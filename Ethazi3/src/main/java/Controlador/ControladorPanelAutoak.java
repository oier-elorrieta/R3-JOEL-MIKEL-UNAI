package Controlador;

import Modelo.Modelo;
import Vista.PanelAutoak;
import Vista.Vista;

public class ControladorPanelAutoak {

	private Modelo modelo;
	private Vista vista;
	private Controlador controlador;
	private PanelAutoak panelAutoak;

	public ControladorPanelAutoak(Modelo modelo, Vista vista, Controlador controlador) {
		this.modelo = modelo;
		this.vista = vista;
		this.controlador = controlador;	
	}

	public void mostrarPanelAutoak() {
		this.panelAutoak = new PanelAutoak(this);
		this.vista.mostrarPanel(this.panelAutoak);
	}

	public void accionadoBottonMostrarPanelGeneros() {
		this.controlador.navegarPanelGeneros();
	}
	
	public String[] accionadoBottonMatrikulak() {
		return modelo.autoakJaso();
	}
}
