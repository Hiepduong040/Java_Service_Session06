// ClassController.java
package com.data.javaservice_session06.controller;

import com.data.javaservice_session06.model.dto.response.DataResponse;
import com.data.javaservice_session06.model.entity.Classes;
import com.data.javaservice_session06.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/classes")
public class ClassController {

    @Autowired
    private ClassService classService;

    @GetMapping
    public ResponseEntity<DataResponse<List<Classes>>> getAllClasses() {
        return new ResponseEntity<>(new DataResponse<>(classService.getAllClasses(), HttpStatus.OK), HttpStatus.OK);
    }

    @GetMapping("/{classId}")
    public ResponseEntity<DataResponse<Classes>> getClassById(@PathVariable Integer classId) {
        return new ResponseEntity<>(new DataResponse<>(classService.getClassById(classId), HttpStatus.OK), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DataResponse<Classes>> createClass(@RequestBody Classes classes) {
        return new ResponseEntity<>(new DataResponse<>(classService.createClass(classes), HttpStatus.CREATED), HttpStatus.CREATED);
    }

    @PutMapping("/{classId}")
    public ResponseEntity<DataResponse<Classes>> updateClass(@RequestBody Classes classes, @PathVariable Integer classId) {
        return new ResponseEntity<>(new DataResponse<>(classService.updateClass(classes, classId), HttpStatus.OK), HttpStatus.OK);
    }

    @DeleteMapping("/{classId}")
    public ResponseEntity<DataResponse<Boolean>> deleteClass(@PathVariable Integer classId) {
        return new ResponseEntity<>(new DataResponse<>(classService.deleteClass(classId), HttpStatus.NO_CONTENT), HttpStatus.NO_CONTENT);
    }
}