package it.eforhum.corsojava.cap1.Lambda.GeneraId;

import java.util.UUID;

public class MainLambda {
	public static void main(String[] args) {
		InterfacciaLambdaInt gen = (() -> {
			UUID id = UUID.randomUUID();
			return id.getLeastSignificantBits();
		});

		long i = gen.generaId();
	}
}
