package examen.modelo.bean;

public class Producto {

	private int id_producto;
	private String nombre;
	private String descripcion;
	private double precio;
	private int likes;
	private int stock;
	private String img;
	private int id_categoria;
	private boolean deleted;
	public Producto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Producto(int id_producto, String nombre, String descripcion, double precio, int likes, int stock, String img,
			int id_categoria, boolean deleted) {
		super();
		this.id_producto = id_producto;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.likes = likes;
		this.stock = stock;
		this.img = img;
		this.id_categoria = id_categoria;
		this.deleted = deleted;
	}
	public int getId_producto() {
		return id_producto;
	}
	public void setId_producto(int id_producto) {
		this.id_producto = id_producto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getLikes() {
		return likes;
	}
	public void setLikes(int likes) {
		this.likes = likes;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public int getId_categoria() {
		return id_categoria;
	}
	public void setId_categoria(int id_categoria) {
		this.id_categoria = id_categoria;
	}
	public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	
	
	
}