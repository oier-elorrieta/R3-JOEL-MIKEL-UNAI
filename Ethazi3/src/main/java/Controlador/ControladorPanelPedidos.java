package Controlador;

import java.util.ArrayList;

import Modelo.Karrito;
import Modelo.Modelo;
import Vista.PanelPedidos;
import Vista.Vista;

public class ControladorPanelPedidos {
	private Modelo modelo;
	private Vista vista;
	private Controlador controlador;
	private PanelPedidos panelPedidos;

	public ControladorPanelPedidos(Modelo modelo, Vista vista, Controlador controlador) {
		this.modelo = modelo;
		this.vista = vista;
		this.controlador = controlador;	
	}

	public void mostrarPanelPedidos() {
		this.panelPedidos = new PanelPedidos(this);
		this.vista.mostrarPanel(this.panelPedidos);
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
	/*public String arrayaDirua(int[] dirua) {
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
