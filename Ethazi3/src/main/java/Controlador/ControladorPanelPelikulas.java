package Controlador;

import Modelo.Modelo; 
import Vista.PanelPelikulas;
import Vista.Vista;

public class ControladorPanelPelikulas {

	@SuppressWarnings("unused")
	private Modelo modelo;
	private Vista vista;
	private Controlador controlador;
	private PanelPelikulas panelPelikulas;
	
	public ControladorPanelPelikulas(Modelo modelo, Vista vista, Controlador controlador) {
		this.modelo = modelo;
		this.vista = vista;
		this.controlador = controlador;	
	}
	
	public void mostrarPanelPelikulas() {
		this.panelPelikulas = new PanelPelikulas(this);
		this.vista.mostrarPanel(this.panelPelikulas);
	}
	
	public void accionadoBottonVolverPanelPelikulas() {
		this.controlador.navegarPanelBienvenida();
	}
}
