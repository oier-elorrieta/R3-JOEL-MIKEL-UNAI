package Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JLabel;
import Controlador.ControladorPanelFaktura;

import javax.swing.JSpinner;
import javax.swing.JComboBox;

@SuppressWarnings("serial")
public class PanelFaktura extends JPanel {

	private ControladorPanelFaktura controladorPanelFaktura;
	
	Calendar fecha = new GregorianCalendar();

	int año = fecha.get(Calendar.YEAR);
	int mes = fecha.get(Calendar.MONTH);
	int dia = fecha.get(Calendar.DAY_OF_MONTH);
	private JTextField TF_Titulua;
	private JTextField TF_Fecha;
	private JLabel LB_Data;
	private JLabel LB_Lokala;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel LB_TransferentziaZenbakia;
	private JLabel LB_Totala;
	private JTextField textField_2;
	private JButton btnAtzera;
	private JButton btnAurrera;
	private JComboBox<String> CB_Produktoak = new JComboBox<String>();
	private JButton btnSegi;
	private JSpinner NºUnidades;
	private JPanel panel;

	public PanelFaktura(ControladorPanelFaktura controladorPanelFaktura)
	{
		this.controladorPanelFaktura = controladorPanelFaktura;

		setBackground(Color.LIGHT_GRAY);
		setLayout(null);
		

		TF_Titulua = new JTextField();
		TF_Titulua.setFont(new Font("Tahoma", Font.BOLD, 12));
		TF_Titulua.setForeground(new Color(255, 255, 255));
		TF_Titulua.setBounds(10, 5, 432, 20);
		TF_Titulua.setBackground(new Color(0, 0, 255));
		TF_Titulua.setHorizontalAlignment(SwingConstants.LEFT);
		TF_Titulua.setText(" \u2666\uFE0F Faktura Kalkuloak \u2666\uFE0F");
		add(TF_Titulua);
		TF_Titulua.setColumns(10);

		btnAtzera = new JButton(" Atzera");
		btnAtzera.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnAtzera.setBounds(353, 266, 92, 23);
		add(btnAtzera);

		btnAurrera = new JButton(" Aurrera");
		btnAurrera.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnAurrera.setBounds(254, 266, 92, 23);
		add(btnAurrera);

		TF_Fecha = new JTextField(dia + "/" + (mes+1) + "/" + año);
		TF_Fecha.setHorizontalAlignment(SwingConstants.CENTER);
		TF_Fecha.setBounds(367, 36, 75, 20);
		add(TF_Fecha);
		TF_Fecha.setColumns(10);

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

		textField = new JTextField("x");
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setColumns(10);
		textField.setBounds(61, 36, 75, 20);
		add(textField);

		textField_1 = new JTextField("x");
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setColumns(10);
		textField_1.setBounds(226, 36, 75, 20);
		add(textField_1);

		LB_TransferentziaZenbakia = new JLabel("Trans Zbk:");
		LB_TransferentziaZenbakia.setFont(new Font("Tahoma", Font.PLAIN, 9));
		LB_TransferentziaZenbakia.setHorizontalAlignment(SwingConstants.CENTER);
		LB_TransferentziaZenbakia.setBounds(170, 39, 57, 14);
		add(LB_TransferentziaZenbakia);

		LB_Totala = new JLabel("Totala:");
		LB_Totala.setHorizontalAlignment(SwingConstants.CENTER);
		LB_Totala.setBounds(20, 270, 46, 14);
		add(LB_Totala);

		textField_2 = new JTextField("x");
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setColumns(10);
		textField_2.setBounds(61, 267, 183, 20);
		add(textField_2);
		CB_Produktoak.setBounds(30, 68, 214, 20);
		add(CB_Produktoak);
		
		btnSegi = new JButton("\u2714\uFE0F");
		btnSegi.setHorizontalAlignment(SwingConstants.TRAILING);
		btnSegi.setBounds(388, 232, 57, 23);
		add(btnSegi);
		
		NºUnidades = new JSpinner();
		NºUnidades.setBounds(254, 233, 120, 20);
		add(NºUnidades);
		
		panel = new JPanel();
		panel.setBounds(254, 67, 188, 154);
		add(panel);
		
		JLabel LB_Izena = new JLabel("Izena:");
		LB_Izena.setHorizontalAlignment(SwingConstants.CENTER);
		LB_Izena.setFont(new Font("Tahoma", Font.PLAIN, 9));
		LB_Izena.setBounds(20, 176, 46, 14);
		add(LB_Izena);
		
		JLabel LB_Abizena = new JLabel("Abizena");
		LB_Abizena.setHorizontalAlignment(SwingConstants.CENTER);
		LB_Abizena.setFont(new Font("Tahoma", Font.PLAIN, 9));
		LB_Abizena.setBounds(20, 207, 46, 14);
		add(LB_Abizena);
		
		JLabel LB_NIF = new JLabel("NIF");
		LB_NIF.setHorizontalAlignment(SwingConstants.CENTER);
		LB_NIF.setFont(new Font("Tahoma", Font.PLAIN, 9));
		LB_NIF.setBounds(20, 236, 46, 14);
		add(LB_NIF);
		
		JTextField TF_Izena = new JTextField("x");
		TF_Izena.setHorizontalAlignment(SwingConstants.CENTER);
		TF_Izena.setColumns(10);
		TF_Izena.setBounds(61, 173, 183, 20);
		add(TF_Izena);
		
		JTextField TF_Abizena = new JTextField("x");
		TF_Abizena.setHorizontalAlignment(SwingConstants.CENTER);
		TF_Abizena.setColumns(10);
		TF_Abizena.setBounds(61, 204, 183, 20);
		add(TF_Abizena);
		
		JTextField TF_NIF = new JTextField("x");
		TF_NIF.setHorizontalAlignment(SwingConstants.CENTER);
		TF_NIF.setColumns(10);
		TF_NIF.setBounds(61, 233, 183, 20);
		add(TF_NIF);
		
		String[] produktuak = controladorPanelFaktura.accionadoComboBox();
		for(int i=0;i < produktuak.length;i++) {
			CB_Produktoak.addItem(produktuak[i]);
		}

		initializeEvents();
	}

	private void initializeEvents() {
		this.btnAurrera.addActionListener(listenerBotonLaburpenera(this.controladorPanelFaktura)); 
		this.btnAtzera.addActionListener(listenerBotonAtzera(this.controladorPanelFaktura)); 
	}

	private ActionListener listenerBotonLaburpenera(ControladorPanelFaktura controladorPanelFaktura) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorPanelFaktura.accionadoBottonLaburpenera();
			}
		};
	}
	private ActionListener listenerBotonAtzera(ControladorPanelFaktura controladorPanelFaktura) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorPanelFaktura.accionadoBottonAtzera();
			}
		};
	}
}

