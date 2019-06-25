package paquete;

import java.util.Arrays;

public class Cerebro {
	// Encontramos la disposicion de las neuronas en sus respectivas capas
	// nos encontraremos posibles espacios vacios por la disposicion de la red
	// neuronal.
	// Se intenta reflejar en esta matriz como se vería visualmente en la vida
	// "real"
	private Neurona[][] matrizCerebro;

	// Esta tasa es una constante para la correccion de los pesos
	private float tasaAprendizaje;

	// Salida de la red neuronal
	private float[] salida;

	// numero de entradas en la capa 0
	private int nEntradas;

	// numero de salidas de la red
	private int nSalidas;

	// numero de capas de la red
	private int nCapas;

	// Entradas reales con todos los datos
	private float[] entradas;

	// Salida correcta de la red
	private float[] salidasDeseadas;

	/*
	 * 
	 * CONSTRUCTOR
	 * 
	 */
	public Cerebro(float tasaAprendizaje, int nEntradas, int nSalidas, int nCapas, float[] entradas,
			float[] salidasDeseadas) {
		super();
		this.tasaAprendizaje = tasaAprendizaje;
		this.nEntradas = nEntradas;
		this.nSalidas = nSalidas;
		this.salida = new float[nSalidas];
		this.nCapas = nCapas;
		this.entradas = entradas;
		this.salidasDeseadas = salidasDeseadas;
		if (nEntradas < 3) {
			this.matrizCerebro = new Neurona[nCapas][3];
		} else {
			this.matrizCerebro = new Neurona[nCapas][nEntradas];
		}

		this.inicializar();
		

	}

	/*
	 * 
	 * METODOS
	 * 
	 */
	// Inicializar Cerebro
	public void inicializar() {
		Neurona neurona = new Neurona();
		int contadorPrimeraCapa=0;
		for (int i = 0; i < this.matrizCerebro.length; i++) {
			for (int j = 0; j < this.matrizCerebro[i].length; j++) {
				if (i == 0) {
					
					neurona = new Neurona(0, new float[1], new float[0],new float[this.matrizCerebro.length], 0);
					this.matrizCerebro[0][j] = neurona;
					this.matrizCerebro[0][j].entradas[0] = this.entradas[contadorPrimeraCapa];
					this.matrizCerebro[0][j].sigmoide();
					contadorPrimeraCapa++;
					if(contadorPrimeraCapa==this.nEntradas) {
						break;
					}
				}
				
			}
		}
		System.out.println(this.toStringCerebro());
	}

	// En este metodo lo que hariamos es hacemos los calculos de las neuronas, vemos
	// si
	// la salida del cerebro es correcta, si no es corregimos los valores de los
	// pesos.
	public void aprender() {

		/*
		 * float auxiliar=0; for (int i = 0; i < this.salida.length; i++) {
		 * 
		 * for (int j = 0; 0 < this.matrizCerebro.length; j++) {
		 * if(this.matrizCerebro[this.matrizCerebro.length-1][j]!=null &&
		 * this.salida[i]!=0) {
		 * 
		 * for (int j2 = this.matrizCerebro.length-1; j2 > 0 ; j2--) { for (int k = 0; k
		 * < this.matrizCerebro.length; k++) {
		 * auxiliar=auxiliar+(this.matrizCerebro[j2-1][k].salidas[k] *
		 * this.matrizCerebro[j2-1][k].pesos[k]); } }
		 * 
		 * 
		 * //this.salida[i]= //this.matrizCerebro[i][j].setSalidas(salidas); } }
		 * this.salida[i]=auxiliar; }
		 */

	}

	// En este metodo lo que hacemos es corregir los pesos de cada neurona haciendo
	// lo
	// mediante derivadas parciales con los pesos.
	public float corregir() {
		// Aqui hariamos Nw= Aw - tasaAprendizaje * E
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

	public float getTasaAprendizaje() {
		return tasaAprendizaje;
	}

	public void setTasaAprendizaje(float tasaAprendizaje) {
		this.tasaAprendizaje = tasaAprendizaje;
	}

	public String toStringCerebro() {
		String info = "Cerebro:";

		for (int i = 0; i < this.matrizCerebro.length; i++) {
			for (int j = 0; j < this.matrizCerebro[i].length; j++) {
				try {
					info = info + " " + this.matrizCerebro[i][j].toString();
				} catch (NullPointerException e) {
					// TODO: handle exception
				}

			}
		}

		return info;
	}

}
