package Servlet;

import Dao.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteUser")
public class DeleteUserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userIdParam = req.getParameter("userId");
        try{
            int userId = Integer.parseInt(userIdParam);
            UserDAO userDAO = new UserDAO();
            userDAO.delete(userId);
        }catch(Exception e){
            e.printStackTrace();
        }
        resp.sendRedirect(req.getContextPath() + "/");
    }
}
