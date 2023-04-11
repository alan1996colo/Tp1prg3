package Negocio;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Negocio {

	private int tamano;
	private int[][] matrizUsuario;
	private int[][] matrizResuelta;
	private int[] resultadoSumaFila;
	private int[] resultadoSumaColumna;
	private int vidas = 3;
	private String dificultad;
	private Date horaInicio;

	/***
	 * Crea la grilla para el juego, hace una matriz cuadrada de tamañoXtamaño, con
	 * valores multiplo de 3xnivel, se crea una matriz resuelta.
	 ***/
	public Negocio(int tamano, int nivel, String dificultad) {
		if (tamano > 20) {
			tamano = 20;
		} // no queremos una matriz exageradamente grande
		this.dificultad = dificultad;
		this.tamano = tamano;

		this.matrizResuelta = crearMatrizResuelta(tamano, nivel);
		this.matrizUsuario = crearMatrizConCeros(tamano);
		this.resultadoSumaColumna = new int[tamano];
		this.resultadoSumaFila = new int[tamano];
		calcularResultadoMatrizCreadaFilaColumna();
		this.horaInicio = new Date();
	}

	public String getDificultad() { // se usan
		return dificultad;
	}

	public int getTamano() {
		return this.tamano;
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
		int[] copia = resultadoSumaFila.clone();
		return copia;
	}

	/****
	 * Devuelve una copia del array con los resultados de cada columna para que lo
	 * use la capa de presentacion
	 ***/
	public int[] getResultadosColumna() {
		int[] copia = resultadoSumaColumna.clone();
		return copia;
	}

	private BigDecimal calcularPuntaje(BigDecimal tiempo) {

		BigDecimal puntos = new BigDecimal(1000 * this.getVidas() * this.getDificultad().length());
		return puntos.divide(tiempo, 2, RoundingMode.HALF_UP);
	}

	/******
	 * Estos metodos revisan que tipo de sistema operativo se usa para conseguir el
	 * path de los archivos, soluciona los problemas de compatibilidad linux windows
	 ***/
	public static String rutaFileResultadoTxt() {
		String resourcePath = null;
		switch (System.getProperty("os.name")) {
		case "Linux":
			resourcePath = "Negocio/resultado.txt";
			break;
		case "Windows":
			resourcePath = "src\\Negocio\\resultado.txt";
			break;
		}
		return resourcePath;
	}

	/****************
	 * Revisa si la fila esta completada de forma correcta, True si, False no.
	 ******/
	public boolean isCorrectaFila(int numFila) {

		return sumarFila(numFila, this.matrizUsuario) == this.resultadoSumaFila[numFila];
	}

	/****************
	 * Revisa si la COlumna esta completada de forma correcta, True si, False no.
	 ******/
	public boolean isCorrectaColumna(int numCol) {

		return sumarColumna(numCol, this.matrizUsuario) == this.resultadoSumaColumna[numCol];
	}

	/****
	 * Escribe el nombre de usuario, fecha, hora, tiempo y puntaje en una nueva
	 * linea en el archivo resultado.txt
	 * 
	 * 
	 ****/
	public void escribirPuntaje(String nombreUsuario) {
		try {
			String ruta = rutaFileResultadoTxt();

			DateFormat dateFormat = new SimpleDateFormat("EEE, d MMM yyyy, HH:mm:ss z");

			// String dateIni = dateFormat.format(this.horaInicio);
			Date horafin = new Date();
			String dateFin = dateFormat.format(horafin);
			BigDecimal difierenciaMilis = new BigDecimal(horafin.getTime() - horaInicio.getTime());
			BigDecimal conPunto = new BigDecimal(1000);
			conPunto = difierenciaMilis.divide(conPunto);
			File file = new File(ruta);

			// Si el archivo no existe es creado
			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file, true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter p = new PrintWriter(bw);
			p.println(nombreUsuario + "  Puntos=[" + calcularPuntaje(conPunto) + "] Vidas: " + this.getVidas()
					+ " Tiempo:(" + conPunto + ") segundos, el dia {" + dateFin + "}");

			p.close();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

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
	public void agregarValoresMatriz(int[][] matrizdeValores) {
		if (gameOver())
			throw new RuntimeException("El juego ha terminado,Esto no deberia mostrarse nunca");

		for (int fil = 0; fil < this.matrizUsuario.length; fil++) {
			for (int col = 0; col < this.matrizUsuario[0].length; col++) {

				this.matrizUsuario[fil][col] = matrizdeValores[fil][col];
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
	public boolean calculartodo() {// parece que aca no es el problema de las vidas

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

				System.out.print("[" + matrizResuelta[i][j] + "]");
			}
		}
		System.out.println("\n------");
	}

	// muestra la matriz que el usuario introduzco
	public void mostrarMatrizUsuario() {
		for (int i = 0; i < matrizUsuario.length; i++) {
			System.out.println("");
			for (int j = 0; j < matrizUsuario[0].length; j++) {

				System.out.print("[" + matrizUsuario[i][j] + "]");
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

}