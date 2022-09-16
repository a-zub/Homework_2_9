// Homework 2.9
// @ Aleksandar Zubanov
// 2022/09

package pro.sky.homework_2_9.exception;

public class EmployeeStorageIsFullException extends RuntimeException {
    public EmployeeStorageIsFullException(String message) {
        super(message);
    }
}
