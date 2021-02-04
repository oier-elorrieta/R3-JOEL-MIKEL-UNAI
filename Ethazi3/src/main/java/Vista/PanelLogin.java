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

@SuppressWarnings("serial")
public class PanelLogin extends JPanel {

	private ControladorPanelLogin controladorPanelLogin;

	private JButton btnSarratu;
	private JButton btnLogin;
	private JButton btnErregistratu;

	private JLabel LB_DNI;
	private JLabel LB_1;
	private JLabel LB_Pasahitza;

	private JTextField TF_DNI;
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
		btnLogin.setFont(new Font("Tahoma", Font.ITALIC, 11));
		btnLogin.setBounds(165, 170, 115, 21);
		add(btnLogin);

		btnErregistratu = new JButton("Erregistratu");
		btnErregistratu.setFont(new Font("Tahoma", Font.ITALIC, 11));
		btnErregistratu.setBounds(165, 220, 115, 21);
		add(btnErregistratu);

		// _______________________________________________________________________________________________________________________________________________________________________________

		TF_DNI = new JTextField();
		TF_DNI.setBounds(135, 60, 170, 19);
		add(TF_DNI);
		TF_DNI.setColumns(10);

		TF_Pasahitza = new JPasswordField();
		TF_Pasahitza.setColumns(10);
		TF_Pasahitza.setBounds(135, 120, 170, 19);
		add(TF_Pasahitza);

		// _______________________________________________________________________________________________________________________________________________________________________________

		LB_DNI = new JLabel("DNI:");
		LB_DNI.setBounds(135, 37, 170, 13);
		add(LB_DNI);

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
			@SuppressWarnings({ "deprecation" })
			public void actionPerformed(ActionEvent arg0) {
				String pasahitza = TF_Pasahitza.getText();
				String erabiltzailea = TF_DNI.getText();
				String NIF = controladorPanelLogin.konprobatuErabiltzailea(erabiltzailea, pasahitza);
				if(NIF == null){
					controladorPanelLogin.ikusiPanelLogin();
				}else {
					if(NIF.charAt(8)=='B') {
						controladorPanelLogin.sakatuPanelTabernaBotoia();
					}else if(NIF.charAt(8)=='C') {
						controladorPanelLogin.sakatuPanelKafetegiaBotoia();
					}else if(NIF.charAt(8)=='R') {
						controladorPanelLogin.sakatuPanelJatetxeBotoia();
					}
					
				}
				controladorPanelLogin.NIF(erabiltzailea, pasahitza);
			}
		};
	} 

	// *****************************************************************************************************************************************************************************************************

	private ActionListener listenerErregistratuBotoia(ControladorPanelLogin controladorPanelLogin) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorPanelLogin.sakatuPanelErregistratuBotoia();
			}
		};
	}

	// *****************************************************************************************************************************************************************************************************

	private ActionListener listenerSarratuBotoia(ControladorPanelLogin controladorPanelLogin) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorPanelLogin.sakatuAtzeraBotoia();
			}
		};
	} 
}
