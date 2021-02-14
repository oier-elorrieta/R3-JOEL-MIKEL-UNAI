package Controlador;

import java.sql.SQLException;
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
	
	public double diruProduktua(String aukera, int kantitatea) {
		return this.modelo.diruProduktua(aukera, kantitatea);
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
	
	public void sartuFaktura(String izena, String abizena) throws ClassNotFoundException, SQLException {
		this.modelo.sartuFaktura(izena, abizena);
	} 
	
	public int jasoTransakzioZbk() throws ClassNotFoundException, SQLException {
		return this.modelo.jasoTransakzioZbk();
	}
	
	public void sakatuPanelTabernaBotoia() {
		this.controlador.nabegatzenPanelTaberna();
		this.modelo.ezabatuProduktuenArraya();
	}

	public void sakatuPanelKafetegiaBotoia() {
		this.controlador.nabegatzenPanelKafetegia();
		this.modelo.ezabatuProduktuenArraya();
	}

	public void sakatuPanelJatetxeBotoia() {
		this.controlador.nabegatzenPanelJatetxea();
		this.modelo.ezabatuProduktuenArraya();
	}
	
	public void sartuNumTrans(int numTrans, int a�o, int mes, int dia) {
		this.modelo.sartuNumTrans(numTrans, a�o, mes, dia);
	}
	
	public void kenduNumTrans(int numTrans) {
		this.modelo.kenduNumTrans(numTrans);
	}
	
	public String konprobatuLokala() {
		return this.modelo.konprobatuLokala();
	}
	
	public String komprobatuLokalarenIzena() {
		return this.modelo.konprobatuLokalarenIzena();
	}
	
	public String konprobatuNIF() {
		return this.modelo.konprobatuNIF();
	}
	
	public void kenduStocka(String nomProduktua, int kantitatea, String nif) {
		this.modelo.kenduStocka(nomProduktua, kantitatea, nif);
	}
	
	public void sartuProduktua(String produktua, int numTrans, int nUnidades, double precio) {
		this.modelo.sartuProduktua(produktua, numTrans, nUnidades, precio);
	}
	
	public int begiratuStock(String produktua, String nif) {
		return this.modelo.begiratuStock(produktua, nif);
	}
}
