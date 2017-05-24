package juego;

import java.util.ArrayList;
import java.util.List;

public class Baraja {

	private List<Carta> cartas = new ArrayList<Carta>();

	public Baraja(String[] nombres,String[] parejas,String[] imagenes) {
		
		//Creamos la baraja
		for (Integer i = 0; i < nombres.length; i++) {
			
			Carta carta = new Carta(nombres[i],parejas[i],imagenes[i]);
			
			cartas.add(carta);
		}
	}

	public List<Carta> getCartas() {
		return cartas;
	}

	public void setCartas(List<Carta> cartas) {
		this.cartas = cartas;
	}
	
	

}
