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

	private ControladorPanelMenuJatetxea controladorPanelJatetxea;
	
	private JButton btnFaktura;
	private JButton btnTicket;
	private JButton btnEskaera;
	private JButton btnSarratu;
	private JButton btnKomanda;
	private JButton btnHasiera;
	private JButton btnHornikuntza;

	// *****************************************************************************************************************************************************************************************************
	
	public PanelMenuJatetxea(ControladorPanelMenuJatetxea controladorPanelJatetxea) {

		this.controladorPanelJatetxea = controladorPanelJatetxea;
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);
		setBounds(0, 0, 450, 300);

		btnTicket = new JButton("TICKET");
		btnTicket.setFont(new Font("Tahoma", Font.ITALIC, 11));
		btnTicket.setBounds(10, 11, 185, 113); 
		add(btnTicket);

		btnFaktura = new JButton("FAKTURA");
		btnFaktura.setFont(new Font("Tahoma", Font.ITALIC, 11));
		btnFaktura.setBounds(255, 11, 185, 113);
		add(btnFaktura);

		btnEskaera = new JButton("ESKAERA");
		btnEskaera.setFont(new Font("Tahoma", Font.ITALIC, 11));
		btnEskaera.setBounds(10, 135, 185, 113);
		add(btnEskaera);


		btnSarratu = new JButton("SARRATU ");
		btnSarratu.setFont(new Font("Tahoma", Font.ITALIC, 11));
		btnSarratu.setBounds(350, 259, 90, 30);
		add(btnSarratu);
		
		btnKomanda = new JButton("KOMANDA");
		btnKomanda.setFont(new Font("Tahoma", Font.ITALIC, 11));
		btnKomanda.setBounds(255, 135, 185, 113);
		add(btnKomanda);
		
		btnHasiera = new JButton("DESLOGEATU");
		btnHasiera.setFont(new Font("Tahoma", Font.ITALIC, 8));
		btnHasiera.setBounds(10, 259, 90, 30);
		add(btnHasiera);
		
		btnHornikuntza = new JButton("+");
		btnHornikuntza.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnHornikuntza.setBounds(204, 11, 41, 237);
		add(btnHornikuntza);

		initializeEvents();
	}
	
	// *****************************************************************************************************************************************************************************************************
	
	private void initializeEvents() {
		this.btnFaktura.addActionListener(listenerFakturaBotoia(this.controladorPanelJatetxea));
		this.btnTicket.addActionListener(listenerTicketBotoia(this.controladorPanelJatetxea));
		this.btnEskaera.addActionListener(listenerEskaeraBotoia(this.controladorPanelJatetxea));
		this.btnSarratu.addActionListener(listenerSarratuBotoia(this.controladorPanelJatetxea));
		this.btnHasiera.addActionListener(listenerHasieraBotoia(this.controladorPanelJatetxea));
		this.btnHornikuntza.addActionListener(listenerHornikuntzaBotoia(this.controladorPanelJatetxea));
		this.btnKomanda.addActionListener(listenerKomandaBotoia(this.controladorPanelJatetxea));

	}
	
	// *****************************************************************************************************************************************************************************************************
	
	private ActionListener listenerFakturaBotoia(ControladorPanelMenuJatetxea controladorPanelJatetxea) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorPanelJatetxea.sakatuFakturaPanelaIkustekoBotoia();
			}
		};
	} 
	
	// *****************************************************************************************************************************************************************************************************
	
	private ActionListener listenerTicketBotoia(ControladorPanelMenuJatetxea controladorPanelJatetxea) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorPanelJatetxea.sakatuTicketPanelaIkustekoBotoia();
			}
		};
	} 
	
	// *****************************************************************************************************************************************************************************************************
	
	private ActionListener listenerEskaeraBotoia(ControladorPanelMenuJatetxea controladorPanelJatetxea) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorPanelJatetxea.sakatuEskaeraPanelaIkustekoBotoia();
			}
		};
	} 
	
	// *****************************************************************************************************************************************************************************************************
	
	private ActionListener listenerSarratuBotoia(ControladorPanelMenuJatetxea controladorPanelJatetxea) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorPanelJatetxea.sakatuAtzeraBotoia();
			}
		};
	}
	
	// *****************************************************************************************************************************************************************************************************
	
		private ActionListener listenerHornikuntzaBotoia(ControladorPanelMenuJatetxea controladorPanelJatetxea) {
			return new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					controladorPanelJatetxea.sakatuHornikuntzaBotoia();
				}
			};
		} 
	
	// *****************************************************************************************************************************************************************************************************
	
	private ActionListener listenerHasieraBotoia(ControladorPanelMenuJatetxea controladorPanelJatetxea) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorPanelJatetxea.sakatuHasieraBotoia();
			}
		};
	}
	
	// *****************************************************************************************************************************************************************************************************
	
	private ActionListener listenerKomandaBotoia(ControladorPanelMenuJatetxea controladorPanelJatetxea) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorPanelJatetxea.sakatuKomandaPanelaIkustekoBotoia();
			}
		};
	}
}
