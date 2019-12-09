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
public class Mensaje {
    
    private String mensaje;
    private String fecha;
    private int idmensaje;
    private int idusuario;
    private int idchat;
    private int idcarrito;
    private int precio;

    public Mensaje(String mensaje, String fecha, int idmensaje, int idusuario) {
        this.mensaje = mensaje;
        this.fecha = fecha;
        this.idmensaje = idmensaje;
        this.idusuario = idusuario;
    }
    
    public Mensaje(String mensaje, String fecha, int idmensaje, int idusuario, int idchat) {
        this.mensaje = mensaje;
        this.fecha = fecha;
        this.idmensaje = idmensaje;
        this.idusuario = idusuario;
        this.idchat = idchat;
    }

    public Mensaje(String mensaje, String fecha, int idmensaje, int idusuario, int idchat, int idcarrito, int precio) {
        this.mensaje = mensaje;
        this.fecha = fecha;
        this.idmensaje = idmensaje;
        this.idusuario = idusuario;
        this.idchat = idchat;
        this.idcarrito = idcarrito;
        this.precio = precio;
    }
    

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getIdmensaje() {
        return idmensaje;
    }

    public void setIdmensaje(int idmensaje) {
        this.idmensaje = idmensaje;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public int getIdchat() {
        return idchat;
    }

    public void setIdchat(int idchat) {
        this.idchat = idchat;
    }

    public int getIdcarrito() {
        return idcarrito;
    }

    public void setIdcarrito(int idcarrito) {
        this.idcarrito = idcarrito;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
    
    
    
    
}
