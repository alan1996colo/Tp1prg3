package Interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JTextArea;

import Negocio.Negocio;

public class Tabla {

	private JFrame frame;

//	private String[] tablaDepuntos; //aca vamos a poner ocasionalmente las lineas de texto

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tabla window = new Tabla();
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
	public Tabla() {
		initialize();
	}

	/****
	 * Se usa para conocer la puntuacion de una linea de Texto en el archivo txt
	 ***/
	private BigDecimal saberPuntosLinea(String linea) {

		String str = "";
		boolean copiar = false;
		for (int n = 0; n < linea.length(); n++) {
			char c = linea.charAt(n);
			if (c == ']') {
				copiar = !copiar;
			}
			if (copiar) {
				str = str + String.valueOf(c);
			}
			if (c == '[') {
				copiar = !copiar;
			}

		}
		if (str.length() == 0) {
			BigDecimal a = new BigDecimal(0);
			return a;
		}
		System.out.println(str);

		BigDecimal puntos = BigDecimal.valueOf(Double.valueOf(str));

		return puntos;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Tabla de puntuaciones");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// JFileChooser fc = new JFileChooser();
		// JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JTextArea tarea = new JTextArea(20, 20);

		File file = new File(Negocio.rutaFileResultadoTxt());
		try {
			BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			tarea.read(input, "READING FILE :-)");

			List<String> lines = Files.readAllLines(Paths.get(Negocio.rutaFileResultadoTxt()));

			// bubleSort
			for (int i = lines.size() - 1; i > 0; i--) {
				for (int j = 0; j < i; j++) {
					if (saberPuntosLinea(lines.get(j)).compareTo(saberPuntosLinea(lines.get(j + 1))) < 1) {
						Collections.swap(lines, j, j + 1);

					}
				}
			}

			//

			FileWriter fw = new FileWriter(file, true);
			BufferedWriter bw = new BufferedWriter(fw);
			// abro el archivo y lo borro
			PrintWriter writer = new PrintWriter(Negocio.rutaFileResultadoTxt());
			writer.print("");
			writer.close();
			// escribo el archivo
			for (int i = 0; i < lines.size(); i++) {// recorro linea a linea y coloco nuevo contenido
				bw.write(lines.get(i));
				bw.newLine();
			}
			bw.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		frame.getContentPane().add(tarea, BorderLayout.CENTER);
		// frame.getContentPane().add(readButton, BorderLayout.PAGE_END);
		frame.pack();
		frame.setVisible(true);
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		frame.setVisible(true);

	}

}
