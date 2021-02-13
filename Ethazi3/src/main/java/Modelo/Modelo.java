package Modelo;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public class Modelo {

	private ArrayList<Karritoa> karroa = new ArrayList<Karritoa>();

	private Erabiltzaile usuarioa = new Erabiltzaile(null, null);													

	// *****************************************************************************************************************************************************************

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

	public ArrayList<Karritoa> ezabatuProduktuenArraya() {
		return metodoak.ezabatuArraya(karroa);
	}

	public ImageIcon argazkiaAukeratu(String aukera) {
		return metodoak.argazkiaAukeratu(aukera);
	}

	// *****************************************************************************************************************************************************************

	public void sartuDatuak(String izena, String abizena, String pasahitza, String dni, String nif) throws ClassNotFoundException, SQLException {
		metodoak.sartuDatuak(izena, abizena, pasahitza, dni, nif);
	}

	public Erabiltzaile sartuErabiltzailea(String erabiltzailea, String pasahitza) {
		return metodoak.sartuErabiltzailea(erabiltzailea, pasahitza,usuarioa);
	}

	public int jasoTransakzioZbk() throws ClassNotFoundException, SQLException {
		return metodoak.jasoTransakzioZbk();
	}
	
	public String konprobatuErabiltzailea(String erabiltzailea, String pasahitza) {
		return metodoak.konprobatuErabiltzailea(erabiltzailea, pasahitza);
	}

	public String konprobatuNIF () {
		return metodoak.konprobatuNIF(usuarioa.getErabiltzailea());
	}

	public String konprobatuLokala() {
		return metodoak.konprobatuLokala(usuarioa.getErabiltzailea());
	}
	
	public String konprobatuLokalarenIzena() {
		return metodoak.konprobatuLokalarenIzena(konprobatuNIF());
	}
	
	public void sartuTicket(int año, int mes, int dia) throws ClassNotFoundException, SQLException {
		metodoak.sartuTicket(konprobatuNIF(), diruTotala(), metodoak.jasoTransakzioZbk(), año, mes , dia);
	}

	public void sartuEskaera(String helbidea, int año, int mes, int dia) throws ClassNotFoundException, SQLException {
		metodoak.sartuEskaera(konprobatuNIF(), diruTotala(), helbidea, metodoak.jasoTransakzioZbk(), año, mes , dia);
	}

	public void sartuFaktura(String izena, String abizena, int año, int mes, int dia) throws ClassNotFoundException, SQLException {
		metodoak.sartuFaktura(konprobatuNIF(), izena, abizena, diruTotala(), metodoak.jasoTransakzioZbk(), año, mes , dia);
	} 

	public void gehituStocka(String nom_Produktua, int kantitatea, String nif){
		metodoak.gehituStocka(nom_Produktua, kantitatea, nif);
	} 
	
	public void kenduStocka(String nom_Produktua, int kantitatea, String nif){
		metodoak.kenduStocka(nom_Produktua, kantitatea, nif);
	} 
	public boolean begiratuDNI(String dni) {
		return metodoak.begiratuDNI(dni);
	}
	
	public boolean begiratuNIF(String nif) {
		return metodoak.begiratuNIF(nif);
	}
	
	public int begiratuStock(String produktua,String nif) {
		return metodoak.begiratuStock(produktua, nif);
	}
}
