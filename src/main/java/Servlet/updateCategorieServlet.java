package Servlet;

import Dao.CategorieDao;
import Entity.Categories;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateCategorie")
public class updateCategorieServlet extends HttpServlet {

    private final CategorieDao categorieDao = new CategorieDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long id = Long.parseLong(request.getParameter("id"));
        Categories categories = categorieDao.getCategorie(id);
        request.setAttribute("category", categories);
        request.getRequestDispatcher("WEB-INF/views/updateCategorie.jsp").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        long id = Long.parseLong(request.getParameter("id"));
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        Categories cat = new Categories(id, name, description);
        categorieDao.updateCategorie(cat);
        response.sendRedirect(request.getContextPath()+"/categories");
    }
}
