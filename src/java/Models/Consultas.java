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
            int timh3 = 1;
            
            String consulta ="select producto.idproducto, nombre,descripcion, valoracion, imagen1,estado from producto " +
                "INNER JOIN valoracion ON producto.idproducto = valoracion.idproducto and estado=? "+
                "ORDER BY ? DESC " +
                "LIMIT ?";
            pst = getConexion().prepareStatement(consulta);
            //pst.setString(1, valora_id);
            pst.setInt(1, timh3);
            pst.setInt(2, timh1);
            pst.setInt(3, timh2);
            
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
            int timh3 = 1;
            
            String consulta ="select idproducto, nombre, descripcion, fecha, imagen1 from producto WHERE estado=? " +
                "ORDER BY ? DESC " +
                "LIMIT ?";
            pst = getConexion().prepareStatement(consulta);
            //pst.setString(1, valora_id);
            pst.setInt(1, timh3);
            pst.setInt(2, timh1);
            pst.setInt(3, timh2);
            
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
    
    public List<producto> proEnVenta(){
       PreparedStatement pst = null;
       ResultSet rs = null;
       List<producto> listaproducto = new ArrayList<producto>();
       
        try {
            int timh1 = 4;
            int timh2 = 3;
            int timh3 = 1;
            
            String consulta ="select idproducto, nombre, descripcion, fecha, imagen1 from producto WHERE estado=? ";
            pst = getConexion().prepareStatement(consulta);
            //pst.setString(1, valora_id);
            pst.setInt(1, timh3);
            
            
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
    
    public List<producto> proEnBorrador(){
       PreparedStatement pst = null;
       ResultSet rs = null;
       List<producto> listaproducto = new ArrayList<producto>();
       
        try {
            int timh1 = 4;
            int timh2 = 3;
            int timh3 = 0;
            
            String consulta ="select idproducto, nombre, descripcion, fecha, imagen1 from producto WHERE estado=? ";
            pst = getConexion().prepareStatement(consulta);
            //pst.setString(1, valora_id);
            pst.setInt(1, timh3);
        
            
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
           
            String consulta = "select idproducto,nombre, descripcion, imagen1,unidades,idcategoria,estado from producto " +
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
                proS.setUnidades(rs.getInt("unidades"));
                proS.setIdCategoria(rs.getInt("idcategoria"));
                proS.setEstado(rs.getBoolean("estado"));
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
    
    public boolean productoBorrar(int idprod){
        PreparedStatement pst = null;
        ResultSet rs = null;
    
       try {
            String consulta = "DELETE FROM producto WHERE idproducto=?";
            pst = getConexion().prepareStatement(consulta);
            pst.setInt(1, idprod);
            if(pst.executeUpdate()==1){
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
    public boolean productoVenta(String nombre, String descripcion, int unidades, boolean estado, int categoria, InputStream imagen){
        PreparedStatement pst = null;
       try {
           
                  
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
    
    public boolean productoEditado(String nombre, String descripcion, int unidades, boolean estado, int categoria, InputStream imagen, int idProducto){
        PreparedStatement pst = null;
       try {
           
                  
           String consulta = "update producto SET nombre=?, descripcion=?, unidades=?, estado=?, idcategoria=?, imagen1=? " +
                                "WHERE idproducto = ?";
           pst = getConexion().prepareStatement(consulta);
           pst.setString(1, nombre);
           pst.setString(2, descripcion);
           pst.setInt(3, unidades);
           pst.setBoolean(4, estado);
           pst.setInt(5, categoria);
           pst.setBinaryStream(6, imagen);
           pst.setInt(7, idProducto);
           
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
    
    public byte [] getUserImage(String usuario){
        byte[] imageBytes = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
           
            String consulta = "select avatar from usuario where username=?";
            pst = getConexion().prepareStatement(consulta);
            pst.setString(1, usuario);
            rs= pst.executeQuery();
            
            while(rs.next())
            {
                imageBytes = rs.getBytes("avatar");
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
    
    public int getIdUser(String usuario){
        int idUsua = 0;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
           
            String consulta = "select idusuario from usuario where username=?";
            pst = getConexion().prepareStatement(consulta);
            pst.setString(1, usuario);
            rs= pst.executeQuery();
            
            while(rs.next())
            {
                idUsua = rs.getInt("idusuario");
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
        return idUsua;
    }
    
      public boolean addCart(int idUsuario, int idProducto){
       PreparedStatement pst = null;
       try {
           boolean admin = false;
         
           String consulta = "insert into carrito(idproducto, idusuario) " +
                             "values (?,?)";
           pst = getConexion().prepareStatement(consulta);
           pst.setInt(1, idProducto);
           pst.setInt(2, idUsuario);
       
           
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
   
    public List<producto> cartShow(int idUsuario){
        List<producto> listaproducto = new ArrayList<producto>();
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        try {
           
            String consulta = "select producto.idproducto, nombre, descripcion, imagen1,idcarrito from producto " +
                "INNER JOIN carrito ON producto.idproducto = carrito.idproducto AND carrito.idusuario = ?";
            pst = getConexion().prepareStatement(consulta);
            pst.setInt(1, idUsuario);
            rs= pst.executeQuery();
            
            while(rs.next())
            {
            int idpro = rs.getInt("producto.idproducto");
            String nombre = rs.getString("nombre");
            String desc = rs.getString("descripcion");
            byte[] image = rs.getBytes("imagen1");
            int idcart = rs.getInt("idcarrito");
            producto productoDash = new producto(nombre,desc,image,idpro,idcart);
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
    
    public boolean cartDel(int idCart){
        PreparedStatement pst = null;
        ResultSet rs = null;
    
       try {
            String consulta = "DELETE FROM carrito WHERE idcarrito=?";
            pst = getConexion().prepareStatement(consulta);
            pst.setInt(1, idCart);
            if(pst.executeUpdate()==1){
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
    
      
    public static void main(String[] args) {
        
        Consultas co = new Consultas();
        
       //List<producto> listb = co.proEnVenta();
        
       /*for(producto lib : listb){
           System.out.println(lib.getNombre());
           System.out.println(lib.getDescripcion());
       }*/
       
       /*producto Pro = new producto();
       Pro = co.productoSearch(5);
        
        System.out.println(Pro.getNombre());
        System.out.println(Pro.getIdproducto());
        System.out.println(Pro.getIdCategoria());
        System.out.println(Pro.getDescripcion());
        System.out.println(Pro.getUnidades());
        System.out.println(Pro.isEstado());*/
       //co.productoEditado("Bocinas negras duplicadas", "jalo", 9, true, 3, imagen, 22)
            
    }
}
