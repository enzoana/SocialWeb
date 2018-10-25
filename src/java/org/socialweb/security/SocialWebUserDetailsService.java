package org.socialweb.security;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.socialweb.model.Usuario;
import org.socialweb.utils.NewHibernateUtil;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author enzo
 */
public class SocialWebUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Usuario usuario = findUserByUsername(username);

        UserBuilder builder = null;
        if (usuario != null) {
            builder = org.springframework.security.core.userdetails.User.withUsername(username);
            builder.password(new BCryptPasswordEncoder().encode(usuario.getPasswordLogin()));
            builder.roles(usuario.getRoles());
        } else {
            throw new UsernameNotFoundException("Usuario no encontrado.");
        }

        return builder.build();

    }

    private Usuario findUserByUsername(String username) {

        SessionFactory sessionFactory = NewHibernateUtil.getSessionFactory();
        Session session = null;
        Usuario usuario = null;

        try {

            session = sessionFactory.openSession();

            boolean loginConEmail = username.contains("@");

            if (! loginConEmail) {
                Query query = (Query) session.getNamedQuery("Usuario.findByUsuarioLogin");
                query.setParameter("usuarioLogin", username);
                if ((query.list() != null) && (! query.list().isEmpty())) {
                    usuario = (Usuario) query.list().get(0);
                }
            } else {
                Query query = (Query) session.getNamedQuery("Usuario.findByCorreoElectronicoLogin");
                query.setParameter("correoElectronicoLogin", username);
                if ((query.list() != null) && (! query.list().isEmpty())) {
                    usuario = (Usuario) query.list().get(0);
                }
            }

            session.close();

        } catch(HibernateException ex) {
            System.out.println("org.socialweb.controller.AutenticarUsuario.autenticarUsuario()");
            System.out.println(ex.getMessage());
        }

       return usuario;
    }
}