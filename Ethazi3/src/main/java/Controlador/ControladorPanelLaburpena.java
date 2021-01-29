package Controlador;

import java.util.ArrayList;

import Modelo.Karrito;
import Modelo.Karro;
import Modelo.Modelo;
import Vista.PanelLaburpena;
import Vista.Vista;

public class ControladorPanelLaburpena {

	private Modelo modelo;
	private Vista vista;
	private Controlador controlador;
	private PanelLaburpena panelLaburpena;
	private Karro karro;
	private Karrito karrito;
	
	public ControladorPanelLaburpena(Modelo modelo, Vista vista, Controlador controlador, Karro karro, Karrito karrito) {
		this.modelo = modelo;
		this.vista = vista;
		this.controlador = controlador;	
		this.karro = karro;
		this.karrito = karrito;
	}
	
	public void mostrarPanelLaburpena() {
		this.panelLaburpena = new PanelLaburpena(this);
		this.vista.mostrarPanel(this.panelLaburpena);
	}
	
	public void accionadoBottonMostrarPanelMenu() throws InterruptedException {
		Thread.sleep(1350);
		this.controlador.navegarPanelLogin(); 
	}
	/*public String arrayaIkusi(String[] aukeratutakoak) {
		return this.modelo.arraya(aukeratutakoak);
	}
	public String arrayaKantitateakIkusi(int[] kantitateak) {
		return this.modelo.arrayaKantitateak(kantitateak);
	}
	public String arrayaDiruaIkusi(int[] dirua) {
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
	 
	public String pantailaratu() {
		return this.modelo.pantailaratu();
	}
	public int diruTotala() {
		return this.modelo.diruTotala();
	}
}
