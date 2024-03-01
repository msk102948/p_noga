package com.p_noga.p_noga;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class PNogaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PNogaApplication.class, args);
	}

}
