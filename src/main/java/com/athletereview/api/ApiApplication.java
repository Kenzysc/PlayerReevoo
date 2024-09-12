package com.athletereview.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}
	
	// adds USER and ADMIN roles to "roles" when spring app loads
	// Task: you need to identify if its a fresh new app unless it affect new user registration
	// Task<fixed>: only one role seems to be saved...confirm
// 	@Bean
//    CommandLineRunner init (RoleRepository roleRepo){
//        return args -> {
//           List<String> roles = Arrays.asList("ROLES_ADMIN", "ROLES_USER");
       	
//        	Role role = new Role();
// 
//        	roles.forEach(name -> role.setName(name));
//        	roleRepo.save(role);

// 			roles.forEach(name -> {
// 				role.setName(name);
// 				roleRepo.save(role);
// 			});
//        };
//    }
}
