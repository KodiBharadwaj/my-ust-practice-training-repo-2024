package com.app.employeehierarchy.service;
import com.app.employeehierarchy.Employee.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeHierarchyService {

    private List<Employee> employees = new ArrayList<>();

    // Todo: Implement a method to add an employee to the system.
    public void addEmployee(Employee employee) {
        // Todo: Add logic to add an employee to the system.
        employees.add(employee);
    }

    // Todo: Implement a method to get an employee by ID.
    public Employee getEmployeeById(int employeeId) {
        // Todo: Add logic to retrieve an employee by ID.
       // return null;  // Placeholder, replace with actual implementation.
        return employees.stream().filter(i->{
            if(i.getId() == employeeId) return true;
            return false;
        }).toList().get(0);
    }

    // Todo: Implement a method to calculate total salary expenditure.
    public double calculateTotalSalaryExpenditure() {
        // Todo: Add logic to calculate the total salary expenditure.
        //return 0.0;  // Placeholder, replace with actual implementation.
        return employees.stream().map(i->i.getSalary()).reduce((acc,i)->acc+i).get();
    }

    // Todo: Implement additional methods for employee management.
    public List<String> getAllEmployeeNames(){
        return employees.stream().map(i->i.getName()).toList();
    }

    public List<List<String>> getAllEmployeeNamesWithSalaries(){
        return employees.stream().map(i->{
            return List.of(i.getName(),String.valueOf(i.getSalary()));
        }).toList();
    }
    
    public List<Employee> incrementSalaries(){
        return employees.stream().map(i->{
            if(i.getPosition() == "Manager") i.setSalary(i.getSalary() + (15*i.getSalary())/100);
            else if(i.getPosition() == "Developer") i.setSalary(i.getSalary() + (10*i.getSalary())/100);
            else i.setSalary(i.getSalary() + (5*i.getSalary())/100);
            return i;
        }).toList();
    }

}
