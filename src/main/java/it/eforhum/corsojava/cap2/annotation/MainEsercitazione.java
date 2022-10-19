package it.eforhum.corsojava.cap2.annotation;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import it.eforhum.corsojava.cap2.annotation.annotation.PrintableFields;
import it.eforhum.corsojava.cap2.annotation.bean.EventoSistema;

public class MainEsercitazione {

	private static Logger log = LogManager.getLogger(MainEsercitazione.class);

	public static void main(String[] args) {

		List<EventoSistema> eventi = new ArrayList<EventoSistema>();

		EventoSistema evento = new EventoSistema();
		evento.setId(990);
		evento.setDescrizione("Sistema avviato");
		evento.setData(LocalDate.of(2022, 8, 15));
		evento.setCreationUser("admin");
		evento.setCreationTime(LocalDateTime.now());

		eventi.add(evento);
		eventi.add(evento);

		System.out.println("Eventi del Sistema \n");

		printObject(eventi);

//		for (int i = 0; i < fields.length; i++) {
//			System.out.println(fields[i].getName() + " - " + fields[i].getAnnotations().length);
//
//			if (fields[i].getAnnotations().length != 0) {
//				Annotation[] annotations = fields[i].getAnnotations();
//
//				for (int j = 0; j < annotations.length; j++) {
//					if (annotations[j].annotationType().getName().equals(User.class.getName()))
//						System.out.println("  User: " + fields[i].getAnnotation(User.class).appUser());
//					else
//						System.out.println("  Annotation type: " + annotations[j].annotationType().getName());
//				}
//			}
//		}

	}

	public static <E> void printObject(List<E> obj) {
		Field[] fields = null;

		if (obj != null && obj.size() > 0)
			fields = obj.get(0).getClass().getDeclaredFields();

		else
			return;

		for (Field field : fields) {

			PrintableFields[] annotations = field.getDeclaredAnnotationsByType(PrintableFields.class);

			for (PrintableFields print : annotations) {

				if (print.header() == null)
					System.out.print(StringUtils.leftPad(" ", print.lenght()));

				else if (print.header().toString().length() >= print.lenght())
					System.out.print(" " + print.header().toString().substring(0, print.lenght() - 4) + "...");

				else
					System.out.print(StringUtils.leftPad(" ", (print.lenght() - print.header().toString().length()))
							+ print.header().toString());

				System.out.print("|");
			}
		}

		System.out.println();

		try {
			for (Object o : obj) {

				for (Field field : fields) {

					PrintableFields[] annotations = field.getDeclaredAnnotationsByType(PrintableFields.class);

					for (PrintableFields print : annotations) {
						String getter = "get" + field.getName().substring(0, 1).toUpperCase()
								+ field.getName().substring(1);

						Object valore = o.getClass().getMethod(getter).invoke(o);

						if (valore == null)
							System.out.print(StringUtils.leftPad(" ", print.lenght()));

						else if (valore.toString().length() >= print.lenght())
							System.out.print(" " + valore.toString().substring(0, print.lenght() - 4) + "...");

						else
							System.out.print(StringUtils.leftPad(" ", (print.lenght() - valore.toString().length()))
									+ valore.toString());

						System.out.print("|");
					}
				}

				System.out.println();
			}

		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException
				| SecurityException e) {

			throw new RuntimeException("Errore stampa oggetto", e);
		}

	}

}
