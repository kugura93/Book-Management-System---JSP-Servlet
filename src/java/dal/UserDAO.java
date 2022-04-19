/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import model.User;

/**
 *
 * @author HLC
 */
public class UserDAO extends MyDAO {

    public User getUser(String username, String pass) {
        User user = null;
        xSql = "select * from [User] where [user_name] = ? and password = ?";  
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, username);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while (rs.next()) {
                user = new User(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    public User checkAccountExist(String username) {
        User user = null;
        xSql = "select * from [User]\n"
                + "where [user_name] = ?\n";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, username);
            rs = ps.executeQuery();
            while (rs.next()) {
                user = new User(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    public void insertUser(String user, String pass) {
        xSql = "insert into [User]([user_name], password, role_id)\n"
                + "values(?,?,2)";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, user);
            ps.setString(2, pass);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
