package dev.paie.console.ihm;

import dev.paie.console.service.Service;

public class OptionA {
	
	private Service serv;

	public OptionA(Service serv) {
		super();
		this.serv = serv;
	}
	
	public void exec() {
		System.out.println("Option A");
		this.serv.display();
	}

}
