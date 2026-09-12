package tpProgra3;

import java.awt.Color;
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
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.KeyStroke;
import javax.swing.JLabel;

public class VentanaPrincipal {
	private JFrame frame;	
	private JTextField txtSiguienteNmero;
	private JTextField textoPuntaje;
	private int nuevoValor = Matriz.nuevoNumeroAInsertar();
	private boolean haySiguienteMovimiento = true;
		
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
			int nuevoNumeroAInsertar = Matriz.nuevoNumeroAInsertar();
			while(nuevoNumeroAInsertar == nuevoValor) {
				nuevoNumeroAInsertar = Matriz.nuevoNumeroAInsertar();
			}nuevoValor = nuevoNumeroAInsertar;
		}
		
		public void actualizarInterfaz(JTextPane[][] jPanes, JTextPane valorNuevo, JTextPane puntaje) {
			for(int f = 0; f < jPanes.length; f++) {
				for(int c = 0; c < jPanes[0].length; c++) {
					jPanes[f][c].setText(Matriz.getValorMatrizString(f, c));
					jPanes[f][c].setBackground(cambiarColor(jPanes[f][c].getText()));
				}
			}nuevoNumero();
			valorNuevo.setText(String.valueOf(nuevoValor));
			puntaje.setText(String.valueOf(Puntaje.getPuntajeString()));
			
		}
		
		public String getValorPuntaje(JTextPane panel) {
			return panel.getText();
		}
		
		public void llamarVentanaJuegoTerminado() {
			VentanaJuegoTerminado window = new VentanaJuegoTerminado();
			window.setVisible(true);
		}	
		
		/**
		 * Launch the application.
		 */
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						VentanaPrincipal window = new VentanaPrincipal();
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
		public VentanaPrincipal() {
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
		            pane.setText(Matriz.getValorMatrizString(f,c));
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
			txtSiguienteNmero.setBounds(324, 62, 123, 20);
			frame.getContentPane().add(txtSiguienteNmero);
			txtSiguienteNmero.setColumns(10);
			
			JTextPane valorSiguienteNumero = new JTextPane();
			valorSiguienteNumero.setText(String.valueOf(nuevoValor));
			valorSiguienteNumero.setBounds(468, 34, 44, 48);
			frame.getContentPane().add(valorSiguienteNumero);
			
			textoPuntaje = new JTextField();
			textoPuntaje.setText("Puntaje:");
			textoPuntaje.setBounds(324, 122, 123, 20);
			frame.getContentPane().add(textoPuntaje);
			textoPuntaje.setColumns(10);
			
			JTextPane valorPuntaje = new JTextPane();
			valorPuntaje.setText("0");
			valorPuntaje.setBounds(468, 94, 44, 48);
			frame.getContentPane().add(valorPuntaje);
			
			JButton botonHistorialPuntajes = new JButton("Puntajes");
			botonHistorialPuntajes.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					VentanaDePuntajes window = new VentanaDePuntajes();
					window.setVisible(true);
					
				}
			});
			
			botonHistorialPuntajes.setBounds(324, 190, 89, 23);
			frame.getContentPane().add(botonHistorialPuntajes);
			
			JButton botonReiniciar = new JButton("Reiniciar Tablero");
			botonReiniciar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Matriz.reiniciarTablero();
					Puntaje.reiniciarPuntaje();
					actualizarInterfaz(jPanes, valorSiguienteNumero, valorPuntaje);
					haySiguienteMovimiento = true;
				}
			});
			botonReiniciar.setBounds(324, 247, 136, 23);
			frame.getContentPane().add(botonReiniciar);
			
			JLabel lblNewLabel = new JLabel("Presione ↑ para desplazar las fichas hacia arriba");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblNewLabel.setBounds(324, 281, 330, 36);
			frame.getContentPane().add(lblNewLabel);
			
			JLabel lblPresionePara = new JLabel("Presione ↓ para desplazar las fichas hacia abajo");
			lblPresionePara.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblPresionePara.setBounds(324, 315, 330, 36);
			frame.getContentPane().add(lblPresionePara);
			
			JLabel lblPresionePara_2 = new JLabel("Presione → para desplazar las fichas hacia la derecha");
			lblPresionePara_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblPresionePara_2.setBounds(324, 346, 330, 36);
			frame.getContentPane().add(lblPresionePara_2);
			
			JLabel lblPresionePara_2_1 = new JLabel("Presione ← para desplazar las fichas hacia la izquierda");
			lblPresionePara_2_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblPresionePara_2_1.setBounds(324, 380, 330, 36);
			frame.getContentPane().add(lblPresionePara_2_1);
				
			Action flechaArriba = new AbstractAction() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if(haySiguienteMovimiento) {
						Matriz.moverPorFilasArriba(Matriz.getMatriz(), nuevoValor);
						actualizarInterfaz(jPanes, valorSiguienteNumero, valorPuntaje);
						haySiguienteMovimiento = Matriz.hayMovimientosDisponibles(Matriz.getMatriz());
					}if(!haySiguienteMovimiento) {
					llamarVentanaJuegoTerminado();
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
						Matriz.moverPorFilasAbajo(Matriz.getMatriz(), nuevoValor);
						actualizarInterfaz(jPanes, valorSiguienteNumero, valorPuntaje);
						haySiguienteMovimiento = Matriz.hayMovimientosDisponibles(Matriz.getMatriz());
					}if(!haySiguienteMovimiento) {
						llamarVentanaJuegoTerminado();
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
						Matriz.moverPorColumnasDerecha(Matriz.getMatriz(), nuevoValor);
						actualizarInterfaz(jPanes, valorSiguienteNumero, valorPuntaje);
						haySiguienteMovimiento = Matriz.hayMovimientosDisponibles(Matriz.getMatriz());
					}if(!haySiguienteMovimiento) {
						llamarVentanaJuegoTerminado();
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
						Matriz.moverPorColumnasIzquierda(Matriz.getMatriz(), nuevoValor);
						actualizarInterfaz(jPanes, valorSiguienteNumero, valorPuntaje);
						haySiguienteMovimiento = Matriz.hayMovimientosDisponibles(Matriz.getMatriz());
					}if(!haySiguienteMovimiento) {
						llamarVentanaJuegoTerminado();
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