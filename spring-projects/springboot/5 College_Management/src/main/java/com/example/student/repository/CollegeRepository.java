package com.example.student.repository;

import com.example.student.model.College;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CollegeRepository extends JpaRepository<College,Long> {
}
