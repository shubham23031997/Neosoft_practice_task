package com.neosoft.multithreading_executor_service.service.serviceimpl;

import com.neosoft.multithreading_executor_service.entity.Person;
import com.neosoft.multithreading_executor_service.repo.PersonRepo;
import com.neosoft.multithreading_executor_service.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Random;

@Slf4j
@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepo personRepo;

    // schedule a job to add object in database in every 5 seconds
    @Scheduled(fixedRate = 5000)
    public void add2DBJob() {
        Person person = new Person();
        person.setPersonName("Neosoft" + new Random().nextInt(374483));
        personRepo.save(person);
        System.out.println("added person data in database at :" + new Date().toString());
    }

    // 2nd schedule to fetch data from database in every 15 seconds
    @Scheduled(cron = "0/15 * * * * *")
    public void fetchDBJob() {
        List<Person> personList = personRepo.findAll();
        System.out.println("fetched  object from database at :" + new Date().toString());
        System.out.println("no of records :" + personList.size());
        log.info("personList: {}", personList);

    }
}
