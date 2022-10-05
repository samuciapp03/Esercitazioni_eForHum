package it.eforhum.corsojava.SistemaNoleggio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.function.Predicate;

import org.apache.commons.lang3.EnumUtils;

import it.eforhum.corsojava.SistemaNoleggio.oggetti.Console;
import it.eforhum.corsojava.SistemaNoleggio.oggetti.Genere;

//====================================================
//ESERCITAZIONE IN AUTONOMIA/GRUPPO
//Scrivere un'applicazione standalone Java, in grado di simulare un sistema di noleggio giochi e film.
//
//Sia i giochi che i film hanno le seguenti caratteristiche
//- identificativo numerico univoco (es. 1)
//- codice alfanumerico (es. PS5-GT7)
//- titolo alfanumerico (es. Mamma ho perso l'aereo)
//- data inizio noleggio (es. 10/12/2020)
//- data fine noleggio (es. 12/12/2020)
//- prezzo noleggio calcolato dal sistema
//
//I giochi hanno come attributi non comuni
//- console di riferimento (valori ammissibili PC/PS4/PS5/XBOX-ONE-S/XBOX-ONE-X)
//
//I film hanno come attributi non comuni
//- genere (valori ammissibili ANIMAZIONE/AZIONE/COMMEDIA/DRAMMATICO/FAMIGLIA)

//Il prezzo di noleggio � cos� calcolato
//giochi - 1 * numero di giorni calcolati come differenza tra la data fine e la data inizio
//film - 2.5 * numero di giorni calcolati come differenza tra la data fine e la data inizio

//Implementare i metodi per calcolare il noleggio sia per i giochi che per i film

public class MainNoleggio {
	public static void main(String[] args) {
		GestioneNoleggio noleggi = new GestioneNoleggio();
		String scelta = "";

		do {
			String cod = insert("Inserisci il codice del prodotto: ", (v) -> true);

			String titolo = insert("Inserisci il titolo del prodotto: ", (v) -> true);

			DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");

			Predicate<String> verifyData = (v) -> (v.length() == 10 && v.substring(0, 2).matches("[0-9]+")
					&& v.substring(3, 5).matches("[0-9]+") && v.substring(6, 10).matches("[0-9]+") && v.charAt(2) == '/'
					&& v.charAt(5) == '/');

			String data = insert("Inserisci la data di inizio noleggio: (dd/MM/yyy) ", verifyData);

			LocalDate dataInizio = LocalDate.from(format.parse(data));

			LocalDate dataFine;

			do {
				data = insert("Inserisci la data di fine noleggio: (dd/MM/yyy) ", verifyData);

				dataFine = LocalDate.from(format.parse(data));

				if (dataFine.isBefore(dataInizio)) {
					System.out.println("Errore, riprova");
				}

			} while (dataFine.isBefore(dataInizio));

			scelta = insert("Vuoi inserire un film o un gioco? (f, g) ", (v) -> ("f".equals(v) || "g".equals(v)));

			if ("f".equals(scelta)) {

				Genere genere = Genere.valueOf(insertUpper("Inserisci il genere del film: ",
						(v) -> EnumUtils.isValidEnum(Genere.class, v.toUpperCase())));

				noleggi.addFilm(cod, titolo, dataInizio, dataFine, genere);

			} else if ("g".equals(scelta)) {

				Console console = Console.valueOf(insertUpper("Inserisci il tipo di console: ",
						(v) -> (EnumUtils.isValidEnum(Console.class, v.toUpperCase()))));

				noleggi.addGioco(cod, titolo, dataInizio, dataFine, console);
			}

			System.out
					.println("\nIl prezzo del noleggio e': " + noleggi.calcolaPrezzoNoleggio(noleggi.getIndex()) + "€");

			scelta = insert("Vuoi inserire un altro noleggio? (y, n) ", (v) -> ("y".equals(v) || "n".equals(v)));

		} while ("y".equals(scelta));

		System.out.println("\nArrivederci");
	}

	public static String insert(String testo, Predicate<String> verify) {
		String result = "";

		do {
			System.out.print("\n" + testo);
			result = read();

			if (result.isEmpty() || !verify.test(result)) {
				System.out.println("Errore, riprova");
			}
		} while (result.isEmpty() || !verify.test(result));

		return result;
	}

	public static String insertUpper(String testo, Predicate<String> verify) {
		String result = "";

		do {
			System.out.print("\n" + testo);
			result = read();

			if (result.isEmpty() || !verify.test(result)) {
				System.out.println("Errore, riprova");
			}
		} while (result.isEmpty() || !verify.test(result));

		return result.toUpperCase();
	}

	public static String read() {
		Scanner scan = new Scanner(System.in);
		return scan.nextLine();
	}
}
