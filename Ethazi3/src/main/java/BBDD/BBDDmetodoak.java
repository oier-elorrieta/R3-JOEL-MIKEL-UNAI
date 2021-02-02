package BBDD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;


public class BBDDmetodoak { 

	public static String sartuDatuak(String izena, String abizena, String pasahitza, String erabiltzailea) throws SQLException, ClassNotFoundException {

		Connection konekzioa = BBDDKonexioa.getConexion();
		String query1 = ("INSERT INTO Usuario VALUES ('"+erabiltzailea+"','"+izena+"','"+abizena+"','"+pasahitza+"')");
		try {
			Statement s;
			s = konekzioa.createStatement();			
			System.out.println("vs");
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
		
		String query1 = ("SELECT nombre,contraseña FROM usuario;"); 
		
		String kk = "";
		try {
			ResultSet re; 
			PreparedStatement p;

			p = konekzioa.prepareStatement(query1);
			re = p.executeQuery();
			if(re.next()) {
				System.out.println(re.getString("Nombre"));
				if(re.getString("Nombre").equalsIgnoreCase(erabiltzailea) && re.getString("Contraseña").equalsIgnoreCase(pasahitza)) {
					kk = "Ona"; 	
				}else if(re.getString("Nombre").equalsIgnoreCase(erabiltzailea) || !re.getString("Contraseña").equalsIgnoreCase(pasahitza)) {
					JOptionPane.showMessageDialog(null, "Pasahitza ez da egokia", "ERROR", JOptionPane.ERROR_MESSAGE);
				}else if(!re.getString("Nombre").equalsIgnoreCase(erabiltzailea) /*|| re.getString("Contraseña").equalsIgnoreCase(pasahitza)*/) {
					JOptionPane.showMessageDialog(null, "Erabiltzaile hau ez dago logeatuta", "ERROR", JOptionPane.ERROR_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(null, "Ez zaude logeatuta", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}
		}catch(SQLException e) {
			System.out.println("Errorea konexioan");
			e.printStackTrace();
		}
		return kk;

	}

}
