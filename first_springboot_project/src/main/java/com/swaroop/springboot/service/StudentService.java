package com.swaroop.springboot.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.swaroop.springboot.entity.Student;

@Service
public interface StudentService {

    public Student saveStudent(Student student);
    public Student updateStudent(Student student);
    public void deleteStudent(Student student);
    public Student findByRollno(long rollno); // ✅ Fixed method name
    public List<Student> findAll();
}
