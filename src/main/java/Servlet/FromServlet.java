package Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/submitForm")
public class FromServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");

        processFormData(email);

        response.setContentType("text/html");
        response.getWriter().write("Form submitted successfully! Email: " + email);
    }

    private void processFormData(String email) {
        System.out.println("Processing form data: Email = " + email);
    }
}
