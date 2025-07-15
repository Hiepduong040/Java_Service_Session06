// StudentService.java
package com.data.javaservice_session06.service;

import com.data.javaservice_session06.model.entity.Students;

import java.util.List;

public interface StudentService {
    List<Students> getStudents();
    Students getStudentById(Integer id);
    Students insertStudent(Students student);
    Students updateStudent(Students student, Integer id);
    boolean deleteStudent(Integer id);
    List<Students> getStudentsByFullName(String name);
    List<Students> getStudentsByAddress(String address);
    List<Students> getStudentsByClassName(String className);
}