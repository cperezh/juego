package ui;

import java.io.FileNotFoundException;
import java.io.IOException;

public class JuegoUI {

	/**
	 * Create the GUI and show it. For thread safety, this method should be
	 * invoked from the event-dispatching thread.
	 */
	public void createAndShowGUI() throws IOException, FileNotFoundException {

		// Create and set up the window.
		FrameAplicacion frame = new FrameAplicacion("Juego Manuel");

		// Display the window.
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {

		try {
			JuegoUI juegoui = new JuegoUI();

			System.out.println(System.getProperty("java.class.path"));

			// Schedule a job for the event-dispatching thread:
			// creating and showing this application's GUI
			javax.swing.SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					try {
						juegoui.createAndShowGUI();
					} catch (Exception e) {
						e.printStackTrace(System.out);
					}

				}
			});
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}

}
