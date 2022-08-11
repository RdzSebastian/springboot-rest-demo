package com.estonianport.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class SpringbootRestDemoAngularApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringbootRestDemoAngularApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootRestDemoAngularApplication.class, args);
	}

}
