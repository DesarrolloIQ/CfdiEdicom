package com.iq.pojos.xsa;
// Generated 05-may-2020 13:56:01 by Hibernate Tools 3.2.1.GA



/**
 * XmlsRetenciones generated by hbm2java
 */
public class XmlsRetenciones  implements java.io.Serializable {


     private int idCfdRetencion;
     private CfdsRetenciones cfdsRetenciones;
     private String xmlTralix;
     private String xmlSat;

    public XmlsRetenciones() {
    }

	
    public XmlsRetenciones(int idCfdRetencion, CfdsRetenciones cfdsRetenciones) {
        this.idCfdRetencion = idCfdRetencion;
        this.cfdsRetenciones = cfdsRetenciones;
    }
    public XmlsRetenciones(int idCfdRetencion, CfdsRetenciones cfdsRetenciones, String xmlTralix, String xmlSat) {
       this.idCfdRetencion = idCfdRetencion;
       this.cfdsRetenciones = cfdsRetenciones;
       this.xmlTralix = xmlTralix;
       this.xmlSat = xmlSat;
    }
   
    public int getIdCfdRetencion() {
        return this.idCfdRetencion;
    }
    
    public void setIdCfdRetencion(int idCfdRetencion) {
        this.idCfdRetencion = idCfdRetencion;
    }
    public CfdsRetenciones getCfdsRetenciones() {
        return this.cfdsRetenciones;
    }
    
    public void setCfdsRetenciones(CfdsRetenciones cfdsRetenciones) {
        this.cfdsRetenciones = cfdsRetenciones;
    }
    public String getXmlTralix() {
        return this.xmlTralix;
    }
    
    public void setXmlTralix(String xmlTralix) {
        this.xmlTralix = xmlTralix;
    }
    public String getXmlSat() {
        return this.xmlSat;
    }
    
    public void setXmlSat(String xmlSat) {
        this.xmlSat = xmlSat;
    }




}


