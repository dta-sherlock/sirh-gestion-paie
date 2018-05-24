package dev.paie.console;

import java.util.Scanner;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

import dev.paie.console.service.BddService;

@Configuration
//@ImportResource( {"app-config.xml"})
//@Import(BddService.class)
@ComponentScan({"dev.paie.console"})
public class AppConfig {
	
	@Bean
	public Scanner scanner() {
		return new Scanner(System.in);
	}

}
