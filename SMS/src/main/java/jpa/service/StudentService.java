package jpa.service;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import jpa.dao.StudentDAO;
import jpa.entitymodels.Course;
import jpa.entitymodels.Student;

import java.lang.reflect.Type;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class StudentService implements StudentDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/SMS";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Kotena84";

    @Override
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM Student")) {

            while (resultSet.next()) {
                String email = resultSet.getString("email");
                String name = resultSet.getString("name");
                String password = resultSet.getString("password");
                List<Course> list = (List<Course>) resultSet.getObject("courses");

                Student student = new Student(email, name, password, list);
                students.add(student);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return students;
    }

    @Override
    public List<Student> getStudentByEmail(String email) {
        List<Student> students = new ArrayList<>();
        Gson gson = new Gson();

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM Student WHERE email = ?")) {
            statement.setString(1,email);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String password = resultSet.getString("password");
                String json = resultSet.getString("courses");
                Type listType = new TypeToken<List<Course>>(){}.getType();
                List<Course> courses = json == null ? new ArrayList<>() : gson.fromJson(json, listType);

                Student student = new Student(email, name, password, courses);
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;

    }




    @Override
    public Boolean validateStudent() {
        return null;
    }

    @Override
    public void registerStudentToCourse(String email, Course newCourse) {
        Gson gson = new Gson();
        List<Course> existingCourses = getStudentCourses(email);
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            // Retrieve existing list of courses for the student
            PreparedStatement statement = connection.prepareStatement("SELECT courses FROM Student WHERE email = ?");
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            List<Course> courses = new ArrayList<>();
            String json = "";
            if (resultSet.next()) {
                json = resultSet.getString("courses");
                Type listType = new TypeToken<List<Course>>(){}.getType();
                courses = json == null ? new ArrayList<>() : gson.fromJson(json, listType);
            }
            // Add the new course to the existing list of courses
            boolean check = false;
            for(Course x : existingCourses){
                if(x.getcId()==newCourse.getcId()){
                    check = true;
                }
            }
            if(check){
                System.out.println("You already signed for this cours)");
                System.out.println();
            }else {
                courses.add(newCourse);
            }
            // Convert the updated list of courses to a JSON array
            json = gson.toJson(courses);
            // Update the "courses" column for the student
            statement = connection.prepareStatement("UPDATE Student SET Courses = ? WHERE email = ?");
            statement.setObject(1, json);
            statement.setString(2, email);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public List<Course> getStudentCourses(String email) {
        List<Course> courses = new ArrayList<>();
        Gson gson = new Gson();

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement statement = connection.prepareStatement("SELECT courses FROM Student WHERE email = ?")) {
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String json = resultSet.getString("courses");
                Type listType = new TypeToken<List<Course>>(){}.getType();
                List<Course> studentCourses = json == null ? new ArrayList<>() : gson.fromJson(json, listType);
                courses.addAll(studentCourses);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courses;
    }

}
