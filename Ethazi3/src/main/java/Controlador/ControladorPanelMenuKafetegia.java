package Controlador;
 
import Vista.PanelMenuKafetegia;
import Vista.Vista;

public class ControladorPanelMenuKafetegia {

	private Vista vista;
	private Controlador controlador;
	private PanelMenuKafetegia panelMenu3;

	public ControladorPanelMenuKafetegia(Vista vista, Controlador controlador) {
		this.vista = vista;
		this.controlador = controlador;	
	}

	public void ikusiPanelMenu3() {
		this.panelMenu3 = new PanelMenuKafetegia(this);
		this.vista.ikusiPanela(this.panelMenu3);
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


