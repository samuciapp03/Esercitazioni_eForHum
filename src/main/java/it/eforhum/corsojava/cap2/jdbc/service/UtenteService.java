package it.eforhum.corsojava.cap2.jdbc.service;

import it.eforhum.corsojava.cap2.jdbc.dao.UtenteDAO;
import it.eforhum.corsojava.cap2.jdbc.entity.Utente;

public class UtenteService {
	private static UtenteService instance = new UtenteService();

	private UtenteService() {

	}

	public static UtenteService getInstance() {
		return instance;
	}

	public Utente findById(long id) {
		return UtenteDAO.getInstance().findById(id);
	}

	public void insertUtente(Utente user) {
		UtenteDAO.getInstance().insertUtente(user);
	}

}
