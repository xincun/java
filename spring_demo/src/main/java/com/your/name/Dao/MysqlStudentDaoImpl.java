package com.your.name.Dao;

import com.your.name.Entity.Student;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * Created by jdzfjfhnui on 2017-9-23.
 */
@Repository
@Qualifier("mysql_dao")
public class MysqlStudentDaoImpl implements StudentDao {
    @Override public Collection<Student> getAllStudents() {
        return null;
    }

    @Override public Student getStudentById(int id) {
        return null;
    }

    @Override public void deleteStudentById(int id) {

    }

    @Override public void updateStudent(Student student) {

    }

    @Override public void insertStudent(Student student) {

    }
}
