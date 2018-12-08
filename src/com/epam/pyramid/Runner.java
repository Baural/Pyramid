package com.epam.pyramid;

public class Runner {
    public static void main(String[] args) {
        Employee employee1 = Employee.createEmployee("Manager #1");
        Employee employee2 = Employee.createEmployee("Manager #2");
        Employee employee3 = Employee.createEmployee("Manager #3");
        Employee employee4 = Employee.createEmployee("Manager #4");
        Employee employee5 = Employee.createEmployee("Manager #5");
        Employee employee6 = Employee.createEmployee("Manager #6");
        Employee employee7 = Employee.createEmployee("Manager #7");
        Employee employee8 = Employee.createEmployee("Manager #8");
        Employee employee9 = Employee.createEmployee("Manager #9");
        Employee employee10 = Employee.createEmployee("Manager #10");

        employee1.addChild(employee2, employee3);
        employee2.addChild(employee4);
        employee3.addChild(employee5, employee6, employee7);
        employee6.addChild(employee8);
        employee8.addChild(employee9, employee10);

        employee7.printParent(7);
        System.out.println();
        employee3.printChildren();
    }
}
