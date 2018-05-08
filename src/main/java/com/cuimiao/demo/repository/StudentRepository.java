/*
 * Created by cuimiao on 2018/5/7.
 */

package com.cuimiao.demo.repository;

import com.cuimiao.demo.bean.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author cuimiao
 * @version 0.0.1
 * @Description:
 * @since 0.0.1 2018-05-07
 */


@Repository
public interface StudentRepository extends CrudRepository<Student, Long>{
  Student findStudentById(Long id);

  Student save(Student student);
}