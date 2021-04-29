package com.example.demo2;

import com.example.entities.Post;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

@WebServlet(name = "helloServlet", value = "/hello")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        // APPEL à l'API REST
        final String path = "https://jsonplaceholder.typicode.com/posts/1";

        ResteasyClient client = new ResteasyClientBuilder().build();
        ResteasyWebTarget target = client.target(UriBuilder.fromPath(path));

        Response res = target.request().get();
        Post value = res.readEntity(Post.class);

        // POST
        Response resPost = target.request().post(Entity.entity(value, "application/json"));
        System.out.println(value);
        res.close();
        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + value.getTitle() + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}