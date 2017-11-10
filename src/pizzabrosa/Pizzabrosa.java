
package pizzabrosa;
import modelo.*;
import vista.*;
import Controlador.*;
import Modelo.ClienteDAO;
import Vista.VentanaClientes;
import com.sun.security.ntlm.Client;


public class Pizzabrosa {

   
    public static void main(String[] args) {
        VentanaClientes vistaC= new VentanaClientes();
        ClienteDAO modeloC = new ClienteDAO();
        ControladorCliente controlaC = new ControladorCliente(vistaC, modeloC);
        vistaC.setVisible(true);
        vistaC.setLocationRelativeTo(null);
    
    }
    
}
