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

	private JLabel lb_DNI;
	private JLabel lb_1;
	private JLabel lb_Pasahitza;

	private JTextField tf_DNI;
	private JPasswordField tf_Pasahitza;

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

		tf_DNI = new JTextField();
		tf_DNI.setBounds(135, 60, 170, 19);
		add(tf_DNI);
		tf_DNI.setColumns(10);

		tf_Pasahitza = new JPasswordField();
		tf_Pasahitza.setColumns(10);
		tf_Pasahitza.setBounds(135, 120, 170, 19);
		add(tf_Pasahitza);

		// _______________________________________________________________________________________________________________________________________________________________________________

		lb_DNI = new JLabel("DNI:");
		lb_DNI.setBounds(135, 37, 170, 13);
		add(lb_DNI);

		lb_Pasahitza = new JLabel("Pasahitza:");
		lb_Pasahitza.setBounds(135, 97, 170, 13);
		add(lb_Pasahitza);

		lb_1 = new JLabel("*********************************");
		lb_1.setHorizontalAlignment(SwingConstants.CENTER);
		lb_1.setBounds(10, 201, 430, 13);
		add(lb_1);

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
				
				String pasahitza = tf_Pasahitza.getText();
				String erabiltzailea = tf_DNI.getText();
				
				String nif = controladorPanelLogin.konprobatuNIF(erabiltzailea);
				String lokalaMota = controladorPanelLogin.konprobatuLokala(nif);
				String erroreaLogeatzean = controladorPanelLogin.konprobatuErabiltzailea(erabiltzailea, pasahitza);
				
				if (erroreaLogeatzean.equals("EZ")) {
					
					if (lokalaMota.equals("Bar")) {
						controladorPanelLogin.sakatuPanelTabernaBotoia();
					} else if (lokalaMota.equals("Cafeter�a")) {
						controladorPanelLogin.sakatuPanelKafetegiaBotoia();
					} else if (lokalaMota.equals("Restaurante")) {
						controladorPanelLogin.sakatuPanelJatetxeBotoia();
					}
					
					System.out.println(lokalaMota);
					
				} else {
					controladorPanelLogin.ikusiPanelLogin();
				}
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
