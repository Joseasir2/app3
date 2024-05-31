package Modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TrabajadorDAO {
	Conexion cn = new Conexion();
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	int response;

	public Trabajador validar(String user, String password) {
		Trabajador tr = null;
		String sql = "SELECT * FROM trabajadores WHERE User = ? AND Pass = ?";

		try {
			con = cn.Conexion();
			if (con == null) {
				throw new SQLException("No se pudo establecer la conexión con la base de datos.");
			}
			ps = con.prepareStatement(sql);
			ps.setString(1, user);
			ps.setString(2, password); // Corregido a ps.setString(2, password)
			rs = ps.executeQuery();

			if (rs.next()) {
				tr = new Trabajador();
				tr.setId(rs.getInt("IdTrabajador"));
				tr.setUser(rs.getString("User"));
				tr.setPass(rs.getString("Pass"));
				tr.setNombre(rs.getString("Nombre"));
				tr.setTelefono(rs.getString("Telefono"));
				tr.setEstado(rs.getString("Estado"));
			}
		} catch (SQLException e) {
			e.printStackTrace(); // Imprimir la traza de la excepción para depuración
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return tr;
	}
	
	//Operaciones CRUD
	
	public List listar () {
		String sql = "select * from trabajadores";
		List lista = new ArrayList<>();
		try {
			con=cn.Conexion();
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			
			while (rs.next()) {
				Trabajador tr = new Trabajador();
				tr.setId(rs.getInt(1));
				//System.out.println(rs.getInt(1));
				tr.setPass(rs.getString(2));
				//System.out.println(rs.getString(2));
				tr.setNombre(rs.getString(3));
				//System.out.println(rs.getString(3));
				tr.setTelefono(rs.getString(4));
				//System.out.println(rs.getString(4));
				tr.setEstado(rs.getString(5));
				//System.out.println(rs.getString(5));
				tr.setUser(rs.getString(6));
				//System.out.println(rs.getString(6));
				lista.add(tr);
			}
		} catch (Exception e) {	
		}
		return lista;
	}
	
	public int agregar (Trabajador tr) {
		String sql="insert into trabajadores(Pass,Nombre,Telefono,Estado,User)values(?,?,?,?,?)";
		try {
			con=cn.Conexion();
			ps=con.prepareStatement(sql);
			ps.setString(1, tr.getPass());
			ps.setString(2, tr.getNombre());
			ps.setString(3, tr.getTelefono());
			ps.setString(4, tr.getEstado());
			ps.setString(5, tr.getUser());
			ps.executeUpdate();
		}catch (Exception e)  {
			
		}
		return response;
	}
	
	public Trabajador listarId(int id) {
		Trabajador tr = new Trabajador();
		String sql = "select * from trabajadores where IdTrabajador="+id;
		try {
			con=cn.Conexion();
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while (rs.next()) {
				tr.setPass(rs.getString(2));
				tr.setNombre(rs.getString(3));
				tr.setTelefono(rs.getString(4));
				tr.setEstado(rs.getString(5));
				tr.setUser(rs.getString(6));
			}
		} catch (Exception e) {
			
		}
		
		return tr;
	}
	
	public int actualizar (Trabajador tr) {
		
		String sql="update trabajadores set Pass=?, Nombre=?,Telefono=? ,Estado=?,User=? Where IdTrabajador=?";
		try {
			con=cn.Conexion();
			ps=con.prepareStatement(sql);
			ps.setString(1, tr.getPass());
			ps.setString(2, tr.getNombre());
			ps.setString(3, tr.getTelefono());
			ps.setString(4, tr.getEstado());
			ps.setString(5, tr.getUser());
			ps.setInt(6, tr.getId());
			ps.executeUpdate();
		}catch (Exception e)  {
			
		}
		return response;
	}
	
	public void delete(int id) {
		String sql="delete from trabajadores where IdTrabajador="+id;
		try {
			con=cn.Conexion();
			ps=con.prepareStatement(sql);
			ps.executeUpdate();
		}catch (Exception e) {
			
		}
	}
}
