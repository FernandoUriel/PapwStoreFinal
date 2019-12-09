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
public class Chat {
    
    private int idchat;
    private int idusuario;
    private int idadmin;
    private int idproducto;
    private int idcarrito;
    private String nombre;

    public Chat() {
    }
    
    

    public Chat(int idchat, int idusuario, int idadmin, int idproducto, int idcarrito, String nombre) {
        this.idchat = idchat;
        this.idusuario = idusuario;
        this.idadmin = idadmin;
        this.idproducto = idproducto;
        this.idcarrito = idcarrito;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdchat() {
        return idchat;
    }

    public void setIdchat(int idchat) {
        this.idchat = idchat;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public int getIdadmin() {
        return idadmin;
    }

    public void setIdadmin(int idadmin) {
        this.idadmin = idadmin;
    }

    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    public int getIdcarrito() {
        return idcarrito;
    }

    public void setIdcarrito(int idcarrito) {
        this.idcarrito = idcarrito;
    }
    
    
    
}
