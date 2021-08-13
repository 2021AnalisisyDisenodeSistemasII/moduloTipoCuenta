/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author Usuario
 */
public class Persona {
    
    protected String documentoIdentidad;
    protected String nombrePersona;
    protected String direccion;
    protected String telefono;

    public Persona(String documentoIdentidad, String nombrePersona, String direccion, String telefono) {
        this.documentoIdentidad = documentoIdentidad;
        this.nombrePersona = nombrePersona;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public String getdocumentoIdentidad() {
        return documentoIdentidad;
    }

    public void setdocumentoIdentidad(String id) {
        this.documentoIdentidad = documentoIdentidad;
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombre) {
        this.nombrePersona = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
   
    
    
}
