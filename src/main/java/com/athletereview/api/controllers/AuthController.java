package com.athletereview.api.controllers;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.athletereview.api.dto.AuthResponseDto;
import com.athletereview.api.dto.LoginDto;
import com.athletereview.api.dto.RegisterDto;
import com.athletereview.api.models.Role;
import com.athletereview.api.models.UserEntity;
import com.athletereview.api.repository.RoleRepository;
import com.athletereview.api.repository.UserRepository;
import com.athletereview.api.security.JWTGenerator;

@RestController
@RequestMapping("/api/auth/")
public class AuthController {

		private AuthenticationManager authenticationManager;
		private UserRepository userRepository;
		private RoleRepository roleRepository;
		private PasswordEncoder passwordEncoder;
		private JWTGenerator jwtGenerator;
		
		@Autowired
		public AuthController(AuthenticationManager authenticationManager, UserRepository userRepository,
				RoleRepository roleRepository, PasswordEncoder passwordEncoder, JWTGenerator jwtGenerator) {
			super();
			this.authenticationManager = authenticationManager;
			this.userRepository = userRepository;
			this.roleRepository = roleRepository;
			this.passwordEncoder = passwordEncoder;
			this.jwtGenerator = jwtGenerator;
		}
		
		@PostMapping("register")
		public ResponseEntity<String> register(@RequestBody RegisterDto registerDto) {
			if (userRepository.existsByUsername(registerDto.getUsername())) {
				return new ResponseEntity<>("Username is taken", HttpStatus.BAD_REQUEST);
			}
			
			UserEntity user = new UserEntity();
			user.setUsername(registerDto.getUsername());
			user.setPassword(passwordEncoder.encode(registerDto.getPassword()));
			
			Role roles = roleRepository.findByName("ROLE_USER").get();
			user.setRoles(Collections.singletonList(roles));
			
			userRepository.save(user);
			
			return new ResponseEntity<>("User registered success", HttpStatus.OK);
			
		}
		
		@PostMapping("login")
		public ResponseEntity<AuthResponseDto> login(@RequestBody LoginDto loginDto){
			Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					loginDto.getUsername(),
					loginDto.getPassword()));
			
			SecurityContextHolder.getContext().setAuthentication(authentication); 
			String token = jwtGenerator.generateToken(authentication); 
			return new ResponseEntity<>(new AuthResponseDto(token), HttpStatus.OK);
		}
		
}
