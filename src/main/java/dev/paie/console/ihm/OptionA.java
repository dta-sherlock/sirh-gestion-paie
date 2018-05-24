package dev.paie.console.ihm;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dev.paie.console.service.Service;

@Component
public class OptionA {
	
	private Service serv;
	private Scanner sc;

	@Autowired
	public OptionA(Service serv, Scanner sc) {
		super();
		this.serv = serv;
		this.sc = sc;
	}
	
	public void exec() {
		System.out.println("Option A");
		String saisie = this.sc.next();
		System.out.println("Vous avez saisi " + saisie);

		
		
		
		System.out.println(saisie);
		this.serv.display();
	}

}
