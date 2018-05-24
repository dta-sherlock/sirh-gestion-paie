package dev.paie.console.ihm;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dev.paie.console.service.Service;
@Component
public class OptionB {
	
	@Autowired
	private Service service;
	

	public OptionB() {
		super();
	

	}
	
	@PostConstruct
	public void init() {
		System.out.println("Option B créé");
		service.display();
	}

	
	public void setService(Service srv) {
		this.service = srv;
	}
	
	public void exec() {
		System.out.println("Option B");
		this.service.display();
	}

}
