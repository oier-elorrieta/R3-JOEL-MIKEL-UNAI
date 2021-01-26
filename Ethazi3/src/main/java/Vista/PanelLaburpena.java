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

@SuppressWarnings("serial")
public class PanelLaburpena extends JPanel{

	private ControladorPanelLaburpena controladorPanelLaburpena;

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
	
	private String[] aukeratutakoak = new String[10];
	private int[] kantitateak = new int[10];
	private int[] diruak = new int[10];

	// *****************************************************************************************************************************************************************************************************

	public PanelLaburpena(ControladorPanelLaburpena controladorPanelLaburpena) {

		this.controladorPanelLaburpena = controladorPanelLaburpena;
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);

		// _______________________________________________________________________________________________________________________________________________________________________________
		
		aukera = controladorPanelLaburpena.arrayaIkusi(aukeratutakoak);
		kantitatea = controladorPanelLaburpena.arrayaKantitateakIkusi(kantitateak);
		dirua = controladorPanelLaburpena.arrayaDiruaIkusi(diruak);
		 
		diruTotala = controladorPanelLaburpena.diruTotala(kantitateak);
		

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

		LB_Total = new JLabel("TOTAL EUR: ");
		LB_Total.setHorizontalAlignment(SwingConstants.LEFT);
		LB_Total.setBounds(10, 259, 155, 20);
		add(LB_Total);

		LB_TotalCant = new JLabel(diruTotala+"€");
		LB_TotalCant.setHorizontalAlignment(SwingConstants.RIGHT);
		LB_TotalCant.setBounds(285, 259, 145, 10);
		add(LB_TotalCant);

		lblLaburpen = new JLabel(aukera);
		lblLaburpen.setVerticalAlignment(SwingConstants.TOP);
		lblLaburpen.setBounds(40, 108, 370, 143);
		add(lblLaburpen);

		lblkopurua = new JLabel(kantitatea);
		lblkopurua.setVerticalAlignment(SwingConstants.TOP);
		lblkopurua.setBounds(10, 108, 20, 143);
		add(lblkopurua);
		
		lbldirua = new JLabel(dirua);
		lbldirua.setVerticalAlignment(SwingConstants.TOP);
		lbldirua.setBounds(415, 108, 32, 140);
		add(lbldirua);


		// _______________________________________________________________________________________________________________________________________________________________________________

		btnSegi = new JButton("\u2714");
		btnSegi.setBounds(415, 0, 44, 23);
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
				try {
					controladorPanelLaburpena.accionadoBottonMostrarPanelMenu();
					aukeratutakoak = controladorPanelLaburpena.clear1(aukeratutakoak);
					kantitateak = controladorPanelLaburpena.clear2(kantitateak);
					diruak = controladorPanelLaburpena.clear3(diruak);
				} catch (InterruptedException e) { 
					e.printStackTrace();
				}
			}
		};
	}
}
