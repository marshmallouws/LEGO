package dbaccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Connector {
	private Connection connection = null;
	
	//Constants
	private static final String IP	     = "157.230.21.82";
	private static final String PORT     = "3306";
	public  static final String DATABASE = "lego";
	private static final String USERNAME = "lego"; 
	private static final String PASSWORD = "iamlego";	     	
	
	public Connector() throws SQLException {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
                String url = "jdbc:mysql://" + IP + ":" + PORT + "/" + DATABASE;
                Properties props = new Properties();
                props.put("user", USERNAME);
                props.put("password", PASSWORD);
                props.put("allowMultiQueries", true);
                props.put("useUnicode", true);
                props.put("useJDBCCompliantTimezoneShift", true);
                props.put("useLegacyDatetimeCode", false);
                props.put("serverTimezone", "CET");
                this.connection = DriverManager.getConnection(url, props);
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
                ex.printStackTrace();
                throw new SQLException(ex.getMessage());
            }
	}
	
	public Connection getConnection() {
   		return this.connection;
	}
}