package Modelo;

public class Kontsultak {

	static final String selectProduktuKantitatea = "SELECT count(nombre) from producto where Tipo = 'Comida' or Tipo = 'Bebida'";

	static final String selectProduktuak = "SELECT * from producto where Tipo = 'Comida' or Tipo = 'Bebida'";
	
	static final String selectPlaterKantitatea = "SELECT count(nombre) from producto where Tipo = 'Plato'";

	static final String selectPlaterrak = "SELECT * from producto where Tipo = 'Plato'";
	
	static final String selectNIFBakarrik = "SELECT nif from local";
	
	static final String selectDNI = "SELECT dni from usuario";

	static final String selectErabiltzailea = "SELECT DNI,Contraseña FROM usuario where dni = " ;

	static final String selectNIF = "SELECT NIF FROM usuario where dni = ";

	static final String selectTipoLokala = "SELECT Tipo from local where NIF = ";

	static final String selectLokalarenIzena = "SELECT nombre FROM local where NIF = ";

	static final String selectLokalarenNif = "SELECT Tipo from local where NIF = ";

	static final String selectLokalaMota = selectLokalarenNif + "(SELECT NIF from usuario where DNI = ";

	static final String selectMaxNumTrans="SELECT max(NumTrans) from operaciones;";
	
	static final String selectIzenaFabrikantea = "SELECT Nombre from fabricante where Nombre = ";
	
	static final String selectFabrikantea = selectIzenaFabrikantea + "(SELECT N_Fabricante from producto where Nombre = ";
	
	static final String selectStock = "SELECT stock from vende where NomProducto =";
	
	static final String selectPlaterraMota = "SELECT nombre from plato where TipoDePlato = ";
	
	static final String selectPlaterMotak = "SELECT distinct TipoDePlato from plato";
	
	static final String selectPlaterKodea = "SELECT Cod_Plato FROM plato where Nombre = ";

	// *****************************************************************************************************************************************************************************************************

	static final String insertDatuak = "INSERT INTO usuario VALUES";
	
	static final String insertOperaciones = "INSERT INTO operaciones VALUES";

	static final String insertNifFaktura = "INSERT INTO niffactura VALUES";

	static final String insertFactura = "INSERT INTO factura VALUES";
                     
	static final String insertEskaera = "INSERT INTO pedidos VALUES";
	
	static final String insertTiene = "INSERT INTO tiene VALUES";
	
	static final String insertHornikuntza = "INSERT INTO aprovisionamiento VALUES";
	
	static final String insertKomanda = "INSERT INTO comanda VALUES";
	
	static final String insertIncluye = "INSERT INTO incluye VALUES";
	
	// *****************************************************************************************************************************************************************************************************
	
	static final String updateTiene = "update vende set Stock = Stock + ";
	
	//static final String updateKenduStock = "update vende set Stock = Stock - ";
}
