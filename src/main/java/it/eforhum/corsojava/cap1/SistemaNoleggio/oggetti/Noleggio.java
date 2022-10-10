package it.eforhum.corsojava.cap1.SistemaNoleggio.oggetti;

import java.time.LocalDate;

public class Noleggio {
	private int id = 0;
	private String cod;
	private String titolo;
	private LocalDate dataInizio;
	private LocalDate dataFine;
	private double prezzo;

	public Noleggio(String cod, String titolo, LocalDate dataInizio, LocalDate dataFine) {
		super();
		this.id = this.id++;
		this.cod = cod;
		this.titolo = titolo;
		this.dataInizio = dataInizio;
		this.dataFine = dataFine;
	}

	public LocalDate getDataFine() {
		return dataFine;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public int getId() {
		return id;
	}

	public String getCod() {
		return cod;
	}

	public String getTitolo() {
		return titolo;
	}

	public LocalDate getDataInizio() {
		return dataInizio;
	}
}
