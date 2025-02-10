package com.mini.project.employee_app.model.entity;

import com.mini.project.employee_app.model.enums.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_no", length = 11)
    private int empNo;

    @Column(name = "birth_date")
    private Date birthDate;

    @Column(name = "first_name", length = 14)
    private String firstName;

    @Column(name = "last_name", length = 16)
    private String lastName;

    private Gender gender;

    @Column(name = "hire_date")
    private Date hireDate;
}
