/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ProductoDAO;
import Vista.MenuPrincipal;
import Vista.RegistrarProductos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LOGAN
 */
public class ControladorProducto implements ActionListener, Comunica{

    RegistrarProductos vistaproducto = new RegistrarProductos(this);
    MenuPrincipal vistaAdmin = new MenuPrincipal();
    ProductoDAO modeloProducto = new ProductoDAO();

    public ControladorProducto(RegistrarProductos vistaProducto, ProductoDAO modeloProducto) {
        this.modeloProducto = modeloProducto;
        this.vistaproducto = vistaproducto;
        this.vistaproducto.botonGuardarRegistrarProducto.addActionListener(this);
        this.vistaproducto.botonRegresarRegistrarProducto.addActionListener(this);  
    }
    
    public void LlenarTabla(JTable tabla) {
        DefaultTableModel modeloT = new DefaultTableModel();
        tabla.setModel(modeloT);

        modeloT.addColumn("Nombre");
        modeloT.addColumn("Codigo");
        modeloT.addColumn("Descripcion");
        modeloT.addColumn("Precio");
        modeloT.addColumn("Cantidad");
        
         Object[] columna = new Object[5];
         
        int numRegistros = modeloProducto.listProducto().size();
        for (int i = 0; i < numRegistros; i++) {
            columna[0] = modeloProducto.listProducto().get(i).getNombre();
            columna[1] = modeloProducto.listProducto().get(i).getCodigo();
            columna[2] = modeloProducto.listProducto().get(i).getDescripcion();
            columna[3] = modeloProducto.listProducto().get(i).getPrecio();
            columna[4] = modeloProducto.listProducto().get(i).getCantidad();
           
            
            modeloT.addRow(columna);
        }
    }
    
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == vistaproducto.botonGuardarRegistrarProducto){
            String nombre = vistaproducto.txtNombreregistrarProductos.getText();
            
        }
        
    }

    public void llenarTablaInterfaz() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
