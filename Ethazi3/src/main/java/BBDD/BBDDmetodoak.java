package BBDD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;


public class BBDDmetodoak { 

	public static String sartuDatuak(String izena, String abizena, String pasahitza, String dni, String nif) throws SQLException, ClassNotFoundException {

		Connection konekzioa = BBDDKonexioa.getConexion();
		String query1 = ("INSERT INTO Usuario VALUES ('"+izena+"','"+abizena+"','"+pasahitza+"','"+dni+"','"+nif+"')");
		try {
			Statement s;
			s = konekzioa.createStatement();
			s.executeUpdate(query1);
			System.out.println("ondo");
		}catch(SQLException e) {
			System.out.println("Errorea konexioan");
			e.printStackTrace();
		}
		return query1;
	}

	public static String konprobatuErabiltzailea(String erabiltzailea, String pasahitza) {

		Connection konekzioa = BBDDKonexioa.getConexion();
		
		String query1 = ("SELECT DNI,Contrase�a,NIF FROM usuario where dni = '"+erabiltzailea+"';"); 
		
		String NIF = null;
		
		try {
			ResultSet re; 
			PreparedStatement p;

			p = konekzioa.prepareStatement(query1);
			re = p.executeQuery();
			if(re.next()) {			
				System.out.println(re.getString("DNI"));
				if(re.getString("DNI").equalsIgnoreCase(erabiltzailea) && re.getString("Contrase�a").equalsIgnoreCase(pasahitza)) {
					NIF = re.getString("NIF");	
				}else if(re.getString("DNI").equalsIgnoreCase(erabiltzailea) && !re.getString("Contrase�a").equalsIgnoreCase(pasahitza)) {
					JOptionPane.showMessageDialog(null, "Pasahitza ez da egokia", "ERROR", JOptionPane.ERROR_MESSAGE);	
				}
			}else {
				JOptionPane.showMessageDialog(null, "Ez zaude logeatuta", "ERROR", JOptionPane.ERROR_MESSAGE);
			} 
		}catch(SQLException e) {
			System.out.println("Errorea konexioan");
			e.printStackTrace();
		}
		return NIF;
	}
}
