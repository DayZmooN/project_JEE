package Servlet;

import Dao.CategorieDao;
import Entity.Categories;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/categories")
public class CategorieServlet extends HttpServlet {

    private final CategorieDao categorieDao =new CategorieDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Categories> categories = categorieDao.getAllCategories();
        request.setAttribute("categories", categories);
        request.getRequestDispatcher("WEB-INF/views/categories.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        Categories cat = new Categories(name, description);
        categorieDao.save(cat);
        response.sendRedirect(request.getContextPath() + "/categories");
    }

}
