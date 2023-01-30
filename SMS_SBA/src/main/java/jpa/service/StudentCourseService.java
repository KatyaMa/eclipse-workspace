package jpa.service;

import com.google.gson.Gson;
import jpa.entitymodels.Course;
//import jpa.entitymodels.StudentCourses;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentCourseService {
    private static final String URL = "jdbc:mysql://localhost:3306/SMS";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Kotena84";

//    public List<StudentCourses> getCoursesByStudent(String email) {
//        // Use the "CoursesByStudent" NamedQuery to retrieve courses by email
//        return null;
//    }

    public void addCourseToStudent(String email, int courseId) {
        // Create a new StudentCourses entity with the provided email and courseId and persist it to the database
    }

    public void removeCourseFromStudent(String email, int courseId) {
        // Delete the StudentCourses entity with the provided email and courseId from the database
    }

    public List<Course> getAllStudentCourses(String email) {
        List<Course> courses = new ArrayList<>();
        Gson gson = new Gson();

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement statement = connection.prepareStatement("SELECT courses FROM Student WHERE email = ?")) {
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String json = resultSet.getString("courses");
                Type listType = new TypeToken<List<Course>>(){}.getType();
                List<Course> list = json == null ? new ArrayList<>() : gson.fromJson(json, listType);
                courses.addAll(list);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courses;
    }

}

