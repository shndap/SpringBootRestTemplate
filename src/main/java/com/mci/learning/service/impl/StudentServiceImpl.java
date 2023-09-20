package com.mci.learning.service.impl;

import com.mci.learning.model.Student;
import com.mci.learning.model.StudentDto;
import com.mci.learning.repository.StudentRepository;
import com.mci.learning.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public StudentDto getById(int id) {
        Student byId = studentRepository.findById(id).get();
        return byId.toDto();
    }

    @Override
    public StudentDto create(StudentDto studentDto) {
        Student student = studentDto.toEntity();
        return studentRepository.save(student).toDto();
    }

    @Override
    public StudentDto update(StudentDto studentDto, int id) {
        Student student = studentRepository.findById(id).get();
        student.setFirstName(studentDto.getFirstName());
        student.setLastName(studentDto.getLastName());

        return studentRepository.save(student).toDto();
    }

    @Override
    public List<StudentDto> getAll() {
        List<Student> all = studentRepository.findAll();
        return all.stream().map(Student::toDto).collect(Collectors.toList());
    }

    @Override
    public ArrayList<Student> findByFirstName(String firstName) {
        return studentRepository.findByFirstName(firstName);
    }

    @Override
    public void delete(int id) {
        studentRepository.delete(studentRepository.findById(id).get());
    }
}
