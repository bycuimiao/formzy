/*
 * Created by cuimiao on 2018/5/7.
 */

package com.cuimiao.demo.controller;

import com.cuimiao.demo.bean.Message;
import com.cuimiao.demo.bean.Student;
import com.cuimiao.demo.repository.MessageRepository;
import com.cuimiao.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.servlet.http.HttpServletRequest;

/**
 * @author cuimiao
 * @version 0.0.1
 * @Description:
 * @since 0.0.1 2018-05-07
 */
@RestController
public class MessageController {

  @Autowired
  private MessageRepository messageRepository;

  @RequestMapping(value="/msg" , method = RequestMethod.POST)
  public Message addMsg(@RequestBody Message message){
    message.setCreateTime(LocalDateTime.now());
    message.setIpaddr(getClientIp());
    Message msg = messageRepository.save(message);
    return msg;
  }

 private static  HttpServletRequest request;

  @Autowired
  public void setRequest(HttpServletRequest request) {
    this.request = request;
  }

  private static String getClientIp() {

    String remoteAddr = "";

    if (request != null) {
      remoteAddr = request.getHeader("X-FORWARDED-FOR");
      if (remoteAddr == null || "".equals(remoteAddr)) {
        remoteAddr = request.getRemoteAddr();
      }
    }

    return remoteAddr;
  }
}