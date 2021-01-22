package Vista;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox; 
import javax.swing.JPanel;
import javax.swing.JTextArea;

import Controlador.ControladorPanelFaktura;
import Controlador.ControladorPanelMenu; 
import javax.swing.JPanel;
@SuppressWarnings("serial")
public class PanelMenu extends JPanel {

	private ControladorPanelMenu controladorPanelMenu;
	private JButton btnFaktura;
	private JButton btnTicket;
	private JButton btnEskaera;
	private JTextArea textArea;
	private JTextArea textAukerak;
	private JButton btnSarratu;


	public PanelMenu(ControladorPanelMenu controladorPanelMenu) {

		this.controladorPanelMenu = controladorPanelMenu;

		setBackground(Color.LIGHT_GRAY);
		setLayout(null);
		setBounds(0, 0, 450, 300);

		btnFaktura = new JButton("FAKTURA");
		btnFaktura.setFont(new Font("Tahoma", Font.ITALIC, 11));
		btnFaktura.setBounds(176, 113, 89, 23); 
		add(btnFaktura);

		btnTicket = new JButton("TICKET");
		btnTicket.setFont(new Font("Tahoma", Font.ITALIC, 11));
		btnTicket.setBounds(176, 147, 89, 23);
		add(btnTicket);

		btnEskaera = new JButton("ESKAERA");
		btnEskaera.setFont(new Font("Tahoma", Font.ITALIC, 11));
		btnEskaera.setBounds(176, 181, 89, 23);
		add(btnEskaera);

		textArea = new JTextArea();
		textArea.setBounds(166, 70, -54, 22);
		add(textArea);

		textAukerak = new JTextArea();
		textAukerak.setFont(new Font("Monospaced", Font.ITALIC, 16));
		textAukerak.setBackground(Color.LIGHT_GRAY);
		textAukerak.setText("AUKERAK:");
		textAukerak.setEditable(false);
		textAukerak.setBounds(45, 45, 89, 23);
		add(textAukerak);

		btnSarratu = new JButton("SARRATU ");
		btnSarratu.setFont(new Font("Tahoma", Font.ITALIC, 11));
		btnSarratu.setBounds(351, 266, 89, 23);
		add(btnSarratu);

		initializeEvents();
	}
	
	private void initializeEvents() {
		this.btnFaktura.addActionListener(listenerBottonFaktura(this.controladorPanelMenu));
		this.btnTicket.addActionListener(listenerBottonTicket(this.controladorPanelMenu));
		this.btnEskaera.addActionListener(listenerBottonEskaera(this.controladorPanelMenu));
		this.btnSarratu.addActionListener(listenerBottonSarratu(this.controladorPanelMenu));
	}
	
	private ActionListener listenerBottonFaktura(ControladorPanelMenu controladorPanelMenu) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorPanelMenu.accionadoBottonMostrarPanelFaktura();
			}
		};
	} 
	private ActionListener listenerBottonTicket(ControladorPanelMenu controladorPanelMenu) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorPanelMenu.accionadoBottonMostrarPanelTicket();
			}
		};
	} 
	private ActionListener listenerBottonEskaera(ControladorPanelMenu controladorPanelMenu) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorPanelMenu.accionadoBottonMostrarPanelPedidos();
			}
		};
	} 
	private ActionListener listenerBottonSarratu(ControladorPanelMenu controladorPanelMenu) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorPanelMenu.accionadoBottonAtzera();
			}
		};
	} 
}
