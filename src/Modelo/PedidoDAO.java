package Modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class PedidoDAO {

    Conexion conexion;

    public PedidoDAO() {
        conexion = new Conexion();
    }

    
     public String insertarPedido(String fechaPedido, String estatusPedido, String idcliente, String idempleado){
        String rptaRegistro=null;
        try {
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs= accesoDB.prepareCall("call sp_insertPedido(?,?,?,?)");
            
            cs.setString(1, fechaPedido);
            cs.setString(2, estatusPedido);
            cs.setString(3, idcliente);
            cs.setString(4, idempleado);
            
           
            
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
    
    
    
    
    
//Obtener la lista de productos para combobox
    public ArrayList<Producto> consultarProductos() {
        ArrayList<Producto> listaproducto = new ArrayList();
        try {
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall("select * from producto");

            ResultSet rs = cs.executeQuery();

            while (rs.next()) {
                Producto p = new Producto();
                p.setIdProducto(rs.getInt(1));
                p.setNombre(rs.getString(2));
                p.setPrecio(rs.getDouble(5));
                listaproducto.add(p);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaproducto;

    }

    //Listar Pedidos
    public ArrayList<Pedido> listPedido() {
        ArrayList listaPedido = new ArrayList();
        Pedido pedido;
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareCall("select * from pedido");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                pedido = new Pedido();
                pedido.setIdPedido(rs.getInt(1));
                pedido.setFechaPedido(rs.getDate(2));
                pedido.setIdEstatusPedido(rs.getInt(3));
                pedido.setIdCliente(rs.getInt(4));
                pedido.setIdEmpleado(rs.getInt(5));

                listaPedido.add(pedido);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaPedido;

    }

    //Obtener los Estatus del pedido
    public ArrayList<String> consultarEstatusPedido() {
        ArrayList<String> listaresEstatusPedido = new ArrayList();
        try {
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall("select * from estatusPedido");

            ResultSet rs = cs.executeQuery();

            while (rs.next()) {
                listaresEstatusPedido.add(rs.getString(2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaresEstatusPedido;
    }

    //Obtener el nombre del cliente
    public ArrayList<String> consultarNombreCliente() {
        ArrayList<String> listaNombreClientes = new ArrayList();
        try {
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall("select * from cliente");

            ResultSet rs = cs.executeQuery();

            while (rs.next()) {
                listaNombreClientes.add(rs.getString(2));
                listaNombreClientes.add(rs.getString(3));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaNombreClientes;
    }

    //Obtener el nombre del Empleado
    public ArrayList<String> consultarNombreEmpleado() {
        ArrayList<String> listaNombreEmpleado = new ArrayList();
        try {
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall("select * from empleado");

            ResultSet rs = cs.executeQuery();

            while (rs.next()) {
                listaNombreEmpleado.add(rs.getString(2));
                listaNombreEmpleado.add(rs.getString(3));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaNombreEmpleado;
    }

    
    //Obtener el id del Empleado
    public ArrayList<Integer> consultaridEmpleado(String usuario) {
        ArrayList<Integer> listaIdEmpleado = new ArrayList();
        try {
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall("select * from empleado where nombreUsuario="+"'"+usuario+"'");

            ResultSet rs = cs.executeQuery();

            while (rs.next()) {
                listaIdEmpleado.add(rs.getInt(1));
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaIdEmpleado;
    }
    
    
    //Buscar Pedidos por Estatus
    public ArrayList<Pedido> buscarPedidoxEstatus(int estatus) {
        ArrayList<Pedido> listaProductos = new ArrayList();
        Pedido pedido;

        try {
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall("call sp_buscaPedidoxEstatus(?)");

            cs.setInt(1, estatus);

            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                pedido = new Pedido();
                pedido.setIdPedido(rs.getInt(1));
                pedido.setFechaPedido(rs.getDate(2));
                pedido.setIdEstatusPedido(rs.getInt(3));
                pedido.setIdCliente(rs.getInt(4));
                pedido.setIdEmpleado(rs.getInt(5));

                listaProductos.add(pedido);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaProductos;
    }

    //Buscar cliente por Teléfono
     public ArrayList<Cliente> buscarClienteXTelefono(String telefono){
    ArrayList<Cliente> listaClientes = new ArrayList();
    Cliente cliente;
        try {
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs= accesoDB.prepareCall("call sp_buscaCxTelefono(?)");
            cs.setString(1, telefono);
            ResultSet rs = cs.executeQuery();
            while(rs.next()){
                cliente = new Cliente();
                cliente.setidCliente(rs.getInt(1));
                cliente.setNombre(rs.getString(2));
                cliente.setApellido(rs.getString(3));
                listaClientes.add(cliente);
            }
        } catch (Exception e) {
             //e.printStackTrace();
             JOptionPane.showMessageDialog(null, "Cliente no registrado, favor de verificar el número");
        }
    return listaClientes;
    }
    
    
}
