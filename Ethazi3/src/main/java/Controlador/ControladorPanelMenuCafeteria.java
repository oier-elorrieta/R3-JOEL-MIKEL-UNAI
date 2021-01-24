package Controlador;

import Modelo.Modelo;
import Vista.PanelMenuRestaurante;
import Vista.PanelMenuBar;
import Vista.PanelMenuCafeteria;
import Vista.Vista;

public class ControladorPanelMenuCafeteria {

	private Modelo modelo;
	private Vista vista;
	private Controlador controlador;
	private PanelMenuCafeteria panelMenu3;

	public ControladorPanelMenuCafeteria(Modelo modelo, Vista vista, Controlador controlador) {
		this.modelo = modelo;
		this.vista = vista;
		this.controlador = controlador;	
	}

	public void mostrarPanelMenu3() {
		this.panelMenu3 = new PanelMenuCafeteria(this);
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


