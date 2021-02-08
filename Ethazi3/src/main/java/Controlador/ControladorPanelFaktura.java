package Controlador;

import java.util.ArrayList;

import javax.swing.ImageIcon;

import Modelo.Karritoa;
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

	public void ikusiPanelFaktura() {
		this.panelFaktura = new PanelFaktura(this);
		this.vista.ikusiPanela(this.panelFaktura);
	}

	public void sakatuLaburpeneraBotoia() {
		this.controlador.nabegatzenPanelLaburpena();
	}
	
	public String[] ComboBoxaSakatu() {
		return this.modelo.produktuakJaso();
	}
	
	public ArrayList<Karritoa> sartu(String elikagaia,int kopuru) {
		return this.modelo.sartu(elikagaia, kopuru); 
	} 
	
	public double diruTotala() {
		return this.modelo.diruTotala();
	}
	
	public ImageIcon argazkiaAukeratu(String aukera) {
		return this.modelo.argazkiaAukeratu(aukera);
	}
	
	public void sartuFaktura(String izena, String abizena) {
		this.modelo.sartuFaktura(izena, abizena);
	} 
	
	public int gehituTransferentziaZenbakia() {
		return this.modelo.gehituTransferentziaZenbakia();
	}
	
	public void sakatuPanelTabernaBotoia() {
		this.controlador.nabegatzenPanelTaberna();
		this.modelo.ezabatu();
	}

	public void sakatuPanelKafetegiaBotoia() {
		this.controlador.nabegatzenPanelKafetegia();
		this.modelo.ezabatu();
	}

	public void sakatuPanelJatetxeBotoia() {
		this.controlador.nabegatzenPanelJatetxea();
		this.modelo.ezabatu();
	}
	
	public String konprobatuLokala() {
		return this.modelo.komprobatuLokala2();
	}
}
