package Controlador;

import Vista.PanelHasiera; 
import Vista.Vista;

public class ControladorPanelHasiera {

	private Vista vista;
	private Controlador controlador;
	private PanelHasiera panelLogin;

	public ControladorPanelHasiera(Vista vista, Controlador controlador) {
		this.vista = vista;
		this.controlador = controlador;	
	}

	public void ikusiPanelLogin() {
		this.panelLogin = new PanelHasiera(this);
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


