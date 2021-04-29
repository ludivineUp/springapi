package com.example;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebFilter(servletNames = {"HelloServlet"})
// bloque ou non un href, un lien => c'est une conditon pour accéder à une page
public class FakeFilter implements Filter {
    public void init(FilterConfig config) throws ServletException{
        System.out.println("on cree le filtre");
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        // on vérifie la condition du filtre : authentification, quelque chose qui doit être en session
        System.out.println("ON FILTRE");
        // condition est ok donc on renvoie vers le lien demandé
        chain.doFilter(request, response);
    }
}
