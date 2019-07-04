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

	//Numero entradas Iniciales
	private int numeroentradasIniciales;
	//Numero Salida
	private int numeroSalidas;
	//Numero Prueba
	private int numeroPruebaActual=0;
	/*
	 * 
	 * CONSTRUCTOR
	 * 
	 */
	public Cerebro(float tasaAprendizaje, int nEntradas, int nSalidas, int nCapas, float[] entradas,
			float[] salidasDeseadas, int numeroentradasIniciales, int numeroSalidas) {
		super();
		this.numeroentradasIniciales=numeroentradasIniciales;
		this.numeroSalidas=numeroSalidas;
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
		int contadorPrimeraCapa = 0,contadorUltimaCapa=0;
		
		for (int i = 0; i < this.matrizCerebro.length; i++) {
			for (int j = 0; j < this.matrizCerebro[i].length; j++) {
				if (i == 0) {

					neurona = new Neurona(0, new float[1], new float[0], new float[this.matrizCerebro[i + 1].length],
							0);
					this.matrizCerebro[0][j] = neurona;
					this.matrizCerebro[0][j].entradas[0] = this.entradas[contadorPrimeraCapa];
					this.matrizCerebro[0][j].sigmoide();
					contadorPrimeraCapa++;
					if (contadorPrimeraCapa == this.nEntradas) {
						break;
					}
				} else if (i < (this.matrizCerebro.length - 1)) {
					// Inicializamos las demas intermedias
					if (this.nEntradas < 3) {
						neurona = new Neurona(1, new float[3], new float[3],
								new float[this.matrizCerebro[i + 1].length], i);
						float[] pesosNeurona = new float[3];
						for (int k = 0; k < pesosNeurona.length; k++) {
							pesosNeurona[k] = (float) Math.random() * 1;
						}
						neurona.pesos = pesosNeurona;
						neurona.pesosAntiguos = pesosNeurona;
					} else {
						neurona = new Neurona(1, new float[this.nEntradas], new float[this.nEntradas],
								new float[this.matrizCerebro.length], i);
						float[] pesosNeurona = new float[this.nEntradas];
						for (int k = 0; k < pesosNeurona.length; k++) {
							pesosNeurona[k] = (float) Math.random() * 1;
						}
						neurona.pesos = pesosNeurona;
						neurona.pesosAntiguos = pesosNeurona;
					}

					this.matrizCerebro[i][j] = neurona;

					for (int j2 = 0; j2 < this.matrizCerebro[i][j].entradas.length; j2++) {
						this.matrizCerebro[i][j].entradas[j2] = this.entradas[j2];
					}
					this.matrizCerebro[i][j].sigmoide();
				} else if(i == (this.matrizCerebro.length - 1) && nSalidas!=contadorUltimaCapa) {
					contadorUltimaCapa++;
					// Ultima Capa
					System.out.println("ULTIMA CAPA");
					if (this.nEntradas < 3) {
						neurona = new Neurona(1, new float[3], new float[3], new float[this.nSalidas],
								i);
						float[] pesosNeurona = new float[3];
						for (int k = 0; k < pesosNeurona.length; k++) {
							pesosNeurona[k] = (float) Math.random() * 1;
						}
						neurona.pesos = pesosNeurona;
						neurona.pesosAntiguos = pesosNeurona;
					} else {
						neurona = new Neurona(1, new float[this.nEntradas], new float[this.nEntradas],
								new float[this.nSalidas], i);
						float[] pesosNeurona = new float[this.nEntradas];
						for (int k = 0; k < pesosNeurona.length; k++) {
							pesosNeurona[k] = (float) Math.random() * 1;
						}
						neurona.pesos = pesosNeurona;
						neurona.pesosAntiguos = pesosNeurona;
					}

					this.matrizCerebro[i][j] = neurona;

					for (int j2 = 0; j2 < this.matrizCerebro[i][j].entradas.length; j2++) {
						this.matrizCerebro[i][j].entradas[j2] = this.entradas[j2];
					}
					this.matrizCerebro[i][j].sigmoide();
					this.salida = this.matrizCerebro[i][j].salidas;
				}

			}
		}
		System.out.println(this.toStringCerebro());
		System.out.println("Inicializar "+this.toStringSalida());
		this.aprender();
		
	}

	// En este metodo lo que hariamos es hacemos los calculos de las neuronas, vemos
	// si
	// la salida del cerebro es correcta, si no es corregimos los valores de los
	// pesos.
	public void aprender() {
		//Entradas  1 2
		//Salidas 1
		
		/*int aux=this.numeroPruebaActual;
		for (int i = 0; i < this.numeroSalidas; i++) {
			if(this.salida[i]==this.salidasDeseadas[aux]) {
				
			}
			aux=aux*;
		}*/
		
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
	public float corregir(float Aw, float e) {
		// Aqui hariamos Nw= Aw - tasaAprendizaje * E
		float Nw= Aw - this.tasaAprendizaje * e;
		return Nw;
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

	public String toStringSalida() {
		String info = "Cerebro Salida:";

		for (int i = 0; i < this.salida.length; i++) {
			try {
				info = info + " " + this.salida[i];
			} catch (NullPointerException e) {
				// TODO: handle exception
			}

		}

		return info;
	}
}
