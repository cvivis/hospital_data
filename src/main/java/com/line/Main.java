package com.line;

import com.line.connectionMaker.AwsConnectionMaker;
import com.line.connectionMaker.Dbconnect;
import com.line.dao.AWSUserDaolmpl;
import com.line.dao.Daofactory;
import com.line.domain.Hospital;
import com.line.parser.HospitalParser;
import com.line.sqlMaker.SqlCreater;
import com.line.dao.hospitalDao;
import com.line.dao.Daofactory;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import com.line.connectionMaker.Dbconnect;

public class Main {
    public static void main(String[] args) throws IOException, SQLException {


        hospitalDao hD = new Daofactory().hosDaoAws();
//        AWSUserDaolmpl hD = new AWSUserDaolmpl();

        LineReader<Hospital> HospitalReader = new LineReader<>(new HospitalParser());


        Hospital hospital = hD.selectId("A1106309");
        System.out.println(hospital.getId());
//        hD.selectAddress("서울특별시 강남구",c);

        //SQL 생성 파일
//        String filename = "/Users/admin/Downloads/result2.txt";
//        List<Hospital> lines = HospitalReader.readAndParse(filename);
//        SqlCreater sqlCreater = new SqlCreater();
//        String sql = sqlCreater.sqlCreate(lines);
//        System.out.println(sql);
//        sqlCreater.filesave("insert.sql",sqlCreater.sqlCreate(lines));
    }

}
