package com.Administracion.catalogo.pojo;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.Type;

@Entity
@Table(name="producto")
public class Producto {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="idProducto")
    private String idProducto;

    @Column(name="nombre")
    private String nombre;

    @Column(name="descripcion")
    private String descripcion;

    @Column(name="modelo")
    private String modelo;

    @Column(name="precio")
    @Type(type = "big_decimal")
    private BigDecimal precio;

    public Producto() {}

    public Producto(String idProducto, String nombre, String descripcion,String modelo, BigDecimal precio) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.modelo = modelo;
        this.precio=precio;
    }

    public String getidProducto() {
        return idProducto;
    }

    public void setidProducto() {
    	String id=Integer.toString (this.nombre.hashCode()+this.descripcion.hashCode());//.substring(0,10);
        if(id.length()>=10) {
        	
        	this.idProducto =id.substring(0,10);
        }else {this.idProducto =id;}
    	
    }

    public String getnombre() {
        return nombre;
    }

    public void setnombre(String nombre) {
        this.nombre = nombre;
    }

    public String getdescripcion() {
        return descripcion;
    }

    public void setdescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getmodelo() {
        return modelo;
    }

    public void setmodelo(String modelo) {
        this.modelo = modelo;
    }
    
    public BigDecimal getprecio() {
        return precio;
    }

    public void setprecio(BigDecimal precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "User [idProducto=" + idProducto + ", nombre=" + nombre + ", descripcion=" + descripcion + ", modelo=" + modelo
                + ", precio=" + precio + "]";
    }


}
