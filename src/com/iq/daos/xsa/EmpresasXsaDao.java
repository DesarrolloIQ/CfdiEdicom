/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iq.daos.xsa;


import com.iq.pojos.xsa.Empresas;
import com.iq.conexiones.HibernateUtilXSA;
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
public class EmpresasXsaDao {

    private Transaction tx;
    private Session session;
    
    private static final Logger logger = Logger.getLogger(EmpresasXsaDao.class);




    public List<Empresas> getEmpresas(int idArchivo) {
        List<Empresas> result = null;
        String hql = "select e from Empresas as e, DocumentosRecibidos as d "
                + "where d.idArchivo = :idArchivo and d.sucursales.empresas.idEmpresa = e.idEmpresa";
        try {
            iniciarOperacion();
            Query query = session.createQuery(hql);
            query.setParameter("idArchivo", idArchivo);
            result = query.list();
            tx.commit();
        } catch (HibernateException e) {
            tx.rollback();
            logger.error(e.getMessage());
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
        session = HibernateUtilXSA.getSessionFactory().openSession();
        tx = session.beginTransaction();
    }
}
