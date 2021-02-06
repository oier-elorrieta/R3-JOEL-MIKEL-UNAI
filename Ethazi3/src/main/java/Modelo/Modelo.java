package Modelo;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Modelo {

	private ArrayList<Karritoa> karroa = new ArrayList<Karritoa>();

	public String[] produktuakJaso() {
		return metodoak.sartuSalgaiak();
	}

	public ArrayList<Karritoa> sartu(String elikagaia, int kopuru) {
		return metodoak.sartuProduktuaArrayan(elikagaia, kopuru, karroa);
	}

	public String pantailaratu() {
		return metodoak.pantailatuProduktua(karroa);
	}

	public double diruTotala() {
		return metodoak.diruTotala(karroa);
	}

	public ArrayList<Karritoa> ezabatu() {
		return metodoak.ezabatuArraya(karroa);
	}

	public ImageIcon argazkiaAukeratu(String aukera) {
		return metodoak.argazkiaAukeratu(aukera);
	}

	public ArrayList<Karritoa> kk(ArrayList<Karritoa> karroa) {
		return karroa;
	}
	
	private int TransferentziaZbk = 1;
	
	public int gehituTransferentziaZenbakia() {
		TransferentziaZbk =  metodoak.gehituTransferentziaZenbakia(TransferentziaZbk);
		return TransferentziaZbk;
	}

	// *****************************************************************************************************************************************************************

	private String NIF = null;
	
	public String sartuDatuak(String izena, String abizena, String pasahitza, String dni, String nif) throws ClassNotFoundException, SQLException {

		return metodoak.sartuDatuak(izena, abizena, pasahitza, dni, nif);
	}

	public String konprobatuErabiltzailea(String erabiltzailea, String pasahitza) {
		return metodoak.konprobatuErabiltzailea(erabiltzailea, pasahitza);
	}

	public String komprobatuLokala(String erabiltzailea) {
		return metodoak.komprobatuLokala(erabiltzailea);
	}
	
	public String komprobatuLokala2() {
		return metodoak.komprobatuLokala(NIF);
	}
	
	public String sartuTicket() {
		return metodoak.sartuTicket(NIF, diruTotala(), TransferentziaZbk);
	}

	public String sartuEskaera(String helbidea) {
		return metodoak.sartuEskaera(NIF, diruTotala(), helbidea, TransferentziaZbk);
	}
	
	public String sartuFaktura(String izena, String abizena) {
		return metodoak.sartuFaktura(NIF, izena, abizena, diruTotala(), TransferentziaZbk);
	} 
	
	public String konprobatuNIF(String erabiltzailea) {
		NIF = metodoak.komprobatuNIF(erabiltzailea);
		return NIF;
	}
}
