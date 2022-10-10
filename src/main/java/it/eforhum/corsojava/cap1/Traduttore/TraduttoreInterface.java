package it.eforhum.corsojava.cap1.Traduttore;

import java.io.PrintStream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public interface TraduttoreInterface {

	Logger LOG = LogManager.getLogger(GestioneTraduttore.class);
	// utilizzo mappe più appropiato per dizionario

	boolean inserisciParola(String parolaItaliana, int lingua, String parolaTradotta);

	void printLingue(PrintStream stream);

	boolean isLingua(int lingua);

	String getLingua(int lingua);

	String traduciParola(String parolaItaliana, int lingua);

}