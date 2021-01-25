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
	private ControladorPanelTicket controladorPanelTicket;
	private ControladorPanelLaburpena controladorPanelLaburpena;
	private ControladorPanelPedidos controladorPanelPedidos;

	public Controlador(Modelo modelo, Vista vista) {
		this.modelo = modelo;
		this.vista = vista;
		this.controladorPanelLogin = new ControladorPanelLogin(this.modelo, this.vista, this);
		this.controladorPanelMenu = new ControladorPanelMenuRestaurante(this.modelo, this.vista, this);
		this.controladorPanelMenu2 = new ControladorPanelMenuBar(this.modelo, this.vista, this);
		this.controladorPanelMenu3 = new ControladorPanelMenuCafeteria(this.modelo, this.vista, this);
		this.controladorPanelFaktura = new ControladorPanelFaktura(this.modelo, this.vista, this);
		this.controladorPanelTicket = new ControladorPanelTicket(this.modelo, this.vista, this);
		this.controladorPanelLaburpena =  new ControladorPanelLaburpena(this.modelo, this.vista, this);
		this.controladorPanelPedidos = new ControladorPanelPedidos(this.modelo, this.vista, this);
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
	public void navegarPanelTicket() { 
		this.controladorPanelTicket.mostrarPanelTicket();
	}
	public void navegarPanelLaburpena() { 
		this.controladorPanelLaburpena.mostrarPanelLaburpena();
	}
	public void navegarPanelPedidos() {
		this.controladorPanelPedidos.mostrarPanelPedidos();
	}
	public void itxi() {
		System.exit(0);
	}
}
