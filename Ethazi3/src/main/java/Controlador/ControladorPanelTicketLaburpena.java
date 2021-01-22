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
		this.controlador.navegarPanelMenu();
	}}
