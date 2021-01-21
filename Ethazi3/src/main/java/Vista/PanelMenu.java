package Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox; 
import javax.swing.JPanel;

import Controlador.ControladorPanelMenu; 

@SuppressWarnings("serial")
public class PanelMenu extends JPanel{

	private JButton btnfaktura;
	private JButton btnticket;
	private JButton btnpedidos;
	//private JButton ;
	private ControladorPanelMenu controladorPanelMenu;

	public PanelMenu(ControladorPanelMenu controladorPanelMenu)
	{
		this.controladorPanelMenu = controladorPanelMenu;

		setLayout(null);

		btnfaktura = new JButton("Faktura");
		btnfaktura.setBounds(58, 70, 115, 25);
		add(btnfaktura);

		btnticket = new JButton("Ticket");
		btnticket.setBounds(58, 30, 89, 23);
		add(btnticket);
		
		btnpedidos = new JButton("Pedidos");
		btnpedidos.setBounds(58, 140, 150, 25);
		add(btnpedidos);

		initializeEvents();
	}

	private void initializeEvents() {
		this.btnfaktura.addActionListener(listenerBotonFaktura(this.controladorPanelMenu)); 
		this.btnpedidos.addActionListener(listenerBotonPedidos(this.controladorPanelMenu));
		this.btnticket.addActionListener(listenerBotonTicket(this.controladorPanelMenu));
	}

	private ActionListener listenerBotonFaktura(ControladorPanelMenu controladorPanelMenu) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorPanelMenu.accionadoBottonMostrarPanelFaktura();
			}
		};
	}
	private ActionListener listenerBotonPedidos(ControladorPanelMenu controladorPanelMenu) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorPanelMenu.accionadoBottonMostrarPanelPedidos();
			}
		};
	}
	private ActionListener listenerBotonTicket(ControladorPanelMenu controladorPanelMenu) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorPanelMenu.accionadoBottonMostrarPanelTicket();
			}
		};
	}
}
