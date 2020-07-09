package com.demo.proxy.repo;


import com.demo.proxy.beans.Person;

public interface PersonDao {
    Person findById(int id);

    void save(Person person);
}
