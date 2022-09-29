package it.eforhum.corsojava.Tris;

import java.util.Scanner;

/*
 * Gioco del tris Elementi da mettere dell'app: Stampa della tabella, Impostare
 * i nomi dei giocatori, Comunicare il turno, Funzione per iniziare la partita
 * Funzione se la partita è ancora in corso Se vince qualcuno, il programma non
 * finisce, Può vedere la durata della partita (h, mm, ss), numero giocate,
 * Comunicare la vincita o la parità Funzione giocata, Recuperare i nomi dei
 * giocatori
 */

public class MainTris {
	public static void main(String[] args) {
		GestioneTris tris = new GestioneTris();
		String scelta = "";

		System.out.println("Gioco del tris");

		System.out.print("\nInserisci il nome del giocatore 1: ");
		tris.setGiocatore1(read());
		System.out.print("Inserisci il nome del giocatore 2: ");
		tris.setGiocatore2(read());

		do {
			tris.inizialize();
			tris.startTempo();

			int n = 0;
			boolean err = false;

			do {
				tris.stampa();

				System.out.print(((err) ? "Errore, riprova \n" : "") + "\n" + tris.turnoGiocatore(0)
						+ " inserisci la giocata: ");
				n = Integer.parseInt(read());

				err = false;

				if (n < 1 || n > 9 || !tris.aggiungiGiocata(n)) {
					err = true;
				}
			} while (tris.finePartita());

			tris.stampa();
			tris.stopTempo();

			if (tris.getTurni() == 8)
				System.out.println("\nLa partita e' finita in partia'");
			else
				System.out.println("\nHa vinto il giocatore " + tris.vincitore);

			do {
				System.out.print("Volete giocare di nuovo o visualizzare le statistiche? (y, n, stat) ");
				scelta = read();

				if (!scelta.equals("y") && !scelta.equals("n") && !scelta.equals("stat")) {
					System.out.println("\nErrore, riprova");
				}
			} while (!scelta.equals("y") && !scelta.equals("n") && !scelta.equals("stat"));

			if (scelta.equals("stat")) {
				System.out.println("\nSono stati fatti " + tris.getTurni() + " turni");
				System.out.println("Il tempo impiegato e' stato: " + tris.getTempo());

				do {
					System.out.print("\nVolete giocare di nuovo? (y, n) ");
					scelta = read();

					if (!scelta.equals("y") && !scelta.equals("n")) {
						System.out.println("\nErrore, riprova");
					}
				} while (!scelta.equals("y") && !scelta.equals("n"));
			}
		} while (scelta.equals("y"));

		System.out.println("\nArrivederci");
	}

	public static String read() {
		Scanner insrt = new Scanner(System.in);
		return insrt.nextLine();
	}

	public final static void clearConsole() {
		try {
			final String os = System.getProperty("os.name");

			if (os.contains("Windows")) {
				Runtime.getRuntime().exec("cls");
			} else {
				Runtime.getRuntime().exec("clear");
			}
		} catch (final Exception e) {
			// Handle any exceptions.
		}
	}
}