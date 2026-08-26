package Model;

public class Juego {
	private Tablero tablero;
	
	public Juego() {
		tablero = new Tablero();
	}
	public void Mostrar() {
		tablero.Imprimir();
		tablero.moverDerecha();
		tablero.Imprimir();
		tablero.moverDerecha();
		tablero.Imprimir();
		tablero.moverDerecha();
		tablero.Imprimir();
	}
	
	public static void main(String[] args){
		Juego juego = new Juego();
		juego.Mostrar();
	}
}
