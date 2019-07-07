package paquete;

public class DerivadaParcial {

	/*
	 * 
	 * CONSTRUCTOR
	 * 
	 */
	public DerivadaParcial() {
		
	}
	
	
	/*
	 * 
	 * METODOS
	 * 
	 */
	public static float derivada(float w, float y) {
		//Derivada Parcial de W(peso de la neurona)
		return (float) (Math.cos(w+y)-Math.tan(w/y));
	}
	
}
