package Model;

public class Juego1 {
	private Tablero tablero;
	
	public Juego1() {
		tablero = new Tablero();
	}
	public void Mostrar() {
		tablero.Imprimir();
		tablero.moverIzquierda();
		tablero.Imprimir();
		tablero.moverArriba();
		tablero.Imprimir();
		tablero.moverDerecha();
		tablero.Imprimir();
		tablero.moverDerecha();
		tablero.Imprimir();
		tablero.moverDerecha();
		tablero.Imprimir();
	}
	
	public static void main(String[] args){
		Juego1 juego = new Juego1();
		juego.Mostrar();
	}
}
