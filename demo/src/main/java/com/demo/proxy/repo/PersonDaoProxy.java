package com.demo.proxy.repo;


import com.demo.proxy.beans.Person;
import com.demo.proxy.repo.PersonDao;

public class PersonDaoProxy implements PersonDao {

    private final PersonDao personDao;

    public PersonDaoProxy(PersonDao personDao) {
        this.personDao = personDao;
    }

    @Override
    public Person findById(int id) {
        System.out.println("before findById");
        Person person = personDao.findById(id);
        System.out.println("after findById");
        return person;
    }

    @Override
    public void save(Person person) {
        System.out.println("before save");
        personDao.save(person);
        System.out.println("after save");
    }
}
