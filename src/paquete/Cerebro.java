package paquete;

public class Cerebro {
	//Encontramos la disposicion de las neuronas en sus respectivas capas
	//nos encontraremos posibles espacios vacios por la disposicion de la red neuronal.
	//Se intenta reflejar en esta matriz como se vería visualmente en la vida "real"
	private Neurona[][] matrizCerebro;

	
	/*
	 * 
	 * CONSTRUCTOR
	 * 
	 */
	public Cerebro(Neurona[][] matrizCerebro) {
		super();
		this.matrizCerebro = matrizCerebro;
		
	}

	
	
	
	/*
	 * 
	 * GETTERS/SETTERS
	 * 
	 */
	public Neurona[][] getMatrizCerebro() {
		return matrizCerebro;
	}

	public void setMatrizCerebro(Neurona[][] matrizCerebro) {
		this.matrizCerebro = matrizCerebro;
	}
	
	
	
	
	
}
