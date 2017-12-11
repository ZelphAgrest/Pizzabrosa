package Vista;

import Controlador.Comunica;
import Controlador.ControladorCliente;
import Controlador.ControladorEmpleado;
import Controlador.ControladorPedido;
import Controlador.ControladorProducto;
import Modelo.ClienteDAO;
import Modelo.EmpleadoDAO;
import Modelo.PedidoDAO;
import Modelo.ProductoDAO;
import javax.swing.JFrame;

public class MenuPrincipal extends javax.swing.JFrame implements Comunica {

    ClienteDAO modelo;
    EmpleadoDAO modeloE;
    ProductoDAO modeloP;
    PedidoDAO modeloPe;
    ControladorCliente controlador;
    ControladorEmpleado controladorE;
    ControladorProducto controladorP;
    ControladorPedido controladorPe;
    static String usser;
    

    /**
     * Creates new form AdminCliente
     */
    public MenuPrincipal(String usuario) {
        initComponents();
        setTitle("Pizzabrosa - Menú Principal");
        setLocationRelativeTo(null);
        setResizable(false);
        usser = usuario;
        this.iniciaClase();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        popup = new javax.swing.JPopupMenu();
        editarPopUpClientes = new javax.swing.JMenuItem();
        eliminarPopUpClientes = new javax.swing.JMenuItem();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        popupEmpleado = new javax.swing.JPopupMenu();
        editarPopUpEmpleados = new javax.swing.JMenuItem();
        eliminarPopUpEmpleados = new javax.swing.JMenuItem();
        popupProductos = new javax.swing.JPopupMenu();
        popUpEditarProducto = new javax.swing.JMenuItem();
        popUpEliminarProducto = new javax.swing.JMenuItem();
        popupPedidos = new javax.swing.JPopupMenu();
        popUpEditarEstatusPedido = new javax.swing.JMenuItem();
        popUpEditarProductosPedido = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablitaClientes = new javax.swing.JTable();
        botonActualizar = new javax.swing.JButton();
        txtBusquedaCliente = new javax.swing.JTextField();
        botonRegistrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        botonCerrarSesion = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        usuarioLabel = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        usuarioLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtBuscarEmpleado = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaEmpleados = new javax.swing.JTable();
        botonActualizarEmpleado = new javax.swing.JButton();
        botonRegistrarEmpleado = new javax.swing.JButton();
        botonCerrarSesionEmpleado = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        usuarioLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaProductos = new javax.swing.JTable();
        txtBuscarProducto = new javax.swing.JTextField();
        botonActualziarProducto = new javax.swing.JButton();
        botonRegistrarProducto = new javax.swing.JButton();
        botonCerrarSesionProducto = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        usuarioLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        TablaPedidos = new javax.swing.JTable();
        txtBuscarPedido = new javax.swing.JTextField();
        botonActualzarPedido = new javax.swing.JButton();
        botonRegistarPedido = new javax.swing.JButton();
        botonCerrarSesionPedido = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        comboBusquedaxEstatus = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();

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

        editarPopUpClientes.setIcon(new javax.swing.ImageIcon("C:\\Users\\Zelph\\Documents\\NetBeansProjects\\PizzabrosaV1.0\\src\\Imagenes\\IconoEditar.png")); // NOI18N
        editarPopUpClientes.setText("Editar");
        editarPopUpClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarPopUpClientesActionPerformed(evt);
            }
        });
        popup.add(editarPopUpClientes);

        eliminarPopUpClientes.setIcon(new javax.swing.ImageIcon("C:\\Users\\Zelph\\Documents\\NetBeansProjects\\PizzabrosaV1.0\\src\\Imagenes\\IconoEliminar.png")); // NOI18N
        eliminarPopUpClientes.setText("Eliminar");
        popup.add(eliminarPopUpClientes);

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Ingresar el apellido que desea buscar");

        jLabel13.setIcon(new javax.swing.ImageIcon("C:\\Users\\Zelph\\Documents\\NetBeansProjects\\PizzabrosaV1.0\\src\\Imagenes\\iconoBuscar.png")); // NOI18N

        editarPopUpEmpleados.setIcon(new javax.swing.ImageIcon("C:\\Users\\Zelph\\Documents\\NetBeansProjects\\PizzabrosaV1.0\\src\\Imagenes\\IconoEditar.png")); // NOI18N
        editarPopUpEmpleados.setText("Editar");
        editarPopUpEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarPopUpEmpleadosActionPerformed(evt);
            }
        });
        popupEmpleado.add(editarPopUpEmpleados);

        eliminarPopUpEmpleados.setIcon(new javax.swing.ImageIcon("C:\\Users\\Zelph\\Documents\\NetBeansProjects\\PizzabrosaV1.0\\src\\Imagenes\\IconoEliminar.png")); // NOI18N
        eliminarPopUpEmpleados.setText("Eliminar");
        popupEmpleado.add(eliminarPopUpEmpleados);

        popUpEditarProducto.setIcon(new javax.swing.ImageIcon("C:\\Users\\Zelph\\Documents\\NetBeansProjects\\PizzabrosaV1.0\\src\\Imagenes\\IconoEditar.png")); // NOI18N
        popUpEditarProducto.setText("Editar");
        popUpEditarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                popUpEditarProductoActionPerformed(evt);
            }
        });
        popupProductos.add(popUpEditarProducto);

        popUpEliminarProducto.setIcon(new javax.swing.ImageIcon("C:\\Users\\Zelph\\Documents\\NetBeansProjects\\PizzabrosaV1.0\\src\\Imagenes\\IconoEliminar.png")); // NOI18N
        popUpEliminarProducto.setText("Eliminar");
        popupProductos.add(popUpEliminarProducto);

        popUpEditarEstatusPedido.setIcon(new javax.swing.ImageIcon("C:\\Users\\Zelph\\Documents\\NetBeansProjects\\PizzabrosaV1.0\\src\\Imagenes\\IconoEditar.png")); // NOI18N
        popUpEditarEstatusPedido.setText("Editar Estatus");
        popUpEditarEstatusPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                popUpEditarEstatusPedidoActionPerformed(evt);
            }
        });
        popupPedidos.add(popUpEditarEstatusPedido);

        popUpEditarProductosPedido.setIcon(new javax.swing.ImageIcon("C:\\Users\\Zelph\\Documents\\NetBeansProjects\\PizzabrosaV1.0\\src\\Imagenes\\IconoEditar.png")); // NOI18N
        popUpEditarProductosPedido.setText("Editar Productos");
        popUpEditarProductosPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                popUpEditarProductosPedidoActionPerformed(evt);
            }
        });
        popupPedidos.add(popUpEditarProductosPedido);

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
        tablitaClientes.setComponentPopupMenu(popup);
        jScrollPane1.setViewportView(tablitaClientes);

        botonActualizar.setIcon(new javax.swing.ImageIcon("C:\\Users\\Zelph\\Documents\\NetBeansProjects\\PizzabrosaV1.0\\src\\Imagenes\\IconoActualizar.png")); // NOI18N
        botonActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonActualizarActionPerformed(evt);
            }
        });

        txtBusquedaCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBusquedaClienteKeyReleased(evt);
            }
        });

        botonRegistrar.setIcon(new javax.swing.ImageIcon("C:\\Users\\Zelph\\Documents\\NetBeansProjects\\PizzabrosaV1.0\\src\\Imagenes\\iconoRegistrarUsuario.png")); // NOI18N
        botonRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegistrarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Zelph\\Documents\\NetBeansProjects\\PizzabrosaV1.0\\src\\Imagenes\\pizzabrosaPestaña.png")); // NOI18N

        botonCerrarSesion.setIcon(new javax.swing.ImageIcon("C:\\Users\\Zelph\\Documents\\NetBeansProjects\\PizzabrosaV1.0\\src\\Imagenes\\iconoCerrarSesión.png")); // NOI18N
        botonCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCerrarSesionActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Bienvenido:");

        usuarioLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        usuarioLabel.setForeground(new java.awt.Color(0, 0, 102));
        usuarioLabel.setText("Administrador");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Escribe el apellido que deseas buscar:");

        jLabel14.setIcon(new javax.swing.ImageIcon("C:\\Users\\Zelph\\Documents\\NetBeansProjects\\PizzabrosaV1.0\\src\\Imagenes\\iconoBuscar.png")); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel14)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtBusquedaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(botonActualizar))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(usuarioLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 288, Short.MAX_VALUE)
                                        .addComponent(jLabel1)))
                                .addGap(24, 24, 24)))
                        .addGap(4, 4, 4)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botonCerrarSesion)
                            .addComponent(botonRegistrar))
                        .addGap(10, 10, 10)))
                .addGap(26, 26, 26))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(botonCerrarSesion))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(usuarioLabel)))
                    .addComponent(jLabel1))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(botonRegistrar))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12)
                        .addGap(15, 15, 15)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(txtBusquedaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(botonActualizar)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(87, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Clientes", jPanel2);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Bienvenido:");

        usuarioLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        usuarioLabel1.setForeground(new java.awt.Color(0, 0, 102));
        usuarioLabel1.setText("Administrador");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\Zelph\\Documents\\NetBeansProjects\\PizzabrosaV1.0\\src\\Imagenes\\pizzabrosaPestaña.png")); // NOI18N

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
        TablaEmpleados.setComponentPopupMenu(popupEmpleado);
        jScrollPane2.setViewportView(TablaEmpleados);

        botonActualizarEmpleado.setIcon(new javax.swing.ImageIcon("C:\\Users\\Zelph\\Documents\\NetBeansProjects\\PizzabrosaV1.0\\src\\Imagenes\\IconoActualizar.png")); // NOI18N
        botonActualizarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonActualizarEmpleadoActionPerformed(evt);
            }
        });

        botonRegistrarEmpleado.setIcon(new javax.swing.ImageIcon("C:\\Users\\Zelph\\Documents\\NetBeansProjects\\PizzabrosaV1.0\\src\\Imagenes\\iconoRegistrarUsuario.png")); // NOI18N
        botonRegistrarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegistrarEmpleadoActionPerformed(evt);
            }
        });

        botonCerrarSesionEmpleado.setIcon(new javax.swing.ImageIcon("C:\\Users\\Zelph\\Documents\\NetBeansProjects\\PizzabrosaV1.0\\src\\Imagenes\\iconoCerrarSesión.png")); // NOI18N
        botonCerrarSesionEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCerrarSesionEmpleadoActionPerformed(evt);
            }
        });

        jLabel9.setIcon(new javax.swing.ImageIcon("C:\\Users\\Zelph\\Documents\\NetBeansProjects\\PizzabrosaV1.0\\src\\Imagenes\\iconoBuscar.png")); // NOI18N

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Escribe el apellido que deseas buscar:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(usuarioLabel1))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(2, 2, 2)
                                .addComponent(txtBuscarEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botonActualizarEmpleado, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(46, 46, 46)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botonCerrarSesionEmpleado, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(botonRegistrarEmpleado, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 819, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(usuarioLabel1))
                        .addGap(26, 26, 26)
                        .addComponent(jLabel10)
                        .addGap(33, 33, 33)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtBuscarEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel4))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(botonCerrarSesionEmpleado)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botonRegistrarEmpleado, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(botonActualizarEmpleado, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(68, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Empleados", jPanel4);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Bienvenido:");

        usuarioLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        usuarioLabel2.setForeground(new java.awt.Color(0, 0, 102));
        usuarioLabel2.setText("Administrador");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel6.setIcon(new javax.swing.ImageIcon("C:\\Users\\Zelph\\Documents\\NetBeansProjects\\PizzabrosaV1.0\\src\\Imagenes\\pizzabrosaPestaña.png")); // NOI18N

        tablaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Producto", "Nombre", "Código", "Descripción", "Precio", "Cantidad", "Restricciones"
            }
        ));
        tablaProductos.setComponentPopupMenu(popupProductos);
        jScrollPane3.setViewportView(tablaProductos);

        botonActualziarProducto.setIcon(new javax.swing.ImageIcon("C:\\Users\\Zelph\\Documents\\NetBeansProjects\\PizzabrosaV1.0\\src\\Imagenes\\IconoActualizar.png")); // NOI18N
        botonActualziarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonActualziarProductoActionPerformed(evt);
            }
        });

        botonRegistrarProducto.setIcon(new javax.swing.ImageIcon("C:\\Users\\Zelph\\Documents\\NetBeansProjects\\PizzabrosaV1.0\\src\\Imagenes\\iconoAgregarProducto.png")); // NOI18N
        botonRegistrarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegistrarProductoActionPerformed(evt);
            }
        });

        botonCerrarSesionProducto.setIcon(new javax.swing.ImageIcon("C:\\Users\\Zelph\\Documents\\NetBeansProjects\\PizzabrosaV1.0\\src\\Imagenes\\iconoCerrarSesión.png")); // NOI18N
        botonCerrarSesionProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCerrarSesionProductoActionPerformed(evt);
            }
        });

        jLabel15.setIcon(new javax.swing.ImageIcon("C:\\Users\\Zelph\\Documents\\NetBeansProjects\\PizzabrosaV1.0\\src\\Imagenes\\iconoBuscar.png")); // NOI18N

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setText("Escribe el nombre del producto que deseas buscar:");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane3)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(usuarioLabel2)
                                        .addGap(241, 256, Short.MAX_VALUE)
                                        .addComponent(jLabel6))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(jLabel15)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(botonActualziarProducto)))
                                .addGap(47, 47, 47)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(botonRegistrarProducto, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(botonCerrarSesionProducto, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addGap(34, 34, 34))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(botonCerrarSesionProducto))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(usuarioLabel2))))
                        .addGap(9, 9, 9)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(jLabel17)
                .addGap(9, 9, 9)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel15)
                        .addComponent(txtBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(botonActualziarProducto))
                    .addComponent(botonRegistrarProducto))
                .addGap(41, 41, 41)
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
        jLabel8.setIcon(new javax.swing.ImageIcon("C:\\Users\\Zelph\\Documents\\NetBeansProjects\\PizzabrosaV1.0\\src\\Imagenes\\pizzabrosaPestaña.png")); // NOI18N

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
        TablaPedidos.setComponentPopupMenu(popupPedidos);
        jScrollPane4.setViewportView(TablaPedidos);

        txtBuscarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarPedidoActionPerformed(evt);
            }
        });

        botonActualzarPedido.setIcon(new javax.swing.ImageIcon("C:\\Users\\Zelph\\Documents\\NetBeansProjects\\PizzabrosaV1.0\\src\\Imagenes\\IconoActualizar.png")); // NOI18N
        botonActualzarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonActualzarPedidoActionPerformed(evt);
            }
        });

        botonRegistarPedido.setIcon(new javax.swing.ImageIcon("C:\\Users\\Zelph\\Documents\\NetBeansProjects\\PizzabrosaV1.0\\src\\Imagenes\\Iconopedidos.png")); // NOI18N
        botonRegistarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegistarPedidoActionPerformed(evt);
            }
        });

        botonCerrarSesionPedido.setIcon(new javax.swing.ImageIcon("C:\\Users\\Zelph\\Documents\\NetBeansProjects\\PizzabrosaV1.0\\src\\Imagenes\\iconoCerrarSesión.png")); // NOI18N
        botonCerrarSesionPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCerrarSesionPedidoActionPerformed(evt);
            }
        });

        jLabel16.setIcon(new javax.swing.ImageIcon("C:\\Users\\Zelph\\Documents\\NetBeansProjects\\PizzabrosaV1.0\\src\\Imagenes\\iconoBuscar.png")); // NOI18N

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setText("Escribe el apellido del cliente que deseas buscar:");

        comboBusquedaxEstatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona un Estatus", "Entregado", "En Proceso", "Cancelado" }));
        comboBusquedaxEstatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBusquedaxEstatusActionPerformed(evt);
            }
        });

        jLabel19.setText("Filtrar Pedidos por estatus:");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jScrollPane4))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(usuarioLabel3))
                            .addComponent(jLabel18)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtBuscarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(comboBusquedaxEstatus, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(botonActualzarPedido)
                                .addGap(54, 54, 54)
                                .addComponent(botonRegistarPedido))
                            .addComponent(jLabel8))
                        .addGap(42, 42, 42)
                        .addComponent(botonCerrarSesionPedido)))
                .addGap(30, 30, 30))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(botonCerrarSesionPedido, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel8))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(usuarioLabel3))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel18)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(txtBuscarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonRegistarPedido, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonActualzarPedido, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboBusquedaxEstatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
            .addComponent(jTabbedPane1)
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

    //Método de inicialización
    private void iniciaClase() {
        modelo = new ClienteDAO();
        controlador = new ControladorCliente(this, modelo);
        modeloE = new EmpleadoDAO();
        controladorE = new ControladorEmpleado(this, modeloE);
        modeloP= new ProductoDAO();
        controladorP = new ControladorProducto(this, modeloP);
        modeloPe = new PedidoDAO();
        controladorPe = new ControladorPedido(this, modeloPe);
        usuarioLabel3.setText(usser);
        usuarioLabel2.setText(usser);
        usuarioLabel1.setText(usser);
        usuarioLabel.setText(usser);
    }


    private void botonRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegistrarActionPerformed
        RegistrarClientes vc = new RegistrarClientes(this);
        controlador.vinculaRegistroClientes(vc);
        vc.setVisible(true);
        vc.pack();
        vc.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        vc.setLocationRelativeTo(null);
    }//GEN-LAST:event_botonRegistrarActionPerformed

    private void botonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonActualizarActionPerformed
        controlador.LlenarTabla(tablitaClientes);
        txtBusquedaCliente.setText("");
    }//GEN-LAST:event_botonActualizarActionPerformed

    private void editarPopUpClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarPopUpClientesActionPerformed
        EditarCliente ved = new EditarCliente(this);
        controlador.vinculaEditaClientes(ved, this);
        ved.setVisible(true);
        ved.pack();
        ved.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ved.setLocationRelativeTo(null);
    }//GEN-LAST:event_editarPopUpClientesActionPerformed

    private void botonRegistrarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegistrarEmpleadoActionPerformed
        RegistrarEmpleado ve = new RegistrarEmpleado(this);
        controladorE.VinculaRegistroEmpleado(ve);
        ve.setVisible(true);
        ve.pack();
        ve.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ve.setLocationRelativeTo(null);
    }//GEN-LAST:event_botonRegistrarEmpleadoActionPerformed

    private void botonActualizarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonActualizarEmpleadoActionPerformed
        controladorE.LlenarTablaEmpleado(TablaEmpleados);
        txtBuscarEmpleado.setText("");
    }//GEN-LAST:event_botonActualizarEmpleadoActionPerformed

    private void txtBusquedaClienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusquedaClienteKeyReleased

    }//GEN-LAST:event_txtBusquedaClienteKeyReleased

    private void editarPopUpEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarPopUpEmpleadosActionPerformed
        EditarEmpleado vee = new EditarEmpleado(this);
        controladorE.vinculaEditaEmpleado(vee, this);
        vee.setVisible(true);
        vee.pack();
        vee.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        vee.setLocationRelativeTo(null);
    }//GEN-LAST:event_editarPopUpEmpleadosActionPerformed

    private void botonRegistrarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegistrarProductoActionPerformed
        RegistrarProductos vrp = new RegistrarProductos(this);
        controladorP.llenarCombo(vrp);
        controladorP.VinculaRegistroProducto(vrp);
        vrp.setVisible(true);
        vrp.pack();
        vrp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        vrp.setLocationRelativeTo(null);
    }//GEN-LAST:event_botonRegistrarProductoActionPerformed

    private void botonActualziarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonActualziarProductoActionPerformed
        controladorP.LlenarTablaProductos(tablaProductos);
        txtBuscarProducto.setText("");
    }//GEN-LAST:event_botonActualziarProductoActionPerformed

    private void botonCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCerrarSesionActionPerformed
       dispose();
        new InicioSesion().setVisible(true);
    }//GEN-LAST:event_botonCerrarSesionActionPerformed

    private void botonCerrarSesionEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCerrarSesionEmpleadoActionPerformed
        dispose();
        new InicioSesion().setVisible(true);
    }//GEN-LAST:event_botonCerrarSesionEmpleadoActionPerformed

    private void botonCerrarSesionProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCerrarSesionProductoActionPerformed
        dispose();
        new InicioSesion().setVisible(true);
    }//GEN-LAST:event_botonCerrarSesionProductoActionPerformed

    private void botonCerrarSesionPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCerrarSesionPedidoActionPerformed
        dispose();
        new InicioSesion().setVisible(true);
    }//GEN-LAST:event_botonCerrarSesionPedidoActionPerformed

    private void popUpEditarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_popUpEditarProductoActionPerformed
        EditarProductos vep = new EditarProductos(this);
        controladorP.llenarComboEditarProducto(vep);
        controladorP.vinculaEditaProducto(vep, this);
        vep.setVisible(true);
        vep.pack();
        vep.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        vep.setLocationRelativeTo(null);
    }//GEN-LAST:event_popUpEditarProductoActionPerformed

    private void botonRegistarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegistarPedidoActionPerformed
        String cajero = usuarioLabel3.getText();
        RegistrarPedido vrepe = new RegistrarPedido(this,cajero);
        controladorPe.llenarCombo(vrepe);
        controladorPe.VinculaRegistroPedido(vrepe);
        vrepe.setVisible(true);
        vrepe.pack();
        vrepe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        vrepe.setLocationRelativeTo(null);
    }//GEN-LAST:event_botonRegistarPedidoActionPerformed

    private void botonActualzarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonActualzarPedidoActionPerformed
       // controladorPe.LlenarTablaPedidos(TablaPedidos);
        txtBuscarPedido.setText("");
        comboBusquedaxEstatus.setSelectedIndex(0);
    }//GEN-LAST:event_botonActualzarPedidoActionPerformed

    private void txtBuscarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarPedidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarPedidoActionPerformed

    private void comboBusquedaxEstatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBusquedaxEstatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBusquedaxEstatusActionPerformed

    private void popUpEditarEstatusPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_popUpEditarEstatusPedidoActionPerformed
        int index = TablaPedidos.getSelectedRow();
        String idpedido = TablaPedidos.getValueAt(index, 0).toString();
        String idEstatusOriginal = TablaPedidos.getValueAt(index, 2).toString();
        EditarEstatusPedido veep = new EditarEstatusPedido(this,idpedido,idEstatusOriginal);
        controladorPe.llenarComboEditarEstatus(veep);
        controladorPe.vinculaEditarEstatusPedido(veep);
        veep.setVisible(true);
        veep.pack();
        veep.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        veep.setLocationRelativeTo(null);
    }//GEN-LAST:event_popUpEditarEstatusPedidoActionPerformed

    private void popUpEditarProductosPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_popUpEditarProductosPedidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_popUpEditarProductosPedidoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal(usser).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTable TablaEmpleados;
    public javax.swing.JTable TablaPedidos;
    public javax.swing.JButton botonActualizar;
    private javax.swing.JButton botonActualizarEmpleado;
    private javax.swing.JButton botonActualzarPedido;
    public javax.swing.JButton botonActualziarProducto;
    private javax.swing.JButton botonCerrarSesion;
    private javax.swing.JButton botonCerrarSesionEmpleado;
    private javax.swing.JButton botonCerrarSesionPedido;
    public javax.swing.JButton botonCerrarSesionProducto;
    private javax.swing.JButton botonRegistarPedido;
    private javax.swing.JButton botonRegistrar;
    private javax.swing.JButton botonRegistrarEmpleado;
    public javax.swing.JButton botonRegistrarProducto;
    public javax.swing.JComboBox<String> comboBusquedaxEstatus;
    public javax.swing.JMenuItem editarPopUpClientes;
    public javax.swing.JMenuItem editarPopUpEmpleados;
    public javax.swing.JMenuItem eliminarPopUpClientes;
    public javax.swing.JMenuItem eliminarPopUpEmpleados;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
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
    public javax.swing.JMenuItem popUpEditarEstatusPedido;
    public javax.swing.JMenuItem popUpEditarProducto;
    public javax.swing.JMenuItem popUpEditarProductosPedido;
    public javax.swing.JMenuItem popUpEliminarProducto;
    public javax.swing.JPopupMenu popup;
    private javax.swing.JPopupMenu popupEmpleado;
    private javax.swing.JPopupMenu popupPedidos;
    public javax.swing.JPopupMenu popupProductos;
    public javax.swing.JTable tablaProductos;
    public javax.swing.JTable tablitaClientes;
    public javax.swing.JTextField txtBuscarEmpleado;
    public javax.swing.JTextField txtBuscarPedido;
    public javax.swing.JTextField txtBuscarProducto;
    public javax.swing.JTextField txtBusquedaCliente;
    private javax.swing.JLabel usuarioLabel;
    public javax.swing.JLabel usuarioLabel1;
    private javax.swing.JLabel usuarioLabel2;
    private javax.swing.JLabel usuarioLabel3;
    // End of variables declaration//GEN-END:variables

    

}
