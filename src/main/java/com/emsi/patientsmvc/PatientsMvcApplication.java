package com.emsi.patientsmvc;

import com.emsi.patientsmvc.entities.Patient;
import com.emsi.patientsmvc.repositories.PatientRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class PatientsMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatientsMvcApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(PatientRepo patientRepo) {
		return args -> {

			patientRepo.save(new Patient(null, "hassan", new Date(), false, 12));
			patientRepo.save(new Patient(null, "moad", new Date(), true, 54));
			patientRepo.save(new Patient(null, "ikram", new Date(), false, 65));
			patientRepo.save(new Patient(null, "karim", new Date(), false, 84));


			patientRepo.findAll().forEach(p -> {
				System.out.println(p.getNom());
			});
		};

	}

}
