package Controlador;

import Modelo.Modelo;
import Vista.PanelMenu;
import Vista.PanelMenu2;
import Vista.Vista;

public class ControladorPanelMenu2 {

	private Modelo modelo;
	private Vista vista;
	private Controlador controlador;
	private PanelMenu2 panelMenu2;

	public ControladorPanelMenu2(Modelo modelo, Vista vista, Controlador controlador) {
		this.modelo = modelo;
		this.vista = vista;
		this.controlador = controlador;	
	}

	public void mostrarPanelMenu2() {
		this.panelMenu2 = new PanelMenu2(this);
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


