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
    
    //Obtener las restricciones
    public ArrayList<String> consultarRestricciones(){
        ArrayList<String> listarestricciones = new ArrayList();
        try{
        Connection accesoDB = conexion.getConexion();
        CallableStatement cs= accesoDB.prepareCall("select * from restricciones");
       
        ResultSet rs=cs.executeQuery();
       
        while (rs.next()){
            listarestricciones.add(rs.getString(2));
            } 
        }catch(Exception e){
           e.printStackTrace();     
        }
        return listarestricciones;
    }
    
    
    public String insertarProducto(String nombre, String codigo, String descripcion, String precio, String cantidad, String idRestriccion ){
        String rptaRegistro=null;
        try {
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs= accesoDB.prepareCall("call sp_insertProducto(?,?,?,?,?,?)");
            
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
                 producto.setIdProducto(rs.getInt(1));
                 producto.setNombre(rs.getString(2));
                 producto.setCodigo(rs.getInt(3));
                 producto.setDescripcion(rs.getString(4));
                 producto.setPrecio(rs.getInt(5));
                 producto.setCantidad(rs.getInt(6));
                 producto.setIdRestriccion(rs.getInt(7));
                 listaProducto.add(producto);
            
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaProducto;
        
    }
    
     public ArrayList<Producto> buscarProductoNombre(String nombre) {
        ArrayList<Producto> listaProductos = new ArrayList();
        Producto producto;

        try {
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall("call sp_buscaPxNombre(?)");
            cs.setString(1, nombre + '%');
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                producto = new Producto();
                producto.setIdProducto(rs.getInt(1));
                producto.setNombre(rs.getString(2));
                producto.setCodigo(rs.getInt(3));
                producto.setDescripcion(rs.getString(4));
                producto.setPrecio(rs.getDouble(5));
                producto.setCantidad(rs.getInt(6));
                producto.setIdRestriccion(rs.getInt(7));
                listaProductos.add(producto);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaProductos;
    }
     
     
     public ArrayList<Producto> buscarProductoCódgio(String codigo) {
        ArrayList<Producto> listaProductos = new ArrayList();
        Producto producto;

        try {
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall("call sp_buscaPxCodigo(?)");
            cs.setString(1, codigo);
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                producto = new Producto();
                producto.setIdProducto(rs.getInt(1));
                producto.setNombre(rs.getString(2));
                producto.setCodigo(rs.getInt(3));
                producto.setDescripcion(rs.getString(4));
                producto.setPrecio(rs.getDouble(5));
                producto.setCantidad(rs.getInt(6));
                producto.setIdRestriccion(rs.getInt(7));
                listaProductos.add(producto);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaProductos;
    } 
     
     
     public String editaProducto(String idProducto,String nombre, String codigo, String descripcion, String precio, String cantidad, String idRestriccion ) {
        String rptaRegistro = null;
        try {
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall("call sp_editaProducto(?,?,?,?,?,?,?)");

            cs.setString(1, idProducto);
            cs.setString(2, nombre);
            cs.setString(3, codigo);
            cs.setString(4, descripcion);
            cs.setString(5, precio);
            cs.setString(6, cantidad);
            cs.setString(7, idRestriccion);
           

            int numFAfectadas = cs.executeUpdate();
            System.out.println("Filas afectadas " + numFAfectadas);
            if (numFAfectadas > 0) {
                rptaRegistro = "Registro Exitoso";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
       
        return rptaRegistro;
    }
     
     public int eliminarProducto(String idProducto) {
        int numFA = 0;
        try {
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall("call sp_eliminarProducto(?)");

            cs.setString(1, idProducto);

            numFA = cs.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return numFA;

    }
     
     
      public ArrayList<ProductoPedido> buscarProductoIdenPedido(String id) {
        ArrayList<ProductoPedido> listaProductos = new ArrayList();
        ProductoPedido producto;

        try {
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall("call sp_buscaPxId(?)");
            cs.setString(1, id);
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                producto = new ProductoPedido();
                producto.setIdPedido(rs.getInt(1));
                producto.setIdProducto(rs.getInt(2));
                
             
                listaProductos.add(producto);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaProductos;
    } 
     
     
     
}
