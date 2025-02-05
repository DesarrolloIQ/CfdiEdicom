/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iq.daos.descarga;

import com.iq.conexiones.HibernateUtilDescarga;
import com.iq.pojos.descarga.MetadatosSinCfdiEmitido;
import java.util.List;
import org.apache.log4j.Logger;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author rudymrgz
 */
public class MetadatosSinCfdiEmitidoDao {

    private Transaction tx;
    private Session session;

    private static final Logger LOGGER = Logger.getLogger(MetadatosSinCfdiEmitidoDao.class);

    public List<MetadatosSinCfdiEmitido> getEmitidosSinCfd(int cantidad, String rfcPac, String estadoMd) {
        List<MetadatosSinCfdiEmitido> result = null;
        String hql = "select m from MetadatosSinCfdiEmitido as m where m.rfcPac=:rfcPac and m.estadoMd=:estadoMd";
        try {
            iniciarOperacion();
            Query q = session.createQuery(hql);
            q.setParameter("rfcPac", rfcPac);
            q.setParameter("estadoMd", estadoMd);
            q.setFirstResult(0);
            q.setMaxResults(cantidad);
            result = q.list();
            tx.commit();
        } catch (HibernateException e) {
            tx.rollback();
            LOGGER.error(hql);
            LOGGER.error(e.getMessage());
        } finally {
            cerrarSession();
        }
        return result;
    }



    public MetadatosSinCfdiEmitido getMetadatoById(Integer idMetadato) {
        MetadatosSinCfdiEmitido sucursal = null;
        String hql = "select m from MetadatosSinCfdiEmitido as m where m.idMetadato=:idMetadato";

        try {
            iniciarOperacion();
            Query q = session.createQuery(hql);
            q.setParameter("idMetadato", idMetadato);
            List<MetadatosSinCfdiEmitido> result = q.list();
            if (result != null && !result.isEmpty()) {
                sucursal = result.get(0);
            }
            tx.commit();
        } catch (HibernateException e) {
            tx.rollback();
            LOGGER.error(hql);
            LOGGER.error(e.getMessage());
        } finally {
            cerrarSession();
        }

        return sucursal;
    }

    public boolean updateEstadoMdMetadatosSinCfdiEmitido(Integer idMetadato, String estadoMd) {
        boolean result = false;
        String hql = "update MetadatosSinCfdiEmitido set  estadoMd = :estadoMd where idMetadato = :idMetadato";
        try {
            iniciarOperacion();
            Query query = session.createQuery(hql);
            query.setParameter("idMetadato", idMetadato);
            query.setParameter("estadoMd", estadoMd);
            int updatedCount = query.executeUpdate();
            tx.commit();
            if (updatedCount == 1) {
                result = true;
            } else if (updatedCount > 1) {
                result = true;
                LOGGER.warn("Se actualizó más de un Metadato para el idMetadato: " + idMetadato);
            } else {
                LOGGER.error("No se actualizó ningún Metadato para el idMetadato: " + idMetadato);
            }
        } catch (HibernateException e) {
            result = false;
            LOGGER.error(e.getMessage());
            tx.rollback();
        } finally {
            cerrarSession();
        }
        return result;
    }

    public boolean updateEstadoMdDescripcionMetadatosSinCfdiEmitido(Integer idMetadato, String estadoMd, String descripcionError) {
        boolean result = false;
        String hql = "update MetadatosSinCfdiEmitido set  estadoMd = :estadoMd, descripcionError=:descripcionError where idMetadato = :idMetadato";
        try {
            iniciarOperacion();
            Query query = session.createQuery(hql);
            query.setParameter("idMetadato", idMetadato);
            query.setParameter("estadoMd", estadoMd);
            query.setParameter("descripcionError", descripcionError);
            int updatedCount = query.executeUpdate();
            tx.commit();
            if (updatedCount == 1) {
                result = true;
            } else if (updatedCount > 1) {
                result = true;
                LOGGER.warn("Se actualizó más de un Metadato para el idMetadato: " + idMetadato);
            } else {
                LOGGER.error("No se actualizó ningún Metadato para el idMetadato: " + idMetadato);
            }
        } catch (HibernateException e) {
            result = false;
            LOGGER.error(e.getMessage());
            tx.rollback();
        } finally {
            cerrarSession();
        }
        return result;
    }

    private void cerrarSession() {
        if (session != null && session.isOpen()) {
            session.close();
        }
    }

    private void iniciarOperacion() throws HibernateException {
        session = HibernateUtilDescarga.getSessionFactory().openSession();
        tx = session.beginTransaction();
    }

}
