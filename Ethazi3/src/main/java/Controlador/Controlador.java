package Controlador;

import Modelo.Modelo;
import Vista.Vista;

public class Controlador {

	private Modelo modelo;
	private Vista vista;
	private ControladorPanelFaktura controladorPanelFaktura;
	private ControladorPanelFakturaLaburpena controladorPanelFakturaLaburpena;
	private ControladorPanelTicket controladorPanelTicket;
	private ControladorPanelTicketLaburpena controladorPanelTicketLaburpena;
	private ControladorPanelPedidos controladorPanelPedidos;
	private ControladorPanelPedidosLaburpena controladorPanelPedidosLaburpena;

	 

	public Controlador(Modelo modelo, Vista vista) {
		this.modelo = modelo;
		this.vista = vista;
		this.controladorPanelFaktura = new ControladorPanelFaktura(this.modelo, this.vista, this);
		this.controladorPanelTicket = new ControladorPanelTicket(this.modelo, this.vista, this);
		this.controladorPanelTicketLaburpena =  new ControladorPanelTicketLaburpena(this.modelo, this.vista, this);
		this.controladorPanelFakturaLaburpena = new ControladorPanelFakturaLaburpena(this.modelo, this.vista, this);
		this.controladorPanelPedidos = new ControladorPanelPedidos(this.modelo, this.vista, this);
		this.controladorPanelPedidosLaburpena = new ControladorPanelPedidosLaburpena(this.modelo, this.vista, this);
	}

	public void navegarPanelFaktura() { 
		this.controladorPanelFaktura.mostrarPanelFaktura();
	}
	
	public void navegarPanelFakturaLaburpena() {
		this.controladorPanelFakturaLaburpena.mostrarPanelFakturaLaburpena();
	}

	public void navegarPanelTicket() { 
		this.controladorPanelTicket.mostrarPanelTicket();
	}
	public void navegarPanelTicketLaburpena() { 
		this.controladorPanelTicketLaburpena.mostrarPanelTicketLaburpena();
	}
	public void navegarPanelPedidos() {
		
	}
	public void navegarPanelPedidosLaburpena() {
		
	}

	 
}
