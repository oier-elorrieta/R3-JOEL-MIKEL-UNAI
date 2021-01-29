package Modelo;

import java.util.ArrayList;

public class Modelo {

	private ArrayList<Karrito> karroa = new ArrayList<Karrito>();

	public String[] produktuakJaso() {
		return metodos.sartuSalgaiak();
	}

	public ArrayList<Karrito> sartu(String elikagaia,int kopuru) {
		return metodos.sartu(elikagaia, kopuru, karroa); 
	}
	 
	public String pantailaratu() {
		return metodos.pantailatu(karroa);
	}
	public int diruTotala() {
		return metodos.diruTotala(karroa);
	}
}
