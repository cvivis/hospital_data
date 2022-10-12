package com.line;

import com.line.domain.Hospital;
import com.line.parser.HospitalParser;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        LineReader<Hospital> HospitalReader = new LineReader<>(new HospitalParser());
        String filename = "/Users/admin/Downloads/서울시 병의원 위치 정보.csv";
        List<Hospital> lines = HospitalReader.readAndParse(filename);
        for(Hospital h : lines){
            System.out.println(h.getId());
        }
    }
}
