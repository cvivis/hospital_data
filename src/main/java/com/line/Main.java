package com.line;

import com.line.connectionMaker.Dbconnect;
import com.line.domain.Hospital;
import com.line.parser.HospitalParser;
import com.line.sqlMaker.SqlCreater;
import com.line.dao.hospitalDao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, SQLException {
        Dbconnect db = new Dbconnect();
        Connection conn = db.add();
        hospitalDao hD = new hospitalDao();

        LineReader<Hospital> HospitalReader = new LineReader<>(new HospitalParser());
        String filename = "/Users/admin/Downloads/result2.txt";
        List<Hospital> lines = HospitalReader.readAndParse(filename);
//        hD.insert(lines,conn);
        hD.selectId("A1106309",conn);
//        SqlCreater sqlCreater = new SqlCreater();
//        String sql = sqlCreater.sqlCreate(lines);
//        System.out.println(sql);
//        sqlCreater.filesave("insert.sql",sqlCreater.sqlCreate(lines));
    }
}
