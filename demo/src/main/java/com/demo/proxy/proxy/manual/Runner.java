package com.demo.proxy.proxy.manual;

import com.demo.proxy.beans.Person;
import com.demo.proxy.repo.PersonDao;
import com.demo.proxy.repo.PersonDaoImpl;
import com.demo.proxy.repo.PersonDaoProxy;

public class Runner {
    public static void main(String[] args) {
//        PersonDao personDao = new PersonDaoImpl();
        PersonDao personDao = new PersonDaoProxy(
                new PersonDaoImpl()
        );

        Person person = personDao.findById(5);
        personDao.save(person);
    }
}
