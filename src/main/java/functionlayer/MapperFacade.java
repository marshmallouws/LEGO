/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package functionlayer;

import dbaccess.OrderMapper;
import dbaccess.UserMapper;
import java.util.ArrayList;

/**
 *
 * @author Annika
 */
public class MapperFacade {

    public static User login(String email, String password) throws LoginSampleException {
        return UserMapper.login(email, password);
    }

    public static User createUser(String email, String password) throws LoginSampleException {
        User user = new User(email, password, "customer");
        UserMapper.createUser(user);
        return user;
    }
    
    public static Order createOrder(User user, int height, int length, int width) throws OrderException {
        Order order = new Order(user, height, length, width);
        OrderMapper.createOrder(order);
        return order;
    }
    
    public static ArrayList<Order> getOrders(User user) throws OrderException {
        return OrderMapper.getOrders(user);
    }
}
