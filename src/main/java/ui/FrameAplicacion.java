package ui;

import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import juego.Juego;

@SuppressWarnings("serial")
public class FrameAplicacion extends JFrame {

	//TODO: Move to a properties
	public static final String rutaImagenes = "images/";
	
	private Juego juego;
	private List<PanelCarta> panelesCartas;
	private PanelCarta panelPulsado;

	public FrameAplicacion(String nombre) {

		super(nombre);

		juego = new Juego();

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

		panelesCartas = new ArrayList<PanelCarta>(juego.getBaraja().getCartas().size());

		// Creo los paneles
		for (Integer i = 0; i < juego.getBaraja().getCartas().size(); i++) {

			PanelCarta panelCarta = new PanelCarta(juego.getBaraja().getCartas().get(i), this);

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
	}

	public PanelCarta getPanelPulsado() {
		return panelPulsado;
	}

	public void setPanelPulsado(PanelCarta panelPulsado) {
		this.panelPulsado = panelPulsado;
	}

	public List<PanelCarta> getPanelesCartas() {
		return panelesCartas;
	}

	public void setPanelesCartas(List<PanelCarta> panelesCartas) {
		this.panelesCartas = panelesCartas;
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
