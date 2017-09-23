package com.your.name.Dao;

import com.your.name.Entity.Student;

import java.util.Collection;

/**
 * Created by jdzfjfhnui on 2017-9-23.
 */
public interface StudentDao {
    Collection<Student> getAllStudents();

    Student getStudentById(int id);

    void deleteStudentById(int id);

    void updateStudent(Student student);

    void insertStudent(Student student);
}
