package com.pvt.controller;

import com.pvt.domain.Department;
import com.pvt.domain.Employee;
import com.pvt.service.DepartmentService;
import com.pvt.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public String getAllDepartments(ModelMap map) {
        List<Department> departmentList = departmentService.findAll();
        return "departments";
    }

    @PostMapping
    public String saveDepartment(@RequestBody Department department) {
        departmentService.save(department);
        return "redirect:/" + department.getName();
    }

    @GetMapping("/{name}")
    public String getDepartment(@PathVariable("name") String name, ModelMap map) {
        Department department = departmentService.getByName(name);
        return "department";
    }

    @GetMapping("/{name}/employees")
    public String getDepartmentEmployees(@PathVariable("name") String name, ModelMap map) {
        Department department = departmentService.getByName(name);
        List<Employee> employees = employeeService.getByDepartment(department);
        return "employees";
    }
}
