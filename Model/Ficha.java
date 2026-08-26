package Model;

public class Ficha {
	private int contenido;
	
	public Ficha() {
		contenido=0;
	}
	
	public Ficha(int valor) {
		contenido=valor;
	}
	public int Numero() {
		return contenido;
	}
	public boolean esCombinable(Ficha ficha2) {
		if (this.contenido==ficha2.contenido)
			return true;
		if (this.contenido==1 && ficha2.contenido==2 || this.contenido==2 && ficha2.contenido==1)
			return true;
		return false;
		
	}
}
