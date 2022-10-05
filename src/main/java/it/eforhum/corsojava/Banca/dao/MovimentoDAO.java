package it.eforhum.corsojava.Banca.dao;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import it.eforhum.corsojava.Banca.oggetti.Conto;
import it.eforhum.corsojava.Banca.oggetti.Movimento;

public class MovimentoDAO {
	ContoDAO conti = new ContoDAO();
	List<Movimento> mov = new ArrayList<Movimento>();

	public void addMovimento(String tipoMovimento, int importo, String desc, LocalDateTime data, int i) {
		Movimento movimento = new Movimento(tipoMovimento, importo, desc, data, conti.getConto(i));

		conti.getMovimenti(i).add(movimento);
		mov.add(movimento);
	}

	public String getTipoMovimento(int i) {
		return mov.get(i).getTipoMovimento();
	}

	public int getImporto(int i) {
		return mov.get(i).getImporto();
	}

	public String getDesc(int i) {
		return mov.get(i).getDesc();
	}

	public LocalDateTime getData(int i) {
		return mov.get(i).getData();
	}

	public int getSizeMovimenti() {
		return mov.size();
	}

}
