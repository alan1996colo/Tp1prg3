package Negocio;

import java.util.*;

public class Negocio {

	private int tamano;
	private int[][] matrizUsuario;
	private int[][] matrizResuelta;
	private int[] resultadoSumaFila;
	private int[] resultadoSumaColumna;
	private int vidas = 3;

	/****
	 * Por defecto crea una matriz de 4x4 con nivel 1.
	 ***/
	public Negocio() {
		this.tamano = 4;
		this.matrizResuelta = crearMatrizResuelta(tamano, 1);
		this.matrizUsuario = crearMatrizConCeros(tamano);
		this.resultadoSumaColumna = new int[tamano];
		this.resultadoSumaFila = new int[tamano];
		calcularResultadoMatrizCreadaFilaColumna();
	}

	/****
	 * Por defecto crea una matriz con nivel 1 si no se ingresa parametro nivel.
	 ***/
	public Negocio(int tamano) {
		if (tamano > 20) {
			tamano = 20;
		} // no queremos una matriz exageradamente grande
		this.tamano = tamano;
		this.matrizResuelta = crearMatrizResuelta(tamano, 1);
		this.matrizUsuario = crearMatrizConCeros(tamano);
		this.resultadoSumaColumna = new int[tamano];
		this.resultadoSumaFila = new int[tamano];
		calcularResultadoMatrizCreadaFilaColumna();
	}

	/***
	 * Crea la grilla para el juego, hace una matriz cuadrada de tamañoXtamaño, con
	 * valores multiplo de 3xnivel, se crea una matriz resuelta.
	 ***/
	public Negocio(int tamano, int nivel) {
		if (tamano > 20) {
			tamano = 20;
		} // no queremos una matriz exageradamente grande
		this.tamano = tamano;
		this.matrizResuelta = crearMatrizResuelta(tamano, nivel);
		this.matrizUsuario = crearMatrizConCeros(tamano);
		this.resultadoSumaColumna = new int[tamano];
		this.resultadoSumaFila = new int[tamano];
		calcularResultadoMatrizCreadaFilaColumna();
	}

	/****
	 * muestra cuantas vidas le quedan al usuario
	 ***/
	public int getVidas() {
		return this.vidas;
	}

	/****
	 * Devuelve una copia del array con los resultados de cada fila para que lo use
	 * la capa de presentacion
	 ***/

	public int[] getResultadoSumaFila() {
		int[] copia = this.resultadoSumaFila.clone();
		return copia;
	}

	/****
	 * Devuelve una copia del array con los resultados de cada columna para que lo
	 * use la capa de presentacion
	 ***/
	public int[] getResultadosColumna() {
		int[] copia = this.resultadoSumaColumna.clone();
		return copia;
	}

	/***
	 * Este metodo devuelve True si el input podria ser valido(en este momento), y
	 * false si el input esta equivocado Se puede usar esta funcion para colorear el
	 * numero en verde o en rojo ---ATENCION: este metodo no verifica que el input
	 * sea definitivamete correcto, solo parcialmente con los datos del momento
	 *****/
	public boolean validarInput(int input, int coordy, int coordx) {
		if (input < 1 || coordy < 0 || coordx < 0 || coordx >= this.tamano || coordy >= this.tamano) {// no queremos
																										// inputs de
																										// naturaleza
																										// invalida

			return false;

		}
		// si el input es mayor a la suma de esa fila o columna - la cantidad de lugares
		// disponibles -1,
		// es un input malo porque solo son validos valores mayores iguales a 1 los que
		// se pueden completar en otras coordenadas
		if (input > this.resultadoSumaColumna[coordx] - (this.tamano - 1)) {
			return false;
		}
		if (input > this.resultadoSumaFila[coordy] - (this.tamano - 1)) {
			return false;
		}
		if (sumarFila(coordy, this.matrizUsuario) + input > this.resultadoSumaFila[coordy]) {
			// si el input del usuario masel resto de inputs de usuario da mayor a el
			// resultado a llegar, entonces es un input malo
			return false;
		}
		if (sumarColumna(coordx, this.matrizUsuario) + input > this.resultadoSumaColumna[coordx]) {
			// si el input del usuario masel resto de inputs de usuario da mayor a el
			// resultado a llegar, entonces es un input malo
			return false;
		}
		// si pasa todo entonces el inputs es parcialmente valido
		return true;
	}

	/*****
	 * Para uso de la capa de presentacion, debe revisar esta funcion antes de nada
	 * Si las vidas llegan a cero, se perdio el juego , entonces gameOver devuelve
	 * True Si las vidas estan en 1,2,3 etc , entonces sigue participando, entonces
	 * gameOver devuelve False
	 * 
	 * .
	 ***/
	public boolean gameOver() {
		if (this.vidas <= 0) {
			return true;
		}
		return false;
	}

