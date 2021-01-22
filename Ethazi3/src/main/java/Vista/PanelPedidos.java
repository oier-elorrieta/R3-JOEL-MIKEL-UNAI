package Vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import Controlador.ControladorPanelPedidos;
import javax.swing.JRadioButton;

@SuppressWarnings("serial")
public class PanelPedidos extends JPanel {

	private ControladorPanelPedidos controladorPanelPedidos;

	Calendar fecha = new GregorianCalendar();

	int a�o = fecha.get(Calendar.YEAR);
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
	private JSpinner N�Unidades;
	private JPanel panel;
	private JTextField TF_Helbide;

	public PanelPedidos(ControladorPanelPedidos controladorPanelPedidos)
	{
		this.controladorPanelPedidos = controladorPanelPedidos;

		setBackground(Color.LIGHT_GRAY);
		setLayout(null);

		TF_Titulua = new JTextField();
		TF_Titulua.setFont(new Font("Tahoma", Font.BOLD, 12));
		TF_Titulua.setForeground(new Color(255, 255, 255));
		TF_Titulua.setBounds(10, 5, 432, 20);
		TF_Titulua.setBackground(new Color(0, 0, 255));
		TF_Titulua.setHorizontalAlignment(SwingConstants.LEFT);
		TF_Titulua.setText(" \u2666\uFE0F Eskaera Kalkuloak \u2666\uFE0F");
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

		TF_Fecha = new JTextField(dia + "/" + (mes+1) + "/" + a�o);
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
		
		N�Unidades = new JSpinner();
		N�Unidades.setBounds(254, 233, 120, 20);
		add(N�Unidades);
		
		panel = new JPanel();
		panel.setBounds(254, 67, 188, 154);
		add(panel);
		
		JRadioButton RB_Helbide = new JRadioButton("Helbide");
		RB_Helbide.setFont(new Font("Tahoma", Font.PLAIN, 9));
		RB_Helbide.setBounds(20, 233, 60, 20);
		add(RB_Helbide);
		
		TF_Helbide = new JTextField("x");
		TF_Helbide.setHorizontalAlignment(SwingConstants.CENTER);
		TF_Helbide.setColumns(10);
		TF_Helbide.setBounds(87, 233, 157, 20);
		add(TF_Helbide);
		
		String[] produktuak = controladorPanelPedidos.accionadoComboBox();
		for(int i=0;i < produktuak.length;i++) {
			CB_Produktoak.addItem(produktuak[i]);
		}

		initializeEvents();
	}

	private void initializeEvents() {
		this.btnAurrera.addActionListener(listenerBotonLaburpenera(this.controladorPanelPedidos)); 
		this.btnAtzera.addActionListener(listenerBotonAtzera(this.controladorPanelPedidos));
	}

	private ActionListener listenerBotonLaburpenera(ControladorPanelPedidos controladorPanelPedidos) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorPanelPedidos.accionadoBottonLaburpenera();
			}
		};
	}
	private ActionListener listenerBotonAtzera(ControladorPanelPedidos controladorPanelPedidos) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorPanelPedidos.accionadoBottonAtzera();
			}
		};
	}
}

