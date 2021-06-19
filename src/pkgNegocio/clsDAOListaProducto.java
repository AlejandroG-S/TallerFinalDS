/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgNegocio;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alejandro
 */
public class clsDAOListaProducto extends clsListaProducto{
    
    pkgDatos.clsConecta con;

    public clsDAOListaProducto() {
        con = new pkgDatos.clsConecta();
    }
    
    public boolean insertar() {
        String SQL = "INSERT INTO administrador.tbl_lista(id_producto, nombre_p, cantidad, valor_u) VALUES ('" + super.getId_producto() + "','" + super.getNombre_p() + "', '" + super.getCantidad() + "', '" + super.getValor_u() + "')";
        return con.procesarSQL(SQL);
    }
    
    public void borrar() {
        String SQL = "DELETE FROM administrador.tbl_lista WHERE id_producto='" + super.getId_producto() + "'";
        con.procesarSQL(SQL);
    }
    
    public boolean modificar(){
        String SQL = "UPDATE administrador.tbl_lista SET cantidad='" + super.getCantidad() + "' WHERE nombre_p='" + super.getNombre_p() +"'";
        return con.procesarSQL(SQL);
    }
    
    public String consultar() {
        String SQL = "SELECT nombre_p, cantidad FROM administrador.tbl_lista WHERE nombre_p='" + super.getNombre_p() + "'";
        java.sql.ResultSet hr = null;
        hr = con.consultarSQL(SQL);
        try {
            if (hr.next()) {
                return hr.getString(2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(clsDAOListaProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "no";
    }
    
    public javax.swing.table.DefaultTableModel listarP(JTable tbl) {
        javax.swing.table.DefaultTableModel modelo;
        modelo = new DefaultTableModel(new Object[]{tbl.getColumnName(0), tbl.getColumnName(1), tbl.getColumnName(2), tbl.getColumnName(3),}, 0);

        String SQL = "SELECT id_producto, nombre_p, cantidad, valor_u FROM administrador.tbl_lista";
        java.sql.ResultSet res = null;

        res = con.consultarSQL(SQL);

        try {
            while (res.next()) {
                modelo.addRow(new Object[]{res.getString(1), res.getString(2), res.getString(3), res.getString(4)});
            }
        } catch (SQLException ex) {
            System.out.println("Error consultando para listar");
        }
        return modelo;
    }
    
    public javax.swing.DefaultComboBoxModel listarCombo() {
        javax.swing.DefaultComboBoxModel modelo;
        modelo = new javax.swing.DefaultComboBoxModel();

        String SQL = "SELECT id_producto, nombre_p, cantidad, valor_u FROM administrador.tbl_lista";
        java.sql.ResultSet res = null;

        res = con.consultarSQL(SQL);

        try {
            while (res.next()) {
                modelo.addElement(res.getString(2));
            }
        } catch (SQLException ex) {
            System.out.println("Error consultando para listar en combo");
        }
        return modelo;
    }
}
