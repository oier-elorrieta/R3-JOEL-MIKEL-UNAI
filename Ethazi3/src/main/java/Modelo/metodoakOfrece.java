package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class metodoakOfrece {

	public static int aukeratuIncluyeKodeak() {
		Connection konekzioa = BBDDKonexioa.getConexion();
		String query1 = (Kontsultak.selectCountCodPlato+"("+Kontsultak.selectMaxNumTrans+")");
		int zbk = 0;
		try {
			ResultSet re;
			PreparedStatement p;
			p = konekzioa.prepareStatement(query1);
			re = p.executeQuery();
			while (re.next()) {
				zbk = re.getInt("count(Cod_Plato)");
			}
		} catch (SQLException e) {
			System.out.println("Errorea konexioan");
			e.printStackTrace();
		}
		return zbk;
	}

	public static int[] kodeak() {
		Connection konekzioa = BBDDKonexioa.getConexion();
		String query1 = (Kontsultak.selectCodPlato+"("+Kontsultak.selectMaxNumTrans+")");
		int[] kodeak = new int[aukeratuIncluyeKodeak()];
		int i = 0;
		try {
			ResultSet re;
			PreparedStatement p;
			p = konekzioa.prepareStatement(query1);
			re = p.executeQuery();
			while (re.next()) {
				kodeak[i] = re.getInt("Cod_Plato");
				i++;
			}
		} catch (SQLException e) {
			System.out.println("Errorea konexioan");
			e.printStackTrace();
		}
		return kodeak;
	}

	public static void ofrece(String nif) {
		int[] kodeak = kodeak();
		for (int i = 0; i < kodeak.length; i++) {
			if (begiratuOfrece(nif, kodeak[i]) == false) {
				insertOfrece(nif, kodeak[i]);
			}
		}
	}

	public static boolean begiratuOfrece(String nif, int platerKodea) {
		Connection konekzioa = BBDDKonexioa.getConexion();
		boolean platerraDago = false;
		String query1 = (Kontsultak.selectOfrece+"'" + nif + "' and Cod_Plato = '" + platerKodea + "'");
		try {
			ResultSet re;
			PreparedStatement p;
			p = konekzioa.prepareStatement(query1);
			re = p.executeQuery();
			if (re.next()) {
				platerraDago = true;
			}
		} catch (SQLException e) {
			System.out.println("Errorea konexioan");
			e.printStackTrace();
		} 
		return platerraDago;
	}

	public static void insertOfrece(String nif, int platerKodea) {
		Connection konekzioa = BBDDKonexioa.getConexion();
		String query1 = (Kontsultak.insertOfrece+"('" + nif + "','" + platerKodea + "')");
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
