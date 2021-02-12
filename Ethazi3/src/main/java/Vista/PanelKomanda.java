package Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerModel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import Controlador.ControladorPanelKomanda; 

import javax.swing.JSpinner;
import javax.swing.JComboBox;

@SuppressWarnings("serial")
public class PanelKomanda extends JPanel {

	private ControladorPanelKomanda controladorPanelKomanda;

	private JTextField tf_Titulua;
	private JTextField tf_Fecha;
	private JTextField tf_Lokala;
	private JTextField tf_TransferentziaZenbakia;
	private JTextField tf_Totala;
	private JTextField tf_Izena;
	private JTextField tf_Abizena;
	private JTextField tf_NIF;

	private JLabel lb_Data;
	private JLabel lb_Lokala;
	private JLabel lb_TransferentziaZenbakia;
	private JLabel lb_Totala;
	private JLabel lb_Izena;
	private JLabel lb_Abizena;
	private JLabel lb_NIF;
	private JLabel argazkiak;

	private JButton btnAtzera;
	private JButton btnAurrera;
	private JButton btnSegi;

	private JComboBox<String> cb_Produktoak = new JComboBox<String>();
	private JSpinner n�unidades;
	private String[] produktuak;

	private int TransferentziaZenbakia;
	private int a�o;
	private int mes;
	private int dia;


	// *****************************************************************************************************************************************************************************************************

	public PanelKomanda(ControladorPanelKomanda controladorPanelKomanda) {
		this.controladorPanelKomanda = controladorPanelKomanda;

		setBackground(Color.LIGHT_GRAY);
		setLayout(null);

		Calendar fecha = new GregorianCalendar();

		a�o = fecha.get(Calendar.YEAR);
		mes = fecha.get(Calendar.MONTH);
		dia = fecha.get(Calendar.DAY_OF_MONTH);

		// _______________________________________________________________________________________________________________________________________________________________________________

		tf_Titulua = new JTextField();
		tf_Titulua.setFont(new Font("Tahoma", Font.BOLD, 12));
		tf_Titulua.setForeground(new Color(255, 255, 255));
		tf_Titulua.setBounds(10, 5, 432, 20);
		tf_Titulua.setBackground(new Color(0, 0, 255));
		tf_Titulua.setHorizontalAlignment(SwingConstants.LEFT);
		tf_Titulua.setText(" \u2666\uFE0F KomandaKalkuloak \u2666\uFE0F");
		tf_Titulua.setColumns(10);
		tf_Titulua.setEditable(false);
		add(tf_Titulua);

		tf_Fecha = new JTextField(dia + "/" + (mes + 1) + "/" + a�o); 
		tf_Fecha.setHorizontalAlignment(SwingConstants.CENTER);
		tf_Fecha.setBounds(367, 36, 75, 20);
		tf_Fecha.setColumns(10);
		tf_Fecha.setEditable(false);
		add(tf_Fecha);

		tf_Lokala = new JTextField();
		tf_Lokala.setFont(new Font("Tahoma", Font.ITALIC, 9));
		tf_Lokala.setHorizontalAlignment(SwingConstants.CENTER);
		tf_Lokala.setBounds(61, 36, 75, 20);
		tf_Lokala.setColumns(10);
		tf_Lokala.setEditable(false);
		add(tf_Lokala);

		try {
			TransferentziaZenbakia = controladorPanelKomanda.jasoTransakzioZbk();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

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

		tf_Izena = new JTextField();
		tf_Izena.setHorizontalAlignment(SwingConstants.CENTER);
		tf_Izena.setBounds(61, 173, 183, 20);
		tf_Izena.setColumns(10);
		add(tf_Izena);

		tf_Abizena = new JTextField();
		tf_Abizena.setHorizontalAlignment(SwingConstants.CENTER);
		tf_Abizena.setBounds(61, 204, 183, 20);
		tf_Abizena.setColumns(10);
		add(tf_Abizena);

		tf_NIF = new JTextField();
		tf_NIF.setFont(new Font("Tahoma", Font.ITALIC, 11));
		tf_NIF.setHorizontalAlignment(SwingConstants.CENTER);
		tf_NIF.setBounds(61, 233, 183, 20);
		tf_NIF.setColumns(10);
		tf_NIF.setEditable(false);
		add(tf_NIF);

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

		lb_Izena = new JLabel("Izena:");
		lb_Izena.setHorizontalAlignment(SwingConstants.CENTER);
		lb_Izena.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lb_Izena.setBounds(20, 176, 46, 14);
		add(lb_Izena);

		lb_Abizena = new JLabel("Abizena");
		lb_Abizena.setHorizontalAlignment(SwingConstants.CENTER);
		lb_Abizena.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lb_Abizena.setBounds(20, 207, 46, 14);
		add(lb_Abizena);

		lb_NIF = new JLabel("NIF");
		lb_NIF.setHorizontalAlignment(SwingConstants.CENTER);
		lb_NIF.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lb_NIF.setBounds(20, 236, 46, 14);
		add(lb_NIF);

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

		n�unidades = new JSpinner();
		final String numbers[] = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };
		SpinnerModel model1 = new SpinnerListModel(numbers);

		n�unidades = new JSpinner(model1);
		n�unidades.setBounds(254, 233, 120, 20);
		add(n�unidades);

		cb_Produktoak.setBounds(30, 68, 214, 20);
		add(cb_Produktoak);

		produktuak = controladorPanelKomanda.ComboBoxaSakatu();
		for (int i = 0; i < produktuak.length; i++) {
			cb_Produktoak.addItem(produktuak[i]);
		}
		cb_Produktoak.setSelectedItem(null);

		initializeEvents();
	}

