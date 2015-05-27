import models.ConexionDB;
import views.LabyApp;


public class MainLaby {

	public static void main(String[] args) {
		//GENERAMOS LA CONEXION
		ConexionDB con = ConexionDB.getInstance("localhost","thelaby","root","tonphp");
		//EN CASO DE CREARLA CON EXITO
		if(con.connectDB()){
			LabyApp frame = new LabyApp(con.getConexion());
			frame.setVisible(true);
			
		}
		

	}

}
