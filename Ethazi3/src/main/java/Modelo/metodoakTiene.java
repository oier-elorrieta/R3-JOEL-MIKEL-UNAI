package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class metodoakTiene {

	public static void sartuTiene(ArrayList<Karritoa> karroa, int numTrans, String erabiltzaile) throws ClassNotFoundException, SQLException {
		for (int i = 0; i < karroa.size(); i++) {
			String elikagaia = karroa.get(i).getElikagaia();
			int kopurua = karroa.get(i).getKopuru();
			double prezioa = karroa.get(i).getBalioa();
			if (begiratuTiene(elikagaia, numTrans) == false) {
				insertTiene(elikagaia, kopurua, prezioa);
				if (metodoakKonprobaketak.begiratuStock(elikagaia, metodoakKonprobaketak.konprobatuNIF(erabiltzaile)) < 5) {
					gehituVende(elikagaia);
				}
			} else {
				updateTiene(elikagaia, kopurua, prezioa);
			}
		}
	}

	public static void insertTiene(String elikagaia, int kopurua, double prezioa) throws ClassNotFoundException, SQLException {
		Connection konekzioa = BBDDKonexioa.getConexion();
		String query1 = (Kontsultak.insertTiene + "('" + elikagaia + "', " + (metodoak.jasoTransakzioZbk() - 1) + ", " + kopurua
				+ ", " + prezioa + ")");
		try {
			Statement s;
			s = konekzioa.createStatement();
			s.executeUpdate(query1);
		} catch (SQLException e) { 
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
			e.printStackTrace();
		}
		return egia;
	}

	public static void updateTiene(String elikagaia, int kopurua, double prezioa) throws ClassNotFoundException, SQLException { 
		Connection konekzioa = BBDDKonexioa.getConexion();
		String query1 = (Kontsultak.updateTiene+"N_Unidades + " + kopurua + ", Precio = Precio + " + prezioa
				+ " where NomProducto = '" + elikagaia + "' and NumTrans = "+(metodoak.jasoTransakzioZbk()-1)+"");
		try {
			Statement s;
			s = konekzioa.createStatement();
			s.executeUpdate(query1);
		} catch (SQLException e) { 
			e.printStackTrace();
		}

	}

	public static void gehituVende(String elikagaia) {
		Connection konekzioa = BBDDKonexioa.getConexion();
		String query1 = (Kontsultak.updateStock+"'" + elikagaia + "' and NIFLocal = ("+Kontsultak.selectNifOperaciones+"("+Kontsultak.selectMaxNumTrans+"))");
		try {
			Statement s;
			s = konekzioa.createStatement();
			s.executeUpdate(query1);
		} catch (SQLException e) { 
			e.printStackTrace();
		}

	}
}
