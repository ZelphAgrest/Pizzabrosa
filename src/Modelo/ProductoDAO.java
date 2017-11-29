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
 * @author LOGAN
 */
public class ProductoDAO {
    Conexion conexion;
    
    public ProductoDAO(){
        conexion =new Conexion();    
    }
    
    public String insertarProducto(String nombre, String codigo, String descripcion, String precio, String cantidad, String idRestriccion ){
        String rptaRegistro=null;
        try {
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs= accesoDB.prepareCall("call sp_(?,?,?,?,?,?)");
            
            cs.setString(1, nombre);
            cs.setString(2, codigo);
            cs.setString(3, descripcion);
            cs.setString(4, precio);
            cs.setString(5, cantidad);
            cs.setString(6, idRestriccion);
            
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
    
    
    public ArrayList<Producto> listProducto(){
        ArrayList listaProducto = new ArrayList();
        Producto producto;
        try {
            Connection accesoDB=conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareCall("select * from producto");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                 producto= new Producto();
                 producto.setNombre(rs.getString(1));
                 producto.setCodigo(rs.getInt(2));
                 producto.setDescripcion(rs.getString(3));
                 producto.setPrecio(rs.getInt(4));
                 producto.setCantidad(rs.getInt(5));
                 //producto.
                
                 listaProducto.add(producto);
            
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaProducto;
        
    }
}
