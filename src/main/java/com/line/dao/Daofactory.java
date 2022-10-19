package com.line.dao;

import com.line.connectionMaker.AwsConnectionMaker;
import com.line.connectionMaker.ConnectionMaker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//spring은 configuration에서 시작함
//
public class Daofactory {

    @Bean
    public hospitalDao hosDaoAws(){
//        ConnectionMaker connectionMaker = new AwsConnectionMaker();
//        hospitalDao hospitalDao = new hospitalDao(connectionMaker);
        //아래 한줄로 가능
        return new hospitalDao(new AwsConnectionMaker());
    }
    @Bean
    public hospitalDao hosDaoLocal(){
//        ConnectionMaker connectionMaker = new AwsConnectionMaker();
//        hospitalDao hospitalDao = new hospitalDao(connectionMaker);
        //안에 연결 객체만 바꾸면 됨
        return new hospitalDao(new AwsConnectionMaker());
    }
}
