/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author fernandourg
 */
public class producto {
    
    private String nombre;
    private String descripcion;
    private String categoria;
    private int precio;
    private byte[] imagen;
    private byte[] imagen2;
    private byte[] imagen3;
    private String valoracion;
    private int idproducto;
    private int unidades;
    private boolean estado;
    private int idCategoria;
    private int idCarrito;
    private String video;
    

   
    public producto() {
    }

    public producto(String nombre, String descripcion, byte[] imagen, int idproducto, int idCarrito, int precio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.imagen = imagen;
        this.idproducto = idproducto;
        this.idCarrito = idCarrito;
    }
    
    public producto(String nombre, String descripcion, byte[] imagen, int idproducto, int idCarrito) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        //this.precio = precio;
        this.imagen = imagen;
        this.idproducto = idproducto;
        this.idCarrito = idCarrito;
    }
    
    

    public producto(String nombre, String descripcion, String categoria, byte[] imagen) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.imagen = imagen;
    }

    public producto(String nombre, String descripcion, String categoria, int precio, byte[] imagen) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.precio = precio;
        this.imagen = imagen;
    }

    public producto(String nombre, String descripcion, byte[] imagen, String valoracion, int idproducto) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.valoracion = valoracion;
        this.idproducto = idproducto;
    }

    public producto(String nombre, String descripcion, byte[] imagen, int idproducto) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.idproducto = idproducto;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    

    public int getIdCarrito() {
        return idCarrito;
    }

    public void setIdCarrito(int idCarrito) {
        this.idCarrito = idCarrito;
    }
    
    
     public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getValoracion() {
        return valoracion;
    }

    public void setValoracion(String valoracion) {
        this.valoracion = valoracion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public byte[] getImagen2() {
        return imagen2;
    }

    public void setImagen2(byte[] imagen2) {
        this.imagen2 = imagen2;
    }

    public byte[] getImagen3() {
        return imagen3;
    }

    public void setImagen3(byte[] imagen3) {
        this.imagen3 = imagen3;
    }
 
    
    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }
    
    
    
}
