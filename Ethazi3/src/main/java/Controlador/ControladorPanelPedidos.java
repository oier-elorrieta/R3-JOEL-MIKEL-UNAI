package Controlador;

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
		this.controlador.navegarPanelPedidosLaburpena();
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
}
