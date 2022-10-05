package it.eforhum.corsojava.Lambda.Fattura;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MainLambda {
	/*
	 * Interfacia funzionale che riesce a filtrare le fatture con importo maggiore
	 * di 250
	 */

	public static void main(String[] args) {
		List<Fattura> fatture = new ArrayList<Fattura>();

		InterfacciaLambdaFattura func = (Fattura f) -> f.getImporto() < 250;

		fatture.forEach((f) -> {
			if (func.filtraFatture(f))
				fatture.remove(f);
		});
	}
}