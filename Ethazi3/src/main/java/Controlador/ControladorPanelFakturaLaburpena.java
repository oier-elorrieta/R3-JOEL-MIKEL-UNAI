package Controlador;
 

import Modelo.Modelo;
import Vista.PanelFakturaLaburpena; 
import Vista.Vista;

public class ControladorPanelFakturaLaburpena {

	@SuppressWarnings("unused")
	private Modelo modelo;
	private Vista vista;
	private Controlador controlador;
	private PanelFakturaLaburpena panelFakturaLaburpena;
	
	public ControladorPanelFakturaLaburpena(Modelo modelo, Vista vista, Controlador controlador) {
		this.modelo = modelo;
		this.vista = vista;
		this.controlador = controlador;	
	}
	
	public void mostrarPanelFakturaLaburpena() {
		this.panelFakturaLaburpena = new PanelFakturaLaburpena(this);
		this.vista.mostrarPanel(this.panelFakturaLaburpena);
	}
	
	public void accionadoBottonMostrarPanelMenu() throws InterruptedException {
		Thread.sleep(1350);
		this.controlador.navegarPanelLogin();
		this.modelo.clear();
	}
	public String arrayaIkusi() {
		return this.modelo.arraya();
	}
	public String arrayaKantitateakIkusi() {
		return this.modelo.arrayaKantitateak();
	}
	public String arrayaDiruaIkusi() {
		return this.modelo.arrayaDirua();
	}
	public int diruTotala() {
		return this.modelo.diruTotala();
	}
}
