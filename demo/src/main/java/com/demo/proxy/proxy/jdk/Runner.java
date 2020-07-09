package com.demo.proxy.proxy.jdk;

import com.demo.proxy.beans.Person;
import com.demo.proxy.repo.PersonDao;
import com.demo.proxy.repo.PersonDaoImpl;

import java.lang.reflect.Proxy;

public class Runner {
    public static void main(String[] args) {
        PersonDao personDao = (PersonDao) Proxy.newProxyInstance(
                PersonDao.class.getClassLoader(), PersonDaoImpl.class.getInterfaces(),
                new PersonDaoInvocationHandler(
                        new PersonDaoImpl()
                )
        );

        Person person = personDao.findById(5);
        personDao.save(person);
    }
}
