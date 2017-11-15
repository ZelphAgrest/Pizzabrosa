
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
                 cliente.setNombre(rs.getString(1));
                 cliente.setApellido(rs.getString(2));
                 cliente.setTelefono(rs.getString(3));
                 cliente.setEmail(rs.getString(4));
                 cliente.setDireccion(rs.getString(5));
                 cliente.setCodigopostal(rs.getString(6));
                 cliente.setCiudad(rs.getString(7));
                 listaCliente.add(cliente);
            
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaCliente;
        
    }
    
}
