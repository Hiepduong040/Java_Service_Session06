// ClassService.java
package com.data.javaservice_session06.service;

import com.data.javaservice_session06.model.entity.Classes;

import java.util.List;

public interface ClassService {
    List<Classes> getAllClasses();
    Classes getClassById(Integer id);
    Classes createClass(Classes classes);
    Classes updateClass(Classes classes, Integer id);
    boolean deleteClass(Integer id);
}