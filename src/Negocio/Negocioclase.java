package Negocio;
import java.util.*;


public class Negocioclase {
	
	private int tamano;
	private static int tamMatriz=4;
	private static int filas= 3;
	private static int columnas=3;
	private static int[][] matrizValores = new int [filas][columnas];
	
	
	//hashmapo array inputs del usuario.
	public Negocioclase() {
		// TODO Auto-generated constructor stub
	}
	
	public boolean validarInput(int input, int coordy,int coordx) {return false;}
	public Negocioclase(int tamano) {
		this.tamano=tamano;
		//for que crea la matriz,
		
	}
	
	/*****
	 *
	 * 
	 * va contando cuantas veces el usuario uso calcular, o valido su dato y si llega a 3 pierde y se termina el juego.***/
	public void gameOver() {}
	
	
	
	
	// Agrega los input a la matriz
	public static int[][] agregarValoresMatriz(int posx, int posy ,int valor){
		
		
		for(int fil=0;fil<matrizValores.length;fil++) {
			for(int col=0;col<matrizValores[0].length;col++) {
				if(fil==posx && col==posy) {
					matrizValores[fil][col] = valor;
				}
			}
		}
		return matrizValores;
	}
	 public int calcular(int cantFilas ,int cantColum, int []valoresAcompararFila,int []valoresAcompararCol ){
		 ArrayList
		 for(int i=0;i<tamMatriz;i++) {
			  
		 }
		 
		 
	 }
	
	
	
	
	
	
	public static int sumarFila(int numFila) {
		int sumatoria = 0;
		int cantCol=matrizValores.length;
		for(int i=0;i<cantCol;i++) {
			sumatoria= sumatoria + matrizValores[numFila][i];
		}
		return sumatoria;
	}
	public static int sumarColumna(int numCol ) {
		int sumatoria = 0;
		int cantFil = matrizValores[0].length;
		for(int i=0;i<cantFil;i++) {
			sumatoria = sumatoria + matrizValores[i][numCol];
		}
		return sumatoria;
	}
	
	/*** valida todos los inputs del usuario que haya puesto hasta el momento**/
	public void  calculartodo() {}



	
	
	
	/*** Muestra los valores objetivos a los que hay que llegar de lateral derecho y abajo*/ 
	public	void mostrarValoresDesuma(){};
	/** Solo muestra los numeros que se van desbloqueando continuamente*/
	public void mostrar() {}
	
	
	public static void main(String[] args) {
		
		
		
		
		agregarValoresMatriz(0, 0, 1);
		agregarValoresMatriz(0, 1, 2);
		agregarValoresMatriz(0, 2, 3);
		agregarValoresMatriz(1, 0, 2);
		agregarValoresMatriz(1, 1, 2);
		agregarValoresMatriz(1, 2, 1);
		agregarValoresMatriz(2, 0, 2);
		agregarValoresMatriz(2, 1, 3);
		agregarValoresMatriz(2, 2, 2);
		
		System.out.println(sumarFila(0));

	}
	
	
}


