package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class metodoak {

	public static Produktua[] objektuak() {

		Produktua sidra = new Produktua("Sidra", 0, "Edaria", 3, 1);
		Produktua kafea = new Produktua("Kafea", 0, "Edaria", 3, 1);
		Produktua ura = new Produktua("Ura", 0, "Edaria", 3, 1);
		Produktua zukua = new Produktua("Zukua", 0, "Edaria", 3, 1);
		Produktua garagardoa = new Produktua("Garagardoa", 0, "Edaria", 3, 1);
		Produktua ardoa = new Produktua("Ardoa", 0, "Edaria", 3, 1);
		Produktua txakoli = new Produktua("Txakoli", 0, "Edaria", 3, 1);
		Produktua tortilla = new Produktua("Patata tortilla", 0, "Janaria", 3, 1);
		Produktua gilda = new Produktua("Gilda", 0, "Janaria", 3, 1);
		Produktua colacao = new Produktua("Colacao", 0, "Edaria", 3, 1);
		Produktua elikagaiak[] = new Produktua[10];

		elikagaiak[0] = sidra;
		elikagaiak[1] = kafea;
		elikagaiak[2] = ura;
		elikagaiak[3] = zukua;
		elikagaiak[4] = garagardoa;
		elikagaiak[5] = ardoa;
		elikagaiak[6] = txakoli;
		elikagaiak[7] = tortilla;
		elikagaiak[8] = gilda;
		elikagaiak[9] = colacao;

		return elikagaiak;
	}

	// *****************************************************************************************************************************************************************************************************

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

		String produktoIzena[] = new String[10];
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
				dirua = kantitatea * elikagaiak[i].getUnitatePrezioa();
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

	public static String sartuDatuak(String izena, String abizena, String pasahitza, String dni, String nif)
			throws SQLException, ClassNotFoundException {

		Connection konekzioa = BBDDKonexioa.getConexion();
		
		String query1 = ("INSERT INTO Usuario VALUES ('" + izena + "','" + abizena + "','" + pasahitza + "','" + dni+ "','" + nif + "')");
		try {
			Statement s;
			s = konekzioa.createStatement();
			s.executeUpdate(query1);
			System.out.println("ondo");
		} catch (SQLException e) {
			System.out.println("Errorea konexioan");
			e.printStackTrace();
		}
		
		return query1;
	}

	// *****************************************************************************************************************************************************************************************************

	public static String konprobatuErabiltzailea(String erabiltzailea, String pasahitza) {

		Connection konekzioa = BBDDKonexioa.getConexion();

		String query1 = ("SELECT DNI,Contraseña FROM usuario where dni = '" + erabiltzailea + "'");
		String ErroreaLogeatzean = null;
		
		try {
			ResultSet re;
			PreparedStatement p;

			p = konekzioa.prepareStatement(query1);
			re = p.executeQuery();
			
			if (re.next()) {
				System.out.println(re.getString("DNI"));
				if (re.getString("DNI").equalsIgnoreCase(erabiltzailea) && re.getString("Contraseña").equalsIgnoreCase(pasahitza)) {
					ErroreaLogeatzean = "EZ";
				} else if (re.getString("DNI").equalsIgnoreCase(erabiltzailea) && !re.getString("Contraseña").equalsIgnoreCase(pasahitza)) {
					JOptionPane.showMessageDialog(null, "Pasahitza ez da egokia", "ERROR", JOptionPane.ERROR_MESSAGE);
					ErroreaLogeatzean = "Bai, pasahitza txarto";
				}
			} else {
				JOptionPane.showMessageDialog(null, "Ez zaude logeatuta", "ERROR", JOptionPane.ERROR_MESSAGE);
				ErroreaLogeatzean = "Bai, erabiltzailea txarto";
			}
			
		} catch (SQLException e) {
			System.out.println("Errorea konexioan");
			e.printStackTrace();
		}
		
		return ErroreaLogeatzean;
	}

	// *****************************************************************************************************************************************************************************************************

	public static String komprobatuNIF(String erabiltzailea) {
		
		Connection konekzioa = BBDDKonexioa.getConexion();

		String query1 = ("SELECT NIF FROM usuario where dni = '" + erabiltzailea + "'");

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

	public static void sartuTicket(String NIF, double diruTotala, int TransferentziaZbk) {
		
		Connection konekzioa = BBDDKonexioa.getConexion();

		String query1 = ("INSERT INTO operaciones VALUES ('" + TransferentziaZbk + "', '2021-02-04','" + diruTotala+ "','" + NIF + "')");

		try {
			Statement s;
			s = konekzioa.createStatement();
			s.executeUpdate(query1);
			System.out.println("ondo");
		} catch (SQLException e) {
			System.out.println("Errorea konexioan");
			e.printStackTrace();
		} 
	}

	// *****************************************************************************************************************************************************************************************************

	public static String komprobatuLokala(String NIF) {
		
		Connection konekzioa = BBDDKonexioa.getConexion();

		String query1 = ("select Tipo from local where NIF = '" + NIF + "';");
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

	public static void sartuEskaera(String NIF, double diruTotala, String helbidea, int TransferentziaZbk) {
		
		Connection konekzioa = BBDDKonexioa.getConexion();

		String query1 = ("INSERT INTO operaciones VALUES ('" + TransferentziaZbk + "', '2021-02-04','" + diruTotala+ "','" + NIF + "')");

		String query2 = ("INSERT INTO pedidos VALUES ('" + TransferentziaZbk + "', '" + helbidea + "')");

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

	public static void sartuFaktura(String NIF, String izena, String abizena, double diruTotala, int TransferentziaZbk) {
		
		Connection konekzioa = BBDDKonexioa.getConexion();

		String query1 = ("INSERT INTO operaciones VALUES ('" + TransferentziaZbk + "', '2021-02-04','" + diruTotala+ "','" + NIF + "')");

		String query2 = ("INSERT INTO niffactura VALUES ('" + NIF + "', '" + izena + "', '" + abizena+ "')");

		String query3 = ("INSERT INTO factura VALUES ('"+TransferentziaZbk+"','"+NIF+"');");

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

		public static String komprobatuLokalarenIzena(String NIF) {
			
			Connection konekzioa = BBDDKonexioa.getConexion();

			String query1 = ("SELECT nombre FROM local where NIF = '" + NIF + "'");

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
	
}
