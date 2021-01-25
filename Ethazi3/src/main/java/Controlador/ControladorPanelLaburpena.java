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
		this.modelo.clear();
	}
	public String arrayaIkusi() {
		return this.modelo.arraya();
	}
	public String arrayaKantitateakIkusi() {
		return this.modelo.arrayaKantitateak();
	}
	public String arrayaDiruaIkusi() {
		return this.modelo.arrayaDirua();
	}
	public int diruTotala() {
		return this.modelo.diruTotala();
	}
}
