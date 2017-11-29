package Modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

public class InicioDeSesionDAO {

    Conexion conexion;

    public InicioDeSesionDAO() {
        conexion = new Conexion();
    }

    public String inicioSesion(String user, String pass) {
        String rptaRegistro = null;
        try {
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall("call sp_iniciaSesion(?,?)");

            cs.setString(1, user);
            cs.setString(2, pass);
           
            ResultSet rs = cs.executeQuery();
                      
            if (rs.next()) {
               rptaRegistro = "Registro Exitoso";
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        return rptaRegistro;

    }

}
