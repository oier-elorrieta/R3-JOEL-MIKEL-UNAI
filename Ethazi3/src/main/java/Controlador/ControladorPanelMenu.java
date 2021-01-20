package Controlador;

import Modelo.Modelo;
import Vista.PanelMenu;
import Vista.Vista;

public class ControladorPanelMenu {

	private Modelo modelo;
	private Vista vista;
	private Controlador controlador;
	private PanelMenu panelAutoak;

	public ControladorPanelMenu(Modelo modelo, Vista vista, Controlador controlador) {
		this.modelo = modelo;
		this.vista = vista;
		this.controlador = controlador;	
	}

	public void mostrarPanelAutoak() {
		this.panelAutoak = new PanelMenu(this);
		this.vista.mostrarPanel(this.panelAutoak);
	}

	public void accionadoBottonMostrarPanelGeneros() {
		//this.controlador.navegarPanelGeneros();
	}
	

}
