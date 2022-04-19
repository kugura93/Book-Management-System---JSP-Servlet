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
 * @author HLC
 */
@WebServlet(name = "SearchBookServlet", urlPatterns = {"/searchBooks"})
public class SearchBookServlet extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        BookDAO bd = new BookDAO();
        AuthorDAO ad = new AuthorDAO();
        CategoryDAO cd = new CategoryDAO();
        List<Author> listAuthor = ad.getAuthorList();
        List<Category> listCategory = cd.getCategoryList();
        String searchBy = request.getParameter("searchGroup");
        String searchText = request.getParameter("searchText");
        if (searchBy.equals("title")) {
            if (searchText.equals("")) {
                List<Book> listBook = bd.getBookList();
                request.setAttribute("listBook", listBook);
            }
            else{
                List<Book> listBook = bd.getBookByTitle(searchText);
                request.setAttribute("listBook", listBook);
            }
        }
        else if(searchBy.equals("category")){
            if (searchText.equals("")) {
                List<Book> listBook = bd.getBookList();
                request.setAttribute("listBook", listBook);
            }
            else{
                List<Book> listBook = new ArrayList<>();
                List<Category> listCategoryId = cd.getCategoryIdByName(searchText);
                for (Category category : listCategoryId) {
                    List<Book> getBookByCategoryId = bd.getBookByCategoryId(category.getCategoryId());
                    for (Book book : getBookByCategoryId) {
                        listBook.add(book);
                    }
                }
                request.setAttribute("listBook", listBook);
            }
        }
        else{
            if (searchText.equals("")) {
                List<Book> listBook = bd.getBookList();
                request.setAttribute("listBook", listBook);
            }
            else{
                List<Author> listAuthorId = ad.getAuthorIdByName(searchText);
                List<Book> listBook = new ArrayList<>();
                for (Author author : listAuthorId) {
                    List<Book> getBookByAuthorId = bd.getBookByAuthorId(author.getAuthorId());
                    for (Book book : getBookByAuthorId) {
                        listBook.add(book);
                    }
                }              
                request.setAttribute("listBook", listBook);
            }
        }
        
        request.setAttribute("listAuthor", listAuthor);
        request.setAttribute("listCat", listCategory);
        request.getRequestDispatcher("searchBooks.jsp").forward(request, response);
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
