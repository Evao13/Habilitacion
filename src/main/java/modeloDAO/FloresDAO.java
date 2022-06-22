package modeloDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import config.Conexion;
import interfaces.CRUD;
import modelo.Flores;

public class FloresDAO implements CRUD{
	
	Conexion cn = new Conexion();
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	Flores f = new Flores();
	
	
	@Override
	public List listar() {
		ArrayList<Flores> list = new ArrayList<>();
		String sql = "Select * from flores";
		try{
			con = Conexion.getConexion();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Flores flor = new Flores();
				flor.setId(rs.getInt("id"));
				flor.setNombre_flor(rs.getString("nombre_flor"));
				flor.setStock(rs.getInt("stock"));
				flor.setValor_unidad(rs.getInt("valor_unidad"));
				flor.setFecha_ingreso(rs.getString("fecha_ingreso"));
				list.add(flor);
			}
		}catch(Exception e) {
			
		}
		return list;
	}
	@Override
	public Flores list(int id) {
		String sql = "Select * from persona where id="+id;
		try{
			con = Conexion.getConexion();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				f.setId(rs.getInt("id"));
				f.setNombre_flor(rs.getString("nombre_flor"));
				f.setStock(rs.getInt("stock"));
				f.setValor_unidad(rs.getInt("valor_unidad"));
				f.setFecha_ingreso(rs.getString("fecha_ingreso"));
				
			}
		}catch(Exception e) {
			
		}
		return f;
	}
	
	@Override
	public boolean add(Flores flor) {
		String sql = "INSERT INTO flores(nombre_flor,stock,valor_unidad) values('"+flor.getNombre_flor()+"','"+flor.getStock()+"','"+flor.getValor_unidad()+"')";
		try{
			con = Conexion.getConexion();
			ps = con.prepareStatement(sql);
			ps.executeUpdate();
		}catch(Exception e) {
			
		}
		return false;
	}
	@Override
	public boolean adit(Flores flor) {
		String sql = "UPDATE flores SET nombre_flor='"+flor.getNombre_flor()+"',stock='"+flor.getStock()+"',valor_unidad='"+flor.getValor_unidad()+ "'WHERE id="+flor.getId();
		try {
			con = Conexion.getConexion();
			ps = con.prepareStatement(sql);
			ps.executeUpdate();
		}catch(Exception e) {
			
		}
		return false;
	}
	
	@Override
	public boolean eliminar(int id) {
		String sql = "delete from flores where id="+id;
		try {
			con = Conexion.getConexion();
			ps=con.prepareStatement(sql);
			ps.executeUpdate();
		}catch(Exception e) {
			
		}
		return false;
	}
}
