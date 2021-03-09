package TestModelo;

import static org.junit.Assert.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import org.junit.Test;
import Modelo.BBDDKonexioa;
import Modelo.Erabiltzaile;
import Modelo.Karritoa;
import Modelo.Produktua;
import Modelo.metodoak;

public class ModeloTest {

	Produktua[] elikagaiak = metodoak.elikagaiak();

	Produktua[] platerrak = metodoak.platerrak();

	// *****************************************************************************************************************************************************************************************************

	@Test
	public void testSartuSalgaiak() {
		String aukera = elikagaiak[0].getIzena();

		String esperotakoa = "Ardoa";

		metodoak.sartuSalgaiak();

		assertEquals(esperotakoa, aukera);
	}

	@Test
	public void testSartuSalgaiak1() {
		String aukera = elikagaiak[2].getIzena();

		String esperotakoa = "Garagardoa";

		metodoak.sartuSalgaiak();

		assertEquals(esperotakoa, aukera);
	}

	// *****************************************************************************************************************************************************************************************************

	// *****************************************************************************************************************************************************************************************************

	@Test
	public void testSartuPlaterrak() {
		String aukera = platerrak[0].getIzena();

		System.out.println(aukera);

		String esperotakoa = "Arroz con leche";

		metodoak.sartuPlaterrak();

		assertEquals(esperotakoa, aukera);
	}

	@Test
	public void testSartuPlaterrak1() {
		String aukera = platerrak[2].getIzena();

		System.out.println(aukera);

		String esperotakoa = "Carbonara Vegana";

		metodoak.sartuPlaterrak();

		assertEquals(esperotakoa, aukera);
	}

	// *****************************************************************************************************************************************************************************************************

	@Test
	public void testezabatu() {

		Karritoa sidra = new Karritoa("Sidra", 0, 3);

		ArrayList<Karritoa> aukera = new ArrayList<Karritoa>(10);

		aukera.add(sidra);
		aukera.add(sidra);
		aukera.add(sidra);
		aukera.add(sidra);
		aukera.add(sidra);
		aukera.add(sidra);
		aukera.add(sidra);
		aukera.add(sidra);
		aukera.add(sidra);
		aukera.add(sidra);

		ArrayList<Karritoa> esperotakoa = new ArrayList<Karritoa>(10);

		assertEquals(esperotakoa, metodoak.ezabatuArraya(aukera));

	}

	// *****************************************************************************************************************************************************************************************************

	@Test
	public void testpantailatu() {

		Karritoa sidra = new Karritoa("Sidra", 1, 3);

		ArrayList<Karritoa> aukera = new ArrayList<Karritoa>(10);

		aukera.add(sidra);

		String esperotakoa = "";

		assertNotEquals(esperotakoa, metodoak.pantailatuProduktua(aukera));

	}

	// *****************************************************************************************************************************************************************************************************

	@Test
	public void testSartuProduktuaArrayan() {

		Karritoa sidra = new Karritoa("Sidra", 1, 2);

		ArrayList<Karritoa> esperotakoa1 = new ArrayList<Karritoa>(10);

		esperotakoa1.add(sidra);

		ArrayList<Karritoa> aukera1 = new ArrayList<Karritoa>(10);

		aukera1 = metodoak.sartuProduktuaArrayan("Sidra", 1, aukera1);

		Karritoa esperotakoa = esperotakoa1.get(0);

		Karritoa aukera = aukera1.get(0);

		assertEquals(aukera.getBalioa(), esperotakoa.getBalioa(), 0);
		assertEquals(aukera.getElikagaia(), esperotakoa.getElikagaia());
		assertEquals(aukera.getKopuru(), esperotakoa.getKopuru());

	}

	// *****************************************************************************************************************************************************************************************************

	@Test
	public void testsartuDirua() {

		int esperotakoa = 6;

		assertEquals(esperotakoa, metodoak.sartuDirua("Sidra", 3), 0);

	}

	// *****************************************************************************************************************************************************************************************************

