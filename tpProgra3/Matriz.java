package tpProgra3;

public class Matriz {

	private int[][] matriz;
	
	public Matriz() {	
		this.matriz = new int[4][4];
	}
	
	public void iniciarMatriz() {
		for(int f = 0; f < matriz.length; f++) {
			for(int c = 0; c < matriz[0].length; c++) {
				if(f == 0 && c == 1) {
					matriz[f][c] = 1;
				}else if((f == 1 && c == 1) || (f == 1 && c == 2)) {
					matriz[f][c] = 2;
				}else if((f == 2 && c == 1) || (f == 2 && c == 2)) {
					matriz[f][c] = 1;
				}else if(f == 3 && c == 1) {
					matriz[f][c] = 2;
				}else {
					matriz[f][c] = 0;
				}
			}
		}
	}
	
	public int getValor(int fila, int columna) {
		return matriz[fila][columna];
	}
	
	public void setValor(int fila, int columna, int valor) {
		matriz[fila][columna] = valor;
	}
	
	public int getLargoFilasMatriz() {
		return matriz.length;
	}
	
	public int getLargoColumnasMatriz() {
		return matriz[0].length;
	}
	
	public boolean filaTieneDisponible(int fila) {
		for(int c = 0; c < matriz[0].length; c++) {
			if(matriz[fila][c] == 0) {
				return true;
			}
		}return false;
	}
	
	public boolean columnaTieneDisponible(int columna) {
		for(int f = 0; f < matriz.length; f++) {
			if(matriz[f][columna] == 0) {
				return true;
			}
		}return false;
	}
	
}
