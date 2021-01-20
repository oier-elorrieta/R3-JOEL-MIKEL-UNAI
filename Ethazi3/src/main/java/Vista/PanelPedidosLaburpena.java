package Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import Controlador.ControladorPanelPedidosLaburpena;

public class PanelPedidosLaburpena extends JPanel {

	private JButton btnLaburpena;
	private ControladorPanelPedidosLaburpena controladorPanelPedidosLaburpena;

	public PanelPedidosLaburpena(ControladorPanelPedidosLaburpena controladorPanelPedidosLaburpena)
	{
		this.controladorPanelPedidosLaburpena = controladorPanelPedidosLaburpena;

		setLayout(null);

		btnLaburpena = new JButton("Laburpena PedidosLaburpena");
		btnLaburpena.setBounds(58, 30, 89, 23);
		add(btnLaburpena);

		initializeEvents();
	}

	private void initializeEvents() {
		this.btnLaburpena.addActionListener(listenerBotonVolver(this.controladorPanelPedidosLaburpena)); 
	}

	private ActionListener listenerBotonVolver(ControladorPanelPedidosLaburpena controladorPanelPedidosLaburpena) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorPanelPedidosLaburpena.accionadoBottonLaburpenera();
			}
		};
	}
}

