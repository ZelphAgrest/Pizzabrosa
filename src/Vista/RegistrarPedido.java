package Vista;

import Controlador.Comunica;
import java.awt.event.KeyEvent;


public class RegistrarPedido extends javax.swing.JFrame implements Comunica {

    Comunica miInterfazRemota;
   
    
    public RegistrarPedido(Comunica comunicacion, String cajero) {
        initComponents();
        setTitle("Registrar Pedido");
        setLocationRelativeTo(null);
        setResizable(false);
        miInterfazRemota = comunicacion;
        labelRegistrarPedidoCajero.setText(cajero);
        
        tablaPedidos.getColumnModel().getColumn(0).setMaxWidth(0);

        tablaPedidos.getColumnModel().getColumn(0).setMinWidth(0);

        tablaPedidos.getColumnModel().getColumn(0).setPreferredWidth(0);
    }
  

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel14 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        labelRegistrarPedidoCajero = new javax.swing.JLabel();
        botonMenos = new javax.swing.JButton();
        botonMas = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        comboListaProductos = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPedidos = new javax.swing.JTable();
        txtBuscarClienteRegistrarPedido = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        spinnerCantidadRegistrarPedido = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        labelNombreClienteRegistrarPedido = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtTotalPagar = new javax.swing.JTextField();
        botonGuardarRegistrarPedido = new javax.swing.JButton();
        botonRegresarRegistrarPedido = new javax.swing.JButton();

        jLabel14.setIcon(new javax.swing.ImageIcon("C:\\Users\\Zelph\\Documents\\NetBeansProjects\\PizzabrosaV1.0\\src\\Imagenes\\iconoBuscar.png")); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Zelph\\Documents\\NetBeansProjects\\PizzabrosaV1.0\\src\\Imagenes\\pizzabrosaPestaña.png")); // NOI18N

        jLabel2.setText("CAJERO:");

        labelRegistrarPedidoCajero.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelRegistrarPedidoCajero.setForeground(new java.awt.Color(0, 0, 102));
        labelRegistrarPedidoCajero.setText("Lorenzo");

        botonMenos.setIcon(new javax.swing.ImageIcon("C:\\Users\\Zelph\\Documents\\NetBeansProjects\\PizzabrosaV1.0\\src\\Imagenes\\menos.png")); // NOI18N

        botonMas.setIcon(new javax.swing.ImageIcon("C:\\Users\\Zelph\\Documents\\NetBeansProjects\\PizzabrosaV1.0\\src\\Imagenes\\mas.png")); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Ingrese el número telefónico del cliente:");

        comboListaProductos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        comboListaProductos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione un Producto" }));

        tablaPedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Producto", "Producto", "Precio Unitario", "Cantidad", "SubTotal"
            }
        ));
        jScrollPane1.setViewportView(tablaPedidos);

        txtBuscarClienteRegistrarPedido.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtBuscarClienteRegistrarPedido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscarClienteRegistrarPedidoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarClienteRegistrarPedidoKeyTyped(evt);
            }
        });

        jLabel15.setIcon(new javax.swing.ImageIcon("C:\\Users\\Zelph\\Documents\\NetBeansProjects\\PizzabrosaV1.0\\src\\Imagenes\\iconoBuscar.png")); // NOI18N

        spinnerCantidadRegistrarPedido.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        spinnerCantidadRegistrarPedido.setModel(new javax.swing.SpinnerNumberModel(1, 0, null, 1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Cantidad:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Cliente:");

        labelNombreClienteRegistrarPedido.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelNombreClienteRegistrarPedido.setForeground(new java.awt.Color(0, 0, 102));
        labelNombreClienteRegistrarPedido.setText("NombreCliente");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel6.setText("$");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Total a Pagar");

        txtTotalPagar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        botonGuardarRegistrarPedido.setIcon(new javax.swing.ImageIcon("C:\\Users\\Zelph\\Documents\\NetBeansProjects\\PizzabrosaV1.0\\src\\Imagenes\\IconoGuardar.png")); // NOI18N

        botonRegresarRegistrarPedido.setIcon(new javax.swing.ImageIcon("C:\\Users\\Zelph\\Documents\\NetBeansProjects\\PizzabrosaV1.0\\src\\Imagenes\\IconoRegresars.png")); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(23, 23, 23))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtBuscarClienteRegistrarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(570, 570, 570)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelRegistrarPedidoCajero, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(comboListaProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(spinnerCantidadRegistrarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(botonMas, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botonMenos, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 524, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jLabel7))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(10, 10, 10)
                                .addComponent(txtTotalPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(botonGuardarRegistrarPedido)
                                .addGap(10, 10, 10)
                                .addComponent(botonRegresarRegistrarPedido)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelNombreClienteRegistrarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelRegistrarPedidoCajero)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtBuscarClienteRegistrarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel15)))
                            .addComponent(jLabel1))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(spinnerCantidadRegistrarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4)
                                        .addComponent(comboListaProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(botonMas)
                                    .addComponent(botonMenos))
                                .addGap(20, 20, 20)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(labelNombreClienteRegistrarPedido)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(115, 115, 115)
                                .addComponent(jLabel7)
                                .addGap(47, 47, 47)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(5, 5, 5)
                                        .addComponent(txtTotalPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(41, 41, 41)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(botonGuardarRegistrarPedido)
                                    .addComponent(botonRegresarRegistrarPedido))))
                        .addGap(22, 22, 22)))
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarClienteRegistrarPedidoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarClienteRegistrarPedidoKeyPressed
       
    }//GEN-LAST:event_txtBuscarClienteRegistrarPedidoKeyPressed

    private void txtBuscarClienteRegistrarPedidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarClienteRegistrarPedidoKeyTyped
        if (evt.getSource() == txtBuscarClienteRegistrarPedido) {
            char c = evt.getKeyChar();
            if (c < '0' || c > '9') {
                evt.consume();
            }
            String caracteres =txtBuscarClienteRegistrarPedido.getText();
            if (caracteres.length() >= 10) {
                evt.consume();

            }
        }
    }//GEN-LAST:event_txtBuscarClienteRegistrarPedidoKeyTyped

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RegistrarPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrarPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrarPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrarPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new RegistrarPedido().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton botonGuardarRegistrarPedido;
    public javax.swing.JButton botonMas;
    public javax.swing.JButton botonMenos;
    public javax.swing.JButton botonRegresarRegistrarPedido;
    public javax.swing.JComboBox<String> comboListaProductos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JLabel labelNombreClienteRegistrarPedido;
    public javax.swing.JLabel labelRegistrarPedidoCajero;
    public javax.swing.JSpinner spinnerCantidadRegistrarPedido;
    public javax.swing.JTable tablaPedidos;
    public javax.swing.JTextField txtBuscarClienteRegistrarPedido;
    public javax.swing.JTextField txtTotalPagar;
    // End of variables declaration//GEN-END:variables
}
