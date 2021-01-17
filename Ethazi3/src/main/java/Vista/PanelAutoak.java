package Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox; 
import javax.swing.JPanel;

import Controlador.ControladorPanelAutoak; 

@SuppressWarnings("serial")
public class PanelAutoak extends JPanel{

	private JButton btnVolver;
	private JButton Matrikula;
	private ControladorPanelAutoak controladorPanelAutoak;
	private JComboBox<String> Matrikulak;

	public PanelAutoak(ControladorPanelAutoak controladorPanelAutoak)
	{
		this.controladorPanelAutoak = controladorPanelAutoak;

		setLayout(null);

		Matrikula = new JButton("Matrikula");
		Matrikula.setBounds(58, 70, 115, 25);
		add(Matrikula);

		btnVolver = new JButton("Volver");
		btnVolver.setBounds(58, 30, 89, 23);
		add(btnVolver);

		Matrikulak = new JComboBox<String>();
		Matrikulak.setBounds(200, 60, 89, 25);
		add(Matrikulak);

		initializeEvents();
	}

	private void initializeEvents() {
		this.btnVolver.addActionListener(listenerBotonVolver(this.controladorPanelAutoak));
		this.Matrikula.addActionListener(listenerBotonMatrikulak(controladorPanelAutoak));
	}

	private ActionListener listenerBotonVolver(ControladorPanelAutoak controladorPanelAutoak) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton Volver");
				controladorPanelAutoak.accionadoBottonMostrarPanelGeneros();
			}
		};
	}
	private ActionListener listenerBotonMatrikulak(ControladorPanelAutoak controladorPanelAutoak) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//System.out.println("Ejecutando evento Boton Volver");
				String[] matrikulak = controladorPanelAutoak.accionadoBottonMatrikulak();
				for(int i = 0;i < matrikulak.length;i++) {
					Matrikulak.addItem(matrikulak[i]);
				}
			}
		};
	}
}
