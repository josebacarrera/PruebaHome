package examen.controllers;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import examen.model.dao.CategoriaModelo;
import examen.model.dao.LoginModelo;
import examen.model.dao.ProductoModelo;
import examen.model.dao.SeccionModelo;

@Controller
public class MainControllers {

	@Autowired
	SeccionModelo sm;
	
	@Autowired
	ProductoModelo pm;
	
	@Autowired
	CategoriaModelo cm;
	
	@Autowired
	LoginModelo lm;
	
	@RequestMapping("/")
	 public String principal (Model Modelo, String username, String password) {
			
			 if (username!=null && password!=null) {
				 
				 if(lm.loggear(username,password) == true) {
					 
					 Modelo.addAttribute("esAdmin",lm.esAdmin(username, password));
					 
				 }
			 } 
		
				Modelo.addAttribute("producto", pm.selectAll());
				Modelo.addAttribute("seccion", sm.selectAll());
				Modelo.addAttribute("categoria", cm.selectAll());
		
		return "index";
	}
	
	
}
