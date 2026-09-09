package View;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

import View.PracticaVentanas;
import View.TerceraVentana;

public class TerceraVentana extends JFrame{

	private JFrame frame;
	private JTextField nombre;	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TerceraVentana window = new TerceraVentana();
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
	public TerceraVentana() {
		initialize();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel juegoTerminado = new JLabel("Juego terminado! Su puntaje es: " + PracticaVentanas.puntaje);
		juegoTerminado.setFont(new Font("Tahoma", Font.PLAIN, 16));
		juegoTerminado.setBounds(10, 11, 291, 25);
		getContentPane().add(juegoTerminado);
		
		JLabel ingresarNombre = new JLabel("Ingrese su nombre:");
		ingresarNombre.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ingresarNombre.setBounds(10, 47, 151, 24);
		getContentPane().add(ingresarNombre);
		
		nombre = new JTextField();
		nombre.setBounds(158, 51, 143, 20);
		getContentPane().add(nombre);
		nombre.setColumns(10);
		
		JLabel salirDePantalla = new JLabel("Si ingresó su nombre, presione ENTER para continuar");
		salirDePantalla.setFont(new Font("Tahoma", Font.PLAIN, 16));
		salirDePantalla.setBounds(10, 124, 407, 25);
		getContentPane().add(salirDePantalla);
		
		Action enter = new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(nombre.getText().length() > 0) {
					PracticaVentanas.actualizarTablaDePuntajes(nombre.getText(), String.valueOf(PracticaVentanas.puntaje));
					dispose();
				}					
			}		
		};
		
		getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
		.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");

		getRootPane().getActionMap().put("enter", enter);
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setBounds(100, 100, 443, 273);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}
