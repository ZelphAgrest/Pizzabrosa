/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Comunica;
import Controlador.ControladorCliente;
import Modelo.ClienteDAO;
import javax.swing.JFrame;

/**
 *
 * @author Zelph
 */
public class MenuPrincipal extends javax.swing.JFrame implements Comunica{

    /**
     * Creates new form AdminCliente
     */
    public MenuPrincipal() {
        initComponents();
        setTitle("Pizzabrosa");
        setLocationRelativeTo(null);
        setResizable(false);
    }

  RegistrarClientes vc = new RegistrarClientes(this);
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablitaClientes = new javax.swing.JTable();
        botonActualizar = new javax.swing.JButton();
        txtBusquedaCliente = new javax.swing.JTextField();
        botonBuscar = new javax.swing.JButton();
        botonRegistrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        botonCerrarSesion = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        usuarioLabel = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        usuarioLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtBuscarEmpleado = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaEmpleados = new javax.swing.JTable();
        botonBuscarEmpleado = new javax.swing.JButton();
        botonActualizarEmpleado = new javax.swing.JButton();
        botonRegistrarEmpleado = new javax.swing.JButton();
        botonCerrarSesionEmpleado = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        usuarioLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaProductos = new javax.swing.JTable();
        txtBuscarProducto = new javax.swing.JTextField();
        botonBuscarProducto = new javax.swing.JButton();
        botonActualziarProducto = new javax.swing.JButton();
        botonRegistrarProducto = new javax.swing.JButton();
        botonCerrarSesionProducto = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        usuarioLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        TablaPedidos = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        botonBuscarPedido = new javax.swing.JButton();
        botonActualzarPedido = new javax.swing.JButton();
        botonRegistarPedido = new javax.swing.JButton();
        botonCerrarSesionPedido = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tablitaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Apellido", "Teléfono", "Dirección", "Código Postal", "Ciudad"
            }
        ));
        jScrollPane1.setViewportView(tablitaClientes);

        botonActualizar.setIcon(new javax.swing.ImageIcon("C:\\Users\\Zelph\\Documents\\NetBeansProjects\\PizzabrosaV1.0\\src\\Imagenes\\IconoActualizar.png")); // NOI18N
        botonActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonActualizarActionPerformed(evt);
            }
        });

        botonBuscar.setIcon(new javax.swing.ImageIcon("C:\\Users\\Zelph\\Documents\\NetBeansProjects\\PizzabrosaV1.0\\src\\Imagenes\\iconoBuscar.png")); // NOI18N

        botonRegistrar.setIcon(new javax.swing.ImageIcon("C:\\Users\\Zelph\\Documents\\NetBeansProjects\\PizzabrosaV1.0\\src\\Imagenes\\iconoRegistrarUsuario.png")); // NOI18N
        botonRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegistrarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setText("Pizzabrosa");

        botonCerrarSesion.setIcon(new javax.swing.ImageIcon("C:\\Users\\Zelph\\Documents\\NetBeansProjects\\PizzabrosaV1.0\\src\\Imagenes\\iconoCerrarSesión.png")); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Bienvenido:");

        usuarioLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        usuarioLabel.setForeground(new java.awt.Color(0, 0, 102));
        usuarioLabel.setText("Administrador");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtBusquedaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(botonBuscar)
                        .addGap(29, 29, 29)
                        .addComponent(botonActualizar)
                        .addGap(29, 29, 29)
                        .addComponent(botonRegistrar)
                        .addContainerGap(61, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(usuarioLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addGap(38, 38, 38)
                                .addComponent(botonCerrarSesion)))
                        .addGap(26, 26, 26))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonCerrarSesion, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2)
                        .addComponent(usuarioLabel)))
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonActualizar)
                    .addComponent(botonBuscar)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(txtBusquedaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(botonRegistrar, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );

        jTabbedPane1.addTab("Clientes", jPanel2);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Bienvenido:");

        usuarioLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        usuarioLabel1.setForeground(new java.awt.Color(0, 0, 102));
        usuarioLabel1.setText("Administrador");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel4.setText("Pizzabrosa");

        TablaEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Apellido", "Teléfono", "E-mail", "Dirección", "Código Postal", "Ciudad", "Usuario", "Contraseña"
            }
        ));
        jScrollPane2.setViewportView(TablaEmpleados);

        botonBuscarEmpleado.setIcon(new javax.swing.ImageIcon("C:\\Users\\Zelph\\Documents\\NetBeansProjects\\PizzabrosaV1.0\\src\\Imagenes\\iconoBuscar.png")); // NOI18N

        botonActualizarEmpleado.setIcon(new javax.swing.ImageIcon("C:\\Users\\Zelph\\Documents\\NetBeansProjects\\PizzabrosaV1.0\\src\\Imagenes\\IconoActualizar.png")); // NOI18N

        botonRegistrarEmpleado.setIcon(new javax.swing.ImageIcon("C:\\Users\\Zelph\\Documents\\NetBeansProjects\\PizzabrosaV1.0\\src\\Imagenes\\iconoRegistrarUsuario.png")); // NOI18N

        botonCerrarSesionEmpleado.setIcon(new javax.swing.ImageIcon("C:\\Users\\Zelph\\Documents\\NetBeansProjects\\PizzabrosaV1.0\\src\\Imagenes\\iconoCerrarSesión.png")); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addContainerGap())
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(txtBuscarEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(botonBuscarEmpleado)
                        .addGap(31, 31, 31)
                        .addComponent(botonActualizarEmpleado)
                        .addGap(26, 26, 26)
                        .addComponent(botonRegistrarEmpleado)
                        .addContainerGap(78, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(usuarioLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addGap(39, 39, 39)
                        .addComponent(botonCerrarSesionEmpleado)
                        .addGap(27, 27, 27))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(usuarioLabel1)
                        .addComponent(jLabel4))
                    .addComponent(botonCerrarSesionEmpleado))
                .addGap(27, 27, 27)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtBuscarEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonBuscarEmpleado)
                    .addComponent(botonActualizarEmpleado)
                    .addComponent(botonRegistrarEmpleado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );

        jTabbedPane1.addTab("Empleados", jPanel4);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Bienvenido:");

        usuarioLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        usuarioLabel2.setForeground(new java.awt.Color(0, 0, 102));
        usuarioLabel2.setText("Administrador");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel6.setText("Pizzabrosa");

        tablaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Código", "Descripción", "Precio", "Restricciones", "Cantidad"
            }
        ));
        jScrollPane3.setViewportView(tablaProductos);

        botonBuscarProducto.setIcon(new javax.swing.ImageIcon("C:\\Users\\Zelph\\Documents\\NetBeansProjects\\PizzabrosaV1.0\\src\\Imagenes\\iconoBuscar.png")); // NOI18N

        botonActualziarProducto.setIcon(new javax.swing.ImageIcon("C:\\Users\\Zelph\\Documents\\NetBeansProjects\\PizzabrosaV1.0\\src\\Imagenes\\IconoActualizar.png")); // NOI18N

        botonRegistrarProducto.setIcon(new javax.swing.ImageIcon("C:\\Users\\Zelph\\Documents\\NetBeansProjects\\PizzabrosaV1.0\\src\\Imagenes\\iconoAgregarProducto.png")); // NOI18N

        botonCerrarSesionProducto.setIcon(new javax.swing.ImageIcon("C:\\Users\\Zelph\\Documents\\NetBeansProjects\\PizzabrosaV1.0\\src\\Imagenes\\iconoCerrarSesión.png")); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 716, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(7, 7, 7)
                                .addComponent(usuarioLabel2)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(43, 43, 43)
                                .addComponent(botonCerrarSesionProducto))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(botonBuscarProducto)
                                .addGap(27, 27, 27)
                                .addComponent(botonActualziarProducto)
                                .addGap(18, 18, 18)
                                .addComponent(botonRegistrarProducto)))))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(usuarioLabel2)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(botonCerrarSesionProducto)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(txtBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(botonActualziarProducto)
                            .addComponent(botonBuscarProducto))
                        .addGap(38, 38, 38))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(botonRegistrarProducto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );

        jTabbedPane1.addTab("Productos", jPanel5);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Bienvenido:");

        usuarioLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        usuarioLabel3.setForeground(new java.awt.Color(0, 0, 102));
        usuarioLabel3.setText("Administrador");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel8.setText("Pizzabrosa");

        TablaPedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Cliente", "Fecha", "Estatus de Pedido"
            }
        ));
        jScrollPane4.setViewportView(TablaPedidos);

        botonBuscarPedido.setIcon(new javax.swing.ImageIcon("C:\\Users\\Zelph\\Documents\\NetBeansProjects\\PizzabrosaV1.0\\src\\Imagenes\\iconoBuscar.png")); // NOI18N

        botonActualzarPedido.setIcon(new javax.swing.ImageIcon("C:\\Users\\Zelph\\Documents\\NetBeansProjects\\PizzabrosaV1.0\\src\\Imagenes\\IconoActualizar.png")); // NOI18N

        botonRegistarPedido.setIcon(new javax.swing.ImageIcon("C:\\Users\\Zelph\\Documents\\NetBeansProjects\\PizzabrosaV1.0\\src\\Imagenes\\Iconopedidos.png")); // NOI18N

        botonCerrarSesionPedido.setIcon(new javax.swing.ImageIcon("C:\\Users\\Zelph\\Documents\\NetBeansProjects\\PizzabrosaV1.0\\src\\Imagenes\\iconoCerrarSesión.png")); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel7)
                .addGap(7, 7, 7)
                .addComponent(usuarioLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(42, 42, 42)
                .addComponent(botonCerrarSesionPedido)
                .addGap(30, 30, 30))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 659, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(botonBuscarPedido)
                        .addGap(33, 33, 33)
                        .addComponent(botonActualzarPedido)
                        .addGap(26, 26, 26)
                        .addComponent(botonRegistarPedido)))
                .addContainerGap(84, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)
                    .addComponent(usuarioLabel3)
                    .addComponent(botonCerrarSesionPedido))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonBuscarPedido)
                    .addComponent(botonActualzarPedido)
                    .addComponent(botonRegistarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );

        jTabbedPane1.addTab("Pedidos", jPanel6);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegistrarActionPerformed
        
        ClienteDAO modeloC = new ClienteDAO();
        ControladorCliente controlaC = new ControladorCliente(vc, modeloC);
        vc.setVisible(true);
        vc.pack();
        vc.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        vc.setLocationRelativeTo(null);
    }//GEN-LAST:event_botonRegistrarActionPerformed

    private void botonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonActualizarActionPerformed
        ClienteDAO modeloD = new ClienteDAO();
        //MenuPrincipal adc = new MenuPrincipal();
        ControladorCliente controlaD = new ControladorCliente(this,modeloD);
    }//GEN-LAST:event_botonActualizarActionPerformed

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
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaEmpleados;
    private javax.swing.JTable TablaPedidos;
    public javax.swing.JButton botonActualizar;
    private javax.swing.JButton botonActualizarEmpleado;
    private javax.swing.JButton botonActualzarPedido;
    private javax.swing.JButton botonActualziarProducto;
    public javax.swing.JButton botonBuscar;
    private javax.swing.JButton botonBuscarEmpleado;
    private javax.swing.JButton botonBuscarPedido;
    private javax.swing.JButton botonBuscarProducto;
    private javax.swing.JButton botonCerrarSesion;
    private javax.swing.JButton botonCerrarSesionEmpleado;
    private javax.swing.JButton botonCerrarSesionPedido;
    private javax.swing.JButton botonCerrarSesionProducto;
    private javax.swing.JButton botonRegistarPedido;
    private javax.swing.JButton botonRegistrar;
    private javax.swing.JButton botonRegistrarEmpleado;
    private javax.swing.JButton botonRegistrarProducto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tablaProductos;
    public javax.swing.JTable tablitaClientes;
    private javax.swing.JTextField txtBuscarEmpleado;
    private javax.swing.JTextField txtBuscarProducto;
    public javax.swing.JTextField txtBusquedaCliente;
    private javax.swing.JLabel usuarioLabel;
    private javax.swing.JLabel usuarioLabel1;
    private javax.swing.JLabel usuarioLabel2;
    private javax.swing.JLabel usuarioLabel3;
    // End of variables declaration//GEN-END:variables
}
