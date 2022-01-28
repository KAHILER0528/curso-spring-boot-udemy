package com.spring.simple.steps.university.backend.services.contracts;

import com.spring.simple.steps.university.backend.models.Carrera;

public interface ICarreraDAO extends IGenericDAO<Carrera> {

    Iterable<Carrera> findCarrerasByNameContains(String name);
    Iterable<Carrera> findCarrerasByNameContainsIgnoreCase(String name);
    Iterable<Carrera> findCarrerasByQuantityYear(Integer quantityYear);
}
