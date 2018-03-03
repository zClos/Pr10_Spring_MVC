package com.pvt.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "department")
public class Department {

    private Integer id;
    private String name;
    private List<Employee> employees;

    public Department() {
        employees = new ArrayList<>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "department", cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH}, orphanRemoval = true)
    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", employees=" + employees +
                '}';
    }
}
