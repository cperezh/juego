package juego;

import java.util.ArrayList;
import java.util.List;

import util.MyMaths;

public class Baraja {

	private List<Carta> cartas = new ArrayList<Carta>();

	public Baraja(String[] nombres,String[] parejas,String[] imagenes) {
		
		//Creamos la baraja
		for (Integer i = 0; i < nombres.length; i++) {
			
			Carta carta = new Carta(nombres[i],parejas[i],imagenes[i]);
			
			cartas.add(carta);
		}
	}
	
	/**
	 * 
	 */
	public void barajear(){
		
		Carta temp;
		
		for (int i=0;i<10;i++){
		
			int posicion1 = MyMaths.random()%cartas.size();
						
			int posicion2 = MyMaths.random()%cartas.size();
			
			temp = cartas.get(posicion1);
			
			cartas.set(posicion1, cartas.get(posicion2));
			
			cartas.set(posicion2,temp);
		}
		
	}

	public List<Carta> getCartas() {
		return cartas;
	}

	public void setCartas(List<Carta> cartas) {
		this.cartas = cartas;
	}
	
	

}
