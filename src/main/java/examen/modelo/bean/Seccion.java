package examen.modelo.bean;

public class Seccion {

	private int id_seccion;
	private String nombre;
	
	public Seccion() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Seccion(int id_seccion, String nombre) {
		super();
		this.id_seccion = id_seccion;
		this.nombre = nombre;
	}
	public int getId_seccion() {
		return id_seccion;
	}
	public void setId_seccion(int id_seccion) {
		this.id_seccion = id_seccion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
