package com.neosoft.hibernatetemplate.service;

import com.neosoft.hibernatetemplate.model.Person;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class PersonService {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    public Person createPerson(Person person) {
        hibernateTemplate.save(person);
        return person;
    }

    public Person getPersonById(Long PersonId) {
        return hibernateTemplate.get(Person.class, PersonId);
    }


    public Person updatePerson(Person person) {
        log.info("person name {}", person.getEmail());
        try {
            Transaction transaction = hibernateTemplate.getSessionFactory().getCurrentSession().beginTransaction();
            hibernateTemplate.saveOrUpdate(person);
            transaction.commit();
            log.info("person to be save{}", person.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return person;
    }


    public void deletePerson(Long personId) {
        Person person = hibernateTemplate.get(Person.class, personId);
        if (person != null) {
            Transaction transaction = hibernateTemplate.getSessionFactory().getCurrentSession().beginTransaction();
            hibernateTemplate.delete(person);
            transaction.commit();
        }
    }
}
