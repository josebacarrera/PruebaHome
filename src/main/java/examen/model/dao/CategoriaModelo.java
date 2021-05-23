package examen.model.dao;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import examen.modelo.bean.Categoria;
import examen.modelo.bean.Producto;

@Component
public class CategoriaModelo {
	
	@Autowired
	JdbcTemplate db;
	
	public ArrayList<Categoria> selectAll(){
		ArrayList<Categoria> c = new ArrayList<Categoria>();
		
		String sql="Select * from categoria";
		SqlRowSet rs=db.queryForRowSet(sql);
		
		while(rs.next()){c.add(new Categoria(
				rs.getInt("id_categoria"),
				rs.getString("nombre"),
				rs.getInt("id_seccion")
				));
		}
		return c;
	}
	
	
	//seleccionar id
		public Categoria categoriaId(int id_categoria) {
			String sql="Select * from categoria where id_categoria="+id_categoria;
			SqlRowSet rs=db.queryForRowSet(sql);
			
			Categoria c = null;
			if(rs.next()){
				return new Categoria( 
						rs.getInt("id_categoria"),
						rs.getString("nombre"),
						rs.getInt("id_seccion")
				);
			}
			   return null;

		}
}
