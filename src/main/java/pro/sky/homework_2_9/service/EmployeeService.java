// Homework 2.9
// @ Aleksandar Zubanov
// 2022/09

package pro.sky.homework_2_9.service;

import org.springframework.stereotype.Service;
import pro.sky.homework_2_9.exception.EmployeeAlreadyAddedException;
import pro.sky.homework_2_9.exception.EmployeeNotFoundException;
import pro.sky.homework_2_9.exception.EmployeeStorageIsFullException;
import pro.sky.homework_2_9.model.Employee;

import java.util.*;

@Service
public class EmployeeService {

    private static final int LIMIT = 10;

    private final Map<String, Employee> employees = new HashMap<>();

    private String getKey(String name, String surname) {
        return name + " | " + surname;
    }


    public Employee addEmployee(String name, String surname, int department, double salary) {
        Employee employee = new Employee(name, surname, department, salary);
        String key = getKey(name, surname);
        if (employees.containsKey(key)) {
            throw new EmployeeAlreadyAddedException("Такой сотрудник уже имеется!");
        }
        if (employees.size() < LIMIT) {
            employees.put(key, employee);
            return employee;
        }
        throw new EmployeeStorageIsFullException(" Список сотрудников переполнен! ");
    }

    public Employee removeEmployee(String name, String surname) {
        String key = getKey(name, surname);
        if (!employees.containsKey(key)) {
            throw new EmployeeNotFoundException(" Сотрудник не найден! ");
        }
        return employees.remove(key);
    }

    public Employee findEmployee(String name, String surname) {
        String key = getKey(name, surname);
        if (!employees.containsKey(key)) {
            throw new EmployeeNotFoundException(" Сотрудник не найден! ");
        }
        return employees.get(key);
    }

    public List<Employee> getAll() {
        return new ArrayList<>(employees.values());
    }
}
