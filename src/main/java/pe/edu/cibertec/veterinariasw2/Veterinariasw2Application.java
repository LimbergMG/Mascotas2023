package pe.edu.cibertec.veterinariasw2;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Veterinariasw2Application {

	
	public static void main(String[] args) {
		SpringApplication.run(Veterinariasw2Application.class, args);
	}
		@Bean
	public CommandLineRunner ejecutar(){
		return args -> {
			System.out.println("Hola Mundo");
		}; 
	}


}
