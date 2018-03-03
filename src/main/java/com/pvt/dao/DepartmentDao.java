package com.pvt.dao;

import com.pvt.domain.Department;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentDao extends CrudRepository<Department, Integer> {

    Department getById(Integer id);
    Department getByName(String name);
}
