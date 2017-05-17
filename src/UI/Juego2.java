package UI;

import juego.Baraja;

public class Juego2 {

	Baraja baraja;

	public Juego2() {
		baraja = crearBaraja();
	}

	private Baraja crearBaraja() {

		String[] nombres = { "gato", "perro", "flor1", "flor2" };
		String[] parejas = { "perro", "gato", "flor2", "flor1" };
		String[] imagenes = { "gato.jpg", "perro.jpg", "flor.jpg", "flor2.jpg" };

		Baraja baraja = new Baraja(nombres, parejas, imagenes);

		return baraja;

	}

	/**
	 * Create the GUI and show it. For thread safety, this method should be
	 * invoked from the event-dispatching thread.
	 */
	public void createAndShowGUI() {

		// Create and set up the window.
		FrameAplicacion frame = new FrameAplicacion("Juego Manuel", baraja);

		// Display the window.
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {

		Juego2 juego2 = new Juego2();

		// Schedule a job for the event-dispatching thread:
		// creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				juego2.createAndShowGUI();
			}
		});
	}

	public Baraja getBaraja() {
		return baraja;
	}

	public void setBaraja(Baraja baraja) {
		this.baraja = baraja;
	}
	
	

}
