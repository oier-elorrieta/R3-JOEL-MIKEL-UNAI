package Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controlador.ControladorPanelGeneros;
import Controlador.ControladorPanelPelikulas;

@SuppressWarnings("serial")
public class PanelPelikulas extends JPanel {
	
	private JButton btnVolver;
	private JLabel lblPelikulas;
	private ControladorPanelPelikulas controladorPanelPelikulas;
	@SuppressWarnings("unused")
	private ControladorPanelGeneros controladorPanelGeneros;

	public PanelPelikulas(ControladorPanelPelikulas controladorPanelPelikulas) {
		this.controladorPanelPelikulas = controladorPanelPelikulas;

		setLayout(null);

		lblPelikulas = new JLabel("Panel Pelikulas");
		lblPelikulas.setBounds(58, 35, 115, 14);
		add(lblPelikulas);

		btnVolver = new JButton("Volver");
		btnVolver.setBounds(58, 62, 89, 23);
		add(btnVolver);

		initializeEvents();
	}

	private void initializeEvents() {
		this.btnVolver.addActionListener(listenerBotonVolver(this.controladorPanelPelikulas));

	}

	private ActionListener listenerBotonVolver(ControladorPanelPelikulas controladorPanelPelikulas) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton Volver");
				controladorPanelPelikulas.accionadoBottonVolverPanelPelikulas();
			}
		};
	}
}

