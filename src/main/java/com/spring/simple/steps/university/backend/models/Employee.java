package com.spring.simple.steps.university.backend.models;

import com.spring.simple.steps.university.backend.models.enumerator.EmployeeType;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "employee")
@PrimaryKeyJoinColumn(name = "persona_id")
public class Employee extends Person {

    private BigDecimal salary;

    @Column(name = "employee_type")
    @Enumerated(EnumType.STRING)
    private EmployeeType employeeType;

    @OneToOne(
            optional = true,
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "pabellon_id",
            foreignKey = @ForeignKey(name = "FK_PABELLON_ID")
    )
    private Pabellon pabellon;

    public Employee() {
    }

    public Employee(Integer id, String name, String lastName, String dni, Direction direction, BigDecimal salary, EmployeeType employeeType) {
        super(id, name, lastName, dni, direction);
        this.salary = salary;
        this.employeeType = employeeType;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public EmployeeType getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(EmployeeType employeeType) {
        this.employeeType = employeeType;
    }

    public Pabellon getPabellon() {
        return pabellon;
    }

    public void setPabellon(Pabellon pabellon) {
        this.pabellon = pabellon;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\tEmployee{" +
                "salary=" + salary +
                ", employeeType=" + employeeType +
                '}';
    }
}
