/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentationlayer;

import functionlayer.LoginSampleException;
import functionlayer.OrderException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Annika
 */
public class Logout extends Command {

    public Logout() {
    }

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, OrderException {
        HttpSession session = request.getSession();
        if(!session.getAttribute("user").equals(null)) {
            session.removeAttribute("user");
            try {
                request.getRequestDispatcher("index.jsp").forward(request, response);
            } catch (ServletException ex) {
                Logger.getLogger(Logout.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Logout.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return "index";
    }
    
}
