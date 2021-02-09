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

	private int TransferentziaZbk = 1;

	public int TranferentziaZbk() {
		return TransferentziaZbk;
	}

	public int gehituTransferentziaZenbakia() {
		TransferentziaZbk =	metodoak.gehituTransferentziaZenbakia(TransferentziaZbk);
		return TransferentziaZbk;
	}

	// *****************************************************************************************************************************************************************

	private String NIF = null;

	public String NIF() {
		return NIF;
	}
	
	public void sartuDatuak(String izena, String abizena, String pasahitza, String dni, String nif) throws ClassNotFoundException, SQLException {
		metodoak.sartuDatuak(izena, abizena, pasahitza, dni, nif);
	}

	public String konprobatuErabiltzailea(String erabiltzailea, String pasahitza) {
		return metodoak.konprobatuErabiltzailea(erabiltzailea, pasahitza);
	}

	public String konprobatuLokala(String erabiltzailea) {
		return metodoak.konprobatuLokala(erabiltzailea);
	}

	public String konprobatuLokala2() {
		return metodoak.konprobatuLokala(NIF);
	}

	public void sartuTicket() {
		metodoak.sartuTicket(NIF, diruTotala(), TransferentziaZbk);
	}

	public void sartuEskaera(String helbidea) {
		metodoak.sartuEskaera(NIF, diruTotala(), helbidea, TransferentziaZbk);
	}

	public void sartuFaktura(String izena, String abizena) {
		metodoak.sartuFaktura(NIF, izena, abizena, diruTotala(), TransferentziaZbk);
	} 

	public String konprobatuNIF(String erabiltzailea) {
		NIF = metodoak.konprobatuNIF(erabiltzailea);
		return NIF;
	}

	public String konprobatuLokalarenIzena() {
		return metodoak.konprobatuLokalarenIzena(NIF);
	}
}
