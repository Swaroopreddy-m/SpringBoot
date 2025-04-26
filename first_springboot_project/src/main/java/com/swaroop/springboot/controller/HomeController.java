package com.swaroop.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.swaroop.springboot.entity.Student;
import com.swaroop.springboot.service.StudentService;

@Controller  // ✅ Use RestController for returning responses or use Controller to give response in other files by forwarding response
public class HomeController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/")
    public String insertStudent(Model model) { //Model model
    	
        Student student = new Student();
        //student.setRollno(1);
        student.setName("Reddy1");

        Student savedStudent = studentService.saveStudent(student);
        
      String info= "Student " + savedStudent.getName() + " with rollno " + savedStudent.getRollno() + " is saved successfully";
       
       model.addAttribute("Student", savedStudent);
       model.addAttribute("info", info);
       
        //return "Student " + savedStudent.getName() + " with rollno " + savedStudent.getRollno() + " is saved successfully";
        
        return "homePage";
    }
}
