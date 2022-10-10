package it.eforhum.corsojava.cap1.SistemaNoleggio.oggetti;

import java.time.LocalDate;

public class Gioco extends Noleggio {
	private Console console;

	public Gioco(String cod, String titolo, LocalDate dataInizio, LocalDate dataFine, Console console) {
		super(cod, titolo, dataInizio, dataFine);
		this.console = console;
	}

	public Console getConsole() {
		return console;
	}

}
