package com.example.criteriaquery;

import com.example.criteriaquery.dao.StudentDAO;
import com.example.criteriaquery.entity.Student;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class CriteriaQueryApplication {

    public static void main(String[] args) {
//        SpringApplication.run(CriteriaQueryApplication.class, args);
        // Initialize SessionFactory
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

        // Create StudentDAO instance
        StudentDAO studentDAO = new StudentDAO(sessionFactory);

        // Fetch and display students
        List<Student> students = StudentDAO.getStudentsWithCriteria(1, 22);
        for (Student student : students) {
            System.out.println("ID: " + student.getId() + ", Name: " + student.getName());
        }


        // Close SessionFactory when done
        sessionFactory.close();
    }

}
