package Vista;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Controlador.ControladorPanelFakturaLaburpena; 

public class PanelFakturaLaburpena extends JPanel{

	private JLabel lbllaburpen; 
	private ControladorPanelFakturaLaburpena controladorPanelFakturaLaburpena;

	public PanelFakturaLaburpena(ControladorPanelFakturaLaburpena controladorPanelFakturaLaburpena) {
		this.controladorPanelFakturaLaburpena = controladorPanelFakturaLaburpena;

		setLayout(null);

		lbllaburpen = new JLabel("Laburpen Faktura");
		lbllaburpen.setBounds(58, 35, 115, 14);
		add(lbllaburpen);

		

	//	initializeEvents();
	}
/*
	private void initializeEvents() {
		this.btnGeneros.addActionListener(listenerBotonGeneros(this.controladorPanelFakturaLaburpena));
	}

	private ActionListener listenerBotonGeneros(ControladorPanelFakturaLaburpena controladorPanelBienvenida) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton Generos");
				//controladorPanelBienvenida.accionadoBottonMostrarPanelGeneros();
			}
		};
	}*/
}