package com.mci.learning.controller;

import com.mci.learning.model.StudentDto;
import com.mci.learning.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RestController {
    private final StudentService studentService;

    //    @Autowired
    public RestController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/student")
    public ResponseEntity<List<StudentDto>> getAll() {
        return ResponseEntity.ok(studentService.getAll());
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<StudentDto> getStudent(@PathVariable int id) {
        return ResponseEntity.ok(studentService.getById(id));
    }

    @PostMapping("/student/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<StudentDto> createStudent(@RequestBody StudentDto studentDto) {
        return ResponseEntity.ok(studentService.create(studentDto));
    }

    @PutMapping("/student/update/{id}")
    public ResponseEntity<StudentDto> updateStudent(@RequestBody StudentDto studentDto, @PathVariable("id") int id) {
        return ResponseEntity.ok(studentService.update(studentDto, id));
    }

    @DeleteMapping("/student/delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable int id) {
        studentService.delete(id);
        return ResponseEntity.ok("Deleted");
    }
}
