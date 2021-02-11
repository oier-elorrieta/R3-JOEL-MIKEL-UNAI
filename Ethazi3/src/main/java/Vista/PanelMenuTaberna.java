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

	private ControladorPanelMenuTaberna controladorPanelMenuTaberna;
	
	private JButton btnFaktura;
	private JButton btnTicket;
	private JButton btnSarratu;
	private JButton btnHasiera;

	// *****************************************************************************************************************************************************************************************************
	
	public PanelMenuTaberna(ControladorPanelMenuTaberna controladorPanelMenuTaberna) {

		this.controladorPanelMenuTaberna = controladorPanelMenuTaberna;
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
		this.btnFaktura.addActionListener(listenerFakturaBotoia(this.controladorPanelMenuTaberna));
		this.btnTicket.addActionListener(listenerTicketBotoia(this.controladorPanelMenuTaberna));
		this.btnSarratu.addActionListener(listenerSarratuBotoia(this.controladorPanelMenuTaberna));
		this.btnHasiera.addActionListener(listenerHasieraBotoia(this.controladorPanelMenuTaberna));
	}
	
	// *****************************************************************************************************************************************************************************************************
	
	private ActionListener listenerFakturaBotoia(ControladorPanelMenuTaberna controladorPanelMenuTaberna) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorPanelMenuTaberna.sakatuFakturaPanelaIkustekoBotoia();
			}
		};
	} 
	
	// *****************************************************************************************************************************************************************************************************
	
	private ActionListener listenerTicketBotoia(ControladorPanelMenuTaberna controladorPanelMenuTaberna) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorPanelMenuTaberna.sakatuTicketPanelaIkustekoBotoia();
			}
		};
	} 
	
	// *****************************************************************************************************************************************************************************************************
	
	private ActionListener listenerSarratuBotoia(ControladorPanelMenuTaberna controladorPanelMenuTaberna) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorPanelMenuTaberna.sakatuAtzeraBotoia();
			}
		};
	} 
	
	// *****************************************************************************************************************************************************************************************************
	
	private ActionListener listenerHasieraBotoia(ControladorPanelMenuTaberna controladorPanelMenuTaberna) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorPanelMenuTaberna.sakatuHasieraBotoia();
			}
		};
	}
}
