
package Modelo;

import java.sql.*;

public class Conexion {
    Connection con=null;
   public Connection getConexion(){
       try {
           //cargar nuestro driver
           Class.forName("com.mysql.jdbc.Driver");
           con=DriverManager.getConnection("jdbc:mysql://localhost/pizzeria","root","123456");
           System.out.println("conexion establecida");
           //JOptionPane.showMessageDialog(null, "conexion establecida");
       } catch (ClassNotFoundException | SQLException e) {
           System.out.println("error de conexion");
          // JOptionPane.showMessageDialog(null, "error de conexion "+e);gggvfcfg
       }
       return con;
   }
     
}
