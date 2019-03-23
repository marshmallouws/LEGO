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
import java.util.HashMap;

/**
 *
 * @author Annika
 */
public class OrderMapper {

    public static void createOrder(Order order) throws OrderException {
        try {
            Connector c = new Connector();
            Connection con = c.getConnection();
            String query = "INSERT INTO l_order (userid, height, length, width, o_date) "
                    + "VALUES (?, ?, ?, ?, NOW());";
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, order.getUser().getId());
            ps.setInt(2, order.getHeight());
            ps.setInt(3, order.getLength());
            ps.setInt(4, order.getWidth());
            ps.executeUpdate();

            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt(1);
            order.setId(id);

            String query1 = "INSERT INTO order_status (orderid, statusid, s_date) "
                    + "VALUES (?, 1, NOW());";
            PreparedStatement ps1 = con.prepareStatement(query1);
            ps1.setInt(1, id);
            ps1.executeUpdate();

        } catch (SQLException e) {
            throw new OrderException(e.getMessage());
        }
    }

    public static ArrayList<Order> getOrders(User user) throws OrderException {
        ArrayList<Order> orders = new ArrayList<>();
        try {
            Connector c = new Connector();
            Connection con = c.getConnection();
            String query = "SELECT l_order.id, height, length, width, o_date, MAX(o_status.id) AS ma FROM l_order "
                    + "JOIN order_status ON l_order.id = orderid "
                    + "JOIN o_status ON o_status.id = order_status.statusid "
                    + "WHERE userid = ? "
                    + "GROUP BY l_order.id;";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, user.getId());
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                int height = rs.getInt("height");
                int length = rs.getInt("length");
                int width = rs.getInt("width");
                String date = rs.getString("o_date");
                String state = getStatus().get(rs.getInt("ma"));

                Order o = new Order(user, height, length, width, id, date, state);
                orders.add(o);
            }

        } catch (SQLException e) {
            throw new OrderException(e.getMessage());
        }
        return orders;
    }

    private static HashMap<Integer, String> getStatus() throws OrderException {
        HashMap<Integer, String> status = new HashMap<>();
        try {
            Connector c = new Connector();
            Connection con = c.getConnection();
            String query = "SELECT * FROM o_status;";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String state = rs.getString("state");
                status.put(id, state);
            }
        } catch (SQLException e) {
            throw new OrderException(e.getMessage());
        }

        return status;
    }

    public static ArrayList<Order> getAllOrders() throws OrderException {
        ArrayList<Order> orders = new ArrayList<>();
        try {
            Connector c = new Connector();
            Connection con = c.getConnection();
            String query = "SELECT userid, l_order.id, height, length, width, o_date, MAX(o_status.id) AS ma FROM l_order "
                    + "JOIN order_status ON l_order.id = orderid "
                    + "JOIN o_status ON o_status.id = order_status.statusid "
                    + "GROUP BY l_order.id;";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int userid = rs.getInt("userid");
                int id = rs.getInt("id");
                int height = rs.getInt("height");
                int length = rs.getInt("length");
                int width = rs.getInt("width");
                String date = rs.getString("o_date");
                String state = getStatus().get(rs.getInt("ma"));
                
                User user = new User(userid);

                Order o = new Order(user, height, length, width, id, date, state);
                orders.add(o);
            }

        } catch (SQLException e) {
            throw new OrderException(e.getMessage());
        }
        return orders;
    }
}
