package Interfaz;

import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Container;
import Negocio.Negocio;
import javax.swing.JTextArea;

public class Presentacion {

	private JFrame frmGrilla;
	private JTextField textField;
	private JTextField textField_1;
	private int cantFilas=4;
	private int cantColumnas=4;
	
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
					window.frmGrilla.setVisible(true);
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
		frmGrilla = new JFrame();
		frmGrilla.setTitle("Grilla");
		frmGrilla.setBounds(100, 100, 450, 300);
		//Container ControlHost = getContentPane();
//	int tamanoGrilla= 4;// esto despues lo transformamos en un input del usuario
//	Negocio neg =new Negocio(tamanoGrilla); //creamos el objeto negocio
//	JPanel textGrilla = new JPanel();
//	GridLayout gl=new GridLayout(tamanoGrilla,tamanoGrilla);
//	textGrilla.setLayout(gl);
//	for(int i=0;i<tamanoGrilla*tamanoGrilla;i++) {
//	textGrilla.add(new JTextField(String.valueOf("3232"),4));
//	frmGrilla.add(textGrilla);
//	}
		//sadasdasdasdad

		JTextField [][] cajas = new JTextField [cantFilas][cantColumnas];
		int posY=60;
		
		
		for(int fila=0;fila<cajas.length;fila++) {
			int posX=50;
			for(int col=0;col<cajas[0].length;col++) {
				cajas[fila][col] = new JTextField();
				cajas[fila][col].setBounds(posX, posY, 55, 38);
				frmGrilla.getContentPane().add(cajas[fila][col]);
				posX+=50;
			}
			posY+=30;
			System.out.println("hola");
			//cambio n#7
			
		}
		
	
	
	
	
		
		
		
		
		
		
//		frmGrilla.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}

}
