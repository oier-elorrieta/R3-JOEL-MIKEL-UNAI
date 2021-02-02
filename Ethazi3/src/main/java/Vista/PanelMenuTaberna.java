package Vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;  
import javax.swing.JPanel;

import Controlador.ControladorPanelMenuTaberna; 

@SuppressWarnings("serial")
public class PanelMenuTaberna extends JPanel {

	private ControladorPanelMenuTaberna controladorPanelMenu2;
	
	private JButton btnFaktura;
	private JButton btnTicket;
	private JButton btnSarratu;
	private JButton btnHasiera;

	// *****************************************************************************************************************************************************************************************************
	
	public PanelMenuTaberna(ControladorPanelMenuTaberna controladorPanelMenu2) {

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
		
		btnHasiera = new JButton("DESLOGEATU");
		btnHasiera.setFont(new Font("Tahoma", Font.ITALIC, 8));
		btnHasiera.setBounds(10, 259, 90, 30);
		add(btnHasiera);

		initializeEvents();
	}
	
	// *****************************************************************************************************************************************************************************************************
	
	private void initializeEvents() {
		this.btnFaktura.addActionListener(listenerFakturaBotoia(this.controladorPanelMenu2));
		this.btnTicket.addActionListener(listenerTicketBotoia(this.controladorPanelMenu2));
		this.btnSarratu.addActionListener(listenerSarratuBotoia(this.controladorPanelMenu2));
		this.btnHasiera.addActionListener(listenerHasieraBotoia(this.controladorPanelMenu2));
	}
	
	// *****************************************************************************************************************************************************************************************************
	
	private ActionListener listenerFakturaBotoia(ControladorPanelMenuTaberna controladorPanelMenu2) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorPanelMenu2.sakatuFakturaPanelaIkustekoBotoia();
			}
		};
	} 
	
	// *****************************************************************************************************************************************************************************************************
	
	private ActionListener listenerTicketBotoia(ControladorPanelMenuTaberna controladorPanelMenu2) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorPanelMenu2.sakatuTicketPanelaIkustekoBotoia();
			}
		};
	} 
	
	// *****************************************************************************************************************************************************************************************************
	
	private ActionListener listenerSarratuBotoia(ControladorPanelMenuTaberna controladorPanelMenu2) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorPanelMenu2.sakatuAtzeraBotoia();
			}
		};
	} 
	
	// *****************************************************************************************************************************************************************************************************
	
	private ActionListener listenerHasieraBotoia(ControladorPanelMenuTaberna controladorPanelMenu2) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorPanelMenu2.sakatuHasieraBotoia();
			}
		};
	}
}
