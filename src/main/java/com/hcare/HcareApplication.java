package com.hcare;

import java.util.Date;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.hcare.dto.PatientsDTO;
import com.hcare.service.PatientsService;

@SpringBootApplication()
@ComponentScan({"com.hcare.service", "com.hcare.service.impl", "com.hcare.services.transformers","com.hcare.controller"})
@EntityScan( {"com.hcare.model", "com.hcare.dto"})
@EnableJpaRepositories("com.hcare.repository")
public class HcareApplication {

	public static void main(String[] args) {
		SpringApplication.run(HcareApplication.class, args);
	}

	@Bean
	public ApplicationRunner initializer(PatientsService patientsServices) {
		PatientsDTO patient1 = new PatientsDTO();
		patient1.setEmail("patient1@gmail.com");
		patient1.setPassword("123456");
		patient1.setSurname("test");
		patient1.setDateInscription(new Date());

		PatientsDTO patient2 = new PatientsDTO();
		patient2.setEmail("patient2@gmail.com");
		patient2.setPassword("123456");
		patient2.setSurname("test");
		patient2.setDateInscription(new Date());

		patientsServices.save(patient1);
		return args -> patientsServices.save(patient2);
	}
}
