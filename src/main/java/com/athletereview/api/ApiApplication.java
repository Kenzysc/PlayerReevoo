package com.athletereview.api;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.athletereview.api.models.Role;
import com.athletereview.api.repository.RoleRepository;

@SpringBootApplication
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}
	
	// adds USER and ADMIN roles to "roles" when spring app loads
	@Bean
   CommandLineRunner init (RoleRepository roleRepo){
       return args -> {
          List<String> roles = Arrays.asList("ADMIN", "USER");
       	
       	Role role = new Role();
       	roles.forEach(name -> role.setName(name));
       	roleRepo.save(role);
       };
   }
}
