package Vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;  
import javax.swing.JPanel;
import Controlador.ControladorPanelHornikuntza;
import javax.swing.JSpinner;
import javax.swing.JComboBox;

@SuppressWarnings("serial")
public class PanelHornikuntza extends JPanel {

	private ControladorPanelHornikuntza controladorPanelHornikuntza; 

	private JButton btnSarratu;
	private JButton btnAtzera;
	private JButton btnSegi;
	
	private JComboBox<String> cb_Produktoak = new JComboBox<String>();
	private JSpinner spinner;
	private String[] produktuak;
	
	// *****************************************************************************************************************************************************************************************************

	public PanelHornikuntza(ControladorPanelHornikuntza controladorPanelHornikuntza) {

		this.controladorPanelHornikuntza = controladorPanelHornikuntza; 

		setBackground(Color.LIGHT_GRAY);
		setBounds(0, 0, 450, 300);
		setLayout(null);

		// _______________________________________________________________________________________________________________________________________________________________________________

		btnSarratu = new JButton("SARRATU ");
		btnSarratu.setBounds(250, 268, 190, 21);
		btnSarratu.setFont(new Font("Tahoma", Font.ITALIC, 11));
		add(btnSarratu);

		btnAtzera = new JButton("Atzera");
		btnAtzera.setBounds(10, 268, 190, 21);
		btnAtzera.setFont(new Font("Tahoma", Font.ITALIC, 11));
		add(btnAtzera);
		
		cb_Produktoak.setBounds(10, 25, 430, 20);
		add(cb_Produktoak);

		produktuak = controladorPanelHornikuntza.ComboBoxaSakatu();
		for (int i = 0; i < produktuak.length; i++) {
			cb_Produktoak.addItem(produktuak[i]);
		}
		cb_Produktoak.setSelectedItem(null);
		
		btnSegi = new JButton("\u2714\uFE0F");
		btnSegi.setBounds(351, 234, 89, 23);
		add(btnSegi);
		
		spinner = new JSpinner();
		spinner.setBounds(10, 234, 331, 23);
		add(spinner);

		initializeEvents();
	}

	// *****************************************************************************************************************************************************************************************************

	private void initializeEvents() {
		this.btnSarratu.addActionListener(listenerSarratuBotoia(this.controladorPanelHornikuntza));
		this.btnAtzera.addActionListener(listenerAtzeraBotoia(this.controladorPanelHornikuntza));
	}

	// *****************************************************************************************************************************************************************************************************

	private ActionListener listenerSarratuBotoia(ControladorPanelHornikuntza controladorPanelHornikuntza) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorPanelHornikuntza.sakatuAtzeraBotoia();
			}
		};
	} 
	
	// *****************************************************************************************************************************************************************************************************

		private ActionListener listenerAtzeraBotoia(ControladorPanelHornikuntza controladorPanelHornikuntza) {
			return new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (controladorPanelHornikuntza.konprobatuLokala().equals("Restaurante")) {
						controladorPanelHornikuntza.sakatuPanelJatetxeBotoia();
					} else if (controladorPanelHornikuntza.konprobatuLokala().equals("Bar")) {
						controladorPanelHornikuntza.sakatuPanelTabernaBotoia();
					} else {
						controladorPanelHornikuntza.sakatuPanelKafetegiaBotoia();
					}
				}
			};
		} 
}
