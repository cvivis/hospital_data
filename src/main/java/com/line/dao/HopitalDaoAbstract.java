package com.line.dao;

import com.line.domain.Hospital;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class HopitalDaoAbstract {
    public void insert(Hospital hospital) throws SQLException {
        Connection c = makeConnection();
        PreparedStatement ps;
        ps = c.prepareStatement("INSERT INTO seoul_hospitals(hospital_id,address, district,category,emergency_room,name,subdivision) VALUES (?,?,?,?,?,?,?)");
        ps.setString(1, hospital.getId());
        ps.setString(2, hospital.getAddress());
        ps.setString(3, hospital.getDistrict());
        ps.setString(4, hospital.getCategory());
        ps.setString(5, Integer.toString(hospital.getEmergency_room()));
        ps.setString(6, hospital.getName());
        ps.setString(7, hospital.getSubdivision());
        ps.executeUpdate();

        ps.close();
        System.out.println("insert 완료");
        c.close();
    }

    public Hospital selectId(String hospital_id) throws SQLException {
        Connection conn = makeConnection();

        PreparedStatement ps2 = conn.prepareStatement("select * from seoul_hospitals where hospital_id = ?");
        ps2.setString(1,hospital_id);
        ResultSet result = ps2.executeQuery();
        Hospital hospital = null;
        while(result.next()){
            hospital = new Hospital(result.getString("hospital_id"),result.getString("address"),result.getString("category"),result.getString("emergency_room"),result.getString("name"));
            
        }
        result.close();

        ps2.close();

        return hospital;
    }

    public abstract Connection makeConnection() throws SQLException;
}
