
package Modelo;
import java.sql.*;
import java.util.ArrayList;
import Vista.RegistrarClientes;

public class ClienteDAO {
    Conexion conexion;
    public ClienteDAO(){
        conexion =new Conexion();
        
    }
    
    public String insertCliente(String nombre,String apellido, String telefono, String email, String direccion, String codigopostal, String ciudad){
        String rptaRegistro=null;
        try {
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs= accesoDB.prepareCall("call sp_insertCliente(?,?,?,?,?,?,?)");
            
            cs.setString(1, nombre);
            cs.setString(2, apellido);
            cs.setString(3, telefono);
            cs.setString(4, email);
            cs.setString(5, direccion);
            cs.setString(6, codigopostal);
            cs.setString(7, ciudad);
            
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
    
    public ArrayList<Cliente> listCliente(){
        ArrayList listaCliente = new ArrayList();
        Cliente cliente;
        try {
            Connection accesoDB=conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareCall("select * from cliente");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                 cliente= new Cliente();
                 cliente.setidCliente(rs.getInt(1));
                 cliente.setNombre(rs.getString(2));
                 cliente.setApellido(rs.getString(3));
                 cliente.setTelefono(rs.getString(4));
                 cliente.setEmail(rs.getString(5));
                 cliente.setDireccion(rs.getString(6));
                 cliente.setCodigopostal(rs.getString(7));
                 cliente.setCiudad(rs.getString(8));
                 listaCliente.add(cliente);
            
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaCliente;
        
    }
    
    public String editaCliente(String idcliente,String nombre,String apellido, String telefono, String email, String direccion, String codigopostal, String ciudad){
        String rptaRegistro=null;
        try {
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs= accesoDB.prepareCall("call sp_editaCliente(?,?,?,?,?,?,?,?)");
            
            cs.setString(1, idcliente);
            cs.setString(2, nombre);
            cs.setString(3, apellido);
            cs.setString(4, telefono);
            cs.setString(5, email);
            cs.setString(6, direccion);
            cs.setString(7, codigopostal);
            cs.setString(8, ciudad);
            
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
    
    public int eliminarCliente (String idCliente){
    int numFA=0;
        try {
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs= accesoDB.prepareCall("call sp_eliminarCliente(?)");
            
            cs.setString(1, idCliente);
            
            numFA= cs.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return numFA;
    
    }
    
    public ArrayList<Cliente> buscarClienteApellidos(String apellido){
    ArrayList<Cliente> listaClientes = new ArrayList();
    Cliente cliente;
        try {
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs= accesoDB.prepareCall("call sp_buscaCxApellido(?)");
            
            cs.setString(1, apellido+'%');
            ResultSet rs = cs.executeQuery();
            while(rs.next()){
                cliente = new Cliente();
                cliente.setidCliente(1);
                cliente.setNombre(rs.getString(2));
                cliente.setApellido(rs.getString(3));
                cliente.setTelefono(rs.getString(4));
                cliente.setEmail(rs.getString(5));
                cliente.setDireccion(rs.getString(6));
                cliente.setCodigopostal(rs.getString(7));
                cliente.setCiudad(rs.getString(8));
                listaClientes.add(cliente);
            
            
            }
        } catch (Exception e) {
             e.printStackTrace();
        }
    return listaClientes;
    }
    
    
     //Busca al cliente en los pedidos
    public ArrayList<Pedido> buscarClienteEnPedidos(String idCliente){
     ArrayList<Pedido> listaEmpleado = new ArrayList();
        Pedido ped;
        try {
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall("call sp_buscaCxidEnPedido(?)");
            cs.setString(1, idCliente);
            
            ResultSet rs = cs.executeQuery();
            
            while (rs.next()) {
                ped = new Pedido();
                ped.setIdPedido(1);
                ped.setIdCliente(4);
                
                
                listaEmpleado.add(ped);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaEmpleado;
    }
    
    //Buscar clientepor su telefono
    
    public ArrayList<Cliente> buscarClienteTelefono(String telefono){
    ArrayList<Cliente> listaClientes = new ArrayList();
    Cliente cliente;
        try {
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs= accesoDB.prepareCall("call sp_buscaCxTelefono(?)");
            
            cs.setString(1, telefono+'%');
            ResultSet rs = cs.executeQuery();
            while(rs.next()){
                cliente = new Cliente();
                cliente.setidCliente(1);
                cliente.setNombre(rs.getString(2));
                cliente.setApellido(rs.getString(3));
                cliente.setTelefono(rs.getString(4));
                cliente.setEmail(rs.getString(5));
                cliente.setDireccion(rs.getString(6));
                cliente.setCodigopostal(rs.getString(7));
                cliente.setCiudad(rs.getString(8));
                listaClientes.add(cliente);
            
            
            }
        } catch (Exception e) {
             e.printStackTrace();
        }
    return listaClientes;
    }
    
    
    
}
