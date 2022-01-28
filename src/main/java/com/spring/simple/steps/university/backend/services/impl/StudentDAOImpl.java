package com.spring.simple.steps.university.backend.services.impl;

import com.spring.simple.steps.university.backend.models.Person;
import com.spring.simple.steps.university.backend.repository.IPersonRepository;
import com.spring.simple.steps.university.backend.repository.IStudentRepository;
import com.spring.simple.steps.university.backend.services.contracts.IStudentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentDAOImpl extends PersonDAOImpl implements IStudentDAO {

    @Autowired
    public StudentDAOImpl(@Qualifier("repositoryStudents")IPersonRepository repository) {
        super(repository);
    }

    @Override
    @Transactional(readOnly =true)
    public Iterable<Person> findStudentByNameCarrera(String name) {
        return ((IStudentRepository)repository).findStudentByNameCarrera(name);
    }
}
