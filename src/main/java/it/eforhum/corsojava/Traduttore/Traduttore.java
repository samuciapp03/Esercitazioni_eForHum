package it.eforhum.corsojava.Traduttore;

public class Traduttore {
	private String italiano;
	private int lingua;
	private String parolaTradotta;

	public Traduttore(String italiano, int lingua, String parolaTradotta) {
		super();
		this.italiano = italiano;
		this.lingua = lingua;
		this.parolaTradotta = parolaTradotta;
	}

	public String getItaliano() {
		return italiano;
	}

	public int getLingua() {
		return lingua;
	}

	public String getParolaTradotta() {
		return parolaTradotta;
	}

}