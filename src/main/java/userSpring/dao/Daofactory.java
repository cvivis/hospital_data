package userSpring.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class Daofactory {

    @Bean
    public UserDao awsUserDao(){
        return new UserDao(new AwsConnectionMaker());
    }
}
