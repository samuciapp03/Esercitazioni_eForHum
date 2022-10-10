package it.eforhum.corsojava.cap1.Tris;

public class GestioneTris {
	Tris table = new Tris();
	String vincitore;

	public void stampa() {
		System.out.println("\n-------------");

		for (int i = 0; i < 3; i++) {

			for (int j = 0; j < 3; j++) {
				System.out.print("| " + table.getCella(i, j) + " ");
			}
			System.out.println("|");
			System.out.println("-------------");
		}
	}

	public void inizialize() {
		table.inizialize();
	}

	public void setGiocatore1(String nome) {
		table.setGiocatore1(nome);
	}

	public void setGiocatore2(String nome) {
		table.setGiocatore2(nome);
	}

	public int getTurni() {
		return table.getTurno();
	}

	public void startTempo() {
		table.startTempo();
		vincitore = "";
	}

	public void stopTempo() {
		table.stopTempo();
	}

	public String getTempo() {
		return table.getTempo();
	}

	public String turnoGiocatore(int n) {
		// n = 0 per vedere giocatore corrente
		// n = 1 per invertire

		if ((table.getTurno() % 2) == n)
			return table.getGiocatore1();
		else
			return table.getGiocatore2();
	}

	public int getRiga(int n) {
		if (n <= 3)
			return 0;
		else if (n <= 6)
			return 1;
		else
			return 2;
	}

	public int getCol(int n) {
		if (n == 1 || n == 4 || n == 7)
			return 0;
		else if (n == 2 || n == 5 || n == 8)
			return 1;
		else
			return 2;
	}

	public boolean aggiungiGiocata(int n) {
		int riga = getRiga(n);
		int col = getCol(n);

		if (table.getCella(riga, col) == 'X' || table.getCella(riga, col) == 'O')
			return false;

		table.setGiocata(riga, col, turnoGiocatore(0));
		return true;
	}

	public boolean finePartita() {
		if (table.getTurno() == 8)
			return false;

		if (table.getCella(0, 0) == table.getCella(0, 1) && table.getCella(0, 1) == table.getCella(0, 2)) {
			vincitore = turnoGiocatore(1);
			return false;
		}

		if (table.getCella(1, 0) == table.getCella(1, 1) && table.getCella(1, 1) == table.getCella(1, 2)) {
			vincitore = turnoGiocatore(1);
			return false;
		}

		if (table.getCella(2, 0) == table.getCella(2, 1) && table.getCella(2, 1) == table.getCella(2, 2)) {
			vincitore = turnoGiocatore(1);
			return false;
		}

		if (table.getCella(0, 0) == table.getCella(1, 0) && table.getCella(1, 0) == table.getCella(2, 0)) {
			vincitore = turnoGiocatore(1);
			return false;
		}

		if (table.getCella(0, 1) == table.getCella(1, 1) && table.getCella(1, 1) == table.getCella(2, 1)) {
			vincitore = turnoGiocatore(1);
			return false;
		}

		if (table.getCella(0, 2) == table.getCella(1, 2) && table.getCella(1, 2) == table.getCella(2, 2)) {
			vincitore = turnoGiocatore(1);
			return false;
		}

		if (table.getCella(0, 0) == table.getCella(1, 1) && table.getCella(1, 1) == table.getCella(2, 2)) {
			vincitore = turnoGiocatore(1);
			return false;
		}

		if (table.getCella(0, 2) == table.getCella(1, 1) && table.getCella(1, 1) == table.getCella(2, 0)) {
			vincitore = turnoGiocatore(1);
			return false;
		}

		return true;
	}
}