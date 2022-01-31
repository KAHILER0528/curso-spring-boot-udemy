package com.spring.simple.steps.university.backend;

import com.spring.simple.steps.university.backend.models.Carrera;
import com.spring.simple.steps.university.backend.services.contracts.ICarreraDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CarrerasCommands implements CommandLineRunner {

    @Autowired
    private ICarreraDAO servicioCarrera;

    @Override
    public void run(String... args) throws Exception {
       /* Carrera ingSistemas = new Carrera(null, "Ingenieria en Sistema", 60, 5);
        Carrera ingIndustrial = new Carrera(null, "Ingenieria Industrial", 55, 5);
        Carrera ingAlimentos = new Carrera(null, "Ingenieria en Alimentos", 53, 5);
        Carrera ingElectronica = new Carrera(null, "Ingenieria Electronica", 45, 5);
        Carrera licSistemas = new Carrera(null, "Licenciado en Sistema", 40, 4);
        Carrera licTurismo = new Carrera(null, "Licnciado en Turismo",42, 4 );
        Carrera licYoga = new Carrera(null, "Licenciado en Yoga", 25, 3);
        Carrera licRecursos = new Carrera(null, "Licenciado en Recursos RRHH", 33, 3);

        servicioCarrera.save(ingSistemas);
        servicioCarrera.save(ingIndustrial);
        servicioCarrera.save(ingAlimentos);
        servicioCarrera.save(ingElectronica);
        servicioCarrera.save(licSistemas);
        servicioCarrera.save(licTurismo);
        servicioCarrera.save(licYoga);
        servicioCarrera.save(licRecursos);*/

        /*List<Carrera> carreras = (List<Carrera>) servicioCarrera.findCarrerasByNameContains("Sistema");
        carreras.forEach(System.out::println);

        List<Carrera> carrerasIgnorCase = (List<Carrera>) servicioCarrera.findCarrerasByNameContainsIgnoreCase("SISTEMA");
        carrerasIgnorCase.forEach(System.out::println);

        List<Carrera> carrerasIgnorCase1 = (List<Carrera>) servicioCarrera.findCarrerasByNameContainsIgnoreCase("sistema");
        carrerasIgnorCase1.forEach(System.out::println);

        List<Carrera> carreras = (List<Carrera>) servicioCarrera.findCarrerasByQuantityYear(3);
        carreras.forEach(System.out::println);*/
    }

}
