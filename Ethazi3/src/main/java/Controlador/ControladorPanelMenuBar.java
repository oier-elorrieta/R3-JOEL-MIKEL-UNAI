package Controlador;

import Modelo.Modelo;
import Vista.PanelMenuRestaurante;
import Vista.PanelMenuBar;
import Vista.Vista;

public class ControladorPanelMenuBar {

	private Modelo modelo;
	private Vista vista;
	private Controlador controlador;
	private PanelMenuBar panelMenu2;

	public ControladorPanelMenuBar(Modelo modelo, Vista vista, Controlador controlador) {
		this.modelo = modelo;
		this.vista = vista;
		this.controlador = controlador;	
	}

	public void mostrarPanelMenu2() {
		this.panelMenu2 = new PanelMenuBar(this);
		this.vista.mostrarPanel(this.panelMenu2);
	}

	public void accionadoBottonMostrarPanelFaktura() {
		this.controlador.navegarPanelFaktura();
	}
	public void accionadoBottonMostrarPanelTicket() {
		this.controlador.navegarPanelTicket();
	}
	public void accionadoBottonAtzera() {
		this.controlador.itxi();
	}
	public void accionadoBotonHasiera() {
		this.controlador.navegarPanelLogin();
	}
}


