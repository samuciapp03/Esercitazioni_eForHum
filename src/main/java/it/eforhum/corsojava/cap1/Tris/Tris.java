package it.eforhum.corsojava.cap1.Tris;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.time.StopWatch;

public class Tris {
	private String giocatore1;
	private String giocatore2;
	private StopWatch tempo;
	private char table[][];
	private int turno;

	public Tris() {
	}

	public void inizialize() {
		this.table = new char[3][3];
		this.turno = 0;

		int n = 1;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				table[i][j] = (char) (n++ + '0');
			}
		}
	}

	public String getGiocatore1() {
		return giocatore1;
	}

	public void setGiocatore1(String giocatore1) {
		this.giocatore1 = giocatore1;
	}

	public String getGiocatore2() {
		return giocatore2;
	}

	public void setGiocatore2(String giocatore2) {
		this.giocatore2 = giocatore2;
	}

	public int getTurno() {
		return turno;
	}

	public char getCella(int riga, int col) {
		return table[riga][col];
	}

	public void setGiocata(int riga, int col, String giocatore) {
		table[riga][col] = (giocatore.equals(giocatore1)) ? 'X' : 'O';
		turno++;
	}

	public void startTempo() {
		this.tempo = new StopWatch();
		tempo.start();
	}

	public void stopTempo() {
		tempo.stop();
	}

	public String getTempo() {
		long sec = tempo.getTime(TimeUnit.SECONDS);

		if (sec < 60)
			return sec + " secondi";
		else
			return String.valueOf(tempo.getTime(TimeUnit.MINUTES)) + " minuti e "
					+ String.valueOf(sec - ((int) (sec / 60) * 60)) + " secondi";
	}
}