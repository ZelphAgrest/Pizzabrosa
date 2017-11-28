package Controlador;

import Modelo.ClienteDAO;
import Vista.EditarCliente;
import Vista.MenuPrincipal;
import Vista.RegistrarClientes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ControladorCliente implements ActionListener, KeyListener, Comunica {

    RegistrarClientes vista = new RegistrarClientes(this);
    EditarCliente vistaEC = new EditarCliente(this);
    MenuPrincipal vistaAdmin; 
    ClienteDAO modelo; 

    public ControladorCliente(EditarCliente vistaEdicion, ClienteDAO modelo, MenuPrincipal menu) {
        this.modelo = modelo;
        this.vistaEC = vistaEdicion;
        this.vistaAdmin = menu;
        this.vistaEC.botonGuardarEditarCliente.addActionListener(this);
        this.vistaEC.botonRegresarEditarCliente.addActionListener(this);
        this.vistaEC.txtNombreEditarC.addKeyListener(this);
        this.vistaEC.txtApellidoEditarCliente.addKeyListener(this);
        this.vistaEC.txtTelefonoEditarCliente.addKeyListener(this);
        this.vistaEC.txtEmailEditarCliente.addKeyListener(this);
        this.vistaEC.txtDireccionEditarCliente.addKeyListener(this);
        this.vistaEC.txtCPEditarClientes.addKeyListener(this);
        this.vistaEC.txtCiudadEditarClientes.addKeyListener(this);
        this.vistaAdmin.txtBusquedaCliente.addKeyListener(this);
        //vistaEC.txtNombreEditarC.setText("prueba texto");
        this.llenaCamposEdicionCliente();

    }

    //Único Construcctor que debe existir
    public ControladorCliente(MenuPrincipal vistaAdmin, ClienteDAO modelo) {
        this.modelo = modelo;
        this.vistaAdmin = vistaAdmin;
        this.vistaAdmin.botonActualizar.addActionListener(this);
        this.vistaAdmin.editarPopUpClientes.addActionListener(this);
        this.vistaAdmin.eliminarPopUpClientes.addActionListener(this);
        this.vistaAdmin.botonBuscar.addActionListener(this);
        this.vistaAdmin.txtBusquedaCliente.addKeyListener(this);
        LlenarTabla(this.vistaAdmin.tablitaClientes);
    }

    //Método para registrar Clientes
    public void vinculaRegistroClientes(RegistrarClientes vistaRC) {
        this.vista = vistaRC;
        this.vista.botonGuardar.addActionListener(this);
        this.vista.botonRegresar.addActionListener(this);
        this.vista.txtNombre.addKeyListener(this);
        this.vista.txtApellido.addKeyListener(this);
        this.vista.txtTelefono.addKeyListener(this);
        this.vista.txtEmail.addKeyListener(this);
        this.vista.txtDireccion.addKeyListener(this);
        this.vista.txtCP.addKeyListener(this);
        this.vista.txtCiudad.addKeyListener(this);
    }

    //Método para Editar Clientes
    public void vinculaEditaClientes(EditarCliente vistaEdC, MenuPrincipal menu) {
        this.vistaEC = vistaEdC;
        this.vistaAdmin = menu;
        this.vistaEC.botonGuardarEditarCliente.addActionListener(this);
        this.vistaEC.botonRegresarEditarCliente.addActionListener(this);
        this.vistaEC.txtNombreEditarC.addKeyListener(this);
        this.vistaEC.txtApellidoEditarCliente.addKeyListener(this);
        this.vistaEC.txtTelefonoEditarCliente.addKeyListener(this);
        this.vistaEC.txtEmailEditarCliente.addKeyListener(this);
        this.vistaEC.txtDireccionEditarCliente.addKeyListener(this);
        this.vistaEC.txtCPEditarClientes.addKeyListener(this);
        this.vistaEC.txtCiudadEditarClientes.addKeyListener(this);
        this.vistaAdmin.txtBusquedaCliente.addKeyListener(this);
        this.llenaCamposEdicionCliente();

    }

    public void llenaCamposEdicionCliente() {
        int filaEditar = vistaAdmin.tablitaClientes.getSelectedRow();
        int numFS = vistaAdmin.tablitaClientes.getSelectedRowCount();
        if (filaEditar >= 0 && numFS == 1) {
            vistaEC.txtIdClienteEditarCliente.setText("" + vistaAdmin.tablitaClientes.getValueAt(filaEditar, 0));
            vistaEC.txtNombreEditarC.setText((String) vistaAdmin.tablitaClientes.getValueAt(filaEditar, 1));
            vistaEC.txtApellidoEditarCliente.setText((String) vistaAdmin.tablitaClientes.getValueAt(filaEditar, 2));
            vistaEC.txtTelefonoEditarCliente.setText((String) vistaAdmin.tablitaClientes.getValueAt(filaEditar, 3));
            vistaEC.txtEmailEditarCliente.setText((String) vistaAdmin.tablitaClientes.getValueAt(filaEditar, 4));
            vistaEC.txtDireccionEditarCliente.setText((String) vistaAdmin.tablitaClientes.getValueAt(filaEditar, 5));
            vistaEC.txtCPEditarClientes.setText((String) vistaAdmin.tablitaClientes.getValueAt(filaEditar, 6));
            vistaEC.txtCiudadEditarClientes.setText((String) vistaAdmin.tablitaClientes.getValueAt(filaEditar, 7));

        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila o al menos una");
        }
    }

    public void inicializar() {

    }

    public void busquedaCliente() {
        String apellidos = vistaAdmin.txtBusquedaCliente.getText();
        

        DefaultTableModel modeloT = new DefaultTableModel();
        vistaAdmin.tablitaClientes.setModel(modeloT);

        modeloT.addColumn("ID Cliente");
        modeloT.addColumn("Nombre");
        modeloT.addColumn("Apellido");
        modeloT.addColumn("Teléfono");
        modeloT.addColumn("Email");
        modeloT.addColumn("Dirección");
        modeloT.addColumn("Código Postal");
        modeloT.addColumn("Ciudad");

        Object[] columna = new Object[8];

        int numRegistros = modelo.buscarClienteApellidos(apellidos).size();

        for (int i = 0; i < numRegistros; i++) {

            columna[0] = modelo.buscarClienteApellidos(apellidos).get(i).getidCliente();
            columna[1] = modelo.buscarClienteApellidos(apellidos).get(i).getNombre();
            columna[2] = modelo.buscarClienteApellidos(apellidos).get(i).getApellido();
            columna[3] = modelo.buscarClienteApellidos(apellidos).get(i).getTelefono();
            columna[4] = modelo.buscarClienteApellidos(apellidos).get(i).getEmail();
            columna[5] = modelo.buscarClienteApellidos(apellidos).get(i).getDireccion();
            columna[6] = modelo.buscarClienteApellidos(apellidos).get(i).getCodigopostal();
            columna[7] = modelo.buscarClienteApellidos(apellidos).get(i).getCiudad();
            modeloT.addRow(columna);

            vistaAdmin.tablitaClientes.getColumnModel().getColumn(0).setMaxWidth(0);

            vistaAdmin.tablitaClientes.getColumnModel().getColumn(0).setMinWidth(0);

            vistaAdmin.tablitaClientes.getColumnModel().getColumn(0).setPreferredWidth(0);
        }

    }

    public void LlenarTabla(JTable tabla) {
        DefaultTableModel modeloT = new DefaultTableModel();

        tabla.setModel(modeloT);

        modeloT.addColumn("ID Cliente");
        modeloT.addColumn("Nombre");
        modeloT.addColumn("Apellido");
        modeloT.addColumn("Teléfono");
        modeloT.addColumn("Email");
        modeloT.addColumn("Dirección");
        modeloT.addColumn("Código Postal");
        modeloT.addColumn("Ciudad");

        Object[] columna = new Object[8];

        int numRegistros = modelo.listCliente().size();
        for (int i = 0; i < numRegistros; i++) {

            columna[0] = modelo.listCliente().get(i).getidCliente();
            columna[1] = modelo.listCliente().get(i).getNombre();
            columna[2] = modelo.listCliente().get(i).getApellido();
            columna[3] = modelo.listCliente().get(i).getTelefono();
            columna[4] = modelo.listCliente().get(i).getEmail();
            columna[5] = modelo.listCliente().get(i).getDireccion();
            columna[6] = modelo.listCliente().get(i).getCodigopostal();
            columna[7] = modelo.listCliente().get(i).getCiudad();
            modeloT.addRow(columna);

            tabla.getColumnModel().getColumn(0).setMaxWidth(0);

            tabla.getColumnModel().getColumn(0).setMinWidth(0);

            tabla.getColumnModel().getColumn(0).setPreferredWidth(0);
        }
    }

    //Action Performed de los botones (Aquí se realizan las Acciones de cada botón)
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vista.botonGuardar) {
            String nombre = vista.txtNombre.getText();
            String apellido = vista.txtApellido.getText();
            String telefono = vista.txtTelefono.getText();
            String email = vista.txtEmail.getText();
            String direccion = vista.txtDireccion.getText();
            String cp = vista.txtCP.getText();
            String ciudad = vista.txtCiudad.getText();

            if (nombre.equals("")||apellido.equals("")||telefono.equals("")||direccion.equals("")||ciudad.equals("")){
              JOptionPane.showMessageDialog(null, "Faltan campos con información por llenar");  
            }else{
             String rptaRegistro = modelo.insertCliente(nombre, apellido, telefono, email, direccion, cp, ciudad);
            
            
            if (rptaRegistro != null && rptaRegistro.equals("Registro Exitoso")) {
                JOptionPane.showMessageDialog(null, "El registro del cliente " + nombre + " ha sido guardado con éxito");
                vista.txtNombre.setText("");
                vista.txtApellido.setText("");
                vista.txtTelefono.setText("");
                vista.txtEmail.setText("");
                vista.txtDireccion.setText("");
                vista.txtCP.setText("");
                vista.txtCiudad.setText("");
                LlenarTabla(this.vistaAdmin.tablitaClientes); //No actualiza la tabla
            } else {
                JOptionPane.showMessageDialog(null, "Ocurrio un error al ingresar el registro");
                }
            }
        }
        
        
        
        if (e.getSource() == vistaAdmin.botonActualizar) {

            LlenarTabla(vistaAdmin.tablitaClientes);

        }

        if (e.getSource() == vista.botonRegresar) {
            vista.setVisible(false);
            vista.txtNombre.setText("");
            vista.txtApellido.setText("");
            vista.txtTelefono.setText("");
            vista.txtEmail.setText("");
            vista.txtDireccion.setText("");
            vista.txtCP.setText("");
            vista.txtCiudad.setText("");

        }

        if (e.getSource() == vistaEC.botonRegresarEditarCliente) {
            vistaEC.setVisible(false);
        }

        if (e.getSource() == vistaEC.botonGuardarEditarCliente) {

            String idcliente = vistaEC.txtIdClienteEditarCliente.getText();
            String nombre = vistaEC.txtNombreEditarC.getText();
            String apellido = vistaEC.txtApellidoEditarCliente.getText();
            String telefono = vistaEC.txtTelefonoEditarCliente.getText();
            String email = vistaEC.txtEmailEditarCliente.getText();
            String direccion = vistaEC.txtDireccionEditarCliente.getText();
            String cp = vistaEC.txtCPEditarClientes.getText();
            String ciudad = vistaEC.txtCiudadEditarClientes.getText();

            String rptaRegistro = modelo.editaCliente(idcliente, nombre, apellido, telefono, email, direccion, cp, ciudad);

            if (rptaRegistro != null && rptaRegistro.equals("Registro Exitoso")) {
                JOptionPane.showMessageDialog(null, "El registro del cliente " + nombre + " ha sido Editado con éxito");
                vistaEC.dispose();
                LlenarTabla(this.vistaAdmin.tablitaClientes);
            } else {
                JOptionPane.showMessageDialog(null, "Ocurrio un error al editar el registro");
            }
        }
        if (e.getSource() == vistaAdmin.eliminarPopUpClientes) {
            int filaInicio = vistaAdmin.tablitaClientes.getSelectedRow();
            int numFS = vistaAdmin.tablitaClientes.getSelectedRowCount();
            String id = "";
            String nombre = "";
            if (filaInicio > 0) {
                for (int i = 0; i < numFS; i++) {
                    id = String.valueOf(vistaAdmin.tablitaClientes.getValueAt(i + filaInicio, 0));
                    nombre = String.valueOf(vistaAdmin.tablitaClientes.getValueAt(i + filaInicio, 1));

                    int rptaUsuario = JOptionPane.showConfirmDialog(null, "¿Quiere eliminar el registro del cliente " + nombre + "?");
                    if (rptaUsuario == 0) {
                        modelo.eliminarCliente(id);
                    }
                }
                LlenarTabla(vistaAdmin.tablitaClientes);
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione al menos una fila a eliminar");
            }
        }

    }
    



    //Validaciones de los campos de texto

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getSource() == vistaEC.txtNombreEditarC || e.getSource() == vistaEC.txtApellidoEditarCliente || e.getSource() == vistaEC.txtCiudadEditarClientes) {
            System.out.println("entra key");
            char c = e.getKeyChar();
            if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && c != 'ñ' && c != 'Ñ' && c != 'á' && c != 'é' && c != 'í' && c != 'ó' && c != 'ú' && c != 'Á' && c != 'É' && c != 'Í' && c != 'Ó' && c != 'Ú' && (c != (char) KeyEvent.VK_BACK_SPACE) && (c != (char) KeyEvent.VK_SPACE)) {
                System.out.println("entra key if");
                e.consume();
            }
        }
        if (e.getSource() == vistaEC.txtTelefonoEditarCliente || e.getSource() == vistaEC.txtCPEditarClientes) {
            char c = e.getKeyChar();
            if ((c < '0' || c > '9')) {
                e.consume();
            }
        }

        if (e.getSource() == vistaEC.txtTelefonoEditarCliente) {
            String caracteres = vistaEC.txtTelefonoEditarCliente.getText();
            if (caracteres.length() >= 10) {
                e.consume();
            }
        }
        if (e.getSource() == vistaEC.txtCPEditarClientes) {
            String Caracteres2 = vistaEC.txtCPEditarClientes.getText();//arreglar
            if (Caracteres2.length() >= 5) {
                e.consume();

            }
        }

        //Validaciones del registro de clientes
        if (e.getSource() == vista.txtNombre || e.getSource() == vista.txtApellido || e.getSource() == vista.txtCiudad) {
            char c = e.getKeyChar();
            if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && c != 'ñ' && c != 'Ñ' && c != 'á' && c != 'é' && c != 'í' && c != 'ó' && c != 'ú' && c != 'Á' && c != 'É' && c != 'Í' && c != 'Ó' && c != 'Ú' && (c != (char) KeyEvent.VK_BACK_SPACE) && (c != (char) KeyEvent.VK_SPACE)) {
                e.consume();
            }
        }
        if (e.getSource() == vista.txtTelefono || e.getSource() == vista.txtCP) {
            char c = e.getKeyChar();
            if ((c < '0' || c > '9')) {
                e.consume();
            }
        }

        if (e.getSource() == vista.txtTelefono) {
            String caracteres = vista.txtTelefono.getText();
            if (caracteres.length() >= 10) {
                e.consume();
            }
        }
        if (e.getSource() == vista.txtCP) {
            String Caracteres2 = vista.txtCP.getText();
            if (Caracteres2.length() >= 5) {
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
        System.out.println("Entra al KeyEvent");
        if (e.getSource() == vistaAdmin.txtBusquedaCliente) {
            System.out.println("realiza el método de búsqueda");
            busquedaCliente();
        }
    }

    @Override
    public void llenarTablaInterfaz() {
        LlenarTabla(vistaAdmin.tablitaClientes);
    }

}
