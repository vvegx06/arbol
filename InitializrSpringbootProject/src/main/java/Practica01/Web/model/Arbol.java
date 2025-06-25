/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practica01.Web.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import jakarta.persistence.Id;

@Entity
public class Arbol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Asegúrate de que este campo sea autoincremental
    private Long id; 
    private String nombreComun;
    private String tipoFlor;
    private Float durezaMadera;
    private String rutaImagen;
    private Float alturaPromedio;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreComun() {
        return nombreComun;
    }

    public void setNombreComun(String nombreComun) {
        this.nombreComun = nombreComun;
    }

    public String getTipoFlor() {
        return tipoFlor;
    }

    public void setTipoFlor(String tipoFlor) {
        this.tipoFlor = tipoFlor;
    }

    public Float getDurezaMadera() {
        return durezaMadera;
    }

    public void setDurezaMadera(Float durezaMadera) {
        this.durezaMadera = durezaMadera;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    public Float getAlturaPromedio() {
        return alturaPromedio;
    }

    public void setAlturaPromedio(Float alturaPromedio) {
        this.alturaPromedio = alturaPromedio;
    }
    
    
}
