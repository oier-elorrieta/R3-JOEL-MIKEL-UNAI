package BBDD;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class BBDDKonexioa {


	private static final String CONTROLADOR = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:33060/ethazi3";
	private static final String USUARIO = "root";
	private static final String CLAVE = "elorrieta";
	

	public static Connection getConexion() {
		Connection konekzioa = null;
		/*ResultSet re;
		Statement s;
		PreparedStatement p;*/
		
		
		try {
			Class.forName(CONTROLADOR);
			konekzioa = DriverManager.getConnection(URL, USUARIO, CLAVE);
			//Insertar valores en BBDD
			/*s = konekzioa.createStatement();
			String query1 = ("INSERT INTO Usuario VALUES ('79187197Z','Unai','Hernando','12345678')");
			s.executeUpdate(query1);*/
			//Mirar los valores de BBDD
			/*String query1 = ("SELECT * FROM usuario;");
			p = konekzioa.prepareStatement(query1);
			re = p.executeQuery();
			
			if(re.next()) {
				System.out.println(re.getString("DNI")+"\n"+re.getString("Nombre"));
			}*/
			 
			System.out.println("Konekzioa OK");

		} catch (ClassNotFoundException e) {
			System.out.println("Errorea kontroladorean"/*Error al cargar el controlador*/);
			e.printStackTrace();

		} catch (SQLException e) {
			System.out.println("Errorea konexioan"/*Error en la conexión*/);
			e.printStackTrace();
		}
		return konekzioa;
	}
	public static void main(String[] args) {
		getConexion();
	}
}
