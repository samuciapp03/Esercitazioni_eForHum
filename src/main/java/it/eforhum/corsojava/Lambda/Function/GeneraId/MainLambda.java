package it.eforhum.corsojava.Lambda.Function.GeneraId;

import java.util.UUID;
import java.util.function.Supplier;

public class MainLambda {
	public static void main(String[] args) {

		Supplier<Long> generaId = () -> {
			UUID id = UUID.randomUUID();
			return id.getLeastSignificantBits();
		};

		long i = generaId.get();
	}
}
