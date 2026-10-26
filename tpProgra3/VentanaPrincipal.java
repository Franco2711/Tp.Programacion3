package tpProgra3;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
//import tpProgra3.Threes;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;


public class VentanaPrincipal {
	private JFrame frame;	
	private Threes threes;
		
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
		
		public void actualizarInterfaz(JLabel[][] jPanes, JLabel valorNuevo) {
			for(int f = 0; f < jPanes.length; f++) {
				for(int c = 0; c < jPanes[0].length; c++) {
					if(threes.getValorFicha(f, c) != 0) {
						jPanes[f][c].setText(String.valueOf(threes.getValorFicha(f, c)));
						jPanes[f][c].setBackground(cambiarColor(jPanes[f][c].getText()));
					}else if(threes.getValorFicha(f, c) == 0){
						jPanes[f][c].setText("");
						jPanes[f][c].setBackground(cambiarColor("0"));
					}
				}
			}
			valorNuevo.setText(String.valueOf(threes.getValorNuevaFicha()));			
		}
		
		public void verificarJuegoTerminado() {
			if(!threes.quedanMovimientos()) {
				threes.sumarPuntaje();
				VentanaJuegoTerminado window = new VentanaJuegoTerminado(threes);
				window.setVisible(true);
			}
		}	
		
		public VentanaPrincipal(Threes juego) {
			this.threes = juego;
			initialize();
		}	
		
		private void initialize() {
			frame = new JFrame();
			frame.setBounds(100, 100, 532, 501);
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

		    JLabel[][] jPanes = new JLabel[filas][columnas];
		    
		    for (int f = 0; f < filas; f++) {
		        for (int c = 0; c < columnas; c++) {
		            JLabel pane = new JLabel();
		            pane.setHorizontalAlignment(SwingConstants.CENTER);
		            pane.setVerticalAlignment(SwingConstants.CENTER);
		            pane.setFont(new Font("Tahoma", Font.PLAIN, 20));
		            pane.setOpaque(true);
		            if(threes.getValorFicha(f, c) != 0) {
		            	pane.setText(String.valueOf(threes.getValorFicha(f, c)));
		            	pane.setBackground(cambiarColor(pane.getText()));
		            }else if(threes.getValorFicha(f, c) == 0){
		            	pane.setBackground(cambiarColor("0"));
		            }
		            int x = margenX + c * espacioX;
		            int y = margenY + f * espacioY;
		            pane.setBounds(x, y, ancho, alto);
		            frame.getContentPane().add(pane);
		            jPanes[f][c] = pane;
		        }
		    }
			
			JButton botonHistorialPuntajes = new JButton("Historial de puntajes");
			botonHistorialPuntajes.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					VentanaDePuntajes window = new VentanaDePuntajes(threes);
					window.setVisible(true);
					
				}
			});
			
			botonHistorialPuntajes.setBounds(304, 105, 156, 23);
			frame.getContentPane().add(botonHistorialPuntajes);
			
			JLabel SiguienteNumero = new JLabel("Siguiente Numero:");
			SiguienteNumero.setFont(new Font("Tahoma", Font.PLAIN, 14));
			SiguienteNumero.setBounds(304, 55, 122, 23);
			frame.getContentPane().add(SiguienteNumero);
			
			JLabel ProxNum = new JLabel("New label");
			ProxNum.setFont(new Font("Tahoma", Font.PLAIN, 14));
			ProxNum.setBounds(436, 56, 75, 20);
			ProxNum.setText(String.valueOf(threes.getValorNuevaFicha()));
			frame.getContentPane().add(ProxNum);
				
			
			JButton botonReiniciar = new JButton("Reiniciar Tablero");
			botonReiniciar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					threes.reiniciarJuego();
					actualizarInterfaz(jPanes, ProxNum);
				}
			});
			botonReiniciar.setBounds(304, 162, 156, 23);
			frame.getContentPane().add(botonReiniciar);
			
			JLabel lblNewLabel = new JLabel("Intrucciones para jugar:");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel.setBounds(10, 312, 164, 23);
			frame.getContentPane().add(lblNewLabel);
			
			JLabel lblNewLabel_1 = new JLabel("Presion la flecha arriba (↑) para mover las fichas hacia arriba");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabel_1.setBounds(10, 336, 350, 32);
			frame.getContentPane().add(lblNewLabel_1);
			
			JLabel lblNewLabel_1_1 = new JLabel("Presion la flecha abajo (↓) para mover las fichas hacia abajo");
			lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabel_1_1.setBounds(10, 357, 350, 32);
			frame.getContentPane().add(lblNewLabel_1_1);
			
			JLabel lblNewLabel_1_1_1 = new JLabel("Presion la flecha derecha (→) para mover las fichas hacia la derecha");
			lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabel_1_1_1.setBounds(10, 379, 370, 32);
			frame.getContentPane().add(lblNewLabel_1_1_1);
			
			JLabel lblNewLabel_1_1_1_1 = new JLabel("Presion la flecha izquierda(←) para mover las fichas hacia la izquierda");
			lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabel_1_1_1_1.setBounds(10, 400, 370, 32);
			frame.getContentPane().add(lblNewLabel_1_1_1_1);
			
			Action flechaArriba = new AbstractAction() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if(threes.quedanMovimientos()) {
						threes.moverPorFilasArriba();
						actualizarInterfaz(jPanes, ProxNum);
					}verificarJuegoTerminado();
				}
			};
			
			frame.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
			.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), "flechaArriba");
		
			frame.getRootPane().getActionMap().put("flechaArriba", flechaArriba);
			
			Action flechaAbajo = new AbstractAction() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if(threes.quedanMovimientos()) {
						threes.moverPorFilasAbajo();
						actualizarInterfaz(jPanes, ProxNum);
					}verificarJuegoTerminado();
				}
			};		
			
			frame.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
			.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), "flechaAbajo");
		
			frame.getRootPane().getActionMap().put("flechaAbajo", flechaAbajo);
			
			Action flechaDerecha = new AbstractAction() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if(threes.quedanMovimientos()) {
						threes.moverPorColumnasDerecha();
						actualizarInterfaz(jPanes, ProxNum);
					}verificarJuegoTerminado();
				}
			};		
			
			frame.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
			.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), "flechaDerecha");
		
			frame.getRootPane().getActionMap().put("flechaDerecha", flechaDerecha);
			
			Action flechaIzquierda = new AbstractAction() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if(threes.quedanMovimientos()) {
						threes.moverPorColumnasIzquierda();
						actualizarInterfaz(jPanes, ProxNum);
					}verificarJuegoTerminado();
				}
			};		
			
			frame.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
			.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), "flechaIzquierda");
		
			frame.getRootPane().getActionMap().put("flechaIzquierda", flechaIzquierda);
			
			frame.setFocusable(true); frame.requestFocusInWindow();
			
			frame.setVisible(true);
			
			}
		}