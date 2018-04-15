package juego;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import ui.FrameAplicacion;
import util.PropertiesUtil;

public class Juego {
	
	private static final String barajaProperties = FrameAplicacion.properties + "baraja.prop";
	
	private Baraja baraja;
	
	private Properties barajaProp;

	public Juego() throws FileNotFoundException,IOException {
		
		barajaProp = PropertiesUtil.loadProperties(barajaProperties);
		
		baraja = crearBaraja(barajaProp);
	}

	private Baraja crearBaraja(Properties barajaProp)  {
		
		String[] nombres = barajaProp.getProperty("nombres").split(",");
		String[] parejas = barajaProp.getProperty("parejas").split(",");
		String[] imagenes = barajaProp.getProperty("imagenes").split(",");
		
		Baraja baraja = new Baraja(nombres, parejas, imagenes);

		return baraja;

	}

	public Baraja getBaraja() {
		return baraja;
	}

	public void setBaraja(Baraja baraja) {
		this.baraja = baraja;
	}
	
	

}
