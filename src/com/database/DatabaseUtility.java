package com.database;


import com.ibatis.common.jdbc.ScriptRunner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtility {
    private static final String USERNAME = "root";
    private static final String PASSWORD = "mysql";
    private static final String CONNECTION = "jdbc:mysql://localhost:3306/BigBox";

    public static Connection connection;

    public static Connection getConnection() throws SQLException {

        try {
            connection = DriverManager.getConnection(CONNECTION, USERNAME, PASSWORD);
            System.out.println("Connection Status: Connected");
        } catch (SQLException e) {
            System.out.println(e);
        }
        return connection;
    }

    public static void closeconnection() throws SQLException {

        try {
            connection.close();
            System.out.println("Connection Status: Closed");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void sqlScriptRunner() throws SQLException {
        String sqlScriptPath = "/Users/longnguyen/Desktop/Java Project/BigBoxApp/BigBoxApp/src/com/sqlscript/BigBox_Create_Tables.sql";

        try {
            ScriptRunner sr = new ScriptRunner(connection, false, false);
            Reader reader = new BufferedReader(new FileReader(sqlScriptPath));

            sr.runScript(reader);

        } catch (Exception e){
            System.err.println("Failed to Execute " + sqlScriptPath
                    + " The error is " + e.getMessage());
        }
    }



}
