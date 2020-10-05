/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;

/**
 *
 * @author Christian D
 */
public final class Conexion {
    private static Connection con;
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String user = "root";
    private static final String pass = "2222";
    private static final String url = "jdbc:mysql://localhost:3306/COMPLEJO_HOTELERO";

    public Conexion() {
    }
    // Este metodo nos devuelve la conexión a la BD.
       public Connection getConnection(){
            con = null;
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url,user,pass);
            if(con != null){
                System.out.println("Conexión exitosa");
                return con;
            }
        } catch (ClassNotFoundException | SQLException e){
            System.out.println("Conexión Fallida "+ e);
            
        }
        return null;
       } 
       // Este metodo anula la conexion.
       public void dropConnection(){
           con = null;
           if(con==null)
               System.out.println("Conexión finalizada");
       }
}
