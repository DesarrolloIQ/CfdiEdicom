/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iq.procesadores;

import com.edicom.ediwinws.service.ediwinintegration.EdiwinIntegrationException_Exception;
import com.edicom.ediwinws.service.ediwinintegration.OperationParam;
import com.iq.conf.ConfiguracionInit;
import com.iq.daos.descarga.MetadatosSinCfdiEmitidoDao;
import com.iq.daos.xsa.UsuariosRecepcionDao;
import com.iq.pojos.descarga.MetadatosSinCfdiEmitido;
import com.iq.utils.Constantes;
import com.iq.utils.EdicomParams;
import com.iq.utils.FileUtils;
import com.iq.utils.LogIQ;
import com.iq.utils.WebServicesEdicom;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @author rudymrgz
 */
public class ProcesarEmitidosSinCfd {

    private static final Logger LOGGER = Logger.getLogger(ProcesarEmitidosSinCfd.class);

    private String logId;
    private ConfiguracionInit configInit;

    public void procesador(ConfiguracionInit configInit) throws EdiwinIntegrationException_Exception, IOException {
        this.logId = LogIQ.generateLogId();
        this.configInit = configInit;
        LOGGER.info(logId + " :BUSCANDO...");
        buscarMetadatosSinCfd();

    }

    public void buscarMetadatosSinCfd() throws EdiwinIntegrationException_Exception, IOException {
        MetadatosSinCfdiEmitidoDao cfdiEmitidoDao = new MetadatosSinCfdiEmitidoDao();
        List<MetadatosSinCfdiEmitido> cfdiEmitidos = cfdiEmitidoDao.getEmitidosSinCfd(Constantes.CANTIDAD_CFDS, Constantes.RFC_PAC, Constantes.EstadoMD.NUEVO.name());

        if (!cfdiEmitidos.isEmpty()) {
            setWsParams(cfdiEmitidos);
        } else {
            LOGGER.info("No se encontraron metadatos sin CFDI emitido.");
        }
    }

    public void setWsParamss(List<MetadatosSinCfdiEmitido> cfdiEmitidos) throws EdiwinIntegrationException_Exception {

        UsuariosRecepcionDao usuariosRecepcionDao = new UsuariosRecepcionDao();
        MetadatosSinCfdiEmitidoDao cfdiEmitidoDao = new MetadatosSinCfdiEmitidoDao();
        List<OperationParam> parameters;
        List<String> reportList = new ArrayList<>();
        reportList.add("");

        String nombreArchivo;

        WebServicesEdicom servicesEdicom = new WebServicesEdicom();

        FileUtils.validarYCrearRuta(configInit.getPathBase());

        for (MetadatosSinCfdiEmitido cfdiEmitido : cfdiEmitidos) {
            byte[] dataxml;
            byte[] datapdf;
            String pathDefinitivo;
            Integer idMetadato = cfdiEmitido.getIdMetadato();
            String estadoMd;
            String descError = " ";

            pathDefinitivo = configInit.getPathBase() + usuariosRecepcionDao.buscarUsuariosPorNombreAndTipo("TIMBRADO", cfdiEmitido.getEfectoComprobante()).getHomeftp() + "/";
            FileUtils.crearArbolDirectorios(pathDefinitivo);

            parameters = new ArrayList<>();
            LOGGER.info("id: " + cfdiEmitido.getIdMetadato() + " UUID: " + cfdiEmitido.getUuid());
            cfdiEmitidoDao.updateEstadoMdMetadatosSinCfdiEmitido(cfdiEmitido.getIdMetadato(), Constantes.EstadoMD.OBTENIENDO_ARCHIVOS.name());
            OperationParam operationParam = new OperationParam();
            operationParam.setName(Constantes.CFDI_UUID);
            operationParam.setValue(cfdiEmitido.getUuid());
            operationParam.setOperator("=");
            parameters.add(operationParam);

            nombreArchivo = Constantes.PREFIX_XML + cfdiEmitido.getUuid();
            dataxml = servicesEdicom.getDocument(new EdicomParams(configInit.getUserWs(), configInit.getPassWs(),
                    configInit.getDomainWs(), configInit.getGroupWs(), Constantes.XML_EXPORT,
                    configInit.getIdVolume(), parameters, reportList), idMetadato, "XML");

            FileUtils.escribirArchivo(dataxml, pathDefinitivo, nombreArchivo + Constantes.EXT_ZIP, idMetadato);

            nombreArchivo = Constantes.PREFIX_PDF + cfdiEmitido.getUuid();
            datapdf = servicesEdicom.getDocument(new EdicomParams(configInit.getUserWs(), configInit.getPassWs(),
                    configInit.getDomainWs(), configInit.getGroupWs(), Constantes.PDF_EXPORT,
                    configInit.getIdVolume(), parameters, reportList), idMetadato, "PDF");

            FileUtils.escribirArchivo(datapdf, pathDefinitivo, nombreArchivo + Constantes.EXT_ZIP, idMetadato);

            estadoMd = cfdiEmitidoDao.getMetadatoById(idMetadato).getEstadoMd();

            if (estadoMd.contains(Constantes.EstadoMD.ERROR.name())) {

            } else {
                cfdiEmitidoDao.updateEstadoMdMetadatosSinCfdiEmitido(cfdiEmitido.getIdMetadato(), Constantes.EstadoMD.PROCESADO.name());
            }

        }

    }

