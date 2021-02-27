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

	public static ArrayList<Karritoa> sartuPlaterrakArrayan(String elikagaia, int kopuru, ArrayList<Karritoa> karroa) {
		double dirua = sartuDiruaPlaterrak(elikagaia, kopuru);
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
		Produktua elikagaiak[] = elikagaiak();

		String produktoIzena[] = new String[produktuKantitatea()];
		for (int i = 0; i < produktoIzena.length; i++) {
			produktoIzena[i] = elikagaiak[i].getIzena();
		}
		return produktoIzena;
	}

	// *****************************************************************************************************************************************************************************************************

	public static String[] sartuPlaterrak() {
		Platerra platerrak[] = platerrak();

		String platerIzena[] = new String[platerKantitatea()];
		for (int i = 0; i < platerIzena.length; i++) {
			platerIzena[i] = platerrak[i].getIzena();
		}
		return platerIzena;
	}

	// *****************************************************************************************************************************************************************************************************

	public static double sartuDirua(String aukera, int kantitatea) {
		Produktua elikagaiak[] = elikagaiak();
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

	public static double sartuDiruaPlaterrak(String aukera, int kantitatea) {
		Platerra platerrak[] = platerrak();
		double dirua = 0;
		for (int i = 0; i < platerrak.length; i++) {
			if (platerrak[i].getIzena().equalsIgnoreCase(aukera)) {
				dirua = kantitatea * platerrak[i].getSaltzekoPrezioa();
				break;
			}
		}
		return dirua;
	}

	// *****************************************************************************************************************************************************************************************************

	public static double jasoProduktuenPrezioa(String aukera, int kantitatea) {
		Produktua elikagaiak[] = elikagaiak();
		double dirua = 0;
		for (int i = 0; i < elikagaiak.length; i++) {
			if (elikagaiak[i].getIzena().equalsIgnoreCase(aukera)) {
				dirua = kantitatea * elikagaiak[i].getErosPrezioa();
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

	public static ImageIcon argazkiaPlaterraAukeratu(String aukera) {
		return new ImageIcon("argazkiak/" + aukera + ".jpg");
	}

	// *****************************************************************************************************************************************************************************************************

	// *****************************************************************************************************************************************************************************************************

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

	public static Platerra[] platerrak() {

		Connection konekzioa = BBDDKonexioa.getConexion();

		int platerKantitatea = platerKantitatea();

		String query1 = ("SELECT * from plato");

		Platerra platerrak[] = new Platerra[platerKantitatea];
		int kont = 0;
		try {
			ResultSet re;
			PreparedStatement p;

			p = konekzioa.prepareStatement(query1);
			re = p.executeQuery();
			while (re.next()) {
				String platerKodea = re.getString("Cod_Plato");

				String platerMota = re.getString(2);

				String izena = re.getString(3);

				double saltzekoPrezioa = re.getDouble(5);

				double erosPrezioa = re.getDouble(6);

				Platerra p1 = new Platerra(platerKodea, platerMota, izena, saltzekoPrezioa, erosPrezioa);
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

	public static int platerKantitatea() {
		Connection konekzioa = BBDDKonexioa.getConexion();

		String query1 = ("SELECT count(Cod_Plato) from plato");
		int kantitatea = 0;

		try {
			ResultSet re;
			PreparedStatement p;

			p = konekzioa.prepareStatement(query1);
			re = p.executeQuery();
			if (re.next()) {
				kantitatea = re.getInt("count(Cod_Plato)");
			}
		} catch (SQLException e) {
			System.out.println("Errorea konexioan");
			e.printStackTrace();
		}
		return kantitatea;
	}

	// *****************************************************************************************************************************************************************************************************

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

	public static boolean begiratuDNI(String dni) {
		Connection konekzioa = BBDDKonexioa.getConexion();
		String query1 = (Kontsultak.selectDNI);
		boolean badago = false;
		try {
			ResultSet re;
			PreparedStatement p;

			p = konekzioa.prepareStatement(query1);
			re = p.executeQuery();
			while (re.next()) {
				if (dni.equals(re.getString("DNI"))) {
					badago = true;
					break;
				}
			}
		} catch (SQLException e) {
			System.out.println("Errorea konexioan");
			e.printStackTrace();
		}
		return badago;
	}

	// *****************************************************************************************************************************************************************************************************

	public static boolean begiratuNIF(String nif) {
		Connection konekzioa = BBDDKonexioa.getConexion();
		String query1 = (Kontsultak.selectNIFBakarrik);
		boolean ondoDago = false;
		try {
			ResultSet re;
			PreparedStatement p;

			p = konekzioa.prepareStatement(query1);
			re = p.executeQuery();
			while (re.next()) {
				if (nif.equals(re.getString("NIF"))) {
					ondoDago = false;
				} else {
					ondoDago = true;
				}
			}
		} catch (SQLException e) {
			System.out.println("Errorea konexioan");
			e.printStackTrace();
		}
		return ondoDago;
	}

	// *****************************************************************************************************************************************************************************************************

	public static int begiratuStock(String produktua, String nif) {
		Connection konekzioa = BBDDKonexioa.getConexion();
		String query1 = (Kontsultak.selectStock + " '" + produktua + "' and nifLocal = '" + nif + "' ");
		int produktuKantitatea = 0;
		try {
			ResultSet re;
			PreparedStatement p;

			p = konekzioa.prepareStatement(query1);
			re = p.executeQuery();
			if (re.next()) {
				produktuKantitatea = re.getInt("Stock");
			}
		} catch (SQLException e) {
			System.out.println("Errorea konexioan");
			e.printStackTrace();
			System.out.println(produktuKantitatea);
		}
		return produktuKantitatea;
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

	// *****************************************************************************************************************************************************************************************************

	public static void sartuFaktura(String NIF, String izena, String abizena, double diruTotala, int TransferentziaZbk,
			int año, int mes, int dia) {

		Connection konekzioa = BBDDKonexioa.getConexion();

		char operazioMota = 'F';

		String query1 = (Kontsultak.insertOperaciones + "('" + TransferentziaZbk + "', '" + año + "/" + (mes + 1) + "/"
				+ dia + "' ,'" + diruTotala + "','" + NIF + "', '" + operazioMota + "')");

		boolean nifDago = begiratuFakturanNIF(NIF);

		if (nifDago == false) {
			insertNifFaktura(NIF, izena, abizena);
		}

		String query3 = (Kontsultak.insertFactura + "('" + TransferentziaZbk + "','" + NIF + "');");

		try {
			Statement s;
			s = konekzioa.createStatement();
			s.executeUpdate(query1);

			Statement smt;
			smt = konekzioa.createStatement();
			smt.executeUpdate(query3);
		} catch (SQLException e) {
			System.out.println("Errorea konexioan");
			e.printStackTrace();
		}
	}

	public static void insertNifFaktura(String NIF, String izena, String abizena) {
		Connection konekzioa = BBDDKonexioa.getConexion();
		String query2 = (Kontsultak.insertNifFaktura + "('" + NIF + "', '" + izena + "', '" + abizena + "')");
		try {
			Statement st;
			st = konekzioa.createStatement();
			st.executeUpdate(query2);
		} catch (SQLException e) {
			System.out.println("Errorea konexioan");
			e.printStackTrace();
		}
	}

	public static boolean begiratuFakturanNIF(String nif) {
		Connection konekzioa = BBDDKonexioa.getConexion();
		String query1 = ("SELECT nif from niffactura where nif = '" + nif + "'");
		boolean nifDago = false;
		try {
			ResultSet re;
			PreparedStatement p;

			p = konekzioa.prepareStatement(query1);
			re = p.executeQuery();
			while (re.next()) {
				nif = re.getString("NIF");
				nifDago = true;
				break;
			}
		} catch (SQLException e) {
			System.out.println("Errorea konexioan");
			e.printStackTrace();
		}
		return nifDago;
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

	/*
	 * public static void gehituStocka(String nomProduktua, int kantitatea, String
	 * nif) {
	 * 
	 * Connection konekzioa = BBDDKonexioa.getConexion();
	 * 
	 * String query1 = (Kontsultak.updateGehituStock + "" + kantitatea +
	 * " where NIFLocal = '" + nif + "' and NomProducto='" + nomProduktua + "';");
	 * 
	 * try { Statement s; s = konekzioa.createStatement(); s.executeUpdate(query1);
	 * } catch (SQLException e) { System.out.println("Errorea konexioan");
	 * e.printStackTrace(); } }
	 */

	// *****************************************************************************************************************************************************************************************************

	/*
	 * public static void kenduStocka(String nomProduktua, int kantitatea, String
	 * nif) {
	 * 
	 * Connection konekzioa = BBDDKonexioa.getConexion();
	 * 
	 * String query1 = (Kontsultak.updateKenduStock + "" + kantitatea +
	 * " where NIFLocal = '" + nif + "' and NomProducto='" + nomProduktua + "';");
	 * 
	 * try { Statement s; s = konekzioa.createStatement(); s.executeUpdate(query1);
	 * } catch (SQLException e) { System.out.println("Errorea konexioan");
	 * e.printStackTrace(); } }
	 */
	// *****************************************************************************************************************************************************************************************************

	public static void sartuTiene(ArrayList<Karritoa> karroa, int numTrans) throws ClassNotFoundException, SQLException {

		for (int i = 0; i < karroa.size(); i++) {
			String elikagaia = karroa.get(i).getElikagaia();
			int kopurua = karroa.get(i).getKopuru();
			double prezioa = karroa.get(i).getBalioa();

			if (komprobatuProduktoa(elikagaia, numTrans) == false) {
				insertTiene(elikagaia,kopurua, prezioa); 
			} else {
				gehituProduktua(elikagaia,kopurua, prezioa, numTrans); 
			}
		}
	}

	public static void insertTiene(String elikagaia, int kopurua, double prezioa) throws ClassNotFoundException, SQLException { 
		Connection konekzioa = BBDDKonexioa.getConexion();
		String query1 = (Kontsultak.insertTiene + "('" + elikagaia + "', "+ (jasoTransakzioZbk() - 1) + ", " + kopurua + ", " + prezioa+ ")");
		try {
			Statement s;
			s = konekzioa.createStatement();
			s.executeUpdate(query1); 
		} catch (SQLException e) {
			System.out.println("Errorea konexioan");
			e.printStackTrace();
		}
	}

	public static boolean komprobatuProduktoa(String Elikagaia, int numTrans) {

		boolean egia = false; 
		Connection konekzioa = BBDDKonexioa.getConexion();

		String query1 = ("select NomProducto,NumTrans from tiene where NomProducto = '" + Elikagaia + "' and NumTrans = '"+(numTrans-1)+"'"); 

		try {
			ResultSet re;
			PreparedStatement p;
			p = konekzioa.prepareStatement(query1);
			re = p.executeQuery();
			while (re.next()) { 
				egia = true;
			}
		} catch (SQLException e) {
			System.out.println("Errorea konexioan");
			e.printStackTrace(); 
		}
		return egia;
	}

	public static void gehituProduktua(String elikagaia, int kopurua, double prezioa, int NumTrans) {

		Connection konekzioa = BBDDKonexioa.getConexion();

		String query1 = ("update tiene set N_Unidades = N_Unidades + "+kopurua+", Precio = Precio + "+prezioa+" where NomProducto = '"+elikagaia+"'");

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

	public static String jasoHornikuntzarakoFabrikantea(String produktua) {
		Connection konekzioa = BBDDKonexioa.getConexion();
		String izenaFabrikantea = null;
		String query1 = (Kontsultak.selectFabrikantea + "'" + produktua + "')");
		try {
			ResultSet re;
			PreparedStatement p;
			p = konekzioa.prepareStatement(query1);
			re = p.executeQuery();
			if (re.next()) {
				izenaFabrikantea = re.getString("Nombre");
			}
		} catch (SQLException e) {
			System.out.println("Errorea konexioan");
			e.printStackTrace();
		}
		return izenaFabrikantea;
	}

	// *****************************************************************************************************************************************************************************************************

	public static void sartuHornikuntza(String produktua, int año, int mes, int dia, String nif, int kantitatea,ArrayList<Karritoa>karroa)
			throws ClassNotFoundException, SQLException {

		Connection konekzioa = BBDDKonexioa.getConexion();
		String izenaFabrikantea = jasoHornikuntzarakoFabrikantea(produktua);
		int numTrans = jasoTransakzioZbk();
		double dirua = jasoProduktuenPrezioa(produktua, kantitatea);
		char operazioMota = 'A';

		String query2 = (Kontsultak.insertOperaciones + "('" + numTrans + "', '" + año + "/" + (mes + 1) + "/" + dia
				+ "','" + dirua + "','" + nif + "', '" + operazioMota + "')");
		System.out.println("op");
		String query3 = (Kontsultak.insertHornikuntza + "(" + numTrans + ",'" + izenaFabrikantea + "')");
		System.out.println("ap");
		String query4 = ("insert into tiene values ('"+produktua+"',"+numTrans+","+kantitatea+","+dirua+")");
		System.out.println("tiwnw7");
		try {
			Statement s;
			s = konekzioa.createStatement();
			s.executeUpdate(query2);
			Statement s1;
			s1 = konekzioa.createStatement();
			s1.executeUpdate(query3);
			Statement s2;
			s2 = konekzioa.createStatement();
			s2.executeUpdate(query4);
		} catch (SQLException e) {
			System.out.println("Errorea konexioan");
			e.printStackTrace();
		}
	}

	// *****************************************************************************************************************************************************************************************************

	public static String[] platerMotak() {
		Connection konekzioa = BBDDKonexioa.getConexion();
		String query1 = (Kontsultak.selectPlaterMotak);
		String platerMotak[] = new String[3];
		int i = 0;
		try {
			ResultSet re;
			PreparedStatement p;
			p = konekzioa.prepareStatement(query1);
			re = p.executeQuery();
			while (re.next()) {
				platerMotak[i] = re.getString("TipoDePlato");
				i++;
			}
		} catch (SQLException e) {
			System.out.println("Errorea konexioan");
			e.printStackTrace();
		}
		return platerMotak;
	}

	// *****************************************************************************************************************************************************************************************************

	public static String[] platerMota(String platerMota, String tipoa) {
		Connection konekzioa = BBDDKonexioa.getConexion();
		String query1 = (Kontsultak.selectPlaterraMota + " '" + platerMota + "' and TipoPosicion = '" + tipoa + "'");
		String platerMotak[] = new String[zenbatPlaterMotaBakoitzeko(platerMota)];
		int i = 0;
		try {
			ResultSet re;
			PreparedStatement p;
			p = konekzioa.prepareStatement(query1);
			re = p.executeQuery();
			while (re.next()) {
				platerMotak[i] = re.getString("Nombre");
				i++;
			}
		} catch (SQLException e) {
			System.out.println("Errorea konexioan");
			e.printStackTrace();
		}
		return platerMotak;
	}

	// *****************************************************************************************************************************************************************************************************

	public static String[] platerMotaArabera(String platerMota) {
		Connection konekzioa = BBDDKonexioa.getConexion();
		String query1 = (Kontsultak.selectPlaterraMota + "'" + platerMota + "'");
		String platerMotak[] = new String[zenbatPlaterMotaBakoitzeko(platerMota)];
		int i = 0;
		try {
			ResultSet re;
			PreparedStatement p;
			p = konekzioa.prepareStatement(query1);
			re = p.executeQuery();
			while (re.next()) {
				platerMotak[i] = re.getString("Nombre");
				i++;
			}
		} catch (SQLException e) {
			System.out.println("Errorea konexioan");
			e.printStackTrace();
		}
		return platerMotak;
	}

	// *****************************************************************************************************************************************************************************************************

	public static int zenbatPlaterMotaBakoitzeko(String platerMota) {
		Connection konekzioa = BBDDKonexioa.getConexion();
		String query1 = ("SELECT count('" + platerMota + "') from plato where TipoDePlato = '" + platerMota + "';");
		int i = 0;
		try {
			ResultSet re;
			PreparedStatement p;
			p = konekzioa.prepareStatement(query1);
			re = p.executeQuery();
			if (re.next()) {
				i = re.getInt("count('" + platerMota + "')");
			}
		} catch (SQLException e) {
			System.out.println("Errorea konexioan");
			e.printStackTrace();
		}
		return i;
	}

	// *****************************************************************************************************************************************************************************************************

	public static String jasoPlaterKodea(String platerra) {
		Connection konekzioa = BBDDKonexioa.getConexion();
		String query1 = (Kontsultak.selectPlaterKodea + "'" + platerra + "'");
		String platerKodea = null;
		try {
			ResultSet re;
			PreparedStatement p;
			p = konekzioa.prepareStatement(query1);
			re = p.executeQuery();
			if (re.next()) {
				platerKodea = re.getString("Cod_Plato");
			}
		} catch (SQLException e) {
			System.out.println("Errorea konexioan");
			e.printStackTrace();
		}
		return platerKodea;
	}

	// *****************************************************************************************************************************************************************************************************

	public static void sartuKomanda(String platerKodea, int kantitatea, double prezioa, int numTrans, String nif,
			int año, int mes, int dia) {
		Connection konekzioa = BBDDKonexioa.getConexion();
		char operazioMota = 'C';
		String query1 = (Kontsultak.insertOperaciones + "('" + numTrans + "', '" + año + "/" + (mes + 1) + "/" + dia
				+ "','" + prezioa + "','" + nif + "', '" + operazioMota + "')");
		String query2 = (Kontsultak.insertKomanda + "('" + numTrans + "')");
		String query3 = (Kontsultak.insertIncluye + "('" + numTrans + "', '" + platerKodea + "', '" + kantitatea
				+ "', '" + prezioa + "')");
		String query4 = ("Insert into ofrece values('" + nif + "','" + platerKodea + "')");
		try {
			Statement s;
			s = konekzioa.createStatement();
			s.executeUpdate(query1);
			Statement s1;
			s1 = konekzioa.createStatement();
			s1.executeUpdate(query2);
			Statement s2;
			s2 = konekzioa.createStatement();
			s2.executeUpdate(query3);
			Statement s3;
			s3 = konekzioa.createStatement();
			s3.executeUpdate(query4);
		} catch (SQLException e) {
			System.out.println("Errorea konexioan");
			e.printStackTrace();
		}
	}

}
