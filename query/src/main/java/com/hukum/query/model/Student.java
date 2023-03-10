package com.hukum.query.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.Date;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
@Table(name = "Student_tbl")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Long studentId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "age")
    private Integer age;

    @Column(name = "is_active")
    private Boolean active;

    @Column(name = "admission_date")

    private LocalDate admissionDate;


}
