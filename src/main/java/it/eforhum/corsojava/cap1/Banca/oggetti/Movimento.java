package it.eforhum.corsojava.cap1.Banca.oggetti;

import java.time.LocalDateTime;

public class Movimento {
	private String tipoMovimento;
	private int importo;
	private String desc;
	private LocalDateTime data;
	private Conto conto;

	public Movimento(String tipoMovimento, int importo, String desc, LocalDateTime data, Conto conto) {
		super();
		this.tipoMovimento = tipoMovimento;
		this.importo = importo;
		this.desc = desc;
		this.data = data;
		this.conto = conto;
	}

	public String getTipoMovimento() {
		return tipoMovimento;
	}

	public int getImporto() {
		return importo;
	}

	public String getDesc() {
		return desc;
	}

	public LocalDateTime getData() {
		return data;
	}

	public Conto getConto() {
		return conto;
	}

}
