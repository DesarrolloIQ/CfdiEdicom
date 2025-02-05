package com.iq.conexiones;

import com.iq.daos.xsa.EmpresasXsaDao;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author rudymrgz
 */
public class HibernateUtilXSA {

    private static final SessionFactory sessionFactory;    
    private static final Logger logger = Logger.getLogger(HibernateUtilXSA.class);
    

    static {
        
        try {          
            sessionFactory = new Configuration().configure("com/iq/hibernate/conf/hibernateXsa.cfg.xml").buildSessionFactory();
        } catch (Throwable ex) {
            // Log the exception. 
            logger.error("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
