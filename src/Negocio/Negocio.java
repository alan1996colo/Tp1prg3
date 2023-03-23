package Negocio;
import java.util.*;
public class Negocio {
	
	int tamano;
	int nivel;//para cuando implementemos el sistema por niveles
	int matriz[][];
	//hashmapo array inputs del usuario.
	
	public boolean validarInput(int input, int coordy,int coordx) {return false;}
	public Negocio(int tamano,int nivel) {
		this.tamano=tamano;
		this.nivel=nivel;
		//for que crea la matriz,
		matriz=new int[tamano+1][tamano+1];
		
		
	}
	public Negocio(int tamano) {//constructor sin setear nivel, se posiciona en 1.
		this.tamano=tamano;
		this.nivel=1;
		//for que crea la matriz,
		matriz=new int[tamano+1][tamano+1];
		
		
	}
	
	
	
	public Negocio() {
		//for que crea la matriz,
		
	}
	
	

	/***elije valores pseudo aleatorios para la suma pasando algun parametro maximo, 
	 * y los coloca en los laterales de la matriz.
	 * --Hay que chequear lo de los pesos de la diagonal, porque no se puede meter cualquier numero aleatorio a lo loco
	 * de lo contrario el juego no tendra solucion
	 * 
	 * 
	 * La mejor idea, es crear una matriz elijiendo completarla con numeros aleatorios, por ejemplo nivel 1 solo  numeros del 1 al 3
	 * despues hacer la suma de las filas de esa matriz, y las columnas de esa matriz, y conservar los valores de las sumas eliminando todo el contenido
	 * o solo pasar el valor de la suma a otra matriz copia sin completar, que esa es la que va llenar el usuario.
	 * ***/
private void valoresPseudoAelatoriosAsumar(int nivel) {
}
	/*****
	 *
	 * 
	 * va contando cuantas veces el usuario uso calcular, o valido su dato y si llega a 3 pierde y se termina el juego.***/
	public void gameOver() {}
	public boolean calcular(int input) {return false;}
	/*** Muestra los valores objetivos a los que hay que llegar de lateral derecho y abajo*/ 
public	void mostrarValoresDesuma(){};
	/** Solo muestra los numeros que se van desbloqueando continuamente*/
public void mostrar() {}
/*** valida todos los inputs del usuario que haya puesto hasta el momento**/
public void  calculartodo() {}

}
