package userSpring.dao;




import userSpring.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

    private ConnectionMaker connectionMaker;

    public UserDao(ConnectionMaker connectionMaker){
        this.connectionMaker = connectionMaker;
    }

    public void insert(User user) throws SQLException {

        Connection c = connectionMaker.makeConnection();;

        PreparedStatement ps = null;
//        for (UserDao hospital : hospitals) {
            ps = c.prepareStatement("INSERT INTO users(id, name,password) VALUES (?,?,?)");
            ps.setString(1, user.getId());
            ps.setString(2, user.getName());
            ps.setString(3, user.getPassword());

            ps.executeUpdate();
//        }



        ps.close();

        System.out.println("insert 완료");
        c.close();
    }

    public User selectId(String id) throws SQLException {
        Connection conn = connectionMaker.makeConnection();;
        PreparedStatement ps2 = conn.prepareStatement("select * from users where id = ?");
        ps2.setString(1,id);
        ResultSet result = ps2.executeQuery();
        User user = null;

        while(result.next()){
            user = new User(result.getString("id"),result.getString("name"),result.getString("password"));
        }
        result.close();
        ps2.close();

        return user;

    }
//    public UserDao selectAddress(String district) throws SQLException {
//        Connection conn = connectionMaker.makeConnection();
//        PreparedStatement ps = conn.prepareStatement("select * from seoul_hospitals where district = ?");
//        ps.setString(1,district);
//        ResultSet result = ps.executeQuery();
//        User user = null;
//        while(result.next()){
////            System.out.println("hospital id: "+result.getString("hospital_id"));
////            System.out.println("name: "+result.getString("name"));
////            System.out.println("district: "+result.getString("district"));
////            System.out.println("--------------------------");
//            user = new User(result.getString("User_id"),result.getString("name"),result.getString("password"));
//        }
//        result.close();
//
//        ps.close();
//        return hospital;
//
//    }
    public int deleteAll() throws SQLException {
        Connection conn = connectionMaker.makeConnection();
        PreparedStatement ps = conn.prepareStatement("DELETE FROM User");
        int result = ps.executeUpdate();
        return result;
    }

    public int getCount() throws  SQLException{
        Connection conn = connectionMaker.makeConnection();
        PreparedStatement ps = conn.prepareStatement("select count(*) from User");
        ResultSet result = ps.executeQuery();
        int count = 0;
        while(result.next()){
            count = Integer.parseInt(result.getString("count(*)"));
        }
        return count;
    }


}