    public void setWsParams(List<MetadatosSinCfdiEmitido> cfdiEmitidos) throws IOException {
        UsuariosRecepcionDao usuariosRecepcionDao = new UsuariosRecepcionDao();
        MetadatosSinCfdiEmitidoDao cfdiEmitidoDao = new MetadatosSinCfdiEmitidoDao();
        List<String> reportList = new ArrayList<>();
        reportList.add("");

        String pathBase = configInit.getPathBase();
        FileUtils.validarYCrearRuta(pathBase);

        WebServicesEdicom servicesEdicom = new WebServicesEdicom();

        for (MetadatosSinCfdiEmitido cfdiEmitido : cfdiEmitidos) {
            Integer idMetadato = cfdiEmitido.getIdMetadato();
            String uuid = cfdiEmitido.getUuid();
            String tipoComprobante = cfdiEmitido.getEfectoComprobante();

            LOGGER.info("id: " + idMetadato + " UUID: " + uuid);
            cfdiEmitidoDao.updateEstadoMdMetadatosSinCfdiEmitido(idMetadato, Constantes.EstadoMD.OBTENIENDO_ARCHIVOS.name());

            String homeFtp = usuariosRecepcionDao.buscarUsuariosPorNombreAndTipo("TIMBRADO", tipoComprobante).getHomeftp();
            String pathDefinitivo = pathBase + homeFtp + "/";
            FileUtils.crearArbolDirectorios(pathDefinitivo);
            LOGGER.info("Escribiendo archivos: " + pathDefinitivo);

            //Se Obtiene el PDF
            LOGGER.info("WS Obteniendo: " + Constantes.PREFIX_PDF);
            byte[] datapdf = getDocumento(servicesEdicom, idMetadato, uuid, Constantes.PDF_EXPORT);
            String nombreArchivoPdf = uuid + Constantes.EXT_PDF;
            LOGGER.info("Descomprimiento y extrayendo : " + Constantes.PREFIX_PDF);
            FileUtils.unzip(datapdf, pathDefinitivo, nombreArchivoPdf);

            //Se Obtiene el XML
            LOGGER.info("WS Obteniendo: " + Constantes.PREFIX_XML);
            byte[] dataxml = getDocumento(servicesEdicom, idMetadato, uuid, Constantes.XML_EXPORT);
            String nombreArchivoXml = uuid + Constantes.EXT_XML;
            LOGGER.info("Descomprimiento y extrayendo : " + Constantes.PREFIX_XML);
            FileUtils.unzip(dataxml, pathDefinitivo, nombreArchivoXml);

            String estadoMd = cfdiEmitidoDao.getMetadatoById(idMetadato).getEstadoMd();
            if (!estadoMd.contains(Constantes.EstadoMD.ERROR.name())) {
                cfdiEmitidoDao.updateEstadoMdMetadatosSinCfdiEmitido(idMetadato, Constantes.EstadoMD.PROCESADO.name());
            }
        }
    }

    private byte[] getDocumento(WebServicesEdicom servicesEdicom, Integer idMetadato, String uuid, int exportType) {
        EdicomParams edicomParams = new EdicomParams(configInit.getUserWs(), configInit.getPassWs(),
                configInit.getDomainWs(), configInit.getGroupWs(), exportType, configInit.getIdVolume(),
                crearParametros(uuid), crearReportList());
        return servicesEdicom.getDocument(edicomParams, idMetadato, exportType == Constantes.XML_EXPORT ? "XML" : "PDF");
    }

    private List<OperationParam> crearParametros(String uuid) {
        List<OperationParam> parameters = new ArrayList<>();
        OperationParam operationParam = new OperationParam();
        operationParam.setName(Constantes.CFDI_UUID);
        operationParam.setValue(uuid);
        operationParam.setOperator("=");
        parameters.add(operationParam);
        return parameters;
    }

    private List<String> crearReportList() {
        return Collections.singletonList("");
    }

}
