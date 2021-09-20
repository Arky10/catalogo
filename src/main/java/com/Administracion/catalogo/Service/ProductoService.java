package com.Administracion.catalogo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Administracion.catalogo.dao.DaoProdImp;
import com.Administracion.catalogo.pojo.Producto;
import com.Administracion.catalogo.pojo.RespuestaApi;



@Service
public class ProductoService implements ProductoServiceI {

	 @Autowired
	    private DaoProdImp Dao;
	
	@Override
	public Producto buscaProducto(String idProducto) {
		Producto prodcuto=Dao.buscaProducto(idProducto);
		return prodcuto;
	}

	@Override
	public Producto guardaProducto(Producto producto) {
		Producto prodcuto=Dao.guardaProducto(producto);
		return prodcuto;

	}

	@Override
	public Producto actualizaProducto(Producto producto) {
		Producto prodcuto=Dao.actualizaProducto(producto);
		return prodcuto;

	}

}
