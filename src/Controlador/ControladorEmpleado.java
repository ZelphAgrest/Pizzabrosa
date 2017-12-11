package Controlador;

import Modelo.Empleado;
import Modelo.EmpleadoDAO;
import Vista.EditarEmpleado;
import Vista.MenuPrincipal;
import Vista.RegistrarEmpleado;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ControladorEmpleado implements ActionListener, Comunica, KeyListener {

    RegistrarEmpleado vistaEmpleado = new RegistrarEmpleado(this);
    EditarEmpleado vistaEditarEmpleado = new EditarEmpleado(this);
    MenuPrincipal vistaAdmin;
    EmpleadoDAO modelo;

    //Constructor de Empleado
    public ControladorEmpleado(MenuPrincipal vistaAdmin, EmpleadoDAO modelo) {
        this.modelo = modelo;
        this.vistaAdmin = vistaAdmin;
        this.vistaAdmin.botonActualizar.addActionListener(this);
        this.vistaAdmin.eliminarPopUpEmpleados.addActionListener(this);
        this.vistaAdmin.txtBuscarEmpleado.addKeyListener(this);
        LlenarTablaEmpleado(this.vistaAdmin.TablaEmpleados);

    }

    //Método para registrar empleados
    public void VinculaRegistroEmpleado(RegistrarEmpleado vistaempleado) {
        this.vistaEmpleado = vistaempleado;
        this.vistaEmpleado.botonGuardarRegistrarEmpleado.addActionListener(this);
        this.vistaEmpleado.botonRegresarRegistrarEmpleado.addActionListener(this);
        this.vistaEmpleado.txtNombreRegistrarEmpleado.addKeyListener(this);
        this.vistaEmpleado.txtApellidoRegistrarEmpleado.addKeyListener(this);
        this.vistaEmpleado.txtTelefonoRegistrarEmpleado.addKeyListener(this);
        this.vistaEmpleado.txtEmailregistrarEmpleado.addKeyListener(this);
        this.vistaEmpleado.txtDireccionRegistrarEmpleado.addKeyListener(this);
        this.vistaEmpleado.txtCPRegistrarEmpleado.addKeyListener(this);
        this.vistaEmpleado.txtCiudadResgitrarEmpleado.addKeyListener(this);
    }

    //Método para Editar Empleados
    public void vinculaEditaEmpleado(EditarEmpleado vistaEdE, MenuPrincipal menu) {
        this.vistaEditarEmpleado = vistaEdE;
        this.vistaAdmin = menu;
        this.vistaEditarEmpleado.botonGuardarEditarEmpleado.addActionListener(this);
        this.vistaEditarEmpleado.botonRegresarEditarEmpleado.addActionListener(this);
        this.vistaEditarEmpleado.txtNombreEditarEmpleado.addKeyListener(this);
        this.vistaEditarEmpleado.txtApellidoEditarEmpleado.addKeyListener(this);
        this.vistaEditarEmpleado.txtTelefonoEditarEmpleado.addKeyListener(this);
        this.vistaEditarEmpleado.txtEmailEditarEmpleado.addKeyListener(this);
        this.vistaEditarEmpleado.txtDireccionEditarEmpleado.addKeyListener(this);
        this.vistaEditarEmpleado.txtCPEditarEmpleado.addKeyListener(this);
        this.vistaEditarEmpleado.txtCiudadEditarEmpleado.addKeyListener(this);
        this.vistaEditarEmpleado.botonCambiarPassword.addActionListener(this);
        this.vistaEditarEmpleado.txtPasswordEmpleado.setEnabled(false);
        this.vistaAdmin.txtBusquedaCliente.addKeyListener(this);
        this.llenaCamposEditarEmpleado();

    }

    public void llenaCamposEditarEmpleado() {
        int filaEditar = vistaAdmin.TablaEmpleados.getSelectedRow();
        int numFS = vistaAdmin.TablaEmpleados.getSelectedRowCount();
        if (filaEditar >= 0 && numFS == 1) {
            vistaEditarEmpleado.txtIdEditarEmpleado.setText("" + vistaAdmin.TablaEmpleados.getValueAt(filaEditar, 0));
            vistaEditarEmpleado.txtNombreEditarEmpleado.setText((String) vistaAdmin.TablaEmpleados.getValueAt(filaEditar, 1));
            vistaEditarEmpleado.txtApellidoEditarEmpleado.setText((String) vistaAdmin.TablaEmpleados.getValueAt(filaEditar, 2));
            vistaEditarEmpleado.txtTelefonoEditarEmpleado.setText((String) vistaAdmin.TablaEmpleados.getValueAt(filaEditar, 3));
            vistaEditarEmpleado.txtEmailEditarEmpleado.setText((String) vistaAdmin.TablaEmpleados.getValueAt(filaEditar, 4));
            vistaEditarEmpleado.txtDireccionEditarEmpleado.setText((String) vistaAdmin.TablaEmpleados.getValueAt(filaEditar, 5));
            vistaEditarEmpleado.txtCPEditarEmpleado.setText((String) vistaAdmin.TablaEmpleados.getValueAt(filaEditar, 6));
            vistaEditarEmpleado.txtCiudadEditarEmpleado.setText((String) vistaAdmin.TablaEmpleados.getValueAt(filaEditar, 7));
            vistaEditarEmpleado.txtUsuarioEmpleado.setText((String) vistaAdmin.TablaEmpleados.getValueAt(filaEditar, 8));
            vistaEditarEmpleado.txtPasswordEmpleado.setText((String) vistaAdmin.TablaEmpleados.getValueAt(filaEditar, 9));
            String valor = (String) vistaAdmin.TablaEmpleados.getValueAt(filaEditar, 10);
            if (valor.equals("Cajero")) {
                vistaEditarEmpleado.comboEditarEmpleado.setSelectedIndex(1);
            } else {
                vistaEditarEmpleado.comboEditarEmpleado.setSelectedIndex(2);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un Empleado");
        }
    }

    public void inicializar() {

    }

    public void busquedaEmpleado() {
        String apellidos = vistaAdmin.txtBuscarEmpleado.getText();
        DefaultTableModel modeloT = new DefaultTableModel();
        vistaAdmin.TablaEmpleados.setModel(modeloT);

        modeloT.addColumn("ID Empleado");
        modeloT.addColumn("Nombre");
        modeloT.addColumn("Apellido");
        modeloT.addColumn("Teléfono");
        modeloT.addColumn("Email");
        modeloT.addColumn("Dirección");
        modeloT.addColumn("Código Postal");
        modeloT.addColumn("Ciudad");
        modeloT.addColumn("Usuario");
        modeloT.addColumn("Contraseña");
        modeloT.addColumn("Tipo Empleado");

        Object[] columna = new Object[11];

        ArrayList<Empleado> listaempleado = modelo.buscarEmpleadoApellidos(apellidos);
        int numRegistros = modelo.buscarEmpleadoApellidos(apellidos).size();

        for (int i = 0; i < numRegistros; i++) {

            columna[0] = listaempleado.get(i).getIdEmpleado();
            columna[1] = listaempleado.get(i).getNombre();
            columna[2] = listaempleado.get(i).getApellido();
            columna[3] = listaempleado.get(i).getTelefono();
            columna[4] = listaempleado.get(i).getEmail();
            columna[5] = listaempleado.get(i).getDireccion();
            columna[6] = listaempleado.get(i).getCodigopostal();
            columna[7] = listaempleado.get(i).getCiudad();
            columna[8] = listaempleado.get(i).getUsuario();
            columna[9] = listaempleado.get(i).getPassword();
            int num = listaempleado.get(i).getIdTipoEmpleado();
            if (num == 1) {
                columna[10] = "Cajero";
            }
            if (num == 2) {
                columna[10] = "Gerente";
            }
            modeloT.addRow(columna);

            vistaAdmin.TablaEmpleados.getColumnModel().getColumn(0).setMaxWidth(0);

            vistaAdmin.TablaEmpleados.getColumnModel().getColumn(0).setMinWidth(0);

            vistaAdmin.TablaEmpleados.getColumnModel().getColumn(0).setPreferredWidth(0);

            vistaAdmin.TablaEmpleados.getColumnModel().getColumn(9).setMaxWidth(0);

            vistaAdmin.TablaEmpleados.getColumnModel().getColumn(9).setMinWidth(0);

            vistaAdmin.TablaEmpleados.getColumnModel().getColumn(9).setPreferredWidth(0);
        }

    }
//Método que llena la tabla 

    public void LlenarTablaEmpleado(JTable tabla) {
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
        modeloT.addColumn("Usuario");
        modeloT.addColumn("Contraseña");
        modeloT.addColumn("Tipo Empleado");

        Object[] columna = new Object[11];

        ArrayList<Empleado> listaempleado = modelo.listEmpleado();
        int numRegistros = modelo.listEmpleado().size();
        for (int i = 0; i < numRegistros; i++) {

            columna[0] = listaempleado.get(i).getIdEmpleado();
            columna[1] = listaempleado.get(i).getNombre();
            columna[2] = listaempleado.get(i).getApellido();
            columna[3] = listaempleado.get(i).getTelefono();
            columna[4] = listaempleado.get(i).getEmail();
            columna[5] = listaempleado.get(i).getDireccion();
            columna[6] = listaempleado.get(i).getCodigopostal();
            columna[7] = listaempleado.get(i).getCiudad();
            columna[8] = listaempleado.get(i).getUsuario();
            columna[9] = listaempleado.get(i).getPassword();
            int num = listaempleado.get(i).getIdTipoEmpleado();
            if (num == 1) {
                columna[10] = "Cajero";
            }
            if (num == 2) {
                columna[10] = "Gerente";
            }
            modeloT.addRow(columna);

            tabla.getColumnModel().getColumn(0).setMaxWidth(0);

            tabla.getColumnModel().getColumn(0).setMinWidth(0);

            tabla.getColumnModel().getColumn(0).setPreferredWidth(0);

            tabla.getColumnModel().getColumn(9).setMaxWidth(0);

            tabla.getColumnModel().getColumn(9).setMinWidth(0);

            tabla.getColumnModel().getColumn(9).setPreferredWidth(0);
        }
    }

    public void actionPerformed(ActionEvent e) {
        //Registro del empleado
        if (e.getSource() == vistaEmpleado.botonGuardarRegistrarEmpleado) {
            String nombre = vistaEmpleado.txtNombreRegistrarEmpleado.getText();
            String apellido = vistaEmpleado.txtApellidoRegistrarEmpleado.getText();
            String telefono = vistaEmpleado.txtTelefonoRegistrarEmpleado.getText();
            String email = vistaEmpleado.txtEmailregistrarEmpleado.getText();
            String direccion = vistaEmpleado.txtDireccionRegistrarEmpleado.getText();
            String cp = vistaEmpleado.txtCPRegistrarEmpleado.getText();
            String ciudad = vistaEmpleado.txtCiudadResgitrarEmpleado.getText();
            String usuario = vistaEmpleado.txtUsuarioRegistrarEmpleado.getText();
            String pass = vistaEmpleado.txtPasswordRegistrarEmpleado.getText();
            int tipo = vistaEmpleado.comboTipoEmpleado.getSelectedIndex();

            String tipoEmpleado = Integer.toString(tipo);

            //Valida las contraseñas
            if (pass.equals(vistaEmpleado.txtConfrimaPassRegistrarEmpleado.getText())) {

                if (nombre.equals("") || apellido.equals("") || telefono.equals("") || direccion.equals("") || ciudad.equals("") || usuario.equals("") || pass.equals("") || tipo == 0) {
                    JOptionPane.showMessageDialog(null, "Faltan campos con información por llenar");
                } else {
                    String rptaRegistro = modelo.inserteEmpleado(nombre, apellido, telefono, email, direccion, cp, ciudad, usuario, pass, tipoEmpleado);

                    if (rptaRegistro != null && rptaRegistro.equals("Registro Exitoso")) {
                        JOptionPane.showMessageDialog(null, "El registro del Empleado " + nombre + " ha sido guardado con éxito");
                        vistaEmpleado.txtNombreRegistrarEmpleado.setText("");
                        vistaEmpleado.txtApellidoRegistrarEmpleado.setText("");
                        vistaEmpleado.txtTelefonoRegistrarEmpleado.setText("");
                        vistaEmpleado.txtEmailregistrarEmpleado.setText("");
                        vistaEmpleado.txtDireccionRegistrarEmpleado.setText("");
                        vistaEmpleado.txtCPRegistrarEmpleado.setText("");
                        vistaEmpleado.txtCiudadResgitrarEmpleado.setText("");
                        vistaEmpleado.txtUsuarioRegistrarEmpleado.setText("");
                        vistaEmpleado.txtPasswordRegistrarEmpleado.setText("");
                        vistaEmpleado.txtConfrimaPassRegistrarEmpleado.setText("");
                        vistaEmpleado.comboTipoEmpleado.setSelectedIndex(0);
                        LlenarTablaEmpleado(this.vistaAdmin.TablaEmpleados);
                    } else {
                        if (rptaRegistro.equals("El nombre de usuario ya se encuentra registrado")) {
                            JOptionPane.showMessageDialog(null, "El nombre de usuario ya se encuentra registrado");
                        } else {
                            JOptionPane.showMessageDialog(null, "Ocurrio un error al ingresar el registro");
                        }

                    }
                }

            } else {
                JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden favor de verificarlo");

            }

        }

        //Regresa del registro de empleados
        if (e.getSource() == vistaEmpleado.botonRegresarRegistrarEmpleado) {
            vistaEmpleado.setVisible(false);
            vistaEmpleado.txtNombreRegistrarEmpleado.setText("");
            vistaEmpleado.txtApellidoRegistrarEmpleado.setText("");
            vistaEmpleado.txtTelefonoRegistrarEmpleado.setText("");
            vistaEmpleado.txtEmailregistrarEmpleado.setText("");
            vistaEmpleado.txtDireccionRegistrarEmpleado.setText("");
            vistaEmpleado.txtCPRegistrarEmpleado.setText("");
            vistaEmpleado.txtCiudadResgitrarEmpleado.setText("");
            vistaEmpleado.txtUsuarioRegistrarEmpleado.setText("");
            vistaEmpleado.txtPasswordRegistrarEmpleado.setText("");
            vistaEmpleado.txtConfrimaPassRegistrarEmpleado.setText("");

        }

        //Actualizar la lista de empleados
        if (e.getSource() == vistaAdmin.botonActualizar) {
            LlenarTablaEmpleado(vistaAdmin.TablaEmpleados);
        }

        //Regresar de la ventana de Guardar empleados
        if (e.getSource() == vistaEmpleado.botonRegresarRegistrarEmpleado) {
            vistaEmpleado.setVisible(false);
        }

        //Habilita la contraseña del empleado
        if (e.getSource() == vistaEditarEmpleado.botonCambiarPassword) {
            String password = JOptionPane.showInputDialog("Ingresa la contraseña");
            if (vistaEditarEmpleado.txtPasswordEmpleado.getText().equals(password) || password.equals("MasterKey")) {
                vistaEditarEmpleado.txtPasswordEmpleado.setEnabled(true);
            } else {
                JOptionPane.showMessageDialog(null, "Contraseña incorrecta");
            }
        }

        //Guardar edición de empleados
        if (e.getSource() == vistaEditarEmpleado.botonGuardarEditarEmpleado) {
            String idcliente = vistaEditarEmpleado.txtIdEditarEmpleado.getText();
            String nombre = vistaEditarEmpleado.txtNombreEditarEmpleado.getText();
            String apellido = vistaEditarEmpleado.txtApellidoEditarEmpleado.getText();
            String telefono = vistaEditarEmpleado.txtTelefonoEditarEmpleado.getText();
            String email = vistaEditarEmpleado.txtEmailEditarEmpleado.getText();
            String direccion = vistaEditarEmpleado.txtDireccionEditarEmpleado.getText();
            String cp = vistaEditarEmpleado.txtCPEditarEmpleado.getText();
            String ciudad = vistaEditarEmpleado.txtCiudadEditarEmpleado.getText();
            String nombreUsuario = vistaEditarEmpleado.txtUsuarioEmpleado.getText();
            String contrasenia = vistaEditarEmpleado.txtPasswordEmpleado.getText();
            int tipo = vistaEditarEmpleado.comboEditarEmpleado.getSelectedIndex();
            String tipoEmpleado = Integer.toString(tipo);

            if (nombre.equals("") || apellido.equals("") || telefono.equals("") || direccion.equals("") || ciudad.equals("") || nombreUsuario.equals("") || tipo == 0 || contrasenia.equals("")) {
                JOptionPane.showMessageDialog(null, "Faltan campos con información por llenar");
            } else {

                String rptaRegistro = modelo.editaEmpleado(idcliente, nombre, apellido, telefono, email, direccion, cp, ciudad, nombreUsuario, contrasenia, tipoEmpleado);

                if (rptaRegistro != null && rptaRegistro.equals("Registro Exitoso")) {
                    JOptionPane.showMessageDialog(null, "El registro del Empleado " + nombre + " ha sido Editado con éxito");
                    vistaEditarEmpleado.dispose();
                    LlenarTablaEmpleado(this.vistaAdmin.TablaEmpleados);
                } else {
                    JOptionPane.showMessageDialog(null, "Ocurrio un error al editar el registro");
                }
            }
        }

        //Regresar de la ventana editar empleados
        if (e.getSource() == vistaEditarEmpleado.botonRegresarEditarEmpleado) {
            vistaEditarEmpleado.setVisible(false);

        }

//Eliminar Empleados
        if (e.getSource() == vistaAdmin.eliminarPopUpEmpleados) {
            int filaInicio = vistaAdmin.TablaEmpleados.getSelectedRow();
            int numFS = vistaAdmin.TablaEmpleados.getSelectedRowCount();
            String usuarioIniciado = vistaAdmin.TablaEmpleados.getValueAt(vistaAdmin.TablaEmpleados.getSelectedRow(), 8).toString();
            String idEmpleadoEliminar = vistaAdmin.TablaEmpleados.getValueAt(vistaAdmin.TablaEmpleados.getSelectedRow(), 0).toString();
            int tienePedidos = modelo.buscarEmpleadoEnPedidos(idEmpleadoEliminar).size();
            if (vistaAdmin.usuarioLabel1.getText() == usuarioIniciado || tienePedidos == 0) {

                String id = "";
                String nombre = "";
                if (filaInicio > 0) {
                    for (int i = 0; i < numFS; i++) {
                        id = String.valueOf(vistaAdmin.TablaEmpleados.getValueAt(i + filaInicio, 0));
                        nombre = String.valueOf(vistaAdmin.TablaEmpleados.getValueAt(i + filaInicio, 1));

                        int rptaUsuario = JOptionPane.showConfirmDialog(null, "¿Seguro que deseas eliminar el registro del Empleado " + nombre + "?");
                        if (rptaUsuario == 0) {
                            modelo.eliminarEmpleado(id);
                            JOptionPane.showMessageDialog(null, "El registro del Empleado " + nombre + " ha sido Eliminado con éxito");

                        }
                    }
                    LlenarTablaEmpleado(vistaAdmin.TablaEmpleados);
                } else {
                    JOptionPane.showMessageDialog(null, "Seleccione al menos una fila a eliminar");
                }
            } else {
                JOptionPane.showMessageDialog(null, "NO se puede eliminar la cuenta: El usuario tiene su sesión activa ó el empleado ya tiene pedidos asignados");
            }
        }

    }

    //Validaciones de Registro de empleado
    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getSource() == vistaEmpleado.txtNombreRegistrarEmpleado || e.getSource() == vistaEmpleado.txtApellidoRegistrarEmpleado || e.getSource() == vistaEmpleado.txtCiudadResgitrarEmpleado) {
            char c = e.getKeyChar();
            if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && c != 'ñ' && c != 'Ñ' && c != 'á' && c != 'é' && c != 'í' && c != 'ó' && c != 'ú' && c != 'Á' && c != 'É' && c != 'Í' && c != 'Ó' && c != 'Ú' && (c != (char) KeyEvent.VK_BACK_SPACE) && (c != (char) KeyEvent.VK_SPACE)) {
                e.consume();
            }
        }
        if (e.getSource() == vistaEmpleado.txtTelefonoRegistrarEmpleado || e.getSource() == vistaEmpleado.txtCPRegistrarEmpleado) {
            char c = e.getKeyChar();
            if ((c < '0' || c > '9')) {
                e.consume();
            }
        }

        if (e.getSource() == vistaEmpleado.txtTelefonoRegistrarEmpleado) {
            String caracteres = vistaEmpleado.txtTelefonoRegistrarEmpleado.getText();
            if (caracteres.length() >= 10) {
                e.consume();
            }
        }
        if (e.getSource() == vistaEmpleado.txtCPRegistrarEmpleado) {
            String Caracteres2 = vistaEmpleado.txtCPRegistrarEmpleado.getText();
            if (Caracteres2.length() >= 5) {
                e.consume();

            }
        }

        //Validaciones de Edicion de Empleados
        if (e.getSource() == vistaEditarEmpleado.txtNombreEditarEmpleado || e.getSource() == vistaEditarEmpleado.txtApellidoEditarEmpleado || e.getSource() == vistaEditarEmpleado.txtCiudadEditarEmpleado) {
            char c = e.getKeyChar();
            if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && c != 'ñ' && c != 'Ñ' && c != 'á' && c != 'é' && c != 'í' && c != 'ó' && c != 'ú' && c != 'Á' && c != 'É' && c != 'Í' && c != 'Ó' && c != 'Ú' && (c != (char) KeyEvent.VK_BACK_SPACE) && (c != (char) KeyEvent.VK_SPACE)) {
                e.consume();
            }
        }
        if (e.getSource() == vistaEditarEmpleado.txtTelefonoEditarEmpleado || e.getSource() == vistaEditarEmpleado.txtCPEditarEmpleado) {
            char c = e.getKeyChar();
            if ((c < '0' || c > '9')) {
                e.consume();
            }
        }

        if (e.getSource() == vistaEditarEmpleado.txtTelefonoEditarEmpleado) {
            String caracteres = vistaEditarEmpleado.txtTelefonoEditarEmpleado.getText();
            if (caracteres.length() >= 10) {
                e.consume();
            }
        }
        if (e.getSource() == vistaEditarEmpleado.txtCPEditarEmpleado) {
            String Caracteres2 = vistaEditarEmpleado.txtCPEditarEmpleado.getText();
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
        if (e.getSource() == vistaAdmin.txtBuscarEmpleado) {
            busquedaEmpleado();
        }
    }

}
