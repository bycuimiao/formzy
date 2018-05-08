/*
 * Created by cuimiao on 2018/5/8.
 */

package com.cuimiao.demo.controller;

import com.cuimiao.demo.bean.Message;
import com.cuimiao.demo.bean.Student;
import com.cuimiao.demo.repository.MessageRepository;
import com.cuimiao.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * @author cuimiao
 * @version 0.0.1
 * @Description: 给那个臭不要脸的master写的事务控制demo.
 * 去掉@Transactional，则没有事务了。亲测ok.
 * @since 0.0.1 2018-05-08
 */
@RestController
@Transactional
public class TransactionController {

  @Autowired
  private MessageRepository messageRepository;

  @Autowired
  private StudentRepository studentRepository;

  @RequestMapping(value="/master" , method = RequestMethod.GET)
  public Message addMsg(){
    Message message = new Message();
    message.setCreateTime(LocalDateTime.now());
    message.setContext("马致远事务控制demo");
    Message msg = messageRepository.save(message);
    //抛出异常
    int a = 1/0;
    Student student = new Student();
    student.setName("马致远");
    studentRepository.save(student);
    return msg;
  }
}