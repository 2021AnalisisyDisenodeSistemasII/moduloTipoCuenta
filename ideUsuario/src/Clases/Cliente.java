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
public class Cliente {
    
    private String documentoIdentidad;
    private String telefono;
    private String nombrePersona;
    private String ocupacion;
    private String direccion;
    
    public Cliente(String documentoIdentidad, String telefono, String nombrePersona, String ocupacion, String direccion){
        
        this.documentoIdentidad = documentoIdentidad;
        this.telefono = telefono;
        this.nombrePersona = nombrePersona;
        this.ocupacion = ocupacion;
        this.direccion = direccion;
    }

    public String getDocumentoIdentidad() {
        return documentoIdentidad;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDocumentoIdentidad(String documentoIdentidad) {
        this.documentoIdentidad = documentoIdentidad;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    
}
