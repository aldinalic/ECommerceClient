package it.unitn.alic.ecommerceclient;

import it.unitn.alic.ecommerceserver.entities.CustomerEntity;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "searchCustomer", value = "/searchCustomer")
public class SearchCustomerServlet extends HttpServlet {

    BusinessDelegate businessDelegate;

    @Override
    public void init() {
        try {
            businessDelegate = new BusinessDelegate();
            System.out.println("Connection Established!");
        } catch (RuntimeException r) {
            System.out.println("Connection NOT Established " + r.getMessage());
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        int id;

        try {
            id = Integer.parseInt(request.getParameter("id"));
            System.out.println("Obtained ID from request: " + id);
        } catch (NumberFormatException e) {
            response.sendRedirect("");
            return;
        }

        String html = "";
        try {
            CustomerEntity customer = businessDelegate.getCustomer(id);
            System.out.println("Obtained Customer from Business Delegate");

            if (customer != null)  {
                html += "<h1> Username is: " + customer.getUsername() + "</h1>";
                html += "<h2> Email is: " + customer.getEmail() + "</h2>";
                html += "<h3> Address is: " + customer.getAddress() + "</h2";
            } else {
                html += "<h1>No Customer Found with that ID!</h1>";
            }
        } catch (Exception e) {
            html += "<h1>Error in fetching data</h1>";
            html += "<p>"+e.getMessage()+"</p>";
        }

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>ID: " + id + "</title></head><body>");
        out.println(html);
        out.println("</body></html>");
        out.close();
    }
}