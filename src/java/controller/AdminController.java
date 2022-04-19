/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.AuthorDAO;
import dal.BookDAO;
import dal.CategoryDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Author;
import model.Book;
import model.Category;

/**
 *
 * @author Admin
 */
@WebServlet(name = "AdminController", urlPatterns = {"/admin"})
public class AdminController extends HttpServlet {

    
    @Override
    protected void  doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        BookDAO bd = new BookDAO();
        AuthorDAO ad = new AuthorDAO();
        CategoryDAO cd = new CategoryDAO();
        List<Author> listAuthor = ad.getAuthorList();
        List<Category> listCategory = cd.getCategoryList();
        List<Book> listBook = bd.getBookList();
        request.setAttribute("listBook", listBook);
        request.setAttribute("listAuthor", listAuthor);
        request.setAttribute("listCat", listCategory);

        request.getRequestDispatcher("admin.jsp").forward(request, response);
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>


}
