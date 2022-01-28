package com.spring.simple.steps.university.backend.services.impl;

import com.spring.simple.steps.university.backend.models.Person;
import com.spring.simple.steps.university.backend.repository.IPersonRepository;
import com.spring.simple.steps.university.backend.services.contracts.IPersonDAO;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public class PersonDAOImpl extends GenericDAOImp<Person, IPersonRepository> implements IPersonDAO {
    public PersonDAOImpl(IPersonRepository repository) {
        super(repository);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Person> findPersonByNameAndLastName(String name, String lastName) {
        return repository.findPersonByNameAndLastName(name, lastName);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Person> findPersonByDni(String dni) {
        return repository.findPersonByDni(dni);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Person> findPersonByLastName(String lastName) {
        return repository.findPersonByLastName(lastName);
    }
}
