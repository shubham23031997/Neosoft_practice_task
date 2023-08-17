package com.example.criteriaquery.dao;

import com.example.criteriaquery.entity.Student;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.Collections;
import java.util.List;

public class StudentDAO {

    private static SessionFactory sessionFactory = null;

    public StudentDAO(SessionFactory sessionFactory) {
        StudentDAO.sessionFactory = sessionFactory;
    }

    public static List<Student> getStudentsWithCriteria(int minAge, int maxGrade) {
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Student> criteriaQuery = criteriaBuilder.createQuery(Student.class);
            Root<Student> root = criteriaQuery.from(Student.class);

            // Adding criteria
            criteriaQuery.select(root)
                    .where(
                            criteriaBuilder.and(
                                    criteriaBuilder.ge(root.get("age"), minAge),
                                    criteriaBuilder.le(root.get("grade"), maxGrade)
                            )
                    );

            Query<Student> query = session.createQuery(criteriaQuery);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}


