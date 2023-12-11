package br.org.com.recode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

//@SpringBootApplication
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class RecodeViagensApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecodeViagensApplication.class, args);
	}

}
