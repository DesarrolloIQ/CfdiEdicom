/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iq.daos.xsa;


import com.iq.conexiones.HibernateUtilXSA;
import com.iq.pojos.xsa.UsuariosRecepcion;
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
public class UsuariosRecepcionDao {

    private Transaction tx;
    private Session session;

    private static final Logger LOGGER = Logger.getLogger(UsuariosRecepcionDao.class);

   public UsuariosRecepcion buscarUsuariosPorNombreAndTipo(String nombre, String tipoCfd) {
        UsuariosRecepcion usuariosRecepcion = null;
        String hql = "from UsuariosRecepcion as s where s.nombre like :nombre and s.tiposCfd.tipo=:tipoCfd";

        try {
            iniciarOperacion();
            Query q = session.createQuery(hql);     
            q.setParameter("nombre", "%" + nombre + "%");
            q.setParameter("tipoCfd", tipoCfd);
            List<UsuariosRecepcion> result = q.list();

            if (result != null && !result.isEmpty()) {
                usuariosRecepcion = result.get(0);
            }else{
                LOGGER.error("NO HAY RUTAS INSERTADAS EN LA TABLA USUARIOS_RECEPCION");
                
            }
            tx.commit();
        } catch (HibernateException e) {
            tx.rollback();
            LOGGER.error(hql);
            LOGGER.error(e.getMessage());
        } finally {
            cerrarSession();
        }
        

        return usuariosRecepcion;
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
