package com.spring.simple.steps.university.backend.repository;

import com.spring.simple.steps.university.backend.models.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository("repositoryStudents")
public interface IStudentRepository extends IPersonRepository{

    //@Query("select s from Student s where s.carrera.name = ?1")
    @Query("select s from Student s join fetch s.carrera c where c.name = ?1")
    Iterable<Person> findStudentByNameCarrera(String name);
}
