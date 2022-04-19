/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.util.ArrayList;
import java.util.List;
import model.Category;

/**
 *
 * @author HLC
 */
public class CategoryDAO extends MyDAO{
    public List<Category> getCategoryList() {
        List<Category> cats = new ArrayList<>();
        xSql = "select * from Category";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            int catId;
            String catName;
            Category cat;
            while (rs.next()) {
                catId = rs.getInt("category_id");
                catName = rs.getString("category_name");
                cat = new Category(catId, catName);
                cats.add(cat);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return cats;
    }
    
    public List<Category> getCategoryIdByName(String categoryName){
        List<Category> categorys = new ArrayList<>();
        
        xSql = "select * from Category where category_name like ?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, "%" + categoryName + "%");
            rs = ps.executeQuery();
            int categoryId;
            Category category;
            while (rs.next()) {
                categoryId = rs.getInt("category_id");
                categoryName = rs.getString("category_name");
                category = new Category(categoryId, categoryName);
                categorys.add(category);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return categorys;
    }
    
    public String getCategoryNameById(int categoryId){
        
        xSql = "select category_name from Category where category_id = ?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, categoryId);
            rs = ps.executeQuery();
            String categoryName;
            if (rs.next()) {
                categoryName = rs.getString("category_name");
                return categoryName;
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        return null;
    }
}
