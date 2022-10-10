package it.eforhum.corsojava.jdbc.service;

import it.eforhum.corsojava.jdbc.dao.UtenteDAO;
import it.eforhum.corsojava.jdbc.entity.Utente;

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

}
