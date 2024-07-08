package org.sid.auth_security;

import org.sid.auth_security.Entity.AppRole;
import org.sid.auth_security.Entity.AppUser;
import org.sid.auth_security.Service.AccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class AuthSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthSecurityApplication.class, args);
	}
	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	 }
	@Bean
	CommandLineRunner start(AccountService accountService){
		return args -> {
            accountService.addNewRole(new AppRole(null,"ADMINISTRATEUR"));
			accountService.addNewRole(new AppRole(null,"CRC"));
			accountService.addNewRole(new AppRole(null,"BOESHOP"));

			accountService.addNewUser(new AppUser(null,"user1","3456",new ArrayList<>()));
			accountService.addNewUser(new AppUser(null,"admin","3456",new ArrayList<>()));
			accountService.addNewUser(new AppUser(null,"user2","3456",new ArrayList<>()));
			accountService.addNewUser(new AppUser(null,"user3","3456",new ArrayList<>()));


            accountService.addRoleToUser("user1","CRC");
			accountService.addRoleToUser("admin","ADMINISTRATEUR");
			accountService.addRoleToUser("user2","BOESHOP");



		};
	 }

}
