package it.eforhum.corsojava.cap2.jdbc;

import java.time.LocalDateTime;

import it.eforhum.corsojava.cap2.jdbc.entity.Utente;
import it.eforhum.corsojava.cap2.jdbc.service.UtenteService;

public class MainDemo {
	public static void main(String[] args) {
		System.out.println(UtenteService.getInstance().findById(1));

		Utente user = new Utente("ciappe", "ciappe", "samuel", "ciappesoni", LocalDateTime.now(), "admin");
		UtenteService.getInstance().insertUtente(user);

		System.out.println(user.toString());
	}
}
