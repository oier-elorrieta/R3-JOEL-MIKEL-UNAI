package Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import Controlador.ControladorPanelPedidos;

public class PanelPedidos extends JPanel {

	private JButton btnLaburpena;
	private ControladorPanelPedidos controladorPanelPedidos;

	public PanelPedidos(ControladorPanelPedidos controladorPanelPedidos)
	{
		this.controladorPanelPedidos = controladorPanelPedidos;

		setLayout(null);

		btnLaburpena = new JButton("Laburpena Pedidos");
		btnLaburpena.setBounds(58, 30, 89, 23);
		add(btnLaburpena);

		initializeEvents();
	}

	private void initializeEvents() {
		this.btnLaburpena.addActionListener(listenerBotonVolver(this.controladorPanelPedidos)); 
	}

	private ActionListener listenerBotonVolver(ControladorPanelPedidos controladorPanelPedidos) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorPanelPedidos.accionadoBottonLaburpenera();
			}
		};
	}
}
