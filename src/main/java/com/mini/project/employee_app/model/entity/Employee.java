package com.mini.project.employee_app.model.entity;

import com.mini.project.employee_app.model.enums.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "employees")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_no", length = 11)
    private int no;

    @Column(name = "birth_date")
    private Date birthDate;

    @Column(name = "first_name", length = 14)
    private String firstName;

    @Column(name = "last_name", length = 16)
    private String lastName;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "hire_date")
    private Date hireDate;
}
