package Punto;

public class Pruebas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Punto punto1 = new Punto();
		Punto punto2 = new Punto(0,0);
		
		if(punto1 == punto2) 
			System.out.println("Son iguales");
		else
			System.out.println("Son diferentes");
		
		System.out.println(punto1);//Muestra la direccion de memoria de la variable.
		System.out.println(punto2);
	}

}
