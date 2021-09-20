package com.Administracion.catalogo.Service;

import com.Administracion.catalogo.pojo.Producto;

public interface ProductoServiceI {

    public Producto buscaProducto(String idProducto);

    public Producto guardaProducto(Producto producto);

    public Producto actualizaProducto(Producto producto);
}
