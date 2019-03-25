package presentationlayer;

import functionlayer.LoginSampleException;
import functionlayer.OrderException;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

abstract class Command {

    private static HashMap<String, Command> commands;

    private static void initCommands() {
        commands = new HashMap<>();
        commands.put("login", new Login());
        commands.put("register", new Register());
        commands.put("order", new OrderCommand());
        commands.put("oldorders", new OrderList());
        commands.put("pieceslist", new Pieces());
        commands.put("changestatus", new ChangeStatus());
        commands.put("logout", new Logout());
        commands.put("back", new Back());
    }

    static Command from(HttpServletRequest request) {
        String commandName = request.getParameter("command");
        if (commands == null) {
            initCommands();
        }
        return commands.getOrDefault(commandName, new UnknownCommand());
    }

    abstract String execute(HttpServletRequest request, HttpServletResponse response)
            throws LoginSampleException, OrderException;

}