	@Test
	public void testDiruTotalak() {

		Karritoa sidra = new Karritoa("Sidra", 0, 3);

		ArrayList<Karritoa> aukera = new ArrayList<Karritoa>(10);

		aukera.add(sidra);
		aukera.add(sidra);
		aukera.add(sidra);
		aukera.add(sidra);
		aukera.add(sidra);
		aukera.add(sidra);
		aukera.add(sidra);
		aukera.add(sidra);
		aukera.add(sidra);
		aukera.add(sidra);

		int esperotakoa = 30;

		assertEquals(esperotakoa, metodoak.diruTotala(aukera), 0);

	}

	// *****************************************************************************************************************************************************************************************************

	@Test
	public void testArgazkiaAukeratu() {

		ImageIcon esperotakoa = new ImageIcon("argazkiak/Zukua.jpg");

		assertEquals(esperotakoa.getImage(), metodoak.argazkiaAukeratu("Zukua").getImage());

	}

	// *****************************************************************************************************************************************************************************************************

	@Test
	public void testGehituTransferentziaZenbakia() {

		int esperotakoa = 1;

		assertEquals(esperotakoa, metodoak.gehituTransferentziaZenbakia(0));

	}

	// *****************************************************************************************************************************************************************************************************

	@Test
	public void testJasoProduktuenPrezioa() {

		double esperotakoa = 0.7 * 2; // Ardoa kostatzen du 0.7.

		assertEquals(esperotakoa, metodoak.jasoProduktuenPrezioa("Ardoa", 2), 0);
	}

	// *****************************************************************************************************************************************************************************************************
	// ***********************************DATU_BASE_TESTAK**************************************************************************************************************************************************
	// *****************************************************************************************************************************************************************************************************

	// ______________________________________________________________________________________________________________________________________________________________________________________________________
	// ______________________________________________________________________________________________________________________________________________________________________________________________________

	@Test
	public void begiratuDNI() {

		Connection konekzioa = BBDDKonexioa.getConexion();

		// _______________________________________________________________________________________________________________________________________________________________________________

		String query2 = ("SELECT DNI FROM usuario LIMIT 1");

		String lehenengoDNI = null;

		try {
			ResultSet rs;
			PreparedStatement q;

			q = konekzioa.prepareStatement(query2);
			rs = q.executeQuery();
			if (rs.next()) {
				lehenengoDNI = rs.getString("DNI");
			}
		} catch (SQLException e) {
			System.out.println("Errorea konexioan");
			e.printStackTrace();
		}

		// _______________________________________________________________________________________________________________________________________________________________________________

		assertTrue(metodoak.begiratuDNI(lehenengoDNI));

	}

	// *****************************************************************************************************************************************************************************************************

	@Test
	public void begiratuNIF() {

		Connection konekzioa = BBDDKonexioa.getConexion();

		// _______________________________________________________________________________________________________________________________________________________________________________

		String query2 = ("SELECT NIF FROM local LIMIT 1");

		String lehenengoNIF = null;

		try {
			ResultSet rs;
			PreparedStatement q;

			q = konekzioa.prepareStatement(query2);
			rs = q.executeQuery();
			if (rs.next()) {
				lehenengoNIF = rs.getString("NIF");
			}
		} catch (SQLException e) {
			System.out.println("Errorea konexioan");
			e.printStackTrace();
		}

		// _______________________________________________________________________________________________________________________________________________________________________________

		assertTrue(metodoak.begiratuNIF(lehenengoNIF));

	}

	// *****************************************************************************************************************************************************************************************************

