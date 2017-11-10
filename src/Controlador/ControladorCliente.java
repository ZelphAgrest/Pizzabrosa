/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Modelo.ClienteDAO;
import Vista.AdminCliente;
import Vista.VentanaClientes;
import modelo.*;
import Vista.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Zelph
 */
public class ControladorCliente implements ActionListener{
    VentanaClientes vista = new VentanaClientes();
    AdminCliente vistaAdmin = new AdminCliente();
    ClienteDAO modelo = new ClienteDAO();
    
    
    public ControladorCliente(VentanaClientes vista, ClienteDAO modelo){
        this.modelo = modelo;
        this.vista= vista;
        this.vista.botonGuardar.addActionListener(this);
        
    }
    
    public void inicializar(){
    
    }
    
    public void LlenarTabla(JTable tabla){
        DefaultTableModel modeloT = new DefaultTableModel();
        tabla.setModel(modeloT);
        
        modeloT.addColumn("Nombre");
        modeloT.addColumn("Apellido");
        modeloT.addColumn("Teléfono");
        modeloT.addColumn("Email");
        modeloT.addColumn("Dirección");
        modeloT.addColumn("Código Postal");
        modeloT.addColumn("Ciudad");
        
        Object[] columna = new Object[7];
        
        int numRegistros = modelo.listCliente().size();
        for (int i = 0; i < numRegistros; i++) {
            columna[0] = modelo.listCliente().get(i).getNombre();
            columna[1] = modelo.listCliente().get(i).getApellido();
            columna[2] = modelo.listCliente().get(i).getTelefono();
            columna[3] = modelo.listCliente().get(i).getEmail();
            columna[4] = modelo.listCliente().get(i).getDireccion();
            columna[5] = modelo.listCliente().get(i).getCodigopostal();
            columna[6] = modelo.listCliente().get(i).getCiudad();
            modeloT.addRow(columna);
        }
    }
    
    public void actionPerformed(ActionEvent e){
       if(e.getSource() == vista.botonGuardar){
           String nombre = vista.txtNombre.getText();
           String apellido = vista.txtApellido.getText();
           String telefono = vista.txtTelefono.getText();
           String email = vista.txtEmail.getText();
           String direccion = vista.txtDireccion.getText();
           String cp = vista.txtCP.getText();
           String ciudad = vista.txtCiudad.getText();
           
           String rptaRegistro = modelo.insertCliente(nombre, apellido, telefono, email, direccion, cp, ciudad);
           
           if(rptaRegistro!=null && rptaRegistro.equals("Registro Exitoso")){
               JOptionPane.showMessageDialog(null, "El registro del cliente "+nombre+" ha sido guardado con éxito");
           }else{
               JOptionPane.showMessageDialog(null, "Ocurrio un error al ingresar el registro");
           }
       }
       if(e.getSource() == vistaAdmin.botonActualizar){
           LlenarTabla(vistaAdmin.tablitaClientes);
            //JOptionPane.showMessageDialog(null, "Aquí va la tabla xD");
       
       }
       
       
    }
    
}