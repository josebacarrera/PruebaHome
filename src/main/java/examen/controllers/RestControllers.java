package examen.controllers;
import java.util.HashMap;
import java.util.Map;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import examen.model.dao.CategoriaModelo;
import examen.model.dao.ProductoModelo;
import examen.model.dao.SeccionModelo;

@RestController
@RequestMapping("/api")
public class RestControllers {

	/* 
	 * aplication
	 * 
	 * 
	 * 
	 * */
	
	
	@Autowired
	SeccionModelo sm;
	
	@Autowired
	ProductoModelo pm;
	
	@Autowired
	CategoriaModelo cm;
	
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
	
}