	@Test
	public void begiratuStock() {

		Connection konekzioa = BBDDKonexioa.getConexion();

		// _______________________________________________________________________________________________________________________________________________________________________________

		String query1 = ("SELECT NomProducto FROM vende LIMIT 1");

		String lehenengoProduktua = null;

		try {
			ResultSet rs;
			PreparedStatement q;

			q = konekzioa.prepareStatement(query1);
			rs = q.executeQuery();
			if (rs.next()) {
				lehenengoProduktua = rs.getString("NomProducto");
			}
		} catch (SQLException e) {
			System.out.println("Errorea konexioan");
			e.printStackTrace();
		}

		// _______________________________________________________________________________________________________________________________________________________________________________

		String query2 = ("SELECT NIF FROM local LIMIT 1");

		String lehenengoNIF = null;

		try {
			ResultSet rs;
			PreparedStatement q;

			q = konekzioa.prepareStatement(query2);
			rs = q.executeQuery();
			if (rs.next()) {
				lehenengoNIF = rs.getString("NIF");
			}
		} catch (SQLException e) {
			System.out.println("Errorea konexioan");
			e.printStackTrace();
		}

		// _______________________________________________________________________________________________________________________________________________________________________________

		String query4 = ("SELECT Stock FROM vende where NIFLocal = '" + lehenengoNIF + "' and NomProducto = '"
				+ lehenengoProduktua + "' ");

		int esperotakoa = 0;

		try {
			ResultSet rs;
			PreparedStatement q;

			q = konekzioa.prepareStatement(query4);
			rs = q.executeQuery();
			if (rs.next()) {
				esperotakoa = rs.getInt("Stock");
			}
		} catch (SQLException e) {
			System.out.println("Errorea konexioan");
			e.printStackTrace();
		}

		// _______________________________________________________________________________________________________________________________________________________________________________

		assertEquals(esperotakoa, metodoak.begiratuStock(lehenengoProduktua, lehenengoNIF));

	}

	// *****************************************************************************************************************************************************************************************************

	@Test
	public void komprobatuLokalarenIzena() {

		Connection konekzioa = BBDDKonexioa.getConexion();

		// _______________________________________________________________________________________________________________________________________________________________________________

		String query2 = ("SELECT NIF FROM local LIMIT 1");

		String lehenengoNIF = null;

		try {
			ResultSet rs;
			PreparedStatement q;

			q = konekzioa.prepareStatement(query2);
			rs = q.executeQuery();
			if (rs.next()) {
				lehenengoNIF = rs.getString("NIF");
			}
		} catch (SQLException e) {
			System.out.println("Errorea konexioan");
			e.printStackTrace();
		}

		// _______________________________________________________________________________________________________________________________________________________________________________

		String query1 = ("SELECT nombre FROM local where NIF = '" + lehenengoNIF + "'");

		String esperotakoa = null;

		try {
			ResultSet re;
			PreparedStatement p;

			p = konekzioa.prepareStatement(query1);
			re = p.executeQuery();
			if (re.next()) {
				esperotakoa = re.getString("nombre");
			}
		} catch (SQLException e) {
			System.out.println("Errorea konexioan");
			e.printStackTrace();
		}

		// _______________________________________________________________________________________________________________________________________________________________________________

		assertEquals(esperotakoa, metodoak.konprobatuLokalarenIzena(lehenengoNIF));

	}

	// *****************************************************************************************************************************************************************************************************

	@Test
	public void komprobatuLokala() {

		Connection konekzioa = BBDDKonexioa.getConexion();

		// _______________________________________________________________________________________________________________________________________________________________________________

		String query2 = ("SELECT NIF FROM local LIMIT 1");

		String lehenengoNIF = null;

		try {
			ResultSet rs;
			PreparedStatement q;

			q = konekzioa.prepareStatement(query2);
			rs = q.executeQuery();
			if (rs.next()) {
				lehenengoNIF = rs.getString("NIF");
			}
		} catch (SQLException e) {
			System.out.println("Errorea konexioan");
			e.printStackTrace();
		}

		// _______________________________________________________________________________________________________________________________________________________________________________

		String query1 = ("SELECT Tipo from local where NIF = (SELECT NIF from usuario where DNI ='" + lehenengoNIF
				+ "');");
		String esperotakoa = null;

		try {
			ResultSet re;
			PreparedStatement p;

			p = konekzioa.prepareStatement(query1);
			re = p.executeQuery();
			if (re.next()) {
				esperotakoa = re.getString("Tipo");
			}
		} catch (SQLException e) {
			System.out.println("Errorea konexioan");
			e.printStackTrace();
		}

		// _______________________________________________________________________________________________________________________________________________________________________________ç

		assertEquals(esperotakoa, metodoak.konprobatuLokala(lehenengoNIF));

	}

