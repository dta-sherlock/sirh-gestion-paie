package dev.paie.console.service;

import org.springframework.stereotype.Component;


public class MemoireService implements Service{
	@Override
	public void display() {
		System.out.println("Memoire");
	}

}
