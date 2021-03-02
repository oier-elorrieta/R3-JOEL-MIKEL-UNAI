package Controlador;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import Modelo.Karritoa;
import Modelo.Modelo;
import Modelo.metodoak;
import Vista.PanelKomanda;
import Vista.Vista;

public class ControladorPanelKomanda {

	private Vista vista;
	private Controlador controlador;
	private Modelo modelo;
	private PanelKomanda panelKomanda;
	
	public ControladorPanelKomanda(Modelo modelo, Vista vista, Controlador controlador) {
		this.vista = vista;
		this.controlador = controlador;    
		this.modelo = modelo;
	}
	
	public void ikusiPanelKomanda() {
		this.panelKomanda = new PanelKomanda(this);
		this.vista.ikusiPanela(this.panelKomanda);
	}
	
	public void sakatuLaburpeneraBotoia() {
		this.controlador.nabegatzenPanelLaburpena();
	}
	
	public void sakatuAtzeraBotoia() {
		this.controlador.nabegatzenPanelLogin();
		this.modelo.ezabatuProduktuenArraya();
	}
	
	public ArrayList<Karritoa> sartu(String elikagaia,int kopuru, boolean komanda) {
		return this.modelo.sartu(elikagaia, kopuru, komanda); 
	}  

	public double diruTotala() {
		return this.modelo.diruTotala();
	}	

	public ImageIcon argazkiaPlaterraAukeratu(String aukera) {
		return metodoak.argazkiaPlaterraAukeratu(aukera);
	}
	
	public int jasoTransakzioZbk() throws ClassNotFoundException, SQLException {
		return this.modelo.jasoTransakzioZbk();
	}

	public void sakatuPanelTabernaBotoia() {
		this.controlador.nabegatzenPanelTaberna();
		this.modelo.ezabatuProduktuenArraya();
	}

	public void sakatuPanelKafetegiaBotoia() {
		this.controlador.nabegatzenPanelKafetegia();
		this.modelo.ezabatuProduktuenArraya();
	}

	public void sakatuPanelJatetxeBotoia() {
		this.controlador.nabegatzenPanelJatetxea();
		this.modelo.ezabatuProduktuenArraya();
	}

	public String konprobatuLokala() {
		return this.modelo.konprobatuLokala();
	}
	
	public String konprobatuLokalarenIzena() {
		return this.modelo.konprobatuLokalarenIzena();
	}
	public String[] platerrakJaso() {
		return this.modelo.platerrakJaso();
	}
	
	public String[] platerMotak() {
		return this.modelo.platerMotak();
	}
	
	public String[] platerMota(String platerMota, String tipoa) {
		return this.modelo.platerMota(platerMota, tipoa);
	}
	
	public int platerKodea(String platerra){
		return this.modelo.platerKodea(platerra);
	}
	
	public void sartuKomanda(int a�o, int mes, int dia) throws ClassNotFoundException, SQLException{
		this.modelo.sartuKomanda(a�o, mes, dia);
	} 
	
	public void sartuIncluye(int platerKodea, int kantitatea) throws ClassNotFoundException, SQLException {
		this.modelo.sartuIncluye(platerKodea, kantitatea);
	}
	
	public String[] platerMotaArabera(String platerMota) {
		return this.modelo.platerMotaArabera(platerMota);
	}
	
	public void ezabatuKomanda() throws ClassNotFoundException, SQLException {
		this.modelo.ezabatuKomanda();
	}
}
