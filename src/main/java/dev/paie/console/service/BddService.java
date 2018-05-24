package dev.paie.console.service;

import org.springframework.stereotype.Component;

@Component
public class BddService implements Service {

	@Override
	public void display() {
		System.out.println("Bdd");
	}

}
