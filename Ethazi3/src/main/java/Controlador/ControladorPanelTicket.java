package Controlador;

import Modelo.Modelo; 
import Vista.PanelTicket;
import Vista.Vista;

public class ControladorPanelTicket {

	 
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
		this.controlador.navegarPanelLaburpena();
	}
	public void accionadoBottonAtzera() {
		this.controlador.navegarPanelMenu();
	}
	public String[] accionadoComboBox() {
		return this.modelo.produktuakJaso();
	}
	public String[] accionadoBotonGuardar(String aukera, String[] aukeratutakoak) {
		 return this.modelo.sartuProduktuak(aukera, aukeratutakoak);
	}
	public String arraya(String[] aukeratutakoak) {
		return this.modelo.arraya(aukeratutakoak);
	}
	public int[] accionadoBotonGuardar2(int aukera, int[] kantitateak) {
		return this.modelo.sartuAukeratutakoKantitateak(aukera, kantitateak);
	}
	public String arrayaKantitateak(int[] kantitateak) {
		return this.modelo.arrayaKantitateak(kantitateak);
	}
	public int[] accionadoBotonGuardar3(String aukera, int kantitatea, int[] dirua) {
		return this.modelo.sartuAukeratutakoenDirua(aukera, kantitatea, dirua);
	}
	public String arrayaDirua(int[] dirua) {
		return this.modelo.arrayaDirua(dirua);
	}
	public int diruTotala(int[] kantitateak) {
		return this.modelo.diruTotala(kantitateak);
	}
	public String[] clear1(String[] aukeratutakoak) {
		return this.modelo.clear1(aukeratutakoak);
	}
	public int[] clear2(int[] kantitateak) {
		return this.modelo.clear2(kantitateak);
	}
	public int[] clear3(int[] dirua) {
		return this.modelo.clear3(dirua);
	}
}
