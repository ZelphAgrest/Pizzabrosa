package Controlador;

import Modelo.ProductoDAO;
import Vista.MenuPrincipal;
import Vista.RegistrarProductos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LOGAN
 */
public class ControladorProducto implements ActionListener, Comunica, KeyListener {

    RegistrarProductos vistaproducto = new RegistrarProductos(this);
    MenuPrincipal vistaAdmin;
    ProductoDAO modeloProducto;

    public ControladorProducto(MenuPrincipal vistaAdmin, ProductoDAO modeloProducto) {
        this.modeloProducto = modeloProducto;
        this.vistaAdmin = vistaAdmin;
        this.vistaAdmin.botonRegistrarProducto.addActionListener(this);
        this.vistaAdmin.botonActualziarProducto.addActionListener(this);
        this.vistaAdmin.txtBuscarProducto.addKeyListener(this);
        LlenarTablaProductos(this.vistaAdmin.tablaProductos);
        
    }

    public void llenarCombo(RegistrarProductos vistaProducto) {
        this.vistaproducto = vistaProducto;
        int numRestric = modeloProducto.consultarRestricciones().size();
        for (int i = 0; i < numRestric; i++) {
            this.vistaproducto.comborestriccionesRegistrarProductos.addItem(modeloProducto.consultarRestricciones().get(i));
        }

    }

    public void VinculaRegistroProducto(RegistrarProductos vistaProducto) {
        this.vistaproducto = vistaProducto;
        this.vistaproducto.botonGuardarRegistrarProducto.addActionListener(this);
        this.vistaproducto.botonRegresarRegistrarProducto.addActionListener(this);
        this.vistaproducto.txtCodigoRegistrarProductos.addKeyListener(this);
        this.vistaproducto.txtPrecioRegistrarProductos.addKeyListener(this);
        
        
    }
     
    public void LlenarTablaProductos(JTable tabla) {
        DefaultTableModel modeloT = new DefaultTableModel();
        tabla.setModel(modeloT);
        modeloT.addColumn("ID Producto");
        modeloT.addColumn("Nombre");
        modeloT.addColumn("Codigo");
        modeloT.addColumn("Descripcion");
        modeloT.addColumn("Precio");
        modeloT.addColumn("Cantidad");
        modeloT.addColumn("Restriccion");

        Object[] columna = new Object[7];

        int numRegistros = modeloProducto.listProducto().size();
        ArrayList <String> lista =modeloProducto.consultarRestricciones();
        int k;
        
        for (int i = 0; i < numRegistros; i++) {
             k=modeloProducto.listProducto().get(i).getIdRestriccion();
            columna[0] = modeloProducto.listProducto().get(i).getIdProducto();
            columna[1] = modeloProducto.listProducto().get(i).getNombre();
            columna[2] = modeloProducto.listProducto().get(i).getCodigo();
            columna[3] = modeloProducto.listProducto().get(i).getDescripcion();
            columna[4] = modeloProducto.listProducto().get(i).getPrecio();
            columna[5] = modeloProducto.listProducto().get(i).getCantidad();
            columna[6] = lista.get(k-1);
            modeloT.addRow(columna);
            vistaAdmin.tablaProductos.getColumnModel().getColumn(0).setMaxWidth(0);
           
            vistaAdmin.tablaProductos.getColumnModel().getColumn(0).setMinWidth(0);

            vistaAdmin.tablaProductos.getColumnModel().getColumn(0).setPreferredWidth(0);
            
            
        }
    }
    
