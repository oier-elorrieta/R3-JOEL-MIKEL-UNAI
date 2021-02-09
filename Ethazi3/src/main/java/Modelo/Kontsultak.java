package Modelo;

public class Kontsultak {

	 static final String SelectErabiltzailea = "SELECT DNI,Contraseña FROM usuario where dni =" ;
	
	 static final String SelectNIF = "SELECT NIF FROM usuario where dni =";
	 
	 static final String SelectTipoLokala = "SELECT Tipo from local where NIF =";
	 
	 static final String SelectLokalarenIzena = "SELECT nombre FROM local where NIF = ";
	 
	// *****************************************************************************************************************************************************************************************************
	 
	 static final String InsertOperaciones = "INSERT INTO operaciones VALUES";
	 
	 static final String InsertNifFaktura = "INSERT INTO niffactura VALUES";
	 
	 static final String InsertFactura = "INSERT INTO factura VALUES";
	 
	 static final String InsertEskaera = "INSERT INTO pedidos VALUES";
}
