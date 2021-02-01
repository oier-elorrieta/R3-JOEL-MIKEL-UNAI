package Controlador;

import Vista.PanelMenuTaberna;
import Vista.Vista;

public class ControladorPanelMenuTaberna {

	private Vista vista;
	private Controlador controlador;
	private PanelMenuTaberna panelMenu2;

	public ControladorPanelMenuTaberna(Vista vista, Controlador controlador) {
		this.vista = vista;
		this.controlador = controlador;	
	}

	public void ikusiPanelMenu2() {
		this.panelMenu2 = new PanelMenuTaberna(this);
		this.vista.ikusiPanela(this.panelMenu2);
	}

	public void sakatuFakturaPanelaIkustekoBotoia() {
		this.controlador.nabegatzenPanelFaktura();
	}
	
	public void sakatuTicketPanelaIkustekoBotoia() {
		this.controlador.nabegatzenPanelTicket();
	}
	
	public void sakatuAtzeraBotoia() {
		this.controlador.itxi();
	}
	
	public void sakatuHasieraBotoia() {
		this.controlador.nabegatzenPanelLogin();
	}
}


