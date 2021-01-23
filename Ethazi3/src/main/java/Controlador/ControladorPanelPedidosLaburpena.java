package Controlador;

import Modelo.Modelo;
import Vista.PanelPedidosLaburpena;
import Vista.Vista;

public class ControladorPanelPedidosLaburpena {
	
	private Modelo modelo;
	private Vista vista;
	private Controlador controlador;
	private PanelPedidosLaburpena panelPedidosLaburpena;

	public ControladorPanelPedidosLaburpena(Modelo modelo, Vista vista, Controlador controlador) {
		this.modelo = modelo;
		this.vista = vista;
		this.controlador = controlador;	
	}

	public void mostrarPanelPedidosLaburpena() {
		this.panelPedidosLaburpena = new PanelPedidosLaburpena(this);
		this.vista.mostrarPanel(this.panelPedidosLaburpena);
	}

	public void accionadoBottonMostrarPanelMenu() throws InterruptedException {
		Thread.sleep(1350);
		this.controlador.navegarPanelLogin();
	}
	public String arrayaIkusi() {
		return this.modelo.arraya();
	}
}
