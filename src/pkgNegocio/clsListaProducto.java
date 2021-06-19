/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgNegocio;

/**
 *
 * @author Alejandro
 */
public class clsListaProducto {
    private String id_producto;
    private String nombre_p;
    private String cantidad;
    private String valor_u;

    public clsListaProducto() {
    }

    public clsListaProducto(String id_producto, String nombre_p, String cantidad, String valor_u) {
        this.id_producto = id_producto;
        this.nombre_p = nombre_p;
        this.cantidad = cantidad;
        this.valor_u = valor_u;
    }

    public String getId_producto() {
        return id_producto;
    }

    public void setId_producto(String id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombre_p() {
        return nombre_p;
    }

    public void setNombre_p(String nombre_p) {
        this.nombre_p = nombre_p;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getValor_u() {
        return valor_u;
    }

    public void setValor_u(String valor_u) {
        this.valor_u = valor_u;
    }
    
    
    
    
    
    
}
