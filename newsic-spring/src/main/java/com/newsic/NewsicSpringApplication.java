package com.newsic;

import java.util.Arrays;
import java.util.Calendar;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class NewsicSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewsicSpringApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			Calendar today = Calendar.getInstance();
			System.out.println("Year : " + today.get(Calendar.YEAR));
			
//			System.out.println("Let's inspect the beans provided by Spring Boot:");
//			System.out.println("");

//			String[] beanNames = ctx.getBeanDefinitionNames();
//			Arrays.sort(beanNames);
//			for (String beanName : beanNames) {
//				System.out.println(beanName);
//			}

		};
	}

}
