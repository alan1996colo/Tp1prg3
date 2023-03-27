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
		
		
		frame = new JFrame();
		frame.setResizable(false); // indicamos que no manipule el usuario el tamaño de la ventana
		frame.setBounds(100, 100, 350, 368);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		
	
		JTextField [][] cajas = new JTextField [cantFilas][cantColumnas];
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
		
		JButton Calcular = new JButton("Calcular");
		Calcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Negocio negocio =new Negocio();
				negocio.AgregarDatosMatriz(cajas);
				System.out.println(negocio.calculartodo());
		
				
				
				
			
				
			}
		});
		Calcular.setBounds(129, 295, 89, 23);
		frame.getContentPane().add(Calcular);
		
		
		
		
	}

	
}
