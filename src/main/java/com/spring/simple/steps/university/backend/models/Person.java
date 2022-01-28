package com.spring.simple.steps.university.backend.models;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name= "personas")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Person implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false, scale = 60)
    private String name;

    @Column(unique = true, nullable = false, scale = 60)
    private String lastName;

    @Column(unique = true, nullable = true, length = 12)
    private String dni;

    @Column(name = "date_Discharge")
    private LocalDateTime dateDischarge; //Fecha de Alta

    @Column(name = "date_Update")
    private LocalDateTime dateUpdate; //Fecha de Actualización

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "postalCode", column = @Column(name = "postal_code")),
            @AttributeOverride(name = "department", column = @Column(name = "department"))
    })
    private Direction direction;

    public Person() {
    }

    public Person(Integer id, String name, String lastName, String dni, Direction direction) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.dni = dni;
        this.direction = direction;
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
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

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
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
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dni='" + dni + '\'' +
                ", dateDischarge=" + dateDischarge +
                ", dateUpdate=" + dateUpdate +
                ", direction=" + direction +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id.equals(person.id) && dni.equals(person.dni);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dni);
    }
}
