package com.line;

import com.line.domain.Hospital;
import com.line.parser.HospitalParser;
import com.line.parser.Parser;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LineReader<T> {

    Parser<T> parser;
    public LineReader (Parser<T> parser){
        this.parser = parser;
    }
    List<T> readAndParse(String filename) throws IOException {
        List<T> result = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String str = "";
        br.readLine();
        while((str = br.readLine()) != null){
//            System.out.println(str);
            result.add(parser.parse(str));
//            result.add((str);
        }
        return result;
    }
}
