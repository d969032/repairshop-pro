package com.wsiiz.repairshop.enterprise.domain.branch;

import com.wsiiz.repairshop.enterprise.domain.employee.Employee;

import java.util.HashSet;
import java.util.Set;

public class Branch {

    private String name;
    private Address address;
    private BranchType branchType;
    private Set<Employee> employees = new HashSet<>();

    public Branch(String name, Address address, BranchType branchType) {
        this.name = name;
        this.address = address;
        this.branchType = branchType;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public BranchType getBranchType() {
        return branchType;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void removeEmployee(Employee employee) {
        employees.remove(employee);
    }

}

class Address {

    private String street;
    private String city;
    private String postalCode;

    public Address(String street, String city, String postalCode) {
        this.street = street;
        this.city = city;
        this.postalCode = postalCode;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getPostalCode() {
        return postalCode;
    }
}

enum BranchType {
    SERVICE,
    SALES,
    MIXED
}
