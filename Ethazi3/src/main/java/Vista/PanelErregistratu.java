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
	private JButton btnAtzera;

	private JTextField TF_Izena;
	private JTextField TF_Abizena;
	private JTextField TF_Pasahitza;
	private JTextField TF_DNI;
	private JTextField TF_NIF;
	
	private JLabel LB_Pasahitza;
	private JLabel LB_DNI;
	private JLabel LB_NIF;
	private JLabel LB_Abizena;
	private JLabel LB_Izena;
	
	// *****************************************************************************************************************************************************************************************************

	public PanelErregistratu(ControladorPanelErregistratu controladorPanelErregistratu) {

		this.controladorPanelErregistratu = controladorPanelErregistratu; 

		setBackground(Color.LIGHT_GRAY);
		setLayout(null);
		setBounds(0, 0, 450, 300);

		// _______________________________________________________________________________________________________________________________________________________________________________

		btnSarratu = new JButton("SARRATU ");
		btnSarratu.setFont(new Font("Tahoma", Font.ITALIC, 11));
		btnSarratu.setBounds(250, 236, 190, 21);
		add(btnSarratu);

		btnErregistratu = new JButton("Erregistratu");
		btnErregistratu.setFont(new Font("Tahoma", Font.ITALIC, 11));
		btnErregistratu.setBounds(250, 118, 190, 21);
		add(btnErregistratu);

		btnAtzera = new JButton("Atzera");
		btnAtzera.setFont(new Font("Tahoma", Font.ITALIC, 11));
		btnAtzera.setBounds(250, 181, 190, 21);
		add(btnAtzera);
		
		// _______________________________________________________________________________________________________________________________________________________________________________

		TF_Izena = new JTextField();
		TF_Izena.setBounds(10, 61, 190, 19);
		add(TF_Izena);
		TF_Izena.setColumns(10);

		TF_Abizena = new JTextField();
		TF_Abizena.setColumns(10);
		TF_Abizena.setBounds(10, 120, 190, 19);
		add(TF_Abizena);

		TF_Pasahitza = new JTextField();
		TF_Pasahitza.setColumns(10);
		TF_Pasahitza.setBounds(10, 236, 190, 19);
		add(TF_Pasahitza);

		TF_DNI = new JTextField();
		TF_DNI.setColumns(10);
		TF_DNI.setBounds(10, 182, 190, 19);
		add(TF_DNI);
		
		TF_NIF = new JTextField();
		TF_NIF.setColumns(10);
		TF_NIF.setBounds(250, 61, 190, 19);
		add(TF_NIF);

		// _______________________________________________________________________________________________________________________________________________________________________________
		
		LB_Pasahitza = new JLabel("Pasahitza:");
		LB_Pasahitza.setBounds(10, 212, 190, 13);
		add(LB_Pasahitza);

		LB_Abizena = new JLabel("Abizena:");
		LB_Abizena.setBounds(10, 96, 190, 13);
		add(LB_Abizena);

		LB_Izena = new JLabel("Izena:");
		LB_Izena.setBounds(10, 37, 190, 13);
		add(LB_Izena);
		
		LB_NIF = new JLabel("NIF:");
		LB_NIF.setBounds(250, 37, 190, 13);
		add(LB_NIF);
		
		LB_DNI = new JLabel("DNI:");
		LB_DNI.setBounds(10, 158, 190, 13);
		add(LB_DNI);

		initializeEvents();
	}

	// *****************************************************************************************************************************************************************************************************

	private void initializeEvents() {
		this.btnSarratu.addActionListener(listenerSarratuBotoia(this.controladorPanelErregistratu));
		this.btnErregistratu.addActionListener(listenerErregistratuBotoia(this.controladorPanelErregistratu));
		this.btnAtzera.addActionListener(listenerAtzeraBotoia(this.controladorPanelErregistratu));
	}

	// *****************************************************************************************************************************************************************************************************

	private ActionListener listenerErregistratuBotoia(ControladorPanelErregistratu controladorPanelErregistratu) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) { 
				String Izena = TF_Izena.getText();
				String Abizena = TF_Abizena.getText();
				String Pasahitza = TF_Pasahitza.getText();
				String DNI = TF_DNI.getText();
				String NIF = TF_NIF.getText();
				try {
					controladorPanelErregistratu.sakatuErregistratuBotoia(DNI, Izena, Abizena, Pasahitza, NIF);
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}			
				controladorPanelErregistratu.sakatuErregistratuBotoia();
			}
		};
	} 

	// *****************************************************************************************************************************************************************************************************

	private ActionListener listenerSarratuBotoia(ControladorPanelErregistratu controladorPanelErregistratu) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorPanelErregistratu.sakatuSarratuBotoia();
			}
		};
	} 
	
	// *****************************************************************************************************************************************************************************************************

		private ActionListener listenerAtzeraBotoia(ControladorPanelErregistratu controladorPanelErregistratu) {
			return new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					controladorPanelErregistratu.sakatuAtzeraBotoia();
				}
			};
		} 
}
