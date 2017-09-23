package com.your.name.Service;

import com.your.name.Dao.StudentDao;
import com.your.name.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by jdzfjfhnui on 2017-9-23.
 */
@Service
public class StudentService {

    @Autowired
    @Qualifier("mysql_dao") /*在实现接口上指定*/
    private StudentDao studentDao;

    public Collection<Student> getAllStudents(){
        return this.studentDao.getAllStudents();
    }
    public  Student getStudentById(int id){
        return this.studentDao.getStudentById(id);
    }

    public  void deleteStudentById(int id){
        this.studentDao.deleteStudentById(id);
    }

    public void updateStudent(Student student){
        this.studentDao.updateStudent(student);
    }

    public void insertStudent(Student student) {
        this.studentDao.insertStudent(student);
    }
}
