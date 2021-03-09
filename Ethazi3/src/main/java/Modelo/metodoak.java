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

		Produktua elikagaiak[] = elikagaiak();

		String produktoIzena[] = new String[produktuKantitatea()];
		for (int i = 0; i < produktoIzena.length; i++) {
			produktoIzena[i] = elikagaiak[i].getIzena();
		}
		return produktoIzena;
	}

	// *****************************************************************************************************************************************************************************************************
	 
	public static String[] sartuPlaterrak() {

		Produktua platerrak[] = platerrak();
		
		String platerIzena[] = new String[platerKantitatea()];
		for (int i = 0; i < platerIzena.length; i++) {
			platerIzena[i] = platerrak[i].getIzena();
		}
		return platerIzena;
	}
	
	// *****************************************************************************************************************************************************************************************************

	public static double sartuDirua(String aukera, int kantitatea) {
		Produktua produktuak[] = produktuGuztiak();
		double dirua = 0;
		for (int i = 0; i < produktuak.length; i++) {
			if (produktuak[i].getIzena().equalsIgnoreCase(aukera)) {
				dirua = kantitatea * produktuak[i].getSaltzekoPrezioa();
				break;
			}
		}
		return dirua;
	}

	// *****************************************************************************************************************************************************************************************************

	public static double jasoProduktuenPrezioa(String aukera, int kantitatea) {
		Produktua produktuak[] = produktuGuztiak();
		double dirua = sartuDirua(aukera, kantitatea);
		for (int i = 0; i < produktuak.length; i++) {
			if (produktuak[i].getIzena().equalsIgnoreCase(aukera)) {
				dirua = kantitatea * produktuak[i].getErosPrezioa();
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

	// ******************************************************************************************************************************************************************************************************

	// ******************************************************************************************************************************************************************************************************

	// ******************************************************************************************************************************************************************************************************

	// ******************************************************************************************************************************************************************************************************


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

	// ______________________________________________________________________________________________________________________________________________________________________________________________________
	//______________________________________________________________________________________________________________________________________________________________________________________________________

	public static boolean begiratuDNI(String dni) {
		Connection konekzioa = BBDDKonexioa.getConexion();
		String query1 = (Kontsultak.selectDNI+ " where DNI = '"+dni+"'");
		boolean badago = false;
		try {
			ResultSet re;
			PreparedStatement p;

			p = konekzioa.prepareStatement(query1);
			re = p.executeQuery();
			if(re.next()) {
				badago = true;
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
		String query1 = (Kontsultak.selectNifLocal+"'"+nif+"'");
		boolean ondoDago = false;
		try {
			ResultSet re;
			PreparedStatement p;

			p = konekzioa.prepareStatement(query1);
			re = p.executeQuery();
			if(re.next()) {
				ondoDago = true;
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
		String query1 = (Kontsultak.selectStockNomProducto + " '" + produktua + "' and nifLocal = '" + nif + "' ");
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
		}
		return produktuKantitatea;
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

	// ______________________________________________________________________________________________________________________________________________________________________________________________________	
	// ______________________________________________________________________________________________________________________________________________________________________________________________________		

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

	public static int jasoPlaterKodea(String platerra) {
		Connection konekzioa = BBDDKonexioa.getConexion();
		int platerKodea = 0;
		String query1 = (Kontsultak.selectPlaterKodea + "'" + platerra + "'");
		try {
			ResultSet re;
			PreparedStatement p;
			p = konekzioa.prepareStatement(query1);
			re = p.executeQuery();
			if (re.next()) {
				platerKodea = re.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println("Errorea konexioan");
			e.printStackTrace();
		}
		return platerKodea;
	}

	// ______________________________________________________________________________________________________________________________________________________________________________________________________	
	// ______________________________________________________________________________________________________________________________________________________________________________________________________		

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

	// ______________________________________________________________________________________________________________________________________________________________________________________________________	
	// ______________________________________________________________________________________________________________________________________________________________________________________________________		

	public static Erabiltzaile sartuErabiltzailea(String erabiltzailea, String pasahitza, Erabiltzaile usuarioa) {
		usuarioa.setErabiltzailea(erabiltzailea);
		usuarioa.setPasahitza(pasahitza);
		return usuarioa;
	}

	// ______________________________________________________________________________________________________________________________________________________________________________________________________	
	// ______________________________________________________________________________________________________________________________________________________________________________________________________		

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

	// ______________________________________________________________________________________________________________________________________________________________________________________________________	
	// ______________________________________________________________________________________________________________________________________________________________________________________________________

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

	// ______________________________________________________________________________________________________________________________________________________________________________________________________	
	// ______________________________________________________________________________________________________________________________________________________________________________________________________

	public static boolean begiratuFakturanNIF(String nif) {
		Connection konekzioa = BBDDKonexioa.getConexion();
		String query1 = (Kontsultak.selectNifFaktura+"'" + nif + "'");
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

	// ______________________________________________________________________________________________________________________________________________________________________________________________________	
	// ______________________________________________________________________________________________________________________________________________________________________________________________________

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

	// ______________________________________________________________________________________________________________________________________________________________________________________________________	
	// ______________________________________________________________________________________________________________________________________________________________________________________________________

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

	public static void sartuHornikuntza(String produktua, int año, int mes, int dia, String nif, int kantitatea,
			ArrayList<Karritoa> karroa) throws ClassNotFoundException, SQLException {

		Connection konekzioa = BBDDKonexioa.getConexion();
		String izenaFabrikantea = jasoHornikuntzarakoFabrikantea(produktua);
		int numTrans = jasoTransakzioZbk();
		double dirua = jasoProduktuenPrezioa(produktua, kantitatea);
		char operazioMota = 'A';

		String query2 = (Kontsultak.insertOperaciones + "('" + numTrans + "', '" + año + "/" + (mes + 1) + "/" + dia
				+ "','" + dirua + "','" + nif + "', '" + operazioMota + "')");
		String query3 = (Kontsultak.insertHornikuntza + "(" + numTrans + ",'" + izenaFabrikantea + "')");
		String query4 = (Kontsultak.insertTiene+"('" + produktua + "'," + numTrans + "," + kantitatea + "," + dirua
				+ ")");

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

	// ______________________________________________________________________________________________________________________________________________________________________________________________________	
	// ______________________________________________________________________________________________________________________________________________________________________________________________________

	public static void hasieratuOperaciones() throws ClassNotFoundException, SQLException {
		Connection konekzioa = BBDDKonexioa.getConexion();
		int numTrans = jasoTransakzioZbk();
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

	// ______________________________________________________________________________________________________________________________________________________________________________________________________	
	// ______________________________________________________________________________________________________________________________________________________________________________________________________

	public static void sartuTiene(ArrayList<Karritoa> karroa, int numTrans, String erabiltzaile) throws ClassNotFoundException, SQLException {
		for (int i = 0; i < karroa.size(); i++) {
			String elikagaia = karroa.get(i).getElikagaia();
			int kopurua = karroa.get(i).getKopuru();
			double prezioa = karroa.get(i).getBalioa();

			if (begiratuTiene(elikagaia, numTrans) == false) {
				insertTiene(elikagaia, kopurua, prezioa);
				if (begiratuStock(elikagaia, konprobatuNIF(erabiltzaile)) < 5) {
					gehituVende(elikagaia);
				}
			} else {
				updateTiene(elikagaia, kopurua, prezioa);
			}
		}
	}

	public static void insertTiene(String elikagaia, int kopurua, double prezioa) throws ClassNotFoundException, SQLException {
		Connection konekzioa = BBDDKonexioa.getConexion();
		String query1 = (Kontsultak.insertTiene + "('" + elikagaia + "', " + (jasoTransakzioZbk() - 1) + ", " + kopurua
				+ ", " + prezioa + ")");
		try {
			Statement s;
			s = konekzioa.createStatement();
			s.executeUpdate(query1);
		} catch (SQLException e) {
			System.out.println("Errorea konexioan");
			e.printStackTrace();
		}
	}

	public static boolean begiratuTiene(String Elikagaia, int numTrans) {
		boolean egia = false;
		Connection konekzioa = BBDDKonexioa.getConexion();
		String query1 = (Kontsultak.selectTiene+"'" + Elikagaia
				+ "' and NumTrans = '" + (numTrans - 1) + "'");
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

	public static void updateTiene(String elikagaia, int kopurua, double prezioa) { 
		Connection konekzioa = BBDDKonexioa.getConexion();
		String query1 = (Kontsultak.updateTiene+"N_Unidades + " + kopurua + ", Precio = Precio + " + prezioa
				+ " where NomProducto = '" + elikagaia + "'");
		try {
			Statement s;
			s = konekzioa.createStatement();
			s.executeUpdate(query1);
		} catch (SQLException e) {
			System.out.println("Errorea konexioan");
			e.printStackTrace();
		}

	}

	// ______________________________________________________________________________________________________________________________________________________________________________________________________	
	// ______________________________________________________________________________________________________________________________________________________________________________________________________

	public static void incluye(int platerKodea, int kantitatea, double prezioa, String nif)
			throws ClassNotFoundException, SQLException {
		int numTrans = jasoTransakzioZbk() - 1;
		if (begiratuIncluye(platerKodea, numTrans) == false) {
			sartuIncluye(platerKodea, kantitatea, prezioa, nif, numTrans);
		}else {
			updateIncluye(platerKodea, kantitatea, prezioa, numTrans);
		}
	}

	public static boolean begiratuIncluye(int platerKodea,int numTrans) throws ClassNotFoundException, SQLException {
		Connection konekzioa = BBDDKonexioa.getConexion(); 
		boolean sartutaDago = false;
		String query1 = (Kontsultak.selectIncluye+"'" + numTrans + "' and Cod_Plato = '" + platerKodea
				+ "'");
		try {
			ResultSet re;
			PreparedStatement p;
			p = konekzioa.prepareStatement(query1);
			re = p.executeQuery();
			if (re.next()) {
				sartutaDago = true;
			}
		} catch (SQLException e) {
			System.out.println("Errorea konexioan");
			e.printStackTrace();
		}
		return sartutaDago;
	}

	public static void updateIncluye(int platerKodea, int kantitatea, double prezioa, int numTrans) {
		Connection konekzioa = BBDDKonexioa.getConexion();
		String query1 = (Kontsultak.updateIncluye+"Num_Platos + " + kantitatea + ", PrecioActual = PrecioActual + " + prezioa
				+ " where Cod_Plato = " + platerKodea + "");
		try {
			Statement s;
			s = konekzioa.createStatement();
			s.executeUpdate(query1);
		} catch (SQLException e) {
			System.out.println("Errorea konexioan");
			e.printStackTrace();
		}
	}

 	public static void sartuIncluye(int platerKodea, int kantitatea, double prezioa, String nif, int numTrans) {
		Connection konekzioa = BBDDKonexioa.getConexion();
		String query1 = (Kontsultak.insertIncluye + "('" + numTrans + "', '" + platerKodea + "', '" + kantitatea
				+ "', '" + prezioa + "')");
		try {
			Statement s1;
			s1 = konekzioa.createStatement();
			s1.executeUpdate(query1);
		} catch (SQLException e) {
			System.out.println("Errorea konexioan");
			e.printStackTrace();
		}
	}

	// ______________________________________________________________________________________________________________________________________________________________________________________________________	
	// ______________________________________________________________________________________________________________________________________________________________________________________________________

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

	// ______________________________________________________________________________________________________________________________________________________________________________________________________	
	// ______________________________________________________________________________________________________________________________________________________________________________________________________

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

	// ______________________________________________________________________________________________________________________________________________________________________________________________________	
	// ______________________________________________________________________________________________________________________________________________________________________________________________________



	public static void gehituVende(String elikagaia) {
		Connection konekzioa = BBDDKonexioa.getConexion();
		String query1 = (Kontsultak.updateStock+"'" + elikagaia + "' and NIFLocal = ("+Kontsultak.selectNifOperaciones+"("+Kontsultak.selectMaxNumTrans+"))");
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
