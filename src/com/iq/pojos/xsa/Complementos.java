package com.iq.pojos.xsa;
// Generated 05-may-2020 13:56:01 by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * Complementos generated by hbm2java
 */
public class Complementos  implements java.io.Serializable {


     private Integer idComplemento;
     private String nombre;
     private String xsltCadena;
     private int orden;
     private String namespace;
     private String referenciaNamespace;
     private String prefijo;
     private boolean reloadXsltCadena;
     private String nivel;
     private Set tiposCfdComplementoses = new HashSet(0);

    public Complementos() {
    }

	
    public Complementos(String nombre, String xsltCadena, int orden, String namespace, String referenciaNamespace, String prefijo, boolean reloadXsltCadena, String nivel) {
        this.nombre = nombre;
        this.xsltCadena = xsltCadena;
        this.orden = orden;
        this.namespace = namespace;
        this.referenciaNamespace = referenciaNamespace;
        this.prefijo = prefijo;
        this.reloadXsltCadena = reloadXsltCadena;
        this.nivel = nivel;
    }
    public Complementos(String nombre, String xsltCadena, int orden, String namespace, String referenciaNamespace, String prefijo, boolean reloadXsltCadena, String nivel, Set tiposCfdComplementoses) {
       this.nombre = nombre;
       this.xsltCadena = xsltCadena;
       this.orden = orden;
       this.namespace = namespace;
       this.referenciaNamespace = referenciaNamespace;
       this.prefijo = prefijo;
       this.reloadXsltCadena = reloadXsltCadena;
       this.nivel = nivel;
       this.tiposCfdComplementoses = tiposCfdComplementoses;
    }
   
    public Integer getIdComplemento() {
        return this.idComplemento;
    }
    
    public void setIdComplemento(Integer idComplemento) {
        this.idComplemento = idComplemento;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getXsltCadena() {
        return this.xsltCadena;
    }
    
    public void setXsltCadena(String xsltCadena) {
        this.xsltCadena = xsltCadena;
    }
    public int getOrden() {
        return this.orden;
    }
    
    public void setOrden(int orden) {
        this.orden = orden;
    }
    public String getNamespace() {
        return this.namespace;
    }
    
    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }
    public String getReferenciaNamespace() {
        return this.referenciaNamespace;
    }
    
    public void setReferenciaNamespace(String referenciaNamespace) {
        this.referenciaNamespace = referenciaNamespace;
    }
    public String getPrefijo() {
        return this.prefijo;
    }
    
    public void setPrefijo(String prefijo) {
        this.prefijo = prefijo;
    }
    public boolean isReloadXsltCadena() {
        return this.reloadXsltCadena;
    }
    
    public void setReloadXsltCadena(boolean reloadXsltCadena) {
        this.reloadXsltCadena = reloadXsltCadena;
    }
    public String getNivel() {
        return this.nivel;
    }
    
    public void setNivel(String nivel) {
        this.nivel = nivel;
    }
    public Set getTiposCfdComplementoses() {
        return this.tiposCfdComplementoses;
    }
    
    public void setTiposCfdComplementoses(Set tiposCfdComplementoses) {
        this.tiposCfdComplementoses = tiposCfdComplementoses;
    }




}


