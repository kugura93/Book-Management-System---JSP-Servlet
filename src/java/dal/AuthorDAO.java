/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.util.ArrayList;
import java.util.List;
import model.Author;

/**
 *
 * @author HLC
 */
public class AuthorDAO extends MyDAO{
    public List<Author> getAuthorList() {
        List<Author> authors = new ArrayList<>();
        xSql = "select * from Author";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            int authorId;
            String authorName;
            Author author;
            while (rs.next()) {
                authorId = rs.getInt("author_id");
                authorName = rs.getString("author_name");
                author = new Author(authorId, authorName);
                authors.add(author);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return authors;
    }
    
    public List<Author> getAuthorIdByName(String authorName){
        List<Author> authors = new ArrayList<>();
        
        xSql = "select * from Author where author_name like ?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, "%" + authorName + "%");
            rs = ps.executeQuery();
            int authorId;
            Author author;
            while (rs.next()) {
                authorId = rs.getInt("author_id");
                authorName = rs.getString("author_name");
                author = new Author(authorId, authorName);
                authors.add(author);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return authors;
    }
    
    public String getAuthorNameById(int authorId){
        
        xSql = "select author_name from Author where author_id = ?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, authorId);
            rs = ps.executeQuery();
            String authorName;
            if (rs.next()) {
                authorName = rs.getString("author_name");
                return authorName;
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        return null;
    }
}
