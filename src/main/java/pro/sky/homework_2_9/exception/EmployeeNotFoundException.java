// Homework 2.9
// @ Aleksandar Zubanov
// 2022/09

package pro.sky.homework_2_9.exception;

public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(String message) {
        super(message);
    }
}
