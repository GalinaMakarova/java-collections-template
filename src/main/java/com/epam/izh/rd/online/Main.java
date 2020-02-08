package com.epam.izh.rd.online;

import com.epam.izh.rd.online.helper.Direction;
import com.epam.izh.rd.online.service.SimpleTextStatisticsAnalyzer;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        String text = "Hello, Hi, mother, father - good, cat, c!!";
        SimpleTextStatisticsAnalyzer service = new SimpleTextStatisticsAnalyzer();
        List<String> test = service.sortWordsByLength(text, Direction.ASC);
        System.out.println(test);
    }
}
