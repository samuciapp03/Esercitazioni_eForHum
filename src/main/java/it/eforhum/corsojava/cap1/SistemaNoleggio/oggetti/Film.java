package it.eforhum.corsojava.cap1.SistemaNoleggio.oggetti;

import java.time.LocalDate;

public class Film extends Noleggio {
	private Genere genere;

	public Film(String cod, String titolo, LocalDate dataInizio, LocalDate dataFine, Genere genere) {
		super(cod, titolo, dataInizio, dataFine);
		this.genere = genere;
	}

	public Genere getGenere() {
		return genere;
	}

}
