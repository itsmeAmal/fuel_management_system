package com.fms.databaseconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseConnection {

    private DatabaseConnection() {
    }

    public static Connection getDatabaseConnection() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/service_station", "root", "123");
        return con;

//    	private static String databaseName = "project_employee_management";
//        private static String url = "jdbc:mysql://localhost:3306/project_employee_management"; // have to change later with host and port
//        private static String user = "root";
//        private static String password = "123";
//
//        private static Connection con = null;
//
//        public static Connection getDatabaseConnection() throws SQLException {
//            if (con == null || isInputChange || con.isClosed()) {
//                try {
//                    con = DriverManager.getConnection(url, user, password);
//                } catch (SQLException ex) {
//                    KatanaDialog.katanaErrorMessageDialog(null,
//                            Options.getOptionPaneList().getString("error_connection_lost"));
//                }
//            }
//            return con;
//        }
    }

}
