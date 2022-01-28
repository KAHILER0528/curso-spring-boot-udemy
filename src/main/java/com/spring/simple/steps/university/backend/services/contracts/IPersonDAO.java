package com.spring.simple.steps.university.backend.services.contracts;

import com.spring.simple.steps.university.backend.models.Person;

import java.util.Optional;

public interface IPersonDAO extends IGenericDAO<Person>{

    Optional<Person> findPersonByNameAndLastName(String name, String lastName);

    Optional<Person> findPersonByDni(String dni);

    Iterable<Person> findPersonByLastName(String lastName);
}
