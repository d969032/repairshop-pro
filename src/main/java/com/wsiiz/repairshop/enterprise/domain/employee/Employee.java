package com.wsiiz.repairshop.enterprise.domain.employee;

import com.wsiiz.repairshop.enterprise.domain.branch.Branch;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Employee {

    private String firstName;
    private String lastName;
    private EmploymentType employmentType;
    private LocalDate hireDate;
    private Branch branch;
    private Set<Skill> skills = new HashSet<>();

    public Employee(String firstName, String lastName, EmploymentType employmentType, LocalDate hireDate, Branch branch, Set<Skill> skills) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.employmentType = employmentType;
        this.hireDate = hireDate;
        this.branch = branch;
        this.skills = skills;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public EmploymentType getEmploymentType() {
        return employmentType;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public Branch getBranch() {
        return branch;
    }

    public Set<Skill> getSkills() {
        return skills;
    }
}

enum EmploymentType {
    MECHANIC,
    SALESMAN,
    OFFICE_WORKER,
    HELPER,
    MANAGER,
    ADVISOR
}

enum Skill {
    ENGINE_REPAIR,
    BODY_REPAIR,
    PAINTING,
    CUSTOMIZATION,
    SALES,
    CUSTOMER_SERVICE,
    ADMINISTRATION,
    CLEANING
}
