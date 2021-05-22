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
	
	public Producto productoId(int id_producto) {
		String sql="Select * from producto where deleted=0 and id_producto="+id_producto;
		SqlRowSet rs=db.queryForRowSet(sql);
		
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
	
	
}
