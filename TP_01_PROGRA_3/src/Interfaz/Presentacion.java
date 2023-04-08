package Interfaz;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.RootPaneContainer;
import javax.swing.SwingConstants;

import Negocio.Negocio;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.ImageIcon;

public class Presentacion {

	private JFrame frame;
	private int cantFilas;
	private int cantColumnas;
	private Negocio negocio;
	JLabel vidas = new JLabel("Vidas");
	JLabel lblVidas = new JLabel("3");
	private JLabel arrLabelArriba[];
	private JLabel arrLabelDerecha[];
	private JButton prenderApagarMusica;
	private Sonido sound;
	

	public Presentacion(Negocio neg) {
		this.negocio = neg;
		initialize();

	}

	private void crearBtnMusica() {
		prenderApagarMusica = new JButton("mute");
		prenderApagarMusica.setBackground(new Color(51, 165, 33));
		prenderApagarMusica.setFont(new Font("Tahoma", Font.BOLD, 8));
		prenderApagarMusica.setForeground(new Color(255, 255, 255));
		prenderApagarMusica.setBounds(frame.getWidth()-60, 5, 60, 32);
		prenderApagarMusica.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if(sound.getStatus().equals("play")) {
			sound.pause();}
				else {
					sound.play();
				}
			}
		});
		
		frame.getContentPane().add(prenderApagarMusica);
	}
	
	public boolean contains(JTextField cajas[][]) {
		// a implementar

		return false;

	}

	private boolean esNumeroYteclasCorrectas(char tipeado) {
		int valor = Character.getNumericValue(tipeado);
		if ((valor >= 0 && valor <= 9) || tipeado == '\n' || tipeado == '\u0008') {// modifique esta linea para que
																					// admita 10,20,30,40,etc
			// numeros finalizados en cero

			return true;

		}

		return false;
	}

	private void verificarElementosIngresados(char tipeado, Object elementosActuales, KeyEvent e) { // verifica que se
																									// ingrese
																									// correctamente los
																									// carecateres
		JTextField CaracteresIngresados = (JTextField) elementosActuales;
		if (esNumeroYteclasCorrectas(tipeado)) {
			if (CaracteresIngresados.getText().length() == 1 && tipeado == '\n') {

				e.consume(); // Evita que se ingresen más caracteres admite 1
				CaracteresIngresados.transferFocus();

			} else if (CaracteresIngresados.getText().length() == 2) {

				e.consume(); // Evita que se ingresen más caracteres admite 2
				CaracteresIngresados.transferFocus();
			}

		} else {
			JOptionPane.showMessageDialog(null, "Ingrese solo numeros!");
			e.consume();

		}

	}
	

	
		
