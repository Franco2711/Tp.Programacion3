package tpProgra3;

public class Matriz {

	private int[][] matriz;
	
	public Matriz() {	
		this.matriz = new int[4][4];
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
