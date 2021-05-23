package examen.controllers;
import java.util.HashMap;
import java.util.Map;
import javax.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import examen.model.dao.CategoriaModelo;
import examen.model.dao.LoginModelo;
import examen.model.dao.ProductoModelo;
import examen.model.dao.SeccionModelo;
import examen.modelo.bean.Login;

@RestController
@RequestMapping("/api")
public class RestControllers {


	/* 
	 * aplication
	 * 
	 * 
	 *
	 * @GetMapping --> Recibir o select
	 * @PostMapping --> Añadir
	 * @PutMapping --> Editar o Modificar
	 * @DeleteMapping --> Borrar
	 * */
	
	
	@Autowired
	SeccionModelo sm;
	
	@Autowired
	ProductoModelo pm;
	
	@Autowired
	CategoriaModelo cm;
	
	@Autowired
	LoginModelo lm;
	
	/*
	 * Todos los productos
	 * */
	@GetMapping("/producto")
	public Map<String,Object> productos(){
		Map<String,Object> m = new HashMap<String,Object>();
		
		m.put("peticion", "recibida");
		m.put("allProducto", pm.selectAll());
		
		return m;
	
	}
	
	/*
	 * 	Producto a producto http://localhost:8080/api/producto/1 o 2 o 3 o 4 ...
	 * */
	
	@GetMapping("/producto/{id_categoria}")
	public Map<String,Object> producto(@PathVariable int id_categoria){
		Map<String,Object> m = new HashMap<String,Object>();
		
		m.put("peticion", "recibida");
		m.put("producto", pm.productoId(id_categoria));
		
		return m;
	
	}
	
	
	@DeleteMapping("/producto/{id_categoria}")
	public Map<String,Object> deleteProducto(@PathVariable int id_categoria){
		Map<String,Object> m = new HashMap<String,Object>();
		
		m.put("peticion", "recibida");
		m.put("deleteProducto", pm.borrarProducto(id_categoria));
		
		return m;
	}	
	
	
	@PutMapping("/producto/{id_categoria}")
	public Map<String,Object> editarProducto(@PathVariable int id_categoria,String nombre,String descripcion,double precio){
		Map<String,Object> m = new HashMap<String,Object>();
		
		m.put("peticion", "recibida");
		m.put("deleteProducto", pm.editarProducto(id_categoria,nombre,descripcion,precio));
		
		return m;
	}
	
	@PostMapping("/producto")
	public Map<String,Object> anadirProducto(String nombre, String descripcion,double precio,int stock,String img,int id_categoria){
		Map<String,Object> m = new HashMap<String,Object>();
		
		m.put("peticion", "recibida");
		m.put("anadirProducto", pm.anadirProducto(nombre,descripcion,precio,stock,img,id_categoria));
		m.put("nuevoproducto", pm.ultimaId());
		
		return m;
	}

	
	/*
	 * @PutMapping("/login") public Map<String,Object> login(@RequestParam
	 * Map<String, String> param){ Map<String,Object> m = new
	 * HashMap<String,Object>(); m.put("peticion", "recibida"); if(lm.loggear(new
	 * Login(param.get("username"), param.get("password"))) == 1) { m.put("status",
	 * 1); } else { m.put("status", 0); }
	 * 
	 * return m; }
	 */
	
	@GetMapping("/producto/filtrar/{id_categoria}")
	public Map<String,Object> categoria(@PathVariable int id_categoria){
		Map<String,Object> m = new HashMap<String,Object>();
		m.put("peticion", "recibida");
		m.put("categoria", pm.filtrar(id_categoria));
		return m;
	
	}
	
	
}

