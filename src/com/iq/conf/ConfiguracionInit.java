package com.iq.conf;

import org.apache.log4j.Logger;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author rudymrgz
 */
public class ConfiguracionInit {

    private static final Logger LOGGER = Logger.getLogger(ConfiguracionInit.class);
    private static final String FILE_SEPARATOR = "file.separator";
    private static final String RUTA = ".." + System.getProperty(FILE_SEPARATOR) + "conf"
            + System.getProperty(FILE_SEPARATOR) + "confCfdiEdicom"
            + System.getProperty(FILE_SEPARATOR) + "config.properties";

    private String userWs;
    private String passWs;
    private String domainWs;
    private String groupWs;
    private Integer exportTypeWs;
    private Integer idVolume;
    private String operatorWs;
    private Boolean existeConfig;
    private String pathBase;

    public boolean getInitConfig() {
        try (FileInputStream fis = new FileInputStream(RUTA)) {
            Properties properties = new Properties();
            properties.load(fis);

            userWs = properties.getProperty("USER_WS").trim();
            passWs = properties.getProperty("PASS_WS").trim();
            domainWs = properties.getProperty("DOMAIN_WS").trim();
            groupWs = properties.getProperty("GROUP_WS").trim();
            exportTypeWs = getIntProperty(properties, "EXPORT_TYPE_WS", 2);
            idVolume = getIntProperty(properties, "ID_VOLUME_WS", 0);
            operatorWs = properties.getProperty("OPERATOR_WS").trim();
            pathBase = properties.getProperty("PATH_BASE").trim();

            LOGGER.debug("La configuración se obtuvo correctamente");
            LOGGER.info("------------------------------------------------------");
            LOGGER.info("RUTA: " + RUTA);
            LOGGER.info("userWs: " + userWs);
            LOGGER.info("passWs: " + passWs);
            LOGGER.info("domainWs: " + domainWs);
            LOGGER.info("groupWs: " + groupWs);
            LOGGER.info("exportTypeWs: " + exportTypeWs);
            LOGGER.info("idVolume: " + idVolume);
            LOGGER.info("operatorWs: " + operatorWs);
            LOGGER.info("pathBase: " + pathBase);
            LOGGER.info("------------------------------------------------------");

            existeConfig = true;

        } catch (IOException e) {
            LOGGER.error("Error al leer el archivo de configuración: " + e.getMessage());
        } catch (Exception e) {
            LOGGER.error("Error inesperado al procesar el archivo de configuración: " + e.getMessage());
            existeConfig = false;
            return false;
        }

        return userWs != null && passWs != null && domainWs != null && groupWs != null && exportTypeWs != null && idVolume != null && operatorWs != null;
    }

    private int getIntProperty(Properties properties, String propertyName, int defaultValue) {
        String propertyValue = properties.getProperty(propertyName).trim();
        
        if (propertyValue != null) {
            try {
                return Integer.parseInt(propertyValue);
            } catch (NumberFormatException e) {
                LOGGER.error("Error al analizar el valor numérico en la propiedad " + propertyName + ". Usando valor predeterminado (" + defaultValue + ").");
            }
        }
        return defaultValue;
    }

   

    public static String getRUTA() {
        return RUTA;
    }

    public String getUserWs() {
        return userWs;
    }

    public String getPassWs() {
        return passWs;
    }

    public String getDomainWs() {
        return domainWs;
    }

    public String getGroupWs() {
        return groupWs;
    }

    public Integer getExportTypeWs() {
        return exportTypeWs;
    }

    public Integer getIdVolume() {
        return idVolume;
    }

    public String getOperatorWs() {
        return operatorWs;
    }
          
    public Boolean getExisteConfig() {
        return existeConfig;
    }

    public String getPathBase() {
        return pathBase;
    }
    
    

}
