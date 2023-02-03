package jpa.service;

import jpa.dao.CourseDAO;
import jpa.entitymodels.Course;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseService implements CourseDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/SMS";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Kotena84";

    public List<Course> getAllCourses() {
        List<Course> courses = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM Course")) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String description = resultSet.getString("instructor");

                Course course = new Course(id, name, description);
                courses.add(course);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return courses;
    }

    @Override
    public Course GetCourseById(int cId) {
        Course course = null;

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM Course WHERE id = ?")) {

            statement.setInt(1, cId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String cName = resultSet.getString("name");
                String cInstructorName = resultSet.getString("instructor");

                course = new Course(id, cName, cInstructorName);
            }

        } catch (SQLException e) {
            // provide proper logging or handling for SQLException
            e.printStackTrace();
        }

        return course;
    }


}
