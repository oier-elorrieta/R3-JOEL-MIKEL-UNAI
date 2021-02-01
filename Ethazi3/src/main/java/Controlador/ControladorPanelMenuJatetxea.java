package Controlador;

import Vista.PanelMenuJatetxea;
import Vista.Vista;

public class ControladorPanelMenuJatetxea {

	private Vista vista;
	private Controlador controlador;
	private PanelMenuJatetxea panelMenu;

	public ControladorPanelMenuJatetxea(Vista vista, Controlador controlador) {
		this.vista = vista;
		this.controlador = controlador;	
	}

	public void ikusiPanelMenu() {
		this.panelMenu = new PanelMenuJatetxea(this);
		this.vista.ikusiPanela(this.panelMenu);
	}

	public void sakatuFakturaPanelaIkustekoBotoia() {
		this.controlador.nabegatzenPanelFaktura();
	}
	
	public void sakatuTicketPanelaIkustekoBotoia() {
		this.controlador.nabegatzenPanelTicket();
	}
	
	public void sakatuEskaeraPanelaIkustekoBotoia() {
		this.controlador.nabegatzenPanelPedidos();
	}
	
	public void sakatuAtzeraBotoia() {
		this.controlador.itxi();
	}
	
	public void sakatuHasieraBotoia() {
		this.controlador.nabegatzenPanelLogin();
	}
}


