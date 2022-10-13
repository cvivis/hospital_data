package com.line.parser;

import com.line.domain.Hospital;

public class HospitalParser implements Parser<Hospital> {

    @Override
    public Hospital parse(String str){
        str = str.replaceAll("\"","");
        String[] newStr = str.split(",");
        return new Hospital(newStr[0],newStr[1],newStr[2],newStr[6],newStr[10]);
    }
}
