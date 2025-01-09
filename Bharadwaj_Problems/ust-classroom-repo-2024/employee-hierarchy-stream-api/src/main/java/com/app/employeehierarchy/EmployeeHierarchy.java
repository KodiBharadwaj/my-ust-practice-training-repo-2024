package com.app.employeehierarchy;


import com.app.employeehierarchy.model.Developer;
import com.app.employeehierarchy.model.Employee;
import com.app.employeehierarchy.model.Manager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class EmployeeHierarchy {

    // DONE: Use Stream API to find the employee with the highest salary
    public static Employee findHighestPaidEmployee(List<Employee> employees) {
        //return employees.stream().max((e1,e2)->Double.compare(e1.getSalary(),e2.getSalary())).get();
        return employees.stream().reduce((acc,i)->{
            if(i.getSalary() > acc.getSalary()){
                acc = i;
            }
            return acc;
        }).get();
    }


    // TODO: Use Stream API to count the number of developers in the collection
    public static long countDevelopers(List<Employee> employees) {
        return employees.stream().filter(i->i.getClass().toString().contains("Developer")).count();

    }    //return employees.stream().filter(i-> instance of Developer).count();

    // TODO: Use Stream API to calculate the average salary of all employees
    public static double calculateAverageSalary(List<Employee> employees) {
        return (double) (employees.stream().map(i->i.getSalary()).reduce((acc,i)->acc+i).get())/employees.size();
        //return employees.stream().mapToDouble(e->e.getSalary()).average().orElse(0);
    }


    public static void main(String[] args) {
        // Create a collection to store employees
        List<Employee> employeeList = new ArrayList<>();

        // TODO: Add sample Manager and Developer instances to the collection
        employeeList.add(new Manager(1, "John", 100000, 10));
        employeeList.add(new Developer(2, "Alice", 80000, "Java"));

        // TODO: Print the initial list of employees
        employeeList.forEach(i-> System.out.println(i));

        // TODO: Use Stream API to filter employees based on salary range and display the results
        employeeList.stream().sorted((a,b)->Double.compare(b.getSalary(),a.getSalary())).forEach(i-> System.out.println(i));

        // TODO: Use Stream API to calculate the total salary of all employees
        String str = employeeList.stream().map(i->i.getSalary()).reduce((a,b)->a+b).toString();
        System.out.println(str);
        // TODO: Allow user input to add new employees to the collection

        System.out.println("""
                Select one of the below:
                1.Manager
                2.Developer
                """);
        Scanner scanner = new Scanner(System.in);
        int value = scanner.nextInt();
        if(value == 1){
            System.out.println("Enter the employee id: ");
            int id = scanner.nextInt();
            System.out.print("Enter the employee name: ");
            Scanner s = new Scanner(System.in);
            String name = s.nextLine();
            System.out.println("Enter the employee salary: ");
            Double salary = scanner.nextDouble();
            System.out.println("Enter the team size: ");
            int size = scanner.nextInt();

            employeeList.add(new Manager(id, name, salary, size));

        }
        else if(value == 2){
            System.out.println("Enter the employee id: ");
            int id = scanner.nextInt();
            System.out.println("Enter the employee name: ");
            Scanner s = new Scanner(System.in);
            String name = s.nextLine();
            System.out.println("Enter the employee salary: ");
            Double salary = scanner.nextDouble();
            System.out.println("Enter the team size: ");
            String programmingLanguage = scanner.nextLine();

            employeeList.add(new Developer(id, name, salary, programmingLanguage));
        }


        System.out.println("Updated list is: ");
        employeeList.forEach(i-> System.out.println(i));

        // TODO: Implement a user interface to interact with the program

    }
}
