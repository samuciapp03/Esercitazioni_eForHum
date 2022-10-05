package it.eforhum.corsojava.Lambda.Function.Fattura;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class MainLambda {
	/*
	 * Interfacia funzionale che riesce a filtrare le fatture con importo maggiore
	 * di 250
	 */

	public static void main(String[] args) {
		List<Fattura> fatture = new ArrayList<Fattura>();

		Predicate<Fattura> filtraFatture = (f) -> f.getImporto() < 250;

		fatture.forEach((f) -> {
			if (filtraFatture.test(f))
				fatture.remove(f);
		});
	}
}