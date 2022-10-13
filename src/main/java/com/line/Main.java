package com.line;

import com.line.domain.Hospital;
import com.line.parser.HospitalParser;
import com.line.sqlMaker.SqlCreater;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        LineReader<Hospital> HospitalReader = new LineReader<>(new HospitalParser());
        String filename = "/Users/admin/Downloads/result.txt";
        List<Hospital> lines = HospitalReader.readAndParse(filename);
        SqlCreater sqlCreater = new SqlCreater();
//        String sql = sqlCreater.sqlCreate(lines);
//        System.out.println(sql);
        sqlCreater.filesave("insert.sql",sqlCreater.sqlCreate(lines));
    }
}
