package Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox; 
import javax.swing.JPanel;

import Controlador.ControladorPanelMenu; 

@SuppressWarnings("serial")
public class PanelMenu extends JPanel{

	private JButton btnVolver;
	private JButton Matrikula;
	private ControladorPanelMenu controladorPanelAutoak;

	public PanelMenu(ControladorPanelMenu controladorPanelAutoak)
	{
		this.controladorPanelAutoak = controladorPanelAutoak;

		setLayout(null);

		Matrikula = new JButton("Matrikula");
		Matrikula.setBounds(58, 70, 115, 25);
		add(Matrikula);

		btnVolver = new JButton("Volver");
		btnVolver.setBounds(58, 30, 89, 23);
		add(btnVolver);

		initializeEvents();
	}

	private void initializeEvents() {
		this.btnVolver.addActionListener(listenerBotonVolver(this.controladorPanelAutoak)); 
	}

	private ActionListener listenerBotonVolver(ControladorPanelMenu controladorPanelAutoak) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton Volver");
				controladorPanelAutoak.accionadoBottonMostrarPanelGeneros();
			}
		};
	}
}
