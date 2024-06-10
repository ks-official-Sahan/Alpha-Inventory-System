package model;

import gui.SignIn;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 * @author S.A. Sahan Sachintha (+94768701148)
 */
public class MySQL {

    private static Connection connection;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop_db_", "username", "password");
//            connection = DriverManager.getConnection("jdbc:mysql://chama-do-user-14637459-0.b.db.ondigitalocean.com:25060/shop_db", "alpha", "Alpha@7f2d!@#$");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop_db", "root", "King7f2d!@#$");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ResultSet execute(String query) throws Exception {
        Statement statement = connection.createStatement();
        if (query.startsWith("SELECT")) {
            return statement.executeQuery(query);
        } else {
            statement.executeUpdate(query);
            return null;
        }
    }

}
