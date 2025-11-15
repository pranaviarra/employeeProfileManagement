package edu.vnrvjiet.epms;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class EmployeeProfile {
    @Id
    private Integer employeeId;
    private String employeeName;
    private Double salary;
}
