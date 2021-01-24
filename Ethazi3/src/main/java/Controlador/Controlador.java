package Controlador;

import Modelo.Modelo;
import Vista.Vista;

public class Controlador {

	private Modelo modelo;
	private Vista vista;
	private ControladorPanelLogin controladorPanelLogin;
	private ControladorPanelMenuRestaurante controladorPanelMenu;	
	private ControladorPanelMenuBar controladorPanelMenu2;	
	private ControladorPanelMenuCafeteria controladorPanelMenu3;	
	private ControladorPanelFaktura controladorPanelFaktura;
	private ControladorPanelFakturaLaburpena controladorPanelFakturaLaburpena;
	private ControladorPanelTicket controladorPanelTicket;
	private ControladorPanelTicketLaburpena controladorPanelTicketLaburpena;
	private ControladorPanelPedidos controladorPanelPedidos;
	private ControladorPanelPedidosLaburpena controladorPanelPedidosLaburpena;

	public Controlador(Modelo modelo, Vista vista) {
		this.modelo = modelo;
		this.vista = vista;
		this.controladorPanelLogin = new ControladorPanelLogin(this.modelo, this.vista, this);
		this.controladorPanelMenu = new ControladorPanelMenuRestaurante(this.modelo, this.vista, this);
		this.controladorPanelMenu2 = new ControladorPanelMenuBar(this.modelo, this.vista, this);
		this.controladorPanelMenu3 = new ControladorPanelMenuCafeteria(this.modelo, this.vista, this);
		this.controladorPanelFaktura = new ControladorPanelFaktura(this.modelo, this.vista, this);
		this.controladorPanelFakturaLaburpena = new ControladorPanelFakturaLaburpena(this.modelo, this.vista, this);
		this.controladorPanelTicket = new ControladorPanelTicket(this.modelo, this.vista, this);
		this.controladorPanelTicketLaburpena =  new ControladorPanelTicketLaburpena(this.modelo, this.vista, this);
		this.controladorPanelPedidos = new ControladorPanelPedidos(this.modelo, this.vista, this);
		this.controladorPanelPedidosLaburpena = new ControladorPanelPedidosLaburpena(this.modelo, this.vista, this);
		this.navegarPanelLogin();
	}
	public void navegarPanelLogin() {
		this.controladorPanelLogin.mostrarPanelLogin();
	}
	public void navegarPanelMenu() {
		this.controladorPanelMenu.mostrarPanelMenu();
	}
	public void navegarPanelMenu2() {
		this.controladorPanelMenu2.mostrarPanelMenu2();
	}
	public void navegarPanelMenu3() {
		this.controladorPanelMenu3.mostrarPanelMenu3();
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
		this.controladorPanelPedidos.mostrarPanelPedidos();
	}
	public void navegarPanelPedidosLaburpena() {
		this.controladorPanelPedidosLaburpena.mostrarPanelPedidosLaburpena();
	}
	public void itxi() {
		System.exit(0);
	}
}
