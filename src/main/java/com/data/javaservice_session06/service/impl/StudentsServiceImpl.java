// StudentServiceImpl.java
package com.data.javaservice_session06.service.impl;

import com.data.javaservice_session06.model.entity.Students;
import com.data.javaservice_session06.repository.StudentRepository;
import com.data.javaservice_session06.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentsServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Students> getStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Students getStudentById(Integer id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
    }

    @Override
    public Students insertStudent(Students student) {
        return studentRepository.save(student);
    }

    @Override
    public Students updateStudent(Students student, Integer id) {
        Students existingStudent = getStudentById(id);
        existingStudent.setFullName(student.getFullName());
        existingStudent.setGender(student.getGender());
        existingStudent.setBirthday(student.getBirthday());
        existingStudent.setAddress(student.getAddress());
        existingStudent.setClasses(student.getClasses());
        return studentRepository.save(existingStudent);
    }

    @Override
    public boolean deleteStudent(Integer id) {
        studentRepository.deleteById(id);
        return true;
    }

    @Override
    public List<Students> getStudentsByFullName(String name) {
        return studentRepository.findByFullNameContainingIgnoreCase(name);
    }

    @Override
    public List<Students> getStudentsByAddress(String address) {
        return studentRepository.findByAddressContainingIgnoreCase(address);
    }

    @Override
    public List<Students> getStudentsByClassName(String className) {
        return studentRepository.findByClassesClassName(className);
    }
}