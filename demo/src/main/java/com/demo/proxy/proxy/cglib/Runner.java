package com.demo.proxy.proxy.cglib;

import com.demo.proxy.beans.Department;
import com.demo.proxy.repo.DepartmentDao;
import org.springframework.cglib.proxy.Enhancer;

public class Runner {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setCallback(new DepartmentDaoMethodInterceptor());
        enhancer.setSuperclass(DepartmentDao.class);
        DepartmentDao departmentDao = (DepartmentDao) enhancer.create();

        Department department = departmentDao.findById(5);
        departmentDao.save(department);
    }
}
