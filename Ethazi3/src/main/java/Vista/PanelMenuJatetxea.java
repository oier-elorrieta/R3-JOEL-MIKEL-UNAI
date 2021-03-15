package Vista;

import java.awt.Color;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 

import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Controlador.ControladorPanelMenuJatetxea;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem; 

@SuppressWarnings("serial")
public class PanelMenuJatetxea extends JPanel {

	private ControladorPanelMenuJatetxea controladorPanelJatetxea;

	private JButton btnFaktura;
	private JButton btnTicket;
	private JButton btnEskaera; 
	private JButton btnKomanda; 
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

	public PanelMenuJatetxea(ControladorPanelMenuJatetxea controladorPanelJatetxea) {

		this.controladorPanelJatetxea = controladorPanelJatetxea;
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);
		setBounds(0, 0, 450, 300);

		btnTicket = new JButton("TICKET");
		btnTicket.setFont(new Font("Tahoma", Font.ITALIC, 11));
		btnTicket.setBounds(10, 39, 185, 113); 
		add(btnTicket);

		btnFaktura = new JButton("FAKTURA");
		btnFaktura.setFont(new Font("Tahoma", Font.ITALIC, 11));
		btnFaktura.setBounds(255, 39, 185, 113);
		add(btnFaktura);

		btnEskaera = new JButton("ESKAERA");
		btnEskaera.setFont(new Font("Tahoma", Font.ITALIC, 11));
		btnEskaera.setBounds(10, 176, 185, 113);
		add(btnEskaera);

		btnKomanda = new JButton("KOMANDA");
		btnKomanda.setFont(new Font("Tahoma", Font.ITALIC, 11));
		btnKomanda.setBounds(255, 176, 185, 113);
		add(btnKomanda);

		btnHornikuntza = new JButton("+");
		btnHornikuntza.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnHornikuntza.setBounds(205, 52, 41, 237);
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

		semanalDirua = new JMenuItem(String.valueOf(controladorPanelJatetxea.asterokoIrabazia()));
		semanal.add(semanalDirua);

		diarioDirua = new JMenuItem(String.valueOf(controladorPanelJatetxea.egunerokoIrabazia()));
		diario.add(diarioDirua);

		menuTop5 = new JMenu("Top5 Salmentak");
		menuBar.add(menuTop5);		

		top5produktuak = controladorPanelJatetxea.top5produktuak();
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
		this.btnFaktura.addActionListener(listenerFakturaBotoia(this.controladorPanelJatetxea));
		this.btnTicket.addActionListener(listenerTicketBotoia(this.controladorPanelJatetxea));
		this.btnEskaera.addActionListener(listenerEskaeraBotoia(this.controladorPanelJatetxea)); 
		this.btnHornikuntza.addActionListener(listenerHornikuntzaBotoia(this.controladorPanelJatetxea));
		this.btnKomanda.addActionListener(listenerKomandaBotoia(this.controladorPanelJatetxea));
		this.menuItemSarratu.addActionListener(listenerSarratuBotoia(this.controladorPanelJatetxea));
		this.menuItemDeslogeatu.addActionListener(listenerHasieraBotoia(this.controladorPanelJatetxea));  
	}

	// *****************************************************************************************************************************************************************************************************

	private ActionListener listenerFakturaBotoia(ControladorPanelMenuJatetxea controladorPanelJatetxea) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorPanelJatetxea.sakatuFakturaPanelaIkustekoBotoia();
			}
		};
	} 

	// *****************************************************************************************************************************************************************************************************

	private ActionListener listenerTicketBotoia(ControladorPanelMenuJatetxea controladorPanelJatetxea) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorPanelJatetxea.sakatuTicketPanelaIkustekoBotoia();
			}
		};
	} 

	// *****************************************************************************************************************************************************************************************************

	private ActionListener listenerEskaeraBotoia(ControladorPanelMenuJatetxea controladorPanelJatetxea) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorPanelJatetxea.sakatuEskaeraPanelaIkustekoBotoia();
			}
		};
	} 

	// *****************************************************************************************************************************************************************************************************

	private ActionListener listenerSarratuBotoia(ControladorPanelMenuJatetxea controladorPanelJatetxea) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorPanelJatetxea.sakatuAtzeraBotoia();
			}
		};
	}

	// *****************************************************************************************************************************************************************************************************

	private ActionListener listenerHornikuntzaBotoia(ControladorPanelMenuJatetxea controladorPanelJatetxea) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorPanelJatetxea.sakatuHornikuntzaBotoia();
			}
		};
	} 

	// *****************************************************************************************************************************************************************************************************

	private ActionListener listenerHasieraBotoia(ControladorPanelMenuJatetxea controladorPanelJatetxea) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorPanelJatetxea.sakatuHasieraBotoia();
			}
		};
	}

	// *****************************************************************************************************************************************************************************************************

	private ActionListener listenerKomandaBotoia(ControladorPanelMenuJatetxea controladorPanelJatetxea) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorPanelJatetxea.sakatuKomandaPanelaIkustekoBotoia();
			}
		};
	}
}