	// *****************************************************************************************************************************************************************************************************

	private void initializeEvents() {
		//this.btnAurrera.addActionListener(listenerLaburpeneraBotoia(this.controladorPanelKomanda));
		this.btnAtzera.addActionListener(listenerAtzeraBotoia(this.controladorPanelKomanda));
		this.cb_Produktoak.addActionListener(listenerComboBox(this.controladorPanelKomanda));
		this.btnSegi.addActionListener(listenerSegiBotoia(this.controladorPanelKomanda));
	}

	// *****************************************************************************************************************************************************************************************************

	/*private ActionListener listenerLaburpeneraBotoia(ControladorPanelKomanda controladorPanelKomanda) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorPanelKomanda.sakatuLaburpeneraBotoia();
				try {
					controladorPanelKomanda.sartuKomanda(tf_Izena.getText(),tf_Abizena.getText(), a�o, mes, dia);
				} catch (ClassNotFoundException | SQLException e) { 
					e.printStackTrace();
				} 
			}
		};
	}*/

	// *****************************************************************************************************************************************************************************************************

	private ActionListener listenerAtzeraBotoia(ControladorPanelKomanda controladorPanelKomanda) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (controladorPanelKomanda.konprobatuLokala().equals("Restaurante")) {
					controladorPanelKomanda.sakatuPanelJatetxeBotoia();
				} else if (controladorPanelKomanda.konprobatuLokala().equals("Bar")) {
					controladorPanelKomanda.sakatuPanelTabernaBotoia();
				} else {
					controladorPanelKomanda.sakatuPanelKafetegiaBotoia();
				}
			}
		};
	}

	// *****************************************************************************************************************************************************************************************************

	private ActionListener listenerSegiBotoia(ControladorPanelKomanda controladorPanelKomanda) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String aukera = (String) cb_Produktoak.getSelectedItem();
				int kantitatea = Integer.parseInt(n�unidades.getValue().toString());
				if (kantitatea != 0) {
					controladorPanelKomanda.sartu(aukera, kantitatea);
				}
				n�unidades.setValue("0");
				btnSegi.setEnabled(false);
				cb_Produktoak.setSelectedItem(null);
				argazkiak.setIcon(new ImageIcon("argazkiak/blanco.jpg"));

				String diruTotala = String.valueOf(controladorPanelKomanda.diruTotala());
				tf_Totala.setText(diruTotala);
			}
		};
	}

	// *****************************************************************************************************************************************************************************************************

	private ActionListener listenerComboBox(ControladorPanelKomanda controladorPanelKomanda) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String aukera = (String) cb_Produktoak.getSelectedItem();
				ImageIcon argazkia = (ImageIcon) controladorPanelKomanda.argazkiaAukeratu(aukera);
				if (cb_Produktoak.getSelectedItem() != null) { 
					btnSegi.setEnabled(true);	
				}
				argazkiak.setIcon(argazkia);
			}
		};
	}
}