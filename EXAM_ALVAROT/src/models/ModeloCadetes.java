package models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ModeloCadetes {
	//CONSULTA
	private final static String CONSULTA = "select * from cadetes";
	//COLUMNAS DE LA TABLA
	private final String ID = "id";
	private final String NOMBRE = "nombre";
	private final String APELLIDOS = "apellidos";
	private final String EDAD = "edad";
	private final String NACIONALIDAD = "nacionalidad";
	private final String EQUIPO = "equipo";
	//COLUMNAS JUNTAS
	private final String columnas[] = {ID,NOMBRE,APELLIDOS,EDAD,NACIONALIDAD,EQUIPO};
	//CONEXION CON LA BBDD
	private Connection conexion;
	//ELEMENTOS DE LA CONEXION
	Statement instruccion = null;
	ResultSet conjuntoInstrucciones = null;
	//ARRAYLIST DE DATOS
	ArrayList<String[]> conjuntoDatos;
	
	public ModeloCadetes (Connection con){
		conjuntoDatos = new ArrayList<String[]>();
		conexion = con;
		getConsulta();
	}
	/**
	 * METODO PARA RECOGER LOS DATOS DE NUESTRA CONSULTA Y GUARDARLOS EN CONJUNTODATOS
	 */
	private void getConsulta(){
		try{
			instruccion = conexion.createStatement();
			
			conjuntoInstrucciones = instruccion.executeQuery(CONSULTA);
			
			while(conjuntoInstrucciones.next()){
				String datos[] = new String[columnas.length];
				datos[0] = String.valueOf(conjuntoInstrucciones.getInt(ID));
				datos[1] = conjuntoInstrucciones.getString(NOMBRE);
				datos[2] = conjuntoInstrucciones.getString(APELLIDOS);
				datos[3] = String.valueOf(conjuntoInstrucciones.getInt(EDAD));
				datos[4] = conjuntoInstrucciones.getString(NACIONALIDAD);
				datos[5] = String.valueOf(conjuntoInstrucciones.getInt(EQUIPO));
				conjuntoDatos.add(datos);
			}
			}catch(SQLException p){
				p.printStackTrace();
			}finally{
				try{
					instruccion.close();
					conjuntoInstrucciones.close();
				}catch(SQLException l){
					l.printStackTrace();
				}
		}
	}
	/*
	 * METODO QUE NOS DEVUELVE LA FILA DE LA CONSULTA DEL ID QUE LE PASEMOS
	 */
	public String[] consulta(String id){
		String fila[] = new String[columnas.length];
		
		for(int i = 0;i<conjuntoDatos.size();i++){
			if(conjuntoDatos.get(i)[0].equals(id)){
				fila = conjuntoDatos.get(i);
			}
		}
		
		return fila;
	}
	/*
	 * METODO QUE NOS DEBUELVE UN ARRAYLIST CON LAS FILAS QUE TENGAN EL EQUIPO QUE LE PASEMOS
	 */
	public ArrayList<String[]> consulta2(String equipo){
		ArrayList<String[]> filas = new ArrayList<String[]>();
		
		for(int i = 0;i<conjuntoDatos.size();i++){
			if(conjuntoDatos.get(i)[5].equals(equipo)){
				filas.add(conjuntoDatos.get(i));
			}
		}
		
		return filas;
	}
	
}
