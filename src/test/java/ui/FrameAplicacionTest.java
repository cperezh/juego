package ui;

import java.awt.MediaTracker;

import javax.swing.ImageIcon;

import org.junit.Test;

import juego.Juego;

public class FrameAplicacionTest {


	@Test
	public void testPintarCartas() {

		Boolean todosImagenesCargadas = true;

		Juego juego = new Juego();

		FrameAplicacion frame = new FrameAplicacion("Juego Manuel", juego);

		frame.pintarCartas();

		//Recorro los panes recien pintados
		for (PanelCarta panelCarta : frame.getPanelesCartas()) {

			//Si alguna imagen no ha cargado, falla el test
			if (((ImageIcon) panelCarta.getImgLabel().getIcon()).getImageLoadStatus() != MediaTracker.COMPLETE) {
				todosImagenesCargadas = false;
				break;
			}

		}

		assert (todosImagenesCargadas);

	}

}
