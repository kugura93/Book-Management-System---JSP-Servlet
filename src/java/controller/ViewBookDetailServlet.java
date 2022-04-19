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
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Author;
import model.Book;
import model.Category;

/**
 *
 * @author HLC
 */
public class ViewBookDetailServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        BookDAO bd = new BookDAO();
        AuthorDAO ad = new AuthorDAO();
        CategoryDAO cd = new CategoryDAO();

        try {
            int bookId = Integer.parseInt(request.getParameter("bookId"));

            Book book = bd.getBookById(bookId);
            int authorId = book.getAuthorId();
            int categoryId = book.getCategoryId();
            String authorName = ad.getAuthorNameById(authorId);
            String categoryName = cd.getCategoryNameById(categoryId);
            request.setAttribute("authorName", authorName);
            request.setAttribute("categoryName", categoryName);
            request.setAttribute("book", book);
            request.getRequestDispatcher("bookDetail.jsp").forward(request, response);
        } catch (Exception e) {
            response.getWriter().println(e.getMessage());

        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
