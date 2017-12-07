package Controlador;

import Modelo.ProductoDAO;
import Vista.EditarProductos;
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
    EditarProductos vistaEditarProducto = new EditarProductos(this);
    MenuPrincipal vistaAdmin;
    ProductoDAO modeloProducto;

    public ControladorProducto(MenuPrincipal vistaAdmin, ProductoDAO modeloProducto) {
        this.modeloProducto = modeloProducto;
        this.vistaAdmin = vistaAdmin;
        this.vistaAdmin.botonRegistrarProducto.addActionListener(this);
        this.vistaAdmin.botonActualziarProducto.addActionListener(this);
        this.vistaAdmin.txtBuscarProducto.addKeyListener(this);
        this.vistaAdmin.popUpEliminarProducto.addActionListener(this);
        LlenarTablaProductos(this.vistaAdmin.tablaProductos);

    }

    public void llenarCombo(RegistrarProductos vistaProducto) {
        this.vistaproducto = vistaProducto;
        int numRestric = modeloProducto.consultarRestricciones().size();
        for (int i = 0; i < numRestric; i++) {
            this.vistaproducto.comborestriccionesRegistrarProductos.addItem(modeloProducto.consultarRestricciones().get(i));
        }

    }

    public void llenarComboEditarProducto(EditarProductos vistaProducto) {
        this.vistaEditarProducto = vistaProducto;
        int numRestric = modeloProducto.consultarRestricciones().size();
        for (int i = 0; i < numRestric; i++) {
            this.vistaEditarProducto.comboBoxRestriccionesEditarProducto.addItem(modeloProducto.consultarRestricciones().get(i));
        }

    }

    public void llenaCamposEditarProducto() {
        int filaEditar = vistaAdmin.tablaProductos.getSelectedRow();
        int numFS = vistaAdmin.tablaProductos.getSelectedRowCount();
        if (filaEditar >= 0 && numFS == 1) {
            vistaEditarProducto.txtIdProductoEditarProducto.setText("" + vistaAdmin.tablaProductos.getValueAt(filaEditar, 0));
            vistaEditarProducto.txtNombreEditarProducto.setText((String) vistaAdmin.tablaProductos.getValueAt(filaEditar, 1));
            vistaEditarProducto.txtCodigoEditarProducto.setText("" + vistaAdmin.tablaProductos.getValueAt(filaEditar, 2));
            vistaEditarProducto.txtDescripcionEditarProducto.setText((String) vistaAdmin.tablaProductos.getValueAt(filaEditar, 3));
            vistaEditarProducto.txtPrecioEditarProducto.setText("" + vistaAdmin.tablaProductos.getValueAt(filaEditar, 4));
            vistaEditarProducto.spinnerCantidadEditarProducto.setValue(vistaAdmin.tablaProductos.getValueAt(filaEditar, 5));
            vistaEditarProducto.comboBoxRestriccionesEditarProducto.setSelectedItem(vistaAdmin.tablaProductos.getValueAt(filaEditar, 6));

        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un Empleado");
        }

    }

    public void vinculaEditaProducto(EditarProductos vep, MenuPrincipal vistaAdmin) {
        this.vistaEditarProducto = vep;
        this.vistaAdmin = vistaAdmin;
        this.vistaEditarProducto.botonGuardarEditarProducto.addActionListener(this);
        this.vistaEditarProducto.botonRegresarEditarProducto.addActionListener(this);
        this.vistaEditarProducto.txtPrecioEditarProducto.addKeyListener(this);
        this.vistaEditarProducto.txtCodigoEditarProducto.addKeyListener(this);
        llenaCamposEditarProducto();

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
        ArrayList<String> lista = modeloProducto.consultarRestricciones();
        int k;

        for (int i = 0; i < numRegistros; i++) {
            k = modeloProducto.listProducto().get(i).getIdRestriccion();
            columna[0] = modeloProducto.listProducto().get(i).getIdProducto();
            columna[1] = modeloProducto.listProducto().get(i).getNombre();
            columna[2] = modeloProducto.listProducto().get(i).getCodigo();
            columna[3] = modeloProducto.listProducto().get(i).getDescripcion();
            columna[4] = modeloProducto.listProducto().get(i).getPrecio();
            columna[5] = modeloProducto.listProducto().get(i).getCantidad();
            columna[6] = lista.get(k - 1);
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
        ArrayList<String> lista = modeloProducto.consultarRestricciones();
        int k;

        for (int i = 0; i < numRegistros; i++) {
            columna[0] = modeloProducto.buscarProductoNombre(palabra).get(i).getIdProducto();
            columna[1] = modeloProducto.buscarProductoNombre(palabra).get(i).getNombre();
            columna[2] = modeloProducto.buscarProductoNombre(palabra).get(i).getCodigo();
            columna[3] = modeloProducto.buscarProductoNombre(palabra).get(i).getDescripcion();
            columna[4] = modeloProducto.buscarProductoNombre(palabra).get(i).getPrecio();
            columna[5] = modeloProducto.buscarProductoNombre(palabra).get(i).getCantidad();
            k = modeloProducto.buscarProductoNombre(palabra).get(i).getIdRestriccion();
            columna[6] = lista.get(k - 1);
            modeloT.addRow(columna);
            vistaAdmin.tablaProductos.getColumnModel().getColumn(0).setMaxWidth(0);

            vistaAdmin.tablaProductos.getColumnModel().getColumn(0).setMinWidth(0);

            vistaAdmin.tablaProductos.getColumnModel().getColumn(0).setPreferredWidth(0);

        }
    }

    public void actionPerformed(ActionEvent e) {
//Guardar Productos
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
                    JOptionPane.showMessageDialog(null, "El registro del Producto " + nombre + " ha sido guardado con éxito");
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

        //Guardar edición de Productos
        if (e.getSource() == vistaEditarProducto.botonGuardarEditarProducto) {
            String idProducto = vistaEditarProducto.txtIdProductoEditarProducto.getText();
            String nombre = vistaEditarProducto.txtNombreEditarProducto.getText();
            String codigo = vistaEditarProducto.txtCodigoEditarProducto.getText();
            String precio = vistaEditarProducto.txtPrecioEditarProducto.getText();
            String descripcion = vistaEditarProducto.txtDescripcionEditarProducto.getText();
            int cant = (int) vistaEditarProducto.spinnerCantidadEditarProducto.getValue();
            int res = vistaEditarProducto.comboBoxRestriccionesEditarProducto.getSelectedIndex();

            String cantidad = Integer.toString(cant);
            String restriccion = Integer.toString(res);
            if (nombre.equals("") || codigo.equals("") || descripcion.equals("") || precio.equals("") || cant <= 0 || res == 0) {
                JOptionPane.showMessageDialog(null, "Faltan campos con información por llenar");
            } else {
                String rptaRegistro = modeloProducto.editaProducto(idProducto, nombre, codigo, descripcion, precio, cantidad, restriccion);
                if (rptaRegistro != null && rptaRegistro.equals("Registro Exitoso")) {
                    JOptionPane.showMessageDialog(null, "El registro del Producto " + nombre + " ha sido Editado con éxito");
                    vistaEditarProducto.dispose();
                    LlenarTablaProductos(this.vistaAdmin.tablaProductos);
                } else {
                    JOptionPane.showMessageDialog(null, "Ocurrio un error al editar el registro");
                }
            }
        }
        
        //Eliminar Productos
        if (e.getSource() == vistaAdmin.popUpEliminarProducto) {
            int filaInicio = vistaAdmin.tablaProductos.getSelectedRow();
            int numFS = vistaAdmin.tablaProductos.getSelectedRowCount();
            String id = "";
            String nombre = "";
            if (filaInicio > 0) {
                for (int i = 0; i < numFS; i++) {
                    id = String.valueOf(vistaAdmin.tablaProductos.getValueAt(i + filaInicio, 0));
                    nombre = String.valueOf(vistaAdmin.tablaProductos.getValueAt(i + filaInicio, 1));

                    int rptaUsuario = JOptionPane.showConfirmDialog(null, "¿Seguro que deseas eliminar el registro del Producto " + nombre + "?");
                    if (rptaUsuario == 0) {
                        modeloProducto.eliminarProducto(id);
                        JOptionPane.showMessageDialog(null, "El registro del producto " + nombre + " ha sido Eliminado con éxito");
                        
                    }
                }
                LlenarTablaProductos(vistaAdmin.tablaProductos);
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione al menos una fila a eliminar");
            }
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
            if ((c < '0' || c > '9') && c != '.') {
                e.consume();
            }
        }

        if (e.getSource() == vistaEditarProducto.txtCodigoEditarProducto) {
            char c = e.getKeyChar();
            if ((c < '0' || c > '9')) {
                e.consume();
            }
        }
        if (e.getSource() == vistaEditarProducto.txtPrecioEditarProducto) {
            char c = e.getKeyChar();
            if ((c < '0' || c > '9') && c != '.') {
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
