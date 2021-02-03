package Vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;  
import javax.swing.JPanel;

import Controlador.ControladorPanelErregistratu;
import javax.swing.JLabel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class PanelErregistratu extends JPanel {

	private ControladorPanelErregistratu controladorPanelErregistratu; 

	private JButton btnSarratu;
	private JButton btnErregistratu;

	private JLabel LB_Erabiltzailea;
	private JLabel LB_Pasahitza;

	private JTextField TF_Izena;
	private JTextField TF_Abizena;
	private JTextField TF_Erabiltzailea;
	private JTextField TF_Pasahitza;

	private JLabel LB_DNI;
	private JLabel LB_NIF;
	private JLabel LB_Abizena;
	private JLabel LB_Izena;
	private JTextField TF_DNI;
	private JTextField TF_NIF;

	// *****************************************************************************************************************************************************************************************************

	public PanelErregistratu(ControladorPanelErregistratu controladorPanelErregistratu) {

		this.controladorPanelErregistratu = controladorPanelErregistratu; 

		setBackground(Color.LIGHT_GRAY);
		setLayout(null);
		setBounds(0, 0, 450, 300);

		// _______________________________________________________________________________________________________________________________________________________________________________

		btnSarratu = new JButton("SARRATU ");
		btnSarratu.setFont(new Font("Tahoma", Font.ITALIC, 11));
		btnSarratu.setBounds(350, 259, 90, 30);
		add(btnSarratu);

		btnErregistratu = new JButton("Erregistratu");
		btnErregistratu.setBounds(250, 182, 190, 21);
		add(btnErregistratu);

		// _______________________________________________________________________________________________________________________________________________________________________________

		TF_Izena = new JTextField();
		TF_Izena.setBounds(10, 61, 190, 19);
		add(TF_Izena);
		TF_Izena.setColumns(10);

		TF_Abizena = new JTextField();
		TF_Abizena.setColumns(10);
		TF_Abizena.setBounds(10, 120, 190, 19);
		add(TF_Abizena);

		TF_Erabiltzailea = new JTextField();
		TF_Erabiltzailea.setColumns(10);
		TF_Erabiltzailea.setBounds(10, 182, 190, 19);
		add(TF_Erabiltzailea);

		TF_Pasahitza = new JTextField();
		TF_Pasahitza.setColumns(10);
		TF_Pasahitza.setBounds(10, 234, 190, 19);
		add(TF_Pasahitza);

		TF_DNI = new JTextField();
		TF_DNI.setColumns(10);
		TF_DNI.setBounds(250, 61, 190, 19);
		add(TF_DNI);
		
		TF_NIF = new JTextField();
		TF_NIF.setColumns(10);
		TF_NIF.setBounds(250, 120, 190, 19);
		add(TF_NIF); 
		
		// _______________________________________________________________________________________________________________________________________________________________________________

		LB_Erabiltzailea = new JLabel("Erabiltzailea:");
		LB_Erabiltzailea.setBounds(10, 156, 190, 13);
		add(LB_Erabiltzailea);

		LB_Pasahitza = new JLabel("Pasahitza:");
		LB_Pasahitza.setBounds(10, 210, 190, 13);
		add(LB_Pasahitza);

		LB_Abizena = new JLabel("Abizena:");
		LB_Abizena.setBounds(10, 96, 190, 13);
		add(LB_Abizena);

		LB_Izena = new JLabel("Izena:");
		LB_Izena.setBounds(10, 37, 190, 13);
		add(LB_Izena);
		
		LB_NIF = new JLabel("NIF:");
		LB_NIF.setBounds(250, 95, 190, 13);
		add(LB_NIF);
		
		LB_DNI = new JLabel("DNI:");
		LB_DNI.setBounds(250, 36, 190, 13);
		add(LB_DNI);

		initializeEvents();
	}

	// *****************************************************************************************************************************************************************************************************

	private void initializeEvents() {
		this.btnSarratu.addActionListener(listenerSarratuBotoia(this.controladorPanelErregistratu));
		this.btnErregistratu.addActionListener(listenerErregistratuBotoia(this.controladorPanelErregistratu));
	}

	// *****************************************************************************************************************************************************************************************************

	private ActionListener listenerErregistratuBotoia(ControladorPanelErregistratu controladorPanelErregistratu) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) { 
				String izena = TF_Izena.getText();
				String abizena = TF_Abizena.getText();
				String pasahitza = TF_Pasahitza.getText();
				String erabiltzailea = TF_Erabiltzailea.getText();
				String dni = TF_DNI.getText();
				String nif = TF_NIF.getText();
				try {
					controladorPanelErregistratu.sakatuErregistratuBotoia(izena, abizena, erabiltzailea, pasahitza, dni, nif);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			
				controladorPanelErregistratu.sakatuAtzeraBotoia();
			}
		};
	} 

	// *****************************************************************************************************************************************************************************************************

	private ActionListener listenerSarratuBotoia(ControladorPanelErregistratu controladorPanelMenu2) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorPanelMenu2.sakatuAtzeraBotoia();
			}
		};
	} 
}
