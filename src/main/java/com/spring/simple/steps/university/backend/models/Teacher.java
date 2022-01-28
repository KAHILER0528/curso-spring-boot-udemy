package com.spring.simple.steps.university.backend.models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "teacher")
@PrimaryKeyJoinColumn(name = "teacher_id")
public class Teacher extends Person {

    private BigDecimal salary;

    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            }
    )
    @JoinTable(
            name = "teacher_carrera",
            joinColumns = @JoinColumn(name = "teacher_id"),
            inverseJoinColumns = @JoinColumn(name = "carrera_id")
    )
    private Set<Carrera> carreras;

    public Teacher() {
    }

    public Teacher(Integer id, String name, String lastName, String dni, Direction direction, BigDecimal salary) {
        super(id, name, lastName, dni, direction);
        this.salary = salary;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public Set<Carrera> getCarreras() {
        return carreras;
    }

    public void setCarreras(Set<Carrera> carreras) {
        this.carreras = carreras;
    }

    @Override
    public String toString() {
        return super.toString()+
                "\tTeacher{" +
                "salary=" + salary +
                '}';
    }
}
