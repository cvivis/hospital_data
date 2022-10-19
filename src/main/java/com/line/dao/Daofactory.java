package com.line.dao;

import com.line.connectionMaker.AwsConnectionMaker;
import com.line.connectionMaker.ConnectionMaker;

public class Daofactory {

    public hospitalDao hosDaoAws(){
//        ConnectionMaker connectionMaker = new AwsConnectionMaker();
//        hospitalDao hospitalDao = new hospitalDao(connectionMaker);
        //아래 한줄로 가능
        return new hospitalDao(new AwsConnectionMaker());
    }
    public hospitalDao hosDaoLocal(){
//        ConnectionMaker connectionMaker = new AwsConnectionMaker();
//        hospitalDao hospitalDao = new hospitalDao(connectionMaker);
        //안에 연결 객체만 바꾸면 됨
        return new hospitalDao(new AwsConnectionMaker());
    }
}
