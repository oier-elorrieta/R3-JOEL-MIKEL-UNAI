package Vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;  
import javax.swing.JPanel;

import Controlador.ControladorPanelErregistratu;
import javax.swing.JLabel;
import javax.swing.JTextField;
 
@SuppressWarnings("serial")
public class PanelErregistratu extends JPanel {

	private ControladorPanelErregistratu controladorPanelMenu;
	
	private JButton btnSarratu;
	private JButton btnErregistratu;

	private JLabel LB_Usuarioa;
	private JLabel LB_Pasahitza;
	
	private JTextField TF_Izena;
	private JTextField TF_Abizena;
	private JTextField TF_Usuarioa;
	private JTextField TF_Pasahitza;
	
	private JLabel LB_Pasahitza_1;
	private JLabel LB_Izena;

	// *****************************************************************************************************************************************************************************************************
	
	public PanelErregistratu(ControladorPanelErregistratu controladorPanelErregistratu) {

		this.controladorPanelMenu = controladorPanelErregistratu;
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);
		setBounds(0, 0, 450, 300);

		// _______________________________________________________________________________________________________________________________________________________________________________
		
		btnSarratu = new JButton("SARRATU ");
		btnSarratu.setFont(new Font("Tahoma", Font.ITALIC, 11));
		btnSarratu.setBounds(350, 259, 90, 30);
		add(btnSarratu);
		
		btnErregistratu = new JButton("Erregistratu");
		btnErregistratu.setBounds(160, 264, 115, 21);
		add(btnErregistratu);
		
		// _______________________________________________________________________________________________________________________________________________________________________________
		
		TF_Izena = new JTextField();
		TF_Izena.setBounds(135, 60, 170, 19);
		add(TF_Izena);
		TF_Izena.setColumns(10);
		
		TF_Abizena = new JTextField();
		TF_Abizena.setColumns(10);
		TF_Abizena.setBounds(135, 120, 170, 19);
		add(TF_Abizena);
		
		TF_Usuarioa = new JTextField();
		TF_Usuarioa.setColumns(10);
		TF_Usuarioa.setBounds(135, 180, 170, 19);
		add(TF_Usuarioa);
		
		TF_Pasahitza = new JTextField();
		TF_Pasahitza.setColumns(10);
		TF_Pasahitza.setBounds(135, 235, 170, 19);
		add(TF_Pasahitza);
		
		// _______________________________________________________________________________________________________________________________________________________________________________
		
		LB_Usuarioa = new JLabel("Usuarioa:");
		LB_Usuarioa.setBounds(135, 157, 170, 13);
		add(LB_Usuarioa);
		
		LB_Pasahitza = new JLabel("Pasahitza:");
		LB_Pasahitza.setBounds(135, 212, 170, 13);
		add(LB_Pasahitza);
		
		LB_Pasahitza_1 = new JLabel("Abizena:");
		LB_Pasahitza_1.setBounds(135, 97, 170, 13);
		add(LB_Pasahitza_1);
		
		LB_Izena = new JLabel("Izena:");
		LB_Izena.setBounds(135, 37, 170, 13);
		add(LB_Izena);

		initializeEvents();
	}
	
	// *****************************************************************************************************************************************************************************************************
	
	private void initializeEvents() {
		this.btnSarratu.addActionListener(listenerSarratuBotoia(this.controladorPanelMenu));
		this.btnErregistratu.addActionListener(listenerErregistratuBotoia(this.controladorPanelMenu));
	}
	
	// *****************************************************************************************************************************************************************************************************
	
	private ActionListener listenerErregistratuBotoia(ControladorPanelErregistratu controladorPanelMenu2) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorPanelMenu2.sakatuErregistratuBotoia();
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
