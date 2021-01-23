package Controlador;

import Modelo.Modelo;
import Vista.PanelMenu;
import Vista.PanelMenu2;
import Vista.PanelMenu3;
import Vista.Vista;

public class ControladorPanelMenu3 {

	private Modelo modelo;
	private Vista vista;
	private Controlador controlador;
	private PanelMenu3 panelMenu3;

	public ControladorPanelMenu3(Modelo modelo, Vista vista, Controlador controlador) {
		this.modelo = modelo;
		this.vista = vista;
		this.controlador = controlador;	
	}

	public void mostrarPanelMenu3() {
		this.panelMenu3 = new PanelMenu3(this);
		this.vista.mostrarPanel(this.panelMenu3);
	}

	public void accionadoBottonMostrarPanelFaktura() {
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
	public void accionadoBotonHasiera() {
		this.controlador.navegarPanelLogin();
	}
}


