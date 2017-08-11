package ui;

import static org.junit.Assert.fail;

import org.junit.Test;

import juego.Carta;
import juego.Juego;

public class JuegoTest {

	@Test
	/**
	 * Pruaba que la baraja está bien formada. Los tres arrays tienen que tener la misma longitud
	 */
	public void testJuego2() {

		try {
			new JuegoUI();
		} catch (Exception ex) {
			fail(ex.toString());
		}
	}

	@Test
	public void testBarajaConNumeroCartasPar() {
		Juego juego = new Juego();

		Integer numCartasBaraja = juego.getBaraja().getCartas().size();

		assert (numCartasBaraja % 2 == 0);
	}

	@Test
	public void testTodasCartasTienenPareja() {

		Boolean todasConPareja;

		Juego juego = new Juego();

		for (Carta carta : juego.getBaraja().getCartas()) {

		}

		fail ("Not developed yet"); 
	}
}
