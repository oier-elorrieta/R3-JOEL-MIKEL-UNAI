package Controlador;

import Modelo.Modelo;
import Vista.PanelTicketLaburpena;
import Vista.Vista;

public class ControladorPanelTicketLaburpena {

	@SuppressWarnings("unused")
	private Modelo modelo;
	private Vista vista;
	private Controlador controlador;
	private PanelTicketLaburpena panelTicketLaburpena;
	
	public ControladorPanelTicketLaburpena(Modelo modelo, Vista vista, Controlador controlador) {
		this.modelo = modelo;
		this.vista = vista;
		this.controlador = controlador;	
	}
	
	public void mostrarPanelTicketLaburpena() {
		this.panelTicketLaburpena = new PanelTicketLaburpena(this);
		this.vista.mostrarPanel(this.panelTicketLaburpena);
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
