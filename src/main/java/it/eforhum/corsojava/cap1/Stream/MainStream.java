package it.eforhum.corsojava.cap1.Stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class MainStream {
	public static void main(String[] args) {
		Stream<Integer> stream;
		List<Integer> list = Arrays.asList(10, 20, 57, 3, 2, 1002, 530, 777);
		List<Integer> test = Arrays.asList(1, 2, 3, 4);

		System.out.println("Numeri dispari: ");
		list.stream().filter(n -> n % 2 != 0).forEach(System.out::println);

		System.out.println("\nE' presente nella lista test? " + list.stream().anyMatch((n) -> test.contains(n)));
	}
}
