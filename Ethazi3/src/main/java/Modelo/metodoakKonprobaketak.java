package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class metodoakKonprobaketak {

	public static boolean begiratuDNI(String dni) {
		Connection konekzioa = BBDDKonexioa.getConexion();
		String query1 = (Kontsultak.selectDNI+ " where DNI = '"+dni+"'");
		boolean badago = false;
		try {
			ResultSet re;
			PreparedStatement p;
			p = konekzioa.prepareStatement(query1);
			re = p.executeQuery();
			if(re.next()) {
				badago = true;
			}
		} catch (SQLException e) {
			System.out.println("Errorea konexioan");
			e.printStackTrace(); 
		}
		return badago;
	}

	// *****************************************************************************************************************************************************************************************************

	public static boolean begiratuNIF(String nif) {
		Connection konekzioa = BBDDKonexioa.getConexion();
		String query1 = (Kontsultak.selectNifLocal+"'"+nif+"'");
		boolean ondoDago = false;
		try {
			ResultSet re;
			PreparedStatement p;
			p = konekzioa.prepareStatement(query1);
			re = p.executeQuery();
			if(re.next()) {
				ondoDago = true;
			}
		} catch (SQLException e) {
			System.out.println("Errorea konexioan");
			e.printStackTrace();
		}
		return ondoDago;
	}

	// *****************************************************************************************************************************************************************************************************

	public static int begiratuStock(String produktua, String nif) {
		Connection konekzioa = BBDDKonexioa.getConexion();
		String query1 = (Kontsultak.selectStockNomProducto + " '" + produktua + "' and nifLocal = '" + nif + "' ");
		int produktuKantitatea = 0;
		try {
			ResultSet re;
			PreparedStatement p;
			p = konekzioa.prepareStatement(query1);
			re = p.executeQuery();
			if (re.next()) {
				produktuKantitatea = re.getInt("Stock");
			}
		} catch (SQLException e) {
			System.out.println("Errorea konexioan");
			e.printStackTrace(); 
		}
		return produktuKantitatea;
	}

	// *****************************************************************************************************************************************************************************************************

	public static String konprobatuErabiltzailea(String erabiltzailea, String pasahitza) {

		Connection konekzioa = BBDDKonexioa.getConexion();

		String query1 = (Kontsultak.selectErabiltzailea + "'" + erabiltzailea + "'");
		String erroreaLogeatzean = null;
		try {
			ResultSet re;
			PreparedStatement p;
			p = konekzioa.prepareStatement(query1);
			re = p.executeQuery();
			if (re.next()) {
				if (re.getString("DNI").equalsIgnoreCase(erabiltzailea)
						&& re.getString("Contraseña").equalsIgnoreCase(pasahitza)) {
					erroreaLogeatzean = "EZ";
				} else if (re.getString("DNI").equalsIgnoreCase(erabiltzailea)
						&& !re.getString("Contraseña").equalsIgnoreCase(pasahitza)) {
					JOptionPane.showMessageDialog(null, "Pasahitza ez da egokia", "ERROR", JOptionPane.ERROR_MESSAGE);
					erroreaLogeatzean = "Bai, pasahitza txarto";
				}
			} else {
				JOptionPane.showMessageDialog(null, "Ez zaude logeatuta", "ERROR", JOptionPane.ERROR_MESSAGE);
				erroreaLogeatzean = "Bai, erabiltzailea txarto";
			}
		} catch (SQLException e) {
			System.out.println("Errorea konexioan");
			e.printStackTrace();
		}

		return erroreaLogeatzean;
	}

	// *****************************************************************************************************************************************************************************************************

	public static String konprobatuNIF(String erabiltzailea) {

		Connection konekzioa = BBDDKonexioa.getConexion();

		String query1 = (Kontsultak.selectNIF + "'" + erabiltzailea + "'");
		String NIF = null;
		try {
			ResultSet re;
			PreparedStatement p;
			p = konekzioa.prepareStatement(query1);
			re = p.executeQuery();
			if (re.next()) {
				NIF = re.getString("NIF");
			}
		} catch (SQLException e) {
			System.out.println("Errorea konexioan");
			e.printStackTrace();
		}
		return NIF;
	}

	// *****************************************************************************************************************************************************************************************************

	public static String konprobatuLokala(String erabiltzailea) {

		Connection konekzioa = BBDDKonexioa.getConexion();

		String query1 = (Kontsultak.selectLokalaMota + "'" + erabiltzailea + "')");
		String Tipo = null;
		try {
			ResultSet re;
			PreparedStatement p;
			p = konekzioa.prepareStatement(query1);
			re = p.executeQuery();
			if (re.next()) {
				Tipo = re.getString("Tipo");
			}
		} catch (SQLException e) {
			System.out.println("Errorea konexioan");
			e.printStackTrace();
		}
		return Tipo;
	}

	// *****************************************************************************************************************************************************************************************************

	public static String konprobatuLokalarenIzena(String NIF) {

		Connection konekzioa = BBDDKonexioa.getConexion();

		String query1 = (Kontsultak.selectLokalarenIzena + "'" + NIF + "'");
		String LokalarenIzena = null;
		try {
			ResultSet re;
			PreparedStatement p;
			p = konekzioa.prepareStatement(query1);
			re = p.executeQuery();
			if (re.next()) {
				LokalarenIzena = re.getString("nombre");
			}
		} catch (SQLException e) {
			System.out.println("Errorea konexioan");
			e.printStackTrace();
		}
		return LokalarenIzena;
	}
}
