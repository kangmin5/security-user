package com.utosoftwaresecretuser;

import com.utosoftwaresecretuser.domain.Role;
import com.utosoftwaresecretuser.domain.User;
import com.utosoftwaresecretuser.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class SecretUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecretUserApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}


	@Bean
	CommandLineRunner run(UserService userService){
		return args -> {
			userService.saveRole(new Role(null,"USER"));
			userService.saveRole(new Role(null,"MANAGER"));
			userService.saveRole(new Role(null,"ADMIN"));
			userService.saveRole(new Role(null,"SUPER_ADMIN"));

			userService.saveUser(new User(null,"kang min","kangmin","1111",new ArrayList<>()));
			userService.saveUser(new User(null,"park sungku","parksungku","1111",new ArrayList<>()));
			userService.saveUser(new User(null,"park chanku","parkchanku","1111",new ArrayList<>()));
			userService.saveUser(new User(null,"Jung yunji","jjj","1111",new ArrayList<>()));

			userService.addRoleToUser("kangmin","USER");
			userService.addRoleToUser("kangmin","ADMIN");
			userService.addRoleToUser("parksungku","USER");
			userService.addRoleToUser("parksungku","MANAGER");
			userService.addRoleToUser("jjj","SUPER_ADMIN");
		};
	}

}
