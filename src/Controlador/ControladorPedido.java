package Controlador;

import Modelo.Empleado;
import Modelo.Pedido;
import Modelo.PedidoDAO;
import Modelo.Producto;
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

    MenuPrincipal vistaAdmin;
    PedidoDAO modeloPedido;
    Double cantidadtotal = 0.0;
    ArrayList<Producto> listaProductos;
    int idClient = 0;

    //Obtiene la fecha del sistema y le da el formato
    SimpleDateFormat fecha = new SimpleDateFormat("yyyy-MM-dd");
    Date now = new Date(System.currentTimeMillis());
    String fechaActual = fecha.format(now);

    public ControladorPedido(MenuPrincipal vistaAdmin, PedidoDAO modeloPedido) {
        this.vistaAdmin = vistaAdmin;
        this.modeloPedido = modeloPedido;
        this.vistaAdmin.comboBusquedaxEstatus.addActionListener(this);
        LlenarTablaPedidos(this.vistaAdmin.TablaPedidos);
    }

    public void llenarCombo(RegistrarPedido vistaPedido) {
        this.vistapedido = vistaPedido;
        int numProductos = modeloPedido.consultarProductos().size();
        for (int i = 0; i < numProductos; i++) {
            this.vistapedido.comboListaProductos.addItem(modeloPedido.consultarProductos().get(i).getNombre());
        }

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

        int numRegistros = modeloPedido.listPedido().size();
        ArrayList<String> lista = modeloPedido.consultarEstatusPedido();
        ArrayList<String> listaNClientes = modeloPedido.consultarNombreCliente();
        ArrayList<String> listaNEmpleado = modeloPedido.consultarNombreEmpleado();

        int k, l, m;
        String nombreCompleto, nombreEmpleado;

        for (int i = 0; i < numRegistros; i++) {

            k = modeloPedido.listPedido().get(i).getIdEstatusPedido();
            l = modeloPedido.listPedido().get(i).getIdCliente();
            m = modeloPedido.listPedido().get(i).getIdEmpleado();

            columna[0] = modeloPedido.listPedido().get(i).getIdPedido();
            columna[1] = modeloPedido.listPedido().get(i).getFechaPedido();
            columna[2] = lista.get(k - 1);
            nombreCompleto = listaNClientes.get(l - 1) + " " + listaNClientes.get(l);//Revisar esta parte del código
            columna[3] = nombreCompleto;
            nombreEmpleado = listaNEmpleado.get(m - 1) + " " + listaNEmpleado.get(m);//Revisar esta parte del código
            columna[4] = nombreEmpleado;

            modeloT.addRow(columna);

            vistaAdmin.TablaPedidos.getColumnModel().getColumn(0).setMaxWidth(0);

            vistaAdmin.TablaPedidos.getColumnModel().getColumn(0).setMinWidth(0);

            vistaAdmin.TablaPedidos.getColumnModel().getColumn(0).setPreferredWidth(0);

        }
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

            int numRegistros = modeloPedido.buscarPedidoxEstatus(estatus).size();
            ArrayList<String> lista = modeloPedido.consultarEstatusPedido();
            ArrayList<String> listaNClientes = modeloPedido.consultarNombreCliente();
            ArrayList<String> listaNEmpleado = modeloPedido.consultarNombreEmpleado();
            int k, l, m;
            String nombreCompleto, nombreEmpleado;

            for (int i = 0; i < numRegistros; i++) {
                columna[0] = modeloPedido.buscarPedidoxEstatus(estatus).get(i).getIdPedido();
                columna[1] = modeloPedido.buscarPedidoxEstatus(estatus).get(i).getFechaPedido();
                k = modeloPedido.buscarPedidoxEstatus(estatus).get(i).getIdEstatusPedido();
                columna[2] = lista.get(k - 1);
                l = modeloPedido.buscarPedidoxEstatus(estatus).get(i).getIdCliente();
                m = modeloPedido.buscarPedidoxEstatus(estatus).get(i).getIdEmpleado();
                nombreCompleto = listaNClientes.get(l - 1) + " " + listaNClientes.get(l);
                columna[3] = nombreCompleto;
                nombreEmpleado = listaNEmpleado.get(m - 1) + " " + listaNEmpleado.get(m);
                columna[4] = nombreEmpleado;

                modeloT.addRow(columna);

                vistaAdmin.TablaPedidos.getColumnModel().getColumn(0).setMaxWidth(0);

                vistaAdmin.TablaPedidos.getColumnModel().getColumn(0).setMinWidth(0);

                vistaAdmin.TablaPedidos.getColumnModel().getColumn(0).setPreferredWidth(0);

            }
        }
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
            System.out.println(idClient);
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

        if (e.getSource() == vistapedido.botonGuardarRegistrarPedido) {

            String usr = vistapedido.labelRegistrarPedidoCajero.getText();

            int idEmpleado = modeloPedido.consultaridEmpleado(usr).get(0);
            
            String id = String.valueOf(idEmpleado);

            System.out.println(fechaActual);
            String estatusPedidous = "2";
            String idCliente = String.valueOf(idClient);

            String rptaRegistro = modeloPedido.insertarPedido(fechaActual, estatusPedidous, idCliente, id);
            if (rptaRegistro != null && rptaRegistro.equals("Registro Exitoso")) {
                JOptionPane.showMessageDialog(null, "El registro del Pedido ha sido guardado con éxito");

            } else {
                JOptionPane.showMessageDialog(null, "Ocurrio un error al ingresar el registro");
            }

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

    }

}
