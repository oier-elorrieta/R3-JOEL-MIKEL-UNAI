package Controlador;

import Modelo.Modelo;
import Vista.Vista;

public class Controlador {

	private Modelo modelo;
	private Vista vista;
	private ControladorPanelTicketResumen controladorPanelBienvenida;
	private ControladorPanelTicket controladorPanelGeneros;
	private ControladorPanelMenu controladorPanelAutoak;
	
	public Controlador(Modelo modelo, Vista vista) {
		this.modelo = modelo;
		this.vista = vista;
		this.controladorPanelBienvenida = new ControladorPanelTicketResumen(this.modelo, this.vista, this);
		this.controladorPanelGeneros = new ControladorPanelTicket(this.modelo, this.vista, this);
		this.controladorPanelAutoak = new ControladorPanelMenu(this.modelo, this.vista, this);
		this.navegarPanelBienvenida();
	}
	
	public void navegarPanelBienvenida() {
		System.out.println("Navegar panel Bienvenida");
		this.controladorPanelBienvenida.mostrarPanelBienvenida();
	}
	
	public void navegarPanelGeneros() {
		System.out.println("Navegar panel Generos");
		this.controladorPanelGeneros.mostrarPanelGeneros();
	}
	
	public void navegarPanelAutoak() {
		System.out.println("Navegar panel Autoak");
		this.controladorPanelAutoak.mostrarPanelAutoak();
	}
}
