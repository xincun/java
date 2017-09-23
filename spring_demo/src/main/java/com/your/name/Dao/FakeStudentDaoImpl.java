package com.your.name.Dao;

import com.your.name.Entity.Student;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jdzfjfhnui on 2017-9-23.
 */
@Repository
@Qualifier("fake_dao")
public class FakeStudentDaoImpl implements StudentDao {
    private static Map<Integer,Student> Students;

    static {
        Students = new HashMap<Integer, Student>()
        {
            {
                put(1, new Student(1, "zhang san", "maths"));
                put(2, new Student(2, "li si", "computer science"));
                put(3, new Student(3, "wang er", "computer science"));
            }
        };
    }

    @Override public Collection<Student> getAllStudents(){
        return this.Students.values();
    }

    @Override public  Student getStudentById(int id){
        return this.Students.get(id);
    }

    @Override public  void deleteStudentById(int id){
        this.Students.remove(id);
    }

    @Override public void updateStudent(Student student){
        Student s = Students.get(student.getId());
        s.setCourse(student.getCourse());
        s.setName(student.getName());

        Students.put(student.getId(), s);
    }

    @Override public void insertStudent(Student student) {
        Students.put(student.getId(), student);
    }
}

