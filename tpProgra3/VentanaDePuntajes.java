package tpProgra3;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;


public class VentanaDePuntajes extends JFrame {

	private JFrame frame;
	private JTextField nombrePuntaje1;
	private JTextField puntaje1;
	private JTextField nombrePuntaje2;
	private JTextField nombrePuntaje3;
	private JTextField puntaje2;
	private JTextField puntaje3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaDePuntajes window = new VentanaDePuntajes();
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
	public VentanaDePuntajes() {
		initialize();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setBounds(100, 100, 303, 266);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		nombrePuntaje1 = new JTextField();
		nombrePuntaje1.setText(Puntaje.getHistorialDePuntaje().get(0)[0]);
		nombrePuntaje1.setBounds(20, 35, 113, 28);
		getContentPane().add(nombrePuntaje1);
		nombrePuntaje1.setColumns(10);
		
		puntaje1 = new JTextField();
		puntaje1.setText(Puntaje.getHistorialDePuntaje().get(0)[1]);
		puntaje1.setColumns(10);
		puntaje1.setBounds(143, 35, 113, 28);
		getContentPane().add(puntaje1);
		
		nombrePuntaje2 = new JTextField();
		nombrePuntaje2.setText(Puntaje.getHistorialDePuntaje().get(1)[0]);
		nombrePuntaje2.setColumns(10);
		nombrePuntaje2.setBounds(20, 74, 113, 28);
		getContentPane().add(nombrePuntaje2);
		
		puntaje2 = new JTextField();
		puntaje2.setText(Puntaje.getHistorialDePuntaje().get(1)[1]);
		puntaje2.setColumns(10);
		puntaje2.setBounds(143, 74, 113, 28);
		getContentPane().add(puntaje2);
		
		nombrePuntaje3 = new JTextField();
		nombrePuntaje3.setText(Puntaje.getHistorialDePuntaje().get(2)[0]);
		nombrePuntaje3.setColumns(10);
		nombrePuntaje3.setBounds(20, 113, 113, 28);
		getContentPane().add(nombrePuntaje3);
		
		puntaje3 = new JTextField();
		puntaje3.setText(Puntaje.getHistorialDePuntaje().get(2)[1]);
		puntaje3.setColumns(10);
		puntaje3.setBounds(143, 113, 113, 28);
		getContentPane().add(puntaje3);
	}
}
