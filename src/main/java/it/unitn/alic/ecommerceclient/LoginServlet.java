package it.unitn.alic.ecommerceclient;

import it.unitn.alic.ecommerceserver.entities.CustomerEntity;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Login", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();

        // Get Session and Context
        HttpSession session = request.getSession();
        ServletContext ctx = getServletConfig().getServletContext();

        // If the current session is empty, we create a new Entity
        if (session.getAttribute("loggedCustomer") == null) {
            session.setAttribute("loggedCustomer", new CustomerEntity());
        }

        // Get Parameters from the request
        String username = request.getParameter("username");
        String password = request.getParameter("password");


        // Boolean that will be true if the user does exist
        boolean auth = false;

        boolean userExist = ctx.getAttribute(username) != null;
        // Check if the user exists and the password matches
        if (userExist) {
            CustomerEntity customer = (CustomerEntity) ctx.getAttribute(username);
            boolean passMatch = customer.getPassword().equals(password);
            if (passMatch) {
                auth = true;
            }
        }

        // ...if that's the case, "move" the user in the session
        // If user exists
        if (auth) {
            synchronized (session) {
                session.setAttribute("loggedCustomer", ctx.getAttribute(username));
                ((CustomerEntity) ctx.getAttribute(username)).setLoggedIn(true);  // the user is currently active
            }
            // After the user is logged in, we forward the call to show the Products Page
            RequestDispatcher rs = request.getRequestDispatcher("/products");
            rs.forward(request, response);

        } else {
            out.println("<p>Username or password incorrect.</p>");
            RequestDispatcher rs = request.getRequestDispatcher("login.jsp");
            rs.include(request, response);
        }
    }

}
