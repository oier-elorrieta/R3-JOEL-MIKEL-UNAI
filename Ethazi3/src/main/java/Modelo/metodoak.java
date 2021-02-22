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

	public static Platerra[] objektuak2() {
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
				Platerra p1 = new Platerra(platerKodea, platerMota, izena);
				platerrak[kont] = p1;
				kont++;
			}
		} catch (SQLException e) {
			System.out.println("Errorea konexioan");
			e.printStackTrace();
		}
		return platerrak;
	}

	public static String[] sartuPlaterrak() {
		Platerra platerrak[] = objektuak2();

		String platerIzena[] = new String[platerKantitatea()];
		for (int i = 0; i < platerIzena.length; i++) {
			platerIzena[i] = platerrak[i].getIzena();
		}
		return platerIzena;
	}

	// ******************************************************************************************************************************************************************************************************

	public static int platerKantitatea() {
		Connection konekzioa = BBDDKonexioa.getConexion();

		String query1 = ("SELECT count(Cod_Plato) from plato");
		int i = 0;

		try {
			ResultSet re;
			PreparedStatement p;

			p = konekzioa.prepareStatement(query1);
			re = p.executeQuery();
			if (re.next()) {
				i = re.getInt("count(Cod_Plato)");
			}
		} catch (SQLException e) {
			System.out.println("Errorea konexioan");
			e.printStackTrace();
		}
		return i;
	}

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

	public static boolean begiratuDNI(String dni) {
		Connection konekzioa = BBDDKonexioa.getConexion();
		String query1 = ("SELECT dni from usuario");
		boolean badago = false;
		try {
			ResultSet re;
			PreparedStatement p;

			p = konekzioa.prepareStatement(query1);
			re = p.executeQuery();
			while (re.next()) { 
				if(dni.equals(re.getString("DNI"))) {
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

	public static boolean begiratuNIF(String nif) {
		Connection konekzioa = BBDDKonexioa.getConexion();
		String query1 = ("SELECT nif from local");
		boolean ondoDago = false;
		try {
			ResultSet re;
			PreparedStatement p;

			p = konekzioa.prepareStatement(query1);
			re = p.executeQuery();
			while (re.next()) { 
				if(nif.equals(re.getString("NIF"))) {
					ondoDago = false;
				}else {
					ondoDago = true;
				}
			}
		} catch (SQLException e) {
			System.out.println("Errorea konexioan");
			e.printStackTrace();
		} 
		return ondoDago;
	}

	public static int begiratuStock(String produktua, String nif) {
		Connection konekzioa = BBDDKonexioa.getConexion();
		String query1 = ("SELECT stock from vende where NomProducto = '" + produktua + "' and nifLocal = '"+ nif +"' "); 
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

	// *****************************************************************************************************************************************************************************************************

	public static void sartuTiene(int i,ArrayList<Karritoa> karroa) throws ClassNotFoundException, SQLException {

		Connection konekzioa = BBDDKonexioa.getConexion();

		kk(karroa); 

		while(i < karroa.size()) {
			String query1 = (Kontsultak.insertTiene + "('"+karroa.get(i).getElikagaia()+"', " + (jasoTransakzioZbk()-1) + ", "+karroa.get(i).getKopuru()+", "+karroa.get(i).getBalioa()+")");

			try {
				Statement s;
				s = konekzioa.createStatement();
				s.executeUpdate(query1);
			} catch (SQLException e) {
				System.out.println("Errorea konexioan");
				e.printStackTrace();
			}
			i++;
		}
	}

	public static void kk(ArrayList<Karritoa> karroa) {  
		for (int i = 0;i < karroa.size(); i++) {
			for (int j = 1;j < karroa.size(); j++) {
				System.out.println(karroa.size());
				System.out.println(karroa.get(i).getElikagaia()+"         "+karroa.get(j).getElikagaia());
				if(karroa.get(i).getElikagaia().equals(karroa.get(j).getElikagaia())) { 
					karroa.get(i).setBalioa(karroa.get(i).getBalioa()+karroa.get(j).getBalioa()); 
					karroa.get(i).setKopuru(karroa.get(i).getKopuru()+karroa.get(j).getKopuru());
					karroa.remove(j);  
				} 
			}
		} 
		System.out.println(karroa.toString());
	}


	public static String jasoHornikuntzarakoFabrikantea(String produktua) {
		Connection konekzioa = BBDDKonexioa.getConexion();
		String izenaFabrikantea = null;
		String query1 = (Kontsultak.selectFabrikantea + "'"+produktua+"')");
		try {
			ResultSet re;
			PreparedStatement p;
			p = konekzioa.prepareStatement(query1);
			re = p.executeQuery(); 
			if(re.next()) {
				izenaFabrikantea = re.getString("Nombre"); 
			}
		} catch (SQLException e) {
			System.out.println("Errorea konexioan");
			e.printStackTrace();
		}
		return izenaFabrikantea;
	}

	public static void sartuHornikuntza(String produktua,int año, int mes, int dia, String nif,double diruTotala) throws ClassNotFoundException, SQLException {

		Connection konekzioa = BBDDKonexioa.getConexion();
		String izenaFabrikantea = jasoHornikuntzarakoFabrikantea(produktua);
		int numTrans = jasoTransakzioZbk();

		String query2 = (Kontsultak.insertOperaciones + "('" + numTrans + "', '" + año + "/" + (mes + 1) + "/"
				+ dia + "','" + diruTotala + "','" + nif + "')");
		String query3 = (Kontsultak.insertHornikuntza + "("+numTrans+",'"+izenaFabrikantea+"')");		
		try {
			Statement s;
			s = konekzioa.createStatement();
			s.executeUpdate(query2);
			Statement s1;
			System.out.println(numTrans);
			s1 = konekzioa.createStatement();
			s1.executeUpdate(query3);
		} catch (SQLException e) {
			System.out.println("Errorea konexioan");
			e.printStackTrace();
		}
	}

	public static String[] platerMotak() {
		Connection konekzioa = BBDDKonexioa.getConexion();
		String query1 = ("SELECT distinct TipoDePlato from plato");
		String platerMotak[] = new String[3];
		int i = 0;
		try {
			ResultSet re;
			PreparedStatement p;
			p = konekzioa.prepareStatement(query1);
			re = p.executeQuery(); 
			while(re.next()) {
				platerMotak[i]= re.getString("TipoDePlato");
				i++;
			}
		} catch (SQLException e) {
			System.out.println("Errorea konexioan");
			e.printStackTrace();
		}
		return platerMotak;
	}

	public static String[] platerMota(String platerMota, String tipoa) {
		Connection konekzioa = BBDDKonexioa.getConexion();
		String query1 = ("SELECT nombre from plato where TipoDePlato = '"+platerMota+"' and TipoPosicion = '"+tipoa+"'");
		String platerMotak[] = new String[zenbatPlaterMotaBakoitzeko(platerMota)];
		int i = 0;
		try {
			ResultSet re;
			PreparedStatement p;
			p = konekzioa.prepareStatement(query1);
			re = p.executeQuery(); 
			while(re.next()) {
				platerMotak[i]= re.getString("Nombre");
				i++;
			}
		} catch (SQLException e) {
			System.out.println("Errorea konexioan");
			e.printStackTrace();
		}
		return platerMotak;
	}
	
	
	public static String[] platerMotaArabera(String platerMota) {
		Connection konekzioa = BBDDKonexioa.getConexion();
		String query1 = ("SELECT nombre from plato where TipoDePlato = '"+platerMota+"'");
		String platerMotak[] = new String[zenbatPlaterMotaBakoitzeko(platerMota)];
		int i = 0;
		try {
			ResultSet re;
			PreparedStatement p;
			p = konekzioa.prepareStatement(query1);
			re = p.executeQuery(); 
			while(re.next()) {
				platerMotak[i]= re.getString("Nombre");
				i++;
			}
		} catch (SQLException e) {
			System.out.println("Errorea konexioan");
			e.printStackTrace();
		}
		return platerMotak;
	}
	

	public static int zenbatPlaterMotaBakoitzeko(String platerMota) {
		Connection konekzioa = BBDDKonexioa.getConexion();
		String query1 = ("SELECT count('"+platerMota+"') from plato where TipoDePlato = '"+platerMota+"';");
		int i = 0;
		try {
			ResultSet re;
			PreparedStatement p;
			p = konekzioa.prepareStatement(query1);
			re = p.executeQuery(); 
			if(re.next()) {
				i= re.getInt("count('"+platerMota+"')");
			}
		} catch (SQLException e) {
			System.out.println("Errorea konexioan");
			e.printStackTrace();
		}
		return i;
	}

	public static String jasoPlaterKodea(String platerra) {
		Connection konekzioa = BBDDKonexioa.getConexion();
		String query1 = ("SELECT Cod_Plato FROM plato where Nombre = '"+platerra+"'");
		String platerKodea = null;
		try {
			ResultSet re;
			PreparedStatement p;
			p = konekzioa.prepareStatement(query1);
			re = p.executeQuery(); 
			if(re.next()) {
				platerKodea = re.getString("Cod_Plato");
			}
		} catch (SQLException e) {
			System.out.println("Errorea konexioan");
			e.printStackTrace();
		}
		return platerKodea;
	}

	public static void sartuKomanda(String platerKodea, int kantitatea, double prezioa, int numTrans, String nif, int año, int mes, int dia){
		Connection konekzioa = BBDDKonexioa.getConexion();
		String query1 = (Kontsultak.insertOperaciones + "('" + numTrans + "', '" + año + "/" + (mes + 1) + "/"
				+ dia + "','" + prezioa + "','" + nif + "')");
		String query2 = ("INSERT INTO comanda VALUES('"+numTrans+"')");
		String query3 = ("INSERT INTO incluye VALUES('"+numTrans+"', '"+platerKodea+"', '"+kantitatea+"', '"+prezioa+"')");
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
		} catch (SQLException e) {
			System.out.println("Errorea konexioan");
			e.printStackTrace();
		}
	} 

}
