package Modelo;

import java.util.ArrayList;

public class Modelo {

	private ArrayList<Karrito> karroa = new ArrayList<Karrito>();

	public String[] produktuakJaso() {
		return metodos.sartuSalgaiak();
	}

	public ArrayList<Karrito> sartu(String elikagaia,int kopuru) {
		return metodos.sartuProduktuaArrayan(elikagaia, kopuru, karroa); 
	}
	 
	public String pantailaratu() {
		return metodos.pantailatuProduktua(karroa);
	}
	
	public double diruTotala() {
		return metodos.diruTotala(karroa);
	}
	
	public ArrayList<Karrito> ezabatu(){
		return metodos.ezabatuArraya(karroa);
	}
}
