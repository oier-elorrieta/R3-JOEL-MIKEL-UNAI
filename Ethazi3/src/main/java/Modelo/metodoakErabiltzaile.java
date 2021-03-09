package Modelo;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class metodoakErabiltzaile {

	public static Erabiltzaile sartuErabiltzailea(String erabiltzailea, String pasahitza, Erabiltzaile usuarioa) {
		usuarioa.setErabiltzailea(erabiltzailea);
		usuarioa.setPasahitza(pasahitza);
		return usuarioa;
	}		

	public static void sartuDatuak(String izena, String abizena, String pasahitza, String dni, String nif) {

		Connection konekzioa = BBDDKonexioa.getConexion();

		String query1 = (Kontsultak.insertDatuak + "('" + izena + "', '" + abizena + "','" + pasahitza + "','" + dni
				+ "', '" + nif + "')");

		try {
			Statement s;
			s = konekzioa.createStatement();
			s.executeUpdate(query1);
		} catch (SQLException e) {
			System.out.println("Errorea konexioan");
			e.printStackTrace();
		}
	}
}
