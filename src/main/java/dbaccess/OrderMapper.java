/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbaccess;

import functionlayer.Order;
import functionlayer.OrderException;
import functionlayer.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Annika
 */
public class OrderMapper {
    public static void createOrder(Order order) throws OrderException {
        try {
            Connector c = new Connector();
            Connection con = c.getConnection();
            String query = "INSERT INTO l_order (userid, height, length, width) "
                    + "VALUES (?, ?, ?, ?);";
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, order.getUser().getId());
            ps.setInt(2, order.getHeight());
            ps.setInt(3, order.getLength());
            ps.setInt(4, order.getWidth());
            ps.executeUpdate();
            
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            order.setId(ids.getInt(1));
            
        } catch (SQLException e) {
            throw new OrderException(e.getMessage());
        }
    }
    
    public static ArrayList<Order> getOrders(User user) throws OrderException {
        ArrayList<Order> orders = new ArrayList<>();
        try {
            Connector c = new Connector();
            Connection con = c.getConnection();
            String query = "SELECT * FROM l_order WHERE userid = ?;";
            PreparedStatement ps = con.prepareStatement(query);
            
            ps.setInt(1, user.getId());
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
                int id = rs.getInt("id");
                int height = rs.getInt("height");
                int length = rs.getInt("lenght");
                int width = rs.getInt("width");
                
                Order o = new Order(user, height, length, width);
                o.setId(id);
                orders.add(o);
            }
            
        } catch (SQLException e) {
            throw new OrderException(e.getMessage());
        }
        return orders;
    }
}
