package com.example.homeworkEmlBase;

public class Exception extends RuntimeException{
    public static class EmployeeNotFoundException extends Throwable {
        public EmployeeNotFoundException(String message) {
            super(message);
        }
    }
    public static class EmployeeStorageIsFullException extends Throwable {
        public EmployeeStorageIsFullException(String message) {
            super(message);
        }
    }
    public static class EmployeeAlreadyAddedException extends Throwable {
        public EmployeeAlreadyAddedException(String message) {
            super(message);
        }
    }
}
