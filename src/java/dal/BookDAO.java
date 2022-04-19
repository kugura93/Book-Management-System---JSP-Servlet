/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Book;

/**
 *
 * @author HLC
 */
public class BookDAO extends MyDAO {

    public List<Book> getBookList() {
        List<Book> books = new ArrayList<>();
        xSql = "select b.*, a.author_name, c.category_name ";
        xSql += "from Book as b, Author as a, Category as c ";
        xSql += "where b.author_id = a.author_id and b.category_id = c.category_id";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            int bookId, authorId, categoryId;
            String bookTitle;
            String brief, publisher, content, image;
            Book book;
            while (rs.next()) {
                bookId = rs.getInt("book_id");
                bookTitle = rs.getString("book_title");
                authorId = rs.getInt("author_id");
                brief = rs.getString("brief");
                publisher = rs.getString("publisher");
                content = rs.getString("content");
                categoryId = rs.getInt("category_id");
                image = rs.getString("image");
                book = new Book(bookId, bookTitle, authorId, brief, publisher, content, categoryId, image);
                books.add(book);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            if(books.isEmpty()){
                System.out.println("empty");
            }
            else{
                System.out.println("error");
            }
        }
        
        return books;
    }
    
    public Book getBookById(int bookId){
        Book book = null;
        xSql = "select * from Book where book_id = ?" ;
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, bookId);
            rs = ps.executeQuery();
            int authorId, categoryId;
            String bookTitle;
            String brief, publisher, content, image;
            if (rs.next()) {
                bookTitle = rs.getString("book_title");
                authorId = rs.getInt("author_id");
                brief = rs.getString("brief");
                publisher = rs.getString("publisher");
                content = rs.getString("content");
                categoryId = rs.getInt("category_id");
                image = rs.getString("image");
                book = new Book(bookId, bookTitle, authorId, brief, publisher, content, categoryId, image);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return book;
    }
    
    public List<Book> getBookByTitle(String bookTitle){
        List<Book> books = new ArrayList<>();
        xSql = "select * from Book where book_title like ?" ;
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1,"%" + bookTitle + "%");
            rs = ps.executeQuery();
            Book book;
            int authorId, categoryId;
            int bookId;
            String brief, publisher, content, image;
            while (rs.next()) {
                bookTitle = rs.getString("book_title");
                bookId = rs.getInt("book_id");
                authorId = rs.getInt("author_id");
                brief = rs.getString("brief");
                publisher = rs.getString("publisher");
                content = rs.getString("content");
                categoryId = rs.getInt("category_id");
                image = rs.getString("image");
                book = new Book(bookId, bookTitle, authorId, brief, publisher, content, categoryId, image);
                books.add(book);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return books;
    }
    
    public List<Book> getBookByCategoryId(int categoryId){
        List<Book> books = new ArrayList<>();
        xSql = "select * from Book where category_id = ?" ;
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, categoryId);
            rs = ps.executeQuery();
            int authorId, bookId;
            String bookTitle;
            String brief, publisher, content, image;
            Book book;
            while (rs.next()) {
                bookTitle = rs.getString("book_title");
                authorId = rs.getInt("author_id");
                brief = rs.getString("brief");
                publisher = rs.getString("publisher");
                content = rs.getString("content");
                bookId = rs.getInt("book_id");
                image = rs.getString("image");
                book = new Book(bookId, bookTitle, authorId, brief, publisher, content, categoryId, image);
                books.add(book);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return books;
    }
    
    public List<Book> getBookByAuthorId(int authorId){
        List<Book> books = new ArrayList<>();
        xSql = "select * from Book where author_id = ?" ;
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, authorId);
            rs = ps.executeQuery();
            int bookId, categoryId;
            String bookTitle;
            String brief, publisher, content, image;
            Book book;
            while (rs.next()) {
                bookTitle = rs.getString("book_title");
                bookId = rs.getInt("book_id");
                brief = rs.getString("brief");
                publisher = rs.getString("publisher");
                content = rs.getString("content");
                categoryId = rs.getInt("category_id");
                image = rs.getString("image");
                book = new Book(bookId, bookTitle, authorId, brief, publisher, content, categoryId, image);
                books.add(book);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return books;
    }
    
    public void insert(Book book) {
        try {
            String sql = "INSERT INTO [Book]\n" +

                    "           ([book_title]\n" +
                    "           ,[author_id]\n" +
                    "           ,[brief]\n" +
                    "           ,[publisher]\n" +
                    "           ,[content]\n" +
                    "           ,[category_id]\n" +
                    "           ,[image])\n" +
                    "     VALUES\n" +
                    "           (?\n" +
                    "           ,?\n" +
                    "           ,?\n" +
                    "           ,?\n" +
                    "           ,?\n" +
                    "           ,?\n" +
                    "           ,?)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, book.getBookTitle());
            stm.setInt(2, book.getAuthorId());
            stm.setString(3, book.getBrief());
            stm.setString(4, book.getPublisher());
            stm.setString(5, book.getContent());
            stm.setInt(6, book.getCategoryId());
            stm.setString(7, book.getImage());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void delete(int id) {
        try {
            String sql = "DELETE FROM [Book]\n"
                    + "      WHERE book_id = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void update(Book book) {
        try {
            String sql = "UPDATE [Book]\n" +
                    "   SET [book_title] = ?\n" +
                    "      ,[author_id] = ?\n" +
                    "      ,[brief] = ?\n" +
                    "      ,[publisher] = ?\n" +
                    "      ,[content] = ?\n" +
                    "      ,[category_id] = ?\n" +
                    "      ,[image] = ?\n" +
                    " WHERE book_id = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(8, book.getBookId());
            stm.setString(1, book.getBookTitle());
            stm.setInt(2, book.getAuthorId());
            stm.setString(3, book.getBrief());
            stm.setString(4, book.getPublisher());
            stm.setString(5, book.getContent());
            stm.setInt(6, book.getCategoryId());
            stm.setString(7, book.getImage());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
