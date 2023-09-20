package com.mci.learning.service;

import com.mci.learning.model.Student;
import com.mci.learning.model.StudentDto;

import java.util.ArrayList;
import java.util.List;

public interface StudentService {
    StudentDto getById(int id);

    StudentDto create(StudentDto studentDto);

    StudentDto update(StudentDto studentDto, int id);

    List<StudentDto> getAll();

    ArrayList<Student> findByFirstName(String firstName);

    void delete(int id);
}
