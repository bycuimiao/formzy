/*
 * Created by cuimiao on 2018/5/7.
 */

package com.cuimiao.demo.controller;

/**
 * @author cuimiao
 * @version 0.0.1
 * @Description:
 * @since 0.0.1 2018-05-07
 */
import java.util.Map;

import com.cuimiao.demo.bean.Student;
import com.cuimiao.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LoginController {

  @Autowired
  private StudentRepository studentRepository;


  @RequestMapping(value="/student" , method = RequestMethod.GET)
  public Student getStudent(){
    Long id = (long) 1;
    Student stu = studentRepository.findStudentById(id);
    return stu;
  }

  @RequestMapping(value="/student" , method = RequestMethod.POST)
  public Student addStudent(@RequestBody Student student){
    Student stu = studentRepository.save(student);
    return stu;
  }
}