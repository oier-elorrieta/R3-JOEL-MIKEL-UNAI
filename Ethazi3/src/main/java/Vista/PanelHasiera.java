package Vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;  
import javax.swing.JPanel;

import Controlador.ControladorPanelHasiera;
 
@SuppressWarnings("serial")
public class PanelHasiera extends JPanel {

	private ControladorPanelHasiera controladorPanelMenu;
	
	private JButton BT_Kafetegi;
	private JButton BT_Taberna;
	private JButton BT_Jatetxe;
	private JButton btnSarratu;

	// *****************************************************************************************************************************************************************************************************
	
	public PanelHasiera(ControladorPanelHasiera controladorPanelLogin) {

		this.controladorPanelMenu = controladorPanelLogin;

		setBackground(Color.LIGHT_GRAY);
		setLayout(null);

		setBounds(0, 0, 450, 300);

		BT_Taberna = new JButton("TABERNA");
		BT_Taberna.setFont(new Font("Tahoma", Font.ITALIC, 11));
		BT_Taberna.setBounds(10, 11, 210, 113); 
		add(BT_Taberna);

		BT_Kafetegi = new JButton("KAFETEGIA");
		BT_Kafetegi.setFont(new Font("Tahoma", Font.ITALIC, 11));
		BT_Kafetegi.setBounds(230, 11, 210, 113);
		add(BT_Kafetegi);

		BT_Jatetxe = new JButton("JATETXEA");
		BT_Jatetxe.setFont(new Font("Tahoma", Font.ITALIC, 11));
		BT_Jatetxe.setBounds(123, 135, 210, 113);
		add(BT_Jatetxe);


		btnSarratu = new JButton("SARRATU ");
		btnSarratu.setFont(new Font("Tahoma", Font.ITALIC, 11));
		btnSarratu.setBounds(350, 259, 90, 30);
		add(btnSarratu);

		initializeEvents();
	}
	
	// *****************************************************************************************************************************************************************************************************
	
	private void initializeEvents() {
		this.BT_Kafetegi.addActionListener(listenerKafetegiBotoia(this.controladorPanelMenu));
		this.BT_Taberna.addActionListener(listenerTabernaBotoia(this.controladorPanelMenu));
		this.BT_Jatetxe.addActionListener(listenerJatetxeBotoia(this.controladorPanelMenu));
		this.btnSarratu.addActionListener(listenerSarratuBotoia(this.controladorPanelMenu));
	}
	
	// *****************************************************************************************************************************************************************************************************
	
	private ActionListener listenerTabernaBotoia(ControladorPanelHasiera controladorPanelMenu2) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorPanelMenu2.sakatuPanelTabernaBotoia();
			}
		};
	} 
	
	// *****************************************************************************************************************************************************************************************************
	
	private ActionListener listenerKafetegiBotoia(ControladorPanelHasiera controladorPanelMenu2) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorPanelMenu2.sakatuPanelKafetegiaBotoia();
			}
		};
	} 
	
	// *****************************************************************************************************************************************************************************************************
	
	private ActionListener listenerJatetxeBotoia(ControladorPanelHasiera controladorPanelMenu2) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorPanelMenu2.sakatuPanelJatetxBotoia();
			}
		};
	}
	
	// *****************************************************************************************************************************************************************************************************
	
	private ActionListener listenerSarratuBotoia(ControladorPanelHasiera controladorPanelMenu2) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorPanelMenu2.sakatuAtzeraBotoia();
			}
		};
	} 
}
