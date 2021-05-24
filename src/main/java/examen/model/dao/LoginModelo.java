package examen.model.dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import examen.modelo.bean.Login;

@Component
public class LoginModelo {

	@Autowired
	JdbcTemplate db;
	
	public boolean loggear(String username,String password) {
	String sql="select * from login where username=? and password=?";
	SqlRowSet rs=db.queryForRowSet(sql,username,password);
	return rs.next();
	
	}
	
	public boolean esAdmin(String username,String password) {
	String sql="select * from login where username=? and password=? and admin=1";
	SqlRowSet rs=db.queryForRowSet(sql,username,password);
	return rs.next();

	}
	
}
