package com.cognizant.truyum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan({"com.cognizant.truyum.*"})
@EnableSwagger2
public class Main {

	public static void main(String[] args) {
		 SpringApplication.run(Main.class, args);
	}

}
