package Controlador;

import Modelo.Modelo;
import Vista.PanelLogin; 
import Vista.Vista;

public class ControladorPanelLogin {

	private Modelo modelo;
	private Vista vista;
	private Controlador controlador;
	private PanelLogin panelLogin;

	public ControladorPanelLogin(Modelo modelo, Vista vista, Controlador controlador) {
		this.modelo = modelo;
		this.vista = vista;
		this.controlador = controlador;	
	}

	public void mostrarPanelLogin() {
		this.panelLogin = new PanelLogin(this);
		this.vista.mostrarPanel(this.panelLogin);
	}

	public void accionadoBottonMostrarPanelBar() {
		this.controlador.navegarPanelMenu3();
	}
	public void accionadoBottonMostrarPanelCafeteria() {
		this.controlador.navegarPanelMenu2();
	}
	public void accionadoBottonMostrarPanelRestaurante() {
		this.controlador.navegarPanelMenu();
	}
	public void accionadoBottonAtzera() {
		this.controlador.itxi();
	}
}


