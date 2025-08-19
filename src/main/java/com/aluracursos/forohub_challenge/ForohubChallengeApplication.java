package com.aluracursos.forohub_challenge;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class ForohubChallengeApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ForohubChallengeApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hola MUNDO");
    }
}
