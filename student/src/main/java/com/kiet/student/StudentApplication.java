package com.kiet.student;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class StudentApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentApplication.class, args);
	}

}
@Component
class StartupRunner implements CommandLineRunner {

	private static final Logger logger =
			LoggerFactory.getLogger(StartupRunner.class);

	@Override
	public void run(String... args) {
		logger.info("KIET Student Management System Started");
		logger.info("Loading Student Data...");
		logger.info("Student Management REST API is Ready");
	}
}
