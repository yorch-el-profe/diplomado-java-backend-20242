package org.bedu.cli;

import org.bedu.cli.controller.TodoController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// IoC (Inversion of Control)

@SpringBootApplication
public class CliApplication implements CommandLineRunner {

	// Injección de Dependencias
	@Autowired
	private TodoController application;

	public static void main(String[] args) {
		SpringApplication.run(CliApplication.class, args);
	}

	@Override
	public void run(String ... args) {
		application.menu();
	}
}
