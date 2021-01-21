package Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Controlador.ControladorPanelTicketLaburpena;

@SuppressWarnings("serial")
public class PanelTicketLaburpena extends JPanel{

	private JLabel lbllaburpen;
	private ControladorPanelTicketLaburpena controladorPanelBienvenida;
	
	public PanelTicketLaburpena(ControladorPanelTicketLaburpena controladorPanelBienvenida) {
		this.controladorPanelBienvenida = controladorPanelBienvenida;
		
		setLayout(null);
		
		lbllaburpen = new JLabel("Ticket laburpena");
		lbllaburpen.setBounds(58, 35, 115, 14);
		add(lbllaburpen);
		
		
		
	//	initializeEvents();
	}
	
/*	private void initializeEvents() {
		this.btnGeneros.addActionListener(listenerBotonGeneros(this.controladorPanelBienvenida));
	}
	
	private ActionListener listenerBotonGeneros(ControladorPanelTicketLaburpena controladorPanelBienvenida) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton Generos");
				//controladorPanelBienvenida.accionadoBottonMostrarPanelGeneros();
			}
		};
	}*/
}
