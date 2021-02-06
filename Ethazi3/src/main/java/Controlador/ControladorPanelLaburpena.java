package Controlador;

import Modelo.Modelo;
import Vista.PanelLaburpena;
import Vista.Vista;

public class ControladorPanelLaburpena {

	private Modelo modelo;
	private Vista vista;
	private Controlador controlador;
	private PanelLaburpena panelLaburpena; 
	
	public ControladorPanelLaburpena(Modelo modelo, Vista vista, Controlador controlador) {
		this.modelo = modelo;
		this.vista = vista;
		this.controlador = controlador;	
	}
	
	public void ikusiPanelLaburpena() {
		this.panelLaburpena = new PanelLaburpena(this);
		this.vista.ikusiPanela(this.panelLaburpena);
	}
	 
	public String pantailaratu() {
		return this.modelo.pantailaratu();
	}
	
	public double diruTotala() {
		return this.modelo.diruTotala();
	}
	
	public void sakatuPanelTabernaBotoia() {
		this.controlador.nabegatzenPanelTaberna();
		this.modelo.ezabatu();
	}

	public void sakatuPanelKafetegiaBotoia() {
		this.controlador.nabegatzenPanelKafetegia();
		this.modelo.ezabatu();
	}

	public void sakatuPanelJatetxeBotoia() {
		this.controlador.nabegatzenPanelJatetxea();
		this.modelo.ezabatu();
	}
	
	public String konprobatuLokala() {
		return this.modelo.komprobatuLokala2();
	}
}
