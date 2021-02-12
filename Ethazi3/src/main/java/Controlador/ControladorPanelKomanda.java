package Controlador;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import Modelo.Karritoa;
import Modelo.Modelo;
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
	
	public String[] ComboBoxaSakatu() {
		return this.modelo.produktuakJaso();
	}
	
	public ArrayList<Karritoa> sartu(String elikagaia,int kopuru) {
		return this.modelo.sartu(elikagaia, kopuru); 
	}  

	public double diruTotala() {
		return this.modelo.diruTotala();
	}	

	public ImageIcon argazkiaAukeratu(String aukera) {
		return this.modelo.argazkiaAukeratu(aukera);
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
}
