package Interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class Tabla {

	private JFrame frame;

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

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		

		//JFileChooser fc = new JFileChooser();
	    //JFrame frame = new JFrame();
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	    JTextArea tarea = new JTextArea(20, 20);

	  
	        File file = new File("src\\Negocio\\resultado.txt");
	        try {
	          BufferedReader input = new BufferedReader(new InputStreamReader(
	              new FileInputStream(file)));
	          tarea.read(input, "READING FILE :-)");
	        } catch (Exception e) {
	          e.printStackTrace();
	        }
	      
	   

	    frame.getContentPane().add(tarea, BorderLayout.CENTER);
	 //   frame.getContentPane().add(readButton, BorderLayout.PAGE_END);
	    frame.pack();
	    frame.setVisible(true);
	  }



	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		frame.setVisible(true);
		
	}
	
		
	}


