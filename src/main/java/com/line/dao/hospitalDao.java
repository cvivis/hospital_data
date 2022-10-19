package com.line.dao;

import com.line.connectionMaker.AwsConnectionMaker;
import com.line.connectionMaker.ConnectionMaker;
import com.line.connectionMaker.Dbconnect;
import com.line.domain.Hospital;

import java.sql.*;
import java.util.List;
import java.util.Map;

public class hospitalDao {

    private ConnectionMaker connectionMaker;

    public hospitalDao(ConnectionMaker connectionMaker){
        this.connectionMaker = connectionMaker;
    }

    public void insert(Hospital hospital) throws SQLException {

        Connection c = connectionMaker.makeConnection();;

        PreparedStatement ps = null;
//        for (Hospital hospital : hospitals) {
            ps = c.prepareStatement("INSERT INTO seoul_hospitals(hospital_id,address, district,category,emergency_room,name,subdivision) VALUES (?,?,?,?,?,?,?)");
            ps.setString(1, hospital.getId());
            ps.setString(2, hospital.getAddress());
            ps.setString(3, hospital.getDistrict());
            ps.setString(4, hospital.getCategory());
            ps.setString(5, Integer.toString(hospital.getEmergency_room()));
            ps.setString(6, hospital.getName());
            ps.setString(7, hospital.getSubdivision());
            ps.executeUpdate();
//        }



        ps.close();

        System.out.println("insert 완료");
        c.close();
    }

    public Hospital selectId(String hospital_id) throws SQLException {
        Connection conn = connectionMaker.makeConnection();;
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
    public Hospital selectAddress(String district) throws SQLException {
        Connection conn = connectionMaker.makeConnection();
        PreparedStatement ps = conn.prepareStatement("select * from seoul_hospitals where district = ?");
        ps.setString(1,district);
        ResultSet result = ps.executeQuery();
        Hospital hospital = null;
        while(result.next()){
//            System.out.println("hospital id: "+result.getString("hospital_id"));
//            System.out.println("name: "+result.getString("name"));
//            System.out.println("district: "+result.getString("district"));
//            System.out.println("--------------------------");
            hospital = new Hospital(result.getString("hospital_id"),result.getString("address"),result.getString("category"),result.getString("emergency_room"),result.getString("name"));
        }
        result.close();

        ps.close();
        return hospital;

    }
    public int deleteAll() throws SQLException {
        Connection conn = connectionMaker.makeConnection();
        PreparedStatement ps = conn.prepareStatement("DELETE FROM seoul_hospitals");
        int result = ps.executeUpdate();
        return result;
    }

    public int getCount() throws  SQLException{
        Connection conn = connectionMaker.makeConnection();
        PreparedStatement ps = conn.prepareStatement("select count(*) from seoul_hospitals");
        ResultSet result = ps.executeQuery();
        int count = 0;
        while(result.next()){
            count = Integer.parseInt(result.getString("count(*)"));
        }
        return count;
    }

}
