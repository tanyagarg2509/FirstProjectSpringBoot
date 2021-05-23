package com.example.Firstproject.service;

import org.springframework.stereotype.Component;

// springbean
@Component
public class LoginService {

	public boolean validateUser(String userid, String password) {
		return userid.equalsIgnoreCase("Tanya") && password.equalsIgnoreCase("garg");
	}
}

// Spring Autowiring @Autowired @Component and Dependency Injection -- to unit test application
// @Component - requesting springframewrok to handle& manage,  @Autowired , @Controller - web controllers ,@Repository, @Service,, @ComponentScan