package br.com.finances;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = {"br.com.finances.entity"})
@EnableJpaRepositories(basePackages = {"br.com.finances.repository"})
@ComponentScan(basePackages = {"br.com.finances.service", "br.com.finances.controller", "br.com.finances.exception"})
@SpringBootApplication
public class FinancesApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinancesApplication.class, args);
	}

}

