package it.eforhum.corsojava.jdbc;

import it.eforhum.corsojava.jdbc.service.UtenteService;

public class MainDemo {
	public static void main(String[] args) {
		System.out.println(UtenteService.getInstance().findById(1));
	}
}
