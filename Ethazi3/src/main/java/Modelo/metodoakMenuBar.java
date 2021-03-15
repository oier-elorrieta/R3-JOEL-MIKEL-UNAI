package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class metodoakMenuBar {

	public static String[] top5produktuak () {
		Connection konekzioa = BBDDKonexioa.getConexion();
		String query1 = ("select * from Top5");
		String[] top5produktuak = new String[5];
		int i = 0;
		try {
			ResultSet re;
			PreparedStatement p;
			p = konekzioa.prepareStatement(query1);
			re = p.executeQuery();
			while (re.next()) {
				top5produktuak[i] = re.getString("NomProducto");
				i++;
			}
		} catch (SQLException e) { 
			e.printStackTrace();
		}
		return top5produktuak;
	}

	public static double egunerokoIrabazia() {
		Connection konekzioa = BBDDKonexioa.getConexion();
		String query1 = ("select * from operatividadDiaria");
		double irabazia = 0;
		try {
			ResultSet re;
			PreparedStatement p;
			p = konekzioa.prepareStatement(query1);
			re = p.executeQuery();
			if (re.next()) {
				irabazia = re.getDouble(1);
			}
		} catch (SQLException e) { 
			e.printStackTrace();
		}
		return irabazia;
	}

	public static double asterokoIrabazia() {
		Connection konekzioa = BBDDKonexioa.getConexion();
		String query1 = ("select * from operatividadSemanal");
		double irabazia = 0;
		try {
			ResultSet re;
			PreparedStatement p;
			p = konekzioa.prepareStatement(query1);
			re = p.executeQuery();
			if (re.next()) {
				irabazia = re.getDouble(1);
			}
		} catch (SQLException e) { 
			e.printStackTrace();
		}
		return irabazia;
	}
}