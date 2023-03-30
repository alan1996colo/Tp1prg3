package Interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import Negocio.Negocio;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaInicio {

	private JFrame frame;

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

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(750, 100, 450, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Juegos Aritmeticos");
		lblNewLabel.setFont(new Font("Tekton Pro", Font.PLAIN, 36));
		lblNewLabel.setBounds(62, 40, 316, 50);
		frame.getContentPane().add(lblNewLabel);

		JButton btnFacil = new JButton("Facil");

		btnFacil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Negocio negocio = new Negocio(4, 1, "Facil");
				Presentacion inicio = new Presentacion(negocio);
				frame.setVisible(false);
				inicio.visible();

			}
		});
		btnFacil.setBounds(164, 164, 91, 23);
		frame.getContentPane().add(btnFacil);

		JButton btnNormal = new JButton("Normal");
		btnNormal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Negocio negocio = new Negocio(6, 4, "Normal");
				Presentacion inicio = new Presentacion(negocio);
				frame.setVisible(false);
				inicio.visible();
			}
		});

		btnNormal.setBounds(164, 205, 91, 23);
		frame.getContentPane().add(btnNormal);

		JButton btnDificil = new JButton("Dificil");
		btnDificil.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				Negocio negocio = new Negocio(8, 5, "Dificil");
				Presentacion inicio = new Presentacion(negocio);

				frame.setVisible(false);
				inicio.visible();
			}
		});
		btnDificil.setBounds(164, 250, 91, 23);
		frame.getContentPane().add(btnDificil);

		JLabel lblNewLabel_1 = new JLabel("Seleccione dificultad");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(108, 117, 245, 23);
		frame.getContentPane().add(lblNewLabel_1);
	}
}
