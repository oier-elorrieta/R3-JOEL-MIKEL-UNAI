package Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Controlador.ControladorPanelTicket;

@SuppressWarnings("serial")
public class PanelTicket extends JPanel {

	private JButton btnVolver;
	private JLabel lblGeneros;
	private ControladorPanelTicket controladorPanelGeneros;
	private JButton btnHurrengoa;
	
	public PanelTicket(ControladorPanelTicket controladorPanelGeneros)
	{
		this.controladorPanelGeneros = controladorPanelGeneros;
		
		setLayout(null);
		
		lblGeneros = new JLabel("Panel Generos");
		lblGeneros.setBounds(58, 35, 115, 14);
		add(lblGeneros);
		
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(58, 62, 89, 23);
		add(btnVolver);
		
		btnHurrengoa = new JButton("Hurrengoa");
		btnHurrengoa.setBounds(70, 82, 89, 23);
		add(btnHurrengoa);
		
		initializeEvents();
	}
	
	private void initializeEvents() {
		this.btnVolver.addActionListener(listenerBotonVolver(this.controladorPanelGeneros));
		this.btnHurrengoa.addActionListener(listenerBotonHurrengoa(controladorPanelGeneros));
	}
	
	private ActionListener listenerBotonVolver(ControladorPanelTicket controladorPanelGeneros) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton Volver");
				controladorPanelGeneros.accionadoBottonVolverPanelGeneros();
			}
		};
	}
	private ActionListener listenerBotonHurrengoa(ControladorPanelTicket controladorPanelGeneros) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton Hurrengoa");
				controladorPanelGeneros.accionadoBottonHurrengoaPanelGeneros();
			}
		};
	}
}
