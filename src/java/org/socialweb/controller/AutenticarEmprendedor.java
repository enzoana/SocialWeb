package org.socialweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author enzo
 */
@Controller
public class AutenticarEmprendedor {

    @RequestMapping(value = "/login.do",
            method = RequestMethod.GET)
    public String obtenerLogin() {
        return "logIn";
    }

    @RequestMapping(value = "/login.do",
            method = RequestMethod.POST)
    public String autenticarEmprendedor(
            @RequestParam("email") String email,
            @RequestParam("password") String password) {

System.out.println("Se loguea usuario: " + email + " - password: " + password);
        return "logIn";
    }
}