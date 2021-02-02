package Vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;  
import javax.swing.JPanel;

import Controlador.ControladorPanelLogin;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
 
@SuppressWarnings("serial")
public class PanelLogin extends JPanel {

	private ControladorPanelLogin controladorPanelMenu;
	
	private JButton btnSarratu;
	private JButton btnLogin;
	private JButton btnErregistratu;

	private JLabel LB_Usuarioa;
	private JLabel LB_1;
	private JLabel LB_Pasahitza;
	
	private JTextField TF_Usuarioa;
	private JTextField TF_Pasahitza;

	// *****************************************************************************************************************************************************************************************************
	
	public PanelLogin(ControladorPanelLogin controladorPanelLogin) {

		this.controladorPanelMenu = controladorPanelLogin;
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);
		setBounds(0, 0, 450, 300);

		// _______________________________________________________________________________________________________________________________________________________________________________
		
		btnSarratu = new JButton("SARRATU ");
		btnSarratu.setFont(new Font("Tahoma", Font.ITALIC, 11));
		btnSarratu.setBounds(350, 259, 90, 30);
		add(btnSarratu);
		
		btnLogin = new JButton("Login");
		btnLogin.setBounds(165, 170, 115, 21);
		add(btnLogin);
		
		btnErregistratu = new JButton("Erregistratu");
		btnErregistratu.setBounds(165, 220, 115, 21);
		add(btnErregistratu);
		
		// _______________________________________________________________________________________________________________________________________________________________________________
		
		TF_Usuarioa = new JTextField();
		TF_Usuarioa.setBounds(135, 60, 170, 19);
		add(TF_Usuarioa);
		TF_Usuarioa.setColumns(10);
		
		TF_Pasahitza = new JTextField();
		TF_Pasahitza.setColumns(10);
		TF_Pasahitza.setBounds(135, 120, 170, 19);
		add(TF_Pasahitza);
		
		// _______________________________________________________________________________________________________________________________________________________________________________
		
		LB_Usuarioa = new JLabel("Usuarioa:");
		LB_Usuarioa.setBounds(135, 37, 170, 13);
		add(LB_Usuarioa);
		
		LB_Pasahitza = new JLabel("Pasahitza:");
		LB_Pasahitza.setBounds(135, 97, 170, 13);
		add(LB_Pasahitza);
		
		LB_1 = new JLabel("*********************************");
		LB_1.setHorizontalAlignment(SwingConstants.CENTER);
		LB_1.setBounds(10, 201, 430, 13);
		add(LB_1);

		initializeEvents();
	}
	
	// *****************************************************************************************************************************************************************************************************
	
	private void initializeEvents() {
		this.btnSarratu.addActionListener(listenerSarratuBotoia(this.controladorPanelMenu));
		this.btnLogin.addActionListener(listenerLoginBotoia(this.controladorPanelMenu));
		this.btnErregistratu.addActionListener(listenerErregistratuBotoia(this.controladorPanelMenu));
	}  
	
	// *****************************************************************************************************************************************************************************************************
	
	private ActionListener listenerLoginBotoia(ControladorPanelLogin controladorPanelMenu2) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorPanelMenu2.sakatuPanelJatetxBotoia();
			}
		};
	} 
	
	// *****************************************************************************************************************************************************************************************************
	
	private ActionListener listenerErregistratuBotoia(ControladorPanelLogin controladorPanelMenu2) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorPanelMenu2.sakatuPanelErregistratuBotoia();
			}
		};
	}
	
	// *****************************************************************************************************************************************************************************************************
	
	private ActionListener listenerSarratuBotoia(ControladorPanelLogin controladorPanelMenu2) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorPanelMenu2.sakatuAtzeraBotoia();
			}
		};
	} 
}
