package com.wsiiz.repairshop.enterprise.application.employee;

import com.wsiiz.repairshop.enterprise.domain.branch.Branch;
import com.wsiiz.repairshop.enterprise.domain.employee.Employee;
import com.wsiiz.repairshop.enterprise.domain.employee.EmployeeRepository;

import java.util.Set;

public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void assignEmployeeToBranch(Long employeeId, Long branchId) {
        Employee employee = employeeRepository.findById(employeeId);
        Branch branch = branchRepository.findById(branchId);
        employee.setBranch(branch);
        employeeRepository.save(employee);
    }

    public Set<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
}
