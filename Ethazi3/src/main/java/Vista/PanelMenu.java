package Vista;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox; 
import javax.swing.JPanel;
import javax.swing.JTextArea;

import Controlador.ControladorPanelMenu; 
import javax.swing.JPanel;
@SuppressWarnings("serial")
public class PanelMenu extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelMenu() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(0, 0, 450, 300);
		add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("FAKTURA");
		btnNewButton.setFont(new Font("Tahoma", Font.ITALIC, 11));
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(176, 113, 89, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("TICKET");
		btnNewButton_1.setFont(new Font("Tahoma", Font.ITALIC, 11));
		btnNewButton_1.setBackground(Color.BLACK);
		btnNewButton_1.setBounds(176, 147, 89, 23);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("ESKAERA");
		btnNewButton_2.setFont(new Font("Tahoma", Font.ITALIC, 11));
		btnNewButton_2.setBackground(Color.BLACK);
		btnNewButton_2.setBounds(176, 181, 89, 23);
		panel.add(btnNewButton_2);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(166, 70, -54, 22);
		panel.add(textArea);
		
		JTextArea txtrAukerak = new JTextArea();
		txtrAukerak.setFont(new Font("Monospaced", Font.ITALIC, 16));
		txtrAukerak.setBackground(Color.LIGHT_GRAY);
		txtrAukerak.setText("AUKERAK:");
		txtrAukerak.setBounds(45, 45, 89, 23);
		panel.add(txtrAukerak);
		
		JButton btnNewButton_3 = new JButton("SARRATU ");
		btnNewButton_3.setBackground(Color.BLACK);
		btnNewButton_3.setForeground(Color.BLACK);
		btnNewButton_3.setFont(new Font("Tahoma", Font.ITALIC, 11));
		btnNewButton_3.setBounds(351, 266, 89, 23);
		panel.add(btnNewButton_3);

	}
}
