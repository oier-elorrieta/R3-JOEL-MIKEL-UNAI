package Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import Controlador.ControladorPanelFaktura; 

@SuppressWarnings("serial")
public class PanelFaktura extends JPanel {

	private JButton btnLaburpena;
	private ControladorPanelFaktura controladorPanelFaktura;

	public PanelFaktura(ControladorPanelFaktura controladorPanelFaktura)
	{
		this.controladorPanelFaktura = controladorPanelFaktura;

		setLayout(null);

		btnLaburpena = new JButton("Laburpena Faktura");
		btnLaburpena.setBounds(58, 30, 89, 23);
		add(btnLaburpena);

		initializeEvents();
	}

	private void initializeEvents() {
		this.btnLaburpena.addActionListener(listenerBotonVolver(this.controladorPanelFaktura)); 
	}

	private ActionListener listenerBotonVolver(ControladorPanelFaktura controladorPanelFaktura) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorPanelFaktura.accionadoBottonLaburpenera();
			}
		};
	}
}

