package Servlet;

import Dao.UserDAO;
import Entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/")
public class home extends HttpServlet {
    private final List<User> users =new ArrayList<>();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String message ="Ah bah enfin bordel";
        req.setAttribute("message1",message);
        req.setAttribute("message2","bonjour");
        req.setAttribute("users", users);
        /*
        List<User> users = new UserDAO().selectAllUser();
        for(User user : users) {
            System.out.println(user);
        }
        */

        List<User> users = new UserDAO().selectAllUser();
        req.setAttribute("usersAll", users);
        req.getRequestDispatcher("WEB-INF/views/home.jsp").forward(req, res);
    }


}
