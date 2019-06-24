package paquete;

public class Neurona {
	//Umbral de la neurona
	public float umbral;
	//Array con todas las entradas a dicha neurona
	public float[] entradas;
	//Pesos que irian acompañando a las entradas de la neurona
	public float[] pesos;
	//Valores salientes de la neurona
	public float[] salidas;
	//capa de la neurona
	public int capa;
	//Pesos que irian acompañando a las entradas de la neurona
	public float[] pesosAntiguos;
	
	
	/*
	 * 
	 * CONSTRUCTOR
	 * 
	 */
	public Neurona(float umbral, float[] entradas, float[] pesos, float[] salidas, int capa) {
		super();
		this.umbral = umbral;
		this.entradas = entradas;
		this.pesos = pesos;
		this.salidas = salidas;
		this.capa=capa;
		this.pesosAntiguos=pesos;
		
		//this.sigmoide();
	}
	
	/*
	 * 
	 * METODOS
	 * 
	 */
	
	//En este metodo Hacemos los calculos basicos de las entradas
	//Siendo siempre en las capas iniciales
	public float calculoXCapasIniciales() {
		float x=0;
				
		for (int i = 0; i < this.entradas.length; i++) {
			x=x+this.entradas[i];
		}
		return x;
	}	
	//En este metodo Hacemos los calculos basicos de las entradas con sus pesos y entradas a la neurona y umbral
	//Siendo siempre en las capas intermedias y finales
	public float calculoXCapasIntermediasFinales() {
		float x=0;
		
		for (int i = 0; i < this.entradas.length; i++) {
			x=x+(this.entradas[i]*this.pesos[i]);
		}
		x=x+this.umbral;
		return x;
	}
	
	
	//Realizamos la funcion sigmoide con los datos del metodo anterior, e introduciendo los en el array de salida
	public void sigmoide() {
		float f=0;
		
		if(capa==0) {
			f=(float) (1 / (1 + Math.exp(-this.calculoXCapasIniciales())));
		}else {
			f=(float) (1/( 1 + Math.exp(-this.calculoXCapasIntermediasFinales())));
		}
		
		
		for (int i = 0; i < this.salidas.length; i++) {
			this.salidas[i]=f;
		}
		
	}
	
	/*
	 * 
	 * GETTERS/SETTERS
	 * 
	 */
	public float getUmbral() {
		return umbral;
	}
	public void setUmbral(float umbral) {
		this.umbral = umbral;
	}
	public float[] getEntradas() {
		return entradas;
	}
	public void setEntradas(float[] entradas) {
		this.entradas = entradas;
	}
	public float[] getPesos() {
		return pesos;
	}
	public void setPesos(float[] pesos) {
		this.pesos = pesos;
	}
	public float[] getSalidas() {
		return salidas;
	}
	public void setSalidas(float[] salidas) {
		this.salidas = salidas;
	}

	public float[] getPesosAntiguos() {
		return pesosAntiguos;
	}

	public void setPesosAntiguos(float[] pesosAntiguos) {
		this.pesosAntiguos = pesosAntiguos;
	}
	
	
	
	
}
