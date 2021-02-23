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
import Modelo.Karritoa;
import Modelo.Produktua;
import Modelo.metodoak;

public class ModeloTest {

	Produktua elikagaiak[] = metodoak.elikagaiak();

	// *****************************************************************************************************************************************************************************************************

	@Test
	public void testSartuSalgaiak() {
		String aukera = elikagaiak[0].getIzena();

		String esperotakoa = "Sidra";

		metodoak.sartuSalgaiak();

		assertEquals(esperotakoa, aukera);
	}

	@Test
	public void testSartuSalgaiak1() {
		String aukera = elikagaiak[2].getIzena();

		String esperotakoa = "Ura";

		metodoak.sartuSalgaiak();

		assertEquals(esperotakoa, aukera);
	}

	// *****************************************************************************************************************************************************************************************************

	@Test
	public void ezabatu() {

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
	public void pantailatu() {

		Karritoa sidra = new Karritoa("Sidra", 1, 3);

		ArrayList<Karritoa> aukera = new ArrayList<Karritoa>(10);

		aukera.add(sidra);

		String esperotakoa = "";

		assertNotEquals(esperotakoa, metodoak.pantailatuProduktua(aukera));

	}

	// *****************************************************************************************************************************************************************************************************

	@Test
	public void TestSartuProduktuaArrayan() {

		Karritoa sidra = new Karritoa("Sidra", 1, 3);

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
	public void sartuDirua() {

		int esperotakoa = 9;

		assertEquals(esperotakoa, metodoak.sartuDirua("Sidra", 3), 0);

	}

	// *****************************************************************************************************************************************************************************************************

	@Test
	public void DiruTotalak() {

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
	public void TestArgazkiaAukeratu() {

		ImageIcon esperotakoa = new ImageIcon("argazkiak/Zukua.jpg");

		assertEquals(esperotakoa.getImage(), metodoak.argazkiaAukeratu("Zukua").getImage());

	}

	// *****************************************************************************************************************************************************************************************************

	@Test
	public void gehituTransferentziaZenbakia() {

		int esperotakoa = 1;

		assertEquals(esperotakoa, metodoak.gehituTransferentziaZenbakia(0));

	}

	// *****************************************************************************************************************************************************************************************************
	// ***********************************DATU_BASE_TESTAK**************************************************************************************************************************************************
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
		
		String query1 = ("SELECT Tipo from local where NIF = (SELECT NIF from usuario where DNI ='"+lehenengoNIF+"');");
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
		
		String query1 = ("SELECT NIF FROM usuario where dni = '"+lehenengoDNI+"'");

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
		
		String query1 = ("SELECT DNI,Contraseña FROM usuario where dni = '"+lehenengoDNI+"'");
		String esperotakoa = null;

		try {
			ResultSet re;
			PreparedStatement p;

			p = konekzioa.prepareStatement(query1);
			re = p.executeQuery();

			if (re.next()) {
				System.out.println(re.getString("DNI"));
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
	
	// *****************************************************************************************************************************************************************************************************

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
					if(rs.getInt("max(NumTrans)") == 0) {
						esperotakoa = 1;
					}else {
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
}