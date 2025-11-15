package edu.vnrvjiet.epms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeeProfileManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeProfileManagementApplication.class, args);
        System.out.println("✅ Employee Profile Management Service running on port 8200...");
    }
}
