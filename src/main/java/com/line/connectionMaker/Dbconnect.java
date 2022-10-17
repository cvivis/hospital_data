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
//        PreparedStatement ps = conn.prepareStatement("INSERT INTO seoul_hospital(hospital_id,address, district,category,emergency_room,name,subdivision) VALUES (?,?,?,?,?,?,?)");
//        ps.setString(1,id);
//        ps.setString(2,address);
//        ps.setString(3,district);
//        ps.setString(4,category);
//        ps.setString(5,emergency_room);
//        ps.setString(6,name);
//        ps.setString(7,subdivision);

//        PreparedStatement ps2 = conn.prepareStatement("select * from users where id = 1");
//        ResultSet result = ps2.executeQuery();
//
//
//        while(result.next()){
//            System.out.println("id: "+result.getString("id"));
//            System.out.println("name: "+result.getString("name"));
//            System.out.println("password: "+result.getString("password"));
//        }


//        ps.executeUpdate();
//        ps2.close();
//        conn.close();
    }
}
