package com.swaroop.springboot.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "STUDENT")  // ✅ Ensure it matches the actual table name
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // ✅ Ensure auto-increment if applicable
    @Column(name = "ROLLNO")  // ✅ Ensure this matches the database column name exactly
    private Long rollno;

    @Column(name = "NAME")  // ✅ Ensure this matches your DB column
    private String name;

    public Long getRollno() {
        return rollno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
