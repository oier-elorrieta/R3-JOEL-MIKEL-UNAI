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
public class PanelFakturaLaburpena extends JPanel {

	private ControladorPanelFakturaLaburpena controladorPanelFakturaLaburpena;

	private JButton btnSegi;

	private JLabel LB_1_;
	private JLabel LB_2_;
	private JLabel LB_3_;
	private JLabel LB_Erosketa;
	private JLabel LB_Nombre;
	private JLabel LB_Direccion;
	private JLabel LB_Total;
	private JLabel LB_TotalCant;
	private JLabel lbldirua;
	private JLabel lblLaburpen;
	private JLabel lblkopurua;

	private String aukera;
	private String kantitatea;
	private String dirua; 
	
	private int diruTotala;

	// *****************************************************************************************************************************************************************************************************

	public PanelFakturaLaburpena(ControladorPanelFakturaLaburpena controladorPanelFakturaLaburpena) {

		this.controladorPanelFakturaLaburpena = controladorPanelFakturaLaburpena;
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);

		// _______________________________________________________________________________________________________________________________________________________________________________

		aukera = controladorPanelFakturaLaburpena.arrayaIkusi();
		kantitatea = controladorPanelFakturaLaburpena.arrayaKantitateakIkusi();
		dirua = controladorPanelFakturaLaburpena.arrayaDiruaIkusi();
		diruTotala = controladorPanelFakturaLaburpena.diruTotala();

		// _______________________________________________________________________________________________________________________________________________________________________________

		LB_Erosketa = new JLabel("EROSKETA");
		LB_Erosketa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		LB_Erosketa.setHorizontalAlignment(SwingConstants.CENTER);
		LB_Erosketa.setBounds(10, 11, 430, 30);
		add(LB_Erosketa);

		LB_1_ = new JLabel("_____________________________________________________________");
		LB_1_.setBounds(10, 27, 430, 14);
		add(LB_1_);

		LB_2_ = new JLabel("_____________________________________________________________");
		LB_2_.setBounds(10, 83, 430, 14);
		add(LB_2_);

		LB_3_ = new JLabel("_____________________________________________________________");
		LB_3_.setBounds(10, 275, 430, 14);
		add(LB_3_);

		LB_Nombre = new JLabel("NOMBRE");
		LB_Nombre.setHorizontalAlignment(SwingConstants.CENTER);
		LB_Nombre.setBounds(10, 47, 430, 14);
		add(LB_Nombre);

		LB_Direccion = new JLabel("DIRECCION");
		LB_Direccion.setHorizontalAlignment(SwingConstants.CENTER);
		LB_Direccion.setBounds(10, 72, 430, 14);
		add(LB_Direccion);

		LB_Total = new JLabel("TOTAL EUR "+diruTotala);
		LB_Total.setHorizontalAlignment(SwingConstants.LEFT);
		LB_Total.setBounds(10, 259, 155, 20);
		add(LB_Total);

		LB_TotalCant = new JLabel("X");
		LB_TotalCant.setHorizontalAlignment(SwingConstants.RIGHT);
		LB_TotalCant.setBounds(285, 259, 155, 20);
		add(LB_TotalCant);

		lblkopurua = new JLabel(kantitatea);
		lblkopurua.setBounds(38, 108, 46, 143);
		add(lblkopurua);

		lblLaburpen = new JLabel(aukera);
		lblLaburpen.setBounds(112, 108, 131, 143);
		add(lblLaburpen);
		
		lbldirua = new JLabel(dirua);
		lbldirua.setBounds(248, 108, 55, 140);
		add(lbldirua);

		// _______________________________________________________________________________________________________________________________________________________________________________

		btnSegi = new JButton("\u2714");
		btnSegi.setBounds(370, 0, 89, 23);
		add(btnSegi);

		initializeEvents();
	}

	// *****************************************************************************************************************************************************************************************************

	private void initializeEvents() {
		this.btnSegi.addActionListener(listenerBotonHasierara(this.controladorPanelFakturaLaburpena));
	}

	// *****************************************************************************************************************************************************************************************************

	private ActionListener listenerBotonHasierara(ControladorPanelFakturaLaburpena controladorPanelFakturaLaburpena) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					controladorPanelFakturaLaburpena.accionadoBottonMostrarPanelMenu();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
	}
}