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
	
	public String sakatuErregistratuBotoia(String izena, String abizena, String pasahitza, String erabiltzailea) throws SQLException, ClassNotFoundException {
		this.controlador.nabegatzenPanelLogin();
		return BBDDmetodoak.sartuDatuak(izena,abizena,pasahitza,erabiltzailea);
	}
	
	public void sakatuAtzeraBotoia() {
		this.controlador.itxi();
	}
}


