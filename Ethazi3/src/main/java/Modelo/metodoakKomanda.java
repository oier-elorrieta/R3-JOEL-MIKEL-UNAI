package Modelo;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class metodoakKomanda {

	public static void hasieratuOperaciones() throws ClassNotFoundException, SQLException {
		
		Connection konekzioa = BBDDKonexioa.getConexion();
		
		int numTrans = metodoak.jasoTransakzioZbk();
		String query1 = (Kontsultak.insertNumTransOperaciones+"" + numTrans + ")");
		String query2 = (Kontsultak.insertKomanda + "('" + numTrans + "')");
		try {
			Statement s1;
			s1 = konekzioa.createStatement();
			s1.executeUpdate(query1);
			Statement s2;
			s2 = konekzioa.createStatement();
			s2.executeUpdate(query2);
		} catch (SQLException e) {
			System.out.println("Errorea konexioan");
			e.printStackTrace();
		}
	}

	public static void sartuKomanda(double prezioa, String nif, int año, int mes, int dia)
			throws ClassNotFoundException, SQLException {
		
		Connection konekzioa = BBDDKonexioa.getConexion();
		
		char operazioMota = 'C';
		String query1 = (Kontsultak.updateOperaciones+"'" + año + "/" + (mes + 1) + "/" + dia
				+ "' , Total_Operaciones = " + prezioa + " , TipoOperacion = '" + operazioMota + "', NIF = '" + nif
				+ "' where Numtrans = ("+Kontsultak.selectMaxNumTransKomanda+")");
		try {
			Statement s;
			s = konekzioa.createStatement();
			s.executeUpdate(query1);
		} catch (SQLException e) {
			System.out.println("Errorea konexioan");
			e.printStackTrace();
		}
	}

	public static void ezabatuKomanda() throws ClassNotFoundException, SQLException {
		
		Connection konekzioa = BBDDKonexioa.getConexion();
		
		String query1 = (Kontsultak.delete);
		try {
			Statement s1;
			s1 = konekzioa.createStatement();
			s1.executeUpdate(query1);
		} catch (SQLException e) {
			System.out.println("Errorea konexioan");
			e.printStackTrace();
		}
	}

}
