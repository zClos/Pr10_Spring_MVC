package com.pvt.service;

import com.pvt.dao.DepartmentDao;
import com.pvt.domain.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DepartmentService {

    @Autowired
    private DepartmentDao departmentDao;


    public Department save(Department department) {
        return departmentDao.save(department);
    }

    public Department findById(Integer id) {
        Optional<Department> department = departmentDao.findById(id);
        return department.orElse(null);
    }

    public Department getByName(String name) {
        return departmentDao.getByName(name);
    }

    public List<Department> findAll() {
        List<Department> list = new LinkedList<>();
        Optional.of(departmentDao.findAll()).ifPresent(departments -> {
            departments.forEach(list::add);
        });
        return list;
    }

    public void deleteById(Integer id) {
        departmentDao.deleteById(id);
    }

    public void delete(Department department) {
        departmentDao.delete(department);
    }

}
