package com.springboot.poc.controller;

import com.springboot.poc.model.Employee;
import com.springboot.poc.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    @RequestMapping("/employees")
    public List<Employee> getEmployees(){
        return employeeService.getAllEmployees();
    }

    @RequestMapping("/employee/{id}")
    public Optional<Employee> getEmployee(@PathVariable String id){
        return employeeService.getEmployee(id);
    }

    @RequestMapping(method = RequestMethod.POST,value = "/employee")
    public void addEmployee(@RequestBody Employee newEmployee){
        String employeeId = String.valueOf(new Random().nextInt(10000));
        Employee emp = new Employee(employeeId, newEmployee.getFirstName(), newEmployee.getLastName(), newEmployee.getEmail());
        employeeService.addEmployee(emp);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/employee/{id}")
    public Optional<Employee> updateEmployee(@RequestBody Employee employee, @PathVariable String id){
        return employeeService.updateEmployee(id, employee);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/employee/{id}")
    public String deleteEmployee(@PathVariable String id){
        return employeeService.deleteEmployee(id);
    }


}
