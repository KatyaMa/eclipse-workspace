/*
 * Filename: SMSRunner.java
* Author: Stefanski
* 02/25/2020 
 */
package jpa.mainrunner;

import jpa.entitymodels.Course;
import jpa.entitymodels.Student;
import jpa.service.CourseService;
import jpa.service.StudentCourseService;
import jpa.service.StudentService;

import java.time.Period;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.out;

/**1
 * 
 * @author Harry
 *
 */
public class SMSRunner {

	private Scanner sin;
	private StringBuilder sb;

	private CourseService courseService;
	private StudentService studentService;
	private Student currentStudent;

	public SMSRunner() {
		sin = new Scanner(System.in);
		sb = new StringBuilder();
		courseService = new CourseService();
		studentService = new StudentService();
	}


	public static void main(String[] args) {

		SMSRunner sms = new SMSRunner();
		sms.run();
	}

	private void run() {
		// Login or quit
		switch (menu1()) {
		case 1:
			if (studentLogin()) {
				registerMenu();
			}
			break;
		case 2:
			out.println("Goodbye!");
			break;

		default:

		}
	}

	private int menu1() {
		sb.append("\n1. Student Login\n2. Quit Application\n");
		out.print(sb.toString());
		sb.delete(0, sb.length());
		int result = 0;
		while (result<1 || result>2){
			try{
				System.out.print("Please Select 1 or 2: ");
				result = Integer.parseInt(sin.next());
			}catch (Exception e){
				System.out.print("Wrong selection, select 1 or 2: ");
			}
		}
		return result;
	}

	private boolean studentLogin() {
		
		boolean retValue = false;
		String email = null;
		String password = null;

		out.print("Enter your email address: ");
		email = sin.next();
		out.print("Enter your password: ");
		password = sin.next();


		List<Student> students = studentService.getStudentByEmail(email);

		if (students != null) {
			currentStudent = students.get(0);
		}


		out.println("Current student: " + currentStudent.getsName());

		if (currentStudent != null & currentStudent.getStudentPassword().equals(password)) {
			List<Course> courses = studentService.getStudentCourses(email);
			out.println("MyClasses");
			for (Course course : courses) {
				out.print(course.getcId() + " ");
				out.print(course.getcName() + " ");
				out.print(course.getcInstructorName());
				out.println();
			}
			retValue = true;
		} else {
			out.println("User Validation failed. GoodBye!");
		}


		return retValue;
	}

	private void registerMenu() {
		sb.append("\n1. Register a class\n2. Logout\n");
		out.print(sb.toString());
		sb.delete(0, sb.length());

		int result = 0;
		while (result<1 || result>2){
			try {
				System.out.println("Please Sslect 1 or 2: ");
				result = Integer.parseInt(sin.next());
			}catch (Exception e){
				System.out.print("Wrong selection, please select 1 or 2:");
			}
		}

		switch (result) {
		case 1:
			List<Course> allCourses = courseService.getAllCourses();
			List<Course> studentCourses = studentService.getStudentCourses(currentStudent.getStudentEmail());
			allCourses.removeAll(studentCourses);
			out.printf("%5s%15S%15s\n", "ID", "Course", "Instructor");
			for (Course course : allCourses) {
				out.print(course.getcId() + " ");
				out.print(course.getcName() + " ");
				out.print(course.getcInstructorName());
				out.println();
			}
			out.println();
			int number = 0;
			while (number<1 || number>allCourses.size()){
				try {
					out.print("Enter Course Number: ");
					number = Integer.parseInt(sin.next());
				}catch (Exception e){
					out.print("Enter Course Number: ");
				}
			}

			Course newCourse = courseService.GetCourseById(number);

			if (newCourse != null) {
				studentService.registerStudentToCourse(currentStudent.getStudentEmail(), newCourse);
				Student temp = studentService.getStudentByEmail(currentStudent.getStudentEmail()).get(0);
				
				StudentCourseService scService = new StudentCourseService();
				List<Course> sCourses = scService.getAllStudentCourses(temp.getStudentEmail());
				

				out.println("MyClasses");
				for (Course course : sCourses) {
					out.print(course.getcId() + " ");
					out.print(course.getcName() + " ");
					out.print(course.getcInstructorName());
					out.println();
				}
			}
			run();
			break;
		case 2:
		default:
			out.println("Goodbye!");
		}
	}
}
