package com.spring.simple.steps.university.backend.repository;

import com.spring.simple.steps.university.backend.models.Carrera;
import org.springframework.data.repository.CrudRepository;

public interface ICarreraRepository extends CrudRepository<Carrera, Integer> {

    //@Query("select c from Carrera c where c.name like %?1%")
    Iterable<Carrera> findCarrerasByNameContains(String name);

    //@Query("select c from Carrera c where upper(c.name) like upper(%?1%)")
    Iterable<Carrera> findCarrerasByNameContainsIgnoreCase(String name);

    //@Query("select c from Carrera c where c.quantityYear > ?1")
    Iterable<Carrera> findCarrerasByQuantityYearAfter(Integer quantityYear);
}
