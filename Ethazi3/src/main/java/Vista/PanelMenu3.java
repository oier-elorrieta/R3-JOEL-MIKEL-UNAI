package Vista;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;  
import javax.swing.JPanel;
import javax.swing.JTextArea;
 
import Controlador.ControladorPanelMenu;
import Controlador.ControladorPanelMenu3; 
@SuppressWarnings("serial")
public class PanelMenu3 extends JPanel {

	private ControladorPanelMenu3 controladorPanelMenu;
	private JButton btnFaktura;
	private JButton btnTicket;
	private JButton btnEskaera;
	private JButton btnSarratu;


	public PanelMenu3(ControladorPanelMenu3 controladorPanelMenu3) {

		this.controladorPanelMenu = controladorPanelMenu3;

		setBackground(Color.LIGHT_GRAY);
		setLayout(null);

		setBounds(0, 0, 450, 300);

		btnTicket = new JButton("TICKET");
		btnTicket.setFont(new Font("Tahoma", Font.ITALIC, 11));
		btnTicket.setBounds(10, 11, 210, 113); 
		add(btnTicket);

		btnFaktura = new JButton("FAKTURA");
		btnFaktura.setFont(new Font("Tahoma", Font.ITALIC, 11));
		btnFaktura.setBounds(230, 11, 210, 113);
		add(btnFaktura);

		btnEskaera = new JButton("ESKAERA");
		btnEskaera.setFont(new Font("Tahoma", Font.ITALIC, 11));
		btnEskaera.setBounds(123, 135, 210, 113);
		add(btnEskaera);


		btnSarratu = new JButton("SARRATU ");
		btnSarratu.setFont(new Font("Tahoma", Font.ITALIC, 11));
		btnSarratu.setBounds(350, 259, 90, 30);
		add(btnSarratu);

		initializeEvents();
	}
	
	private void initializeEvents() {
		this.btnFaktura.addActionListener(listenerBottonFaktura(this.controladorPanelMenu));
		this.btnTicket.addActionListener(listenerBottonTicket(this.controladorPanelMenu));
		this.btnEskaera.addActionListener(listenerBottonEskaera(this.controladorPanelMenu));
		this.btnSarratu.addActionListener(listenerBottonSarratu(this.controladorPanelMenu));
	}
	
	private ActionListener listenerBottonFaktura(ControladorPanelMenu3 controladorPanelMenu2) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorPanelMenu2.accionadoBottonMostrarPanelFaktura();
			}
		};
	} 
	private ActionListener listenerBottonTicket(ControladorPanelMenu3 controladorPanelMenu2) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorPanelMenu2.accionadoBottonMostrarPanelTicket();
			}
		};
	} 
	private ActionListener listenerBottonEskaera(ControladorPanelMenu3 controladorPanelMenu2) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorPanelMenu2.accionadoBottonMostrarPanelPedidos();
			}
		};
	} 
	private ActionListener listenerBottonSarratu(ControladorPanelMenu3 controladorPanelMenu2) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorPanelMenu2.accionadoBottonAtzera();
			}
		};
	} 
}
