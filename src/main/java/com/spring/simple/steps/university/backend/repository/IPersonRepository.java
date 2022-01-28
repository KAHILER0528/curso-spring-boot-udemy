package com.spring.simple.steps.university.backend.repository;

import com.spring.simple.steps.university.backend.models.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;

@NoRepositoryBean
public interface IPersonRepository extends CrudRepository<Person, Integer> {

    //@Query("select p from person p where p.name = ?1 and p.lastName = ?2")
    Optional<Person> findPersonByNameAndLastName(String name, String lastName);

    //@Query("select p from person p where p.dni = ?1")
    Optional<Person> findPersonByDni(String dni);

    //@Query("select p from person p where p.lastName like %?1%")
    Iterable<Person> findPersonByLastName(String lastName);
}
