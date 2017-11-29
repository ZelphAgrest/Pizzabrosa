/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Zelph
 */
public class EmpleadoDAO {
     Conexion conexion;
    public EmpleadoDAO(){
        conexion =new Conexion();
        
    }
    
     public String inserteEmpleado(String nombre,String apellido, String telefono, String email, String direccion, String codigopostal, String ciudad, String usuario, String password,String tipoEmpleado){
        String rptaRegistro=null;
        try {
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs= accesoDB.prepareCall("call sp_inserteEmpleado(?,?,?,?,?,?,?,?,?,?)");
            
            
            cs.setString(1, nombre);
            cs.setString(2, apellido);
            cs.setString(3, telefono);
            cs.setString(4, email);
            cs.setString(5, direccion);
            cs.setString(6, codigopostal);
            cs.setString(7, ciudad);
            cs.setString(8, usuario);
            cs.setString(9, password);
            cs.setString(10, tipoEmpleado);
            
            int numFAfectadas = cs.executeUpdate();
            System.out.println("Filas afectadas "+numFAfectadas);
            if(numFAfectadas>0){
                rptaRegistro="Registro Exitoso";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return rptaRegistro;
    }
     
     public ArrayList<Empleado> listEmpleado(){
        ArrayList listaEmpleado = new ArrayList();
        Empleado empleado;
        try {
            Connection accesoDB=conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareCall("select * from empleado");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                 empleado= new Empleado();
                 empleado.setIdEmpleado(rs.getInt(1));
                 empleado.setNombre(rs.getString(2));
                 empleado.setApellido(rs.getString(3));
                 empleado.setTelefono(rs.getString(4));
                 empleado.setEmail(rs.getString(5));
                 empleado.setDireccion(rs.getString(6));
                 empleado.setCodigopostal(rs.getString(7));
                 empleado.setCiudad(rs.getString(8));
                 empleado.setUsuario(rs.getString(9));
                 empleado.setPassword(rs.getString(10));
                 empleado.setIdTipoEmpleado(rs.getInt(11));
                 listaEmpleado.add(empleado);
            
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaEmpleado;
        
    }
     
     public ArrayList<Empleado> buscarEmpleadoApellidos(String apellido){
    ArrayList<Empleado> listaEmpleado = new ArrayList();
    Empleado empleado;
         
        try {
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs= accesoDB.prepareCall("call sp_buscaExApellido(?)");
            
            cs.setString(1, apellido+'%');
            ResultSet rs = cs.executeQuery();
            while(rs.next()){
                empleado = new Empleado();
                empleado.setIdEmpleado(1);
                empleado.setNombre(rs.getString(2));
                empleado.setApellido(rs.getString(3));
                empleado.setTelefono(rs.getString(4));
                empleado.setEmail(rs.getString(5));
                empleado.setDireccion(rs.getString(6));
                empleado.setCodigopostal(rs.getString(7));
                empleado.setCiudad(rs.getString(8));
                empleado.setUsuario(rs.getString(9));
                empleado.setPassword(rs.getString(10));
                empleado.setIdTipoEmpleado(rs.getInt(11));
                listaEmpleado.add(empleado);
                
            
            }
        } catch (Exception e) {
             e.printStackTrace();
        }
    return listaEmpleado;
    }
    
     
     public String editaEmpleado(String idEmpleado,String nombre,String apellido, String telefono, String email, String direccion, String codigopostal, String ciudad, String nombreUsuario, String contrasenia,String tipoEmpleado){
        String rptaRegistro=null;
        try {
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs= accesoDB.prepareCall("call sp_editaEmpleado(?,?,?,?,?,?,?,?,?,?,?)");
            
            cs.setString(1, idEmpleado);
            cs.setString(2, nombre);
            cs.setString(3, apellido);
            cs.setString(4, telefono);
            cs.setString(5, email);
            cs.setString(6, direccion);
            cs.setString(7, codigopostal);
            cs.setString(8, ciudad);
            cs.setString(9, nombreUsuario);
            cs.setString(10, contrasenia);
            cs.setString(11, tipoEmpleado);
            
            int numFAfectadas = cs.executeUpdate();
            System.out.println("Filas afectadas "+numFAfectadas);
            if(numFAfectadas>0){
                rptaRegistro="Registro Exitoso";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // comentario
        return rptaRegistro;
    }
     
     
      public int eliminarEmpleado (String idEmpleado){
    int numFA=0;
        try {
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs= accesoDB.prepareCall("call sp_eliminarEmpleado(?)");
            
            cs.setString(1, idEmpleado);
            
            numFA= cs.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return numFA;
    
    }
     
}
