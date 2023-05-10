package com.wsiiz.repairshop.enterprise.application.branch;

import com.wsiiz.repairshop.enterprise.domain.employee.Employee;
import com.wsiiz.repairshop.enterprise.domain.branch.Branch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/branches")
public class BranchController {

    @Autowired
    private Branch branch;

    @Autowired
    private Employee employeeRepository;

    @GetMapping
    public String getAllBranches(Model model) {
        model.addAttribute("branches", branch.findAll());
        return "branch-list";
    }

    @GetMapping("/{id}")
    public String getBranchById(@PathVariable Long id, Model model) {
        model.addAttribute("branch", branch.findById(id).orElse(null));
        return "branch-details";
    }

    @GetMapping("/new")
    public String newBranch(Model model) {
        model.addAttribute("branch", new Branch());
        model.addAttribute("employees", employee.findAll());
        return "branch-form";
    }

    @PostMapping
    public String saveOrUpdateBranch(@ModelAttribute Branch branch) {
        branchRepository.save(branch);
        return "redirect:/branches";
    }

    @GetMapping("/edit/{id}")
    public String editBranch(@PathVariable Long id, Model model) {
        model.addAttribute("branch", branchRepository.findById(id).orElse(null));
        model.addAttribute("employees", employeeRepository.findAll());
        return "branch-form";
    }

    @GetMapping("/delete/{id}")
    public String deleteBranch(@PathVariable Long id) {
        branchRepository.deleteById(id);
        return "redirect:/branches";
    }
}
