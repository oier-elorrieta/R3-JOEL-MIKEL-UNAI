package Vista;

import javax.swing.JLabel;
import javax.swing.JPanel;
import Controlador.ControladorPanelFakturaLaburpena;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;


@SuppressWarnings("serial")
public class PanelFakturaLaburpena extends JPanel{
	
	private ControladorPanelFakturaLaburpena controladorPanelFakturaLaburpena;
	private JButton btnNewButton;

	public PanelFakturaLaburpena(ControladorPanelFakturaLaburpena controladorPanelFakturaLaburpena) {
		setBackground(Color.LIGHT_GRAY);
		this.controladorPanelFakturaLaburpena = controladorPanelFakturaLaburpena;
		setLayout(null);

		JLabel lblNewLabel = new JLabel("EROSKETA");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 430, 30);
		add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("_____________________________________________________________");
		lblNewLabel_1.setBounds(10, 27, 430, 14);
		add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("_____________________________________________________________");
		lblNewLabel_1_1.setBounds(10, 83, 430, 14);
		add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("_____________________________________________________________");
		lblNewLabel_1_2.setBounds(10, 275, 430, 14);
		add(lblNewLabel_1_2);

		JLabel lblNewLabel_2 = new JLabel("NOMBRE");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(10, 47, 430, 14);
		add(lblNewLabel_2);

		JLabel lblNewLabel_2_1 = new JLabel("DIRECCION");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setBounds(10, 72, 430, 14);
		add(lblNewLabel_2_1);

		JLabel LB_Total = new JLabel("TOTAL EUR");
		LB_Total.setHorizontalAlignment(SwingConstants.LEFT);
		LB_Total.setBounds(10, 259, 155, 20);
		add(LB_Total);

		JLabel LB_TotalCant = new JLabel("X");
		LB_TotalCant.setHorizontalAlignment(SwingConstants.RIGHT);
		LB_TotalCant.setBounds(285, 259, 155, 20);
		add(LB_TotalCant);

		btnNewButton = new JButton("\u2714");
		btnNewButton.setBounds(362, 0, 89, 23);
		add(btnNewButton);

		initializeEvents();
	}
	private void initializeEvents() {
		this.btnNewButton.addActionListener(listenerBotonHasierara(this.controladorPanelFakturaLaburpena));
	}
	private ActionListener listenerBotonHasierara(ControladorPanelFakturaLaburpena controladorPanelFakturaLaburpena) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					controladorPanelFakturaLaburpena.accionadoBottonMostrarPanelMenu();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
	}
}