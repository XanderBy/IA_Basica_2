package paquete;

public class Main {

	public static void main(String[] args) {
		int [] entradas= {1,1,0,1,1,0,0,0};
		int [] salidas= {1,0,1,0};
		
		//Disposicion de la red neuronal
		//x 	x		0
		//x		x		x
		//0		x		0
		//Neurona neurona;
		Cerebro cerebro=new Cerebro((float) 0.4,2,1,3);
		
	}

}
