package tpProgra3;

import java.util.LinkedList;
import java.util.Random;

public class Threes {
	
	private int valorNuevaFicha = nuevoNumeroAInsertar();
	private int puntaje = 0;
	private String[] tablaDePuntajesNombres = new String[3];
	private int[] tablaDePuntajesPuntos = new int[3];
	private boolean hayMovimientos;
	private Matriz matriz;
	
	public Threes() {
		this.matriz = new Matriz();
		iniciarMatriz(matriz);
	}
	
	public void reiniciarJuego() {
		iniciarMatriz(matriz);
		puntaje = 0;
		hayMovimientos = true;
	}
	
	public boolean quedanMovimientos() {
		return hayMovimientos = hayMovimientosDisponibles();
	}
	
	public void sumarPuntaje() {
		for(int f = 0; f < matriz.getLargoFilasMatriz(); f++) {
			for(int c = 0; c < matriz.getLargoColumnasMatriz(); c++) {
				puntaje = puntaje + matriz.getValor(f, c);
			}
		}
	}
	
	public int getPuntaje() {
		return puntaje;
	}
	
	public void actualizarPuntajes(int puntaje, int ubicacion) {
		for(int i = 0; i < tablaDePuntajesPuntos.length; i++) {
			if(i == ubicacion) {
				tablaDePuntajesPuntos[i] = puntaje;
			}
		}
	}
	
	public void actualizarTablaDePuntajes(String nombre, int puntaje) {
		int ubicacion = 0;
		for(int i = 0; i < tablaDePuntajesPuntos.length; i++) {
			if(puntaje > tablaDePuntajesPuntos[i]) {
				ubicacion = i;
				break;
			}
		}tablaDePuntajesPuntos[ubicacion] = puntaje;
		tablaDePuntajesNombres[ubicacion] = nombre;
	}
	
	public String getNombrePuntaje(int posicion) {
		return tablaDePuntajesNombres[posicion];
	}
	
	public int getPuntosPuntaje(int posicion) {
		return tablaDePuntajesPuntos[posicion];
	}
	
	public int getValorNuevaFicha() {
		return valorNuevaFicha;
	}
	
	public int getValorFicha(int fila, int columna) {
		return matriz.getValor(fila, columna);
	}
	
	public int nuevoNumeroAInsertar() {
		Random rand = new Random();
		int numeroNuevo = rand.nextInt(3) + 1;
		return numeroNuevo;
	}
	
	public int nuevaPosicionAIntertar() {
		Random rand = new Random();
		int numeroNuevo = rand.nextInt(4);
		return numeroNuevo;
	}
	
	public boolean puedenSumarse(int f, int c) {
		if((f == 1 && c == 2) || (f == 2 && c == 1) || (f == c && f >= 3 && c >= 3)){
			return true;
		}return false;
	}
	
	private void insertarFichaMovimientoArribaOAbajo(int fila, int valorNuevo) {
		int posicion = nuevaPosicionAIntertar();
		while(matriz.getValor(fila, posicion) != 0) {
			posicion = nuevaPosicionAIntertar();
		}matriz.setValor(fila, posicion, valorNuevo);
	}

	public void insertarFichaMovimientoDerechaOIzquierda(int columna, int valorNuevo) {
		int posicion = nuevaPosicionAIntertar();
		while(matriz.getValor(posicion, columna) != 0) {
			posicion = nuevaPosicionAIntertar();
		}matriz.setValor(posicion, columna, valorNuevo);
	}
	
