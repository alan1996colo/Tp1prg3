package Negocio;
import java.util.*;


public class Negocio {
	
	private int tamano;
	private static int tamMatriz=4;
	private static int filas= 3;
	private static int columnas=3;
	private static int[][] matrizValores = new int [filas][columnas];
	private int[][] matrizResuelta;
	private int[] resultadoSumaFila=new int[3];
	private int[] resultadoSumaColumna=new int[3];//ver como inicializar sin tener que poner un valor
	
	
	//hashmapo array inputs del usuario.
	public Negocio() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public boolean validarInput(int input, int coordy,int coordx) {return false;}
	public Negocio(int tamano) {
		this.tamano=tamano;
		//for que crea la matriz,
		
	}
	
	/*****
	 *
	 * 
	 * va contando cuantas veces el usuario uso calcular, o valido su dato y si llega a 3 pierde y se termina el juego.***/
	public void gameOver() {}
	
	private void crearMatrizResuelta(int tamano, int nivel) {
		int matriz[][]= new int[tamano][tamano];
		for (int i=0;i<matriz.length;i++) {
			for(int j=0;j<matriz[i].length;j++) {
				matriz[i][j]=valorAleatorioNivel(nivel);
				
			}
		
			
		}
		
		this.matrizResuelta=matriz;
		
		
	}
	private void calcularResultadoMatrizCreadaFilaColumna() {
		for(int i =0;i<this.tamano;i++) {
			this.resultadoSumaFila[i]=sumarFila(i,this.matrizResuelta);
			this.resultadoSumaColumna[i]=sumarColumna(i,this.matrizResuelta);
		}
		
		
		
	}
	
	
private int valorAleatorioNivel(int nivel) {
		return (int)(Math.random()*nivel*3+1);
		
	}
	
	
	
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
	/* public int calcular(int cantFilas ,int cantColum, int []valoresAcompararFila,int []valoresAcompararCol ){
		 ArrayList
		 for(int i=0;i<tamMatriz;i++) {
			  
		 }
		 
		 
	 }*/
	
	
	
	
	
	
	private int sumarFila(int numFila, int [][]matriz ){
		int sumatoria = 0;
		int cantCol=matriz.length;
		for(int i=0;i<cantCol;i++) {
			sumatoria= sumatoria + matriz[numFila][i];
		}
		return sumatoria;
	}
	private int sumarColumna(int numCol,int matriz[][] ) {
		int sumatoria = 0;
		int cantFil = matriz[0].length;
		for(int i=0;i<cantFil;i++) {
			sumatoria = sumatoria + matriz[i][numCol];
		}
		return sumatoria;
	}
	
	/*** valida todos los inputs del usuario que haya puesto hasta el momento**/
	public void  calculartodo() {}



	
	
	
	/*** Muestra los valores objetivos a los que hay que llegar de lateral derecho y abajo*/ 
	public	void mostrarValoresDesuma(){
		for(int n :this.resultadoSumaFila) {System.out.println("suma fila "+n);}
		for(int  j:this.resultadoSumaColumna) {System.out.println("suma columna "+j);}
		
		
		
	};
	/** Solo muestra los numeros que se van desbloqueando continuamente*/
	public void mostrar() {
		int cont=0;
		for (int i=0;i<this.matrizResuelta.length;i++) {
			System.out.println("");
			for(int j=0;j<this.matrizResuelta[0].length;j++) {
			
					System.out.print(matrizResuelta[i][j]);
			}}
		}
	
	
	
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
	//	System.out.println(valorAleatorioNivel(2));
		//System.out.println(sumarFila(0));

		Negocio n=new Negocio(3);
		n.crearMatrizResuelta(3, 1);
		n.mostrar();
		n.calcularResultadoMatrizCreadaFilaColumna();
		n.mostrarValoresDesuma();
	}
	
	
}


