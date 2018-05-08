/*
 * Created by cuimiao on 2018/5/7.
 */

package com.cuimiao.demo.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cuimiao
 * @version 0.0.1
 * @Description:
 * @since 0.0.1 2018-05-07
 */
@RestController
public class HelloApi {
  @RequestMapping("/hello")
  public String hello() {
    return "Hello World";
  }

  @RequestMapping("/index")
  public String index() {
    return "/index";
  }
}