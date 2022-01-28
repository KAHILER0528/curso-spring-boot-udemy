package com.spring.simple.steps.university.backend.models;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "pabellon")
public class Pabellon implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "square_meter")
    private Double mts2; //Metros Cuadrados

    @Column(name = "name_pabellon")
    private String name; //Nombre del pabellon

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "postalCode", column = @Column(name = "postal_code")),
            @AttributeOverride(name = "department", column = @Column(name = "department"))
    })
    private Direction direction;

    @Column(name = "date_Discharge")
    private LocalDateTime dateDischarge; //Fecha de Alta

    @Column(name = "date_Update")
    private LocalDateTime dateUpdate; //Fecha de Actualización

    @OneToMany(
            mappedBy = "pabellon",
            fetch = FetchType.LAZY
    )
    private Set<Classroom> classrooms;

    public Pabellon() {
    }

    public Pabellon(Integer id, Double mts2, String aame, Direction direction) {
        this.id = id;
        this.mts2 = mts2;
        this.name = aame;
        this.direction = direction;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getMts2() {
        return mts2;
    }

    public void setMts2(Double mts2) {
        this.mts2 = mts2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
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

    public Set<Classroom> getClassrooms() {
        return classrooms;
    }

    public void setClassrooms(Set<Classroom> classrooms) {
        this.classrooms = classrooms;
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
        return "Pabellon{" +
                "id=" + id +
                ", mts2=" + mts2 +
                ", aame='" + name + '\'' +
                ", direction=" + direction +
                ", dateDischarge=" + dateDischarge +
                ", dateUpdate=" + dateUpdate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pabellon pabellon = (Pabellon) o;
        return id.equals(pabellon.id) && name.equals(pabellon.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
