package com.hukum.query.service;

import com.hukum.query.dao.IStudentRepository;
import com.hukum.query.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.Date;
import java.time.LocalDate;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    private IStudentRepository repository;

    // get student bt Student id
    public Student getStudent(Long id) {
        return repository.findById(id).orElse(null);
    }

    // add student by passing data of the student
    public Student createStudent(Student student) {
        student.setAdmissionDate(LocalDate.now());
        return repository.save(student);
    }

    public List<Student> getAllStudents(Student student) {
        return repository.findAllStudents();
    }


    //for Active Students
    public List<Student> getActiveStudents() {
        return repository.findByActive();
    }

    //for Inactivate Students
    public List<Student> getInactiveStudents() {
        return repository.findByActiveFalse();
    }

    //for getting student by studentId
    public Student findStudentById(Long studentId) {
        return repository.findStudentById(studentId);

    }

    // for finding the student by student first name
    public List<Student> getStudentsByFirstName(String firstName) {
        return repository.findByFirstName(firstName);
    }

    // For deleting the existing student
    public boolean deleteStudentByStudentId(Long studentId, Student student) {
        Student student1 = repository.findStudentById(studentId);

        if (student1 == null) {
            return false;

        } else {
            repository.deleteStudentById(studentId);
            return true;
        }
    }


    public List<Student> findByAgeBetween(int minAge, int maxAge) {
        return repository.findByAgeBetween(minAge, maxAge);
    }
}