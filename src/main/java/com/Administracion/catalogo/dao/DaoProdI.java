package com.Administracion.catalogo.dao;


import com.Administracion.catalogo.pojo.Producto;


public interface DaoProdI {


    public Producto buscaProducto(String idProducto);

    public Producto guardaProducto(Producto producto);

    public Producto actualizaProducto(Producto producto);
}