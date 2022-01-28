package com.spring.simple.steps.university.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UniversityBackendApplication {

	public static void main(String[] args) {
		String[] beanDefinitionNames = SpringApplication.run(UniversityBackendApplication.class, args).getBeanDefinitionNames();

		/*for (String s: beanDefinitionNames){
			System.out.println("s = " + s);
		}*/
	}

}
