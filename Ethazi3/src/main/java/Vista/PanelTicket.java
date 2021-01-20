package Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Controlador.ControladorPanelTicket;

@SuppressWarnings("serial")
public class PanelTicket extends JPanel {

	private JButton btnLaburpenera; 
	private ControladorPanelTicket controladorPanelTicket; 
	
	public PanelTicket(ControladorPanelTicket controladorPanelTicket)
	{
		this.controladorPanelTicket = controladorPanelTicket;
		
		setLayout(null);
		
		btnLaburpenera = new JButton("Laburpenera Ticket");
		btnLaburpenera.setBounds(58, 62, 89, 23);
		add(btnLaburpenera);
		
		
		initializeEvents();
	}
	
	private void initializeEvents() {
		this.btnLaburpenera.addActionListener(listenerBotonVolver(this.controladorPanelTicket)); 
	}
	
	private ActionListener listenerBotonVolver(ControladorPanelTicket controladorPanelTicket) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorPanelTicket.accionadoBottonLaburpenera(); 
			}
		};
	}
}
