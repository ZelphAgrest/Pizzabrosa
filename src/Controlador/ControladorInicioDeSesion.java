package Controlador;

import Modelo.InicioDeSesionDAO;
import Vista.InicioSesion;
import Vista.MenuPrincipal;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

public class ControladorInicioDeSesion {

    InicioSesion vistaInicioSesion;
    InicioDeSesionDAO modelo;

    public ControladorInicioDeSesion(InicioSesion vistaInicioSesion, InicioDeSesionDAO modelo) {
        this.vistaInicioSesion = vistaInicioSesion;
        this.modelo = modelo;
    }

    public void IniciarSesion(InicioSesion vistaInicioSesion) {
        this.vistaInicioSesion = vistaInicioSesion;
        String user = this.vistaInicioSesion.campoUsuario.getText();
        String password = this.vistaInicioSesion.campoPassword.getText();
        String rptaRegistro = modelo.inicioSesion(user, password);
        
        if (rptaRegistro != null && rptaRegistro.equals("Registro Exitoso")) {
             
            this.vistaInicioSesion.dispose();
            
            new MenuPrincipal(this.vistaInicioSesion.campoUsuario.getText()).setVisible(true);
            
        } else {
            JOptionPane.showMessageDialog(null, "Usuario y/o contraseña incorrectos");
        }

    }
    
    
    
    public void salirSistema(){
        System.exit(0);
    }

}
