package com.pvt.controller;

import com.pvt.domain.Employee;
import com.pvt.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public String getAllEmployees(ModelMap map) {
        List<Employee> departmentList = employeeService.findAll();
        return "employees";
    }

    @PostMapping
    public String saveEmployee(@RequestBody Employee employee) {
        employeeService.save(employee);
        return "redirect:/" + Optional.of(employee.getId());
    }

    @GetMapping("/{id}")
    public String getEmployeesByFirstName(@PathVariable("id") Integer id, ModelMap map) {
        Employee employees = employeeService.findById(id);
        return "employees";
    }

}
