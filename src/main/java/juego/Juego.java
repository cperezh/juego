package juego;

public class Juego {

	private Baraja baraja;

	public Juego() {
		baraja = crearBaraja();
	}

	private Baraja crearBaraja() {

		String[] nombres = { "gato", "perro", "flor1", "flor2", "gato2", "perro2", "flor1_2", "flor2_2" };
		String[] parejas = { "gato2", "perro2", "flor1_2", "flor2_2", "gato", "perro", "flor1", "flor2" };
		String[] imagenes = { "gato.jpg", "perro.jpg", "flor.jpg", "flor2.jpg", "gato.jpg", "perro.jpg", "flor.jpg", "flor2.jpg" };

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
