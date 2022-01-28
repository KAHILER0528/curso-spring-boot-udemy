package com.spring.simple.steps.university.backend.models;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "carreras")
public class Carrera implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false, length = 80)
    private String name;

    @Column(name = "quantity_siganatura")
    private Integer quantityAsiganatura; //Cantidad Mataeria

    @Column(name = "quantity_year")
    private  Integer quantityYear; //Cantidad Años

    @Column(name = "date_discharge")
    private LocalDateTime dateDischarge; //Fecha de Alta

    @Column(name = "date_update")
    private LocalDateTime dateUpdate; //Fecha de Actualización

    @OneToMany(
            mappedBy = "carrera",
            fetch = FetchType.LAZY
    )
    private Set<Student> students;

    @ManyToMany(
            mappedBy = "carreras",
            fetch = FetchType.LAZY

    )
    private Set<Teacher> teachers;

    public Carrera() {
    }

    public Carrera(Integer id, String name, Integer quantityAsiganatura, Integer quantityYear) {
        this.id = id;
        this.name = name;
        this.quantityAsiganatura = quantityAsiganatura;
        this.quantityYear = quantityYear;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantityAsiganatura() {
        return quantityAsiganatura;
    }

    public void setQuantityAsiganatura(Integer quantityAsiganatura) {
        this.quantityAsiganatura = quantityAsiganatura;
    }

    public Integer getQuantityYear() {
        return quantityYear;
    }

    public void setQuantityYear(Integer quantityYear) {
        this.quantityYear = quantityYear;
    }

    public LocalDateTime getDateDischarge() {
        return dateDischarge;
    }

    public void setDateDischarge(LocalDateTime dateDischarge) {
        this.dateDischarge = dateDischarge;
    }

    public LocalDateTime getDateUpdate() {
        return dateUpdate;
    }

    public void setDateUpdate(LocalDateTime dateUpdate) {
        this.dateUpdate = dateUpdate;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public Set<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(Set<Teacher> teachers) {
        this.teachers = teachers;
    }

    //Dos metodos mas
    @PrePersist
    private void beforePersis(){
        this.dateDischarge= LocalDateTime.now();
    }

    @PreUpdate
    private void beforeUpdate() {
        this.dateUpdate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Carrera{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", quantityAsiganatura=" + quantityAsiganatura +
                ", quantityYear=" + quantityYear +
                ", dateDischarge=" + dateDischarge +
                ", dateUpdate=" + dateUpdate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carrera carrera = (Carrera) o;
        return id.equals(carrera.id) && name.equals(carrera.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
