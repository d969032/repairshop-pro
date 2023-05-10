package com.wsiiz.repairshop.enterprise.application.employee;

import com.wsiiz.repairshop.enterprise.domain.employee.Employee;
import com.wsiiz.repairshop.enterprise.domain.employee.EmployeeRepository;
import com.wsiiz.repairshop.enterprise.domain.branch.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private BranchRepository branchRepository;

    @GetMapping
    public String getAllEmployees(Model model) {
        model.addAttribute("employees", employeeRepository.findAll());
        return "employee-list";
    }

    @GetMapping("/{id}")
    public String getEmployeeById(@PathVariable Long id, Model model) {
        model.addAttribute("employee", employeeRepository.findById(id).orElse(null));
        return "employee-details";
    }

    @GetMapping("/new")
    public String newEmployee(Model model) {
        model.addAttribute("employee", new Employee());
        model.addAttribute("branches", branchRepository.findAll());
        return "employee-form";
    }

    @PostMapping
    public String saveOrUpdateEmployee(@ModelAttribute Employee employee) {
        employeeRepository.save(employee);
        return "redirect:/employees";
    }

    @GetMapping("/edit/{id}")
    public String editEmployee(@PathVariable Long id, Model model) {
        model.addAttribute("employee", employeeRepository.findById(id).orElse(null));
        model.addAttribute("branches", branchRepository.findAll());
        return "employee-form";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id) {
