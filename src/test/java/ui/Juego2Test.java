package ui;

import static org.junit.Assert.fail;

import org.junit.Test;

public class Juego2Test {

	@Test
	public void testJuego2() {

		try {
			new Juego2();
		}
		catch (Exception ex) {
			fail(ex.toString());
		}
	}

}