	public boolean hayMovimientosDisponibles() {
		if(matriz.filaTieneDisponible(0) || matriz.filaTieneDisponible(3) ||
				matriz.columnaTieneDisponible(0) || matriz.columnaTieneDisponible(3)) {
			return true;
		}
		for(int f = 0; f < matriz.getLargoFilasMatriz(); f++) {
			for(int c = 0; c < matriz.getLargoColumnasMatriz(); c++) {
				if(f < 3 && c < 3) {
					if(puedenSumarse(matriz.getValor(f, c), matriz.getValor(f+1, c)) ||
							puedenSumarse(matriz.getValor(f, c), matriz.getValor(f, c+1))) {
						return true;
					}
				}else if(f < 3 && c == 3) {
					if(puedenSumarse(matriz.getValor(f, c), matriz.getValor(f+1, c))) {
						return true;
					}
				}else if(f == 3 && c < 3) {
					if(puedenSumarse(matriz.getValor(f, c), matriz.getValor(f, c+1))) {
						return true;
					}
				}
			}
		}return false;
	}	
	
	public void sumarValoresDeMatrizArribaOAbajo(int fila, int columna, int valor, String mov) {
		matriz.setValor(fila, columna, valor);
		if(mov.equals("arriba")) {
			matriz.setValor(fila+1, columna, 0);
		}else if(mov.equals("abajo")) {
			matriz.setValor(fila-1, columna, 0);
		}else if(mov.equals("der")) {
			matriz.setValor(fila, columna-1, 0);
		}else if(mov.equals("izq")) {
			matriz.setValor(fila, columna+1, 0);
		}
		
	}
	
	public void valoresFilaACero(int fila) {
		for(int c = 0; c < matriz.getLargoColumnasMatriz(); c++) {
			if(matriz.getValor(fila, c) == 0) {
				matriz.setValor(fila, c, 0);
			}
		}
	}
	
	public void valoresColumnaACero(int columna) {
		for(int f = 0; f < matriz.getLargoFilasMatriz(); f++) {
			if(matriz.getValor(f, columna) == 0) {
				matriz.setValor(f, columna, 0);
			}
		}
	}
	
	public void insertarNuevaFichaEnFila(int fila) {
		if(matriz.filaTieneDisponible(fila)) {
			insertarFichaMovimientoArribaOAbajo(fila, valorNuevaFicha);
		}int nuevoValorParaFicha = nuevoNumeroAInsertar();
		while(nuevoValorParaFicha == valorNuevaFicha) {
			nuevoValorParaFicha = nuevoNumeroAInsertar();
		}valorNuevaFicha = nuevoValorParaFicha;
	}
	
	public void insertarNuevaFichaEnColumna(int columna) {
		if(matriz.columnaTieneDisponible(columna)) {
			insertarFichaMovimientoDerechaOIzquierda(columna, valorNuevaFicha);
		}int nuevoValorParaFicha = nuevoNumeroAInsertar();
		while(nuevoValorParaFicha == valorNuevaFicha) {
			nuevoValorParaFicha = nuevoNumeroAInsertar();
		}valorNuevaFicha = nuevoValorParaFicha;
	}
	
	public void moverPorFilasArriba() {
		for(int f = 0; f < matriz.getLargoFilasMatriz()-1; f++) {
			for(int c = 0; c < matriz.getLargoColumnasMatriz(); c++ ) {
				if(matriz.getValor(f, c) == 0) {
					sumarValoresDeMatrizArribaOAbajo(f, c, matriz.getValor(f+1, c), "arriba");
				}else if((matriz.getValor(f, c) == 1 && matriz.getValor(f+1, c) == 2) ||
						(matriz.getValor(f, c) == 2 && matriz.getValor(f+1, c) == 1)) {
					sumarValoresDeMatrizArribaOAbajo(f, c, 3, "arriba");
				}else if(matriz.getValor(f, c) == matriz.getValor(f+1, c) && 
						matriz.getValor(f, c) != 1 && matriz.getValor(f, c) != 2) {
					sumarValoresDeMatrizArribaOAbajo(f, c, (matriz.getValor(f, c)+matriz.getValor(f+1, c)), "arriba");
				}
			}
		}valoresFilaACero(3);
		insertarNuevaFichaEnFila(3);		
	}
	
