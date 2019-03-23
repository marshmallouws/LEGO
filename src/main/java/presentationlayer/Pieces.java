/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentationlayer;

import functionlayer.LogicFacade;
import functionlayer.LoginSampleException;
import functionlayer.OrderException;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Annika
 */
public class Pieces extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, OrderException {
        int height = Integer.parseInt(request.getParameter("height"));
        int length = Integer.parseInt(request.getParameter("length"));
        int width = Integer.parseInt(request.getParameter("width"));
        HttpSession session = request.getSession();
        //String order = request.getParameter("ordernumber");
        HashMap<String, Integer> pieces = LogicFacade.calculate(height, length, width);
        session.setAttribute("pieces", pieces);
        return "pieceslist";
    }
    
}
