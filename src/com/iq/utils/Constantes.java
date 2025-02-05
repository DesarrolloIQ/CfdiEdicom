/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iq.utils;

/**
 *
 * @author rudymrgz
 */
public class Constantes {

    public static final int DELAY_TIME_SECONDS = 0;
    public static final int SLEEP_TIME_SECONDS = 10;

    public static  final int CANTIDAD_CFDS = 100;
    
    
    
    public static final String EXT_XML=".xml";
    public static final String EXT_PDF=".pdf";
    public static final String EXT_ZIP=".zip";
    public static final String PREFIX_XML="XML";
    public static final String PREFIX_PDF="PDF";
    
    
    public static final String CFDI_UUID="CFDI_UUID";
    public static final String EQUALS_OPERATOR="=";
    public static final String RFC_PAC="EME000602QR9";
    public static final int XML_EXPORT=2;
    public static final int PDF_EXPORT=4;
    
    
    
    public enum EstadoMD {

        NUEVO,
        OBTENIENDO_ARCHIVOS,
        PROCESADO,
        CARGADO_BD,
        ERROR,
        DUPLICADO;
    }

    
    
    
    

}
