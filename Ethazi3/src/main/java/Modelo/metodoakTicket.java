package Modelo;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class metodoakTicket {

	public static void sartuTicket(String NIF, double diruTotala, int TransferentziaZbk, int año, int mes, int dia) {
		Connection konekzioa = BBDDKonexioa.getConexion();
		char operazioMota = 'T';
		String query1 = (Kontsultak.insertOperaciones + "('" + TransferentziaZbk + "', '" + año + "/" + (mes + 1) + "/"
				+ dia + "','" + diruTotala + "','" + NIF + "', '" + operazioMota + "')");
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
