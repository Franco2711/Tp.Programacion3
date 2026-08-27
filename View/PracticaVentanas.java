package View;

public class PracticaVentanas {
	
	static int [][] m = {{0,0,0,0}, 
			 {0,2,1,0}, 
			 {1,0,0,3}, 
	  		 {0,0,0,0}};

	public static String getM(int[][] m, int f, int c) {
		return String.valueOf(m[f][c]);
	}
	
	public static void moverPorFilas(int[][] m) {
		for(int f = 0; f < m.length-1; f++) {
			for(int c = 0; c < m[0].length; c++ ) {
				m[f][c] = m[f+1][c];
			}
		}for(int c = 0; c < m[0].length-1; c++) {
			m[3][c] = 0;
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
	moverPorFilas(mat);
	imprimirMatriz(mat);

	}
}

