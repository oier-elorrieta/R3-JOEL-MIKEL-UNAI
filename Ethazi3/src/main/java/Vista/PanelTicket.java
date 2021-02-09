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

	private JTextField tf_Titulua;
	private JTextField tf_Fecha;
	private JTextField tf_Lokala;
	private JTextField tf_TransferentziaZenbakia;
	private JTextField tf_Totala;

	private JLabel lb_Data;
	private JLabel lb_Lokala;
	private JLabel lb_TransferentziaZenbakia;
	private JLabel lb_Totala;
	private JLabel argazkiak;

	private JButton btnAtzera;
	private JButton btnAurrera;
	private JButton btnSegi;

	private JComboBox<String> cb_Produktoak = new JComboBox<String>();
	private JSpinner nºunidades; 
	private String[] produktuak;

	private int TransferentziaZenbakia;

	// *****************************************************************************************************************************************************************************************************

	public PanelTicket(ControladorPanelTicket controladorPanelTicket) {
		this.controladorPanelTicket = controladorPanelTicket;

		setBackground(Color.LIGHT_GRAY);
		setLayout(null);

		// _______________________________________________________________________________________________________________________________________________________________________________

		tf_Titulua = new JTextField();
		tf_Titulua.setFont(new Font("Tahoma", Font.BOLD, 12));
		tf_Titulua.setForeground(new Color(255, 255, 255));
		tf_Titulua.setBounds(10, 5, 432, 20);
		tf_Titulua.setBackground(new Color(0, 0, 255));
		tf_Titulua.setHorizontalAlignment(SwingConstants.LEFT);
		tf_Titulua.setText(" \u2666\uFE0F Ticket Kalkuloak \u2666\uFE0F");
		tf_Titulua.setColumns(10);
		tf_Titulua.setEditable(false);
		add(tf_Titulua);

		tf_Fecha = new JTextField();
		tf_Fecha.setHorizontalAlignment(SwingConstants.CENTER);
		tf_Fecha.setBounds(367, 36, 75, 20);
		tf_Fecha.setColumns(10);
		tf_Fecha.setEditable(false);
		add(tf_Fecha);

		tf_Lokala = new JTextField(controladorPanelTicket.konprobatuLokalarenIzena());
		tf_Lokala.setFont(new Font("Tahoma", Font.ITALIC, 9));
		tf_Lokala.setHorizontalAlignment(SwingConstants.CENTER);
		tf_Lokala.setBounds(61, 36, 75, 20);
		tf_Lokala.setColumns(10);
		tf_Lokala.setEditable(false);
		add(tf_Lokala);

		TransferentziaZenbakia = controladorPanelTicket.TransferentziaZenbakia();

		tf_TransferentziaZenbakia = new JTextField(String.valueOf(TransferentziaZenbakia));
		tf_TransferentziaZenbakia.setHorizontalAlignment(SwingConstants.CENTER);
		tf_TransferentziaZenbakia.setBounds(226, 36, 75, 20);
		tf_TransferentziaZenbakia.setColumns(10);
		tf_TransferentziaZenbakia.setEditable(false);
		add(tf_TransferentziaZenbakia);

		tf_Totala = new JTextField("0.0");
		tf_Totala.setHorizontalAlignment(SwingConstants.CENTER);
		tf_Totala.setBounds(61, 267, 183, 20);
		tf_Totala.setColumns(10);
		tf_Totala.setEditable(false);
		add(tf_Totala);

		// _______________________________________________________________________________________________________________________________________________________________________________

		lb_Data = new JLabel("Data:");
		lb_Data.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lb_Data.setHorizontalAlignment(SwingConstants.CENTER);
		lb_Data.setBounds(328, 39, 46, 14);
		add(lb_Data);

		lb_Lokala = new JLabel("Lokala:");
		lb_Lokala.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lb_Lokala.setHorizontalAlignment(SwingConstants.CENTER);
		lb_Lokala.setBounds(20, 39, 46, 14);
		add(lb_Lokala);

		lb_TransferentziaZenbakia = new JLabel("Trans Zbk:");
		lb_TransferentziaZenbakia.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lb_TransferentziaZenbakia.setHorizontalAlignment(SwingConstants.CENTER);
		lb_TransferentziaZenbakia.setBounds(170, 39, 57, 14);
		add(lb_TransferentziaZenbakia);

		lb_Totala = new JLabel("Totala:");
		lb_Totala.setHorizontalAlignment(SwingConstants.CENTER);
		lb_Totala.setBounds(20, 270, 46, 14);
		add(lb_Totala);

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
		btnSegi.setEnabled(false);
		add(btnSegi);

		// _______________________________________________________________________________________________________________________________________________________________________________

		final String numbers[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };
		SpinnerModel model1 = new SpinnerListModel(numbers);

		nºunidades = new JSpinner(model1);
		nºunidades.setBounds(254, 233, 120, 20);
		add(nºunidades);

		cb_Produktoak.setBounds(30, 68, 214, 20);
		add(cb_Produktoak);

		produktuak = controladorPanelTicket.ComboBoxaSakatu();
		for(int i=0;i < produktuak.length;i++) {
			cb_Produktoak.addItem(produktuak[i]);
		}
		cb_Produktoak.setSelectedItem(null);

		initializeEvents();
	}

	// *****************************************************************************************************************************************************************************************************

	private void initializeEvents() {
		this.btnAurrera.addActionListener(listenerLaburpeneraBotoia(this.controladorPanelTicket));
		this.btnAtzera.addActionListener(listenerAtzeraBotoia(this.controladorPanelTicket));
		this.cb_Produktoak.addActionListener(listenerComboBox(this.controladorPanelTicket));
		this.btnSegi.addActionListener(listenerSegiBotoia());
	}

	// *****************************************************************************************************************************************************************************************************

	private ActionListener listenerLaburpeneraBotoia(ControladorPanelTicket controladorPanelTicket) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					controladorPanelTicket.sakatuLaburpeneraBotoia();
					controladorPanelTicket.gordeTicket();
					controladorPanelTicket.gehituTransferentziaZenbakia();				
			}
		};
	}

	// *****************************************************************************************************************************************************************************************************

	private ActionListener listenerAtzeraBotoia(ControladorPanelTicket controladorPanelTicket) {
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
				String aukera = (String) cb_Produktoak.getSelectedItem();
				int kantitatea = Integer.parseInt(nºunidades.getValue().toString());
				if (kantitatea != 0) { 
					controladorPanelTicket.sartu(aukera, kantitatea);
				}
				nºunidades.setValue("0");
				btnSegi.setEnabled(false);
				cb_Produktoak.setSelectedItem(null);
				argazkiak.setIcon(new ImageIcon("argazkiak/blanco.jpg"));
				String diruTotala = String.valueOf(controladorPanelTicket.diruTotala());
				tf_Totala.setText(diruTotala);
			}
		};
	}

	// *****************************************************************************************************************************************************************************************************

	private ActionListener listenerComboBox(ControladorPanelTicket controladorPanelTicket) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String aukera = (String) cb_Produktoak.getSelectedItem();
				ImageIcon argazkia = (ImageIcon) controladorPanelTicket.argazkiaAukeratu(aukera);
				if (cb_Produktoak.getSelectedItem() != null) { 
					btnSegi.setEnabled(true);	
				}
				argazkiak.setIcon(argazkia);
			}
		};
	}
}
