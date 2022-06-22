package modelo;

public class Flores {
	
	private int id;
	private String nombre_flor;
	private int stock;
	private int valor_unidad;
	private String fecha_ingreso;
	
	public Flores() {
	}

	public Flores(String nombre_flor, int stock, int valor_unidad) {
		this.nombre_flor = nombre_flor;
		this.stock = stock;
		this.valor_unidad = valor_unidad;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre_flor() {
		return nombre_flor;
	}

	public void setNombre_flor(String nombre_flor) {
		this.nombre_flor = nombre_flor;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getValor_unidad() {
		return valor_unidad;
	}

	public void setValor_unidad(int valor_unidad) {
		this.valor_unidad = valor_unidad;
	}

	public String getFecha_ingreso() {
		return fecha_ingreso;
	}

	public void setFecha_ingreso(String fecha_ingreso) {
		this.fecha_ingreso = fecha_ingreso;
	}
	
	
	
	
}
