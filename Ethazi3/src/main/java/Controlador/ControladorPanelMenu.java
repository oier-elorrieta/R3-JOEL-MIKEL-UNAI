package Controlador;

import Modelo.Modelo;
import Vista.PanelMenu;
import Vista.Vista;

public class ControladorPanelMenu {

	private Modelo modelo;
	private Vista vista;
	private Controlador controlador;
	private PanelMenu panelMenu;

	public ControladorPanelMenu(Modelo modelo, Vista vista, Controlador controlador) {
		this.modelo = modelo;
		this.vista = vista;
		this.controlador = controlador;	
	}

	public void mostrarPanelMenu() {
		this.panelMenu = new PanelMenu(this);
		this.vista.mostrarPanel(this.panelMenu);
	}

	public void accionadoBottonMostrarPanelFaktura( ) {
		this.controlador.navegarPanelFaktura();
	}
	public void accionadoBottonMostrarPanelTicket() {
		this.controlador.navegarPanelTicket();
	}
	public void accionadoBottonMostrarPanelPedidos() {
		this.controlador.navegarPanelPedidos();
	}
	public void accionadoBottonAtzera() {
		this.controlador.itxi();
	}
}


