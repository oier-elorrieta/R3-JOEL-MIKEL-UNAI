package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BBDDKonexioa {
	
	private static final String CONTROLADOR = "com.mysql.jdbc.Driver";
	//private static final String URL = "jdbc:mysql://localhost:33060/ethazi3";
	private static final String URL = "jdbc:mysql://localhost:3306/ethazi3";
	private static final String USUARIO = "root";
	//private static final String CLAVE = "elorrieta";
	private static final String CLAVE = "defensa12";


	public static Connection getConexion() {

		Connection konekzioa = null;

		try {
			Class.forName(CONTROLADOR);
			konekzioa = DriverManager.getConnection(URL, USUARIO, CLAVE);			 
			System.out.println("Konekzioa OK");

		} catch (ClassNotFoundException e) {
			System.out.println("Errorea kontroladorean");
			e.printStackTrace();

		} catch (SQLException e) {
			System.out.println("Errorea konexioan");
			e.printStackTrace();
		}
		return konekzioa;
	}
	public static void main(String[] args) {
		getConexion();
	}
}
