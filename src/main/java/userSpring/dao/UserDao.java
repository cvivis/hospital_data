package userSpring.dao;


import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.jdbc.Sql;
import userSpring.model.User;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDao {

//    private ConnectionMaker dataSource;
//
//    public UserDao(ConnectionMaker dataSource) {
//        this.dataSource = dataSource;
//    }
    private final DataSource dataSource;
//    private final JdbcContext jdbcContext;
    private JdbcTemplate jdbcTemplate;
    public UserDao(DataSource dataSource){
        this.dataSource = dataSource;
//        this.jdbcContext = new JdbcContext(dataSource);
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


//    public int jdbcContextWithStatementStrategy(StatementStrategy stmt) throws SQLException {
//        Connection conn = null;
//        PreparedStatement ps = null;
//        try {
//            conn = dataSource.getConnection();
//            ps = stmt.makePreparedStatement(conn);
//            int result = ps.executeUpdate();
//            return result;
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        } finally {
//            if (ps != null) {
//                try {
//                    ps.close();
//                } catch (SQLException e) {
//                }
//            }
//            if (conn != null) {
//                try {
//                    conn.close();
//                } catch (SQLException e) {
//                }
//            }
//        }
//    }
    public List<User> getAll() throws SQLException{
        RowMapper<User> rowMapper = new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User user = new User(rs.getString("id"), rs.getString("name"),
                        rs.getString("password"));
                return user;
            }
        };

        return this.jdbcTemplate.query("select * from users",rowMapper);
    }

    public void insert(User user) throws SQLException {
//        jdbcContextWithStatementStrategy(new InsertStrategy(user));
//        System.out.println("insert 완료");
//        jdbcContext.jdbcContextWithStatementStrategy(new StatementStrategy() {
//            @Override
//            public PreparedStatement makePreparedStatement(Connection connection) throws SQLException {
//                PreparedStatement ps =  connection.prepareStatement("INSERT INTO users(id, name,password) VALUES (?,?,?)");
//                ps.setString(1, user.getId());
//                ps.setString(2, user.getName());
//                ps.setString(3, user.getPassword());
//                return ps;
//            }
//        });
            this.jdbcTemplate.update("INSERT INTO users(id, name,password) VALUES (?,?,?)",user.getId(),user.getName(),user.getPassword());
    }

    public User selectId(String id) throws SQLException {
        RowMapper<User> rowMapper = new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User user = new User(rs.getString("id"),rs.getString("name"),rs.getString("password"));
                return user;
            }
        };
        return this.jdbcTemplate.queryForObject("select * from users where id = ?",rowMapper,id);
//        try {
//            Connection conn = dataSource.getConnection();
//            ;
//            PreparedStatement ps2 = conn.prepareStatement("select * from users where id = ?");
//            ps2.setString(1, id);
//            ResultSet result = ps2.executeQuery();
//            User user = null;
//
//            if (result.next()) {
//                user = new User(result.getString("id"), result.getString("name"), result.getString("password"));
//            }
//            result.close();
//            ps2.close();
//            if (user == null) {
//                throw new EmptyResultDataAccessException(1);
//            }
//
//
//            return user;
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }

    }

//    public void executeSql(String sql) throws SQLException{
//        this.jdbcContext.jdbcContextWithStatementStrategy(new StatementStrategy() {
//            @Override
//            public PreparedStatement makePreparedStatement(Connection connection) throws SQLException {
//                return connection.prepareStatement(sql);
//            }
//        });
//    }
    public void deleteAll() throws SQLException {
//        Connection conn = null;
//        PreparedStatement ps = null;
//        int result = jdbcContextWithStatementStrategy(new DeleteAllStrategy());
//        return result;
        String sql = "DELETE FROM users";
//        this.jdbcContext.executeSql(sql);
        this.jdbcTemplate.update(sql);
    }

    public int getCount() throws SQLException {
//        Connection conn = null;
//        PreparedStatement ps = null;
//
//        try {
//            conn = dataSource.getConnection();
//            ps = conn.prepareStatement("select count(*) from users");
//            ResultSet result = ps.executeQuery();
//            int count = 0;
//            if (result.next()) {
//                count = Integer.parseInt(result.getString("count(*)"));
//            }
//            return count;
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        } finally {
//            if (ps != null) {
//                try {
//                    ps.close();
//                } catch (SQLException e) {
//                }
//            }
//            if (conn != null) {
//                try {
//                    conn.close();
//                } catch (SQLException e) {
//                }
//            }
//        }
        return this.jdbcTemplate.queryForObject("select count(*) from users",Integer.class);
    }


}
