package dev.paie.console.ihm;

import dev.paie.console.service.Service;

public class OptionB {
	
	private Service service;

	public void setService(Service srv) {
		this.service = srv;
	}
	
	public void exec() {
		System.out.println("Option B");
		this.service.display();
	}

}
