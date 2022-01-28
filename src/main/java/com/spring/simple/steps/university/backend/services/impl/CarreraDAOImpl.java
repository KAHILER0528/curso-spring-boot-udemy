package com.spring.simple.steps.university.backend.services.impl;

import com.spring.simple.steps.university.backend.models.Carrera;
import com.spring.simple.steps.university.backend.repository.ICarreraRepository;
import com.spring.simple.steps.university.backend.services.contracts.ICarreraDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CarreraDAOImpl extends GenericDAOImp<Carrera, ICarreraRepository> implements ICarreraDAO {

    @Autowired
    public CarreraDAOImpl(ICarreraRepository repository) {
        super(repository);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Carrera> findCarrerasByNameContains(String name) {
        return repository.findCarrerasByNameContains(name);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Carrera> findCarrerasByNameContainsIgnoreCase(String name) {
        return repository.findCarrerasByNameContainsIgnoreCase(name);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Carrera> findCarrerasByQuantityYear(Integer quantityYear) {
        return repository.findCarrerasByQuantityYearAfter(quantityYear);
    }
}
