package UI;

import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import juego.Baraja;

@SuppressWarnings("serial")
public class FrameAplicacion extends JFrame {

	public static final String rutaImagenes = "bin/images/";

	private Baraja baraja;
	private List<PanelCarta> panelesCartas;
	private PanelCarta panelPulsado;

	public FrameAplicacion(String nombre, Baraja barajaInicial) {

		super(nombre);

		baraja = barajaInicial;

		panelesCartas = crearPaneles();

		panelPulsado = null;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setLayout(new GridLayout(3, 3));

		addWindowListener(new EventosVentana(this));
	}

	/**
	 * Creamos los paneles donde alojar las cartas
	 */
	private List<PanelCarta> crearPaneles() {

		List<PanelCarta> panelesCartas;

		panelesCartas = new ArrayList<PanelCarta>(baraja.getCartas().size());

		// Creo los paneles
		for (Integer i = 0; i < baraja.getCartas().size(); i++) {

			PanelCarta panelCarta = new PanelCarta(baraja.getCartas().get(i), this);

			panelesCartas.add(panelCarta);

			this.add(panelCarta);

		}

		return panelesCartas;
	}

	public void pintarCartas() {

		// Recorro los paneles y pinto la imagen de la carta de cada panel
		for (PanelCarta panelCarta : panelesCartas) {

			panelCarta.displayImage();

		}

		//SwingUtilities.updateComponentTreeUI(this);
	}
	
	public void despusarTodosPaneles(){
		
		panelPulsado = null;
		
		for (PanelCarta panelCarta:panelesCartas){
			panelCarta.unpressImage();
		}
	}

	public PanelCarta getPanelPulsado() {
		return panelPulsado;
	}

	public void setPanelPulsado(PanelCarta panelPulsado) {
		this.panelPulsado = panelPulsado;
	}

}

class EventosVentana extends WindowAdapter {

	FrameAplicacion ventana;

	public EventosVentana(FrameAplicacion ventanaInicial) {
		this.ventana = ventanaInicial;
	}

	@Override
	public void windowOpened(WindowEvent e) {
		ventana.pintarCartas();

	}
}
