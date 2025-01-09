package com.example.student.service;

import com.example.student.StudentApplication;
import com.example.student.model.College;
import com.example.student.model.Student;
import com.example.student.repository.CollegeRepository;
import com.example.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollegeService {

       @Autowired
       private CollegeRepository colRepo;

       @Autowired
       private StudentRepository studRepo;

       public College createCollege(College college){
           return colRepo.save(college);
       }

       public Student createStudent(long collegeId,Student student){
           College col = colRepo.findById(collegeId).orElseThrow(()->new RuntimeException("College not found"));
           student.setCollege(col);
           col.getStudents().add(student);
           Student savedStudent = studRepo.save(student);
           colRepo.save(col);
           return savedStudent;
       }

       public List<College> getALLColleges(){
           return colRepo.findAll();
       }

//        public List<Student> getStudentsByCollegeName(String collegeName) {
//            return studRepo.findByCollegeNameOrderByMarksDesc(collegeName);
//        }


}
