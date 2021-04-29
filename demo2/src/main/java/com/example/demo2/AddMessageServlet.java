package com.example.demo2;

import com.example.entities.Message;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "addMessageServlet", value = "/save-msg")
public class AddMessageServlet extends HttpServlet {



    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect(request.getContextPath()+"/add-msg.jsp");
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String msg = request.getParameter("msg");
        int repaet = Integer.parseInt(request.getParameter("repeat"));
        Message m = new Message(msg, repaet);
        request.getSession().setAttribute("msg", m);
        response.sendRedirect(request.getContextPath()+"/message.jsp");

    }

}
