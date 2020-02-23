package com.qpidhealth.qpid.search;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.qpidhealth")
public class SimpleSearchAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleSearchAppApplication.class, args);
	}
	
}
