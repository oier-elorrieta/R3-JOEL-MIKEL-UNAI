package Controlador;

import Modelo.Modelo;
import Vista.Vista;

public class Controlador {

	private Modelo modelo;
	
	private Vista vista;
	
	private ControladorPanelLogin controladorPanelLogin;
	private ControladorPanelMenuJatetxea controladorPanelMenu;	
	private ControladorPanelMenuTaberna controladorPanelMenu2;	
	private ControladorPanelMenuKafetegia controladorPanelMenu3;	
	private ControladorPanelFaktura controladorPanelFaktura;
	private ControladorPanelTicket controladorPanelTicket;
	private ControladorPanelLaburpena controladorPanelLaburpena;
	private ControladorPanelEskaera controladorPanelPedidos; 

	public Controlador(Modelo modelo, Vista vista) {
		this.modelo = modelo;
		this.vista = vista;
		this.controladorPanelLogin = new ControladorPanelLogin(this.vista, this);
		this.controladorPanelMenu = new ControladorPanelMenuJatetxea(this.vista, this);
		this.controladorPanelMenu2 = new ControladorPanelMenuTaberna(this.vista, this);
		this.controladorPanelMenu3 = new ControladorPanelMenuKafetegia(this.vista, this);
		this.controladorPanelFaktura = new ControladorPanelFaktura(this.modelo, this.vista, this);
		this.controladorPanelTicket = new ControladorPanelTicket(this.modelo, this.vista, this);
		this.controladorPanelLaburpena =  new ControladorPanelLaburpena(this.modelo, this.vista, this);
		this.controladorPanelPedidos = new ControladorPanelEskaera(this.modelo, this.vista, this);
		this.nabegatzenPanelLogin();
	}
	
	public void nabegatzenPanelLogin() {
		this.controladorPanelLogin.ikusiPanelLogin();
	}
	
	public void nabegatzenPanelMenu() {
		this.controladorPanelMenu.ikusiPanelMenu();
	}
	
	public void nabegatzenPanelMenu2() {
		this.controladorPanelMenu2.ikusiPanelMenu2();
	}
	
	public void nabegatzenPanelMenu3() {
		this.controladorPanelMenu3.ikusiPanelMenu3();
	}
	
	public void nabegatzenPanelFaktura() { 
		this.controladorPanelFaktura.ikusiPanelFaktura();
	}
	
	public void nabegatzenPanelTicket() { 
		this.controladorPanelTicket.ikusiPanelTicket();
	}
	
	public void nabegatzenPanelLaburpena() { 
		this.controladorPanelLaburpena.ikusiPanelLaburpena();
	}
	
	public void nabegatzenPanelPedidos() {
		this.controladorPanelPedidos.ikusiPanelPedidos();
	}
	
	public void itxi() {
		System.exit(0);
	}
	
}
