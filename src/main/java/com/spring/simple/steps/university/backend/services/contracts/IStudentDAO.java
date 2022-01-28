package com.spring.simple.steps.university.backend.services.contracts;

import com.spring.simple.steps.university.backend.models.Person;

public interface IStudentDAO extends IPersonDAO{
    Iterable<Person> findStudentByNameCarrera(String name);
}
