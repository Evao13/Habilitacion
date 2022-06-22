package interfaces;

import java.util.List;

import modelo.Flores;

public interface CRUD {

	public List listar();
	public Flores list(int id);
	public boolean add(Flores per);
	public boolean adit(Flores per);
	public boolean eliminar(int id);
	
}
