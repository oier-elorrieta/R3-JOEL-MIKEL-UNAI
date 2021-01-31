package Controlador;

import Vista.PanelLogin; 
import Vista.Vista;

public class ControladorPanelLogin {

	private Vista vista;
	private Controlador controlador;
	private PanelLogin panelLogin;

	public ControladorPanelLogin(Vista vista, Controlador controlador) {
		this.vista = vista;
		this.controlador = controlador;	
	}

	public void ikusiPanelLogin() {
		this.panelLogin = new PanelLogin(this);
		this.vista.ikusiPanela(this.panelLogin);
	}

	public void sakatuPanelTabernaBotoia() {
		this.controlador.nabegatzenPanelMenu3();
	}
	
	public void sakatuPanelKafetegiaBotoia() {
		this.controlador.nabegatzenPanelMenu2();
	}
	
	public void sakatuPanelJatetxBotoia() {
		this.controlador.nabegatzenPanelMenu();
	}
	
	public void sakatuAtzeraBotoia() {
		this.controlador.itxi();
	}
}


