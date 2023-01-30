package jpa.dao;

import jpa.entitymodels.Course;
import jpa.entitymodels.Student;

import java.util.List;

public interface StudentDAO {
    List<Student> getAllStudents();
    List<Student> getStudentByEmail(String email);
    Boolean validateStudent();
    void registerStudentToCourse(String email, Course newCourse);
    List<Course> getStudentCourses(String email);
}
