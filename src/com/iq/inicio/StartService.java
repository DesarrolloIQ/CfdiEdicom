/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iq.inicio;

import com.iq.conf.ConfiguracionInit;
import com.iq.procesadores.ProcesarEmitidosSinCfd;
import com.iq.utils.Constantes;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;

/**
 *
 * @author rudymrgz
 */
public class StartService implements Runnable {

    private static final Logger LOGGER = Logger.getLogger(StartService.class);

    public static final ConfiguracionInit configInit = new ConfiguracionInit();
    private final ScheduledExecutorService executorService;
    private boolean running;

    public static void main(String[] args) {

        LOGGER.info("Inicializando el servicio CfdiEdicom........");

        if (configInit.getInitConfig()) {

            new StartService().start();

        } else {
            LOGGER.error("No fue posible recuperar la configuración. Asegúrese de que el archivo de configuración sea válido.");
        }

    }

    @Override
    public void run() {
        ProcesarEmitidosSinCfd procesoPrincipal = new ProcesarEmitidosSinCfd();
        Thread.currentThread().setName("cfdiEdicomService-Thread");
        try {
            procesoPrincipal.procesador(configInit);
            LOGGER.info("Esperando " + Constantes.SLEEP_TIME_SECONDS + " segundos para revisar documdentos sin integrar..");
        } catch (Exception ex) {
            LOGGER.error("Error al procesar cfdi: " + ex);
        }
    }

    public StartService() {
        this.executorService = Executors.newSingleThreadScheduledExecutor();
        this.running = false;
    }

    public void start() {
        if (!running) {
            executorService.scheduleAtFixedRate(this, Constantes.DELAY_TIME_SECONDS, Constantes.SLEEP_TIME_SECONDS, TimeUnit.SECONDS);
            running = true;
        }
    }

    public void stop() {
        if (running) {
            executorService.shutdown();
            running = false;
        }
    }
}
