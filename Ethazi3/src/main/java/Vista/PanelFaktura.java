package Vista;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JSpinner;

public class PanelFaktura extends JPanel {

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
	public PanelFaktura() {
		setBackground(new Color(211, 211, 211));
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
		
		JButton btnNewButton = new JButton("\u2716\uFE0F Atzera");
		btnNewButton.setBounds(353, 266, 92, 23);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u2714\uFE0F Aurrera");
		btnNewButton_1.setBounds(254, 266, 92, 23);
		add(btnNewButton_1);
		
		TF_Fecha = new JTextField(dia + "/" + (mes+1) + "/" + año);
		TF_Fecha.setHorizontalAlignment(SwingConstants.CENTER);
		TF_Fecha.setBounds(367, 36, 75, 20);
		add(TF_Fecha);
		TF_Fecha.setColumns(10);
		
		LB_Data = new JLabel("Data:");
		LB_Data.setHorizontalAlignment(SwingConstants.CENTER);
		LB_Data.setBounds(328, 39, 46, 14);
		add(LB_Data);
		
		LB_Lokala = new JLabel("Lokala:");
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
		textField_2.setBounds(61, 267, 150, 20);
		add(textField_2);
	}
}
