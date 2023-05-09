package com.wsiiz.repairshop.enterprise.application.branch;

import com.wsiiz.repairshop.enterprise.domain.branch.Branch;
import com.wsiiz.repairshop.enterprise.domain.branch.BranchRepository;
import com.wsiiz.repairshop.enterprise.domain.employee.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/branches")
public class BranchController {

    @Autowired
    private BranchRepository branchRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/{id}")
    public Branch getBranchById(@PathVariable Long id) {
        return branchRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Branch createBranch(@RequestBody Branch branch) {
        return branchRepository.save(branch);
    }

    @PutMapping("/{id}")
    public Branch updateBranch(@PathVariable Long id, @RequestBody Branch branch) {
        Branch existingBranch = branchRepository.findById(id).orElse(null);
        if (existingBranch != null) {
            existingBranch.setName(branch.getName());
            existingBranch.setAddress(branch.getAddress());
            existingBranch.setBranchType(branch.getBranchType());
            existingBranch.getEmployees().clear();
            existingBranch.getEmployees().addAll(branch.getEmployees());
            return branchRepository.save(existingBranch);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteBranch(@PathVariable Long id) {
        branchRepository.deleteById(id);
    }
}
