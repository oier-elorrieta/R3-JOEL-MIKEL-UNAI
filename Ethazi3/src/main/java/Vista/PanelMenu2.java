package Vista;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;  
import javax.swing.JPanel;

import Controlador.ControladorPanelMenu2; 
@SuppressWarnings("serial")
public class PanelMenu2 extends JPanel {

	private ControladorPanelMenu2 controladorPanelMenu2;
	private JButton btnFaktura;
	private JButton btnTicket;
	private JButton btnSarratu;
	private JButton btnHasiera;

	public PanelMenu2(ControladorPanelMenu2 controladorPanelMenu2) {

		this.controladorPanelMenu2 = controladorPanelMenu2;

		setBackground(Color.LIGHT_GRAY);
		setLayout(null);

		setBounds(0, 0, 450, 300);

		btnTicket = new JButton("TICKET");
		btnTicket.setFont(new Font("Tahoma", Font.ITALIC, 11));
		btnTicket.setBounds(10, 95, 210, 113); 
		add(btnTicket);

		btnFaktura = new JButton("FAKTURA");
		btnFaktura.setFont(new Font("Tahoma", Font.ITALIC, 11));
		btnFaktura.setBounds(230, 95, 210, 113);
		add(btnFaktura);


		btnSarratu = new JButton("SARRATU ");
		btnSarratu.setFont(new Font("Tahoma", Font.ITALIC, 11));
		btnSarratu.setBounds(350, 259, 90, 30);
		add(btnSarratu);
		
		btnHasiera = new JButton("Hasiera");
		btnHasiera.setFont(new Font("Tahoma", Font.ITALIC, 11));
		btnHasiera.setBounds(10, 259, 90, 30);
		add(btnHasiera);

		initializeEvents();
	}
	
	private void initializeEvents() {
		this.btnFaktura.addActionListener(listenerBottonFaktura(this.controladorPanelMenu2));
		this.btnTicket.addActionListener(listenerBottonTicket(this.controladorPanelMenu2));
		this.btnSarratu.addActionListener(listenerBottonSarratu(this.controladorPanelMenu2));
		this.btnHasiera.addActionListener(listenerBotonHasiera(this.controladorPanelMenu2));
	}
	
	private ActionListener listenerBottonFaktura(ControladorPanelMenu2 controladorPanelMenu2) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorPanelMenu2.accionadoBottonMostrarPanelFaktura();
			}
		};
	} 
	private ActionListener listenerBottonTicket(ControladorPanelMenu2 controladorPanelMenu2) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorPanelMenu2.accionadoBottonMostrarPanelTicket();
			}
		};
	} 
	private ActionListener listenerBottonSarratu(ControladorPanelMenu2 controladorPanelMenu2) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorPanelMenu2.accionadoBottonAtzera();
			}
		};
	} 
	private ActionListener listenerBotonHasiera(ControladorPanelMenu2 controladorPanelMenu2) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorPanelMenu2.accionadoBotonHasiera();
			}
		};
	}
}
