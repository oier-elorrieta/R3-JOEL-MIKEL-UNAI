package Controlador;

import Modelo.Modelo; 
import Vista.PanelTicket;
import Vista.Vista;

public class ControladorPanelTicket {

	@SuppressWarnings("unused")
	private Modelo modelo;
	private Vista vista;
	private Controlador controlador;
	private PanelTicket panelGeneros;
	
	public ControladorPanelTicket(Modelo modelo, Vista vista, Controlador controlador) {
		this.modelo = modelo;
		this.vista = vista;
		this.controlador = controlador;	
	}
	
	public void mostrarPanelGeneros() {
		this.panelGeneros = new PanelTicket(this);
		this.vista.mostrarPanel(this.panelGeneros);
	}
	
	public void accionadoBottonVolverPanelGeneros() {
		this.controlador.navegarPanelBienvenida();
	}
	
	public void accionadoBottonHurrengoaPanelGeneros() {
		this.controlador.navegarPanelAutoak();
	}
}
