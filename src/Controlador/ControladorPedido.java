package Controlador;

import Modelo.Cliente;
import Modelo.Empleado;
import Modelo.Pedido;
import Modelo.PedidoDAO;
import Modelo.Producto;
import Modelo.ProductoPedido;
import Modelo.ProductosPedido;
import Vista.EditarEstatusPedido;
import Vista.EditarProductosPedido;
import Vista.MenuPrincipal;
import Vista.RegistrarPedido;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ControladorPedido implements ActionListener, Comunica, KeyListener {

    RegistrarPedido vistapedido = new RegistrarPedido(this, "");
    EditarEstatusPedido vistaEstatus = new EditarEstatusPedido(this, "", "");
    EditarProductosPedido vistaeditarproductos = new EditarProductosPedido(this, 0);

    MenuPrincipal vistaAdmin;
    PedidoDAO modeloPedido;
    Double cantidadtotal = 0.0;
    Double cantidadtotalEdicion = 0.0;
    ArrayList<Producto> listaProductos;
    ArrayList<Producto> listaProductosEdicion;
    int idClient = 0;
    String IdPedidoEdicionEstatus;
    String idEstatusOriginal;

    //Obtiene la fecha del sistema y le da el formato
    SimpleDateFormat fecha = new SimpleDateFormat("yyyy-MM-dd");
    Date now = new Date(System.currentTimeMillis());
    String fechaActual = fecha.format(now);

    public ControladorPedido(MenuPrincipal vistaAdmin, PedidoDAO modeloPedido) {
        this.vistaAdmin = vistaAdmin;
        this.modeloPedido = modeloPedido;
        this.vistaAdmin.comboBusquedaxEstatus.addActionListener(this);
        this.vistaAdmin.txtBuscarPedido.addKeyListener(this);
        LlenarTablaPedidos(this.vistaAdmin.TablaPedidos);
    }

    public void llenarCombo(RegistrarPedido vistaPedido) {
        this.vistapedido = vistaPedido;
        int numProductos = modeloPedido.consultarProductos().size();
        for (int i = 0; i < numProductos; i++) {
            this.vistapedido.comboListaProductos.addItem(modeloPedido.consultarProductos().get(i).getNombre());
        }

    }

    public void llenarCombo(EditarProductosPedido vistaPedido) {
        this.vistaeditarproductos = vistaPedido;
        int numProductos = modeloPedido.consultarProductos().size();
        for (int i = 0; i < numProductos; i++) {
            this.vistaeditarproductos.comboProducosEditarPedido.addItem(modeloPedido.consultarProductos().get(i).getNombre());
        }

    }

    public void llenarComboEditarEstatus(EditarEstatusPedido vistaEstatus) {
        this.vistaEstatus = vistaEstatus;
        int numRestric = modeloPedido.consultarEstatus().size();
        for (int i = 0; i < numRestric; i++) {
            this.vistaEstatus.comboCambiarEstatusPedido.addItem(modeloPedido.consultarEstatus().get(i));
        }

    }

    public void vinculaEditarEstatusPedido(EditarEstatusPedido vistaEstatus) {
        this.vistaEstatus = vistaEstatus;
        this.vistaEstatus.botonGuardarEditarEstatusPedido.addActionListener(this);
        this.vistaEstatus.botonRegresarEditarEstatusPedido.addActionListener(this);
        IdPedidoEdicionEstatus = this.vistaEstatus.regresaIdPedido();
        idEstatusOriginal = this.vistaEstatus.regresaIdEstatus();
    }

    public void vinculaEditarProductosPedido(EditarProductosPedido vistaeditarproductos, String idpedidoeditar) {
        this.vistaeditarproductos = vistaeditarproductos;
        this.vistaeditarproductos.botonAgregarProductoEditarProductoPedido.addActionListener(this);
        this.vistaeditarproductos.botonGuardarEditarProductoPedido.addActionListener(this);
        this.vistaeditarproductos.botonRegresarEditarProductoPedido.addActionListener(this);
        this.vistaeditarproductos.popUpEliminarProducto.addActionListener(this);
        LlenarTablaProductosPedido(idpedidoeditar);
      //  System.out.println("vinculo con editar pedidos productos");
    }

    public void VinculaRegistroPedido(RegistrarPedido vistaPedido) {
        this.vistapedido = vistaPedido;
        this.vistapedido.botonMenos.addActionListener(this);
        this.vistapedido.botonMas.addActionListener(this);
        this.vistapedido.botonRegresarRegistrarPedido.addActionListener(this);
        this.vistapedido.botonGuardarRegistrarPedido.addActionListener(this);
        this.vistapedido.txtBuscarClienteRegistrarPedido.addKeyListener(this);
        vistaAdmin.TablaPedidos.getColumnModel().getColumn(0).setMaxWidth(0);

        vistaAdmin.TablaPedidos.getColumnModel().getColumn(0).setMinWidth(0);

        vistaAdmin.TablaPedidos.getColumnModel().getColumn(0).setPreferredWidth(0);

    }

    public void LlenarTablaPedidos(JTable tabla) {
        DefaultTableModel modeloT = new DefaultTableModel();
        tabla.setModel(modeloT);
        modeloT.addColumn("ID Pedido");
        modeloT.addColumn("Fecha del Pedido");
        modeloT.addColumn("Estatus del Pedido");
        modeloT.addColumn("Cliente");
        modeloT.addColumn("Empleado");

        Object[] columna = new Object[5];
        ArrayList<Pedido> listaPedidos = modeloPedido.listPedido();
        int numRegistros = listaPedidos.size();
        ArrayList<String> lista = modeloPedido.consultarEstatusPedido();
        ArrayList<Cliente> listaNClientes = modeloPedido.consultarNombreCliente();
        ArrayList<Empleado> listaNEmpleado = modeloPedido.consultarNombreEmpleado();

        int k;
        String nombreCompleto, nombreEmpleado;

        for (int i = 0; i < numRegistros; i++) {

            k = listaPedidos.get(i).getIdEstatusPedido();

            columna[0] = listaPedidos.get(i).getIdPedido();
            columna[1] = listaPedidos.get(i).getFechaPedido();
            columna[2] = lista.get(k - 1);
            nombreCompleto = getNombreUser(listaNClientes, listaPedidos.get(i).getIdCliente()); //Revisar esta parte del código
            columna[3] = nombreCompleto;
            nombreEmpleado = getEmpleadoUser(listaNEmpleado, listaPedidos.get(i).getIdEmpleado());//Revisar esta parte del código
            columna[4] = nombreEmpleado;

            modeloT.addRow(columna);

            vistaAdmin.TablaPedidos.getColumnModel().getColumn(0).setMaxWidth(0);

            vistaAdmin.TablaPedidos.getColumnModel().getColumn(0).setMinWidth(0);

            vistaAdmin.TablaPedidos.getColumnModel().getColumn(0).setPreferredWidth(0);

        }
    }

    private String getNombreUser(ArrayList<Cliente> cli, int idClienteActual) {
        String nombre = "";
        if (cli != null && cli.size() > 0) {
            for (Cliente cliente : cli) {
                if (cliente.getidCliente() == idClienteActual) {
                    nombre = cliente.getNombre() + " " + cliente.getApellido();
                    return nombre;
                }
            }
        }
        return nombre;
    }

    private String getEmpleadoUser(ArrayList<Empleado> emp, int idEmpleadoActual) {
        String nombre = "";
        if (emp != null && emp.size() > 0) {
            for (Empleado empleado : emp) {
                if (empleado.getIdEmpleado() == idEmpleadoActual) {
                    nombre = empleado.getNombre() + " " + empleado.getApellido();
                    return nombre;
                }
            }
        }
        return nombre;
    }

    public void busquedaPedidos() {
        if (vistaAdmin.comboBusquedaxEstatus.getSelectedIndex() == 0) {

            LlenarTablaPedidos(this.vistaAdmin.TablaPedidos);
        } else {
            int estatus = vistaAdmin.comboBusquedaxEstatus.getSelectedIndex();
            DefaultTableModel modeloT = new DefaultTableModel();
            vistaAdmin.TablaPedidos.setModel(modeloT);
            modeloT.addColumn("ID Pedido");
            modeloT.addColumn("Fecha del Pedido");
            modeloT.addColumn("Estatus del Pedido");
            modeloT.addColumn("Cliente");
            modeloT.addColumn("Empleado");

            Object[] columna = new Object[5];

            ArrayList<Pedido> listaPedidos = modeloPedido.listPedido();
            int numRegistros = modeloPedido.buscarPedidoxEstatus(estatus).size();
            ArrayList<String> lista = modeloPedido.consultarEstatusPedido();
            ArrayList<Cliente> listaNClientes = modeloPedido.consultarNombreCliente();
            ArrayList<Empleado> listaNEmpleado = modeloPedido.consultarNombreEmpleado();
            int k;
            String nombreCompleto, nombreEmpleado;

            for (int i = 0; i < numRegistros; i++) {
                columna[0] = modeloPedido.buscarPedidoxEstatus(estatus).get(i).getIdPedido();
                columna[1] = modeloPedido.buscarPedidoxEstatus(estatus).get(i).getFechaPedido();
                k = modeloPedido.buscarPedidoxEstatus(estatus).get(i).getIdEstatusPedido();
                columna[2] = lista.get(k - 1);
                nombreCompleto = getNombreUser(listaNClientes, listaPedidos.get(i).getIdCliente());
                columna[3] = nombreCompleto;
                nombreEmpleado = getEmpleadoUser(listaNEmpleado, listaPedidos.get(i).getIdEmpleado());
                columna[4] = nombreEmpleado;

                modeloT.addRow(columna);

                vistaAdmin.TablaPedidos.getColumnModel().getColumn(0).setMaxWidth(0);

                vistaAdmin.TablaPedidos.getColumnModel().getColumn(0).setMinWidth(0);

                vistaAdmin.TablaPedidos.getColumnModel().getColumn(0).setPreferredWidth(0);

            }
        }
    }

    //Llenar tabla editar productos del pedido
    public void LlenarTablaProductosPedido(String idpedidobuscar) {
        DefaultTableModel modeloT = new DefaultTableModel();
        vistaeditarproductos.TablaProductosPedido.setModel(modeloT);
        modeloT.addColumn("ID Pedido");
        modeloT.addColumn("Nombre Producto");
        modeloT.addColumn("Cantidad");
        modeloT.addColumn("Precio");
        modeloT.addColumn("Sub Total");

        Object[] columna = new Object[5];

        ArrayList<ProductoPedido> listaProductosPedidos = modeloPedido.consultarProductosPedido(idpedidobuscar);
        ArrayList<Producto> listaproductos = modeloPedido.listProducto();

        int numRegistros = listaProductosPedidos.size();
        int numregis = listaproductos.size();
        String produc = "";
        for (int i = 0; i < numRegistros; i++) {

            columna[0] = listaProductosPedidos.get(i).getIdPedido();
            //Obtener el nombre del producto

            for (int j = 0; j < numregis; j++) {
                if (listaproductos.get(j).getIdProducto() == listaProductosPedidos.get(i).getIdProducto()) {
                    produc = listaproductos.get(j).getNombre();
                }
            }
            columna[1] = produc;
            columna[2] = listaProductosPedidos.get(i).getCantidad();
            columna[3] = listaProductosPedidos.get(i).getPrecioProducto();
            int cant = listaProductosPedidos.get(i).getCantidad();
            double pre = listaProductosPedidos.get(i).getPrecioProducto();
            double subtotal = cant * pre;
            columna[4] = (subtotal);

            modeloT.addRow(columna);
            vistaeditarproductos.TablaProductosPedido.getColumnModel().getColumn(0).setMaxWidth(0);

            vistaeditarproductos.TablaProductosPedido.getColumnModel().getColumn(0).setMinWidth(0);

            vistaeditarproductos.TablaProductosPedido.getColumnModel().getColumn(0).setPreferredWidth(0);

        }
        double subtotal = 0;
        int numFilas = vistaeditarproductos.TablaProductosPedido.getRowCount();
        for (int h = 0; h < numFilas; h++) {
            subtotal = subtotal + (double) vistaeditarproductos.TablaProductosPedido.getValueAt(h, 4);
        }
        vistaeditarproductos.txtTotalEditarProductos.setText(String.valueOf(subtotal));
    }

    public void agregarProductosalaTabla() {

        if (vistapedido.comboListaProductos.getSelectedItem() != "Seleccione un Producto") {

            listaProductos = modeloPedido.consultarProductos();
            int pseleccionado = (vistapedido.comboListaProductos.getSelectedIndex()) - 1;

            Producto productoSeleccionado = listaProductos.get(pseleccionado);

            Double pruni = productoSeleccionado.getPrecio();//Toma el precio del producto
            int cant = (int) vistapedido.spinnerCantidadRegistrarPedido.getValue();//Toma el valor del spiner
            Double total = (pruni * cant);//operacion entre valor de espiner y precio

            DefaultTableModel modelo = (DefaultTableModel) vistapedido.tablaPedidos.getModel();
            // modelo.setRowCount(0);

            //Agrega los datos de los productos en la tabla 
            Object[] fila = new Object[modelo.getColumnCount()];

            for (int i = 0; i < 1; i++) {
                fila[0] = productoSeleccionado.getIdProducto();
                fila[1] = productoSeleccionado.getNombre();
                fila[2] = productoSeleccionado.getPrecio();
                fila[3] = vistapedido.spinnerCantidadRegistrarPedido.getValue();
                fila[4] = total;
                modelo.addRow(fila);
                vistapedido.tablaPedidos.getColumnModel().getColumn(0).setMaxWidth(0);

                vistapedido.tablaPedidos.getColumnModel().getColumn(0).setMinWidth(0);

                vistapedido.tablaPedidos.getColumnModel().getColumn(0).setPreferredWidth(0);
            }

            //Hace el calculo del total a pagar
            cantidadtotal = cantidadtotal + total;
            vistapedido.txtTotalPagar.setText(String.valueOf(cantidadtotal));

            vistapedido.spinnerCantidadRegistrarPedido.setValue(1);
            vistapedido.comboListaProductos.setSelectedItem("Seleccione un Producto");

        } else {
            JOptionPane.showMessageDialog(null, "Selecciona un producto de la lista"); //Excepcion si no se elige un elemento
        }

    }

    public void asignarCliente() {
        String tele = vistapedido.txtBuscarClienteRegistrarPedido.getText();
        int numRegis = modeloPedido.buscarClienteXTelefono(tele).size();
        if (numRegis == 0) {
            JOptionPane.showMessageDialog(null, "El cliente no se encuentra registrado, verifique el número");
        } else {

            String nombre = modeloPedido.buscarClienteXTelefono(tele).get(0).getNombre();
            String apellido = modeloPedido.buscarClienteXTelefono(tele).get(0).getApellido();
            int idCliente = modeloPedido.buscarClienteXTelefono(tele).get(0).getidCliente();
            vistapedido.labelNombreClienteRegistrarPedido.setText(nombre + " " + apellido);
            idClient = idCliente;
            //System.out.println(idClient);
        }
    }

    public void eliminarProductosdelaTabla() {
        int index = vistapedido.tablaPedidos.getSelectedRow();//Digo que tabla es sacandola de la seleccion
        DefaultTableModel modelo = (DefaultTableModel) vistapedido.tablaPedidos.getModel();
        Object menoscantidad = modelo.getValueAt(index, 4);
        Double en = (Double) (menoscantidad);
        cantidadtotal = cantidadtotal - en;
        vistapedido.txtTotalPagar.setText(String.valueOf(cantidadtotal));
        modelo.removeRow(index);
    }

    //Buscar pedido por nombre del cliente
    public void busquedaPedidosXNombreCliente() {
        String nombre = vistaAdmin.txtBuscarPedido.getText();

        DefaultTableModel modeloT = new DefaultTableModel();
        vistaAdmin.TablaPedidos.setModel(modeloT);
        modeloT.addColumn("ID Pedido");
        modeloT.addColumn("Fecha del Pedido");
        modeloT.addColumn("Estatus del Pedido");
        modeloT.addColumn("Cliente");
        modeloT.addColumn("Empleado");

        Object[] columna = new Object[5];

        ArrayList<Cliente> listaNClientespb = modeloPedido.consultarDatosCliente(nombre);
        int numregistrosclientes = listaNClientespb.size();
        //System.out.println(numregistrosclientes+" tamaño del arreglo numero de clientes");
        String idclientebuscado;
        ArrayList<Pedido> listaPedidoscliente = new ArrayList<>();

        for (int i = 0; i < numregistrosclientes; i++) {
            idclientebuscado = String.valueOf(listaNClientespb.get(i).getidCliente());
            //System.out.println("Entro al for");
           
            listaPedidoscliente.addAll(modeloPedido.buscarPedidoxid(idclientebuscado));

            
        }

        int numRegistros = listaPedidoscliente.size();
        // System.out.println(numRegistros+"numero de registros de la lista de los pedidos cientes");
        ArrayList<String> lista = modeloPedido.consultarEstatusPedido();
        ArrayList<Cliente> listaNClientes = modeloPedido.consultarNombreCliente();
        ArrayList<Empleado> listaNEmpleado = modeloPedido.consultarNombreEmpleado();
        int k;
        String nombreCompleto, nombreEmpleado;

        for (int i = 0; i < numRegistros; i++) {
            columna[0] = listaPedidoscliente.get(i).getIdPedido();
            columna[1] = listaPedidoscliente.get(i).getFechaPedido();
            k = listaPedidoscliente.get(i).getIdEstatusPedido();
            columna[2] = lista.get(k - 1);
            nombreCompleto = getNombreUser(listaNClientes, listaPedidoscliente.get(i).getIdCliente());
            columna[3] = nombreCompleto;
            nombreEmpleado = getEmpleadoUser(listaNEmpleado, listaPedidoscliente.get(i).getIdEmpleado());
            columna[4] = nombreEmpleado;

            modeloT.addRow(columna);

            vistaAdmin.TablaPedidos.getColumnModel().getColumn(0).setMaxWidth(0);

            vistaAdmin.TablaPedidos.getColumnModel().getColumn(0).setMinWidth(0);

            vistaAdmin.TablaPedidos.getColumnModel().getColumn(0).setPreferredWidth(0);

        }

    }

    //limpiar tabla
    public void limpiarTabla() {
        DefaultTableModel modelo = (DefaultTableModel) vistaeditarproductos.TablaProductosPedido.getModel();
        for (int i = 0; i < vistaeditarproductos.TablaProductosPedido.getRowCount(); i++) {
            modelo.removeRow(i);
            i -= 1;
        }
    }

    //limpiar tabla
    public void limpiarTablaPedidos() {
        DefaultTableModel modelo = (DefaultTableModel) vistapedido.tablaPedidos.getModel();
        for (int i = 0; i < vistapedido.tablaPedidos.getRowCount(); i++) {
            modelo.removeRow(i);
            i -= 1;
        }
    }
    
    
    //Asignar datos a la tabla de editar productos
    public void agregarProductosalaTablaEditarPedido() {

        if (vistaeditarproductos.comboProducosEditarPedido.getSelectedItem() != "Selecciona...") {
            int idpedid = (int) vistaeditarproductos.TablaProductosPedido.getValueAt(0, 0);
            System.out.println(idpedid);
            listaProductosEdicion = modeloPedido.consultarProductos();
            int pseleccionado = (vistaeditarproductos.comboProducosEditarPedido.getSelectedIndex()) - 1;

            Producto productoSeleccionado = listaProductosEdicion.get(pseleccionado);

            Double pruni = productoSeleccionado.getPrecio();//Toma el precio del producto
            int cant = (int) vistaeditarproductos.spinnerCantidadEditarProductosPedido.getValue();//Toma el valor del spiner
            Double total = (pruni * cant);//operacion entre valor de espiner y precio

            DefaultTableModel modelo = (DefaultTableModel) vistaeditarproductos.TablaProductosPedido.getModel();

            //Agrega los datos de los productos en la tabla 
            Object[] fila = new Object[modelo.getColumnCount()];

            for (int i = 0; i < 1; i++) {
                fila[0] = idpedid;
                fila[1] = productoSeleccionado.getNombre();
                fila[2] = vistaeditarproductos.spinnerCantidadEditarProductosPedido.getValue();
                fila[3] = productoSeleccionado.getPrecio();
                fila[4] = total;
                modelo.addRow(fila);
                vistaeditarproductos.TablaProductosPedido.getColumnModel().getColumn(0).setMaxWidth(0);

                vistaeditarproductos.TablaProductosPedido.getColumnModel().getColumn(0).setMinWidth(0);

                vistaeditarproductos.TablaProductosPedido.getColumnModel().getColumn(0).setPreferredWidth(0);

            }

            //Hace el calculo del total a pagar
            cantidadtotalEdicion = Double.parseDouble(vistaeditarproductos.txtTotalEditarProductos.getText());
            cantidadtotalEdicion = cantidadtotalEdicion + total;
            vistaeditarproductos.txtTotalEditarProductos.setText(String.valueOf(cantidadtotalEdicion));

            vistaeditarproductos.spinnerCantidadEditarProductosPedido.setValue(1);
            vistaeditarproductos.comboProducosEditarPedido.setSelectedItem("Selecciona...");

        } else {
            JOptionPane.showMessageDialog(null, "Selecciona un producto de la lista"); //Excepcion si no se elige un elemento
        }

    }

    public void actionPerformed(ActionEvent e) {

//Búsqueda del combobox
        if (e.getSource() == vistaAdmin.comboBusquedaxEstatus) {
            busquedaPedidos();
        }

        if (e.getSource() == vistapedido.botonMas) {
            agregarProductosalaTabla();
        }

        if (e.getSource() == vistapedido.botonMenos) {
            eliminarProductosdelaTabla();
        }

        if (e.getSource() == vistapedido.botonRegresarRegistrarPedido) {
            vistapedido.setVisible(false);

        }

        if (e.getSource() == vistaEstatus.botonGuardarEditarEstatusPedido) {
            String idPedido = IdPedidoEdicionEstatus;
            String idEstatusPedido = String.valueOf(vistaEstatus.comboCambiarEstatusPedido.getSelectedIndex());
            System.out.println(idEstatusOriginal);
            if (idEstatusPedido.equals("0")) {
                JOptionPane.showMessageDialog(null, "Selecciona un Estatus para el pedido");
            } else {
                if (idEstatusOriginal.equals("Cancelado")) {
                    JOptionPane.showMessageDialog(null, "El estatus del Pedido NO puede ser cambiado");
                }
                if (idEstatusOriginal.equals("Entregado")) {
                    JOptionPane.showMessageDialog(null, "El estatus del Pedido NO puede ser cambiado");
                }
                if (idEstatusOriginal.equals("En Proceso") && !"2".equals(idEstatusPedido)) {
                    String rptaRegistro = modeloPedido.editaEstatusPedido(idPedido, idEstatusPedido);
                    if (rptaRegistro != null && rptaRegistro.equals("Registro Exitoso")) {
                        JOptionPane.showMessageDialog(null, "El estatus del Pedido ha sido Editado con éxito");
                        vistaEstatus.dispose();
                        LlenarTablaPedidos(this.vistaAdmin.TablaPedidos);
                    } else {
                        JOptionPane.showMessageDialog(null, "Ocurrio un error al editar el pedido");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "El pedido ya está en proceso");
                }
            }
        }

        if (e.getSource() == vistaEstatus.botonRegresarEditarEstatusPedido) {
            vistaEstatus.setVisible(false);

        }
//Guardar El pedido
        if (e.getSource() == vistapedido.botonGuardarRegistrarPedido) {

            String usr = vistapedido.labelRegistrarPedidoCajero.getText();

            int idEmpleado = modeloPedido.consultaridEmpleado(usr).get(0);

            String id = String.valueOf(idEmpleado);

            System.out.println(fechaActual);
            String estatusPedidous = "2";
            String idCliente = String.valueOf(idClient);

            //Guarda el pedido
            String rptaRegistro = modeloPedido.insertarPedido(fechaActual, estatusPedidous, idCliente, id);

            //Guardar la lista de Productos:
            String idPedido = String.valueOf(modeloPedido.consultarUltimoPedido());

            System.out.println("id del pedido" + idPedido);

            String idProducto;
            String cantidad;
            String precio;
            String rptaRegistroProductos = "";

            for (int i = 0; i < vistapedido.tablaPedidos.getRowCount(); i++) {

                idProducto = String.valueOf(vistapedido.tablaPedidos.getValueAt(i, 0));
                
                precio = String.valueOf(vistapedido.tablaPedidos.getValueAt(i, 2));
                
                cantidad = String.valueOf(vistapedido.tablaPedidos.getValueAt(i, 3));
                

                rptaRegistroProductos = modeloPedido.insertarProductosPedido(idPedido, idProducto, cantidad, precio);
            }

            if (rptaRegistro != null && rptaRegistro.equals("Registro Exitoso") && rptaRegistroProductos != null && rptaRegistroProductos.equals("Registro Exitoso")) {
                JOptionPane.showMessageDialog(null, "El registro del Pedido con sus productos ha sido guardado con éxito");
                LlenarTablaPedidos(vistaAdmin.TablaPedidos);
                //Limpiar campos de la ventana
                vistapedido.txtBuscarClienteRegistrarPedido.setText("");
                vistapedido.txtTotalPagar.setText("");
                vistapedido.labelNombreClienteRegistrarPedido.setText("Nombre Cliente");
                cantidadtotal = 0.0;
                idClient = 0;
                limpiarTablaPedidos();

            } else {
                JOptionPane.showMessageDialog(null, "Ocurrio un error al ingresar el registro de los productos o pedido");
            }
        }

        if (e.getSource() == vistaeditarproductos.botonRegresarEditarProductoPedido) {
            this.vistaeditarproductos.setVisible(false);
        }
        //Boton guardar en editar Productos del pedido
        if (e.getSource() == vistaeditarproductos.botonGuardarEditarProductoPedido) {
            String idPedido;
            String idProducto;
            int idpr = 0;
            String cantidad;
            String precio;
            String nombreProducto;
            String rptaRegistroProductos = "";

            ArrayList<Producto> listaProductos = modeloPedido.listProducto();
            int recorrido = listaProductos.size();

            for (int i = 0; i < vistaeditarproductos.TablaProductosPedido.getRowCount(); i++) {
                idPedido = String.valueOf(vistaeditarproductos.TablaProductosPedido.getValueAt(i, 0));

                nombreProducto = String.valueOf(vistaeditarproductos.TablaProductosPedido.getValueAt(i, 1));

                for (int j = 0; j < recorrido; j++) {
                    if (nombreProducto.equals(listaProductos.get(j).getNombre())) {
                        idpr = listaProductos.get(j).getIdProducto();
                    }

                }

                idProducto = String.valueOf(idpr);
                precio = String.valueOf(vistaeditarproductos.TablaProductosPedido.getValueAt(i, 3));

                cantidad = String.valueOf(vistaeditarproductos.TablaProductosPedido.getValueAt(i, 2));

                rptaRegistroProductos = modeloPedido.insertarProductosPedido(idPedido, idProducto, cantidad, precio);

            }
            if (rptaRegistroProductos != null && rptaRegistroProductos.equals("Registro Exitoso")) {
                JOptionPane.showMessageDialog(null, "El registro de los productos ha sido guardado con éxito");
                vistaeditarproductos.txtTotalEditarProductos.setText("");
                vistaeditarproductos.comboProducosEditarPedido.setSelectedIndex(0);
                vistaeditarproductos.spinnerCantidadEditarProductosPedido.setValue(1);
                limpiarTabla();
                //vistaeditarproductos.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "Ocurrio un error al ingresar el registro de los productos");
            }
        }

        //boton eliminar productos edicion pedidos.
        if (e.getSource() == vistaeditarproductos.popUpEliminarProducto) {
            int idpedido = (int) vistaeditarproductos.TablaProductosPedido.getValueAt(vistaeditarproductos.TablaProductosPedido.getSelectedRow(), 0);
            String producto = (String) vistaeditarproductos.TablaProductosPedido.getValueAt(vistaeditarproductos.TablaProductosPedido.getSelectedRow(), 1);
            int idProducts = 0;
            ArrayList<Producto> listaProductos = modeloPedido.listProducto();
            int cantidadProductos = listaProductos.size();
            for (int i = 0; i < cantidadProductos; i++) {
                if (listaProductos.get(i).getNombre().equals(producto)) {
                    idProducts = listaProductos.get(i).getIdProducto();
                }

            }
            int rptaUsuario = JOptionPane.showConfirmDialog(null, "¿Seguro que deseas eliminar el producto " + producto + " de este pedido?");
            if (rptaUsuario == 0) {
                String idproductsString = String.valueOf(idProducts);
                String idpedidoString = String.valueOf(idpedido);
                int numFA = modeloPedido.eliminarProductoPedido(idpedidoString, idproductsString);
                if (numFA > 0) {
                    JOptionPane.showMessageDialog(null, "El registro del Producto " + producto + " ha sido Eliminado con éxito");
                    cantidadtotalEdicion = Double.parseDouble(vistaeditarproductos.txtTotalEditarProductos.getText());
                    Double cantid = (Double) vistaeditarproductos.TablaProductosPedido.getValueAt(vistaeditarproductos.TablaProductosPedido.getSelectedRow(), 4);
                    cantidadtotalEdicion = cantidadtotalEdicion - cantid;
                    vistaeditarproductos.txtTotalEditarProductos.setText(String.valueOf(cantidadtotalEdicion));
                    LlenarTablaProductosPedido(idpedidoString);
                } else {
                    JOptionPane.showMessageDialog(null, "Error al eliminar el producto");
                }

            }
        }

        //boton agregar editar productos
        if (e.getSource() == vistaeditarproductos.botonAgregarProductoEditarProductoPedido) {
            agregarProductosalaTablaEditarPedido();
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {
        char c = e.getKeyChar();
        String cadena = vistapedido.txtBuscarClienteRegistrarPedido.getText();
        if (c == (char) KeyEvent.VK_ENTER && cadena != "") {
            asignarCliente();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getSource() == vistaAdmin.txtBuscarPedido) {
            busquedaPedidosXNombreCliente();
            System.out.println("Entró  a la busqueda por nombre de cliente");
        }

    }

}
