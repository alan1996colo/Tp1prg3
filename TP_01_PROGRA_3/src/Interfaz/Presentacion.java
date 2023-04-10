package Interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
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
import java.awt.Color;
import javax.swing.ImageIcon;

public class Presentacion {

	private JFrame frame;
	private Negocio negocio;
	JLabel lblVidas = new JLabel("3");
	private JLabel arrLabelArriba[];
	private JLabel arrLabelDerecha[];
	private JButton prenderApagarMusica;
	private Sonido sound;

	public Presentacion(Negocio neg) {
		this.negocio = neg;
		initialize();

	}

	private void crearBtnMusica(String nivel) {
		prenderApagarMusica = new JButton("Mute");
		prenderApagarMusica.setBackground(new Color(51, 165, 33));
		prenderApagarMusica.setFont(new Font("Tahoma", Font.BOLD, 9));
		prenderApagarMusica.setForeground(new Color(255, 255, 255));
		switch (nivel) {
		case "Facil": {
			prenderApagarMusica.setBounds(266, 5, 60, 32);
			break;

		}
		case "Normal": {
			prenderApagarMusica.setBounds(368, 5, 60, 32);
			break;
		}

		case "Dificil": {
			prenderApagarMusica.setBounds(468, 5, 60, 32);
			break;
		}

		}
		prenderApagarMusica.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (sound.getStatus().equals("play")) {
					sound.pause();
				} else {
					sound.play();
				}
			}
		});
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(prenderApagarMusica);
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

	/***
	 * Visualiza en pantalla la suma objetivo de arriba
	 ***/
	private void SumTargetTop() {
		this.arrLabelArriba = new JLabel[negocio.getTamano()];
		for (int i = 0; i < arrLabelArriba.length; i++) {
			arrLabelArriba[i] = new JLabel("--");
			arrLabelArriba[i].setText(String.valueOf(negocio.getResultadosColumna()[i]));
			arrLabelArriba[i].setFont(new Font("Tahoma", Font.BOLD, 16));
			arrLabelArriba[i].setBounds(70 + (i * 50), 20, 121, 33);
			frame.getContentPane().add(arrLabelArriba[i]);
		}

	}

	/***
	 * Visualiza en pantalla la suma objetivo del costado
	 ***/
	private void SumTargetSide() {
		this.arrLabelDerecha = new JLabel[negocio.getTamano()];
		for (int i = 0; i < arrLabelDerecha.length; i++) {
			arrLabelDerecha[i] = new JLabel("--");
			arrLabelDerecha[i].setFont(new Font("Tahoma", Font.BOLD, 16));
			arrLabelDerecha[i].setText(String.valueOf(negocio.getResultadoSumaFila()[i]));

			arrLabelDerecha[i].setBounds(frame.getWidth() - 70, (58 + i * 50), 150, 50);
			frame.getContentPane().add(arrLabelDerecha[i]);
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
		String[] arreglo = { "Jugar", "Terminar", "Guardar puntaje" };
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

	private String rutaImgCorazon() {
		String resourcePath = null;
		switch (System.getProperty("os.name")) {
		case "Linux":
			resourcePath = "Imagenes/corazon pequeño.png";
			break;
		case "Windows":
			resourcePath = "src\\Imagenes\\corazon pequeño.png";
			break;
		}
		return resourcePath;
	}

	private String rutaImgFondo() {
		String resourcePath = null;
		switch (System.getProperty("os.name")) {
		case "Linux":
			resourcePath = "Imagenes/fondo.jpg";
			break;
		case "Windows":
			resourcePath = "src\\Imagenes\\fondo.jpg";
			break;
		}
		return resourcePath;
	}

	private void colorear_Top_Side() {
		for (int i = 0; i < negocio.getTamano(); i++) {
			if (negocio.isCorrectaFila(i)) {
				arrLabelDerecha[i].setForeground(Color.green);
			} else {
				arrLabelDerecha[i].setForeground(Color.red);
			}
			if (negocio.isCorrectaColumna(i)) {
				arrLabelArriba[i].setForeground(Color.green);
			} else {
				arrLabelArriba[i].setForeground(Color.red);

			}

		}
	}

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

	public Presentacion() {
		initialize();
	}

	public void visible() {
		frame.setVisible(true);

	}

	private void initialize() {
		try {
			this.sound = new Sonido();
			sound.play();
		} catch (Exception ex) {
			System.out.println("Error with playing sound.");
			ex.printStackTrace();

		}

		System.out.println("Dificultad seleccionada:" + negocio.getDificultad());

		JButton Calcular = new JButton("Calcular"); // lo coloco aca para poder modificar la posicion
		Calcular.setBackground(new Color(255, 140, 0));
		Calcular.setFont(new Font("Tahoma", Font.BOLD, 15));

		frame = new JFrame("Juegos aritmeticos");
		frame.setResizable(false); // indicamos que no manipule el usuario el tamaño de la ventana

		switch (negocio.getDificultad()) {
		case "Facil":
			frame.setBounds(500, 200, 350, 350);
			frame.setLocationRelativeTo(null);
			Calcular.setBounds(110, 265, 102, 32);
			crearBtnMusica("Facil");
			break;
		case "Normal":
			frame.setBounds(500, 200, 450, 450);
			frame.setLocationRelativeTo(null);
			Calcular.setBounds(160, 370, 102, 32);
			crearBtnMusica("Normal");
			break;
		case "Dificil":
			frame.setBounds(500, 200, 548, 570);
			frame.setLocationRelativeTo(null);
			Calcular.setBounds(200, 480, 102, 32);
			crearBtnMusica("Dificil");
			break;
		}

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(Calcular);

		SumTargetTop();
		SumTargetSide();

		JTextField[][] cajas = new JTextField[negocio.getTamano()][negocio.getTamano()];
		System.out.println("Matriz :" + negocio.getTamano() + "x" + negocio.getTamano());
		int posY = 55;
		for (int fila = 0; fila < cajas.length; fila++) {
			int posX = 60;
			for (int col = 0; col < cajas[0].length; col++) {
				cajas[fila][col] = new JTextField();
				cajas[fila][col].setBounds(posX, posY, 50, 50);
				cajas[fila][col].setHorizontalAlignment(SwingConstants.CENTER);
				cajas[fila][col].setFont(new Font("Tahoma", Font.BOLD, 16));
				cajas[fila][col].setBackground(new Color(169, 169, 169));
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

		negocio.mostrar(); // muestra la matriz resuelta
		Calcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					negocio.agregarValoresMatriz(transformarCajasAmatriz(cajas));
					negocio.mostrarMatrizUsuario();
					if (negocio.calculartodo()) {
						for (int i = 0; i < negocio.getTamano(); i++) {
							arrLabelDerecha[i].setForeground(Color.green);
							arrLabelArriba[i].setForeground(Color.green);
						}
						cartelGanaste();
					} else if (negocio.getVidas() == 0) {
						JOptionPane.showMessageDialog(null, "Ups perdiste! ");
						lblVidas.setText(String.valueOf(negocio.getVidas()));
						OpcionesPerdiste();
					} else {
						JOptionPane.showMessageDialog(null,
								"Revisa los datos ingresados,Perdiste una vida!, te quedan " + negocio.getVidas());
					}
					lblVidas.setText(String.valueOf(negocio.getVidas()));
					colorear_Top_Side();
				} catch (IllegalArgumentException f) {
					JOptionPane.showMessageDialog(null, "Las cajas estan vacias !");
				}
			}
		});

		JLabel lblNewLabel = new JLabel("CorazonPequeño");
		lblNewLabel.setBounds(0, 4, 36, 32);
		lblNewLabel.setIcon(new ImageIcon(rutaImgCorazon()));
		frame.getContentPane().add(lblNewLabel);

		lblVidas.setBounds(33, 8, 46, 28);
		lblVidas.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblVidas.setForeground(new Color(0, 128, 0));
		frame.getContentPane().add(lblVidas);

		JLabel lblFondo = new JLabel("FondoPresentacion");
		lblFondo.setBounds(-28, -119, 819, 777);
		lblFondo.setIcon(new ImageIcon(rutaImgFondo()));
		frame.getContentPane().add(lblFondo);

		// vidas.setFont(new Font("Tahoma", Font.BOLD, 16));

	}
}
