package com.hukum.query.dao;

import com.hukum.query.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.*;

public interface IStudentRepository extends JpaRepository<Student,Long> {
    @Query("SELECT s FROM Student s")
    List<Student> findAllStudents();

    @Modifying
    @Query("DELETE FROM Student s WHERE s.id = :id")
    void deleteStudentById(@Param("id") Long id);

    @Query("SELECT s FROM Student s WHERE s.firstName = :firstName")
    List<Student> findByFirstName(@Param("firstName") String firstName);
    @Query("SELECT s FROM Student s WHERE s.id = :id")
    Student findStudentById(@Param("id") Long id);

    @Query("SELECT s FROM Student s WHERE s.age BETWEEN :minAge AND :maxAge")
    List<Student> findByAgeBetween(@Param("minAge") Integer age,@Param("maxAge") Integer maxAge);


    @Query("SELECT s FROM Student s WHERE s.active = true")
    List<Student> findByActive();
    @Query("SELECT s FROM Student s WHERE s.active = false")
    List<Student> findByActiveFalse();




}
