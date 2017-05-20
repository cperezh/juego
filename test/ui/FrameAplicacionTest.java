package ui;

import java.awt.MediaTracker;

import javax.swing.ImageIcon;

import org.junit.Test;

public class FrameAplicacionTest {


	@Test
	public void testPintarCartas() {

		Boolean todosImagenesCargadas = true;

		Juego2 juego2 = new Juego2();

		FrameAplicacion frame = new FrameAplicacion("Juego Manuel", juego2.getBaraja());

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
