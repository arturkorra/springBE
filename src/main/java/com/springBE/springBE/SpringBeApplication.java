package com.springBE.springBE;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class SpringBeApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(SpringBeApplication.class, args);
		
	}

}
