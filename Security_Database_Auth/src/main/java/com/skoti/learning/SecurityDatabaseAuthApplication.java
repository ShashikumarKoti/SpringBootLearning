package com.skoti.learning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SecurityDatabaseAuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityDatabaseAuthApplication.class, args);
		
		BCryptPasswordEncoder encode1 = new BCryptPasswordEncoder();
		String encode = encode1.encode("ved");
		System.out.println(encode);
	}

	
}
