package examen.model.dao;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import examen.modelo.bean.Categoria;
import examen.modelo.bean.Seccion;

@Component
public class SeccionModelo {

	@Autowired
	JdbcTemplate db;
	
	
	public ArrayList<Seccion> selectAll(){
		ArrayList<Seccion> s = new ArrayList<Seccion>();
		
		String sql="Select * from Seccion";
		SqlRowSet rs=db.queryForRowSet(sql);
		
		while(rs.next()){s.add(new Seccion(
				rs.getInt("id_seccion"),
				rs.getString("nombre")
				));
		}
		return s;
	}
	
}
