package examen.model.dao;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import examen.modelo.bean.Producto;

@Component
public class ProductoModelo {
	
	@Autowired
	JdbcTemplate db;
	
	/*
	*
	*INSERT,DELETE Y UPDATE -->return db.update(sql); #Devuelve el numero de celdas modificadas INT
	*
	*SELECT --> SqlRowSet rs=db.queryForRowSet(sql); STRING
	*
	**/
	
	//Mostrar todo
	public ArrayList<Producto> selectAll(){
		ArrayList<Producto> p = new ArrayList<Producto>();
		
		String sql="Select * from producto where deleted=0";
		SqlRowSet rs=db.queryForRowSet(sql);
		
		while(rs.next()){p.add(new Producto(
				rs.getInt("id_producto"),
				rs.getString("nombre"),
				rs.getString("descripcion"),
				rs.getDouble("precio"),
				rs.getInt("likes"),
				rs.getInt("stock"),
				rs.getString("img"),
				rs.getInt("id_categoria"),
				rs.getBoolean("deleted")
				));
		}
		return p;
	}
	//seleccionar id
	public Producto productoId(int id_producto) {
		String sql="Select * from producto where deleted=0 and id_producto="+id_producto;
		SqlRowSet rs=db.queryForRowSet(sql);
		/*String sql="Select * from producto where deleted=0 and id_producto=?";*/
		/*SqlRowSet rs=db.queryForRowSet(sql,id_producto);*/
		
		Producto p = null;
		if(rs.next()){
			return new Producto( 
			rs.getInt("id_producto"),
			rs.getString("nombre"),
			rs.getString("descripcion"),
			rs.getDouble("precio"),
			rs.getInt("likes"),
			rs.getInt("stock"),
			rs.getString("img"),
			rs.getInt("id_categoria"),
			rs.getBoolean("deleted")
			);
		}
		   return null;

	}
	
	
	//borrar
	public int borrarProducto(int id_producto) {
		String sql="UPDATE `producto` SET deleted=1 where deleted=0 and id_producto="+id_producto;
		return db.update(sql);
	}
	//editar
	public int editarProducto(int id_producto,String nombre,String descripcion,double precio) {
		String sql="UPDATE `producto` SET nombre=?,descripcion=?,precio=? where id_producto=?";
		return db.update(sql,nombre,descripcion,precio,id_producto);
	
	}
	//añadir
	public int anadirProducto (String nombre, String descripcion,double precio,int stock,String img,int id_categoria) {
		String sql="INSERT INTO `producto`(`Nombre`, `Descripcion`, `precio`,`stock`, `img`,`id_categoria`) VALUES (?,?,?,?,?,?)";
				return db.update(sql,nombre,descripcion,precio,stock,img,id_categoria);
	}
	//recoger ultima id
	public int ultimaId() {
		String sql="Select MAX(id_producto) as ultima_id from producto";
		SqlRowSet rs=db.queryForRowSet(sql);
		
		rs.next();

		   return rs.getInt("ultima_id");

	}
	
	public ArrayList<Producto> filtrar(int id_categoria) {
		ArrayList<Producto> p = new ArrayList<Producto>();
		String sql="Select * from producto where deleted=0 and id_categoria="+id_categoria;
		SqlRowSet rs=db.queryForRowSet(sql);
		
		while(rs.next()){p.add(new Producto(
			rs.getInt("id_producto"),
			rs.getString("nombre"),
			rs.getString("descripcion"),
			rs.getDouble("precio"),
			rs.getInt("likes"),
			rs.getInt("stock"),
			rs.getString("img"),
			rs.getInt("id_categoria"),
			rs.getBoolean("deleted")
			));
		}
		   return p;

	} 
	
	
	public ArrayList<Producto> ordenar(String ordenar) {
		ArrayList<Producto> p = new ArrayList<Producto>();
		String sql = "Select * from producto where deleted=0 order by ? ";/* desc o asc */
		SqlRowSet rs=db.queryForRowSet(sql,ordenar);
		
		while(rs.next()){p.add(new Producto(
			rs.getInt("id_producto"),
			rs.getString("nombre"),
			rs.getString("descripcion"),
			rs.getDouble("precio"),
			rs.getInt("likes"),
			rs.getInt("stock"),
			rs.getString("img"),
			rs.getInt("id_categoria"),
			rs.getBoolean("deleted")
			));
		}
		   return p;

	} 
	
}
