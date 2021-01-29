package Vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;  
import javax.swing.JPanel;

import Controlador.ControladorPanelLogin;
 
@SuppressWarnings("serial")
public class PanelLogin extends JPanel {

	private ControladorPanelLogin controladorPanelMenu;
	
	private JButton BT_cafeteria;
	private JButton BT_bar;
	private JButton BT_restaurante;
	private JButton btnSarratu;

	// *****************************************************************************************************************************************************************************************************
	
	public PanelLogin(ControladorPanelLogin controladorPanelLogin) {

		this.controladorPanelMenu = controladorPanelLogin;

		setBackground(Color.LIGHT_GRAY);
		setLayout(null);

		setBounds(0, 0, 450, 300);

		BT_bar = new JButton("BAR");
		BT_bar.setFont(new Font("Tahoma", Font.ITALIC, 11));
		BT_bar.setBounds(10, 11, 210, 113); 
		add(BT_bar);

		BT_cafeteria = new JButton("CAFETERIA");
		BT_cafeteria.setFont(new Font("Tahoma", Font.ITALIC, 11));
		BT_cafeteria.setBounds(230, 11, 210, 113);
		add(BT_cafeteria);

		BT_restaurante = new JButton("RESTAURANTE");
		BT_restaurante.setFont(new Font("Tahoma", Font.ITALIC, 11));
		BT_restaurante.setBounds(123, 135, 210, 113);
		add(BT_restaurante);


		btnSarratu = new JButton("SARRATU ");
		btnSarratu.setFont(new Font("Tahoma", Font.ITALIC, 11));
		btnSarratu.setBounds(350, 259, 90, 30);
		add(btnSarratu);

		initializeEvents();
	}
	
	// *****************************************************************************************************************************************************************************************************
	
	private void initializeEvents() {
		this.BT_cafeteria.addActionListener(listenerBottonFaktura(this.controladorPanelMenu));
		this.BT_bar.addActionListener(listenerBottonTicket(this.controladorPanelMenu));
		this.BT_restaurante.addActionListener(listenerBottonEskaera(this.controladorPanelMenu));
		this.btnSarratu.addActionListener(listenerBottonSarratu(this.controladorPanelMenu));
	}
	
	// *****************************************************************************************************************************************************************************************************
	
	private ActionListener listenerBottonFaktura(ControladorPanelLogin controladorPanelMenu2) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorPanelMenu2.accionadoBottonMostrarPanelBar();
			}
		};
	} 
	
	// *****************************************************************************************************************************************************************************************************
	
	private ActionListener listenerBottonTicket(ControladorPanelLogin controladorPanelMenu2) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorPanelMenu2.accionadoBottonMostrarPanelCafeteria();
			}
		};
	} 
	
	// *****************************************************************************************************************************************************************************************************
	
	private ActionListener listenerBottonEskaera(ControladorPanelLogin controladorPanelMenu2) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorPanelMenu2.accionadoBottonMostrarPanelRestaurante();
			}
		};
	}
	
	// *****************************************************************************************************************************************************************************************************
	
	private ActionListener listenerBottonSarratu(ControladorPanelLogin controladorPanelMenu2) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorPanelMenu2.accionadoBottonAtzera();
			}
		};
	} 
}
