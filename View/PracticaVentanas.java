package View;

import java.util.Random;

public class PracticaVentanas {
	
	static int[][] mModelo = {{0,0,0,0}, 
							  {0,2,1,0}, 
							  {1,0,0,3}, 
							  {0,0,0,0}};
	
	
	static int [][] m = {{0,0,0,0}, 
						 {0,2,1,0}, 
						 {1,0,0,3}, 
						 {0,0,0,0}};
	
	static int puntaje = 0;
	
	static void reiniciarTablero() {
		for(int f = 0; f < mModelo.length; f++) {
			for(int c = 0; c < mModelo[0].length; c++) {
				m[f][c] = mModelo[f][c];
			}
		}puntaje = 0;
	}

	static String[] historialDePuntajes = new String[] {"Franco", "1000", "Gonza", "800", "David", "600"};

	
	public static void actualizarTablaDePuntajes(String nombre, String puntaje) {
		for(int i = 1; i < historialDePuntajes.length; i+=2) {
			if(Integer.parseInt(historialDePuntajes[i]) < Integer.parseInt(puntaje)) {
				historialDePuntajes[i] = puntaje;
				historialDePuntajes[i-1] = nombre;
				break;
			}
		}
		
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
				}if(f < 3 && c == 3) {
					if(puedenSumarse(mat[f][c], mat[f+1][c])) {
						return true;
					}
				}if(f == 3 && c < 3) {
					if(puedenSumarse(mat[f][c], mat[f][c+1])) {
						return true;
					}
				}
			}
		}return false;
	}
	
	public static String getM(int[][] m, int f, int c) {
		return String.valueOf(m[f][c]);
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
	
	public static void sumarPuntaje(int valor) {
		puntaje += valor;
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
					sumarPuntaje(3);
				}else if(m[f][c] == m[f+1][c] && m[f][c] != 1 && m[f][c] != 2) {
					m[f][c] = m[f][c]+m[f+1][c];
					sumarPuntaje(m[f][c]+m[f+1][c]);
					m[f+1][c] = 0;
				}
			}
		}for(int c = 0; c < m[0].length; c++) {
			if(m[3][c] == 0) {
				m[3][c] = 0;
			}
		}int valor = valorNuevo;
		int posicion = nuevaPosicionAIntertar();
		if(filaTieneDisponible(m, 3)) {
			while(m[3][posicion] != 0) {
				posicion = nuevaPosicionAIntertar();
		}
		}	m[3][posicion] = valor;
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
					sumarPuntaje(3);
				}else if(m[f][c] == m[f-1][c] && m[f][c] != 1 && m[f][c] != 2) {
					m[f][c] = m[f][c]+m[f-1][c];
					sumarPuntaje(m[f][c]+m[f-1][c]);
					m[f-1][c] = 0;
				}
			}
		}for(int c = 0; c < m[0].length; c++) {
			if(m[0][c] == 0) {
				m[0][c] = 0;
			}
		}int valor = valorNuevo;
		int posicion = nuevaPosicionAIntertar();
		if(filaTieneDisponible(m, 0)) {
			while(m[0][posicion] != 0) {
				posicion = nuevaPosicionAIntertar();
		}
		}m[0][posicion] = valor;
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
					sumarPuntaje(3);
				}else if(m[f][c] == m[f][c-1] && m[f][c] != 1 && m[f][c] != 2) {
					m[f][c] = m[f][c]+m[f][c-1];
					sumarPuntaje(m[f][c]+m[f][c-1]);
					m[f][c-1] = 0;
					
				}			
			}
		}for(int f = 0; f < m.length; f++) {
			if(m[f][0] == 0) {
				m[f][0] = 0;
			}
		}int valor = valorNuevo;
		int posicion = nuevaPosicionAIntertar();
		if(columnaTieneDisponible(m, 0)) {
			while(m[posicion][0] != 0) {
				posicion = nuevaPosicionAIntertar();
		}
		}m[posicion][0] = valor;
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
					sumarPuntaje(3);
				}else if(m[f][c] == m[f][c+1] && m[f][c] != 1 && m[f][c] != 2) {
					m[f][c] = m[f][c]+m[f][c+1];
					sumarPuntaje(m[f][c]+m[f][c+1]);
					m[f][c+1] = 0;
					
				}
			}
		}for(int f = 0; f < m.length; f++) {
			if(m[f][3] == 0) {
				m[f][3] = 0;
			}
		}int valor = valorNuevo;
		int posicion = nuevaPosicionAIntertar();
		if(columnaTieneDisponible(m, 3)) {
			while(m[posicion][3] != 0) {
				posicion = nuevaPosicionAIntertar();
		}
		}m[posicion][3] = valor;
	}
	
	public static void imprimirMatriz(int[][] m) {
		for(int f = 0; f < m.length; f++) {
			System.out.print("[ ");
			for(int c = 0; c < m[0].length; c++ ) {
				System.out.print(m[f][c] + " ");
			}System.out.println("]");
		}System.out.println();
	}
	
	public static void insertarEnMovimientoDerecha(int[][] matriz, int posicion, int valor) {
		matriz[posicion][0] = valor;
	}
	
	public static void insertarEnMovimientoIzquierda(int[][] matriz, int posicion, int valor) {
		matriz[posicion][3] = valor;
	}
	
	public static void insertarEnMovimientoArriba(int[][] matriz, int posicion, int valor) {
		matriz[3][posicion] = valor;
	}
	
	public static void insertarEnMovimientoAbajo(int[][] matriz, int posicion, int valor) {
		matriz[0][posicion] = valor;
	}
	
	public static int nuevoNumeroAInsertar() {
		Random rand = new Random();
		int numeroNuevo = rand.nextInt(3) + 1;
		return numeroNuevo;
	}
	
	public static int nuevaPosicionAIntertar() {
		Random rand = new Random();
		int numeroNuevo = rand.nextInt(4);
		return numeroNuevo;
	}
		
public static void main(String[] args) {

	 int [][] mat = {{0,0,0,0}, 
			 {0,2,1,0}, 
			 {1,0,0,3}, 
	  		 {0,0,0,0}};
	
	imprimirMatriz(mat);
	//moverPorColumnasIzquierda(mat);
	imprimirMatriz(mat);

	}
}

