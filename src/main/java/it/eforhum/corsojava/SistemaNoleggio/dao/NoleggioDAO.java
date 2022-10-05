package it.eforhum.corsojava.SistemaNoleggio.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import it.eforhum.corsojava.SistemaNoleggio.oggetti.Console;
import it.eforhum.corsojava.SistemaNoleggio.oggetti.Film;
import it.eforhum.corsojava.SistemaNoleggio.oggetti.Genere;
import it.eforhum.corsojava.SistemaNoleggio.oggetti.Gioco;
import it.eforhum.corsojava.SistemaNoleggio.oggetti.Noleggio;

public class NoleggioDAO {
	List<Noleggio> noleggi = new ArrayList<Noleggio>();

	public boolean addFilm(String cod, String titolo, LocalDate dataInizio, LocalDate dataFine, Genere genere) {
		noleggi.add(new Film(cod, titolo, dataInizio, dataFine, genere));
		return true;
	}

	public boolean addGioco(String cod, String titolo, LocalDate dataInizio, LocalDate dataFine, Console console) {
		noleggi.add(new Gioco(cod, titolo, dataInizio, dataFine, console));
		return true;
	}

	public LocalDate getInizio(int i) {
		return noleggi.get(i).getDataInizio();
	}

	public LocalDate getFine(int i) {
		return noleggi.get(i).getDataFine();
	}

	public double getPrezzo(int i) {
		return noleggi.get(i).getPrezzo();
	}

	public void setPrezzo(int i, double prezzo) {
		noleggi.get(i).setPrezzo(prezzo);
	}

	public boolean isFilm(int i) {
		return noleggi.get(i) instanceof Film ? true : false;
	}

	public int getIndex() {
		return (noleggi.size() - 1);
	}

}
