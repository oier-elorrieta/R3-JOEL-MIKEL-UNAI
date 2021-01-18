package Controlador;

import Modelo.Modelo;
import Vista.PanelTicketResumen;
import Vista.Vista;

public class ControladorPanelTicketResumen {

	@SuppressWarnings("unused")
	private Modelo modelo;
	private Vista vista;
	private Controlador controlador;
	private PanelTicketResumen panelBienvenida;
	
	public ControladorPanelTicketResumen(Modelo modelo, Vista vista, Controlador controlador) {
		this.modelo = modelo;
		this.vista = vista;
		this.controlador = controlador;	
	}
	
	public void mostrarPanelBienvenida() {
		this.panelBienvenida = new PanelTicketResumen(this);
		this.vista.mostrarPanel(this.panelBienvenida);
	}
	
	public void accionadoBottonMostrarPanelGeneros() {
		this.controlador.navegarPanelGeneros();
	}
}
