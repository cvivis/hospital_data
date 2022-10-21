package userSpring.dao;




import org.springframework.dao.EmptyResultDataAccessException;
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
        try{
            Connection conn = connectionMaker.makeConnection();;
            PreparedStatement ps2 = conn.prepareStatement("select * from users where id = ?");
            ps2.setString(1,id);
            ResultSet result = ps2.executeQuery();
            User user = null;

            if(result.next()){
                user = new User(result.getString("id"),result.getString("name"),result.getString("password"));
            }
            result.close();
            ps2.close();
            if(user == null){
                throw new EmptyResultDataAccessException(1);
            }


            return user;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }

    }
    public int deleteAll() throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = connectionMaker.makeConnection();
            ps = new DeleteAllStrategy().makePreparedStatement(conn);
            int result = ps.executeUpdate();
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            if(ps != null){
                try {
                    ps.close();
                } catch (SQLException e) {
                }
            }
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                }
            }
        }


    }

    public int getCount() throws  SQLException{
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = connectionMaker.makeConnection();
            ps = conn.prepareStatement("select count(*) from users");
            ResultSet result = ps.executeQuery();
            int count = 0;
            if(result.next()){
                count = Integer.parseInt(result.getString("count(*)"));
            }
            return count;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            if(ps != null){
                try {
                    ps.close();
                } catch (SQLException e) {
                }
            }
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                }
            }
        }
    }


}
