package ui;

import java.awt.MediaTracker;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.ImageIcon;

import org.junit.Test;

public class FrameAplicacionTest {


	@Test
	public void testPintarCartas() throws IOException,FileNotFoundException{

		Boolean todosImagenesCargadas = true;

		FrameAplicacion frame = new FrameAplicacion("Juego Manuel");

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
