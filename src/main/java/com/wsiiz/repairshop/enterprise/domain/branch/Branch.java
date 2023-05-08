package com.wsiiz.repairshop.enterprise.domain.branch;

import jakarta.persistence.*;

import java.time.LocalDate;
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

    @OneToMany(mappedBy = "branch", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Employee> employees = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_branch_id")
    private Branch parentBranch;

    @OneToMany(mappedBy = "parentBranch", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Branch> childBranches = new ArrayList<>();

    // getters and setters
}

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    @Enumerated(EnumType.STRING)
    private EmployeeType employeeType;

    private LocalDate employmentDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "branch_id")
    private Branch branch;

    @ElementCollection
    private List<EmployeeSkill> skills = new ArrayList<>();

    // getters and setters
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