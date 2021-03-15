package Vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Controlador.ControladorPanelMenuTaberna; 

@SuppressWarnings("serial")
public class PanelMenuTaberna extends JPanel {

	private ControladorPanelMenuTaberna controladorPanelMenuTaberna;

	private JButton btnFaktura;
	private JButton btnTicket; 
	private JButton btnHornikuntza;
	private JMenuBar menuBar;
	private JMenu menuOperatibitatea;
	private JMenu menuTop5;
	private JMenuItem menuItemSarratu;
	private JMenuItem menuItemDeslogeatu;
	private String [] top5produktuak;
	private JMenuItem produktuak;
	private JMenu diario;	
	private JMenu semanal;
	private JMenuItem diarioDirua;
	private JMenuItem semanalDirua;

	// *****************************************************************************************************************************************************************************************************

	public PanelMenuTaberna(ControladorPanelMenuTaberna controladorPanelMenuTaberna) {

		this.controladorPanelMenuTaberna = controladorPanelMenuTaberna;
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);
		setBounds(0, 0, 450, 300);

		btnTicket = new JButton("TICKET");
		btnTicket.setFont(new Font("Tahoma", Font.ITALIC, 11));
		btnTicket.setBounds(10, 52, 210, 113); 
		add(btnTicket);

		btnFaktura = new JButton("FAKTURA");
		btnFaktura.setFont(new Font("Tahoma", Font.ITALIC, 11));
		btnFaktura.setBounds(230, 52, 210, 113);
		add(btnFaktura); 

		btnHornikuntza = new JButton("+");
		btnHornikuntza.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnHornikuntza.setBounds(125, 176, 210, 113);
		add(btnHornikuntza);

		menuBar = new JMenuBar();
		menuBar.setBounds(24, 11, 400, 22);
		add(menuBar);

		menuOperatibitatea = new JMenu("Operatibitatea"); 
		menuBar.add(menuOperatibitatea);

		diario = new JMenu("Diario");
		menuOperatibitatea.add(diario);

		semanal = new JMenu("Semanal");
		menuOperatibitatea.add(semanal);

		semanalDirua = new JMenuItem(String.valueOf(controladorPanelMenuTaberna.asterokoIrabazia()));
		semanal.add(semanalDirua);

		diarioDirua = new JMenuItem(String.valueOf(controladorPanelMenuTaberna.egunerokoIrabazia()));
		diario.add(diarioDirua);

		menuTop5 = new JMenu("Top5 Salmentak");
		menuBar.add(menuTop5);		

		top5produktuak = controladorPanelMenuTaberna.top5produktuak();
		for(int i = 0; i < top5produktuak.length; i++) { 
			produktuak = new JMenuItem();  
			produktuak.setText(top5produktuak[i]);
			menuTop5.add(produktuak);
		}

		menuItemDeslogeatu	= new JMenuItem("DESLOGEATU");
		menuBar.add(menuItemDeslogeatu); 

		menuItemSarratu = new JMenuItem("X"); 
		menuItemSarratu.setHorizontalAlignment(SwingConstants.RIGHT);
		menuItemSarratu.setForeground(Color.RED);
		menuBar.add(menuItemSarratu);

		initializeEvents();
	}

	// *****************************************************************************************************************************************************************************************************

	private void initializeEvents() {
		this.btnFaktura.addActionListener(listenerFakturaBotoia(this.controladorPanelMenuTaberna));
		this.btnTicket.addActionListener(listenerTicketBotoia(this.controladorPanelMenuTaberna));
		this.menuItemSarratu.addActionListener(listenerSarratuBotoia(this.controladorPanelMenuTaberna));
		this.menuItemDeslogeatu.addActionListener(listenerHasieraBotoia(this.controladorPanelMenuTaberna));
		this.btnHornikuntza.addActionListener(listenerHornikuntzaBotoia(this.controladorPanelMenuTaberna));
	}

	// *****************************************************************************************************************************************************************************************************

	private ActionListener listenerFakturaBotoia(ControladorPanelMenuTaberna controladorPanelMenuTaberna) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorPanelMenuTaberna.sakatuFakturaPanelaIkustekoBotoia();
			}
		};
	} 

	// *****************************************************************************************************************************************************************************************************

	private ActionListener listenerTicketBotoia(ControladorPanelMenuTaberna controladorPanelMenuTaberna) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorPanelMenuTaberna.sakatuTicketPanelaIkustekoBotoia();
			}
		};
	} 

	// *****************************************************************************************************************************************************************************************************

	private ActionListener listenerSarratuBotoia(ControladorPanelMenuTaberna controladorPanelMenuTaberna) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorPanelMenuTaberna.sakatuAtzeraBotoia();
			}
		};
	} 

	// *****************************************************************************************************************************************************************************************************

	private ActionListener listenerHornikuntzaBotoia(ControladorPanelMenuTaberna controladorPanelMenuTaberna) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorPanelMenuTaberna.sakatuHornikuntzaBotoia();
			}
		};
	} 

	// *****************************************************************************************************************************************************************************************************

	private ActionListener listenerHasieraBotoia(ControladorPanelMenuTaberna controladorPanelMenuTaberna) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorPanelMenuTaberna.sakatuHasieraBotoia();
			}
		};
	}
}
