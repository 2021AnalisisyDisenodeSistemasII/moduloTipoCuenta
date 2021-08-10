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
public class Empresa extends Cliente {
    
    protected String nit;
    protected String nombreEmpresa;
    protected String sectorEmpresa;
    protected String direccionEmpresa;

    public Empresa(String nit, String nombreEmpresa, String sectorEmpresa, String direccionEmpresa, String documentoIdentidad, String telefono, String nombrePersona, String ocupacion, String direccion) {
        super(documentoIdentidad, telefono, nombrePersona, ocupacion, direccion);
        this.nit = nit;
        this.nombreEmpresa = nombreEmpresa;
        this.sectorEmpresa = sectorEmpresa;
        this.direccionEmpresa = direccionEmpresa;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getSectorEmpresa() {
        return sectorEmpresa;
    }

    public void setSectorEmpresa(String sectorEmpresa) {
        this.sectorEmpresa = sectorEmpresa;
    }

    public String getDireccionEmpresa() {
        return direccionEmpresa;
    }

    public void setDireccionEmpresa(String direccionEmpresa) {
        this.direccionEmpresa = direccionEmpresa;
    }

 
    
    
    
}
