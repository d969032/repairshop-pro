package com.wsiiz.repairshop.enterprise.domain.branch;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
//poprawka_2
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

    @OneToMany(mappedBy = "branch", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Employee> employees = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_branch_id")
    private Branch parentBranch;

    @OneToMany(mappedBy = "parentBranch", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<Branch> childBranches = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
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
}
@Embeddable
public class Address {
    private String city;

    private String street;

    private String zipCode;

    // getters and setters
}

public enum BranchType {
    SERVICE,
    SALES,
    MIXED
}

public enum EmployeeType {
    MECHANIC,
    SALES_PERSON,
    OFFICE_WORKER,
    HELPER,
    MANAGER,
    ADVISOR
}

public enum EmployeeSkill {
    ELECTRONICS,
    MECHANICS,
    HYDRAULICS,
    ELECTRICAL_INSTALLATION,
    CAR_BODY,
    PAINTING,
    CUSTOMER_SERVICE,
    SALES
}