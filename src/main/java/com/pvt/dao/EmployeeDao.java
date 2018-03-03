package com.pvt.dao;

import com.pvt.domain.Department;
import com.pvt.domain.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeDao extends CrudRepository<Employee, Integer> {

    List<Employee> getByFirstNameAndLastName(String firstName, String lastName);

    List<Employee> getByFirstName(String firstName);

    List<Employee> getByLastName(String lastName);

    List<Employee> getByDepartment(Department department);

}
