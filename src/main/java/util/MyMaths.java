package util;

public class MyMaths {

	/**
	 * Devuelve un entero aleatorio entre 0 y 100
	 * @return
	 */
	public static int random(){
		
		int aleatorio = new Double((Math.random()*100)).intValue();
		
		return aleatorio;
	}
}
