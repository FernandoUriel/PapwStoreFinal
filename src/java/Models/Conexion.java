/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author fernandourg
 */
public class Conexion {
     private String USERNAME = "root";
    private String PASSWORD = "";
    private String HOST = "localhost";
    private String PORT = "3306";
    private String DATABASE = "BD-FerShop";
    private String CLASSNAME = "com.mysql.jdbc.Driver";
    private String URL = "jdbc:mysql://"+HOST+":"+PORT+"/"+DATABASE;
    private Connection con;
    
    public Conexion(){
        
        try {
            Class.forName(CLASSNAME);
            con = (Connection) DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } catch (ClassNotFoundException e) {
            System.out.println("Error "+e);
        }
        catch (SQLException e) {
            System.out.println("Error "+e);
        }
    }
    
    
    public Connection getConexion(){
    return con;
    }
    
    public static void main(String[] args) {
        Conexion con = new Conexion();
    }
    
}
