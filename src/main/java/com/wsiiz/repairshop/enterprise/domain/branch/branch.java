package com.wsiiz.repairshop.enterprise.domain.branch;
package com.telran.enterprise.entity;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    private BranchType branchType;

    @ManyToOne(fetch = FetchType.LAZY)
    private Branch parentBranch;

    @OneToMany(mappedBy = "parentBranch", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Branch> childBranches = new ArrayList<>();

    @OneToMany(mappedBy = "branch", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Employee> employees = new ArrayList<>();

    public Branch() {}

    public Branch(String name, Address address, BranchType branchType) {
        this.name = name;
        this.address = address;
        this.branchType = branchType;
    }

    // getters and setters

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public BranchType getBranchType() {
        return branchType;
    }

    public void setBranchType(BranchType branchType) {
        this.branchType = branchType;
    }

    public Branch getParentBranch() {
        return parentBranch;
    }

    public void setParentBranch(Branch parentBranch) {
        this.parentBranch = parentBranch;
    }

    public List<Branch> getChildBranches() {
        return childBranches;
    }

    public void setChildBranches(List<Branch> childBranches) {
        this.childBranches = childBranches;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public void addChildBranch(Branch branch) {
        this.childBranches.add(branch);
        branch.setParentBranch(this);
    }

    public void removeChildBranch(Branch branch) {
        this.childBranches.remove(branch);
        branch.setParentBranch(null);
    }

    public void addEmployee(Employee employee) {
        this.employees.add(employee);
        employee.setBranch(this);
    }

    public void removeEmployee(Employee employee) {
        this.employees.remove(employee);
        employee.setBranch(null);
    }

}