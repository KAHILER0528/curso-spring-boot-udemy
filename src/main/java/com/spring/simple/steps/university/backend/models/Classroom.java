package com.spring.simple.steps.university.backend.models;

import com.spring.simple.steps.university.backend.models.enumerator.Blackboard;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "classrooms")
public class Classroom implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "num_classrrom", nullable = false)
    private Integer numClassroom; //Numero de aula

    @Column(name = "measures")
    private String measures; //medidas mts x mts

    @Column(name = "cant_Desks")
    private Integer cantDesks; //cantida pupitres

    @Column(name = "type_blackboard")
    @Enumerated(EnumType.STRING)
    private Blackboard blackboard; //Tipo Pizarron

    @Column(name = "date_Discharge")
    private LocalDateTime dateDischarge; //Fecha de Alta

    @Column(name = "date_Update")
    private LocalDateTime dateUpdate; //Fecha de Actualización

    @ManyToOne(
            optional = true,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            }
    )
    @JoinColumn(
            name = "pabellon_id",
            foreignKey = @ForeignKey(name = "FK_PABLLON_ID")
    )
    private Pabellon pabellon;


    public Classroom() {
    }

    public Classroom(Integer id, Integer numClassroom, String measures, Integer numDesks, Blackboard blackboard) {
        this.id = id;
        this.numClassroom = numClassroom;
        this.measures = measures;
        this.cantDesks = numDesks;
        this.blackboard = blackboard;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumClassroom() {
        return numClassroom;
    }

    public void setNumClassroom(Integer numClassroom) {
        this.numClassroom = numClassroom;
    }

    public String getMeasures() {
        return measures;
    }

    public void setMeasures(String measures) {
        this.measures = measures;
    }

    public Integer getCantDesks() {
        return cantDesks;
    }

    public void setCantDesks(Integer cantDesks) {
        this.cantDesks = cantDesks;
    }

    public Blackboard getBlackboard() {
        return blackboard;
    }

    public void setBlackboard(Blackboard blackboard) {
        this.blackboard = blackboard;
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

    public Pabellon getPabellon() {
        return pabellon;
    }

    public void setPabellon(Pabellon pabellon) {
        this.pabellon = pabellon;
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
        return "Classroom{" +
                "id=" + id +
                ", numClassroom=" + numClassroom +
                ", measures='" + measures + '\'' +
                ", numDesks=" + cantDesks +
                ", blackboard=" + blackboard +
                ", dateDischarge=" + dateDischarge +
                ", dateUpdate=" + dateUpdate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Classroom classroom = (Classroom) o;
        return id.equals(classroom.id) && numClassroom.equals(classroom.numClassroom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numClassroom);
    }

}
