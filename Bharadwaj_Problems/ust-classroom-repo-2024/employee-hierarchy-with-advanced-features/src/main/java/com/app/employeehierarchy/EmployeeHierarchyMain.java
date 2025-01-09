package com.app.employeehierarchy;

import com.app.employeehierarchy.Employee.Employee;
import com.app.employeehierarchy.service.EmployeeHierarchyService;

import java.util.List;

public class EmployeeHierarchyMain {

    public static void main(String[] args) {

        EmployeeHierarchyService service = new EmployeeHierarchyService();

        // Todo: Add employees to the system.
        service.addEmployee(new Employee(1, "John Doe", "Manager", 60000.0));
        service.addEmployee(new Employee(2, "Jane Smith", "Developer", 50000.0));
        service.addEmployee(new Employee(3, "Jack", "Regular Employee", 50000.0));

        // Todo: Retrieve and display employee information.
        Employee retrievedEmployee = service.getEmployeeById(1);
        System.out.println("Retrieved Employee: " + retrievedEmployee);

        // Todo: Calculate and display total salary expenditure.
        double totalSalaryExpenditure = service.calculateTotalSalaryExpenditure();
        System.out.println("Total Salary Expenditure: $" + totalSalaryExpenditure);

        // Todo: Perform additional operations as needed.

        //Todo: Names of all employees
        List<String> list1 = service.getAllEmployeeNames();
        System.out.println("Names of the empoyees are: " + list1);

        //Todo: Names of all employees along with salaries
        List<List<String>> list = service.getAllEmployeeNamesWithSalaries();
        System.out.println("All Employee names along with their salaries are: " + list);

        // Todo: Do increments.... Manager - 15%, Developer - 10%, Regular Employee - 5%
        List<Employee> incrememts = service.incrementSalaries();
        System.out.println("Employees after increments: " + incrememts);
    }
}
