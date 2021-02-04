package Controlador;

import Modelo.Modelo;
import Vista.Vista;

public class Controlador {

	private Modelo modelo;
	
	private Vista vista;
	
	
	private ControladorPanelLogin controladorPanelLogin;
	private ControladorPanelMenuJatetxea controladorPanelJatetxea;	
	private ControladorPanelMenuTaberna controladorPanelTaberna;	
	private ControladorPanelMenuKafetegia controladorPanelKafetegia;	
	private ControladorPanelFaktura controladorPanelFaktura;
	private ControladorPanelTicket controladorPanelTicket;
	private ControladorPanelLaburpena controladorPanelLaburpena;
	private ControladorPanelEskaera controladorPanelPedidos; 
	private ControladorPanelErregistratu controladorPanelErregistratu; 

	public Controlador(Modelo modelo, Vista vista) {
		this.modelo = modelo;
		this.vista = vista;
		this.controladorPanelLogin = new ControladorPanelLogin(this.vista, this, this.modelo);
		this.controladorPanelErregistratu = new ControladorPanelErregistratu(this.vista, this, this.modelo);
		this.controladorPanelJatetxea = new ControladorPanelMenuJatetxea(this.vista, this);
		this.controladorPanelTaberna = new ControladorPanelMenuTaberna(this.vista, this);
		this.controladorPanelKafetegia = new ControladorPanelMenuKafetegia(this.vista, this);
		this.controladorPanelFaktura = new ControladorPanelFaktura(this.modelo, this.vista, this);
		this.controladorPanelTicket = new ControladorPanelTicket(this.modelo, this.vista, this);
		this.controladorPanelLaburpena =  new ControladorPanelLaburpena(this.modelo, this.vista, this);
		this.controladorPanelPedidos = new ControladorPanelEskaera(this.modelo, this.vista, this); 
		this.nabegatzenPanelLogin();
	}
	
	public void nabegatzenPanelLogin() {
		this.controladorPanelLogin.ikusiPanelLogin();
	}
	
	public void nabegatzenPanelErregistratu() {
		this.controladorPanelErregistratu.ikusiPanelErregistratu();
	}
	
	public void nabegatzenPanelJatetxea() {
		this.controladorPanelJatetxea.ikusipanelMenuJatetxea();
	}
	
	public void nabegatzenPanelTaberna() {
		this.controladorPanelTaberna.ikusipanelMenuTaberna();
	}
	
	public void nabegatzenPanelKafetegia() {
		this.controladorPanelKafetegia.ikusipanelMenuKafetegia();
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
