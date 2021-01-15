package Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Controlador.ControladorPanelBienvenida;

@SuppressWarnings("serial")
public class PanelBienvenida extends JPanel{

	private JButton btnGeneros;
	private JLabel lblBienvenida;
	private ControladorPanelBienvenida controladorPanelBienvenida;
	private JButton btnInfo;
	private JComboBox<String> comBox;
	
	public PanelBienvenida(ControladorPanelBienvenida controladorPanelBienvenida) {
		this.controladorPanelBienvenida = controladorPanelBienvenida;
		
		setLayout(null);
		
		lblBienvenida = new JLabel("Panel Bienvenida");
		lblBienvenida.setBounds(58, 35, 115, 14);
		add(lblBienvenida);
		
		btnGeneros = new JButton("Generos");
		btnGeneros.setBounds(58, 116, 120, 23);
		add(btnGeneros);
		
		btnInfo = new JButton("Kotxeak");
		btnInfo.setBounds(80, 150, 120, 23);
		add(btnInfo);
		
		comBox = new JComboBox<String>();
		comBox.setBounds(100, 170, 120, 23); 
		add(comBox);
				
		initializeEvents();
	}
	
	private void initializeEvents() {
		this.btnGeneros.addActionListener(listenerBotonGeneros(this.controladorPanelBienvenida));
		this.btnInfo.addActionListener(listenerBotoiKotxeak(controladorPanelBienvenida));
	}
	
	private ActionListener listenerBotonGeneros(ControladorPanelBienvenida controladorPanelBienvenida) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton Generos");
				controladorPanelBienvenida.accionadoBottonMostrarPanelGeneros();
			}
		};
	}
	private ActionListener listenerBotoiKotxeak(ControladorPanelBienvenida controladorPanelBienvenida) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Kotxeak agertu");
				String[] matrikulak = controladorPanelBienvenida.accionadoBottonMatrikulak();
				for(int i = 0;i < matrikulak.length;i++) {
					comBox.addItem(matrikulak[i]);
				}
			}
		};
	}
}
