package com.spring.simple.steps.university.backend;

import com.spring.simple.steps.university.backend.models.Carrera;
import com.spring.simple.steps.university.backend.models.Person;
import com.spring.simple.steps.university.backend.models.Student;
import com.spring.simple.steps.university.backend.services.contracts.ICarreraDAO;
import com.spring.simple.steps.university.backend.services.contracts.IPersonDAO;
import com.spring.simple.steps.university.backend.services.contracts.IStudentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class StudentsCommands implements CommandLineRunner {

    @Autowired
    @Qualifier("studentDAOImpl")
    private IPersonDAO servicePerson;

    @Autowired
    private ICarreraDAO serviceCarrera;

    @Override
    public void run(String... args) throws Exception {
        /*Optional<Carrera> ingSistemas = servicioCarrera.findById(9);

        Iterable<Person> students = servicePersona.findAll();
        students.forEach(s-> ((Student)s).setCarrera(ingSistemas.get()));
        students.forEach(s->servicePersona.save(s));*/

        //Medtod de busquedas desde Person
        /*Optional<Person> student = servicePersona.findById(1);

        Optional<Person> personNameLastName = servicePersona.findPersonByNameAndLastName(student.get().getName(), student.get().getLastName());
        System.out.println("PersonNameLastName = " + personNameLastName.toString());

        Optional<Person> personDNI = servicePersona.findPersonByDni(student.get().getDni());
        System.out.println("PersonDNI = " + personDNI.toString());

        Iterable<Person> personLastName = servicePersona.findPersonByLastName(student.get().getLastName());
        personLastName.forEach(System.out::println);*/

        //Busqueda por carrera desde Student
        Optional<Carrera> ingSistemas = serviceCarrera.findById(9);

        Iterable<Person> studentByNameCarrera = ((IStudentDAO) servicePerson).findStudentByNameCarrera(ingSistemas.get().getName());
        studentByNameCarrera.forEach(System.out::println);

    }

}