	public void moverPorFilasAbajo() {
		for(int f = 3; f > 0; f--) {
			for(int c = 0; c < matriz.getLargoColumnasMatriz(); c++ ) {
				if(matriz.getValor(f, c) == 0) {
					sumarValoresDeMatrizArribaOAbajo(f, c, matriz.getValor(f-1, c), "abajo");
				}else if((matriz.getValor(f, c) == 1 && matriz.getValor(f-1, c) == 2) ||
						(matriz.getValor(f, c) == 2 && matriz.getValor(f-1, c) == 1)) {
					sumarValoresDeMatrizArribaOAbajo(f, c, 3, "abajo");
				}else if(matriz.getValor(f, c) == matriz.getValor(f-1, c) &&
						matriz.getValor(f, c) != 1 && matriz.getValor(f, c) != 2) {
					sumarValoresDeMatrizArribaOAbajo(f, c, (matriz.getValor(f, c)+matriz.getValor(f-1, c)), "abajo");
				}
			}
		}valoresFilaACero(0);
		insertarNuevaFichaEnFila(0);
	}
	
	public void moverPorColumnasDerecha() {
		for(int c = 3; c > 0; c-- ) {
			for(int f = 0; f < matriz.getLargoFilasMatriz(); f++) {
				if(matriz.getValor(f, c) == 0) {
					sumarValoresDeMatrizArribaOAbajo(f, c, matriz.getValor(f, c-1), "der");
				}else if((matriz.getValor(f, c) == 1 && matriz.getValor(f, c-1) == 2) ||
						(matriz.getValor(f, c) == 2 && matriz.getValor(f, c-1) == 1)) {
					sumarValoresDeMatrizArribaOAbajo(f, c, 3, "der"); 
				}else if(matriz.getValor(f, c) == matriz.getValor(f, c-1) &&
						matriz.getValor(f, c) != 1 && matriz.getValor(f, c) != 2) {
					sumarValoresDeMatrizArribaOAbajo(f, c, (matriz.getValor(f, c)+matriz.getValor(f, c-1)), "der");					
				}			
			}
		}valoresColumnaACero(0);
		insertarNuevaFichaEnColumna(0);	
	}
	
	public void moverPorColumnasIzquierda() {
		for(int c = 0; c < matriz.getLargoColumnasMatriz()-1; c++ ) {
			for(int f = 0; f < matriz.getLargoFilasMatriz(); f++) {
				if(matriz.getValor(f, c) == 0) {
					sumarValoresDeMatrizArribaOAbajo(f, c, matriz.getValor(f, c+1), "izq");
				}else if((matriz.getValor(f, c) == 1 && matriz.getValor(f, c+1) == 2) ||
						(matriz.getValor(f, c) == 2 && matriz.getValor(f, c+1) == 1)) {
					sumarValoresDeMatrizArribaOAbajo(f, c, 3, "izq");
				}else if(matriz.getValor(f, c) == matriz.getValor(f, c+1) &&
						matriz.getValor(f, c) != 1 && matriz.getValor(f, c) != 2) {
					sumarValoresDeMatrizArribaOAbajo(f, c, (matriz.getValor(f, c)+matriz.getValor(f, c+1)), "izq");
				}
			}
		}valoresColumnaACero(3);
		insertarNuevaFichaEnColumna(3);
	}
	
	public void iniciarMatriz(Matriz m) {
		for(int f = 0; f < m.getLargoFilasMatriz(); f++) {
			for(int c = 0; c < m.getLargoColumnasMatriz(); c++) {
				if(f == 0 && c == 1) {
					m.setValor(f, c, 1);
				}else if((f == 1 && c == 1) || (f == 1 && c == 2)) {
					m.setValor(f, c, 2);
				}else if((f == 2 && c == 1) || (f == 2 && c == 2)) {
					m.setValor(f, c, 1);
				}else if(f == 3 && c == 1) {
					m.setValor(f, c, 2);
				}else {
					m.setValor(f, c, 0);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		
		Threes threes = new Threes();
		VentanaPrincipal nuevaVentana = new VentanaPrincipal(threes);
		//nuevaVentana.setVisible(true);

	}

}
