package com.line.sqlMaker;

import com.line.domain.Hospital;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class SqlCreater {

    public String sqlCreate(List<Hospital> lines){
        String query ="";
//        Hospital h = lines.get(0);
        for(Hospital h : lines){
         query = query + "INSERT INTO `likelion`.`seoul_hospital` " +
                "(`hospital_id`,`address`,`district`,`category`,`emergency_room`,`name`,`subdivision`) "+
                "VALUES ('" + h.getId() + "','" + h.getAddress() + "','" + h.getDistrict() + "','" + h.getCategory()+"',"+
            h.getEmergency_room() +",'" +h.getName() + "','" + h.getSubdivision() + "');\n";

        }
        return query;
    }

    public void filesave(String filename, String body) {
        File file = new File(filename);
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(body);
            writer.close();
            System.out.println("파일 저장 완료!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
