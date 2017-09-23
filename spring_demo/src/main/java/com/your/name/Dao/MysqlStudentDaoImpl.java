package com.your.name.Dao;

import com.your.name.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

/**
 * Created by jdzfjfhnui on 2017-9-23.
 */
@Repository @Qualifier("mysql_dao") public class MysqlStudentDaoImpl implements StudentDao {

    @Autowired private JdbcTemplate jdbcTemplate;
    private static class StudentRowMapper implements RowMapper<Student> {

        @Override public Student mapRow(ResultSet resultSet, int i) throws SQLException {
            Student student = new Student();
            student.setId(resultSet.getInt("id"));
            student.setName(resultSet.getString("name"));
            student.setCourse(resultSet.getString("course"));
            return student;
        }
    }

    @Override public Collection<Student> getAllStudents() {
        List<Student> studentList =
            jdbcTemplate.query("SELECT id, name, course FROM students", new StudentRowMapper());
        return studentList;
    }

    @Override public Student getStudentById(int id) {
        final String sql = "SELECT id, name, course FROM students WHERE id=?";
        Student student = jdbcTemplate.queryForObject(sql, new StudentRowMapper(), id);
        return student;
    }

    @Override public void deleteStudentById(int id) {

        final String sql = "DELETE FROM students WHERE id=?";
        jdbcTemplate.update(sql, id);
    }

    @Override public void updateStudent(Student student) {
        final String sql = "UPDATE students SET name=?, course=?  WHERE id=?";
        //多个参数用数组
        jdbcTemplate
            .update(sql, new Object[] {student.getName(), student.getCourse(), student.getId()});
    }

    @Override public void insertStudent(Student student) {

        final String sql = "INSERT INTO  students(name, course) VALUES(?,?)";
        jdbcTemplate.update(sql, new Object[] {student.getName(), student.getCourse()});
    }
}
