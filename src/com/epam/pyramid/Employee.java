package com.epam.pyramid;

import java.util.*;

public class Employee {
    static long counterId;
    private long id;
    private long parentId;
    private String name;
    private Set<Employee> children = new HashSet<>();
    public static Map<Long, Employee> allEmployees = new HashMap<>();




    public static Employee createEmployee(String name) {
        Employee employee = new Employee(name);
        allEmployees.put(employee.getId(), employee);
        return employee;
    }

    public void addChild(Employee ... employees){
        for (Employee employee: employees) {
            employee.setParentId(id);
            children.add(employee);
        }
    }

    public void printParent(long parentId) {
        if (parentId != 0) {
            Employee employee = allEmployees.get(parentId);
            System.out.println(employee);
            printParent(employee.parentId);
        }
    }

    public void printChildren() {
        for (Employee employee : children) {
            System.out.println(employee);
        }
        System.out.println();
        for (Employee employee: children) {
            employee.printChildren();
        }
    }

    public static Employee getEmployee(long id) {
        return allEmployees.get(id);
    }

    public Employee(String name) {
        this();
        this.name = name;
    }

    public Employee() {
        id = ++counterId;
    }

    public static long getCounterId() {
        return counterId;
    }

    public static void setCounterId(long counterId) {
        Employee.counterId = counterId;
    }

    public long getId() {
        return id;
    }

    public long getParentId() {
        return parentId;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", parentId=" + parentId +
                ", name='" + name + '\'' +
                '}';
    }
}
