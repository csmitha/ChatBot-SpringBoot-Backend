package com.mskcc.chat.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication


/**
* The ChatDemoApplication program entry point to application
* 
* @author  Smitha Chap
* @version 1.0
* @since   2019-09-02
*/
@Configuration
@ComponentScan("com.mskcc.chat.demo")
public class ChatDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChatDemoApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/loginUser").allowedOrigins("http://localhost:9000");
				registry.addMapping("/loginUser").allowedOrigins("http://localhost:8080");

			}
		};
	}

}
