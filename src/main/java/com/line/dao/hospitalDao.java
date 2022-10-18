package com.line.dao;

import com.line.domain.Hospital;

import java.sql.*;
import java.util.List;
import java.util.Map;

public class hospitalDao {



    public void insert(List<Hospital> hospitals) throws SQLException {
        Connection c = getConnection();

        PreparedStatement ps = null;
        for (Hospital hospital : hospitals) {
            ps = c.prepareStatement("INSERT INTO seoul_hospitals(hospital_id,address, district,category,emergency_room,name,subdivision) VALUES (?,?,?,?,?,?,?)");
            ps.setString(1, hospital.getId());
            ps.setString(2, hospital.getAddress());
            ps.setString(3, hospital.getDistrict());
            ps.setString(4, hospital.getCategory());
            ps.setString(5, Integer.toString(hospital.getEmergency_room()));
            ps.setString(6, hospital.getName());
            ps.setString(7, hospital.getSubdivision());
            ps.executeUpdate();
        }



        ps.close();

        System.out.println("insert 완료");
        c.close();
    }

    public Hospital selectId(String hospital_id,Connection conn) throws SQLException {
        PreparedStatement ps2 = conn.prepareStatement("select * from seoul_hospitals where hospital_id = ?");
        ps2.setString(1,hospital_id);
        ResultSet result = ps2.executeQuery();

        while(result.next()){
//            System.out.println("hospital id: "+result.getString("hospital_id"));
//            System.out.println("name: "+result.getString("name"));
//            System.out.println("password: "+result.getString("address"));
        }

        Hospital hospital = new Hospital(result.getString("hospital_id"),result.getString("address"),result.getString("district"),result.getString("name"),result.getString("subdivision"));
        result.close();
        ps2.close();

        return hospital;

    }
    public Hospital selectAddress(String district,Connection conn) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("select * from seoul_hospitals where district = ?");
        ps.setString(1,district);
        ResultSet result = ps.executeQuery();

        while(result.next()){
//            System.out.println("hospital id: "+result.getString("hospital_id"));
//            System.out.println("name: "+result.getString("name"));
//            System.out.println("district: "+result.getString("district"));
//            System.out.println("--------------------------");
        }
        Hospital hospital = new Hospital(result.getString("hospital_id"),result.getString("address"),result.getString("district"),result.getString("name"),result.getString("subdivision"));
        result.close();

        ps.close();
        return hospital;

    }

    public Connection getConnection() throws SQLException {
        Map<String,String> env = System.getenv();
        String dbHost = env.get("DB_HOST");
        String dbUser = env.get("DB_USER");
        String dbPassword = env.get("DB_PASSWORD");

        Connection conn = DriverManager.getConnection(dbHost,dbUser,dbPassword);

        return conn;

    }

}