	// *****************************************************************************************************************************************************************************************************

	@Test
	public void komprobatuNIF() {

		Connection konekzioa = BBDDKonexioa.getConexion();

		// _______________________________________________________________________________________________________________________________________________________________________________

		String query2 = ("SELECT DNI FROM usuario LIMIT 1");

		String lehenengoDNI = null;

		try {
			ResultSet rs;
			PreparedStatement q;

			q = konekzioa.prepareStatement(query2);
			rs = q.executeQuery();
			if (rs.next()) {
				lehenengoDNI = rs.getString("DNI");
			}
		} catch (SQLException e) {
			System.out.println("Errorea konexioan");
			e.printStackTrace();
		}

		// _______________________________________________________________________________________________________________________________________________________________________________

		String query1 = ("SELECT NIF FROM usuario where dni = '" + lehenengoDNI + "'");

		String esperotakoa = null;

		try {
			ResultSet re;
			PreparedStatement p;

			p = konekzioa.prepareStatement(query1);
			re = p.executeQuery();
			if (re.next()) {
				esperotakoa = re.getString("NIF");
			}
		} catch (SQLException e) {
			System.out.println("Errorea konexioan");
			e.printStackTrace();
		}

		// _______________________________________________________________________________________________________________________________________________________________________________

		assertEquals(esperotakoa, metodoak.konprobatuNIF(lehenengoDNI));

	}

	// *****************************************************************************************************************************************************************************************************

	@Test
	public void konprobatuErabiltzailea() {

		Connection konekzioa = BBDDKonexioa.getConexion();

		// _______________________________________________________________________________________________________________________________________________________________________________

		String query2 = ("SELECT DNI FROM usuario LIMIT 1");

		String lehenengoDNI = null;

		try {
			ResultSet rs;
			PreparedStatement q;

			q = konekzioa.prepareStatement(query2);
			rs = q.executeQuery();
			if (rs.next()) {
				lehenengoDNI = rs.getString("DNI");
			}
		} catch (SQLException e) {
			System.out.println("Errorea konexioan");
			e.printStackTrace();
		}

		// _______________________________________________________________________________________________________________________________________________________________________________

		String query3 = ("SELECT Contraseña FROM usuario LIMIT 1");

		String lehenengoPasahitza = null;

		try {
			ResultSet rs;
			PreparedStatement q;

			q = konekzioa.prepareStatement(query3);
			rs = q.executeQuery();
			if (rs.next()) {
				lehenengoPasahitza = rs.getString("Contraseña");
			}
		} catch (SQLException e) {
			System.out.println("Errorea konexioan");
			e.printStackTrace();
		}

		// _______________________________________________________________________________________________________________________________________________________________________________

		String query1 = ("SELECT DNI,Contraseña FROM usuario where dni = '" + lehenengoDNI + "'");
		String esperotakoa = null;

		try {
			ResultSet re;
			PreparedStatement p;

			p = konekzioa.prepareStatement(query1);
			re = p.executeQuery();

			if (re.next()) {
				if (re.getString("DNI").equalsIgnoreCase(lehenengoDNI)
						&& re.getString("Contraseña").equalsIgnoreCase(lehenengoPasahitza)) {
					esperotakoa = "EZ";
				} else if (re.getString("DNI").equalsIgnoreCase(lehenengoDNI)
						&& !re.getString("Contraseña").equalsIgnoreCase(lehenengoPasahitza)) {
					esperotakoa = "Bai, pasahitza txarto";
				}
			} else {
				esperotakoa = "Bai, erabiltzailea txarto";
			}

		} catch (SQLException e) {
			System.out.println("Errorea konexioan");
			e.printStackTrace();
		}

		// _______________________________________________________________________________________________________________________________________________________________________________

		assertEquals(esperotakoa, metodoak.konprobatuErabiltzailea(lehenengoDNI, lehenengoPasahitza));

	}

