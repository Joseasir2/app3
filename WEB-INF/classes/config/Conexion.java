package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	public Connection Conexion() {
		Connection con = null;
		String url = "jdbc:mysql://localhost:3306/bd_taller";
		String user = "root"; // Cambia esto a tu usuario de base de datos
		String pass = ""; // Cambia esto a tu contraseña de base de datos

		try {
			// Intenta cargar el controlador
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, pass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("No se encontró el controlador JDBC.");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("No se pudo establecer la conexión con la base de datos.");
		}
		return con;
	}
}