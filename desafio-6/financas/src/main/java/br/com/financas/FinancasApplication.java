package br.com.financas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EntityScan(basePackages = {"br.com.financas.entity"})
@EnableJpaRepositories(basePackages = {"br.com.financas.repository"})
@ComponentScan(basePackages = {"br.com.financas.service", "br.com.financas.controller", "br.com.financas.exception"})
@SpringBootApplication
public class FinancasApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinancasApplication.class, args);
	}

}
