package edu.vnrvjiet.epms;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeProfileController {

    private final EmployeeProfileService employeeProfileService;

    public EmployeeProfileController(EmployeeProfileService employeeProfileService) {
        this.employeeProfileService = employeeProfileService;
    }

    @PostMapping
    public ResponseEntity<EmployeeProfile> addEmployee(@RequestBody EmployeeProfile employeeProfile) {
        return ResponseEntity.ok(employeeProfileService.save(employeeProfile));
    }

    @GetMapping
    public ResponseEntity<List<EmployeeProfile>> getAllEmployees() {
        return ResponseEntity.ok(employeeProfileService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeProfile> getEmployeeById(@PathVariable Integer id) {
        return employeeProfileService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeProfile> updateEmployee(@PathVariable Integer id, @RequestBody EmployeeProfile employeeProfile) {
        employeeProfile.setEmployeeId(id);
        return ResponseEntity.ok(employeeProfileService.save(employeeProfile));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Integer id) {
        employeeProfileService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
