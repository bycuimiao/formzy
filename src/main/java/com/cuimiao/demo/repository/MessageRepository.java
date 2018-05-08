/*
 * Created by cuimiao on 2018/5/7.
 */

package com.cuimiao.demo.repository;

import com.cuimiao.demo.bean.Message;
import com.cuimiao.demo.bean.Student;
import org.springframework.data.repository.CrudRepository;

/**
 * @author cuimiao
 * @version 0.0.1
 * @Description:
 * @since 0.0.1 2018-05-07
 */
public interface MessageRepository extends CrudRepository<Message, Long> {
  Message save(Message message);
}