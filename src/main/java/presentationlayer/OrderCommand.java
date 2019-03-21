/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentationlayer;

import functionlayer.LogicFacade;
import functionlayer.OrderException;
import functionlayer.Order;
import functionlayer.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Annika
 */
public class OrderCommand extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws OrderException {     
        int height = Integer.parseInt(request.getParameter("height"));
        int length = Integer.parseInt(request.getParameter("length"));
        int width = Integer.parseInt(request.getParameter("width"));
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        Order order = LogicFacade.createOrder(user, height, length, width);
        return user.getRole() + "page";
    }
    
}
