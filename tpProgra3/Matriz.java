package tpProgra3;

import java.util.Random;

public class Matriz {

	private static int[][] matrizModelo = {{0,0,0,0}, 
									{0,2,1,0}, 
									{1,0,0,3}, 
									{0,0,0,0}};
	
	private static int[][] matriz = {{0,0,0,0}, 
							  {0,2,1,0}, 
							  {1,0,0,3}, 
							  {0,0,0,0}};
	
	public static int getValorMatriz(int fila, int columna) {
		return matriz[fila][columna];
	}
	
	public static int[][] getMatriz(){
		return matriz;
	}
	
	public static String getValorMatrizString(int fila, int columna) {
		return String.valueOf(matriz[fila][columna]);
	}
	
	public static int nuevoNumeroAInsertar() {
		Random rand = new Random();
		int numeroNuevo = rand.nextInt(3) + 1;
		return numeroNuevo;
	}
	
	public static int nuevaPosicionAInsertar() {
		Random rand = new Random();
		int numeroNuevo = rand.nextInt(4);
		return numeroNuevo;
	}
	
	public static void reiniciarTablero() {
		for(int f = 0; f < matrizModelo.length; f++) {
			for(int c = 0; c < matrizModelo[0].length; c++) {
				matriz[f][c] = matrizModelo[f][c];
			}
		}
	}
	
	public static boolean filaTieneDisponible(int[][] mat, int fila) {
		for(int c = 0; c < mat[0].length; c++) {
			if(mat[fila][c] == 0) {
				return true;
			}
		}return false;
	}
	
	public static boolean columnaTieneDisponible(int[][] mat, int columna) {
		for(int f = 0; f < mat.length; f++) {
			if(mat[f][columna] == 0) {
				return true;
			}
		}return false;
	}
	
	public static boolean puedenSumarse(int f, int c) {
		if((f == 1 && c == 2) || (f == 2 && c == 1) || (f == c && f >= 3 && c >= 3)){
			return true;
		}return false;
	}
	
	public static boolean hayMovimientosDisponibles(int[][] mat) {
		if(filaTieneDisponible(mat, 0) || filaTieneDisponible(mat, 3) || columnaTieneDisponible(mat, 0) || columnaTieneDisponible(mat, 3)) {
			return true;
		}
		for(int f = 0; f < mat.length; f++) {
			for(int c = 0; c < mat[0].length; c++) {
				if(f < 3 && c < 3) {
					if(puedenSumarse(mat[f][c], mat[f+1][c]) || puedenSumarse(mat[f][c], mat[f][c+1])) {
						return true;
					}
				}else if(f < 3 && c == 3) {
					if(puedenSumarse(mat[f][c], mat[f+1][c])) {
						return true;
					}
				}else if(f == 3 && c < 3) {
					if(puedenSumarse(mat[f][c], mat[f][c+1])) {
						return true;
					}
				}
			}
		}return false;
	}
	
	public static void insertarFichaMovimientoArribaOAbajo(int[][] m, int fila, int valorNuevo) {
		int posicion = nuevaPosicionAInsertar();
		while(m[fila][posicion] != 0) {
			posicion = nuevaPosicionAInsertar();
		}m[fila][posicion] = valorNuevo;
	}
	
	public static void moverPorFilasArriba(int[][] m, int valorNuevo) {
		for(int f = 0; f < m.length-1; f++) {
			for(int c = 0; c < m[0].length; c++ ) {
				if(m[f][c] == 0) {
					m[f][c] = m[f+1][c];
					m[f+1][c] = 0;
				}else if((m[f][c] == 1 && m[f+1][c] == 2) || (m[f][c] == 2 && m[f+1][c] == 1)) {
					m[f][c] = 3;
					m[f+1][c] = 0;
					Puntaje.sumarPuntaje(3);
				}else if(m[f][c] == m[f+1][c] && m[f][c] != 1 && m[f][c] != 2) {
					m[f][c] = m[f][c]+m[f+1][c];
					Puntaje.sumarPuntaje(m[f][c]+m[f+1][c]);
					m[f+1][c] = 0;
				}
			}
		}for(int c = 0; c < m[0].length; c++) {
			if(m[3][c] == 0) {
				m[3][c] = 0;
			}
		}if(filaTieneDisponible(m, 3)) {
			insertarFichaMovimientoArribaOAbajo(m, 3, valorNuevo);
		}
	}
	
