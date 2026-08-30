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
		return Color.BLUE;
		}
	}
	
	public void actualizarInterfaz() {
		
	}
	
	private JFrame frame;

	//InputMap inputMap = frame.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
	//ActionMap actionMap = frame.getRootPane().getActionMap();
	
	
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
		
		JTextPane f0c0 = new JTextPane();
		f0c0.setFont(new Font("Tahoma", Font.PLAIN, 20));
		f0c0.setText(PracticaVentanas.getM(PracticaVentanas.m, 0,0));
		f0c0.setBackground(cambiarColor(f0c0.getText()));
		f0c0.setBounds(10, 11, 60, 60);
		frame.getContentPane().add(f0c0);
		
		JTextPane f0c1 = new JTextPane();
		f0c1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		f0c1.setText(PracticaVentanas.getM(PracticaVentanas.m,0,1));
		f0c1.setBackground(cambiarColor(f0c1.getText()));
		f0c1.setBounds(80, 11, 60, 60);
		frame.getContentPane().add(f0c1);
		
		JTextPane f0c2 = new JTextPane();
		f0c2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		f0c2.setText(PracticaVentanas.getM(PracticaVentanas.m,0,2));
		f0c2.setBackground(cambiarColor(f0c2.getText()));
		f0c2.setBounds(150, 11, 60, 60);
		frame.getContentPane().add(f0c2);
		
		JTextPane f0c3 = new JTextPane();
		f0c3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		f0c3.setText(PracticaVentanas.getM(PracticaVentanas.m,0,3));
		f0c3.setBackground(cambiarColor(f0c3.getText()));
		f0c3.setBounds(220, 11, 60, 60);
		frame.getContentPane().add(f0c3);
		
		JTextPane f1c0 = new JTextPane();
		f1c0.setFont(new Font("Tahoma", Font.PLAIN, 20));
		f1c0.setText(PracticaVentanas.getM(PracticaVentanas.m,1,0));
		f1c0.setBackground(cambiarColor(f1c0.getText()));
		f1c0.setBounds(10, 82, 60, 60);
		frame.getContentPane().add(f1c0);
		
		JTextPane f1c1 = new JTextPane();
		f1c1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		f1c1.setText(PracticaVentanas.getM(PracticaVentanas.m,1,1));
		f1c1.setBackground(cambiarColor(f1c1.getText()));
		f1c1.setBounds(80, 82, 60, 60);
		frame.getContentPane().add(f1c1);
		
		JTextPane f1c2 = new JTextPane();
		f1c2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		f1c2.setText(PracticaVentanas.getM(PracticaVentanas.m,1,2));
		f1c2.setBackground(cambiarColor(f1c2.getText()));
		f1c2.setBounds(150, 82, 60, 60);
		frame.getContentPane().add(f1c2);
		
		JTextPane f1c3 = new JTextPane();
		f1c3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		f1c3.setText(PracticaVentanas.getM(PracticaVentanas.m,1,3));
		f1c3.setBackground(cambiarColor(f1c3.getText()));
		f1c3.setBounds(220, 82, 60, 60);
		frame.getContentPane().add(f1c3);
		
		JTextPane f2c0 = new JTextPane();
		f2c0.setFont(new Font("Tahoma", Font.PLAIN, 20));
		f2c0.setText(PracticaVentanas.getM(PracticaVentanas.m,2,0));
		f2c0.setBackground(cambiarColor(f2c0.getText()));
		f2c0.setBounds(10, 153, 60, 60);
		frame.getContentPane().add(f2c0);
		
		JTextPane f2c1 = new JTextPane();
		f2c1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		f2c1.setText(PracticaVentanas.getM(PracticaVentanas.m,2,1));
		f2c1.setBackground(cambiarColor(f2c1.getText()));
		f2c1.setBounds(80, 153, 60, 60);
		frame.getContentPane().add(f2c1);
		
		JTextPane f2c2 = new JTextPane();
		f2c2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		f2c2.setText(PracticaVentanas.getM(PracticaVentanas.m,2,2));
		f2c2.setBackground(cambiarColor(f2c2.getText()));
		f2c2.setBounds(150, 153, 60, 60);
		frame.getContentPane().add(f2c2);
		
		JTextPane f2c3 = new JTextPane();
		f2c3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		f2c3.setText(PracticaVentanas.getM(PracticaVentanas.m,2,3));
		f2c3.setBackground(cambiarColor(f2c3.getText()));
		f2c3.setBounds(220, 153, 60, 60);
		frame.getContentPane().add(f2c3);
		
		JTextPane f3c0 = new JTextPane();
		f3c0.setFont(new Font("Tahoma", Font.PLAIN, 20));
		f3c0.setText(PracticaVentanas.getM(PracticaVentanas.m,3,0));
		f3c0.setBackground(cambiarColor(f3c0.getText()));
		f3c0.setBounds(10, 224, 60, 60);
		frame.getContentPane().add(f3c0);
		
		JTextPane f3c1 = new JTextPane();
		f3c1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		f3c1.setText(PracticaVentanas.getM(PracticaVentanas.m,3,1));
		f3c1.setBackground(cambiarColor(f3c1.getText()));
		f3c1.setBounds(80, 224, 60, 60);
		frame.getContentPane().add(f3c1);
		
		JTextPane f3c2 = new JTextPane();
		f3c2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		f3c2.setText(PracticaVentanas.getM(PracticaVentanas.m,3,2));
		f3c2.setBackground(cambiarColor(f3c2.getText()));
		f3c2.setBounds(150, 224, 60, 60);
		frame.getContentPane().add(f3c2);
		
		JTextPane f3c3 = new JTextPane();
		f3c3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		f3c3.setText(PracticaVentanas.getM(PracticaVentanas.m,3,3));
		f3c3.setBackground(cambiarColor(f3c3.getText()));
		f3c3.setBounds(220, 224, 60, 60);
		frame.getContentPane().add(f3c3);
		
		JTextPane[] jPanes = {f0c0, f0c1, f0c2, f0c3, f1c0, f1c1, f1c2, f1c3,
							  f2c0, f2c1, f2c2, f2c3, f3c0, f3c1, f3c2, f3c3};
		
		Action flechaArriba = new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
					PracticaVentanas.moverPorFilasArriba(PracticaVentanas.m);
					int cont = 0;
					for(int f = 0; f < PracticaVentanas.m.length; f++) {
						for(int c = 0; c < PracticaVentanas.m[0].length; c++) {
							jPanes[cont].setText(PracticaVentanas.getM(PracticaVentanas.m, f, c));
							jPanes[cont].setBackground(cambiarColor(jPanes[cont].getText()));
							cont++;
						}
					}
				}
		};
		
		Action flechaAbajo = new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
					PracticaVentanas.moverPorFilasAbajo(PracticaVentanas.m);
					int cont = 0;
					for(int f = 0; f < PracticaVentanas.m.length; f++) {
						for(int c = 0; c < PracticaVentanas.m[0].length; c++) {
							jPanes[cont].setText(PracticaVentanas.getM(PracticaVentanas.m, f, c));
							jPanes[cont].setBackground(cambiarColor(jPanes[cont].getText()));
							cont++;
						}
					}
				}
		};		
		
		Action flechaDerecha = new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
					PracticaVentanas.moverPorColumnasDerecha(PracticaVentanas.m);
					int cont = 0;
					for(int f = 0; f < PracticaVentanas.m.length; f++) {
						for(int c = 0; c < PracticaVentanas.m[0].length; c++) {
							jPanes[cont].setText(PracticaVentanas.getM(PracticaVentanas.m, f, c));
							jPanes[cont].setBackground(cambiarColor(jPanes[cont].getText()));
							cont++;
						}
					}
				}
		};		
		
		Action flechaIzquierda = new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
					PracticaVentanas.moverPorColumnasIzquierda(PracticaVentanas.m);
					int cont = 0;
					for(int f = 0; f < PracticaVentanas.m.length; f++) {
						for(int c = 0; c < PracticaVentanas.m[0].length; c++) {
							jPanes[cont].setText(PracticaVentanas.getM(PracticaVentanas.m, f, c));
							jPanes[cont].setBackground(cambiarColor(jPanes[cont].getText()));
							cont++;
						}
					}
				}
		};		
		
		frame.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
			.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), "flechaArriba");
		
		frame.getRootPane().getActionMap().put("flechaArriba", flechaArriba);
		
		frame.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
		.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), "flechaAbajo");
	
		frame.getRootPane().getActionMap().put("flechaAbajo", flechaAbajo);
		
		frame.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
		.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), "flechaDerecha");
	
		frame.getRootPane().getActionMap().put("flechaDerecha", flechaDerecha);
		
		frame.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
		.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), "flechaIzquierda");
	
		frame.getRootPane().getActionMap().put("flechaIzquierda", flechaIzquierda);
		
		frame.setFocusable(true); frame.requestFocusInWindow();
		
		frame.setVisible(true);
		
		
		
		
//		JButton BotonArriba = new JButton("Arriba");
//		BotonArriba.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				PracticaVentanas.moverPorFilas(PracticaVentanas.m);
//				int cont = 0;
//				for(int f = 0; f < PracticaVentanas.m.length; f++) {
//					for(int c = 0; c < PracticaVentanas.m[0].length; c++) {
//						jPanes[cont].setText(PracticaVentanas.getM(PracticaVentanas.m, f, c));
//						jPanes[cont].setBackground(cambiarColor(jPanes[cont].getText()));
//						cont++;
//					}
//				}
//			}
//		});
//		BotonArriba.setBounds(434, 366, 89, 23);
//		frame.getContentPane().add(BotonArriba);
		
		
	}
}
