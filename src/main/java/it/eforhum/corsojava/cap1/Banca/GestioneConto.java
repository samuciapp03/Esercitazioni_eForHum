package it.eforhum.corsojava.cap1.Banca;

import java.io.PrintStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;

import it.eforhum.corsojava.cap1.Banca.dao.ContoDAO;
import it.eforhum.corsojava.cap1.Banca.dao.MovimentoDAO;

public class GestioneConto {
	ContoDAO conti = new ContoDAO();
	MovimentoDAO mov = new MovimentoDAO();

	public boolean creaConto(String nome, String cognome, String nTelefono, String indirizzo) {
		int conto = getConto(nome, cognome);

		if (conto == -1)
			return false;

		Random rand = new Random();
		String iban = "IT";

		iban += String.valueOf(10000 + rand.nextInt(99999));
		iban += String.valueOf(10000 + rand.nextInt(99999));
		iban += String.valueOf(10000 + rand.nextInt(99999));
		iban += String.valueOf(10000 + rand.nextInt(99999));
		iban += String.valueOf(10000 + rand.nextInt(99999));

		conti.addConto(nome, cognome, nTelefono, indirizzo, iban);
		return true;
	}

	public boolean creaMovimento(String nome, String cognome, String tipoMovimento, int importo, String desc,
			LocalDateTime data) {
		int conto = getConto(nome, cognome);

		if (conto == -1)
			return false;

		mov.addMovimento(tipoMovimento, importo, desc, data, conto);
		return true;
	}

	public void elencoMovimenti(LocalDate inizio, LocalDate fine, PrintStream stream) {
		if (mov.getSizeMovimenti() != 0) {
			stream.println("Tipo del movimento \t | Importo \t | Descrizione \t | Data");

			for (int i = 0; i < mov.getSizeMovimenti(); i++) {
				stream.println("\n" + mov.getTipoMovimento(i) + ", \t " + mov.getImporto(i) + ", \t " + mov.getDesc(i)
						+ ", \t " + mov.getData(i));
			}

		} else {
			stream.println("Non e' ancora stato registrato alcun elemento");
		}

	}

	public int getSaldo(String nome, String cognome) {
		int conto = getConto(nome, cognome);

		if (conto == -1)
			return conto;

		return conti.getSaldo(conto);
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
