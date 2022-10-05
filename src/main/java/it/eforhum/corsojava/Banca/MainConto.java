package it.eforhum.corsojava.Banca;

import java.util.Scanner;

public class MainConto {

// ====================================================
//	ESERCITAZIONE IN AUTONOMIA/GRUPPO
//	Definire le classi necessarie a scrivere un programma in grado di simulare una gestione semplificata di un conto corrente.
//	In particolare il conto corrente ammette le seguenti operazioni:
//
//		deposito - il programma permette la registrazione di un movimento che incrementa il saldo del conto corrente
//		prelievo - il programma permette la registrazione di un movimento che decrementa il saldo del conto corrente
//		elenco movimenti - il programma permette di visualizzare tutti i movimenti registrati in un lasso di tempo (data inizio e data fine)
//		saldo - il programma permette di visualizzare il saldo attuale contenuto nel conto corrente
//		ricarica telefonica - il programma permette di eseguire una ricarica telefonica	
// =====================================================

	public static void main(String[] args) {
		GestioneConto conti = new GestioneConto();
		String scelta = "";

		do {
			do {
				System.out.println("Cosa vuoi fare? ");
			} while (false);
			do {
				System.out.print("Vuoi fare un'altra operazione? (y, n)");
				scelta = read();

				if ((!"y".equals(scelta) && !"n".equals(scelta))) {
					System.out.println("Errore, riprova");
				}
			} while (!"y".equals(scelta) && !"n".equals(scelta));
		} while ("y".equals(scelta));
	}

	public static String read() {
		Scanner insrt = new Scanner(System.in);
		return insrt.nextLine();
	}
}
