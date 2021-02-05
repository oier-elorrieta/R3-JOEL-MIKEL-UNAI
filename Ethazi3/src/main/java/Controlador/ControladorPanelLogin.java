package Controlador;

import Modelo.Modelo;
import Modelo.metodoak;
import Vista.PanelLogin; 
import Vista.Vista;

public class ControladorPanelLogin {

	private Vista vista;
	private Controlador controlador;
	private PanelLogin panelLogin;
	private Modelo modelo;

	public ControladorPanelLogin(Vista vista, Controlador controlador, Modelo modelo) {
		this.vista = vista;
		this.controlador = controlador; 
		this.modelo = modelo;
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
		return this.modelo.konprobatuErabiltzailea(erabiltzailea, pasahitza);
	} 
	
	public String konprobatuLokala(String erabiltzailea) {
		return this.modelo.komprobatuLokala(erabiltzailea);
	} 
	
	public String konprobatuNIF(String erabiltzailea) {
		return this.modelo.konprobatuNIF(erabiltzailea);
	}
}


