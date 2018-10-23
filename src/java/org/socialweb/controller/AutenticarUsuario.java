package org.socialweb.controller;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.socialweb.model.Usuario;
import org.socialweb.utils.NewHibernateUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author enzo
 */
@Controller
public class AutenticarUsuario {

    @RequestMapping(value = "/login.do",
            method = RequestMethod.GET)
    public String obtenerLogin() {
        return "logIn";
    }

    @RequestMapping(value = "/login.do",
            method = RequestMethod.POST)
    public boolean autenticarUsuario(
            @RequestParam("usuario_email") String usuarioEmail,
            @RequestParam("password") String password) {

System.out.println("Autenticando usuario: " + usuarioEmail + " - password: " + password);

        SessionFactory sessionFactory = NewHibernateUtil.getSessionFactory();
        Session session = null;
        Usuario usuario = null;

        try {

            session = sessionFactory.openSession();

            Boolean loginConEmail = usuarioEmail.contains("@");

            if (! loginConEmail) {
                Query query = (Query) session.getNamedQuery("Usuario.findByUsuarioLoginCheckLogin");
                query.setParameter("usuarioLogin", usuarioEmail);
                query.setParameter("passwordLogin", password);
                if ((query.list() != null) && (query.list().isEmpty())) {
                    usuario = (Usuario) query.list().get(0);
                }
            } else {
                Query query = (Query) session.getNamedQuery("Usuario.findByCorreoElectronicoLoginCheckLogin");
                query.setParameter("usuarioLogin", usuarioEmail);
                query.setParameter("passwordLogin", password);
                if ((query.list() != null) && (query.list().isEmpty())) {
                    usuario = (Usuario) query.list().get(0);
                }
            }

            session.close();

        } catch(HibernateException ex) {
            System.out.println("org.socialweb.controller.AutenticarUsuario.autenticarUsuario()");
            System.out.println(ex.getMessage());
        }

        if (usuario != null) {
System.out.println("PASO TODO OK - " + usuario.toString());
            return true;
        } else {
System.out.println("PASO TODO OK - usuario no encontrado");
            return false;
        }
    }
}