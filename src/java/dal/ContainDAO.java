/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Contain;

/**
 *
 * @author HLC
 */
public class ContainDAO extends MyDAO{
    public void insertBookContain(int userId, int bookId) {
        try {
            xSql ="insert into Contain values(?,?,GETDATE())";
            PreparedStatement stm = connection.prepareStatement(xSql);
            stm.setInt(1, userId);
            stm.setInt(2, bookId);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ContainDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Contain checkContainExist(int userId, int bookId) {
        Contain contain = null;
        xSql = "select * from Contain where book_case_id = ? and book_id = ?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, userId);
            ps.setInt(2, bookId);
            rs = ps.executeQuery();
            while (rs.next()) {
                contain = new Contain(rs.getInt(1),
                        rs.getInt(2),
                        rs.getDate(3));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return contain;
    }
    
    public List<Contain> getContainListById(int bookCaseId) {
        List<Contain> contains = new ArrayList<>();
        xSql = "select * from Contain where book_case_id = ?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, bookCaseId);
            rs = ps.executeQuery();
            int bookId;
            Date date;
            Contain contain;
            while (rs.next()) {
                bookId = rs.getInt("book_id");
                date = rs.getDate("create_date");
                contain = new Contain(bookCaseId, bookId, date);
                contains.add(contain);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return contains;
    }
    
    public void deleteContain(int bookId) {
        try {
            xSql = "delete from Contain where book_id = ?";
            PreparedStatement stm = connection.prepareStatement(xSql);
            stm.setInt(1, bookId);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ContainDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
