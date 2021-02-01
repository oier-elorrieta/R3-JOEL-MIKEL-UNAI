package Modelo;

import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Modelo {

	private ArrayList<Karritoa> karroa = new ArrayList<Karritoa>();

	public String[] produktuakJaso() {
		return metodoak.sartuSalgaiak();
	}

	public ArrayList<Karritoa> sartu(String elikagaia,int kopuru) {
		return metodoak.sartuProduktuaArrayan(elikagaia, kopuru, karroa); 
	}
	 
	public String pantailaratu() {
		return metodoak.pantailatuProduktua(karroa);
	}
	
	public double diruTotala() {
		return metodoak.diruTotala(karroa);
	}
	
	public ArrayList<Karritoa> ezabatu(){
		return metodoak.ezabatuArraya(karroa);
	}
	
	public ImageIcon argazkiaAukeratu(String aukera) {
		return metodoak.argazkiaAukeratu(aukera);
	}
}
