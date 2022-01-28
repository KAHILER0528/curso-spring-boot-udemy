package com.spring.simple.steps.university.backend.services.contracts;


import java.util.Optional;

public interface IGenericDAO<E>{
    Optional<E> findById(Integer id);
    E save(E entidad);
    Iterable<E> findAll();
    void deleteById(Integer id);
}
