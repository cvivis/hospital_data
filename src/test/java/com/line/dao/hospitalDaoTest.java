package com.line.dao;

import com.line.connectionMaker.Dbconnect;
import com.line.domain.Hospital;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class hospitalDaoTest {

    @Test
    void insertAndSelectId() throws SQLException {

        AWSUserDaolmpl hospital = new AWSUserDaolmpl();

        Hospital selectHospital = hospital.selectId("A1106309");
        Assertions.assertEquals("A1106309",selectHospital.getId());

    }
}