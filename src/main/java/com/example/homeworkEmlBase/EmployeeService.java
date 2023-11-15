package com.example.homeworkEmlBase;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class EmployeeService implements EmployeeServ {
    private static final int MAX_EMPLOYEES = 100;
    private List<Employee> employees;
    public EmployeeService() {
        this.employees = new ArrayList<>();
    }
    @Override
    public void addEmployee(String firstName, String lastName) throws Exception {
        if (employees.size() >= MAX_EMPLOYEES) {
            try {
                throw new Exception.EmployeeStorageIsFullException("Employee storage is full");
            } catch (Exception.EmployeeStorageIsFullException e) {
                throw new RuntimeException(e);
            }
        }
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            try {
                throw new Exception.EmployeeAlreadyAddedException("Employee already added");
            } catch (Exception.EmployeeAlreadyAddedException e) {
                throw new RuntimeException(e);
            }
        }
        employees.add(employee);
    }

    @Override
    public void removeEmployee(String firstName, String lastName) throws Exception {
        Employee employee = new Employee(firstName, lastName);
        if (!employees.contains(employee)) {
            try {
                throw new Exception.EmployeeNotFoundException("Employee not found");
            } catch (Exception.EmployeeNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        employees.remove(employee);
    }

    public void findEmployee(String firstName, String lastName) throws Exception {
        Employee employee = new Employee(firstName, lastName);
        int index = employees.indexOf(employee);
        if (index == -1) {
            try {
                throw new Exception.EmployeeNotFoundException("Employee not found");
            } catch (Exception.EmployeeNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        employees.get(index);
    }

    public String error(){
        return "Ошибка, проверьте наличие параметров";
    }

    @Override
    public String toString() {
        return employees.toString();
    }
}
