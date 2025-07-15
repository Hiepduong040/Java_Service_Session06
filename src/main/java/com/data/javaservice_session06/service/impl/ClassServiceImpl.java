// ClassServiceImpl.java
package com.data.javaservice_session06.service.impl;

import com.data.javaservice_session06.model.entity.Classes;
import com.data.javaservice_session06.repository.ClassRepository;
import com.data.javaservice_session06.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassServiceImpl implements ClassService {

    @Autowired
    private ClassRepository classRepository;

    @Override
    public List<Classes> getAllClasses() {
        return classRepository.findAll();
    }

    @Override
    public Classes getClassById(Integer id) {
        return classRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Class not found with id: " + id));
    }

    @Override
    public Classes createClass(Classes classes) {
        return classRepository.save(classes);
    }

    @Override
    public Classes updateClass(Classes classes, Integer id) {
        Classes existingClass = getClassById(id);
        existingClass.setClassName(classes.getClassName());
        existingClass.setStatus(classes.getStatus());
        return classRepository.save(existingClass);
    }

    @Override
    public boolean deleteClass(Integer id) {
        classRepository.deleteById(id);
        return true;
    }
}