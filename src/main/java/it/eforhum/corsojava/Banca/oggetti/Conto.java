package it.eforhum.corsojava.Banca.oggetti;

import java.util.ArrayList;
import java.util.List;

public class Conto {
	private String nome;
	private String cognome;
	private String nTelefono;
	private String indirizzo;
	private String iban;
	private int saldo;
	private List<Movimento> mov;

	public Conto(String nome, String cognome, String nTelefono, String indirizzo, String iban) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.nTelefono = nTelefono;
		this.indirizzo = indirizzo;
		this.iban = iban;
		this.mov = new ArrayList<Movimento>();
	}

	public int getSaldo() {
		return saldo;
	}

	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}

	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}

	public String getnTelefono() {
		return nTelefono;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public String getIban() {
		return iban;
	}

	public List<Movimento> getMov() {
		return mov;
	}

}
