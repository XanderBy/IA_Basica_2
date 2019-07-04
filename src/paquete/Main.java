package paquete;

public class Main {

	public static void main(String[] args) {
		int numeroentradasIniciales=2;
		int numeroSalidas=1;
		float [] entradas= {1,1,0,1,1,0,0,0};
		float [] salidas= {1,0,1,0};
		
		//Disposicion de la red neuronal
		//x 	x		0
		//x		x		x
		//0		x		0
		//Neurona neurona;
		Cerebro cerebro=new Cerebro((float) 0.4,2,1,3, entradas, salidas, numeroentradasIniciales, numeroSalidas);
		
	}

}
