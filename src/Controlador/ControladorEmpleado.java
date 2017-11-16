/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.EmpleadoDAO;
import Vista.MenuPrincipal;
import Vista.RegistrarEmpleado;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Zelph
 */
public class ControladorEmpleado implements ActionListener, Comunica{
    
    RegistrarEmpleado vistaEmpleado = new RegistrarEmpleado(this);
    MenuPrincipal vistaAdmin = new MenuPrincipal();
    EmpleadoDAO modelo = new EmpleadoDAO();
    
    public ControladorEmpleado(RegistrarEmpleado vistaempleado, EmpleadoDAO modelo) {
        this.modelo = modelo;
        this.vistaEmpleado = vistaempleado;
        this.vistaEmpleado.botonGuardarRegistrarEmpleado.addActionListener(this);
        this.vistaEmpleado.botonRegresarRegistrarEmpleado.addActionListener(this);
    }
    public void inicializar() {

    }

    public void LlenarTabla(JTable tabla) {
        DefaultTableModel modeloT = new DefaultTableModel();
        tabla.setModel(modeloT);

        modeloT.addColumn("Nombre");
        modeloT.addColumn("Apellido");
        modeloT.addColumn("Teléfono");
        modeloT.addColumn("Email");
        modeloT.addColumn("Dirección");
        modeloT.addColumn("Código Postal");
        modeloT.addColumn("Ciudad");
        modeloT.addColumn("Usuario");
        modeloT.addColumn("Contraseña");

        Object[] columna = new Object[9];

        int numRegistros = modelo.listEmpleado().size();
        for (int i = 0; i < numRegistros; i++) {
            columna[0] = modelo.listEmpleado().get(i).getNombre();
            columna[1] = modelo.listEmpleado().get(i).getApellido();
            columna[2] = modelo.listEmpleado().get(i).getTelefono();
            columna[3] = modelo.listEmpleado().get(i).getEmail();
            columna[4] = modelo.listEmpleado().get(i).getDireccion();
            columna[5] = modelo.listEmpleado().get(i).getCodigopostal();
            columna[6] = modelo.listEmpleado().get(i).getCiudad();
            columna[7] = modelo.listEmpleado().get(i).getUsuario();
            columna[8] = modelo.listEmpleado().get(i).getPassword();
            
            modeloT.addRow(columna);
        }
    }
    
     public void actionPerformed(ActionEvent e) {
    
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

            String rptaRegistro = modelo.inserteEmpleado(nombre, apellido, telefono, email, direccion, cp, ciudad, usuario, pass,tipoEmpleado);

            if (rptaRegistro != null && rptaRegistro.equals("Registro Exitoso")) {
                JOptionPane.showMessageDialog(null, "El registro del Empleado " + nombre + " ha sido guardado con éxito");
            } else {
                JOptionPane.showMessageDialog(null, "Ocurrio un error al ingresar el registro");
            }
        }
    if (e.getSource() == vistaAdmin.botonActualizar) {
            LlenarTabla(vistaAdmin.TablaEmpleados);
        }
    
    if (e.getSource() == vistaEmpleado.botonRegresarRegistrarEmpleado) {
            vistaEmpleado.setVisible(false);
        }
     }
     
    
}
