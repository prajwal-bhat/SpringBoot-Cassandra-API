package com.springboot.poc.service;

import com.springboot.poc.model.Employee;
import com.springboot.poc.repository.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private IEmployeeRepository employeeRepository;


    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        employeeRepository.findAll().forEach(employees::add);
        return employees;
    }

    public Optional<Employee> getEmployee(String id) {
        return employeeRepository.findById(id);
    }

    public void addEmployee(Employee emp) {
        employeeRepository.save(emp);
    }

    public Optional<Employee> updateEmployee(String id, Employee newEmployee) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if(optionalEmployee.isPresent()){
            Employee emp = optionalEmployee.get();
            emp.setFirstName(newEmployee.getFirstName());
            emp.setLastName(newEmployee.getLastName());
            emp.setEmail(newEmployee.getLastName());
            employeeRepository.save(emp);
        }
        return optionalEmployee;
    }


    public String deleteEmployee(String id) {
        Boolean isEmployeeExists = employeeRepository.existsById(id);
        if(isEmployeeExists) {
            employeeRepository.deleteById(id);
            return "Success";
        }
        else return "Employee Doesn't exists";
    }
}
