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
	
	public void mostrarPanelLaburpena() {
		this.panelLaburpena = new PanelLaburpena(this);
		this.vista.mostrarPanel(this.panelLaburpena);
	}
	
	public void accionadoBottonMostrarPanelMenu() throws InterruptedException {
		Thread.sleep(1350);
		this.controlador.navegarPanelLogin(); 
		this.modelo.ezabatu();
	}
	 
	public String pantailaratu() {
		return this.modelo.pantailaratu();
	}
	public double diruTotala() {
		return this.modelo.diruTotala();
	}
}
