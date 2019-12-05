/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author fernandourg
 */
public class Consultas extends Conexion{
    
    public boolean autenticacion(String usuario, String contrasena){
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String consulta = "select * from usuario where username = ? and contrasena = ?";
            pst = getConexion().prepareStatement(consulta);
            pst.setString(1, usuario);
            pst.setString(2, contrasena);
            rs = pst.executeQuery();
            
            if(rs.absolute(1)){
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Error " + e);
        }finally{
            try {
                if(getConexion() != null) getConexion().close();
                if(pst != null) pst.close();
                if(rs != null) rs.close();
            } catch (SQLException e) {
                System.out.println("Error " +e);
            }
        }
    return false;
    }

    public boolean registrar(String nombre, String apellido, String direccion, String telefono, String username, String correo, String contrasena, InputStream avatar){
       PreparedStatement pst = null;
       try {
           boolean admin = false;
         
           String consulta = "insert into usuario(nombre, apellido, direccion, telefono, username, email, contrasena, avatar, esadmin) " +
                             "values (?,?,?,?,?,?,?,?,?)";
           pst = getConexion().prepareStatement(consulta);
           pst.setString(1, nombre);
           pst.setString(2, apellido);
           pst.setString(3, direccion);
           pst.setString(4, telefono);
           pst.setString(5, username);
           pst.setString(6, correo);
           pst.setString(7, contrasena);
           pst.setBinaryStream(8, avatar);
           pst.setBoolean(9, admin);
           
           if(pst.executeUpdate()==1){
               return true;
           }
       } catch (SQLException e) {
           System.out.println("Error " + e);
       }finally{
           try {
               if(getConexion() != null) getConexion().close();
               if(pst != null) pst.close();
           } catch (Exception e) {
           }
       }
       return false;
   }
    
    public List<producto> dashValoracion(){
       PreparedStatement pst = null;
       ResultSet rs = null;
       List<producto> listaproducto = new ArrayList<producto>();
       
        try {
            int timh1 = 4;
            int timh2 = 3;
            
            String consulta ="select producto.idproducto, nombre,descripcion, valoracion, imagen1 from producto " +
                "INNER JOIN valoracion ON producto.idproducto = valoracion.idproducto " +
                "ORDER BY ? DESC " +
                "LIMIT ?";
            pst = getConexion().prepareStatement(consulta);
            //pst.setString(1, valora_id);
            pst.setInt(1, timh1);
            pst.setInt(2, timh2);
            
            rs= pst.executeQuery();
            
            while(rs.next())
            {
            int idpro = rs.getInt("producto.idproducto");
            String nombre = rs.getString("nombre");
            String desc = rs.getString("descripcion");
            byte[] image = rs.getBytes("imagen1");
            producto productoDash = new producto(nombre,desc,image,idpro);
            listaproducto.add(productoDash);
            
            }
        } catch (SQLException e) {
           System.out.println("Error " + e);
       }finally{
            try {
                if(getConexion() != null) getConexion().close();
                if(pst != null) pst.close();
                if(rs != null) rs.close();
            } catch (SQLException e) {
                System.out.println("Error " +e);
            }
        }
       
       return listaproducto;
    }
    
    public List<producto> dashFecha(){
       PreparedStatement pst = null;
       ResultSet rs = null;
       List<producto> listaproducto = new ArrayList<producto>();
       
        try {
            int timh1 = 4;
            int timh2 = 3;
            
            String consulta ="select idproducto, nombre, descripcion, fecha, imagen1 from producto " +
                "ORDER BY ? DESC " +
                "LIMIT ?";
            pst = getConexion().prepareStatement(consulta);
            //pst.setString(1, valora_id);
            pst.setInt(1, timh1);
            pst.setInt(2, timh2);
            
            rs= pst.executeQuery();
            
            while(rs.next())
            {
            int idpro = rs.getInt("producto.idproducto");
            String nombre = rs.getString("nombre");
            String desc = rs.getString("descripcion");
            byte[] image = rs.getBytes("imagen1");
            producto productoDash = new producto(nombre,desc,image,idpro);
            listaproducto.add(productoDash);
            
            }
        } catch (SQLException e) {
           System.out.println("Error " + e);
       }finally{
            try {
                if(getConexion() != null) getConexion().close();
                if(pst != null) pst.close();
                if(rs != null) rs.close();
            } catch (SQLException e) {
                System.out.println("Error " +e);
            }
        }
       
       return listaproducto;
    }
    
