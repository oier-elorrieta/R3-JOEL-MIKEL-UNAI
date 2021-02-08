package Vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerModel;
import javax.swing.SwingConstants;

import Controlador.ControladorPanelTicket;

@SuppressWarnings("serial")
public class PanelTicket extends JPanel {

	private ControladorPanelTicket controladorPanelTicket;

	private JTextField TF_Titulua;
	private JTextField TF_Fecha;
	private JTextField TF_Lokala;
	private JTextField TF_TransferentziaZenbakia;
	private JTextField TF_Totala;

	private JLabel LB_Data;
	private JLabel LB_Lokala;
	private JLabel LB_TransferentziaZenbakia;
	private JLabel LB_Totala;
	private JLabel argazkiak;

	private JButton btnAtzera;
	private JButton btnAurrera;
	private JButton btnSegi;

	private JComboBox<String> CB_Produktoak = new JComboBox<String>();
	private JSpinner NºUnidades; 
	private String[] produktuak;

	private int TransferentziaZenbakia;
	
	// *****************************************************************************************************************************************************************************************************

	public PanelTicket(ControladorPanelTicket controladorPanelTicket) {
		this.controladorPanelTicket = controladorPanelTicket;

		setBackground(Color.LIGHT_GRAY);
		setLayout(null);

		// _______________________________________________________________________________________________________________________________________________________________________________

		TF_Titulua = new JTextField();
		TF_Titulua.setFont(new Font("Tahoma", Font.BOLD, 12));
		TF_Titulua.setForeground(new Color(255, 255, 255));
		TF_Titulua.setBounds(10, 5, 432, 20);
		TF_Titulua.setBackground(new Color(0, 0, 255));
		TF_Titulua.setHorizontalAlignment(SwingConstants.LEFT);
		TF_Titulua.setText(" \u2666\uFE0F Ticket Kalkuloak \u2666\uFE0F");
		TF_Titulua.setColumns(10);
		TF_Titulua.setEditable(false);
		add(TF_Titulua);

		TF_Fecha = new JTextField();
		TF_Fecha.setHorizontalAlignment(SwingConstants.CENTER);
		TF_Fecha.setBounds(367, 36, 75, 20);
		TF_Fecha.setColumns(10);
		TF_Fecha.setEditable(false);
		add(TF_Fecha);

		TF_Lokala = new JTextField(controladorPanelTicket.komprobatuLokalarenIzena());
		TF_Lokala.setFont(new Font("Tahoma", Font.ITALIC, 9));
		TF_Lokala.setHorizontalAlignment(SwingConstants.CENTER);
		TF_Lokala.setBounds(61, 36, 75, 20);
		TF_Lokala.setColumns(10);
		TF_Lokala.setEditable(false);
		add(TF_Lokala);

		TransferentziaZenbakia = controladorPanelTicket.gehituTransferentziaZenbakia();
		
		TF_TransferentziaZenbakia = new JTextField(String.valueOf(TransferentziaZenbakia));
		TF_TransferentziaZenbakia.setHorizontalAlignment(SwingConstants.CENTER);
		TF_TransferentziaZenbakia.setBounds(226, 36, 75, 20);
		TF_TransferentziaZenbakia.setColumns(10);
		TF_TransferentziaZenbakia.setEditable(false);
		add(TF_TransferentziaZenbakia);

		TF_Totala = new JTextField("x");
		TF_Totala.setHorizontalAlignment(SwingConstants.CENTER);
		TF_Totala.setBounds(61, 267, 183, 20);
		TF_Totala.setColumns(10);
		TF_Totala.setEditable(false);
		add(TF_Totala);

		// _______________________________________________________________________________________________________________________________________________________________________________

		LB_Data = new JLabel("Data:");
		LB_Data.setFont(new Font("Tahoma", Font.PLAIN, 9));
		LB_Data.setHorizontalAlignment(SwingConstants.CENTER);
		LB_Data.setBounds(328, 39, 46, 14);
		add(LB_Data);

		LB_Lokala = new JLabel("Lokala:");
		LB_Lokala.setFont(new Font("Tahoma", Font.PLAIN, 9));
		LB_Lokala.setHorizontalAlignment(SwingConstants.CENTER);
		LB_Lokala.setBounds(20, 39, 46, 14);
		add(LB_Lokala);

		LB_TransferentziaZenbakia = new JLabel("Trans Zbk:");
		LB_TransferentziaZenbakia.setFont(new Font("Tahoma", Font.PLAIN, 9));
		LB_TransferentziaZenbakia.setHorizontalAlignment(SwingConstants.CENTER);
		LB_TransferentziaZenbakia.setBounds(170, 39, 57, 14);
		add(LB_TransferentziaZenbakia);

		LB_Totala = new JLabel("Totala:");
		LB_Totala.setHorizontalAlignment(SwingConstants.CENTER);
		LB_Totala.setBounds(20, 270, 46, 14);
		add(LB_Totala);

		argazkiak = new JLabel();
		argazkiak.setBounds(254, 67, 188, 154);
		argazkiak.setIcon(new ImageIcon("argazkiak/blanco.jpg"));
		add(argazkiak);

		// _______________________________________________________________________________________________________________________________________________________________________________

		btnAtzera = new JButton(" Atzera");
		btnAtzera.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnAtzera.setBounds(353, 266, 92, 23);
		add(btnAtzera);

		btnAurrera = new JButton(" Aurrera");
		btnAurrera.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnAurrera.setBounds(254, 266, 92, 23);
		add(btnAurrera);

		btnSegi = new JButton("\u2714\uFE0F");
		btnSegi.setHorizontalAlignment(SwingConstants.TRAILING);
		btnSegi.setBounds(388, 232, 57, 23);
		add(btnSegi);

		// _______________________________________________________________________________________________________________________________________________________________________________

		final String numbers[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };
		SpinnerModel model1 = new SpinnerListModel(numbers);

		NºUnidades = new JSpinner(model1);
		NºUnidades.setBounds(254, 233, 120, 20);
		add(NºUnidades);

		CB_Produktoak.setBounds(30, 68, 214, 20);
		add(CB_Produktoak);

		produktuak = controladorPanelTicket.ComboBoxaSakatu();
		for(int i=0;i < produktuak.length;i++) {
			CB_Produktoak.addItem(produktuak[i]);
		}
		CB_Produktoak.setSelectedItem(null);

		initializeEvents();
	}

