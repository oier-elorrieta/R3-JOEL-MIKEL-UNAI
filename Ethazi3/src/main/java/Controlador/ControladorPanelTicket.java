package Controlador;

 
import java.util.ArrayList;

import Modelo.Karrito; 
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
	/*public String[] accionadoBotonGuardar(String aukera) {
		 return this.modelo.sartuProduktuak(aukera);
	}
	public String arraya(String[] aukeratutakoak) {
		return this.modelo.arraya(aukeratutakoak);
	}
	public int[] accionadoBotonGuardar2(int aukera) {
		return this.modelo.sartuAukeratutakoKantitateak(aukera);
	}
	public String arrayaKantitateak(int[] kantitateak) {
		return this.modelo.arrayaKantitateak(kantitateak);
	}
	public String arrayaDirua(int[] dirua) {
		return this.modelo.arrayaDirua(dirua);
	}
	public String[] clear1(String[] aukeratutakoak) {
		return this.modelo.clear1(aukeratutakoak);
	}
	public int[] clear2(int[] kantitateak) {
		return this.modelo.clear2(kantitateak);
	}
	public int[] clear3(int[] dirua) {
		return this.modelo.clear3(dirua);
	}*/
	public ArrayList<Karrito> sartu(String elikagaia,int kopuru) {
		return this.modelo.sartu(elikagaia, kopuru); 
	}   
	
}
