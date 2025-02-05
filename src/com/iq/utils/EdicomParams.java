package com.iq.utils;

import com.edicom.ediwinws.service.ediwinintegration.OperationParam;
import java.util.List;

/**
 * Clase para encapsular los parámetros necesarios para interactuar con los
 * servicios web de Edicom.
 */
public class EdicomParams {

    private String user;
    private String password;
    private String domain;
    private String group;    
    private int exportType;
    private int idVolume;
    private List<OperationParam> parameters;
    private List<String> reportList;

    // Constructor
    public EdicomParams(String user, String password, String domain, String group, int exportType, int idVolume,
            List<OperationParam> parameters, List<String> reportList) {
        this.user = user;
        this.password = password;
        this.domain = domain;
        this.group = group;
        this.exportType = exportType;
        this.idVolume = idVolume;
        this.parameters = parameters;
        this.reportList = reportList;
    }

    // Getters y setters
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

          
    public int getExportType() {
        return exportType;
    }

    public void setExportType(int exportType) {
        this.exportType = exportType;
    }

    public int getIdVolume() {
        return idVolume;
    }

    public void setIdVolume(int idVolume) {
        this.idVolume = idVolume;
    }

    public List<OperationParam> getParameters() {
        return parameters;
    }

    public void setParameters(List<OperationParam> parameters) {
        this.parameters = parameters;
    }

    public List<String> getReportList() {
        return reportList;
    }

    public void setReportList(List<String> reportList) {
        this.reportList = reportList;
    }
}