//				this.vidas.setText(String.valueOf(negocio.getVidas()));
//				this.vidas.setBounds(39, 0, 33, 33);
//				this.vidas.setForeground(Color.green);
//				frame.getContentPane().add(vidas);
//				System.out.println(negocio.getVidas());
//		
////		JLabel lblCorazon = new JLabel("New label");
////		lblCorazon.setIcon(new ImageIcon("src\\Imagenes\\corazon pequeño.png"));
////		lblCorazon.setBounds(0, 2, 33, 33);
////		frame.getContentPane().add(lblCorazon);
	

	private void SumTargetTop() {
		this.arrLabelArriba = new JLabel[negocio.getTamano()];
		for (int i = 0; i < arrLabelArriba.length; i++) {
			arrLabelArriba[i] = new JLabel("--");
			arrLabelArriba[i].setText(String.valueOf(negocio.getResultadosColumna()[i]));

			arrLabelArriba[i].setBounds(70 + (i * 50), 20, 121, 33);
			frame.getContentPane().add(arrLabelArriba[i]);
		}

	}

	private void SumTargetSide() {
		this.arrLabelDerecha = new JLabel[negocio.getTamano()];
		for (int i = 0; i < arrLabelDerecha.length; i++) {
			arrLabelDerecha[i] = new JLabel("--");
			arrLabelDerecha[i].setText(String.valueOf(negocio.getResultadoSumaFila()[i]));

			arrLabelDerecha[i].setBounds(frame.getWidth()-40
					
					, (60+i * 50), 115, 33);
			frame.getContentPane().add(arrLabelDerecha[i]);
		}
	}

	public int getCantFilas() {
		return cantFilas;
	}

	public void setNegocio(Negocio neg) {
		this.negocio = neg;
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

	private int[][] transformarCajasAmatriz(JTextField[][] cajas) {
		int[][] ret = new int[cajas.length][cajas.length];
		for (int i = 0; i < cajas.length; i++) {
			for (int j = 0; j < cajas.length; j++) {
				if (cajas[i][j].getText().equals("")) {
					throw new IllegalArgumentException("las cajas estan vacias");

				} else {
					ret[i][j] = Integer.parseInt(cajas[i][j].getText());
				}
			}
		}

		return ret;

	}

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
		try
        {
			this.sound=new Sonido();
			sound.play();}
		 	catch (Exception ex) 
        {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
          
          }
		
		System.out.println("Dificultad seleccionada:" + negocio.getDificultad());
		JButton Calcular = new JButton("Calcular"); // lo coloco aca para poder modificar la posicion
		frame = new JFrame("Juegos aritmeticos");
		frame.setResizable(false); // indicamos que no manipule el usuario el tamaño de la ventana

		switch (negocio.getDificultad()) {
		case "Facil":
			frame.setBounds(500, 200, 320, 400);
			frame.setLocationRelativeTo(null);
			Calcular.setBounds(129, 325, 89, 23);
			break;
		case "Normal":
			frame.setBounds(500, 200, 420, 500);
			frame.setLocationRelativeTo(null);
			Calcular.setBounds(180, 430, 89, 23);
			break;
		case "Dificil":
			frame.setBounds(500, 200, 520, 630);
			frame.setLocationRelativeTo(null);
			Calcular.setBounds(250, 530, 89, 23);
			break;
		}
		crearBtnMusica();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

//		//vamos a hacer un array de labels para mostrar resultados de columnaas

		SumTargetTop();
//	//hagamos otro para mostrar resultados de filas

		SumTargetSide();
		
		
		//System.out.println(frame.getHeight());

		JTextField[][] cajas = new JTextField[negocio.getCantFilas()][negocio.getCantColumnas()];// pedimos el tamaño a
																									// la clase negocio,
																									// mucho mejor.
		System.out.println("Matriz :" + negocio.getCantFilas() + "x" + negocio.getCantFilas());
		int posY = 55;

		for (int fila = 0; fila < cajas.length; fila++) {
			int posX = 60;
			for (int col = 0; col < cajas[0].length; col++) {
				cajas[fila][col] = new JTextField();
				cajas[fila][col].setBounds(posX, posY, 50, 50);
				cajas[fila][col].setHorizontalAlignment(SwingConstants.CENTER);
				frame.getContentPane().add(cajas[fila][col]);
				posX += 50;
				cajas[fila][col].addKeyListener(new KeyAdapter() {
					public void keyTyped(KeyEvent e) {
						char tipeado = e.getKeyChar();
						var elementosActuales = e.getSource();
						verificarElementosIngresados(tipeado, elementosActuales, e);
					}
				});
			}
			posY += 50;
		}
		
//esto es solo para ver el resultado despues lo sacamos
		negocio.mostrar();

		// sacar luego

		Calcular.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				System.out.println(negocio.getVidas());
				lblVidas.setText(String.valueOf(negocio.getVidas()));
				
				try {
					negocio.agregarValoresMatriz(transformarCajasAmatriz(cajas));
					negocio.mostrarMatrizUsuario();

					if (negocio.calculartodo()) {
						for(int i=0;i<negocio.getTamano();i++) {
							arrLabelDerecha[i].setForeground(Color.green);
							arrLabelArriba[i].setForeground(Color.green);
						}
						cartelGanaste();
					}else if(negocio.getVidas()==0){
						JOptionPane.showMessageDialog(null, "Ups perdiste! ");
						OpcionesPerdiste();
					} 
					else {
						JOptionPane.showMessageDialog(null, "Revisa los datos ingresados,Perdiste una vida!, te quedan "+negocio.getVidas());
					}
						
										//codigo para colorear labels
					for(int i=0;i<negocio.getTamano();i++) {
						if(negocio.isCorrectaFila(i)) {
							arrLabelDerecha[i].setForeground(Color.green);
						}
						else {
							arrLabelDerecha[i].setForeground(Color.red);
						}
						if(negocio.isCorrectaColumna(i)) {
							arrLabelArriba[i].setForeground(Color.green);
						}
						else {arrLabelArriba[i].setForeground(Color.red);
							
						}
						
					}
					
					
					}
				

				catch (IllegalArgumentException f) {
					JOptionPane.showMessageDialog(null, "Las cajas estan vacias !");

				}
			}

			private void OpcionesPerdiste() {
				if (negocio.gameOver()) {
					sound.pause();
					String[] arreglo = { "Jugar", "Terminar" };
					int opcionesReiniciar = JOptionPane.showOptionDialog(null, "¿Quieres volver a jugar?",
							"Juegos Aritmeticos UNGS", 0, JOptionPane.INFORMATION_MESSAGE, null, arreglo, null);

					switch (opcionesReiniciar) {
					case 0:
						VentanaInicio nuevoJuego = new VentanaInicio();
						nuevoJuego.visible();
						frame.setVisible(false);
						break;
					case 1:
						System.exit(0);
						break;
					}


				}
			}

			private void cartelGanaste() {
				JOptionPane.showMessageDialog(null, "Muy bien ganaste");
				sound.pause();
				String[] arreglo = { "Jugar", "Terminar","Guardar puntaje" };
				int opcionesReiniciar = JOptionPane.showOptionDialog(null, "¿Quieres volver a jugar?",
						"Juegos Aritmeticos UNGS", 0, JOptionPane.INFORMATION_MESSAGE, null, arreglo, null);

				switch (opcionesReiniciar) {
				case 0:
					VentanaInicio nuevoJuego = new VentanaInicio();
					nuevoJuego.visible();
					frame.setVisible(false);
					break;
				case 1:
					System.exit(0);
					break;
				case 2:
					String m = JOptionPane.showInputDialog("Ingrese su nombre");
					negocio.escribirPuntaje(m);
					VentanaInicio nuevoJuego2 = new VentanaInicio();
					nuevoJuego2.visible();
					frame.setVisible(false);
					break;
				}
			}
		});
		
		
		System.out.println(negocio.getVidas());
		lblVidas.setBounds(57, 11, 46, 28);
		frame.getContentPane().add(lblVidas);
		frame.getContentPane().add(Calcular);
		
		JLabel lblFondo = new JLabel("New label");
		lblFondo.setIcon(new ImageIcon("Imagenes/fondo.jpg"));
		lblFondo.setBounds(0, 0, 434, 256);
		frame.getContentPane().add(lblFondo);
		
		vidas.setFont(new Font("Tahoma", Font.BOLD, 16));

	}
}
