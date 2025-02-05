/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iq.utils;

import com.edicom.ediwinws.service.ediwinintegration.EdiwinIntegration;
import com.edicom.ediwinws.service.ediwinintegration.EdiwinIntegrationException_Exception;
import com.edicom.ediwinws.service.ediwinintegration.EdiwinIntegrationService;
import com.edicom.ediwinws.service.ediwinintegration.OperationParam;
import com.iq.daos.descarga.MetadatosSinCfdiEmitidoDao;
import com.iq.daos.xsa.EmpresasXsaDao;
import com.iq.pojos.descarga.MetadatosSinCfdiEmitido;
import com.iq.pojos.xsa.Empresas;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rudymrgz
 */
public class Tests {

    public static void main(String[] args) throws EdiwinIntegrationException_Exception {

        String rutaNombreArchivo = "../logs/salida/6F97146A-040E-11EF-8C5D-ED74AB6C8FBA.zip";

        //Empresas empresa = new Tests().getEmpresa(481726);

        //System.out.println("Empresas:" + empresa.getRfc());

        //MetadatosSinCfdiEmitido cfdiEmitido = new Tests().getMetadatosSinCfdiEmitidoByUuuid("6F97146A-040E-11EF-8C5D-ED74AB6C8FBA");

        //System.out.println("MetadatosSinCfdiEmitido:" + cfdiEmitido.getRfcPac());

        String user = "MME9909016F0";
        String password = "Ema040508";
        String domain = "MME9909016F0";
        String group = "ASPEDI51";
        int exportType = 4;
        int idVolume = 0;

        OperationParam operationParam = new OperationParam();
        operationParam.setName("CFDI_UUID");
        operationParam.setValue("6F97146A-040E-11EF-8C5D-ED74AB6C8FBA");
        operationParam.setOperator("=");

        List<OperationParam> parameters = new ArrayList<>();
        parameters.add(operationParam);

        List<String> reportList = new ArrayList<>();
        reportList.add("");
        
        //
        OperationParam operationParamDos = new OperationParam();
        operationParamDos.setName("CFDI_UUID");
        operationParamDos.setValue("EA4F29E2-0353-11EF-BE33-1FF4DF0454F8");
        operationParamDos.setOperator("=");
        parameters.add(operationParamDos);
        

    }


 
}
