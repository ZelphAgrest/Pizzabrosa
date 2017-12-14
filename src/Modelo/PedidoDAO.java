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
       
        return rptaRegistro;
    }
    
    //Guardar los productos de un pedido
     public String insertarProductosPedido(String idPedido, String idProducto, String cantidad, String precio){
        String rptaRegistro=null;
        try {
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs= accesoDB.prepareCall("call sp_insertProductoPedido(?,?,?,?)");
            
            cs.setString(1, idPedido);
            cs.setString(2, idProducto);
            cs.setString(3, cantidad);
            cs.setString(4, precio);
            
           
            
            int numFAfectadas = cs.executeUpdate();
            System.out.println("Filas afectadas "+numFAfectadas);
            if(numFAfectadas>0){
                rptaRegistro="Registro Exitoso";
            }
        } catch (Exception e) {
           // e.printStackTrace();
        }
        
        return rptaRegistro;
    }
    
    
     //Obtener los Estatus
    public ArrayList<String> consultarEstatus(){
        ArrayList<String> listarestatus = new ArrayList();
        try{
        Connection accesoDB = conexion.getConexion();
        CallableStatement cs= accesoDB.prepareCall("select * from estatuspedido");
       
        ResultSet rs=cs.executeQuery();
       
        while (rs.next()){
            listarestatus.add(rs.getString(2));
            } 
        }catch(Exception e){
           e.printStackTrace();     
        }
        return listarestatus;
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
    public ArrayList<Cliente> consultarNombreCliente() {
        ArrayList<Cliente> listaNombreClientes = new ArrayList();
        try {
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall("select * from cliente");

            ResultSet rs = cs.executeQuery();

            while (rs.next()) {
                Cliente cli = new Cliente();
                cli.setidCliente(rs.getInt(1));
                cli.setNombre(rs.getString(2));
                cli.setApellido(rs.getString(3));
                listaNombreClientes.add(cli);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaNombreClientes;
    }

    //Obtener el nombre del Empleado
    public ArrayList<Empleado> consultarNombreEmpleado() {
        ArrayList<Empleado> listaNombreEmpleado = new ArrayList();
        try {
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall("select * from empleado");

            ResultSet rs = cs.executeQuery();

            while (rs.next()) {
                Empleado emp = new Empleado();
                emp.setIdEmpleado(rs.getInt(1));
                emp.setNombre(rs.getString(2));
                emp.setApellido(rs.getString(3));
                listaNombreEmpleado.add(emp);
                
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
    
    //EditarEstatus del pedido
      public String editaEstatusPedido(String idPedido,String idEstatusPedido) {
        String rptaRegistro = null;
        try {
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall("call sp_editaEstatusPedido(?,?)");

            cs.setString(1, idPedido);
            cs.setString(2, idEstatusPedido);
           
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
     
     
    
   
    
    public int consultarUltimoPedido(){
        ArrayList<Pedido> listarpedido = new ArrayList();
        try{
        Connection accesoDB = conexion.getConexion();
        CallableStatement cs= accesoDB.prepareCall("select * from pedido");
       
        ResultSet rs=cs.executeQuery();
       
        while (rs.next()){
            Pedido pe = new Pedido();
            pe.setIdPedido(rs.getInt(1));
            listarpedido.add(pe);
            } 
        }catch(Exception e){
           e.printStackTrace();     
        }
        int idPed = listarpedido.get(listarpedido.size()-1).getIdPedido();
        return idPed;
    }
     
    
    
    //Consultar los productos por id de pedido
    public ArrayList<ProductoPedido> consultarProductosPedido(String idPedido) {
        ArrayList<ProductoPedido> listaproductos = new ArrayList();
         ProductoPedido pp;
        try {
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall("select * from productospedido where idPedido="+"'"+idPedido+"'");

            ResultSet rs = cs.executeQuery();

            while (rs.next()) {
                pp = new ProductoPedido();
                pp.setIdPedido(rs.getInt(1));
                pp.setIdProducto(rs.getInt(2));
                pp.setCantidad(rs.getInt(3));
                pp.setPrecioProducto(rs.getDouble(4));
                listaproductos.add(pp);
            
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaproductos;
    }
    //Consulta los productos para obtener su nombre para la tabla
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
                
                 listaProducto.add(producto);
            
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaProducto;
        
    }
     
    //Buscar pedidos por id
    public ArrayList<Pedido> buscarPedidoxid(String idpedido) {
        ArrayList<Pedido> listaPedidos = new ArrayList();
        Pedido pedido;

        try {
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall("call sp_buscaPedidoxid(?)");

            cs.setString(1, idpedido);

            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                pedido = new Pedido();
                pedido.setIdPedido(rs.getInt(1));
                pedido.setFechaPedido(rs.getDate(2));
                pedido.setIdEstatusPedido(rs.getInt(3));
                pedido.setIdCliente(rs.getInt(4));
                pedido.setIdEmpleado(rs.getInt(5));

                listaPedidos.add(pedido);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaPedidos;
    }
    
    //Consultar los datos del cliente por su nombre
    
     public ArrayList<Cliente> consultarDatosCliente(String nombreCliente) {
        ArrayList<Cliente> listaNombreClientes = new ArrayList();
        try {
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall("call sp_buscaClientexNombre(?)");

            cs.setString(1, nombreCliente+'%');
            
            ResultSet rs = cs.executeQuery();

            while (rs.next()) {
                Cliente cli = new Cliente();
                cli.setidCliente(rs.getInt(1));
                cli.setNombre(rs.getString(2));
                cli.setApellido(rs.getString(3));
                listaNombreClientes.add(cli);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaNombreClientes;
    }
     
    //eliminar producto del pedido
      public int eliminarProductoPedido(String idPedido,String idProducto) {
        int numFA = 0;
        try {
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall("call sp_eliminarProductoPedido(?,?)");

            cs.setString(1, idPedido);
            cs.setString(2, idProducto);

            numFA = cs.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return numFA;

    }
      
      
    //Editar productos del pedido
    public String editaProductosPedido(String idPedido,String idProducto, String cantidad, String Precio) {
        String rptaRegistro = null;
        try {
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall("call sp_editaProductosPedido(?,?,?,?)");

            cs.setString(1, idPedido);
            cs.setString(2, idProducto);
            cs.setString(3, cantidad);
            cs.setString(4, Precio);
           
            int numFAfectadas = cs.executeUpdate();
            System.out.println("Filas afectadas " + numFAfectadas);
            if (numFAfectadas > 0) {
                rptaRegistro = "Registro Exitoso";
            }
        } catch (Exception e) {
            //e.printStackTrace();
        }
       
        return rptaRegistro;
    }  
      
      
}
