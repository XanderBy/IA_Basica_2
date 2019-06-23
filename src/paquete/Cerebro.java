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
	 * METODOS
	 * 
	 */
	
	//En este metodo lo que hariamos es hacemos los calculos de las neuronas, vemos si
	//la salida del cerebro es correcta, si no es corregimos los valores de los pesos.	
	public void aprender() {
		
	}
	
	//En este metodo lo que hacemos es corregir los pesos de cada neurona haciendo lo
	//mediante derivadas parciales con los pesos.
	public float corregir() {
		//Aqui hariamos Nw= Aw - tasaAprendizaje * E
		return 0;
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
