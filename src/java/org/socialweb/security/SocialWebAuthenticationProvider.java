package org.socialweb.security;

import org.jasypt.util.password.BasicPasswordEncryptor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author enzo
 */
public class SocialWebAuthenticationProvider implements AuthenticationProvider {

    private SocialWebUserDetailsService socialWebUserDetailsService;
 
    public void setUserDetailsService(SocialWebUserDetailsService socialWebUserDetailsService) {
 
        this.socialWebUserDetailsService = socialWebUserDetailsService;
    }
 
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
 
        UserDetails userDetails = this.socialWebUserDetailsService.loadUserByUsername(authentication.getName());
        if ((userDetails != null)
                && (new BasicPasswordEncryptor().checkPassword(authentication.getCredentials().toString(), userDetails.getPassword()))) {
            return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        }
 
        throw new BadCredentialsException("Error en las credenciales.");
    }

    @Override
    public boolean supports(java.lang.Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}