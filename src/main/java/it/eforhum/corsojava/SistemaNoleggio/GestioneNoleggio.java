package it.eforhum.corsojava.SistemaNoleggio;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import it.eforhum.corsojava.SistemaNoleggio.dao.NoleggioDAO;
import it.eforhum.corsojava.SistemaNoleggio.oggetti.Console;
import it.eforhum.corsojava.SistemaNoleggio.oggetti.Genere;

public class GestioneNoleggio {
	NoleggioDAO noleggi = new NoleggioDAO();

	public boolean addFilm(String cod, String titolo, LocalDate dataInizio, LocalDate dataFine, Genere genere) {
		noleggi.addFilm(cod, titolo, dataInizio, dataFine, genere);
		return true;
	}

	public boolean addGioco(String cod, String titolo, LocalDate dataInizio, LocalDate dataFine, Console console) {
		noleggi.addGioco(cod, titolo, dataInizio, dataFine, console);
		return true;
	}

	public double calcolaPrezzoNoleggio(int i) {
		long giorniNoleggio = ChronoUnit.DAYS.between(noleggi.getInizio(i), noleggi.getFine(i));

		if (noleggi.isFilm(i)) {
			noleggi.setPrezzo(i, (2.5 * giorniNoleggio));
		} else {
			noleggi.setPrezzo(i, (1 * giorniNoleggio));
		}

		return noleggi.getPrezzo(i);
	}

	public int getIndex() {
		return noleggi.getIndex();
	}

}
