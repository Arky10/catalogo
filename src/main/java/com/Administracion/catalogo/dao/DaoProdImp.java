package com.Administracion.catalogo.dao;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Administracion.catalogo.pojo.Producto;

@Repository
public class DaoProdImp implements DaoProdI {
	@Autowired
    private EntityManager entityManager;
	
	@Override
	public Producto buscaProducto(String idProducto) {
		  Session currentSession = entityManager.unwrap(Session.class);

		  Producto producto = currentSession.get(Producto.class, idProducto);

	        return producto;
	}

	@Override
	public Producto guardaProducto(Producto producto) {
		  Session currentSession = entityManager.unwrap(Session.class);

	        currentSession.saveOrUpdate(producto);  
	        return producto;

	}

	@Override
	public Producto actualizaProducto(Producto producto) {
		  Session currentSession = entityManager.unwrap(Session.class);

	        currentSession.saveOrUpdate(producto);  
	        return producto;

	}

}