	/***
	 * Crea una matriz resuelta
	 ***/
	private int[][] crearMatrizResuelta(int tamano, int nivel) {
		int matriz[][] = new int[tamano][tamano];
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				matriz[i][j] = valorAleatorioNivel(nivel);
			}
		}
		return matriz;
	}

	/****
	 * Crea una matriz con puros ceros para que despues la vaya modificando el
	 * usuario.
	 ***/
	private int[][] crearMatrizConCeros(int tamano) {
		int[][] ret = new int[tamano][tamano];
		for (int i = 0; i < ret.length; i++) {
			for (int j = 0; j < ret.length; j++) {
				ret[i][j] = 0;
			}
		}
		return ret;
	}

	private void calcularResultadoMatrizCreadaFilaColumna() {
		for (int i = 0; i < this.tamano; i++) {
			this.resultadoSumaFila[i] = sumarFila(i, this.matrizResuelta);
			this.resultadoSumaColumna[i] = sumarColumna(i, this.matrizResuelta);
		}
	}

	private int valorAleatorioNivel(int nivel) {
		return (int) (Math.random() * nivel * 3 + 1);
	}

	// Agrega los input a la matriz de usuario
	public void agregarValoresMatriz(int posx, int posy, int valor)  {
		if (gameOver())
			throw new RuntimeException(
					"El juego ha terminado,Esto no deberia mostrarse nunca");
		if (posx < 0)
			throw new IllegalArgumentException("No existen posiciones negativas " + posx);
		if (posy < 0)
			throw new IllegalArgumentException("No existen posiciones negativas " + posy);
		if (valor <= 0)
			throw new IllegalArgumentException("No se permiten valores negativos o iguales a cero " + valor);

		for (int fil = 0; fil < this.matrizUsuario.length; fil++) {
			for (int col = 0; col < this.matrizUsuario[0].length; col++) {
				if (fil == posx && col == posy) {
					this.matrizUsuario[fil][col] = valor;
				}
			}
		}
	}

	private int sumarFila(int numFila, int[][] matriz) {
		int sumatoria = 0;
		int cantCol = matriz.length;
		for (int i = 0; i < cantCol; i++) {
			sumatoria = sumatoria + matriz[numFila][i];
		}
		return sumatoria;
	}

	private int sumarColumna(int numCol, int matriz[][]) {
		int sumatoria = 0;
		int cantFil = matriz[0].length;
		for (int i = 0; i < cantFil; i++) {
			sumatoria = sumatoria + matriz[i][numCol];
		}
		return sumatoria;
	}

	/***
	 * valida todos los inputs del usuario que haya puesto hasta el momento Si los
	 * valores ingresados a la matriz de usuario cumplen las sumas solicitadas,
	 * entonces devuelve true de lo contrario la matriz es incorrecta y esta mal
	 * hecha y mostrara false. Si el el usuario se equivoca, le resta una vida
	 **/
	public boolean calculartodo() {
		for (int z = 0; z < this.tamano; z++) {
			if (sumarFila(z, this.matrizUsuario) != this.resultadoSumaFila[z]) {
				this.vidas = vidas - 1;
				return false;
			}
			if (sumarColumna(z, this.matrizUsuario) != this.resultadoSumaColumna[z]) {
				this.vidas = vidas - 1;
				return false;
			}
			// Si alguna fila o alguna columna no da igual a lo antes calculado, entonces
			// esta mal
		}
		// de lo contrario esta bien hecho
		return true;
	}

	/***
	 * Muestra los valores objetivos a los que hay que llegar de lateral derecho y
	 * abajo
	 */
	public void mostrarValoresDesuma() {
		for (int n : this.resultadoSumaFila) {
			System.out.println("suma fila " + n);
		}
		for (int j : this.resultadoSumaColumna) {
			System.out.println("suma columna " + j);
		}
	};

	/**
	 * muestra por terminal la matriz resuelta, este metodo hay que quitarlo
	 * despues, porque es solo para los desarrolladores.
	 */
	public void mostrar() {
		for (int i = 0; i < this.matrizResuelta.length; i++) {
			System.out.println("");
			for (int j = 0; j < this.matrizResuelta[0].length; j++) {

				System.out.print(matrizResuelta[i][j]);
			}
		}
		System.out.println("\n------");
	}

	/****
	 * Retorna una copia de la matriz de Usuario, para que la capa de presentacion
	 * puede ir muestreando al user esta copia no va afectar la matriz real, por lo
	 * tanto recomiendo usarla solo para mostrar y no intentar interactuar seteando
	 * valores o lo que sea
	 ***/
	public int[][] dameMatrizUsuarioParcial() {
		int[][] copia = this.matrizUsuario.clone();
		return copia;
	}

	public static void main(String[] args) {
	}

}
