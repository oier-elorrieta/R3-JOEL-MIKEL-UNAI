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

	public void sartuTiene()  {
		try {
			metodoak.sartuTiene(karroa, jasoTransakzioZbk()); 
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
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

	public ImageIcon argazkiaPlaterraAukeratu(String aukera) {
		return metodoak.argazkiaPlaterraAukeratu(aukera);
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

	public boolean begiratuDNI(String dni) {
		return metodoak.begiratuDNI(dni);
	}

	public boolean begiratuNIF(String nif) {
		return metodoak.begiratuNIF(nif);
	}

	public int begiratuStock(String produktua,String nif) {
		return metodoak.begiratuStock(produktua, nif);
	}

	public void sartuHornikuntza(String produktua,int año, int mes, int dia, String nif, int kantitatea) throws ClassNotFoundException, SQLException {
		metodoak.sartuHornikuntza(produktua, año, mes, dia, nif, kantitatea, karroa);
	}

	public String[] platerrakJaso() {
		return metodoak.sartuPlaterrak();
	}

	public String[] platerMotak(){
		return metodoak.platerMotak();
	}

	public String[] platerMota(String platerMota, String tipoa){
		return metodoak.platerMota(platerMota, tipoa);
	}
	public int platerKodea(String platerra){
		return metodoak.jasoPlaterKodea(platerra);
	}

	public void sartuKomanda(int año, int mes, int dia) throws ClassNotFoundException, SQLException{
		metodoak.sartuKomanda(diruTotala(), metodoak.jasoTransakzioZbk(),konprobatuNIF(), año, mes, dia);
	} 
	public void incluye(int platerKodea, int kantitatea) throws ClassNotFoundException, SQLException {
		metodoak.incluye(platerKodea, kantitatea, diruTotala(), konprobatuNIF());
	}
	
	public void hasieratuOperaciones() throws ClassNotFoundException, SQLException {
		metodoak.hasieratuOperaciones();
	}
	
	public void ofrece() {
		metodoak.ofrece(konprobatuNIF());
	}

	public String[] platerMotaArabera(String platerMota) {
		return metodoak.platerMotaArabera(platerMota);
	}

	public void ezabatuKomanda() throws ClassNotFoundException, SQLException {
		metodoak.ezabatuKomanda();
	}
}
