package it.eforhum.corsojava.Traduttore;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MainTraduttore {
	public static final Logger LOG = LogManager.getLogger(MainTraduttore.class);

//  implementare una classe in grado di simulare un traduttore
//  la classe permette di registare al suo interno parole in lingua inglese e francese
//  ad ogni parola registrata deve corrispondere la sua traduzione in italiano
//  la classe deve esporre le seguenti operazioni
// 		registra nuova parola inglese (viene specificata la parola inglese e la sua traduzione)
//		registra nuova parola francese (viene specificata la parola francese e la sua traduzione)
//		traduci parola inglese (viene richiesta in input la parola da tradurre)
//		traduci parola francese (viene richiesta in input la parola da tradurre)
//	implementare la classe che utilizza dei casi d'uso per verificarne il comportamento

	public static void main(String[] args) {
		LOG.info("inizio applicazione");

		GestioneTraduttore trad = new GestioneTraduttore();
		String scelta = "";

		do {
			do {
				System.out.print("\nVuoi inserire una nuova parola o tradurla? (i, t) ");
				scelta = read();

				if (scelta.isEmpty() || (!scelta.equals("i") && !scelta.equals("t"))) {
					LOG.warn("errore nell'inserimento da tastiera, contro le regole");
					System.out.println("Errore, riprova");
				}
			} while (scelta.isEmpty() || (!scelta.equals("i") && !scelta.equals("t")));

			LOG.info("inserimento lingua");
			int lingua = 0;

			do {
				trad.printLingue(System.out);

				System.out.print("\nInserisci la lingua della parola da tradurre: ");
				lingua = Integer.parseInt(read());
				lingua--;

				if (!trad.isLingua(lingua)) {
					LOG.warn("errore nell'inserimento da tastiera, contro le regole");
					System.out.println("Errore, riprova");
				}
			} while (!trad.isLingua(lingua));

			if (scelta.equals("i")) {
				String parolaItaliana = inserisciParola(-1);
				String parolaTradotta = inserisciParola(lingua);

				if (!trad.inserisciParola(parolaItaliana, lingua, parolaTradotta))
					System.out.println("Errore, la traduzione che hai provato ad inserire e' gia' stata inserita");
				else
					System.out.println("\nParola inserita con successo");
			} else {
				String parolaItaliana = inserisciParola(-1);

				String parolaTradotta = trad.traduciParola(parolaItaliana, lingua);

				if (!parolaTradotta.isEmpty()) {
					System.out.println("La parola \"" + parolaItaliana + "\" tradotta in " + trad.getLingua(lingua)
							+ " e': " + parolaTradotta);
				} else {
					System.out.println("Non c'e' una traduzione in " + trad.getLingua(lingua) + " per la parola \""
							+ parolaItaliana + "\"");
				}
			}

			do {
				System.out.print("\nVuoi eseguire un'altra operazione? (y, n) ");
				scelta = read();

				if (scelta.isEmpty() || (!scelta.equals("y") && !scelta.equals("n"))) {
					LOG.warn("errore nell'inserimento da tastiera, contro le regole");
					System.out.println("Errore, riprova");
				}
			} while (scelta.isEmpty() || (!scelta.equals("y") && !scelta.equals("n")));

			System.out.println();
		} while ("y".equals(scelta)); // modificare anche gli altri

		System.out.println("Arrivederci");
	}

	public static String inserisciParola(int lingua) {
		// -1 per parola italiana
		GestioneTraduttore trad = new GestioneTraduttore();

		String parola = "";

		do {
			System.out.print("\nInserisci la parola in " + (lingua == -1 ? "italiano" : trad.getLingua(lingua)) + ": ");
			parola = read();

			if (parola.isEmpty()) {
				LOG.warn("errore nell'inserimento da tastiera, contro le regole");
				System.out.println("Errore, riprova");
			}
		} while (parola.isEmpty());

		return parola;
	}

	public static String read() {
		Scanner insrt = new Scanner(System.in);
		return insrt.nextLine();
	}

}
