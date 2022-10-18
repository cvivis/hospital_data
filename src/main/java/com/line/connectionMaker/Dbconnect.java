package com.line.connectionMaker;

import java.sql.*;
import java.util.Map;
import com.line.dao.hospitalDao;

public class Dbconnect {
    public Connection add() throws SQLException {
        Map<String,String> env = System.getenv();
        String dbHost = env.get("DB_HOST");
        String dbUser = env.get("DB_USER");
        String dbPassword = env.get("DB_PASSWORD");

        Connection conn = DriverManager.getConnection(dbHost,dbUser,dbPassword);

        return conn;

    }
}
