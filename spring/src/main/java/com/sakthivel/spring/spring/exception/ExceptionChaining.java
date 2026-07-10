package com.sakthivel.spring.spring.exception;

public class ExceptionChaining {

    static class DatabaseException extends RuntimeException {
        public DatabaseException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    static class ServiceException extends RuntimeException {
        public ServiceException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    static class Repository {
        public void save() {
            // simulating a database failure
            throw new DatabaseException("Connection refused on port 5432", 
                new RuntimeException("Socket timeout after 30s"));
        }
    }

    static class Service {
        Repository repo = new Repository();

        public void processPayment() {
            try {
                repo.save();
            } catch (DatabaseException e) {
                throw new ServiceException("Payment processing failed", e);
            }
        }
    }

    public static void main(String[] args) {
        Service service = new Service();
        service.processPayment();
    }
}