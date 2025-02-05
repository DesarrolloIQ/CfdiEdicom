/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iq.utils;

import com.edicom.ediwinws.service.ediwinintegration.EdiwinIntegration;
import com.edicom.ediwinws.service.ediwinintegration.EdiwinIntegrationException_Exception;
import com.edicom.ediwinws.service.ediwinintegration.EdiwinIntegrationService;
import com.iq.daos.descarga.MetadatosSinCfdiEmitidoDao;
import com.iq.pojos.descarga.MetadatosSinCfdiEmitido;

import org.apache.log4j.Logger;

/**
 *
 * @author rudymrgz
 */
public class WebServicesEdicom {

    private static final Logger LOGGER = Logger.getLogger(WebServicesEdicom.class);

    /**
     * Obtiene un documento de Edicom.
     *
     * @param user Nombre de usuario.
     * @param password Contraseña.
     * @param domain Dominio.
     * @param group Grupo.
     * @param exportType Tipo de exportación.
     * @param idVolume ID del volumen.
     * @param parameters Lista de parámetros.
     * @param reportList Lista de reportes.
     * @return Arreglo de bytes que representa el documento.
     * @throws EdiwinIntegrationException_Exception Si ocurre un error al
     * obtener el documento.
     */
    public byte[] getDocuments(EdicomParams edicomParams, Integer idMetadato, String tipoArchivo) throws EdiwinIntegrationException_Exception {
        byte[] data = null;
        MetadatosSinCfdiEmitidoDao cfdiEmitidoDao = new MetadatosSinCfdiEmitidoDao();

        try {
            EdiwinIntegrationService ediwinIntegrationService = new EdiwinIntegrationService();
            EdiwinIntegration ediwinIntegration = ediwinIntegrationService.getEdiwinIntegration();
            data = ediwinIntegration.getDocument(edicomParams.getUser(), edicomParams.getPassword(),
                    edicomParams.getDomain(), edicomParams.getGroup(), edicomParams.getExportType(),
                    edicomParams.getIdVolume(), edicomParams.getParameters(), edicomParams.getReportList());
        } catch (EdiwinIntegrationException_Exception e) {
            String mjsError;
            String msjErrorBd = cfdiEmitidoDao.getMetadatoById(idMetadato).getDescripcionError() + " ";
            if (msjErrorBd != null) {
                mjsError = msjErrorBd + " WS Error al obtener el documento " + tipoArchivo + " de Edicom: " + e.getMessage();
            } else {
                mjsError = " WS Error al obtener el documento " + tipoArchivo + " de Edicom: " + e.getMessage();
            }

            LOGGER.error(mjsError, e);
            cfdiEmitidoDao.updateEstadoMdDescripcionMetadatosSinCfdiEmitido(idMetadato, Constantes.EstadoMD.ERROR.name(), mjsError);
        }
        return data;
    }

    public byte[] getDocument(EdicomParams edicomParams, Integer idMetadato, String tipoArchivo) {
        byte[] data = null;
        MetadatosSinCfdiEmitidoDao cfdiEmitidoDao = new MetadatosSinCfdiEmitidoDao();

        try {
            EdiwinIntegrationService ediwinIntegrationService = new EdiwinIntegrationService();
            EdiwinIntegration ediwinIntegration = ediwinIntegrationService.getEdiwinIntegration();
            data = ediwinIntegration.getDocument(edicomParams.getUser(), edicomParams.getPassword(),
                    edicomParams.getDomain(), edicomParams.getGroup(), edicomParams.getExportType(),
                    edicomParams.getIdVolume(), edicomParams.getParameters(), edicomParams.getReportList());
        } catch (EdiwinIntegrationException_Exception e) {
            String errorMessage = "WS Error al obtener el documento " + tipoArchivo + " de Edicom: " + e.getMessage();
            MetadatosSinCfdiEmitido metadato = cfdiEmitidoDao.getMetadatoById(idMetadato);
            String descripcionErrorBd = (metadato != null) ? metadato.getDescripcionError() + " " : "";
            String mensajeError = descripcionErrorBd + errorMessage;
            LOGGER.error(mensajeError, e);
            cfdiEmitidoDao.updateEstadoMdDescripcionMetadatosSinCfdiEmitido(idMetadato, Constantes.EstadoMD.ERROR.name(), mensajeError);
        }
        return data;
    }

}
