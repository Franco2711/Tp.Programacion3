package tpProgra3;

//import tpProgra3Vista.VentanaPrincipal;

public class IniciarJuego {

	public static void main(String[] args) {
		Matriz matriz =  new Matriz();
		Threes threes = new Threes();
		VentanaPrincipal ventana = new VentanaPrincipal(threes);
	}
	
}