	// ______________________________________________________________________________________________________________________________________________________________________________________________________
	// ______________________________________________________________________________________________________________________________________________________________________________________________________

	@SuppressWarnings("deprecation")
	@Test
	public void platerMotak() {

		// _______________________________________________________________________________________________________________________________________________________________________________

		String esperotakoPlaterMotak[] = new String[3];

		esperotakoPlaterMotak[0] = "Vegetariano";
		esperotakoPlaterMotak[1] = "Vegano";
		esperotakoPlaterMotak[2] = "Normal";
				
		// _______________________________________________________________________________________________________________________________________________________________________________

		assertEquals(esperotakoPlaterMotak, metodoak.platerMotak());

	}
	
	// *****************************************************************************************************************************************************************************************************
	
	@SuppressWarnings("deprecation")
	@Test
	public void platerMotaArabera() {

		Connection konekzioa = BBDDKonexioa.getConexion();

		// _______________________________________________________________________________________________________________________________________________________________________________

		String query1 = ("SELECT nombre from plato where TipoDePlato = 'Vegetariano' LIMIT 1");
		String platerMotak[] = new String[10];
		try {
			ResultSet re;
			PreparedStatement p;
			p = konekzioa.prepareStatement(query1);
			re = p.executeQuery();
			if (re.next()) {
				platerMotak[0] = re.getString("Nombre");
			}
		} catch (SQLException e) {
			System.out.println("Errorea konexioan");
			e.printStackTrace();
		}
		
		// _______________________________________________________________________________________________________________________________________________________________________________
		
		String query2 = ("SELECT nombre from plato where TipoDePlato = 'Vegetariano' and nombre = '"+platerMotak[0]+"'");
		String platerMotak1[] = new String[10];
		try {
			ResultSet re;
			PreparedStatement p;
			p = konekzioa.prepareStatement(query2);
			re = p.executeQuery();
			if (re.next()) {
				platerMotak1[0] = re.getString("Nombre");
			}
		} catch (SQLException e) {
			System.out.println("Errorea konexioan");
			e.printStackTrace();
		}
		
		// _______________________________________________________________________________________________________________________________________________________________________________
		
		assertEquals(metodoak.platerMotaArabera(platerMotak1[0]), metodoak.platerMotaArabera(platerMotak[0]));

	}

	// *****************************************************************************************************************************************************************************************************
	
	@Test
	public void jasoPlaterKodea() {

		Connection konekzioa = BBDDKonexioa.getConexion();

		// _______________________________________________________________________________________________________________________________________________________________________________

		String lehenengoPlaterra = null;
		String query1 = ("SELECT Nombre from plato LIMIT 1");
		try {
			ResultSet re;
			PreparedStatement p;
			p = konekzioa.prepareStatement(query1);
			re = p.executeQuery();
			if (re.next()) {
				lehenengoPlaterra = re.getString("Nombre");
			}
		} catch (SQLException e) {
			System.out.println("Errorea konexioan");
			e.printStackTrace();
		}

		// _______________________________________________________________________________________________________________________________________________________________________________

		// _______________________________________________________________________________________________________________________________________________________________________________

		String esperotakoPlaterra = null;
		String query = ("SELECT Nombre from plato where Nombre = '" + lehenengoPlaterra + "'");
		try {
			ResultSet re;
			PreparedStatement p;
			p = konekzioa.prepareStatement(query);
			re = p.executeQuery();
			if (re.next()) {
				esperotakoPlaterra = re.getString("Nombre");
			}
		} catch (SQLException e) {
			System.out.println("Errorea konexioan");
			e.printStackTrace();
		}
		// _______________________________________________________________________________________________________________________________________________________________________________

		assertEquals(metodoak.jasoPlaterKodea(esperotakoPlaterra), metodoak.jasoPlaterKodea(lehenengoPlaterra));

	}

