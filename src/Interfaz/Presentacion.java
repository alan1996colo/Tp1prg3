package Interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class Presentacion {

	private JFrame frame;
	
	/*** apunta a mostrar valores de suma del negocio, muestra el objetivo a sumar de el juego */
	public void mostrarValoresDeSuma() {}

	/*** decide el tamano de la matriz, restriccion a que sea cuadrado*/
	public void inputFilaColumna() {}
	
	
	/****
	 * llama a mostrar de negocio, para actualizar la pantalla con los valores que puede ver el usuario
	 * 
	 * 
	 * 
	 * ***/
	public void llamaraMostrar() {}
	/****
	 * valida un input del usuario, llama a calcular de negocios.
	 * solo puede fallar 3 veces o pierde el juego.
	 * 
	 * 
	 * 
	 * ***/
	public void validarHasta3vecesSepuedefallar() {}
	
	
	/*****
	 * valida los multiples inputs del usuario todos juntos, y si hay mas de 3 inputs mal pierde***/
	public void validarTodo() {}
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Presentacion window = new Presentacion();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Presentacion() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
