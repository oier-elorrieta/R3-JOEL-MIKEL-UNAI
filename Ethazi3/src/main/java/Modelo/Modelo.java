package Modelo;

import java.sql.SQLException;
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

	public ArrayList<Karritoa> kk(ArrayList<Karritoa> karroa) {
		return karroa;
	}
	
	// *****************************************************************************************************************************************************************
	
	private String NIF = null;

	public String sartuDatuak(String izena, String abizena, String pasahitza, String dni, String nif) throws ClassNotFoundException, SQLException {
		return metodoak.sartuDatuak(izena, abizena, pasahitza, dni, nif);
	}

	public String konprobatuErabiltzailea(String erabiltzailea, String pasahitza) {
		NIF = metodoak.konprobatuErabiltzailea(erabiltzailea, pasahitza);
		return NIF;
	}

	public String sartuTicket() {
		return metodoak.sartuTicket(NIF, diruTotala());
	}

	public String sartuEskaera() {
		return metodoak.sartuEskaera(NIF, diruTotala());
	}
}
