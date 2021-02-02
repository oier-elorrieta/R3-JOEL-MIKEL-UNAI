package Controlador;

import Vista.PanelErregistratu; 
import Vista.Vista;

public class ControladorPanelErregistratu {

	private Vista vista;
	private Controlador controlador;
	private PanelErregistratu panelErregistratu;

	public ControladorPanelErregistratu(Vista vista, Controlador controlador) {
		this.vista = vista;
		this.controlador = controlador;	
	}

	public void ikusiPanelErregistratu() {
		this.panelErregistratu = new PanelErregistratu(this);
		this.vista.ikusiPanela(this.panelErregistratu);
	}
	
	public void sakatuErregistratuBotoia() {
		this.controlador.nabegatzenPanelLogin();
	}
	
	public void sakatuAtzeraBotoia() {
		this.controlador.itxi();
	}
}


