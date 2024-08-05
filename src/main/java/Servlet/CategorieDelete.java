package Servlet;

import Dao.CategorieDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteCategories")
public class CategorieDelete extends HttpServlet {

    public CategorieDelete() {
        // Constructeur par défaut requis
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String catId = req.getParameter("categorieId");
        try {
            long categoriesId = Long.parseLong(catId);
            CategorieDao categorieDao = new CategorieDao();
            categorieDao.delete(categoriesId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        resp.sendRedirect(req.getContextPath() + "/categories");
    }
}
