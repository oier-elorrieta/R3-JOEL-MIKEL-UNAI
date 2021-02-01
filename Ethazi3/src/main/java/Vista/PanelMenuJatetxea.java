package Vista;

import java.awt.Color;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;  
import javax.swing.JPanel;
 
import Controlador.ControladorPanelMenuJatetxea; 

@SuppressWarnings("serial")
public class PanelMenuJatetxea extends JPanel {

	private ControladorPanelMenuJatetxea controladorPanelMenu;
	
	private JButton btnFaktura;
	private JButton btnTicket;
	private JButton btnEskaera;
	private JButton btnSarratu;
	private JButton btnKomanda;
	private JButton btnHasiera;

	// *****************************************************************************************************************************************************************************************************
	
	public PanelMenuJatetxea(ControladorPanelMenuJatetxea controladorPanelMenu) {

		this.controladorPanelMenu = controladorPanelMenu;
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
		btnEskaera.setBounds(10, 135, 210, 113);
		add(btnEskaera);


		btnSarratu = new JButton("SARRATU ");
		btnSarratu.setFont(new Font("Tahoma", Font.ITALIC, 11));
		btnSarratu.setBounds(350, 259, 90, 30);
		add(btnSarratu);
		
		btnKomanda = new JButton("KOMANDA");
		btnKomanda.setFont(new Font("Tahoma", Font.ITALIC, 11));
		btnKomanda.setBounds(230, 135, 210, 113);
		add(btnKomanda);
		
		btnHasiera = new JButton("Hasiera");
		btnHasiera.setFont(new Font("Tahoma", Font.ITALIC, 11));
		btnHasiera.setBounds(10, 259, 90, 30);
		add(btnHasiera);

		initializeEvents();
	}
	
	// *****************************************************************************************************************************************************************************************************
	
	private void initializeEvents() {
		this.btnFaktura.addActionListener(listenerFakturaBotoia(this.controladorPanelMenu));
		this.btnTicket.addActionListener(listenerTicketBotoia(this.controladorPanelMenu));
		this.btnEskaera.addActionListener(listenerEskaeraBotoia(this.controladorPanelMenu));
		this.btnSarratu.addActionListener(listenerSarratuBotoia(this.controladorPanelMenu));
		this.btnHasiera.addActionListener(listenerHasieraBotoia(this.controladorPanelMenu));
	}
	
	// *****************************************************************************************************************************************************************************************************
	
	private ActionListener listenerFakturaBotoia(ControladorPanelMenuJatetxea controladorPanelMenu) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorPanelMenu.sakatuFakturaPanelaIkustekoBotoia();
			}
		};
	} 
	
	// *****************************************************************************************************************************************************************************************************
	
	private ActionListener listenerTicketBotoia(ControladorPanelMenuJatetxea controladorPanelMenu) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorPanelMenu.sakatuTicketPanelaIkustekoBotoia();
			}
		};
	} 
	
	// *****************************************************************************************************************************************************************************************************
	
	private ActionListener listenerEskaeraBotoia(ControladorPanelMenuJatetxea controladorPanelMenu) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorPanelMenu.sakatuEskaeraPanelaIkustekoBotoia();
			}
		};
	} 
	
	// *****************************************************************************************************************************************************************************************************
	
	private ActionListener listenerSarratuBotoia(ControladorPanelMenuJatetxea controladorPanelMenu) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorPanelMenu.sakatuAtzeraBotoia();
			}
		};
	}
	
	// *****************************************************************************************************************************************************************************************************
	
	private ActionListener listenerHasieraBotoia(ControladorPanelMenuJatetxea controladorPanelMenu) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorPanelMenu.sakatuHasieraBotoia();
			}
		};
	}
}
