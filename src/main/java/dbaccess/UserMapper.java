/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbaccess;

import functionlayer.LoginSampleException;
import functionlayer.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Annika
 */
public class UserMapper {
    
    public static void createUser(User user) throws LoginSampleException {
        try {
            Connector c = new Connector();
            Connection con = c.getConnection();
            String query = "INSERT INTO user (email, password, rode) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getRole());
            ps.executeUpdate();
            
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt(1);
            user.setId(id);
            
        } catch (SQLException e) {
            throw new LoginSampleException(e.getMessage());
        }   
    }
    
    public static User login(String email, String password) throws LoginSampleException {
        try {
            Connector c = new Connector();
            Connection con = c.getConnection();
            String query = "SELECT * FROM user WHERE email = ? AND password = ?;";
            PreparedStatement ps = con.prepareStatement(query);
            
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()) {
                String role = rs.getString("role");
                int id = rs.getInt("id");
                User user = new User(email, password, role);
                user.setId(id);
                return user;
            } else {
                throw new LoginSampleException("Bruger kan ikke valideres");
            }
        } catch (SQLException e) {
            throw new LoginSampleException(e.getMessage());
        }
    }
    
}
