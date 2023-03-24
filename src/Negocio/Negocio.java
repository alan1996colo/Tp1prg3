package Negocio;
import java.util.*;


public class Negocio {
	
	private int tamano;
	private int tamMatriz=4;
	private  int filas= 3;
	private  int columnas=3;
	private  int[][] matrizUsuario = new int [filas][columnas];
	private int[][] matrizResuelta;
	private int[] resultadoSumaFila=new int[3];
	private int[] resultadoSumaColumna=new int[3];//ver como inicializar sin tener que poner un valor
	
	
	//hashmapo array inputs del usuario.
	
	/****Por defecto crea una matriz de 4x4 con nivel 1.
	 * ***/	
	public Negocio() {
		this.tamano=4;
		this.matrizResuelta=crearMatrizResuelta(tamano,1);
		this.matrizUsuario=crearMatrizConCeros(tamano);
		
		
	}
	/****Por defecto crea una matriz con nivel 1 si no se ingresa parametro nivel.
	 * ***/	
	public Negocio(int tamano) {
		this.tamano=tamano;
		this.matrizResuelta=crearMatrizResuelta(tamano,1);
		this.matrizUsuario=crearMatrizConCeros(tamano);
	}
	/***Crea la grilla para el juego, hace una matriz cuadrada de tamañoXtamaño, con valores multiplo de 3xnivel, se crea una matriz resuelta.
	 * ***/	
	public Negocio(int tamano,int nivel) {
		this.tamano=tamano;
		this.matrizResuelta=crearMatrizResuelta(tamano,nivel);
		this.matrizUsuario=crearMatrizConCeros(tamano);
	}
	
	public boolean validarInput(int input, int coordy,int coordx) {return false;}
	
	
	/*****
	 *
	 * 
	 * va contando cuantas veces el usuario uso calcular, o valido su dato y si llega a 3 pierde y se termina el juego.***/
	public void gameOver() {}
	
	/***
	 * Crea una matriz resuelta
	 * ***/
	private int[][] crearMatrizResuelta(int tamano, int nivel) {
		int matriz[][]= new int[tamano][tamano];
		for (int i=0;i<matriz.length;i++) {
			for(int j=0;j<matriz[i].length;j++) {
				matriz[i][j]=valorAleatorioNivel(nivel);	
			}	
		}	
		return matriz;
		}
	
	
	/**** Crea una matriz con puros ceros para que despues la vaya modificando el usuario.
	 * ***/
	private int[][] crearMatrizConCeros(int tamano){
		int[][] ret=new int [tamano][tamano];
		for(int i=0;i<ret.length;i++) {
			for(int j=0;j<ret.length;j++){
				ret[i][j]=0;
			}
		}
		return ret;
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
	public void agregarValoresMatriz(int posx, int posy ,int valor){
		
		for(int fil=0;fil<this.matrizUsuario.length;fil++) {
			for(int col=0;col<this.matrizUsuario[0].length;col++) {
				if(fil==posx && col==posy) {
					this.matrizUsuario[fil][col] = valor;
				}
			}
		}
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
		

	//	System.out.println(valorAleatorioNivel(2));
		//System.out.println(sumarFila(0));

	
	}
	
	
}

