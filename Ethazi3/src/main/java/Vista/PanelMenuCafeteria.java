package Vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;  
import javax.swing.JPanel;

import Controlador.ControladorPanelMenuCafeteria; 

@SuppressWarnings("serial")
public class PanelMenuCafeteria extends JPanel {

	private ControladorPanelMenuCafeteria controladorPanelMenu3;
	
	private JButton btnFaktura;
	private JButton btnTicket;
	private JButton btnEskaera;
	private JButton btnSarratu;
	private JButton btnHasiera;

	// *****************************************************************************************************************************************************************************************************
	
	public PanelMenuCafeteria(ControladorPanelMenuCafeteria controladorPanelMenu3) {

		this.controladorPanelMenu3 = controladorPanelMenu3;
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
		
		btnHasiera = new JButton("Hasiera");
		btnHasiera.setFont(new Font("Tahoma", Font.ITALIC, 11));
		btnHasiera.setBounds(10, 259, 90, 30);
		add(btnHasiera);

		initializeEvents();
	}
	
	// *****************************************************************************************************************************************************************************************************
	
	private void initializeEvents() {
		this.btnFaktura.addActionListener(listenerBottonFaktura(this.controladorPanelMenu3));
		this.btnTicket.addActionListener(listenerBottonTicket(this.controladorPanelMenu3));
		this.btnEskaera.addActionListener(listenerBottonEskaera(this.controladorPanelMenu3));
		this.btnSarratu.addActionListener(listenerBottonSarratu(this.controladorPanelMenu3));
		this.btnHasiera.addActionListener(listenerBotonHasiera(this.controladorPanelMenu3));
	}
	
	// *****************************************************************************************************************************************************************************************************
	
	private ActionListener listenerBottonFaktura(ControladorPanelMenuCafeteria controladorPanelMenu3) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorPanelMenu3.accionadoBottonMostrarPanelFaktura();
			}
		};
	} 
	
	// *****************************************************************************************************************************************************************************************************
	
	private ActionListener listenerBottonTicket(ControladorPanelMenuCafeteria controladorPanelMenu3) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorPanelMenu3.accionadoBottonMostrarPanelTicket();
			}
		};
	} 
	
	// *****************************************************************************************************************************************************************************************************
	
	private ActionListener listenerBottonEskaera(ControladorPanelMenuCafeteria controladorPanelMenu3) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorPanelMenu3.accionadoBottonMostrarPanelPedidos();
			}
		};
	} 
	
	// *****************************************************************************************************************************************************************************************************
	
	private ActionListener listenerBottonSarratu(ControladorPanelMenuCafeteria controladorPanelMenu3) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorPanelMenu3.accionadoBottonAtzera();
			}
		};
	} 
	
	// *****************************************************************************************************************************************************************************************************
	
	private ActionListener listenerBotonHasiera(ControladorPanelMenuCafeteria controladorPanelMenu3) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorPanelMenu3.accionadoBotonHasiera();
			}
		};
	} 
}
