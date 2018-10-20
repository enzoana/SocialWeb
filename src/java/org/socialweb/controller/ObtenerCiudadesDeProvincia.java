package org.socialweb.controller;

import java.util.HashSet;
import java.util.Set;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.socialweb.model.Ciudad;
import org.socialweb.model.Provincia;
import org.socialweb.utils.NewHibernateUtil;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author enzo
 */
@RestController
public class ObtenerCiudadesDeProvincia {

    @RequestMapping(value = "/obtenerCiudadesDeProvincia.do",
            method = RequestMethod.GET)
    public Set<Ciudad> obtenerCiudadesDeProvincia(@RequestParam("provincia") int codigoProvincia) {

        SessionFactory sessionFactory = NewHibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Provincia provincia = (Provincia) session.get(Provincia.class, codigoProvincia);

        if (provincia != null) {
            return provincia.getCiudades();
        } else {
            return new HashSet<Ciudad>();
        }
    }
}