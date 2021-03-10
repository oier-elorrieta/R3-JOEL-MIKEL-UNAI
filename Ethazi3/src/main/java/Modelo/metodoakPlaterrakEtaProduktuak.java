package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class metodoakPlaterrakEtaProduktuak {

	public static int produktuKantitatea() {
		Connection konekzioa = BBDDKonexioa.getConexion();
		String query1 = (Kontsultak.selectProduktuKantitatea);
		int kantitatea = 0;
		try {
			ResultSet re;
			PreparedStatement p;
			p = konekzioa.prepareStatement(query1);
			re = p.executeQuery();
			if (re.next()) {
				kantitatea = re.getInt("count(nombre)");
			}
		} catch (SQLException e) {
			System.out.println("Errorea konexioan");
			e.printStackTrace();
		}
		return kantitatea;
	}

	// *****************************************************************************************************************************************************************************************************

	public static int platerKantitatea() {
		Connection konekzioa = BBDDKonexioa.getConexion();
		String query1 = (Kontsultak.selectPlaterKantitatea);
		int kantitatea = 0;
		try {
			ResultSet re;
			PreparedStatement p;
			p = konekzioa.prepareStatement(query1);
			re = p.executeQuery();
			if (re.next()) {
				kantitatea = re.getInt("count(nombre)");
			}
		} catch (SQLException e) {
			System.out.println("Errorea konexioan");
			e.printStackTrace();
		}
		return kantitatea;
	}

	// *****************************************************************************************************************************************************************************************************

	public static Produktua[] elikagaiak() {
		Connection konekzioa = BBDDKonexioa.getConexion();
		int produktuKantitate = produktuKantitatea();
		String query1 = (Kontsultak.selectProduktuak);
		Produktua elikagaiak[] = new Produktua[produktuKantitate];
		int kont = 0;
		try {
			ResultSet re;
			PreparedStatement p;
			p = konekzioa.prepareStatement(query1);
			re = p.executeQuery();
			while (re.next()) {
				String izena = re.getString("Nombre");
				Date data = re.getDate("Fec_Cad");
				String mota = re.getString("Tipo");
				double saltzekoPrezioa = re.getDouble("Precio_Venta");
				double erosPrezioa = re.getDouble("Precio_Compra");
				String fabrikantea = re.getString("N_Fabricante");
				Produktua p1 = new Produktua(izena, (java.sql.Date) data, mota, saltzekoPrezioa, erosPrezioa,
						fabrikantea);
				elikagaiak[kont] = p1;
				kont++;
			}
		} catch (SQLException e) {
			System.out.println("Errorea konexioan");
			e.printStackTrace();
		}
		return elikagaiak;
	}

	// *****************************************************************************************************************************************************************************************************

	public static Produktua[] platerrak() {
		Connection konekzioa = BBDDKonexioa.getConexion();
		int platerKantitatea = platerKantitatea();
		String query1 = (Kontsultak.selectPlaterrak);
		Produktua platerrak[] = new Produktua[platerKantitatea];
		int kont = 0;
		try {
			ResultSet re;
			PreparedStatement p;
			p = konekzioa.prepareStatement(query1);
			re = p.executeQuery();
			while (re.next()) {
				String izena = re.getString("Nombre");
				Date data = re.getDate("Fec_Cad");
				String mota = re.getString("Tipo");
				double saltzekoPrezioa = re.getDouble("Precio_Venta");
				double erosPrezioa = re.getDouble("Precio_Compra");
				String fabrikantea = re.getString("N_Fabricante");
				Produktua p1 = new Produktua(izena, (java.sql.Date) data, mota, saltzekoPrezioa, erosPrezioa,
						fabrikantea);
				platerrak[kont] = p1;
				kont++;
			}
		} catch (SQLException e) {
			System.out.println("Errorea konexioan");
			e.printStackTrace();
		}
		return platerrak;
	}

	// ******************************************************************************************************************************************************************************************************
	public static Produktua[] produktuGuztiak() {
		Connection konekzioa = BBDDKonexioa.getConexion();
		String query1 = (Kontsultak.selectProductuakEtaPlaterrak);
		Produktua produktuak[] = new Produktua[platerKantitatea() + produktuKantitatea()];
		int kont = 0;
		try {
			ResultSet re;
			PreparedStatement p;
			p = konekzioa.prepareStatement(query1);
			re = p.executeQuery();
			while (re.next()) {
				String izena = re.getString("Nombre");
				Date data = re.getDate("Fec_Cad");
				String mota = re.getString("Tipo");
				double saltzekoPrezioa = re.getDouble("Precio_Venta");
				double erosPrezioa = re.getDouble("Precio_Compra");
				String fabrikantea = re.getString("N_Fabricante");
				Produktua p1 = new Produktua(izena, (java.sql.Date) data, mota, saltzekoPrezioa, erosPrezioa,
						fabrikantea);
				produktuak[kont] = p1;
				kont++;
			}
		} catch (SQLException e) {
			System.out.println("Errorea konexioan");
			e.printStackTrace();
		}
		return produktuak;
	}
}
