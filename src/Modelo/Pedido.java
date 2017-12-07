package Modelo;

import java.util.Date;

public class Pedido {
    int idPedido, idEstatusPedido,idCliente, idEmpleado;
    Date fechaPedido;

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getIdEstatusPedido() {
        return idEstatusPedido;
    }

    public void setIdEstatusPedido(int idEstatusPedido) {
        this.idEstatusPedido = idEstatusPedido;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Date getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(Date fechaPedido) {
        this.fechaPedido = fechaPedido;
    }
}
