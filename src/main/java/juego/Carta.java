package juego;

public class Carta {

	private String nombre;
	private Carta pareja;
	private String imagen;

	public Carta(String nombre, String pareja, String pathToImage) {
		this.nombre = nombre;
		if (pareja != null)
			this.pareja = new Carta(pareja, null, null);
		else
			this.pareja = null;
		this.imagen = pathToImage;
	}

	public Carta(String nombre) {
		this.nombre = nombre;
		this.pareja = null;
		this.imagen = null;
	}

	@Override
	public boolean equals(Object cartaObjeto) {

		if (cartaObjeto == null)
			return false;
		else if (!(cartaObjeto instanceof Carta))
			return false;
		else {
			Carta carta = (Carta) cartaObjeto;

			if (carta.getNombre().equals(this.getNombre()))
				return true;
			else
				return false;
		}
	}

	@Override
	public String toString() {
		return nombre + "," + pareja + "," + imagen;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Carta getPareja() {
		return pareja;
	}

	public void setPareja(Carta pareja) {
		this.pareja = pareja;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

}
