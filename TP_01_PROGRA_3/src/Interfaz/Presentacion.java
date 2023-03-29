package Interfaz;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.RootPaneContainer;
import javax.swing.SwingConstants;

import Negocio.Negocio;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Presentacion {
	private int hola;
	private JFrame frame;
	private int cantFilas;
	private int cantColumnas;
	

	public Presentacion(int cantFilas, int cantCol) {
		this.cantFilas= cantFilas;
		this.cantColumnas = cantCol;
		
	}
	public int getCantFilas() {
		return cantFilas;
	}

	public void setCantFilas(int cantFilas) {
		this.cantFilas = cantFilas;
	}

	public int getCantColumnas() {
		return cantColumnas;
	}

	public void setCantColumnas(int cantColumnas) {
		this.cantColumnas = cantColumnas;
	}

	private JTextField textField;
	
	

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
	public void visible() {
		frame.setVisible(true);
		
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		System.out.println("Dificultad seleccionada:"+ Negocio.getDificultad());
		JButton Calcular = new JButton("Calcular"); // lo coloco aca para poder modificar la posicion 
		frame = new JFrame();
		frame.setResizable(false); // indicamos que no manipule el usuario el tamaño de la ventana
		
		switch (Negocio.getDificultad()) {
		case "Facil":
			frame.setBounds(750, 100, 400, 400);
			Calcular.setBounds(129, 325, 89, 23);
			break;
		case "Normal":
			frame.setBounds(750, 100, 480, 500);
			Calcular.setBounds(180, 430, 89, 23);
			break;
		case "Dificil":
			frame.setBounds(750, 100, 580, 630);
			Calcular.setBounds(250, 530, 89, 23);
			break;
		}
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
//		//vamos a hacer un array de labels para mostrar resultados de columnaas
//	JLabel[] arrLabelArriba=new JLabel[Negocio.getTamano()];
//	for(int i=0; i<arrLabelArriba.length;i++) {
//		arrLabelArriba[i]=new JLabel("--");
//				arrLabelArriba[i].setText(String.valueOf(Negocio.getResultadosColumna()[i]));
//				
//		arrLabelArriba[i].setBounds(70 + (i*50), 12, 121, 33);
//		frame.getContentPane().add(arrLabelArriba[i]);
//	}
//	
//	//hagamos otro para mostrar resultados de filas
//	
//	JLabel[] arrLabelDerecha=new JLabel[Negocio.getTamano()];
//	for(int i=0; i<arrLabelDerecha.length;i++) {
//		arrLabelDerecha[i]=new JLabel("--");
//				arrLabelDerecha[i].setText(String.valueOf(Negocio.getResultadoSumaFila()[i]));
//				
//		arrLabelDerecha[i].setBounds(300, 60+ (i*50), 121, 33);
//		frame.getContentPane().add(arrLabelDerecha[i]);
//	}
	
	
		
		
	
		JTextField [][] cajas = new JTextField [Negocio.getCantFilas()][Negocio.getCantColumnas()];//pedimos el tamaño a la clase negocio, mucho mejor.
		System.out.println("Matriz :"+Negocio.getCantFilas()+"x"+Negocio.getCantFilas());
		int posY=55;
		
		
		for(int fila=0;fila<cajas.length;fila++) {
			int posX=60;
			for(int col=0;col<cajas[0].length;col++) {
				cajas[fila][col] = new JTextField();
				cajas[fila][col].setBounds(posX, posY, 50, 50);
				cajas[fila][col].setHorizontalAlignment(SwingConstants.CENTER);
				frame.getContentPane().add(cajas[fila][col]);
				posX+=50;
				 // Evento en tipeado en cada caja, si introdusco cualquier carater hago focus en la siguiente caja.
				cajas[fila][col].addKeyListener(new KeyAdapter() {
					public void keyTyped(KeyEvent e) {
						char Tipeado = e.getKeyChar();
						e.setKeyChar(Tipeado);
						var elementoActual= e.getSource();
						((JTextField) elementoActual).setText(""); // permite poner solo un numero
						((JTextField) elementoActual).transferFocus();	
					}
				});	
			}
			posY+=50;
		}
		
		
		Calcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//			neg.AgregarDatosMatriz(cajas);
//				neg.calculartodo();
//				
//				System.out.print(neg.gameOver());//revisamos si perdemos.
			}
		});
		frame.getContentPane().add(Calcular);
		
		
	}
	
}
