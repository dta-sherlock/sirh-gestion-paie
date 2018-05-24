package dev.paie.console;

import java.math.BigDecimal;
import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dev.paie.console.ihm.OptionA;
import dev.paie.console.ihm.OptionB;
import dev.paie.console.service.BddService;
import dev.paie.console.service.Service;

public class AppConsole {

	public static void main(String[] args) {

		
		//BddService.class.getDeclaredMethods().
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		OptionB opt = context.getBean(OptionB.class);
		opt.exec();
		
		context.close();
	}

}
