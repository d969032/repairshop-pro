package com.wsiiz.repairshop.enterprise.domain.branch;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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