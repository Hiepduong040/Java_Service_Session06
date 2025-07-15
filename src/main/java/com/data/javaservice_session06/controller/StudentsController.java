// StudentsController.java
package com.data.javaservice_session06.controller;

import com.data.javaservice_session06.model.dto.response.DataResponse;
import com.data.javaservice_session06.model.entity.Students;
import com.data.javaservice_session06.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentsController {

    @Autowired
    private StudentService studentsService;

    @GetMapping
    public ResponseEntity<DataResponse<List<Students>>> getAllStudents() {
        return new ResponseEntity<>(new DataResponse<>(studentsService.getStudents(), HttpStatus.OK), HttpStatus.OK);
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<DataResponse<Students>> getStudentById(@PathVariable Integer studentId) {
        return new ResponseEntity<>(new DataResponse<>(studentsService.getStudentById(studentId), HttpStatus.OK), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DataResponse<Students>> insertStudent(@RequestBody Students student) {
        return new ResponseEntity<>(new DataResponse<>(studentsService.insertStudent(student), HttpStatus.CREATED), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<DataResponse<Students>> updateStudent(@RequestBody Students student) {
        return new ResponseEntity<>(new DataResponse<>(studentsService.updateStudent(student, student.getStudentId()), HttpStatus.OK), HttpStatus.OK);
    }

    @DeleteMapping("/{studentId}")
    public ResponseEntity<DataResponse<Boolean>> deleteStudent(@PathVariable Integer studentId) {
        return new ResponseEntity<>(new DataResponse<>(studentsService.deleteStudent(studentId), HttpStatus.NO_CONTENT), HttpStatus.NO_CONTENT);
    }

    @GetMapping("/search/by-name/{name}")
    public ResponseEntity<DataResponse<List<Students>>> getStudentsByName(@PathVariable String name) {
        return new ResponseEntity<>(new DataResponse<>(studentsService.getStudentsByFullName(name), HttpStatus.OK), HttpStatus.OK);
    }

    @GetMapping("/search/by-address/{address}")
    public ResponseEntity<DataResponse<List<Students>>> getStudentsByAddress(@PathVariable String address) {
        return new ResponseEntity<>(new DataResponse<>(studentsService.getStudentsByAddress(address), HttpStatus.OK), HttpStatus.OK);
    }

    @GetMapping("/search/by-class/{className}")
    public ResponseEntity<DataResponse<List<Students>>> getStudentsByClassName(@PathVariable String className) {
        return new ResponseEntity<>(new DataResponse<>(studentsService.getStudentsByClassName(className), HttpStatus.OK), HttpStatus.OK);
    }
}