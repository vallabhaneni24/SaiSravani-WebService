package com.java.cis;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (username.equals("SaiSravani") && password.equals("2424")) {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            response.sendRedirect("home.html");
        } else {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Invalid credentials. Please try again.');");
            out.println("window.location.href='login.html';");
            out.println("</script>");
            out.close();
        }
    }
}