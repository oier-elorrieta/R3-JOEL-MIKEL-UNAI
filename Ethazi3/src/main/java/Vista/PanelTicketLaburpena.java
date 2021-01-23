package Vista;


import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Controlador.ControladorPanelTicketLaburpena;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class PanelTicketLaburpena extends JPanel{

	private ControladorPanelTicketLaburpena controladorPanelTicketLaburpena;
	private JButton btnNewButton;

	public PanelTicketLaburpena(ControladorPanelTicketLaburpena controladorPanelBienvenida) {
		this.controladorPanelTicketLaburpena = controladorPanelBienvenida;

		setBackground(Color.LIGHT_GRAY);
		this.controladorPanelTicketLaburpena = controladorPanelBienvenida;
		setLayout(null);

		JLabel lblNewLabel = new JLabel("EROSKETA");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 430, 30);
		add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("____________________________________________________________");
		lblNewLabel_1.setBounds(10, 27, 425, 14);
		add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("____________________________________________________________");
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
		LB_TotalCant.setBounds(285, 259, 155, 10);
		add(LB_TotalCant);


		btnNewButton = new JButton("\u2714");
		btnNewButton.setBounds(370, 0, 88, 23);
		add(btnNewButton);		
		
		String aukera = controladorPanelTicketLaburpena.arrayaIkusi();
		JLabel lblLaburpen = new JLabel(aukera);
		lblLaburpen.setBounds(56, 135, 308, 107);
		add(lblLaburpen);
		
		String kantitatea = controladorPanelTicketLaburpena.arrayaKantitateakIkusi();
		JLabel lbldirua = new JLabel(kantitatea);
		lbldirua.setBounds(38, 108, 46, 143);
		add(lbldirua);

		initializeEvents();
	}

	private void initializeEvents() {
		this.btnNewButton.addActionListener(listenerBotonHasierara(this.controladorPanelTicketLaburpena));
	}

	private ActionListener listenerBotonHasierara(ControladorPanelTicketLaburpena controladorPanelTicketLaburpena) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					controladorPanelTicketLaburpena.accionadoBottonMostrarPanelMenu();
				} catch (InterruptedException e) { 
					e.printStackTrace();
				}
			}
		};
	}
}
