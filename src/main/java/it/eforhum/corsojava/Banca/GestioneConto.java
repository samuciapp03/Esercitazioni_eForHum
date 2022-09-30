package it.eforhum.corsojava.Banca;

import java.time.LocalDate;

import it.eforhum.corsojava.Banca.dao.ContoDAO;
import it.eforhum.corsojava.Banca.dao.MovimentoDAO;
import it.eforhum.corsojava.Banca.oggetti.Conto;

public class GestioneConto {
	ContoDAO conti = new ContoDAO();
	MovimentoDAO mov = new MovimentoDAO();

	public boolean creaConto(String nome, String cognome, String nTelefono, String indirizzo) {
		int conto = getConto(nome, cognome);

		if (conto == -1)
			return false;

		String iban = "IT0000";

		conti.addConto(nome, cognome, nTelefono, indirizzo, iban);
		return true;
	}

	public boolean creaMovimento(String nome, String cognome, String tipoMovimento, int importo, String desc) {
		return false;
	}

	public String elencoMovimenti(String nome, String cognome, LocalDate inizio, LocalDate fine) {
		return "";
	}

	public int getSaldo(String nome, String cognome) {
		return 0;
	}

	public boolean ricaricaTelefonica(String nome, String cognome, int importo) {
		return false;
	}

	public int getConto(String nome, String cognome) {
		for (int i = 0; i < conti.nConti(); i++)
			if (conti.getNome(i).equals(nome) && conti.getCognome(i).equals(cognome))
				return i;

		return -1;
	}
}
