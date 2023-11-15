package com.example.homeworkEmlBase;

public interface EmployeeServ {

    void addEmployee(String firstName, String lastName);

    void removeEmployee(String firstName, String lastName);

    void findEmployee(String firstName, String lastName);

    String error();

    String toString();

}
