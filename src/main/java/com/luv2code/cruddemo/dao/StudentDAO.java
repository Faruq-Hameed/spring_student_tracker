package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student theStudent);
    Student findById(Integer id);
    List<Student> findAll();
    List<Student> findMany(String fieldName, String fieldValue);
    List<Student> findByLastName(String theLastName);

    void updateAStudent(Integer id
//            , String fieldName, String fieldValue
    );

    void updateLastName();

    void update(Student theStudent);

    void delete(Integer id);

//    void delete(Student theStudent);

}
