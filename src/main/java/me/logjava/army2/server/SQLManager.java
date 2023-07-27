package me.logjava.army2.server;

import java.sql.*;

/**
 *
 * @author ASD
 * @maintain Hoàng Nguyên
 */
public class SQLManager {

    protected static Connection conn;
    protected static Statement stat;
    protected static String host;
    protected static String database;
    protected static String user;
    protected static String password;

    protected static synchronized void create(String host, String database, String user, String pass) {
        SQLManager.host = host;
        SQLManager.database = database;
        SQLManager.user = user;
        SQLManager.password = pass;
        try {
            /**
             * @maintain Hoàng Nguyên
             * update to Mysql connector driver 8.0.32
             */
            Class.forName("com.mysql.cj.jdbc.Driver");  // Kiểm tra driver
        } catch (ClassNotFoundException e) {
            System.out.println("driver mysql not found!");
            System.exit(0);
        }
        String url = "jdbc:mysql://" + host + "/" + database;
        System.out.println("MySQL connect: " + url);
        try {
            conn = DriverManager.getConnection(url, user, pass);
            // fix bugs null pointer by Nguyen
            stat = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            System.out.println("Success!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }
    
    protected static synchronized Statement getStatement() throws SQLException {
        if (stat == null ||  stat.isClosed() || stat.isCloseOnCompletion()) {
            create(host, database, user, password);
        }
        return stat;
    }

    protected static synchronized boolean close() {
        System.out.println("Close connection to database");
        try {
            if (stat != null) {
                stat.close();
            }
            if (conn != null) {
                conn.close();
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
