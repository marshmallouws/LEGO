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
}