    public byte [] getproImage(int idProducto){
        byte[] imageBytes = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
           
            String consulta = "select imagen1 from producto where idproducto=?";
            pst = getConexion().prepareStatement(consulta);
            pst.setInt(1, idProducto);
            rs= pst.executeQuery();
            
            while(rs.next())
            {
                imageBytes = rs.getBytes("imagen1");
            }
            
       } catch (SQLException e) {
           System.out.println("Error " + e);
       }finally{
            try {
                if(getConexion() != null) getConexion().close();
                if(pst != null) pst.close();
                if(rs != null) rs.close();
            } catch (SQLException e) {
                System.out.println("Error " +e);
            }
        }
        return imageBytes;
    }
    
    public producto productoSearch(int idprod){
        producto proS = new producto();
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        try {
           
            String consulta = "select idproducto,nombre, descripcion, imagen1 from producto " +
                "where idproducto = ?";
            pst = getConexion().prepareStatement(consulta);
            pst.setInt(1, idprod);
            rs= pst.executeQuery();
            
            while(rs.next())
            {
                proS.setIdproducto(rs.getInt("idproducto"));
                proS.setNombre(rs.getString("nombre"));
                proS.setDescripcion(rs.getString("descripcion"));
                proS.setImagen(rs.getBytes("imagen1"));
            }
            
       } catch (SQLException e) {
           System.out.println("Error " + e);
       }finally{
            try {
                if(getConexion() != null) getConexion().close();
                if(pst != null) pst.close();
                if(rs != null) rs.close();
            } catch (SQLException e) {
                System.out.println("Error " +e);
            }
        }
        
        return proS;
    }
    
    public boolean productoVenta(String nombre, String descripcion, int unidades, int categoria, InputStream imagen){
        PreparedStatement pst = null;
       try {
           boolean estado = false;
                  
           String consulta = "insert into producto (nombre, descripcion, unidades, estado, fecha, idcategoria,imagen1) " +
                                "values(?,?,?,?,NOW(),?,?)";
           pst = getConexion().prepareStatement(consulta);
           pst.setString(1, nombre);
           pst.setString(2, descripcion);
           pst.setInt(3, unidades);
           pst.setBoolean(4, estado);
           pst.setInt(5, categoria);
           pst.setBinaryStream(6, imagen);
           
           if(pst.executeUpdate()==1){
               return true;
           }
       } catch (SQLException e) {
           System.out.println("Error " + e);
       }finally{
           try {
               if(getConexion() != null) getConexion().close();
               if(pst != null) pst.close();
           } catch (Exception e) {
           }
       }
    return false;
    }
    
    public List<producto> cateSearch(int catid){
        List<producto> listaproducto = new ArrayList<producto>();
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        try {
           
            String consulta = "select idproducto,producto.nombre, descripcion, imagen1 from producto " +
                "WHERE producto.idcategoria=?";
            pst = getConexion().prepareStatement(consulta);
            pst.setInt(1, catid);
            rs= pst.executeQuery();
            
            while(rs.next())
            {
            int idpro = rs.getInt("producto.idproducto");
            String nombre = rs.getString("nombre");
            String desc = rs.getString("descripcion");
            byte[] image = rs.getBytes("imagen1");
            producto productoDash = new producto(nombre,desc,image,idpro);
            listaproducto.add(productoDash);
            
            }
            
       } catch (SQLException e) {
           System.out.println("Error " + e);
       }finally{
            try {
                if(getConexion() != null) getConexion().close();
                if(pst != null) pst.close();
                if(rs != null) rs.close();
            } catch (SQLException e) {
                System.out.println("Error " +e);
            }
        }
        
        return listaproducto;
    
    }
   
    public static void main(String[] args) {
        
        Consultas co = new Consultas();
        
        System.out.println(co.autenticacion("LindaKitty", "Contrasena19"));
        
      
        
      
            
    }
}
