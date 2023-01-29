package com.springJPA.JPATutorial.Repository;

import com.springJPA.JPATutorial.Entity.Guardian;
import com.springJPA.JPATutorial.Entity.Student;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        Student student = Student.builder()
                .emailId("Narry123@gmail")
                .firstName("Naresh")
                .lastName("K")
//                .guardianName("KR")
//                .guardianEmail("KR@gmail.com")
//                .guardianMobile("123456789")
                .build();
        studentRepository.save(student);
    }

    @Test
    public void printAllStudent() {
        List<Student> studentList = studentRepository.findAll();
        System.out.println("Student List = "+ studentList);
    }

    @Test
    public void saveStudentWithGuardian() {
        Guardian guardian = Guardian.builder()
                .email("guardianEmail@gmail.com")
                .name("GuardianName")
                .mobile("123123123")
                .build();

        Student student = Student.builder()
                .emailId("Enoch@gmail")
                .firstName("Naresh")
                .lastName("Kumar")
                .guardian(guardian)
                .build();
        studentRepository.save(student);
    }

    @Test
    public void findByFirstName() {
        List<Student> students = studentRepository.findByFirstName("Naresh");
        System.out.println("Find By FirstName Output => "+ students);
    }
    @Test
    public void findByFirstNameContaining() {
        List<Student> students = studentRepository.findByFirstNameContaining("Na");
        System.out.println("Find By FirstName Containing Output => "+ students);
    }

    @Test
    public void findByGuardianName() {
        List<Student> students = studentRepository.findByGuardianName("KR");
        System.out.println("Find By FirstNameContaining Output => "+ students);
    }

    @Test
    public void getStudentByEmailAddress() {
        Student student = studentRepository.getStudentByEmailAddress("Narry123@gmail");
        System.out.println("Find By EmailAddress Output => "+ student);

    }

    @Test
    public void getStudentByEmailAddressNativeQuery() {
        Student student = studentRepository.getStudentByEmailAddressNativeQuery("Narry123@gmail");
        System.out.println("Get Student By EmailAddress NativeQuery output =>" + student);
    }

    @Test
    public void getStudentByEmailAddressNativeQueryParam() {
        Student student = studentRepository.getStudentByEmailAddressNativeQueryParam("Narry123@gmail");
        System.out.println("Get Student By EmailAddress NativeQuery Param output =>" + student);
    }

}