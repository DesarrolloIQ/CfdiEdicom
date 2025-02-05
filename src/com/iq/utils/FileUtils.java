/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iq.utils;

import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import org.apache.log4j.Logger;

/**
 *
 * @author rudymrgz
 */
public class FileUtils {

    private static final Logger LOGGER = Logger.getLogger(FileUtils.class);

    public static void escribirArchivo(byte[] data, String ruta, String nombre, Integer idMetadato) {
        LOGGER.info("nombreArchivo: " + ruta + nombre);
        try (FileOutputStream fos = new FileOutputStream(ruta + nombre)) {
            fos.write(data); // Escribir los datos en el archivo
            LOGGER.info("Los datos se han escrito en el archivo correctamente.");
        } catch (IOException e) {
            LOGGER.error("Error al escribir en el archivo: " + e.getMessage());
        }
    }

    public static boolean validarYCrearRuta(String ruta) {
        File directorio = new File(ruta);
        if (!directorio.exists()) {
            if (directorio.mkdirs()) {
                return true;
            } else {
                LOGGER.warn("No se pudo crear el directorio.");
                return false;
            }
        } else {
            LOGGER.debug("La ruta ya existe.");
            return true;
        }
    }

    public static void crearArbolDirectorios(String rutaDirectorio) {
        File directorio = new File(rutaDirectorio);

        // Verificar si el directorio ya existe
        if (!directorio.exists()) {
            // Intentar crear el directorio y sus padres si no existen
            if (directorio.mkdirs()) {
                LOGGER.info("Se ha creado el árbol de directorios en: " + rutaDirectorio);
            } else {
                LOGGER.info("No se pudo crear el árbol de directorios en: " + rutaDirectorio);
            }
        } else {
            LOGGER.debug("El directorio ya existe en: " + rutaDirectorio);
        }
    }

    public static void unzip(byte[] zipFileData, String destDir, String desiredFileName) throws IOException {
        File dir = new File(destDir);
        // Si el directorio de destino no existe, créalo
        if (!dir.exists()) {
            dir.mkdirs();
        }

        try (ZipInputStream zipIn = new ZipInputStream(new ByteArrayInputStream(zipFileData))) {
            ZipEntry entry = zipIn.getNextEntry();
            // Itera sobre todas las entradas en el archivo ZIP
            while (entry != null) {
                String filePath = destDir + File.separator + desiredFileName;
                if (!entry.isDirectory()) {
                    // Si la entrada es un archivo, extrae su contenido
                    extractFile(zipIn, filePath);
                } else {
                    // Si la entrada es un directorio, asegúrate de que exista en el directorio de destino
                    File dirToCreate = new File(filePath);
                    dirToCreate.mkdirs();
                }
                zipIn.closeEntry();
                entry = zipIn.getNextEntry();
            }
        }
    }

    private static void extractFile(ZipInputStream zipIn, String filePath) throws IOException {
        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath))) {
            byte[] bytesIn = new byte[4096];
            int read;
            while ((read = zipIn.read(bytesIn)) != -1) {
                bos.write(bytesIn, 0, read);
            }
        }
    }

}