     public void busquedaProductos() {
        String palabra = vistaAdmin.txtBuscarProducto.getText();
        DefaultTableModel modeloT = new DefaultTableModel();
        vistaAdmin.tablaProductos.setModel(modeloT);
        modeloT.addColumn("ID Producto");
        modeloT.addColumn("Nombre");
        modeloT.addColumn("Codigo");
        modeloT.addColumn("Descripcion");
        modeloT.addColumn("Precio");
        modeloT.addColumn("Cantidad");
        modeloT.addColumn("Restriccion");

        Object[] columna = new Object[7];

        int numRegistros = modeloProducto.buscarProductoNombre(palabra).size();
        ArrayList <String> lista =modeloProducto.consultarRestricciones();
        int k;
        
        for (int i = 0; i < numRegistros; i++) {
            columna[0] = modeloProducto.buscarProductoNombre(palabra).get(i).getIdProducto();
            columna[1] = modeloProducto.buscarProductoNombre(palabra).get(i).getNombre();
            columna[2] = modeloProducto.buscarProductoNombre(palabra).get(i).getCodigo();
            columna[3] = modeloProducto.buscarProductoNombre(palabra).get(i).getDescripcion();
            columna[4] = modeloProducto.buscarProductoNombre(palabra).get(i).getPrecio();
            columna[5] = modeloProducto.buscarProductoNombre(palabra).get(i).getCantidad();
            k=modeloProducto.buscarProductoNombre(palabra).get(i).getIdRestriccion();
            columna[6] = lista.get(k-1);
            modeloT.addRow(columna);
            vistaAdmin.tablaProductos.getColumnModel().getColumn(0).setMaxWidth(0);
           
            vistaAdmin.tablaProductos.getColumnModel().getColumn(0).setMinWidth(0);

            vistaAdmin.tablaProductos.getColumnModel().getColumn(0).setPreferredWidth(0);
            
            
        }
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vistaproducto.botonGuardarRegistrarProducto) {
            String nombre = vistaproducto.txtNombreregistrarProductos.getText();
            String codigo = vistaproducto.txtCodigoRegistrarProductos.getText();
            String descripcion = vistaproducto.txtDescripcionRegistrarProductos.getText();
            String precio = vistaproducto.txtPrecioRegistrarProductos.getText();
            int cant = (int) vistaproducto.spinnerCantidadRegistrarProductos.getValue();
            int res = vistaproducto.comborestriccionesRegistrarProductos.getSelectedIndex();

            String cantidad = Integer.toString(cant);
            String restriccion = Integer.toString(res);

            if (nombre.equals("") || codigo.equals("") || descripcion.equals("") || precio.equals("") || cant <= 0 || res == 0) {
                JOptionPane.showMessageDialog(null, "Faltan campos con información por llenar");
            } else {
                String rptaRegistro = modeloProducto.insertarProducto(nombre, codigo, descripcion, precio, cantidad, restriccion);
                if (rptaRegistro != null && rptaRegistro.equals("Registro Exitoso")) {
                    JOptionPane.showMessageDialog(null, "El registro del Empleado " + nombre + " ha sido guardado con éxito");
                    vistaproducto.txtNombreregistrarProductos.setText("");
                    vistaproducto.txtCodigoRegistrarProductos.setText("");
                    vistaproducto.txtDescripcionRegistrarProductos.setText("");
                    vistaproducto.txtPrecioRegistrarProductos.setText("");
                    vistaproducto.comborestriccionesRegistrarProductos.setSelectedIndex(0);
                    vistaproducto.spinnerCantidadRegistrarProductos.setValue(0);
                    LlenarTablaProductos(this.vistaAdmin.tablaProductos);

                } else {
                    JOptionPane.showMessageDialog(null, "Ocurrio un error al ingresar el registro");
                }
            }
        }
        
        if (e.getSource() == vistaproducto.botonRegresarRegistrarProducto) {
            vistaproducto.setVisible(false);

        }

    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getSource() == vistaproducto.txtCodigoRegistrarProductos) {
            char c = e.getKeyChar();
            if ((c < '0' || c > '9')) {
                e.consume();
            }
        }
        if (e.getSource() == vistaproducto.txtPrecioRegistrarProductos) {
            char c = e.getKeyChar();
            if ((c < '0' || c > '9')&& c != '.') {
                e.consume();
            }
        }
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
         if (e.getSource() == vistaAdmin.txtBuscarProducto) {
            busquedaProductos();
        }
    }

}
