package userSpring.dao;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import userSpring.model.User;

import java.sql.SQLException;
import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = Daofactory.class)
class UserDaoTest {
    @Autowired
    ApplicationContext context;
    UserDao userdao;

    @BeforeEach
    void setUp(){
        System.out.println("before");
        this.userdao = context.getBean("awsUserDao", UserDao.class);
    }

    @Test
    @DisplayName("데이터 추가 및 읽기 테스트")
    void addAndGet() throws SQLException, ClassNotFoundException {

        User user1 = new User("1", "홍홍홍", "1234");

        userdao.insert(user1);

        User user2 = userdao.selectId(user1.getId());
        assertEquals(user1.getId(), user2.getId());
        assertEquals(user1.getName(), user2.getName());
        assertEquals(user1.getPassword(), user2.getPassword());

        assertEquals(1,userdao.getCount());
        assertEquals(1,userdao.deleteAll());
    }
    @Test
    void findById(){
        assertThrows(EmptyResultDataAccessException.class,()->{
            userdao.selectId("30");
        });
    }
}