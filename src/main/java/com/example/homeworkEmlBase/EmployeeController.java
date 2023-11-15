package com.example.homeworkEmlBase;

import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {

    private final EmployeeServ employeeServ;

    public EmployeeController(EmployeeServ employeeServ) {
        this.employeeServ = employeeServ;
    }

    @RequestMapping(value = "/employee/add", method = RequestMethod.GET)
    public String addEmlpoyee(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName){
        if ((firstName != null && !firstName.isEmpty()) && (lastName != null && !lastName.isEmpty())){
            employeeServ.addEmployee(firstName, lastName);
        } else {
            employeeServ.error();
        }
        return "Successful added - " + firstName + " " + lastName;
    }

    @RequestMapping(value = "/employee/remove", method = RequestMethod.GET)
    public String removeEmlpoyee(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName){
        if ((firstName != null && !firstName.isEmpty()) && (lastName != null && !lastName.isEmpty())){
            employeeServ.removeEmployee(firstName, lastName);
        } else {
            employeeServ.error();
        }
        return "Successful removed - " + firstName + " " + lastName;
    }

    @RequestMapping(value = "/employee/find", method = RequestMethod.GET)
    public String findEmlpoyee(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName){
        if ((firstName != null && !firstName.isEmpty()) && (lastName != null && !lastName.isEmpty())){
            employeeServ.findEmployee(firstName, lastName);
        } else {
            employeeServ.error();
        }
        return "Successful found - " + firstName + " " + lastName;
    }

    @RequestMapping(value = "/employee/all", method = RequestMethod.GET)
    public String allEmlpoyee(){
        return employeeServ.toString();
    }

}
