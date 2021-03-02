package ua.nure.hospital.db;

import org.apache.log4j.Logger;
import ua.nure.hospital.command.common.admin.ChangeUserByAdminCommand;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBManager {

    public static Logger logger = Logger.getLogger(ChangeUserByAdminCommand.class);

    public static final String URL = "jdbc:mysql://localhost:3306/hospitalinside?sslMode=DISABLED&serverTimezone=UTC&user=root&password=3228";//getUrl();

    private static DBManager instance;

    public DBManager() {
        super();
    }

    public static synchronized DBManager getInstance() {
        if (instance == null) {
            instance = new DBManager();
        }
        return instance;
    }

    public static String getUrl() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return URL;
        /*FileInputStream fileInputStream;
        Properties properties = new Properties();
        try  {
            fileInputStream = new FileInputStream("D:/Download/learning/EPAM/Practice/Hospital_FP/app.properties");
            properties.load(fileInputStream);
            logger.info("DBCONT >>> " + properties.getProperty("connection.url"));
            return properties.getProperty("connection.url");
        } catch (IOException exception) {
            logger.info("DBCONT >>> " + exception.getMessage());
            return null;
        }*/
    }

    public Connection getConnection(String connectionUrl) throws SQLException {
        return DriverManager.getConnection(connectionUrl);
    }

    public void close(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException ex) {
                //LOGGER.error("Can not close connection", ex);
            }
        }
    }
}
