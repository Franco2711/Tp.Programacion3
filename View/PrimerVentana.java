package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.InputMap;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JProgressBar;
import java.awt.Panel;
import java.awt.color.ColorSpace;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import View.PracticaVentanas;
import View.PrimerVentana;
import View.SeguntaVentana;
import View.TerceraVentana;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JSeparator;
import javax.swing.JTextPane;
import javax.swing.KeyStroke;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.DropMode;
import java.awt.Color;

public class PrimerVentana {	
private JFrame frame;	
private JTextField txtSiguienteNmero;
private JTextField textoPuntaje;
	
	int nuevoValor = PracticaVentanas.nuevoNumeroAInsertar();
	String nuevoValorString = String.valueOf(nuevoValor);
	boolean haySiguienteMovimiento = true;
	
	
	public Color cambiarColor(String valor) {
		if(valor.equals("0")) {
			return Color.white;
		}else if(valor.equals("1")) {
			return Color.pink;
		}else if(valor.equals("2")) {
			return Color.green;
		}else if(valor.equals("3")) {
			return Color.red;
		}else {
		return Color.cyan;
		}
	}
	
	public void nuevoNumero() {
		int nuevoNumeroAInsertar = PracticaVentanas.nuevoNumeroAInsertar();
		while(nuevoNumeroAInsertar == nuevoValor) {
			nuevoNumeroAInsertar = PracticaVentanas.nuevoNumeroAInsertar();
		}nuevoValor = nuevoNumeroAInsertar;
	}
	
	public void actualizarInterfaz(JTextPane[][] jPanes, JTextPane valorNuevo, JTextPane puntaje) {
		for(int f = 0; f < jPanes.length; f++) {
			for(int c = 0; c < jPanes[0].length; c++) {
				jPanes[f][c].setText(String.valueOf(PracticaVentanas.m[f][c]));
				jPanes[f][c].setBackground(cambiarColor(jPanes[f][c].getText()));
			}
		}nuevoNumero();
		valorNuevo.setText(String.valueOf(nuevoValor));
		puntaje.setText(String.valueOf(PracticaVentanas.puntaje));
		
	}
	
	public String getValorPuntaje(JTextPane panel) {
		return panel.getText();
	}
	
