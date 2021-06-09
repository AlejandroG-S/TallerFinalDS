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
public class clsDAOTarea extends clsTarea {
    
    pkgDatos.clsConecta con;

    public clsDAOTarea() {
        con = new pkgDatos.clsConecta();
    }
    
    public boolean insertar() {
        String SQL = "INSERT INTO administrador.tbl_tarea(id_t, materia, descripcion, d_entrega) VALUES ('" + super.getId_t() + "','" + super.getMateria() + "', '" + super.getDescripcion() + "', '" + super.getD_entrega() + "')";
        return con.procesarSQL(SQL);
    }
    
    public void borrar() {
        String SQL = "DELETE FROM administrador.tbl_tarea WHERE id_t='" + super.getId_t() + "'";
        con.procesarSQL(SQL);
    }
    
    public boolean modificar(){
        String SQL = "UPDATE administrador.tbl_tarea SET materia='" + super.getMateria() + "' WHERE id_t='" + super.getId_t() + "' WHERE descripcion='" + super.getDescripcion() +"' WHERE d_entrega='" + super.getD_entrega() +"'";
        return con.procesarSQL(SQL);
    }
    
    public String consultar() {
        String SQL = "SELECT id_, materia, descripcion, d_entrega FROM administrador.tbl_persona WHERE id_='" + super.getId_t() + "'";
        java.sql.ResultSet hr = null;
        hr = con.consultarSQL(SQL);
        try {
            if (hr.next()) {
                return hr.getString(2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(clsDAOPersona.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "no";
    }
    
    public javax.swing.table.DefaultTableModel listarT(JTable tbl) {
        javax.swing.table.DefaultTableModel modelo;
        modelo = new DefaultTableModel(new Object[]{tbl.getColumnName(0), tbl.getColumnName(1), tbl.getColumnName(2), tbl.getColumnName(3),}, 0);

        String SQL = "SELECT id_t, materia, descripcion, d_entrega FROM administrador.tbl_tarea";
        java.sql.ResultSet res = null;

        res = con.consultarSQL(SQL);

        try {
            while (res.next()) {
                modelo.addRow(new Object[]{res.getString(1), res.getString(2), res.getString(3), res.getString(4) });
            }
        } catch (SQLException ex) {
            System.out.println("Error consultando para listar");
        }
        return modelo;
    }
    
    public javax.swing.DefaultComboBoxModel listarCombo() {
        javax.swing.DefaultComboBoxModel modelo;
        modelo = new javax.swing.DefaultComboBoxModel();

        String SQL = "SELECT id, materia, descripcion, d_entrega FROM administrador.tbl_tarea";
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
