package it.eforhum.corsojava.Traduttore;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GestioneTraduttore {
	public static final Logger LOG = LogManager.getLogger(GestioneTraduttore.class);

	private static final List<String> lingue = Arrays.asList(new String[] { "inglese", "francese" });

	private List<Traduttore> traduttore = new ArrayList<Traduttore>();
	boolean check;

	public boolean inserisciParola(String parolaItaliana, int lingua, String parolaTradotta) {
		LOG.info("tentativo di inserire una nuova parola: [] in []", parolaItaliana, parolaTradotta);
		check = false;

		traduttore.forEach((parola) -> {
			if (parola.getItaliano().equals(parolaItaliana) && parola.getLingua() == lingua
					&& parola.getParolaTradotta().equals(parolaTradotta))
				check = true;
		});

		if (check) {
			LOG.warn("parola che si cercava di inseriere già esistente");
			return false;
		}

		traduttore.add(new Traduttore(parolaItaliana, lingua, parolaTradotta));
		LOG.info("nuova parola inserita");
		return true;
	}

	public void printLingue(PrintStream stream) {
		stream.println("");
		for (int i = 0; i < lingue.size(); i++) {
			stream.println("  " + (i + 1) + ". " + lingue.get(i));
		}
	}

	public boolean isLingua(int lingua) {
		if (lingua < 0 || lingua >= lingue.size())
			return false;
		return true;
	}

	public String getLingua(int lingua) {
		return lingue.get(lingua);
	}

	public String traduciParola(String parolaItaliana, int lingua) {
		LOG.info("tentativo di tradurre la parola [] in []", parolaItaliana, getLingua(lingua));
		String result = "";

		for (int i = 0; i < traduttore.size(); i++) {
			if (traduttore.get(i).getItaliano().equals(parolaItaliana) && traduttore.get(i).getLingua() == lingua) {
				result = traduttore.get(i).getParolaTradotta();
				break;
			}
		}

		if (result.isEmpty()) {
			LOG.warn("parola che si cercava di tradurre non esiste");
			return "";
		}

		LOG.info("parola tradotta con successo");
		return result;
	}
}