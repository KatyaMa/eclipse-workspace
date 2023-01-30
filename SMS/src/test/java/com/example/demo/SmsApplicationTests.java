package com.example.demo;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;

import jpa.entitymodels.Student;
import jpa.service.StudentService;

@SpringBootTest
class SmsApplicationTests {

    private StudentService studentService = new StudentService();
    List<Student> test1 = studentService.getStudentByEmail("aiannitti7@is.gd");
    Student test2 = new Student("aiannitti7@is.gd","Alexandra Iannitti","TWP4hf5j",null);

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Before Class");
    }

    @Before
    public void before() {
        System.out.println("Before Test Case");
    }

    @Test
    @Order(1)
    public void isEqualName() {

        System.out.println("Test first name");
        assertEquals(test1.get(0).getsName(),test2.getsName());
    }

    @Test
    @Order(2)
    public void isEqualPass() {

        System.out.println("Test password");
        assertEquals(test1.get(0).getStudentPassword(),test2.getStudentPassword());

    }

    @Test
    @Order(3)
    public void isEqualEmail() {

        System.out.println("Test Email");
        assertEquals(test1.get(0).getStudentEmail(),test2.getStudentEmail());
    }

    @After
    public void after() {
        System.out.println("After Test Case");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("After Class");
    }

}
