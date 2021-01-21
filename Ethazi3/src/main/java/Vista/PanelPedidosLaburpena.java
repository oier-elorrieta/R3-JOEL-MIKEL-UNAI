package Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controlador.ControladorPanelPedidosLaburpena;

public class PanelPedidosLaburpena extends JPanel {

	private JLabel Laburpena;
	private ControladorPanelPedidosLaburpena controladorPanelPedidosLaburpena;

	public PanelPedidosLaburpena(ControladorPanelPedidosLaburpena controladorPanelPedidosLaburpena)
	{
		this.controladorPanelPedidosLaburpena = controladorPanelPedidosLaburpena;

		setLayout(null);

		Laburpena = new JLabel("Laburpena PedidosLaburpena");
		Laburpena.setBounds(58, 30, 150, 150);
		add(Laburpena);

		//initializeEvents();
	}
/*
	private void initializeEvents() {
		this.btnLaburpena.addActionListener(listenerBotonVolver(this.controladorPanelPedidosLaburpena)); 
	}

	private ActionListener listenerBotonVolver(ControladorPanelPedidosLaburpena controladorPanelPedidosLaburpena) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorPanelPedidosLaburpena.accionadoBottonLaburpenera();
			}
		};
	}*/
}

