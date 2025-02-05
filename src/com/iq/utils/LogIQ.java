/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iq.utils;

import java.util.Arrays;
import java.util.UUID;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 *
 * @author rudymrgz
 */
public class LogIQ {

    private static final Logger LOG = LogManager.getLogger(LogIQ.class);
    private static final String LOGID = " |LOGID: ";
    private static final String SERVICE = " |SERVICIO: ";
    private static final String RUNTIME = " |TIEMPO DE EJECUCION:: ";
    private static final String MILISECONDS = " MILISEGUNDOS #]";
    private static final String STRING = " |";

    public enum Level {

        TRACE,
        DEBUG,
        INFO,
        WARN,
        ERROR,
        FATAL;
    }

    public static void logException(String serviceName, String logId, Level level, String observations,
            Exception object) {
        String errorRute;
        if (object instanceof NullPointerException) {
            errorRute = Arrays.asList(((NullPointerException) object).getStackTrace()).stream()
                    .map(ste -> " at " + ste.toString()).reduce(String::concat).orElse("StackTrace vacío");
            errorRute = observations + " " + object.toString() + errorRute;
        } else {
            errorRute = observations + " " + object.toString();
        }

        logString(serviceName, logId, level, errorRute);
    }

    public static void logString(String serviceName, String logId, Level level, String s) {

        StringBuilder sb = new StringBuilder();
        sb.append(LOGID);
        sb.append(logId);
        sb.append(SERVICE);
        sb.append(serviceName);
        sb.append(STRING);
        sb.append(s.replace("\n", ""));
        sb.append(RUNTIME);
        sb.append(System.currentTimeMillis());
        sb.append(MILISECONDS);

        String msg = sb.toString();

        log(logId, level, msg);

    }

    private static void log(String logId, Level level, String msg) {
        switch (level) {
            case TRACE:
                LOG.trace(msg);
                break;
            case DEBUG:
                LOG.debug(msg);
                break;
            case INFO:
                LOG.info(msg);
                break;
            case WARN:
                LOG.warn(msg);
                break;
            case ERROR:
                LOG.error(msg);
                break;
            case FATAL:
                LOG.fatal(msg);
                break;
            default:
                logString(LogIQ.class.toString(), logId, Level.ERROR,
                        "OPCION DE NIVEL DE LOG: " + level + " NO VALIDA");
                break;
        }
    }
    
    public static String generateLogId() {
        return UUID.randomUUID().toString();
    }
}
