/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.logging.Logger;


public class Region {

    private String codigo;
    private String nombre;
    private String cod_pais;
    
    private static final Logger LOG = Logger.getLogger(Region.class.getName());

    public Region(String codigo, String nombre, String cod_pais) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cod_pais = cod_pais;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCod_pais() {
        return cod_pais;
    }

    public void setCod_pais(String cod_pais) {
        this.cod_pais = cod_pais;
    }

    
    
    
}
