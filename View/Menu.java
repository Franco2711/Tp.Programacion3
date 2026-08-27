package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.CardLayout;
import org.eclipse.wb.swing.FocusTraversalOnArray;

import Model.Tablero;

import java.awt.Component;

public class Menu {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
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
	public Menu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.PINK);
		frame.setBounds(100, 100, 810, 507);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(4, 4, 5, 5));
		Tablero tabla = new Tablero();
		dibujar(tabla.getTablero());
		tabla.moverDerecha();
		
		}
	public void dibujar(int[][] tablero) {
		JLabel lblNewLabel_1 = new JLabel(""+tablero[0][0]+"");
		lblNewLabel_1.setForeground(Color.BLACK);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel(""+tablero[0][1]+"");
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel(""+tablero[0][2]+"");
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel(""+tablero[0][3]+"");
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel(""+tablero[1][0]+"");
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel(""+tablero[1][1]+"");
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel(""+tablero[1][2]+"");
		frame.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel(""+tablero[1][3]+"");
		frame.getContentPane().add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel(""+tablero[2][0]+"");
		frame.getContentPane().add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel(""+tablero[2][1]+"");
		frame.getContentPane().add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel(""+tablero[2][2]+"");
		frame.getContentPane().add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel(""+tablero[2][3]+"");
		frame.getContentPane().add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel(""+tablero[3][0]+"");
		frame.getContentPane().add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel(""+tablero[3][1]+"");
		frame.getContentPane().add(lblNewLabel_14);
		
		JLabel lblNewLabel_15 = new JLabel(""+tablero[3][2]+"");
		frame.getContentPane().add(lblNewLabel_15);
		
		JLabel lblNewLabel_16 = new JLabel(""+tablero[3][3]+"");
		frame.getContentPane().add(lblNewLabel_16);
		frame.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{lblNewLabel_1, lblNewLabel_2, lblNewLabel_3, lblNewLabel_4, lblNewLabel_5, lblNewLabel_6, lblNewLabel_7, lblNewLabel_8, lblNewLabel_9, lblNewLabel_10, lblNewLabel_11, lblNewLabel_12, lblNewLabel_13, lblNewLabel_14, lblNewLabel_15, lblNewLabel_16}));
		
	}

}
