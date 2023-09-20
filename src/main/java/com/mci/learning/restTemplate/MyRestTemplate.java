package com.mci.learning.restTemplate;

import com.mci.learning.controller.API;
import com.mci.learning.model.StudentDto;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class MyRestTemplate {
    private final RestTemplate restTemplate;

    public MyRestTemplate(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public StudentDto getStudentById(int id) {
        return restTemplate.getForObject(API.GET.string(id), StudentDto.class);
    }

    public String getAllAsString() {
        return restTemplate.getForObject(API.GET_ALL.string(0), String.class);
    }

    public List<StudentDto> getAllStudents() {
        return restTemplate.getForObject(API.GET_ALL.string(0), List.class);
    }

    public void deleteStudent(int id) {
        restTemplate.delete(API.DELETE.string(id));
    }

    public StudentDto createStudent(StudentDto studentDto) {
        return restTemplate.postForObject(API.CREATE.string(0), studentDto, StudentDto.class);
    }

    public void updateStudent(StudentDto studentDto, int id) {
        restTemplate.put(API.UPDATE.string(id), studentDto);
    }
}
