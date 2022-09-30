package it.eforhum.corsojava.Banca.dao;

import java.util.ArrayList;
import java.util.List;

import it.eforhum.corsojava.Banca.oggetti.Conto;
import it.eforhum.corsojava.Banca.oggetti.Movimento;

public class ContoDAO {
	private List<Conto> conti = new ArrayList<Conto>();

	public void addConto(String nome, String cognome, String nTelefono, String indirizzo, String iban) {
		conti.add(new Conto(nome, cognome, nTelefono, indirizzo, iban));
	}

	public Conto getConto(int i) {
		return conti.get(i);
	}

	public String getNome(int i) {
		return conti.get(i).getNome();
	}

	public String getCognome(int i) {
		return conti.get(i).getCognome();
	}

	public String getIban(int i) {
		return conti.get(i).getIban();
	}

	public String getnTelefono(int i) {
		return conti.get(i).getnTelefono();
	}

	public int getSaldo(int i) {
		return conti.get(i).getSaldo();
	}

	public String getIndirizzo(int i) {
		return conti.get(i).getIndirizzo();
	}

	public void setSaldo(int i, int saldo) {
		conti.get(i).setSaldo(saldo);
	}

	public int nConti() {
		return conti.size();
	}

	public List<Movimento> getMovimenti(int i) {
		return conti.get(i).getMov();
	}

}
