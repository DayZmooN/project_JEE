package Servlet;

import Dao.UserDAO;
import Entity.User;
import org.mindrot.jbcrypt.BCrypt;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private final List<User> users = new ArrayList<>();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("first_name");
        String lastName = request.getParameter("last_name");
        String email =request.getParameter("email");
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");
        String hashPass = BCrypt.hashpw(password, BCrypt.gensalt());
        User user = new User(firstName,lastName,phone,email,hashPass);
        //users.add(user);
        UserDAO userDAO = new UserDAO();
        userDAO.save(user);
        List<User> users = new UserDAO().findAll();
        request.setAttribute("users", users);
        request.getRequestDispatcher("WEB-INF/views/contact.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    List<User>   users = new UserDAO().findAll();
        request.setAttribute("users", users);
        System.out.println("GET request received at /contact");
        System.out.println("Users added to request: " + users);
        request.getRequestDispatcher("WEB-INF/views/contact.jsp").forward(request, response);
    }
}
