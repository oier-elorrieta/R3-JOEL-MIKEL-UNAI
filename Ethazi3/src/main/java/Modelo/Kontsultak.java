package Modelo;

public class Kontsultak {

	 static final String selectErabiltzailea = "SELECT DNI,Contrase�a FROM usuario where dni = " ;
	
	 static final String selectNIF = "SELECT NIF FROM usuario where dni = ";
	 
	 static final String selectTipoLokala = "SELECT Tipo from local where NIF = ";
	 
	 static final String selectLokalarenIzena = "SELECT nombre FROM local where NIF = ";
	 
	 static final String selectLokalarenNif = "SELECT Tipo from local where NIF = ";
	 
	 static final String selectLokalaMota = selectLokalarenNif + "(SELECT NIF from usuario where DNI = ";
	 
	// *****************************************************************************************************************************************************************************************************
	 
	 static final String insertDatuak = "INSERT INTO usuario VALUES";
	 
	 static final String insertOperaciones = "INSERT INTO operaciones VALUES";
	 
	 static final String insertNifFaktura = "INSERT INTO niffactura VALUES";
	 
	 static final String insertFactura = "INSERT INTO factura VALUES";
	 
	 static final String insertEskaera = "INSERT INTO pedidos VALUES";
}