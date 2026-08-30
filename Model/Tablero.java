package Model;
import java.util.Random;


public class Tablero {

	private int[][] tablero;
	
	public Tablero() {
		tablero = new int[4][4];
		Iniciar();
	}
	public void Iniciar() {
		int num1=1;
		int num2=3;
		int num3=6;
		Random aleatorio = new Random();
		int Fila1 = aleatorio.nextInt(4);
		int Columna1 = aleatorio.nextInt(4);
		int Fila2 = aleatorio.nextInt(4);
		int Columna2 = aleatorio.nextInt(4);
		System.out.println(Fila1+ "-"+ Columna1+ "-"+ num1);
		System.out.println(Fila2+ "-"+ Columna2+ "-"+num2);
		System.out.println();
		tablero[0][3]= 1;
		while (!estaVacio(Fila2, Columna2)) {
			Fila2 = aleatorio.nextInt(4);
			Columna2 = aleatorio.nextInt(4);
		}	
		tablero[0][1]= num2;
		tablero[0][0]= num3;
		tablero[1][3]=2;
		tablero[1][2]=2;
	}

	public void Imprimir() {
		for (int i=0; i<4; i++) {
			for (int j=0; j<4; j++) {
				System.out.print(tablero[i][j]+"-");
				if (j==3)
					System.out.println();
			}
		}
		System.out.println();
	}
	public boolean estaVacio(int fila, int columna) {
			if (tablero[fila][columna]==0)
					return true;
			return false;
		}
	public void moverDerecha() {
		for (int i=0; i<4;i++) {
			boolean movio=false;
			int j=3;
			int[] fila = new int[4];
			while(j>0) {
				if (tablero[i][j]==0 && tablero[i][j-1]!=0) {
					fila[j]=tablero[i][j-1];
					tablero[i][j-1]=0;
					movio=true;
					j--;
				}
				else if (esCombinable(tablero[i][j], tablero [i][j-1])){
					System.out.println ("entro");
					fila[j]=(tablero[i][j]+tablero[i][j-1]);
					tablero[i][j-1]=0;
					movio=true;
					j--;
				}
				else {
					fila[j]=tablero[i][j];
					j--;
				}
			}
			if (movio) {
				for (int k=0;k<4;k++) {
				tablero[i][k]=fila[k];
				}
			}
		}
	}
	public void moverIzquierda() {
		for (int i=0; i<4;i++) {
			boolean movio=false;
			int j=0;
			int[] fila = new int[4];
			while(j<3) {
				if (tablero[i][j]==0 && tablero[i][j+1]!=0) {
					fila[j]=tablero[i][j+1];
					tablero[i][j+1]=0;
					movio=true;
					j++;
				}
				else if (esCombinable(tablero[i][j], tablero [i][j+1])){
					System.out.println ("entro");
					fila[j]=(tablero[i][j]+tablero[i][j+1]);
					tablero[i][j+1]=0;
					movio=true;
					j++;
				}
				else {
					fila[j]=tablero[i][j];
					j++;
				}
			}
			if (movio) {
				for (int k=0;k<4;k++) {
				tablero[i][k]=fila[k];
				}
			}
		}
	}
	public void moverAbajo() {
		for (int i=0; i<4;i++) {
			boolean movio=false;
			int j=3;
			int[] fila = new int[4];
			while(j>0) {
				if (tablero[j][i]==0 && tablero[j-1][i]!=0) {
					fila[j]=tablero[j-1][i];
					tablero[j-1][i]=0;
					movio=true;
					j--;
				}
				else if (esCombinable(tablero[j][i], tablero[j-1][i])){
					System.out.println ("entro");
					fila[i]=(tablero[j][i]+tablero[j-1][i]);
					tablero[j-1][i]=0;
					movio=true;
					j--;
				}
				else {
					fila[j]=tablero[j][i];
					j--;
				}
			}
			if (movio) {
				for (int k=0;k<4;k++) {
				tablero[k][i]=fila[k];
				}
			}
		}
	}
	public void moverArriba() {
		for (int i=0; i<4;i++) {
			boolean movio=false;
			int j=0;
			int[] fila = new int[4];
			while(j<3) {
				if (tablero[j][i]==0 && tablero[j+1][i]!=0) {
					fila[j]=tablero[j+1][i];
					tablero[j+1][i]=0;
					movio=true;
					j++;
				}
				else if (esCombinable(tablero[j][i], tablero [j+1][i])){
					System.out.println ("entro");
					fila[j]=(tablero[j][i]+tablero[j+1][i]);
					tablero[j+1][i]=0;
					movio=true;
					j++;
				}
				else {
					fila[j]=tablero[j][i];
					j++;
				}
			}
			if (movio) {
				for (int k=0;k<4;k++) {
				tablero[k][i]=fila[k];
				}
			}
		}
	}
	public boolean esCombinable(int a, int b) {
		if (a!=1 && a!=2 && b!=1 && b!=2 && a!=0 && b!=0 && a==b)
			return true;
		if (a==1 && b==2 || a==2 && b==1)
			return true;
		return false;
	}
	public String getValor(int a, int b) {
		String valor = String.valueOf(tablero[a][b]);
		return valor;
	}
	public int[][] getTablero() {
		return tablero;
	}
	}
