package Controlador;

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

	public void sakatuLaburpeneraBotoia() {
		this.controlador.nabegatzenPanelLaburpena();
	}
	
	public void sakatuAtzeraBotoia() {
		this.controlador.nabegatzenPanelLogin();
		this.modelo.ezabatu();
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
	public String gordeEskaera(String helbidea) {
		return this.modelo.sartuEskaera(helbidea);
	}
	
	public int gehituTransferentziaZenbakia() {
		return this.modelo.gehituTransferentziaZenbakia();
	}
	
	public void sakatuPanelTabernaBotoia() {
		this.controlador.nabegatzenPanelTaberna();
	}

	public void sakatuPanelKafetegiaBotoia() {
		this.controlador.nabegatzenPanelKafetegia();
	}

	public void sakatuPanelJatetxeBotoia() {
		this.controlador.nabegatzenPanelJatetxea();
	}
	
	public String konprobatuLokala() {
		return this.modelo.komprobatuLokala2();
	} 
}
