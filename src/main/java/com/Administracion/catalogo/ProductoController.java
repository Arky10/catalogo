package com.Administracion.catalogo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Administracion.catalogo.Service.ProductoService;
import com.Administracion.catalogo.pojo.Producto;
import com.Administracion.catalogo.pojo.RespuestaApi;


@RestController
@RequestMapping("/WsAdministracion/Catalogo/v1") 
public class ProductoController {

	 @Autowired
	 private ProductoService productoService;
	 
	  @GetMapping("/Test")
	    public RespuestaApi Test(){

	        return new RespuestaApi(200,"Hola estoy aqui");
	    }
	 
	  @GetMapping("/productos/{idProducto}")
	    public ResponseEntity<Producto> getUser(@PathVariable String idProducto){
		  Producto producto= new Producto();
		try {
		   producto = productoService.buscaProducto(idProducto);

	        if(producto == null) {
	        	   return new ResponseEntity<>(producto, HttpStatus.NOT_FOUND);
	        }
	        return new ResponseEntity<>(producto, HttpStatus.OK);
	        
		  	}catch(Exception e) {
		  		 return new ResponseEntity<Producto>(producto, HttpStatus.INTERNAL_SERVER_ERROR);
	    	}

	 
	    }
	    @PostMapping("/productos")
	    public ResponseEntity<Producto> GuardaProducto(@RequestBody Producto producto) {
	    	
	    	try {
	    	producto.setidProducto();
	        productoService.guardaProducto(producto);
	        return new ResponseEntity<>(producto, HttpStatus.OK);
	        
	 		  	}catch(Exception e) {
	 		  		 return new ResponseEntity<Producto>(producto, HttpStatus.INTERNAL_SERVER_ERROR);
	 	    	}
	    }
	    
	    @PutMapping("/productos")
	    public ResponseEntity<Producto> ActualizaProducto(@RequestBody Producto producto) {

	    	try {
	    	Producto productoFind = productoService.buscaProducto(producto.getidProducto());
	    	   if(productoFind == null) {
	        	   return new ResponseEntity<>(producto, HttpStatus.NOT_FOUND);
	        }
	    	   productoFind.setmodelo(producto.getmodelo());
	    	   productoFind.setdescripcion(producto.getdescripcion());
	        productoService.actualizaProducto(productoFind);
	        
	        return new ResponseEntity<>(producto, HttpStatus.OK);
	        
 		  	}catch(Exception e) {
 		  		 return new ResponseEntity<Producto>(producto, HttpStatus.INTERNAL_SERVER_ERROR);
 	    	}
	    }
}
