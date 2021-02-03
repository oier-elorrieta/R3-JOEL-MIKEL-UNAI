package Controlador;

import BBDD.BBDDKonexioa;
import BBDD.BBDDmetodoak;
import Vista.PanelLogin; 
import Vista.Vista;

public class ControladorPanelLogin {

	private Vista vista;
	private Controlador controlador;
	private PanelLogin panelLogin;
	@SuppressWarnings("unused")
	private BBDDKonexioa BBDD;

	public ControladorPanelLogin(Vista vista, Controlador controlador, BBDDKonexioa BBDD) {
		this.vista = vista;
		this.controlador = controlador;	
		this.BBDD = BBDD;
	}

	public void ikusiPanelLogin() {
		this.panelLogin = new PanelLogin(this);
		this.vista.ikusiPanela(this.panelLogin);
	}
	
	public void sakatuPanelErregistratuBotoia() {
		this.controlador.nabegatzenPanelErregistratu();
	}
	
	public void sakatuPanelTabernaBotoia() {
		this.controlador.nabegatzenPanelTaberna();
	}
	
	public void sakatuPanelKafetegiaBotoia() {
		this.controlador.nabegatzenPanelKafetegia();
	}
	
	public void sakatuPanelJatetxeBotoia() {
		this.controlador.nabegatzenPanelJatetxea();
	}
	
	public void sakatuAtzeraBotoia() {
		this.controlador.itxi();
	}
	
	public String konprobatuErabiltzailea(String erabiltzailea, String pasahitza) {
		return BBDDmetodoak.konprobatuErabiltzailea(erabiltzailea, pasahitza);
	}
}


