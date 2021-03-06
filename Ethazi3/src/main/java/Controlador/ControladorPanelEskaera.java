package Controlador;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import Modelo.Karritoa;
import Modelo.Modelo;
import Vista.PanelEskaera;
import Vista.Vista;

public class ControladorPanelEskaera {

	private Modelo modelo;
	private Vista vista;
	private Controlador controlador;
	private PanelEskaera panelPedidos;

	public ControladorPanelEskaera(Modelo modelo, Vista vista, Controlador controlador) {
		this.modelo = modelo;
		this.vista = vista;
		this.controlador = controlador;
	}

	public void ikusiPanelPedidos() {
		this.panelPedidos = new PanelEskaera(this);
		this.vista.ikusiPanela(this.panelPedidos);
	}

	public void sakatuLaburpeneraBotoia(){
		this.controlador.nabegatzenPanelLaburpena();
	}

	public String[] ComboBoxaSakatu() {
		return this.modelo.produktuakJaso();
	}

	public ArrayList<Karritoa> sartu(String elikagaia, int kopuru) {
		return this.modelo.sartu(elikagaia, kopuru);
	}

	public double diruTotala() {
		return this.modelo.diruTotala();
	}

	public ImageIcon argazkiaAukeratu(String aukera) {
		return this.modelo.argazkiaAukeratu(aukera);
	}

	public void gordeEskaera(String helbidea, int anyo, int mes, int dia) throws ClassNotFoundException, SQLException {
		this.modelo.sartuEskaera(helbidea, anyo, mes, dia);
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
	
	public String konprobatuNIF() {
		return this.modelo.konprobatuNIF();
	}
	
	public int begiratuStock(String produktua, String nif) {
		return this.modelo.begiratuStock(produktua, nif);
	}
}
