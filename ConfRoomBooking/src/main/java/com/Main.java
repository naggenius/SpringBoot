package com;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:application.properties")
@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		//ConfigurableApplicationContext context = 
				SpringApplication.run(Main.class, args);
		
		
			}
}
