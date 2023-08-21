package com.example.criteriaquery.dao;

import com.example.criteriaquery.config.HibernateConfiguration;
import com.example.criteriaquery.entity.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDao {

    public void createEmployee(Employee employee) {

        Transaction transaction = null;
        try (Session session = HibernateConfiguration.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(employee);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    // criteria queries implementation
    public List<Employee> findAllEmployeeByCriteriaQuery() {
        try {
            return HibernateConfiguration.getSessionFactory().openSession().createCriteria(Employee.class).list();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Employee> getEmpSalaryIsGreaterThan5000() {
        try {
            return HibernateConfiguration.getSessionFactory().openSession().createCriteria(Employee.class)
                    .add(Restrictions.gt("salary", 7000)).list();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public List<Employee> getEmpSalaryLessThan20000() {
        try {
            return HibernateConfiguration.getSessionFactory().openSession().createCriteria(Employee.class).add(Restrictions.lt("salary", 20000)).list()
                    ;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public List<Employee> getEmpSalaryGreaterThanOrEqual8000() {
        try {
            return HibernateConfiguration.getSessionFactory().openSession().createCriteria(Employee.class).
                    add(Restrictions.ge("salary", 8000)).list()
                    ;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public List<Employee> findEmployeeNameStartsWith() {
        try {
            return HibernateConfiguration.getSessionFactory().openSession().createCriteria(Employee.class)
                    .add(Restrictions.ilike("name", "Ana%")).list();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
    /*insert into employees(name,salary) values
( "Anuj"    , 10000),
        ( "Yusuf"   , 20000),
        ( "Siddhesh", 30000),
        ( "Sameer"  , 40000),
        ( "Lokesh"  , 50000),
        ( "Shubham" , 5000),
        ( "Sai"     , 6000),
        ( "Amar"    , 7000),
        ( "Nikhil"  , 7500),
        ( "Anchal"  , 6500),
        ( "Kajal"   , 5500);*/