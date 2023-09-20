package com.mci.learning.repository;

import com.mci.learning.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    ArrayList<Student> findByFirstName(String name);
}
