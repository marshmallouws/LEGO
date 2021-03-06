/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentationlayer;

import functionlayer.LogicFacade;
import functionlayer.LoginSampleException;
import functionlayer.OrderException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Bitten
 */
public class ChangeStatus extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, OrderException {
        int id = Integer.parseInt(request.getParameter("orderid"));
        String status = request.getParameter("status");
        LogicFacade.changeStatus(id, status);
        return "employeepage";
        
    }
    
}
