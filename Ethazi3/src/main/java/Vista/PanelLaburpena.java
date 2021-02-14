package Vista;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Controlador.ControladorPanelLaburpena;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

@SuppressWarnings("serial")
public class PanelLaburpena extends JPanel {

	private ControladorPanelLaburpena controladorPanelLaburpena;

	private JButton btnSegi;

	private JLabel lb_1_;
	private JLabel lb_2_;
	private JLabel lb_3_;
	private JLabel lb_Erosketa;
	private JLabel lb_Nombre;
	private JLabel lb_Total;
	private JLabel lb_TotalCant;
	private JLabel lb_Laburpen;

	// *****************************************************************************************************************************************************************************************************

	public PanelLaburpena(ControladorPanelLaburpena controladorPanelLaburpena){

		this.controladorPanelLaburpena = controladorPanelLaburpena;
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);
		
		// _______________________________________________________________________________________________________________________________________________________________________________

		String emaitza = controladorPanelLaburpena.pantailaratu();
		double diruTotala = controladorPanelLaburpena.diruTotala();

		// _______________________________________________________________________________________________________________________________________________________________________________

		lb_Erosketa = new JLabel("EROSKETA");
		lb_Erosketa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lb_Erosketa.setHorizontalAlignment(SwingConstants.CENTER);
		lb_Erosketa.setBounds(10, 11, 430, 30);
		add(lb_Erosketa);

		lb_1_ = new JLabel("_____________________________________________________________");
		lb_1_.setBounds(10, 27, 430, 14);
		add(lb_1_);

		lb_2_ = new JLabel("_____________________________________________________________");
		lb_2_.setBounds(10, 51, 430, 14);
		add(lb_2_);

		lb_3_ = new JLabel("_____________________________________________________________");
		lb_3_.setBounds(10, 248, 430, 14);
		add(lb_3_);

		lb_Nombre = new JLabel(controladorPanelLaburpena.konprobatuLokalarenIzena());
		lb_Nombre.setHorizontalAlignment(SwingConstants.CENTER);
		lb_Nombre.setBounds(10, 47, 430, 14);
		add(lb_Nombre);

		lb_Total = new JLabel("TOTAL EUR: ");
		lb_Total.setHorizontalAlignment(SwingConstants.LEFT);
		lb_Total.setBounds(10, 245, 155, 20);
		add(lb_Total);

		lb_TotalCant = new JLabel(diruTotala + "€");
		lb_TotalCant.setHorizontalAlignment(SwingConstants.RIGHT);
		lb_TotalCant.setBounds(283, 250, 145, 10);
		add(lb_TotalCant);

		lb_Laburpen = new JLabel(emaitza);
		lb_Laburpen.setVerticalAlignment(SwingConstants.TOP);
		lb_Laburpen.setBounds(40, 75, 370, 143);
		add(lb_Laburpen);

		// _______________________________________________________________________________________________________________________________________________________________________________

		btnSegi = new JButton("\u2714");
		btnSegi.setBounds(10, 270, 305, 20);
		add(btnSegi);

		initializeEvents();
	}

	// *****************************************************************************************************************************************************************************************************

	private void initializeEvents() {
		this.btnSegi.addActionListener(listenerBotonHasierara(this.controladorPanelLaburpena));
	}

	// *****************************************************************************************************************************************************************************************************

	private ActionListener listenerBotonHasierara(ControladorPanelLaburpena controladorPanelLaburpena) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				int i = 0;
				try {
					controladorPanelLaburpena.sartuTiene(i);
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
				
				
				if (controladorPanelLaburpena.konprobatuLokala().equals("Restaurante")) {
					controladorPanelLaburpena.sakatuPanelJatetxeBotoia();
				} else if (controladorPanelLaburpena.konprobatuLokala().equals("Bar")) {
					controladorPanelLaburpena.sakatuPanelTabernaBotoia();
				} else {
					controladorPanelLaburpena.sakatuPanelKafetegiaBotoia();
				}

			}
		};
	}
}
