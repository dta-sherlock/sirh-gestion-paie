package dev.paie.console;

import java.math.BigDecimal;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import dev.paie.console.ihm.OptionA;
import dev.paie.console.ihm.OptionB;
import dev.paie.console.service.Service;

public class AppConsole {

	public static void main(String[] args) {

		//double a = 1.0D;
		//double b = 0.9D;

		//double resultat = a - b;
		
		BigDecimal a = new BigDecimal("1.0");
		BigDecimal b = new BigDecimal("0.9");

		BigDecimal resultat = a.subtract(b);
		
		System.out.println(resultat);

		/*
		 * 
		 * 
		 * // Créer contexte spring ClassPathXmlApplicationContext context = new
		 * ClassPathXmlApplicationContext("app-config.xml");
		 * 
		 * //Service serv1 = context.getBean(Service.class);
		 * 
		 * //serv1.display();
		 * 
		 * OptionB opt = context.getBean(OptionB.class); opt.exec();
		 * 
		 * 
		 * 
		 * context.close();
		 * 
		 */
	}

}
