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
public class clsTarea {
    private String id_t;
    private String materia;
    private String descripcion;
    private String d_entrega;

    public clsTarea() {
    }

    public clsTarea(String id_t, String materia, String descripcion, String d_entrega) {
        this.id_t = id_t;
        this.materia = materia;
        this.descripcion = descripcion;
        this.d_entrega = d_entrega;
    }

    public String getId_t() {
        return id_t;
    }

    public void setId_t(String id_t) {
        this.id_t = id_t;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getD_entrega() {
        return d_entrega;
    }

    public void setD_entrega(String d_entrega) {
        this.d_entrega = d_entrega;
    }
    
    
    
}
