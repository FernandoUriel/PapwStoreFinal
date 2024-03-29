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
            //String consulta = "select * from usuario where username = ? and contrasena = ?";
            String consulta = "call inicioSesion(?,?)";
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
            int timh1 = 1;
            int timh2 = 3;
            int timh3 = 1;
            
            String consulta ="select unidades,producto.idproducto, nombre,descripcion, imagen1,estado from producto " +
                    "WHERE estado =? " +
                    "ORDER BY ? ASC " +
                    "LIMIT ?";
            //String consulta="call dashPocos2(?,?,?)";
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
           
            //String consulta = "select imagen1 from producto where idproducto=?";
            String consulta ="call getproImage(?)";
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
     public byte [] getproImage2(int idProducto){
        byte[] imageBytes = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
           
            //String consulta = "select imagen2 from producto where idproducto=?";
            String consulta ="call getImage2(?)";
            pst = getConexion().prepareStatement(consulta);
            pst.setInt(1, idProducto);
            rs= pst.executeQuery();
            
            while(rs.next())
            {
                imageBytes = rs.getBytes("imagen2");
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
      public byte [] getproImage3(int idProducto){
        byte[] imageBytes = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
           
            String consulta = "select imagen3 from producto where idproducto=?";
            pst = getConexion().prepareStatement(consulta);
            pst.setInt(1, idProducto);
            rs= pst.executeQuery();
            
            while(rs.next())
            {
                imageBytes = rs.getBytes("imagen3");
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
           
            String consulta = "select idproducto,nombre, descripcion, imagen1,unidades,idcategoria,estado,video,imagen2,imagen3 from producto " +
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
                proS.setImagen2(rs.getBytes("imagen2"));
                proS.setImagen3(rs.getBytes("imagen3"));
                proS.setUnidades(rs.getInt("unidades"));
                proS.setIdCategoria(rs.getInt("idcategoria"));
                proS.setEstado(rs.getBoolean("estado"));
                proS.setVideo(rs.getString("video"));
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
    public boolean productoVenta(String nombre, String descripcion, int unidades, boolean estado, int categoria, InputStream imagen,String video,InputStream imagen2,InputStream imagen3){
        PreparedStatement pst = null;
       try {
           
                  
           String consulta = "insert into producto (nombre, descripcion, unidades, estado, fecha, idcategoria,imagen1,video,imagen2, imagen3) " +
                                "values(?,?,?,?,NOW(),?,?,?,?,?)";
           pst = getConexion().prepareStatement(consulta);
           pst.setString(1, nombre);
           pst.setString(2, descripcion);
           pst.setInt(3, unidades);
           pst.setBoolean(4, estado);
           pst.setInt(5, categoria);
           pst.setBinaryStream(6, imagen);
           pst.setString(7, video);
           pst.setBinaryStream(8, imagen2);
           pst.setBinaryStream(9, imagen3);
           
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
    
    public boolean productoEditado(String nombre, String descripcion, int unidades, boolean estado, int categoria, InputStream imagen, int idProducto,InputStream imagen2,InputStream imagen3,String video){
        PreparedStatement pst = null;
       try {
           
                  
           String consulta = "update producto SET nombre=?, descripcion=?, unidades=?, estado=?, idcategoria=?, imagen1=?, imagen2=?, imagen3=?, video=? " +
                                "WHERE idproducto = ?";
           pst = getConexion().prepareStatement(consulta);
           pst.setString(1, nombre);
           pst.setString(2, descripcion);
           pst.setInt(3, unidades);
           pst.setBoolean(4, estado);
           pst.setInt(5, categoria);
           pst.setBinaryStream(6, imagen);
           pst.setBinaryStream(7, imagen2);
           pst.setBinaryStream(8, imagen3);
           pst.setString(9, video);
           pst.setInt(10, idProducto);
           
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
           
            //String consulta = "select idproducto,producto.nombre, descripcion, imagen1 from producto " +
            //    "WHERE producto.idcategoria=?";
            String consulta ="call cateSearch(?)";
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
           
            String consulta = "call getImagenUsuario(?)";
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
           
            //String consulta = "select idusuario from usuario where username=?";
            String consulta = "call getIdUser(?)";
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
       int est=0;
       try {
           boolean admin = false;
         
           String consulta = "insert into carrito(idproducto, idusuario, estado) " +
                             "values (?,?,?)";
           pst = getConexion().prepareStatement(consulta);
           pst.setInt(1, idProducto);
           pst.setInt(2, idUsuario);
           pst.setInt(3, est);
       
           
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
        int est=0;
        ResultSet rs = null;
        
        try {
           
            //String consulta = "select producto.idproducto, nombre, descripcion, imagen1,carrito.idcarrito,carrito.preciosugerido from producto " +
            //    "INNER JOIN carrito ON carrito.idproducto = producto.idproducto "+
            //    "WHERE carrito.idusuario = ? AND carrito.estado=?";
            String consulta ="call cartShow(?,?)";
            pst = getConexion().prepareStatement(consulta);
            pst.setInt(1, idUsuario);
            pst.setInt(2, est);
            rs= pst.executeQuery();
            
            while(rs.next())
            {
            int idpro = rs.getInt("producto.idproducto");
            String nombre = rs.getString("nombre");
            String desc = rs.getString("descripcion");
            byte[] image = rs.getBytes("imagen1");
            int idcart = rs.getInt("idcarrito");
            int presu = rs.getInt("preciosugerido");
            producto productoDash = new producto(nombre,desc,image,idpro,idcart,presu);
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
        int est=1;
    
       try {
            String consulta = "UPDATE carrito SET estado=? WHERE idcarrito=?";
            pst = getConexion().prepareStatement(consulta);
            pst.setInt(1, est);
            pst.setInt(2, idCart);
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
    
    public boolean chatMK(int idUsuario, int idAdmin, int idProducto, int idCarrito){
        PreparedStatement pst = null;
       try {
                
           String consulta = "insert into chat (idusuario, idadmin, idproducto, idcarrito) " +
                   "values(?,?,?,?)";
           pst = getConexion().prepareStatement(consulta);
           pst.setInt(1, idUsuario);
           pst.setInt(2, idAdmin);
           pst.setInt(3, idProducto);
           pst.setInt(4, idCarrito);
     
           
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
    
    public int chatExist(int idCart){
        int chatId=0;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {

             //String consulta = "select idchat from chat WHERE chat.idcarrito = ?";
             String consulta = "call chatExist(?)";
             pst = getConexion().prepareStatement(consulta);
             pst.setInt(1, idCart);
             rs= pst.executeQuery();

             while(rs.next())
             {
                 chatId = rs.getInt("idchat");
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
       return chatId;
      
    
    }
    
    
       public proCart getCarPro(int idcart){
        proCart cartItem = new proCart();
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        try {
           
            String consulta = "select idproducto, idusuario from carrito WHERE idcarrito = ?";
            pst = getConexion().prepareStatement(consulta);
            pst.setInt(1, idcart);
            rs= pst.executeQuery();
            
            while(rs.next())
            {
            int idpro = rs.getInt("idproducto");
            int idusu = rs.getInt("idusuario");
            
            cartItem.setIdproducto(idpro);
            cartItem.setIdusuario(idusu);
            cartItem.setIdcarrito(idcart);
            
            
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
        
        return cartItem;
    
    }
       
     public Chat getChat(int idcart){
        Chat chatIt = new Chat();
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        try {
           
            String consulta = "select idusuario, idadmin, idproducto, idchat WHERE idcarrito =?";
            pst = getConexion().prepareStatement(consulta);
            pst.setInt(1, idcart);
            rs= pst.executeQuery();
            
            while(rs.next())
            {
            int idpro = rs.getInt("idproducto");
            int idusu = rs.getInt("idusuario");
            int idadm = rs.getInt("idadmin");
            int idchat = rs.getInt("idchat");
            
            chatIt.setIdproducto(idpro);
            chatIt.setIdusuario(idusu);
            chatIt.setIdcarrito(idcart);
            chatIt.setIdchat(idchat);
            
            
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
        
        return chatIt;
    
    }
     
     public List<Mensaje> getMsj(int idChat){
        List<Mensaje> listMsj = new ArrayList<Mensaje>();
        int orden=2;
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        try {
           
            String consulta = "select mensaje, horamsj, idmensaje, mensaje.idusuario from mensaje " +
                "INNER JOIN chat ON chat.idchat = mensaje.idchat WHERE chat.idchat = ? "+
                "ORDER BY ? ASC";
            pst = getConexion().prepareStatement(consulta);
            pst.setInt(1, idChat);
            pst.setInt(2, orden);
            rs= pst.executeQuery();
            
            while(rs.next())
            {
            String mensaje = rs.getString("mensaje");
            String hora = rs.getString("horamsj");
            int idmsj = rs.getInt("idmensaje");
            int idUsu = rs.getInt("idusuario");
            Mensaje msj = new Mensaje(mensaje,hora,idmsj,idUsu,idChat);
            listMsj.add(msj);
            
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
        
        return listMsj;
    
    }
     
     public boolean isChat(int idCart){
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            //String consulta = "select * from chat where idcarrito = ?";
            String consulta = "call isChat(?)";
            pst = getConexion().prepareStatement(consulta);
            pst.setInt(1, idCart);
           
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
     
     public boolean addMsj(String msj,int usuario,int idchat){
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String consulta = "insert into mensaje(mensaje, horamsj, idusuario, idchat) "+
                    "values(?,NOW(),?,?)";
            pst = getConexion().prepareStatement(consulta);
            pst.setString(1, msj);
            pst.setInt(2, usuario);
            pst.setInt(3, idchat);
           
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
     
      public List<Chat> getChats(){
        List<Chat> listChats = new ArrayList<Chat>();
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        try {
           
            //String consulta = "select idchat, idusuario, idadmin, chat.idproducto, idcarrito, nombre from chat "
            //        +"INNER JOIN producto ON producto.idproducto = chat.idproducto";
            String consulta="call getChats()";
            pst = getConexion().prepareStatement(consulta);
            rs= pst.executeQuery();
            
            while(rs.next())
            {
            int idchat = rs.getInt("idchat");
            int idusu = rs.getInt("idusuario");
            int idadmin = rs.getInt("idadmin");
            int idprodu = rs.getInt("idproducto");
            int idcarrito = rs.getInt("idcarrito");
            String nompro= rs.getString("nombre");
            Chat chat = new Chat(idchat,idusu,idadmin,idprodu,idcarrito,nompro);
            listChats.add(chat);
            
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
        
        return listChats;
    
    }
      
      public boolean addPrs(int idchat, int Pres){
          PreparedStatement pst = null;
        try {
           
                  
           String consulta = "update carrito SET preciosugerido = ? " +
                                "WHERE idcarrito = ?";
           pst = getConexion().prepareStatement(consulta);
           pst.setInt(1, Pres);
           pst.setInt(2, idchat);
          
           
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
      
     public int cantPro(int idProducto){
        int canPro=0;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {

             //String consulta = "select unidades from producto where idproducto =?";
             String consulta = "call canPro(?)";
             pst = getConexion().prepareStatement(consulta);
             pst.setInt(1, idProducto);
             rs= pst.executeQuery();

             while(rs.next())
             {
                 canPro = rs.getInt("unidades");
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
       return canPro;
      
    
    } 
     
     public int proxCart(int cart){
        int canPro=0;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {

             String consulta = "select idproducto from carrito where idcarrito =?";
             pst = getConexion().prepareStatement(consulta);
             pst.setInt(1, cart);
             rs= pst.executeQuery();

             while(rs.next())
             {
                 canPro = rs.getInt("idproducto");
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
       return canPro;
      
    
    }
     
     public boolean addCompra(int idchat, int Pres){
          PreparedStatement pst = null;
        try {
           
                  
           String consulta = "update chat SET preciosugerido = ? " +
                                "WHERE idchat = ?";
           pst = getConexion().prepareStatement(consulta);
           pst.setInt(1, Pres);
           pst.setInt(2, idchat);
          
           
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
     
     public boolean addCompraH(int precio, int unidades, int formapago,int idusuario, int idproducto){
       PreparedStatement pst = null;
       try {
          
         
           String consulta = "insert into compra(fecha, precio, unidades, formapago, idusuario, idproducto) " +
                             "values (NOW(),?,?,?,?,?)";
           pst = getConexion().prepareStatement(consulta);
           pst.setInt(1, precio);
           pst.setInt(2, unidades);
           pst.setInt(3, formapago);
           pst.setInt(4, idusuario);
           pst.setInt(5, idproducto);
       
           
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
     
     public boolean updCnt(int nCant, int idProducto){
          PreparedStatement pst = null;
        try {
           
                  
           String consulta = "update producto SET unidades=? " +
                                "WHERE idproducto = ?";
           pst = getConexion().prepareStatement(consulta);
           pst.setInt(1, nCant);
           pst.setInt(2, idProducto);
          
           
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
     
     public List<Compra> shwCompra(int idusuario){
        List<Compra> listCom = new ArrayList<Compra>();
        PreparedStatement pst = null;
        ResultSet rs = null;
        
      
        
        try {
           
            //String consulta = "select producto.nombre,compra.idproducto, compra.fecha, precio, compra.unidades, formapago from compra " +
            //        "INNER JOIN producto ON producto.idproducto = compra.idproducto " +
            //        "WHERE compra.idusuario = ?";
            String consulta ="call shwCompra(?)";
            pst = getConexion().prepareStatement(consulta);
            pst.setInt(1, idusuario);
           
            rs= pst.executeQuery();
            
            while(rs.next())
            {
            String nombre = rs.getString("producto.nombre");
            int idpro = rs.getInt("compra.idproducto");
            String fecha = rs.getString("compra.fecha");
            int precio = rs.getInt("precio");
            int unidades = rs.getInt("compra.unidades");
            int formapago = rs.getInt("formapago");
            Compra com = new Compra(nombre,fecha,precio,unidades,formapago,idpro);
            listCom.add(com);
            
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
        
        return listCom;
    
    }
     
     public List<Compra> shwCompraFiltro(int idusuario, int order){
        List<Compra> listCom = new ArrayList<Compra>();
        PreparedStatement pst = null;
        ResultSet rs = null;
        
      
        
        try {
           
            String consulta = "select producto.nombre,compra.idproducto, compra.fecha, precio, compra.unidades, formapago from compra " +
                    "INNER JOIN producto ON producto.idproducto = compra.idproducto " +
                    "WHERE compra.idusuario = ? "+
                    "ORDER BY ?";
            pst = getConexion().prepareStatement(consulta);
            pst.setInt(1, idusuario);
            pst.setInt(2, order);
           
            rs= pst.executeQuery();
            
            while(rs.next())
            {
            String nombre = rs.getString("producto.nombre");
            int idpro = rs.getInt("compra.idproducto");
            String fecha = rs.getString("compra.fecha");
            int precio = rs.getInt("precio");
            int unidades = rs.getInt("compra.unidades");
            int formapago = rs.getInt("formapago");
            Compra com = new Compra(nombre,fecha,precio,unidades,formapago,idpro);
            listCom.add(com);
            
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
        
        return listCom;
    
    }
     public List<Compra> shwCompraFiltro2(int idusuario, String col, String prt){
        List<Compra> listCom = new ArrayList<Compra>();
        PreparedStatement pst = null;
        ResultSet rs = null;
        
      
        
        try {
           
            String consulta = "select producto.nombre,compra.idproducto, compra.fecha, precio, compra.unidades, formapago from compra " +
                    "INNER JOIN producto ON producto.idproducto = compra.idproducto " +
                    "WHERE compra.idusuario = ? AND "+col+" LIKE '%"+prt+"%'";
                    
            pst = getConexion().prepareStatement(consulta);
            pst.setInt(1, idusuario);
            //pst.setString(2, col);
            //pst.setString(2, prt);
           
            rs= pst.executeQuery();
            
            while(rs.next())
            {
            String nombre = rs.getString("producto.nombre");
            int idpro = rs.getInt("compra.idproducto");
            String fecha = rs.getString("compra.fecha");
            int precio = rs.getInt("precio");
            int unidades = rs.getInt("compra.unidades");
            int formapago = rs.getInt("formapago");
            Compra com = new Compra(nombre,fecha,precio,unidades,formapago,idpro);
            listCom.add(com);
            
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
        
        return listCom;
    
    }
     
     public int cntLikes(int idProducto){
        int like = 1;
        int canLike=0;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {

             String consulta = "SELECT COUNT(valoracion.valoracion) as likes FROM valoracion "+ 
                     "where valoracion.idproducto = ? AND valoracion.valoracion = ?";
             pst = getConexion().prepareStatement(consulta);
             pst.setInt(1, idProducto);
             pst.setInt(2, like);
             rs= pst.executeQuery();

             while(rs.next())
             {
                 canLike = rs.getInt("likes");
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
       return canLike;
      
    
    }
     
    public int cntDislikes(int idProducto){
        int like = 0;
        int canLike=0;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {

             String consulta = "SELECT COUNT(valoracion.valoracion) as likes FROM valoracion "+ 
                     "where valoracion.idproducto = ? AND valoracion.valoracion = ?";
             pst = getConexion().prepareStatement(consulta);
             pst.setInt(1, idProducto);
             pst.setInt(2, like);
             rs= pst.executeQuery();

             while(rs.next())
             {
                 canLike = rs.getInt("likes");
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
       return canLike;
      
    
    }
    
    public void addLike(int idPro, int idusuario){
       PreparedStatement pst = null;
       PreparedStatement pst2 = null;
       PreparedStatement pst3 = null;
       ResultSet rs = null;
       
       boolean like = true;
       try {
           
           String validacion ="select valoracion.valoracion from valoracion WHERE idusuario=? AND idproducto =?";
           
           pst = getConexion().prepareStatement(validacion);
           //pst.setBoolean(1, like);
           pst.setInt(1, idusuario);
           pst.setInt(2, idPro);
           rs=pst.executeQuery();
           if(rs.next()){
               String update="update valoracion set valoracion.valoracion=true WHERE idusuario=? AND idproducto=?";
               pst2 = getConexion().prepareStatement(update);
               pst2.setInt(1, idusuario);
               pst2.setInt(2, idPro);
              pst2.executeUpdate();
           }else{
           String consulta = "insert into valoracion (valoracion, idusuario, idproducto) " +
                             "values (?,?,?)";
           pst3 = getConexion().prepareStatement(consulta);
           pst3.setBoolean(1, like);
           pst3.setInt(2, idusuario);
           pst3.setInt(3, idPro);
           pst3.executeUpdate();
           
           }
       } catch (SQLException e) {
           System.out.println("Error " + e);
       }finally{
           try {
               if(getConexion() != null) getConexion().close();
               if(pst != null) pst.close();
               if(pst2 != null) pst2.close();
               if(pst3 != null) pst3.close();
               if(rs != null) rs.close();
           } catch (Exception e) {
           }
       }
       
   }
    
    public void addDislike(int idPro, int idusuario){
       PreparedStatement pst = null;
       PreparedStatement pst2 = null;
       PreparedStatement pst3 = null;
       ResultSet rs = null;
       boolean like = false;
       try {
           
           String validacion ="select valoracion.valoracion from valoracion WHERE idusuario=? AND idproducto =?";
            pst = getConexion().prepareStatement(validacion);
           //pst.setBoolean(1, like);
           pst.setInt(1, idusuario);
           pst.setInt(2, idPro);
           rs=pst.executeQuery();
           if(rs.next()){
               String update="update valoracion set valoracion.valoracion=false WHERE idusuario=? AND idproducto=?";
               pst2 = getConexion().prepareStatement(update);
               pst2.setInt(1, idusuario);
               pst2.setInt(2, idPro);
               pst2.executeUpdate();
           
           }else{
           
            String consulta = "insert into valoracion (valoracion, idusuario, idproducto) " +
                             "values (?,?,?)";
           pst = getConexion().prepareStatement(consulta);
           pst.setBoolean(1, like);
           pst.setInt(2, idusuario);
           pst.setInt(3, idPro);
           
           pst3.executeUpdate();}
       } catch (SQLException e) {
           System.out.println("Error " + e);
       }finally{
           try {
               if(getConexion() != null) getConexion().close();
               if(pst != null) pst.close();
               if(pst2 != null) pst2.close();
               if(pst3 != null) pst3.close();
               if(rs != null) rs.close();
           } catch (Exception e) {
           }
       }
      
   }
   
    public boolean obComprado(int idusuario, int idproducto){
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String consulta = "select	idusuario, idproducto from compra where idusuario = ? AND idproducto=?";
            
            pst = getConexion().prepareStatement(consulta);
            pst.setInt(1, idusuario);
            pst.setInt(2, idproducto);
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
    
    public boolean addComentario(int idUsuario, int idProducto, String Comentario){
       PreparedStatement pst = null;
       try {
          
         
           String consulta = "insert into comentario(idusuario, idproducto, texto, fecha) " +
                             "values (?,?,?,NOW())";
           pst = getConexion().prepareStatement(consulta);
           pst.setInt(1, idUsuario);
           pst.setInt(2, idProducto);
           pst.setString(3, Comentario);
           
       
           
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
    
    public List<Comentario> shwComentario(int idProducto){
        List<Comentario> listCom = new ArrayList<Comentario>();
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        try {
           
            String consulta = "select usuario.username, comentario.fecha, texto from comentario " +
                        "INNER JOIN usuario ON usuario.idusuario = comentario.idusuario " +
                        "WHERE comentario.idproducto=?";
                    
            pst = getConexion().prepareStatement(consulta);
            pst.setInt(1, idProducto);
            rs= pst.executeQuery();
            
            while(rs.next())
            {
            String nombre = rs.getString("usuario.username");
            String fecha = rs.getString("comentario.fecha");
            String comentario = rs.getString("texto");
            Comentario com = new Comentario(nombre,fecha,comentario);
            listCom.add(com);
            
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
        
        return listCom;
    
    }
     
    public static void main(String[] args) {
        
        Consultas co = new Consultas();
        
        System.out.println(co.addComentario(9, 21, "Me gusto Mucho la figura"));
        
        /*Consultas co2 = new Consultas();
        int unidades = 8;
        int proid = co.proxCart(1);
        int unPro = co2.cantPro(proid);*/
        
        
        //Consultas co2 = new Consultas();
        //proCart procart = co.getCarPro(1);
        //producto pro = co.productoSearch(20);
        //List<Mensaje> msjs = co.getMsj(2);
        //List<Chat> chat = co2.getChats();
        //List<producto> pro = co.cartShow(9);
        
       //List<Compra> listb = co.shwCompraFiltro2(9,"producto.nombre","Funko");
        
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
       
       /*proCart pro = co.getCarPro(1);
       
        System.out.println(pro.getIdcarrito());
        System.out.println(pro.getIdproducto());*/
       
       /*for( producto ls : pro)
       {
           System.out.println(ls.getNombre());
           System.out.println(ls.getDescripcion());
           System.out.println(ls.getIdproducto());
           System.out.println(ls.getIdCarrito());
           System.out.println(ls.getPrecio());
           System.out.println("---------------");
       }*/
       
        
       
       /*for( Chat c : chat)
       {
           System.out.println(c.getIdcarrito());
       }*/
      
    }
}
