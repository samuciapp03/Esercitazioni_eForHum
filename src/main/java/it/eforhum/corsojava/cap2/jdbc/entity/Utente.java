package it.eforhum.corsojava.cap2.jdbc.entity;

import java.time.LocalDateTime;
import java.util.Objects;

public class Utente {
	private long idUtente;
	private String username;
	private String password;
	private String nome;
	private String cognome;

	private LocalDateTime dataIns;
	private String utenteIns;
	private LocalDateTime dataMod;
	private String utenteMod;

	public Utente(String username, String password, String nome, String cognome, LocalDateTime dataIns,
			String utenteIns) {
		super();
		this.username = username;
		this.password = password;
		this.nome = nome;
		this.cognome = cognome;
		this.dataIns = dataIns;
		this.utenteIns = utenteIns;
	}

	public Utente() {

	}

	public long getIdUtente() {
		return idUtente;
	}

	public void setIdUtente(long idUtente) {
		this.idUtente = idUtente;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public LocalDateTime getDataIns() {
		return dataIns;
	}

	public void setDataIns(LocalDateTime dataIns) {
		this.dataIns = dataIns;
	}

	public String getUtenteIns() {
		return utenteIns;
	}

	public void setUtenteIns(String utenteIns) {
		this.utenteIns = utenteIns;
	}

	public LocalDateTime getDataMod() {
		return dataMod;
	}

	public void setDataMod(LocalDateTime dataMod) {
		this.dataMod = dataMod;
	}

	public String getUtenteMod() {
		return utenteMod;
	}

	public void setUtenteMod(String utenteMod) {
		this.utenteMod = utenteMod;
	}

	@Override
	public String toString() {
		return "Utente [idUtente=" + idUtente + ", username=" + username + ", password=" + password + ", nome=" + nome
				+ ", cognome=" + cognome + ", dataIns=" + dataIns + ", utenteIns=" + utenteIns + ", dataMod=" + dataMod
				+ ", utenteMod=" + utenteMod + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cognome, dataIns, dataMod, idUtente, nome, password, username, utenteIns, utenteMod);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Utente other = (Utente) obj;
		return Objects.equals(cognome, other.cognome) && Objects.equals(dataIns, other.dataIns)
				&& Objects.equals(dataMod, other.dataMod) && idUtente == other.idUtente
				&& Objects.equals(nome, other.nome) && Objects.equals(password, other.password)
				&& Objects.equals(username, other.username) && Objects.equals(utenteIns, other.utenteIns)
				&& Objects.equals(utenteMod, other.utenteMod);
	}

}