	public static void moverPorFilasAbajo(int[][] m, int valorNuevo) {
		for(int f = 3; f > 0; f--) {
			for(int c = 0; c < m[0].length; c++ ) {
				if(m[f][c] == 0) {
					m[f][c] = m[f-1][c];
					m[f-1][c] = 0;
				}else if((m[f][c] == 1 && m[f-1][c] == 2) || (m[f][c] == 2 && m[f-1][c] == 1)) {
					m[f][c] = 3;
					m[f-1][c] = 0;
					Puntaje.sumarPuntaje(3);
				}else if(m[f][c] == m[f-1][c] && m[f][c] != 1 && m[f][c] != 2) {
					m[f][c] = m[f][c]+m[f-1][c];
					Puntaje.sumarPuntaje(m[f][c]+m[f-1][c]);
					m[f-1][c] = 0;
				}
			}
		}for(int c = 0; c < m[0].length; c++) {
			if(m[0][c] == 0) {
				m[0][c] = 0;
			}
		}if(filaTieneDisponible(m, 0)) {
			insertarFichaMovimientoArribaOAbajo(m, 0, valorNuevo);
		}
	}
	
	public static void insertarFichaMovimientoDerechaOIzquierda(int[][] m, int columna, int valorNuevo) {
		int posicion = nuevaPosicionAInsertar();
		while(m[posicion][columna] != 0) {
			posicion = nuevaPosicionAInsertar();
		}m[posicion][columna] = valorNuevo;
	}
	
	public static void moverPorColumnasDerecha(int[][] m, int valorNuevo) {
		for(int c = 3; c > 0; c-- ) {
			for(int f = 0; f < m.length; f++) {
				if(m[f][c] == 0) {
					m[f][c] = m[f][c-1];
					m[f][c-1] = 0;
				}else if((m[f][c] == 1 && m[f][c-1] == 2) || (m[f][c] == 2 && m[f][c-1] == 1)) {
					m[f][c] = 3;
					m[f][c-1] = 0;
					Puntaje.sumarPuntaje(3);
				}else if(m[f][c] == m[f][c-1] && m[f][c] != 1 && m[f][c] != 2) {
					m[f][c] = m[f][c]+m[f][c-1];
					Puntaje.sumarPuntaje(m[f][c]+m[f][c-1]);
					m[f][c-1] = 0;
					
				}			
			}
		}for(int f = 0; f < m.length; f++) {
			if(m[f][0] == 0) {
				m[f][0] = 0;
			}
		}if(columnaTieneDisponible(m, 0)) {
			insertarFichaMovimientoDerechaOIzquierda(m, 0, valorNuevo);
		}	
	}
	
	public static void moverPorColumnasIzquierda(int[][] m, int valorNuevo) {
		for(int c = 0; c < m[0].length-1; c++ ) {
			for(int f = 0; f < m.length; f++) {
				if(m[f][c] == 0) {
					m[f][c] = m[f][c+1];
					m[f][c+1] = 0;
				}else if((m[f][c] == 1 && m[f][c+1] == 2) || (m[f][c] == 2 && m[f][c+1] == 1)) {
					m[f][c] = 3;
					m[f][c+1] = 0;
					Puntaje.sumarPuntaje(3);
				}else if(m[f][c] == m[f][c+1] && m[f][c] != 1 && m[f][c] != 2) {
					m[f][c] = m[f][c]+m[f][c+1];
					Puntaje.sumarPuntaje(m[f][c]+m[f][c+1]);
					m[f][c+1] = 0;
				}
			}
		}for(int f = 0; f < m.length; f++) {
			if(m[f][3] == 0) {
				m[f][3] = 0;
			}
		}if(columnaTieneDisponible(m, 3)) {
			insertarFichaMovimientoDerechaOIzquierda(m, 3, valorNuevo);
		}
	}
	
}
