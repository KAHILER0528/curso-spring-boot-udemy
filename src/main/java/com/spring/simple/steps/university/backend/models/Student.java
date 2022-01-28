package com.spring.simple.steps.university.backend.models;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student extends Person {

    @ManyToOne(
            optional = true,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "carrera_id")
    private Carrera carrera;

    public Student() {
    }

    public Student(Integer id, String name, String lastName, String dni, Direction direction) {
        super(id, name, lastName, dni, direction);
    }

    @Override
    public String toString() {
        return super.toString()+
                "Student{}";
    }
}
