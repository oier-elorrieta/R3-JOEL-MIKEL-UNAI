package Vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;  
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import Controlador.ControladorPanelLogin;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JOptionPane;
 
@SuppressWarnings("serial")
public class PanelLogin extends JPanel {

	private ControladorPanelLogin controladorPanelLogin;
	
	private JButton btnSarratu;
	private JButton btnLogin;
	private JButton btnErregistratu;

	private JLabel LB_Erabiltzailea;
	private JLabel LB_1;
	private JLabel LB_Pasahitza;
	
	private JTextField TF_Erabiltzailea;
	private JPasswordField TF_Pasahitza;

	// *****************************************************************************************************************************************************************************************************
	
	public PanelLogin(ControladorPanelLogin controladorPanelLogin) {

		this.controladorPanelLogin = controladorPanelLogin;
		
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
		
		TF_Erabiltzailea = new JTextField();
		TF_Erabiltzailea.setBounds(135, 60, 170, 19);
		add(TF_Erabiltzailea);
		TF_Erabiltzailea.setColumns(10);
		
		TF_Pasahitza = new JPasswordField();
		TF_Pasahitza.setColumns(10);
		TF_Pasahitza.setBounds(135, 120, 170, 19);
		add(TF_Pasahitza);
		
		// _______________________________________________________________________________________________________________________________________________________________________________
		
		LB_Erabiltzailea = new JLabel("Erabiltzailea:");
		LB_Erabiltzailea.setBounds(135, 37, 170, 13);
		add(LB_Erabiltzailea);
		
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
		this.btnSarratu.addActionListener(listenerSarratuBotoia(this.controladorPanelLogin));
		this.btnLogin.addActionListener(listenerLoginBotoia(this.controladorPanelLogin));
		this.btnErregistratu.addActionListener(listenerErregistratuBotoia(this.controladorPanelLogin));
	}  
	
	// *****************************************************************************************************************************************************************************************************
	
	private ActionListener listenerLoginBotoia(ControladorPanelLogin controladorPanelLogin) {
		return new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				/*if(TF_Erabiltzailea.getText().equals("1") && TF_Pasahitza.getText().equals("1")) {
					controladorPanelLogin.sakatuPanelJatetxBotoia();
				} else if(TF_Erabiltzailea.getText().equals("2") && TF_Pasahitza.getText().equals("2")) {
					controladorPanelLogin.sakatuPanelKafetegiaBotoia();
				}else if(TF_Erabiltzailea.getText().equals("3") && TF_Pasahitza.getText().equals("3")){
					controladorPanelLogin.sakatuPanelTabernaBotoia();
				}else {
					JOptionPane.showMessageDialog(null, "Aukera hau ez du balio", "ERROR", JOptionPane.ERROR_MESSAGE);
				}*/
				String pasahitza = TF_Pasahitza.getText();
				String erabiltzailea = TF_Erabiltzailea.getText();
				String kk = controladorPanelLogin.konprobatuErabiltzailea(erabiltzailea, pasahitza);
				if(kk.equals("Ona")) {
					controladorPanelLogin.sakatuPanelJatetxBotoia();
				}
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
