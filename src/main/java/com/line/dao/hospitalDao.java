package com.line.dao;

import com.line.domain.Hospital;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class hospitalDao {



    public void insert(List<Hospital> hospitals, Connection conn) throws SQLException {

        PreparedStatement ps = null;
        for (Hospital hospital : hospitals) {
            ps = conn.prepareStatement("INSERT INTO seoul_hospitals(hospital_id,address, district,category,emergency_room,name,subdivision) VALUES (?,?,?,?,?,?,?)");
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
        conn.close();
    }

    public void selectId(String hospital_id,Connection conn) throws SQLException {
        PreparedStatement ps2 = conn.prepareStatement("select * from users where id = ?");
        ps2.setString(1,hospital_id);
        ResultSet result = ps2.executeQuery();

        while(result.next()){
            System.out.println("hospital id: "+result.getString("hospital_id"));
            System.out.println("name: "+result.getString("name"));
            System.out.println("password: "+result.getString("address"));
        }
        ps2.close();
        conn.close();
    }

}
