package com.springJPA.JPATutorial.Repository;

import com.springJPA.JPATutorial.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    public List<Student> findByFirstName(String firstName);

    public List<Student> findByFirstNameContaining(String name);

    public List<Student> findByGuardianName(String name);

    //JPQL
    @Query("select s from Student s where s.emailId = ?1")
    public Student getStudentByEmailAddress(String emailId);

    @Query(
            value = "SELECT * FROM tbl_student s  where s.email_address = ?1",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNativeQuery(String email);

    @Query(
            value = "SELECT * FROM tbl_student s  where s.email_address = :emailId",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNativeQueryParam(@Param("emailId") String emailId);

}