	// *****************************************************************************************************************************************************************************************************

	@Test
	public void zenbatPlaterMotaBakoitzeko() {

		Connection konekzioa = BBDDKonexioa.getConexion();

		// _______________________________________________________________________________________________________________________________________________________________________________

		String query1 = ("SELECT count('TipoDePlato') from plato where TipoDePlato = 'Vegetariano';");
		int i = 0;
		try {
			ResultSet re;
			PreparedStatement p;
			p = konekzioa.prepareStatement(query1);
			re = p.executeQuery();
			if (re.next()) {
				i = re.getInt("count('TipoDePlato')");
			}
		} catch (SQLException e) {
			System.out.println("Errorea konexioan");
			e.printStackTrace();
		}

		assertEquals(metodoak.zenbatPlaterMotaBakoitzeko("Vegetariano"), i);

	}

	// ______________________________________________________________________________________________________________________________________________________________________________________________________
	// ______________________________________________________________________________________________________________________________________________________________________________________________________

	@Test
	public void jasoTransakzioZbk() throws ClassNotFoundException, SQLException {

		Connection konekzioa = BBDDKonexioa.getConexion();

		// _______________________________________________________________________________________________________________________________________________________________________________

		String query1 = ("SELECT max(NumTrans) from operaciones;");

		int esperotakoa = 0;

		try {
			ResultSet rs;
			PreparedStatement q;

			q = konekzioa.prepareStatement(query1);
			rs = q.executeQuery();
			if (rs.next()) {
				if (rs.getInt("max(NumTrans)") == 0) {
					esperotakoa = 1;
				} else {
					esperotakoa = rs.getInt("max(NumTrans)");
					esperotakoa++;
				}
			}
		} catch (SQLException e) {
			System.out.println("Errorea konexioan");
			e.printStackTrace();
		}

		// _______________________________________________________________________________________________________________________________________________________________________________

		assertEquals(esperotakoa, metodoak.jasoTransakzioZbk());

	}

	// ______________________________________________________________________________________________________________________________________________________________________________________________________
	// ______________________________________________________________________________________________________________________________________________________________________________________________________

	@Test
	public void sartuErabiltzailea(){

		Erabiltzaile esperotakoa = new Erabiltzaile("esperotakoa", "esperotakoa1");
		
		// _______________________________________________________________________________________________________________________________________________________________________________

		assertEquals(esperotakoa, metodoak.sartuErabiltzailea("esperotakoa", "esperotakoa1", esperotakoa));

	}
	
	// ______________________________________________________________________________________________________________________________________________________________________________________________________
	// ______________________________________________________________________________________________________________________________________________________________________________________________________

	@Test
	public void begiratuTiene(){

		assertFalse(metodoak.begiratuTiene(null, 0));

	}
	
	// ______________________________________________________________________________________________________________________________________________________________________________________________________
	// ______________________________________________________________________________________________________________________________________________________________________________________________________
	
	@Test
	public void begiratuIncluye() throws ClassNotFoundException, SQLException{

		assertFalse(metodoak.begiratuIncluye(0, 0));

	}
	
	// ______________________________________________________________________________________________________________________________________________________________________________________________________
	// ______________________________________________________________________________________________________________________________________________________________________________________________________
		
	
	@Test
	public void begiratuOfrece(){

		assertFalse(metodoak.begiratuOfrece(null, 0));

	}
		
	// ______________________________________________________________________________________________________________________________________________________________________________________________________
	// ______________________________________________________________________________________________________________________________________________________________________________________________________
		
	@Test
	public void kodeak(){

		Connection konekzioa = BBDDKonexioa.getConexion();

		// _______________________________________________________________________________________________________________________________________________________________________________

		String query1 = ("select Cod_Plato from incluye where Num_Trans = (SELECT max(NumTrans) from operaciones)");
		int[] kodeak = new int[metodoak.aukeratuIncluyeKodeak()];
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

		// _______________________________________________________________________________________________________________________________________________________________________________

		assertEquals(kodeak, metodoak.kodeak());

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}