	public void llamarPantallaParaIngresarPuntaje() {
		TerceraVentana window = new TerceraVentana();
		window.setVisible(true);
	}	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrimerVentana window = new PrimerVentana();
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
	public PrimerVentana() {
		initialize();
	}	
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 680, 501);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		int filas = 4;
	    int columnas = 4;
	    int ancho = 60;
	    int alto = 60;
	    int margenX = 10;
	    int margenY = 11;
	    int espacioX = 70; 
	    int espacioY = 71; 

	    JTextPane[][] jPanes = new JTextPane[filas][columnas];
	    
	    for (int f = 0; f < filas; f++) {
	        for (int c = 0; c < columnas; c++) {
	            JTextPane pane = new JTextPane();
	            pane.setFont(new Font("Tahoma", Font.PLAIN, 20));
	            pane.setText(PracticaVentanas.getM(PracticaVentanas.m, f, c));
	            pane.setBackground(cambiarColor(pane.getText()));
	            int x = margenX + c * espacioX;
	            int y = margenY + f * espacioY;
	            pane.setBounds(x, y, ancho, alto);
	            frame.getContentPane().add(pane);
	            jPanes[f][c] = pane;
	        }
	    }

		txtSiguienteNmero = new JTextField();
		txtSiguienteNmero.setText("Siguiente Número:");
		txtSiguienteNmero.setBounds(339, 62, 123, 20);
		frame.getContentPane().add(txtSiguienteNmero);
		txtSiguienteNmero.setColumns(10);
		
		JTextPane valorSiguienteNumero = new JTextPane();
		valorSiguienteNumero.setText(nuevoValorString);
		valorSiguienteNumero.setBounds(483, 34, 44, 48);
		frame.getContentPane().add(valorSiguienteNumero);
		
		textoPuntaje = new JTextField();
		textoPuntaje.setText("Puntaje:");
		textoPuntaje.setBounds(339, 122, 123, 20);
		frame.getContentPane().add(textoPuntaje);
		textoPuntaje.setColumns(10);
		
		JTextPane valorPuntaje = new JTextPane();
		valorPuntaje.setText("0");
		valorPuntaje.setBounds(483, 94, 44, 48);
		frame.getContentPane().add(valorPuntaje);
		
		JButton botonHistorialPuntajes = new JButton("Puntajes");
		botonHistorialPuntajes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SeguntaVentana window = new SeguntaVentana();
				window.setVisible(true);
				
			}
		});
		
		botonHistorialPuntajes.setBounds(339, 190, 89, 23);
		frame.getContentPane().add(botonHistorialPuntajes);
		
		JButton botonReiniciar = new JButton("Reiniciar Tablero");
		botonReiniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PracticaVentanas.reiniciarTablero();
				actualizarInterfaz(jPanes, valorSiguienteNumero, valorPuntaje);
				haySiguienteMovimiento = true;
			}
		});
		botonReiniciar.setBounds(339, 247, 136, 23);
		frame.getContentPane().add(botonReiniciar);
			
		Action flechaArriba = new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(haySiguienteMovimiento) {
					PracticaVentanas.moverPorFilasArriba(PracticaVentanas.m, nuevoValor);
					actualizarInterfaz(jPanes, valorSiguienteNumero, valorPuntaje);
					haySiguienteMovimiento = PracticaVentanas.hayMovimientosDisponibles(PracticaVentanas.m);
				}if(!haySiguienteMovimiento) {
				llamarPantallaParaIngresarPuntaje();
				}
			}
		};
		
		frame.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
		.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), "flechaArriba");
	
		frame.getRootPane().getActionMap().put("flechaArriba", flechaArriba);
		
		Action flechaAbajo = new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(haySiguienteMovimiento) {
					PracticaVentanas.moverPorFilasAbajo(PracticaVentanas.m, nuevoValor);
					actualizarInterfaz(jPanes, valorSiguienteNumero, valorPuntaje);
					haySiguienteMovimiento = PracticaVentanas.hayMovimientosDisponibles(PracticaVentanas.m);
				}if(!haySiguienteMovimiento) {
					llamarPantallaParaIngresarPuntaje();
			}
			}
		};		
		
		frame.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
		.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), "flechaAbajo");
	
		frame.getRootPane().getActionMap().put("flechaAbajo", flechaAbajo);
		
		Action flechaDerecha = new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(haySiguienteMovimiento) {
					PracticaVentanas.moverPorColumnasDerecha(PracticaVentanas.m, nuevoValor);
					actualizarInterfaz(jPanes, valorSiguienteNumero, valorPuntaje);
					haySiguienteMovimiento = PracticaVentanas.hayMovimientosDisponibles(PracticaVentanas.m);
				}if(!haySiguienteMovimiento) {
					llamarPantallaParaIngresarPuntaje();
				}
			}
		};		
		
		frame.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
		.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), "flechaDerecha");
	
		frame.getRootPane().getActionMap().put("flechaDerecha", flechaDerecha);
		
		Action flechaIzquierda = new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(haySiguienteMovimiento) {
					PracticaVentanas.moverPorColumnasIzquierda(PracticaVentanas.m, nuevoValor);
					actualizarInterfaz(jPanes, valorSiguienteNumero, valorPuntaje);
					haySiguienteMovimiento = PracticaVentanas.hayMovimientosDisponibles(PracticaVentanas.m);
				}if(!haySiguienteMovimiento) {
					llamarPantallaParaIngresarPuntaje();
				}
			}
		};		
		
		frame.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
		.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), "flechaIzquierda");
	
		frame.getRootPane().getActionMap().put("flechaIzquierda", flechaIzquierda);
		
		frame.setFocusable(true); frame.requestFocusInWindow();
		
		frame.setVisible(true);
		
		}
	}
