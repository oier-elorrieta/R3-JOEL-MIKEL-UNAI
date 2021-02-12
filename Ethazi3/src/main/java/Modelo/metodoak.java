package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class metodoak {

	public static ArrayList<Karritoa> sartuProduktuaArrayan(String elikagaia, int kopuru, ArrayList<Karritoa> karroa) {
		double dirua = sartuDirua(elikagaia, kopuru);
		Karritoa Prod = new Karritoa(elikagaia, kopuru, dirua);
		karroa.add(Prod);
		return karroa;
	}

	// *****************************************************************************************************************************************************************************************************

	public static String pantailatuProduktua(ArrayList<Karritoa> karroa) {
		String PantailatukoDena = "";
		for (int i = 0; i < karroa.size(); i++) {
			PantailatukoDena = PantailatukoDena + "<html>" + karroa.get(i).toString() + "<br><html>";
		}
		return PantailatukoDena;
	}

	// *****************************************************************************************************************************************************************************************************

	public static String[] sartuSalgaiak() {
		Produktua elikagaiak[] = objektuak();

		String produktoIzena[] = new String[produktuKantitatea()];
		for (int i = 0; i < produktoIzena.length; i++) {
			produktoIzena[i] = elikagaiak[i].getIzena();
		}
		return produktoIzena;
	}

	// *****************************************************************************************************************************************************************************************************

	public static double sartuDirua(String aukera, int kantitatea) {
		Produktua elikagaiak[] = objektuak();
		double dirua = 0;
		for (int i = 0; i < elikagaiak.length; i++) {
			if (elikagaiak[i].getIzena().equalsIgnoreCase(aukera)) {
				dirua = kantitatea * elikagaiak[i].getSaltzekoPrezioa();
				break;
			}
		}
		return dirua;
	}

	// *****************************************************************************************************************************************************************************************************

	public static int gehituTransferentziaZenbakia(int zbk) {
		zbk++;
		return zbk;
	}

	// *****************************************************************************************************************************************************************************************************

	public static double diruTotala(ArrayList<Karritoa> karroa) {
		double diruTotala = 0;
		for (int i = 0; i < karroa.size(); i++) {
			diruTotala = diruTotala + karroa.get(i).getBalioa();
		}
		return diruTotala;
	}

	// *****************************************************************************************************************************************************************************************************

	public static ArrayList<Karritoa> ezabatuArraya(ArrayList<Karritoa> karroa) {
		karroa.clear();
		return karroa;
	}

	// *****************************************************************************************************************************************************************************************************

	public static ImageIcon argazkiaAukeratu(String aukera) {
		return new ImageIcon("argazkiak/" + aukera + ".jpg");
	}

	// *****************************************************************************************************************************************************************************************************
	// ***********************************DATU_BASE_METODOAK************************************************************************************************************************************************
	// *****************************************************************************************************************************************************************************************************

	public static Produktua[] objektuak() {

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

	// ******************************************************************************************************************************************************************************************************

	public static int produktuKantitatea() {
		Connection konekzioa = BBDDKonexioa.getConexion();

		String query1 = (Kontsultak.selectProduktuKantitatea);
		int i = 0;

		try {
			ResultSet re;
			PreparedStatement p;

			p = konekzioa.prepareStatement(query1);
			re = p.executeQuery();
			if (re.next()) {
				i = re.getInt("count(nombre)");
			}
		} catch (SQLException e) {
			System.out.println("Errorea konexioan");
			e.printStackTrace();
		}
		return i;
	}

	// *****************************************************************************************************************************************************************************************************

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

	// *****************************************************************************************************************************************************************************************************

	public static Erabiltzaile sartuErabiltzailea(String erabiltzailea, String pasahitza, Erabiltzaile usuarioa) {
		usuarioa.setErabiltzailea(erabiltzailea);
		usuarioa.setPasahitza(pasahitza);
		return usuarioa;
	}

	// *****************************************************************************************************************************************************************************************************

	public static int jasoTransakzioZbk() throws SQLException, ClassNotFoundException {

		Connection konekzioa = BBDDKonexioa.getConexion();

		String query1 = (Kontsultak.selectMaxNumTrans);
		int TransakzioZbk = 0;

		try {
			ResultSet re;
			PreparedStatement p;

			p = konekzioa.prepareStatement(query1);
			re = p.executeQuery();
			if (re.next()) {
				if (re.getInt("max(NumTrans)") == 0) {
					TransakzioZbk = 1;
				} else {
					TransakzioZbk = re.getInt("max(NumTrans)");
					TransakzioZbk++;
				}
			}
		} catch (SQLException e) {
			System.out.println("Errorea konexioan");
			e.printStackTrace();
		}
		return TransakzioZbk;
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

	public static void sartuTicket(String NIF, double diruTotala, int TransferentziaZbk, int año, int mes, int dia) {

		Connection konekzioa = BBDDKonexioa.getConexion();

		String query1 = (Kontsultak.insertOperaciones + "('" + TransferentziaZbk + "', '" + año + "/" + (mes + 1) + "/"
				+ dia + "','" + diruTotala + "','" + NIF + "')");

		try {
			Statement s;
			s = konekzioa.createStatement();
			s.executeUpdate(query1);
		} catch (SQLException e) {
			System.out.println("Errorea konexioan");
			e.printStackTrace();
		}
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

	public static void sartuEskaera(String NIF, double diruTotala, String helbidea, int TransferentziaZbk, int año,
			int mes, int dia) {

		Connection konekzioa = BBDDKonexioa.getConexion();

		String query1 = (Kontsultak.insertOperaciones + "('" + TransferentziaZbk + "', '" + año + "/" + (mes + 1) + "/"
				+ dia + "','" + diruTotala + "','" + NIF + "')");

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

	// *****************************************************************************************************************************************************************************************************

	public static void sartuFaktura(String NIF, String izena, String abizena, double diruTotala, int TransferentziaZbk,
			int año, int mes, int dia) {

		Connection konekzioa = BBDDKonexioa.getConexion();

		String query1 = (Kontsultak.insertOperaciones + "('" + TransferentziaZbk + "', '" + año + "/" + (mes + 1) + "/"
				+ dia + "' ,'" + diruTotala + "','" + NIF + "')");

		String query2 = (Kontsultak.insertNifFaktura + "('" + NIF + "', '" + izena + "', '" + abizena + "')");

		String query3 = (Kontsultak.insertFactura + "('" + TransferentziaZbk + "','" + NIF + "');");

		try {
			Statement s;
			s = konekzioa.createStatement();
			s.executeUpdate(query1);
			Statement st;
			st = konekzioa.createStatement();
			st.executeUpdate(query2);
			Statement smt;
			smt = konekzioa.createStatement();
			smt.executeUpdate(query3);
		} catch (SQLException e) {
			System.out.println("Errorea konexioan");
			e.printStackTrace();
		}
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

	// *****************************************************************************************************************************************************************************************************

	public static void gehituStocka(String nomProduktua, int kantitatea, String nif) {

		Connection konekzioa = BBDDKonexioa.getConexion();

		String query1 = (Kontsultak.updateGehituStock + "" + kantitatea + " where NIFLocal = '" + nif + "' and NomProducto='" + nomProduktua + "';");

		try {
			Statement s;
			s = konekzioa.createStatement();
			s.executeUpdate(query1);
		} catch (SQLException e) {
			System.out.println("Errorea konexioan");
			e.printStackTrace();
		}
	}

	// *****************************************************************************************************************************************************************************************************

	public static void kenduStocka(String nomProduktua, int kantitatea, String nif) {

		Connection konekzioa = BBDDKonexioa.getConexion();

		String query1 = (Kontsultak.updateKenduStock + "" + kantitatea + " where NIFLocal = '" + nif + "' and NomProducto='" + nomProduktua + "';");

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
