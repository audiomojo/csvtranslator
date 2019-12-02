package com.softwarecraftsmanship.csvtranslator.services;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CSVTranslatorService {
    public String translate(List<List<String>> parsedCSV) {
        StringBuilder builder = new StringBuilder();
        parsedCSV.forEach(row -> {
            row.forEach(element -> builder.append("["+ element +"] "));
            builder.deleteCharAt(builder.length()-1);
            builder.append("\n");
        });
        String result = builder.toString();
        return result.substring(0,result.length()-1);
    }
}
