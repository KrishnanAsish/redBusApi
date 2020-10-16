package com.redbus.starter;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com")
@EnableJpaRepositories("com.redbus.model")
@EntityScan("com.redbus.entities")   
public class RedBusStarterApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedBusStarterApiApplication.class, args);
	}

}
