package org.socialweb.security;

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

        /*Here we are using dummy data, you need to load user data from
        database or other third party application*/
/*
        Emprendedor user = findUserbyUsername(username);

        UserBuilder builder = null;
        if (user != null) {
            builder = org.springframework.security.core.userdetails.User.withUsername(username);
            builder.password(new BCryptPasswordEncoder().encode(user.getPassword()));
            builder.roles(user.getRoles());
        } else {
            throw new UsernameNotFoundException("User not found.");
        }

        return builder.build();
*/
return null;
    }
/*
    private Emprendedor findUserbyUsername(String username) {

        if(username.equalsIgnoreCase("admin")) {
            return new Emprendedor();
        }

        return null;
    }
*/
}