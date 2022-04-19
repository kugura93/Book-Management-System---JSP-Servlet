/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.BookCase;

/**
 *
 * @author HLC
 */
public class BookCaseDAO extends MyDAO{
    public void createBookCase(int userId, String userName){
        try {
            xSql = "insert into BookCase(book_case_id, book_case_name) values(?,?)" ;
            PreparedStatement stm = connection.prepareStatement(xSql);
            stm.setInt(1, userId);
            stm.setString(2, userName);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BookCaseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public BookCase getBookCaseById(int userId){
        BookCase bookCase = null;
        xSql = "select * from BookCase where book_case_id = ?" ;
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, userId);
            rs = ps.executeQuery();
            String caseName;
            if (rs.next()) {
                caseName = rs.getString("book_case_name");
                bookCase = new BookCase(userId, caseName);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return bookCase;
    }
}
