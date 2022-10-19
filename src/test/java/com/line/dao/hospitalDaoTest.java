package com.line.dao;

import com.line.connectionMaker.AwsConnectionMaker;
import com.line.connectionMaker.Dbconnect;
import com.line.domain.Hospital;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = Daofactory.class)
class hospitalDaoTest {

    @Autowired
    ApplicationContext context;
    @Test
    void insertAndSelectId() throws SQLException {

//        AWSUserDaolmpl hospital = new AWSUserDaolmpl();
//        hospitalDao hD = new Daofactory().hosDaoAws();
        hospitalDao hD = context.getBean("hosDaoAws", hospitalDao.class);

        Hospital hospital = new Hospital("A1101720","서울특별시 강남구 선릉로 669","C","2","강남영상의학과의원");
        hD.insert(hospital);

        Hospital selectHospital = hD.selectId("A1101720");
        Assertions.assertEquals("A1101720",selectHospital.getId());

        Assertions.assertEquals(1,hD.deleteAll());

        Assertions.assertEquals(0,hD.getCount());

    }
}