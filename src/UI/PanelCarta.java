package UI;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import juego.Carta;

@SuppressWarnings("serial")
public class PanelCarta extends JPanel {

	private Carta carta;

	private JLabel imgLabel;

	private FrameAplicacion frameAplicacion;

	private boolean desactivado;

	public PanelCarta(Carta cartaInicial, FrameAplicacion frameAplicacion) {

		this.carta = cartaInicial;

		this.imgLabel = null;

		this.frameAplicacion = frameAplicacion;

		addMouseListener(new EventosPanel(this));

	}

	public void displayImage() {

		Image imagenEscalada = new ImageIcon(FrameAplicacion.rutaImagenes + carta.getImagen()).getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH);

		imgLabel = new JLabel(new ImageIcon(imagenEscalada));

		this.add(imgLabel);
		
		SwingUtilities.updateComponentTreeUI(this);

	}

	public void displayImageOK() {
		
		desactivado = true;

		this.remove(imgLabel);

		Image imagenEscalada = new ImageIcon(FrameAplicacion.rutaImagenes + "ok.jpg").getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH);

		imgLabel = new JLabel(new ImageIcon(imagenEscalada));

		this.add(imgLabel);
		
		SwingUtilities.updateComponentTreeUI(this);


	}

	public void seleccionarPanel() {

		Border b2 = new LineBorder(Color.BLACK, 10);

		this.imgLabel.setBorder(b2);

		frameAplicacion.setPanelPulsado(this);
	}

	public void desSeleccionarPanel() {

		this.imgLabel.setBorder(null);

		frameAplicacion.setPanelPulsado(null);
	}

	public void pressPanel() {

		// Si no hay ningun panel pulsado
		if (frameAplicacion.getPanelPulsado() == null) {

			seleccionarPanel();

		}
		// Si hay algun panel seleccionado
		else {
			// Si la carta de este es la pareja del seleccionado
			
			if (carta.getPareja().equals(frameAplicacion.getPanelPulsado().getCarta())) {

				displayImageOK();

				frameAplicacion.getPanelPulsado().displayImageOK();

			}
			// Si no son pareja
			else {
				// Despulsar el pulsado y pulsar este
				
				frameAplicacion.getPanelPulsado().desSeleccionarPanel();

				seleccionarPanel();

			}
		}

	}

	public void unpressImage() {

	}

	public Carta getCarta() {
		return carta;
	}

	public void setCarta(Carta carta) {
		this.carta = carta;
	}

	public boolean isDesactivado() {
		return desactivado;
	}

	public void setDesactivado(boolean desactivado) {
		this.desactivado = desactivado;
	}

}

class EventosPanel extends MouseAdapter {

	PanelCarta panelCarta;

	public EventosPanel(PanelCarta panelCartaInit) {
		this.panelCarta = panelCartaInit;
	}

	public void mousePressed(MouseEvent me) {

		if (!panelCarta.isDesactivado())
			panelCarta.pressPanel();
	}

}