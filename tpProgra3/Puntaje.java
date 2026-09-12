package tpProgra3;

import java.util.LinkedList;

public class Puntaje {

	private static int puntaje = 0;
	private static LinkedList<String[]> historialDePuntaje = new LinkedList<>(
			java.util.Arrays.asList(new String[] {"Franco", "1000"},
					new String[] {"Gonza", "800"},
					new String[] {"David", "600"}));
	
	public static void sumarPuntaje(int valor) {
		puntaje += valor;
	}
	
	public static void reiniciarPuntaje() {
		puntaje = 0;
	}
	
	public static void actualizarTablaDePuntajes(String nombre, String puntaje) {
		String[] nuevo = {nombre, puntaje};
		int cont = 0;
		for(String[] arr : historialDePuntaje) {
			if(Integer.parseInt(arr[1]) < Integer.parseInt(puntaje)) {
				historialDePuntaje.add(cont, nuevo);
				break;
			}cont++;
		}	
	}	

	public static int getPuntaje() {
		return puntaje;
	}
	
	public static String getPuntajeString() {
		return String.valueOf(puntaje);
	}

	public static LinkedList<String[]> getHistorialDePuntaje() {
		return historialDePuntaje;
	}
	
	
	
}
