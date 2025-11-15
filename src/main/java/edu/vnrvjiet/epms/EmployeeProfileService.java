package edu.vnrvjiet.epms;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeProfileService {

    private final EmployeeProfileRepository employeeProfileRepository;

    public EmployeeProfileService(EmployeeProfileRepository employeeProfileRepository) {
        this.employeeProfileRepository = employeeProfileRepository;
    }

    public EmployeeProfile save(EmployeeProfile employeeProfile) {
        return employeeProfileRepository.save(employeeProfile);
    }

    public Optional<EmployeeProfile> findById(Integer id) {
        return employeeProfileRepository.findById(id);
    }

    public List<EmployeeProfile> findAll() {
        return employeeProfileRepository.findAll();
    }

    public void deleteById(Integer id) {
        employeeProfileRepository.deleteById(id);
    }
}
