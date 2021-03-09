package Modelo;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class metodoakEskaera {

	public static void sartuEskaera(String NIF, double diruTotala, String helbidea, int TransferentziaZbk, int año,
			int mes, int dia) {

		Connection konekzioa = BBDDKonexioa.getConexion();

		char operazioMota = 'P';

		String query1 = (Kontsultak.insertOperaciones + "('" + TransferentziaZbk + "', '" + año + "/" + (mes + 1) + "/"
				+ dia + "','" + diruTotala + "','" + NIF + "', '" + operazioMota + "')");

		String query2 = (Kontsultak.insertEskaera + "('" + TransferentziaZbk + "', '" + helbidea + "')");

		try {
			Statement s;
			s = konekzioa.createStatement();
			s.executeUpdate(query1);
			Statement st;
			st = konekzioa.createStatement();
			st.executeUpdate(query2);
		} catch (SQLException e) {
			System.out.println("Errorea konexioan");
			e.printStackTrace();
		}
	}
}
