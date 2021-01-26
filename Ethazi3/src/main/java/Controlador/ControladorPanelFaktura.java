package Controlador;

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
	public int[] accionadoBotonGuardar3(String aukera,int kantitatea) {
		return this.modelo.sartuAukeratutakoenDirua(aukera, kantitatea);
	}
	public int diruTotala() {
		return this.modelo.diruTotala();
	}
}
