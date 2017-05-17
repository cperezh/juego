package test;

import org.junit.Test;

import juego.Carta;

public class CartaTest {

	@Test
	public void testNotEquals() {

		Boolean iguales;

		Carta carta1 = new Carta("perro", null, null);
		Carta carta2 = new Carta("gato", null, null);

		iguales = carta1.equals(carta2);

		assert (!iguales);

	}

	@Test
	public void testEquals() {

		Boolean iguales;

		Carta carta1 = new Carta("perro", null, null);
		Carta carta3 = new Carta("perro", null, null);

		iguales = carta1.equals(carta3);

		assert (iguales);

	}

}
