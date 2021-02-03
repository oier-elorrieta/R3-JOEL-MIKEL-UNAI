package Controlador;
 
import java.sql.SQLException;

import BBDD.BBDDKonexioa;
import BBDD.BBDDmetodoak; 
import Vista.PanelErregistratu; 
import Vista.Vista;

public class ControladorPanelErregistratu {

	private Vista vista;
	private Controlador controlador;
	private PanelErregistratu panelErregistratu;
	@SuppressWarnings("unused")
	private BBDDKonexioa BBDD;

	public ControladorPanelErregistratu(Vista vista, Controlador controlador, BBDDKonexioa BBDD) {
		this.vista = vista;
		this.controlador = controlador;
		this.BBDD = BBDD;                                                                                 
	}

	public void ikusiPanelErregistratu() {
		this.panelErregistratu = new PanelErregistratu(this);
		this.vista.ikusiPanela(this.panelErregistratu);
	}
	
	public String sakatuErregistratuBotoia(String izena, String abizena, String pasahitza, String dni, String nif) throws SQLException, ClassNotFoundException {
		this.controlador.nabegatzenPanelLogin();
		return BBDDmetodoak.sartuDatuak(izena,abizena,pasahitza, dni, nif);
	}
	
	public void sakatuAtzeraBotoia() {
		this.controlador.nabegatzenPanelLogin();
	}
	
	public void sakatuSarratuBotoia() {
		this.controlador.itxi();
	}
	
	public void sakatuErregistratuBotoia() {
		this.controlador.nabegatzenPanelLogin();
	}
}


