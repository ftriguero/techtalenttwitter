package com.tts.techtalenttwitter.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration //Says this is a class that controls how objects are created ...
				//A class annotated with @Configuration will typically have one 
				//or more methods that are annotated @Bean that define how an object is 
				//created for Autowiring .. AKA inversion of control 
public class WebMvcConfiguration {
	@Bean //Whatever return type of the method that follows becomes the way it is created
	
	public BCryptPasswordEncoder passwordEncoder()
	{
		BCryptPasswordEncoder bCryptPasswordEncoder =
				new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}

}
