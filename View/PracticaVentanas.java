package View;

public class PracticaVentanas {
	
	static int [][] m = {{0,0,0,0}, 
			 {0,2,1,0}, 
			 {1,0,0,3}, 
	  		 {0,0,0,0}};

	public static String getM(int[][] m, int f, int c) {
		return String.valueOf(m[f][c]);
	}
	
	public static void moverPorFilasArriba(int[][] m) {
		for(int f = 0; f < m.length-1; f++) {
			for(int c = 0; c < m[0].length; c++ ) {
				m[f][c] = m[f+1][c];
			}
		}for(int c = 0; c < m[0].length-1; c++) {
			m[3][c] = 0;
		}
	}
	
	public static void moverPorFilasAbajo(int[][] m) {
		for(int f = 3; f > 0; f--) {
			for(int c = 0; c < m[0].length; c++ ) {
				m[f][c] = m[f-1][c];
			}
		}for(int c = 0; c < m[0].length-1; c++) {
			m[0][c] = 0;
		}
	}
	
	public static void moverPorColumnasDerecha(int[][] m) {
		for(int c = 3; c > 0; c-- ) {
			for(int f = 0; f < m.length; f++) {
				m[f][c] = m[f][c-1];
			}
		}for(int f = 0; f < m.length; f++) {
			m[f][0] = 0;
		}
	}
	
	public static void moverPorColumnasIzquierda(int[][] m) {
		for(int c = 0; c < m[0].length-1; c++ ) {
			for(int f = 0; f < m.length-1; f++) {
				m[f][c] = m[f][c+1];
			}
		}for(int f = 0; f < m[0].length-1; f++) {
			m[f][3] = 0;
		}
	}
	public static void imprimirMatriz(int[][] m) {
		for(int f = 0; f < m.length; f++) {
			System.out.print("[ ");
			for(int c = 0; c < m[0].length; c++ ) {
				System.out.print(m[f][c] + " ");
		}System.out.println("]");
	}System.out.println();
	}
		
public static void main(String[] args) {

	 int [][] mat = {{0,0,0,0}, 
			 {0,2,1,0}, 
			 {1,0,0,3}, 
	  		 {0,0,0,0}};
	
	imprimirMatriz(mat);
	moverPorColumnasIzquierda(mat);
	imprimirMatriz(mat);

	}
}

