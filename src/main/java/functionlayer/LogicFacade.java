package functionlayer;

/**
 * The purpose of LogicFacade is to...
 *
 * @author kasper
 */
public class LogicFacade {

    public static User login(String email, String password) throws LoginSampleException {
        return MapperFacade.login(email, password);
    }

    public static User createUser(String email, String password) throws LoginSampleException {
        return MapperFacade.createUser(email, password);
    }
    
    public static Order createOrder(User user, int height, int length, int width) throws OrderException {
        return MapperFacade.createOrder(user, height, length, width);
    }
}
