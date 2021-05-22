package examen.modelo.bean;

public class Categoria {

	private int id_categoria;
	private String nombre;
	private int id_seccion;
	
	public Categoria() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Categoria(int id_categoria, String nombre, int id_seccion) {
		super();
		this.id_categoria = id_categoria;
		this.nombre = nombre;
		this.id_seccion = id_seccion;
	}
	public int getId_categoria() {
		return id_categoria;
	}
	public void setId_categoria(int id_categoria) {
		this.id_categoria = id_categoria;
	}
	public String getNombreString() {
		return nombre;
	}
	public void setNombreString(String nombreString) {
		this.nombre = nombre;
	}
	public int getId_seccion() {
		return id_seccion;
	}
	public void setId_seccion(int id_seccion) {
		this.id_seccion = id_seccion;
	}
	
	
	
	
}
