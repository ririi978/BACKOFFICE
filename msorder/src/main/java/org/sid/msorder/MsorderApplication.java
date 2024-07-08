package org.sid.msorder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "org.sid.msorder.Feign")

public class MsorderApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsorderApplication.class, args);

	}

}