	// *****************************************************************************************************************************************************************************************************

	private void initializeEvents() {
		this.btnAurrera.addActionListener(listenerLaburpeneraBotoia(this.controladorPanelTicket));
		this.btnAtzera.addActionListener(listenerAtzeraBotoia(this.controladorPanelTicket));
		this.CB_Produktoak.addActionListener(listenerComboBox(this.controladorPanelTicket));
		this.btnSegi.addActionListener(listenerSegiBotoia());
	}

	// *****************************************************************************************************************************************************************************************************

	private ActionListener listenerLaburpeneraBotoia(ControladorPanelTicket ControladorPanelTicket) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ControladorPanelTicket.sakatuLaburpeneraBotoia();
				controladorPanelTicket.gordeTicket();
			}
		};
	}

	// *****************************************************************************************************************************************************************************************************

	private ActionListener listenerAtzeraBotoia(ControladorPanelTicket ControladorPanelTicket) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(controladorPanelTicket.konprobatuLokala().equals("Restaurante")) {
					controladorPanelTicket.sakatuPanelJatetxeBotoia();
				}else if(controladorPanelTicket.konprobatuLokala().equals("Bar")) {
					controladorPanelTicket.sakatuPanelTabernaBotoia();
				}else {
					controladorPanelTicket.sakatuPanelKafetegiaBotoia();
				}
			}
		};
	}

	// *****************************************************************************************************************************************************************************************************

	private ActionListener listenerSegiBotoia() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String aukera = (String) CB_Produktoak.getSelectedItem();
				int kantitatea = Integer.parseInt(NºUnidades.getValue().toString());
				if (kantitatea != 0) { 
					controladorPanelTicket.sartu(aukera, kantitatea);
				}
				NºUnidades.setValue("0");
				argazkiak.setIcon(new ImageIcon("argazkiak/blanco.jpg"));
				String diruTotala = String.valueOf(controladorPanelTicket.diruTotala());
				TF_Totala.setText(diruTotala);
			}
		};
	}

	// *****************************************************************************************************************************************************************************************************

	private ActionListener listenerComboBox(ControladorPanelTicket controladorPanelTicket) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String aukera = (String) CB_Produktoak.getSelectedItem();
				ImageIcon argazkia = (ImageIcon) controladorPanelTicket.argazkiaAukeratu(aukera);
				argazkiak.setIcon(argazkia);
			}
		};
	}
}
