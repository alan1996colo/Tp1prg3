package Interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import Negocio.Negocio;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.UIManager;
import javax.swing.JTextPane;

public class VentanaInicio {

	private JFrame frame;
	//private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaInicio window = new VentanaInicio();
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
	public VentanaInicio() {
		initialize();
	}

	public void visible() {
		frame.setVisible(true);

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Bienvenidos a los juegos del hambre");//borrar despues jaja
		frame.setBounds(500, 200, 449, 465);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);

		JLabel lblNewLabel = new JLabel("Juegos Aritmeticos");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 44));
		lblNewLabel.setBounds(21, 11, 402, 82);
		frame.getContentPane().add(lblNewLabel);

		JButton btnFacil = new JButton("Facil");
		btnFacil.setBackground(new Color(51, 255, 102));
		btnFacil.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnFacil.setForeground(new Color(0, 0, 0));

		btnFacil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Negocio negocio = new Negocio(4, 4, "Facil");
				Presentacion inicio = new Presentacion(negocio);
				frame.setVisible(false);
				inicio.visible();

			}
		});
		btnFacil.setBounds(164, 212, 102, 32);
		frame.getContentPane().add(btnFacil);

		JButton btnNormal = new JButton("Normal");
		btnNormal.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNormal.setForeground(new Color(0, 0, 0));
		btnNormal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Negocio negocio = new Negocio(6, 4, "Normal");
				Presentacion inicio = new Presentacion(negocio);
				frame.setVisible(false);
				inicio.visible();
				
			}
		});

		btnNormal.setBounds(164, 267, 102, 32);
		btnNormal.setBackground(new Color(255,251,32));
		frame.getContentPane().add(btnNormal);

		JButton btnDificil = new JButton("Dificil");
		btnDificil.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnDificil.setBackground(new Color(255, 0, 51));
		btnDificil.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				Negocio negocio = new Negocio(8, 5, "Dificil");
				Presentacion inicio = new Presentacion(negocio);

				frame.setVisible(false);
				inicio.visible();
			}
		});
		btnDificil.setBounds(164, 327, 102, 32);
		frame.getContentPane().add(btnDificil);
		
		JButton verPuntajes = new JButton("Puntos");
		verPuntajes.setFont(new Font("Tahoma", Font.BOLD, 16));
		verPuntajes.setBackground(new Color(255, 200, 51));
	
		
		
		verPuntajes.setBounds(164, 387, 102, 32);
		frame.getContentPane().add(verPuntajes);
		verPuntajes.addActionListener(ev -> {
			Tabla tabla=new Tabla();
			tabla.setVisible(true);
			
		});


		JLabel lblNewLabel_1 = new JLabel("Seleccione dificultad");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(108, 162, 239, 40);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblFondo =  new JLabel("New label");//De esto se ve que vamos a estar pelando por el path jaja
		lblFondo.setIcon(new ImageIcon("Imagenes/fondo.jpg"));
		lblFondo.setBounds(-14, -20, 731, 517);
		frame.getContentPane().add(lblFondo);
		
		
	}
}
