package com.swaroop.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swaroop.springboot.entity.Student;
import com.swaroop.springboot.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

   @Autowired
   private StudentRepository studentRepository;

   @Override
   public Student saveStudent(Student student) {
       return studentRepository.save(student);
   }

   @Override
   public Student updateStudent(Student student) {
       return studentRepository.save(student);
   }

   @Override
   public void deleteStudent(Student student) {
       studentRepository.delete(student);
   }

   @Override
   public Student findByRollno(long rollno) { // ✅ Fixed method name
       Optional<Student> student = studentRepository.findById(rollno);
       return student.orElse(null); // ✅ Prevents NoSuchElementException
   }

   @Override
   public List<Student> findAll() {
       return studentRepository.findAll();
   }
}
