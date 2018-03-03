package com.pvt.service;

import com.pvt.dao.EmployeeDao;
import com.pvt.domain.Department;
import com.pvt.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    public Employee save(Employee employee) {
        return employeeDao.save(employee);
    }

    public Employee findById(Integer id) {
        Optional<Employee> employee = employeeDao.findById(id);
        return employee.orElse(null);
    }

    public List<Employee> getByFirstName(String firstName){
        List<Employee> list = new LinkedList<>();
        Optional.of(employeeDao.getByFirstName(firstName)).ifPresent(list::addAll);
        return list;
    }

    public List<Employee> getByLastName(String lastName) {
        List<Employee> list = new LinkedList<>();
        Optional.of(employeeDao.getByLastName(lastName)).ifPresent(list::addAll);
        return list;
    }

    public List<Employee> getByFirstNameAndLastName(String firstName, String lastName){
        return employeeDao.getByFirstNameAndLastName(firstName, lastName);
    }

    public List<Employee> findAll(){
        List<Employee> list = new LinkedList<>();
        Optional.of(employeeDao.findAll()).ifPresent(departments -> {
            departments.forEach(list::add);
        });
        return list;
    }

    public List<Employee> getByDepartment(Department department) {
        List<Employee> list = new LinkedList<>();
        Optional.of(employeeDao.getByDepartment(department)).ifPresent(list::addAll);
        return list;
    }
}
