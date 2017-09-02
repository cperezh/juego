package ui;

import static org.junit.Assert.fail;

import org.junit.Test;

import juego.Carta;
import juego.Juego;

public class JuegoTest {

	@Test
	/**
	 * Pruaba que la baraja está bien formada. Los tres arrays tienen que tener
	 * la misma longitud
	 */
	public void testBarajaJuego() {

		try {
			new Juego();
		} catch (Exception ex) {
			fail(ex.toString());
		}
	}

	

	@Test
	public void testTodasLasParejasSonCartas() {
		
		Juego juego = new Juego();
		
		boolean cartaEncontrada;

		for (Carta carta:juego.getBaraja().getCartas()) {
			
			cartaEncontrada = false;

			for (Carta carta2:juego.getBaraja().getCartas()) {

				if (carta.getPareja().equals(carta2)) {
					cartaEncontrada = true;
					break;
				}
			}
			
			if (!cartaEncontrada){
				fail("Pareja que no es carta: "+carta.getPareja().getNombre());
			}
		}
	}

	@Test
	public void testNoDosVecesLaMismaCarta() {
		Juego juego = new Juego();

		for (int i = 0; i < juego.getBaraja().getCartas().size(); i++) {

			Carta carta = juego.getBaraja().getCartas().get(i);

			for (int j = i + 1; j < juego.getBaraja().getCartas().size(); j++) {

				Carta carta2 = juego.getBaraja().getCartas().get(j);

				if (carta.equals(carta2)) {
					fail("Cartas iguales: "+carta.getNombre()+" y "+carta2.getNombre());
				}
			}
		}

	}

	@Test
	public void testNoDosVecesLaMismaPareja() {
		Juego juego = new Juego();

		for (int i = 0; i < juego.getBaraja().getCartas().size(); i++) {

			Carta carta = juego.getBaraja().getCartas().get(i);

			for (int j = i + 1; j < juego.getBaraja().getCartas().size(); j++) {

				Carta carta2 = juego.getBaraja().getCartas().get(j);

				if (carta.getPareja().equals(carta2.getPareja())) {
					fail("Parejas iguales: "+carta.getPareja().getNombre()+" y "+carta2.getPareja().getNombre());
				}
			}
		}

	}

}
