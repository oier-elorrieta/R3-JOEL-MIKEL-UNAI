package Controlador;

import Modelo.Modelo; 
import Vista.PanelTicket;
import Vista.Vista;

public class ControladorPanelTicket {

	@SuppressWarnings("unused")
	private Modelo modelo;
	private Vista vista;
	private Controlador controlador;
	private PanelTicket panelTicket;
	
	public ControladorPanelTicket(Modelo modelo, Vista vista, Controlador controlador) {
		this.modelo = modelo;
		this.vista = vista;
		this.controlador = controlador;	
	}
	
	public void mostrarPanelTicket() {
		this.panelTicket = new PanelTicket(this);
		this.vista.mostrarPanel(panelTicket);
	}
	
	public void accionadoBottonLaburpenera() {
		this.controlador.navegarPanelTicketLaburpena();
	}
	public void accionadoBottonAtzera() {
		this.controlador.navegarPanelMenu();
		this.modelo.clear();
	}
	public String[] accionadoComboBox() {
		return this.modelo.produktuakJaso();
	}
	public String[] accionadoBotonGuardar(String aukera) {
		 return this.modelo.sartuProduktuak(aukera);
	}
	public int[] accionadoBotonGuardar2(int aukera) {
		return this.modelo.sartuAukeratutakoKantitateak(aukera);
	}
	public int[] accionadoBotonGuardar3(String aukera) {
		return this.modelo.sartuAukeratutakoenDirua(aukera);
	}
	public int diruTotala() {
		return this.modelo.diruTotala();
	}
}
