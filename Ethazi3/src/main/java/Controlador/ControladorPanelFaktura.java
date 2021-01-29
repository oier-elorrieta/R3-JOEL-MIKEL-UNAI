package Controlador;

import java.util.ArrayList;

import Modelo.Karrito;
import Modelo.Modelo;
import Vista.PanelFaktura; 
import Vista.Vista;

public class ControladorPanelFaktura {
	
	private Modelo modelo;
	private Vista vista;
	private Controlador controlador;
	private PanelFaktura panelFaktura;

	public ControladorPanelFaktura(Modelo modelo, Vista vista, Controlador controlador) {
		this.modelo = modelo;
		this.vista = vista;
		this.controlador = controlador;	
	}

	public void mostrarPanelFaktura() {
		this.panelFaktura = new PanelFaktura(this);
		this.vista.mostrarPanel(this.panelFaktura);
	}

	public void accionadoBottonLaburpenera() {
		this.controlador.navegarPanelLaburpena();
	}
	
	public void accionadoBottonAtzera() {
		this.controlador.navegarPanelLogin();
		this.modelo.ezabatu();
	}
	
	public String[] accionadoComboBox() {
		return this.modelo.produktuakJaso();
	}
	
	public ArrayList<Karrito> sartu(String elikagaia,int kopuru) {
		return this.modelo.sartu(elikagaia, kopuru); 
	} 
	
	public double diruTotala() {
		return this.modelo.diruTotala();
	}
}
