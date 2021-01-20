package Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controlador.ControladorPanelFakturaLaburpena; 

public class PanelFakturaLaburpena extends JPanel{

	private JButton btnGeneros;
	private JLabel lblBienvenida;
	private ControladorPanelFakturaLaburpena controladorPanelFakturaLaburpena;

	public PanelFakturaLaburpena(ControladorPanelFakturaLaburpena controladorPanelBienvenida) {
		this.controladorPanelFakturaLaburpena = controladorPanelFakturaLaburpena;

		setLayout(null);

		lblBienvenida = new JLabel("Panel Bienvenida");
		lblBienvenida.setBounds(58, 35, 115, 14);
		add(lblBienvenida);

		btnGeneros = new JButton("Generos");
		btnGeneros.setBounds(58, 116, 120, 23);
		add(btnGeneros);

		initializeEvents();
	}

	private void initializeEvents() {
		this.btnGeneros.addActionListener(listenerBotonGeneros(this.controladorPanelFakturaLaburpena));
	}

	private ActionListener listenerBotonGeneros(ControladorPanelFakturaLaburpena controladorPanelBienvenida) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton Generos");
				//controladorPanelBienvenida.accionadoBottonMostrarPanelGeneros();
			}
		};
	}
}